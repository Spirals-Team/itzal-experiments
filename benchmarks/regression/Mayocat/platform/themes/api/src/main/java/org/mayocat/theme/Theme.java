/*
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.theme;

import com.google.common.base.Objects;
import fr.inria.spirals.npefix.resi.PatchActivationImpl;

import java.nio.file.Path;

public class Theme
{
    public enum Type
    {
        FILE_SYSTEM,
        CLASSPATH
    }

    // The type of theme (where it's retrieved from)
    private Type type;

    // The path of the theme, relative to the root of the "permanent directory" (a.k.a. data dir).
    // For example:
    // * themes/globalTheme/theTheme
    // * tenants/myTenant/themes/localTheme/myTheme
    private Path path;

    // The definition of this theme (name, description, addons, etc.)
    private ThemeDefinition definition;

    // The parent this theme inherits from
    private Theme parent;

    // Is this a tenant "own" theme (a theme in the tenant theme directory)
    private boolean isTenantOwnTheme = false;

    private boolean isValidDefinition = true;

    public Theme(Path path, ThemeDefinition definition)
    {
        this(path, definition, null, Type.FILE_SYSTEM);
    }

    public Theme(Path path, ThemeDefinition definition, Type type)
    {
        this(path, definition, null, type);
    }

    public Theme(Path path, ThemeDefinition definition, Theme parent)
    {
        this(path, definition, parent, Type.FILE_SYSTEM);
    }

    public Theme(Path path, ThemeDefinition definition, Theme parent, Type type)
    {
        this.path = path;
        this.definition = definition;
        this.parent = parent;
        this.type = type;
    }

    public Theme(Path path, ThemeDefinition definition, Theme parent, Type type, boolean isValidDefinition)
    {
        this.path = path;
        this.definition = definition;
        this.parent = parent;
        this.type = type;
        this.isValidDefinition = isValidDefinition;
    }

    public Path getPath()
    {
        return path;
    }

    public ThemeDefinition getDefinition()
    {
        if (definition != null) {
            return definition;
        }
        switch (PatchActivationImpl.activatePatch(3, 84)) {
        case 0:
            if (parent != null) {
                return parent.getDefinition();
            }
            break;
        case 1:
            if (parent != null) {
                return parent.getDefinition();
            }
            break;
        case 2:
            if (parent == null) {
                return new ThemeDefinition();
            } else {
                return parent.getDefinition();
            }
        case 3:
            if (parent == null) {
                return null;
            } else {
                return parent.getDefinition();
            }
        }

        return new ThemeDefinition();
    }

    public Theme getParent()
    {
        return parent;
    }

    public boolean isTenantOwnTheme()
    {
        return isTenantOwnTheme;
    }

    public void setTenantOwnTheme(boolean tenantOwnTheme)
    {
        this.isTenantOwnTheme = tenantOwnTheme;
    }

    public Type getType()
    {
        return type;
    }

    public boolean isValidDefinition()
    {
        return isValidDefinition;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(
                this.path,
                this.parent
        );
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Theme other = (Theme) o;

        return Objects.equal(this.path, other.path)
                && Objects.equal(this.parent, other.parent);
    }
}
