/*
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.store.rdbms.dbi.argument;

import fr.inria.spirals.npefix.resi.PatchActivationImpl;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;
import org.skife.jdbi.v2.tweak.ArgumentFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Argument factory that binds java.util.Date as timestamp.
 *
 * See https://groups.google.com/d/msg/jdbi/ooFw_s183jM/WLwNBJuemYEJ
 *
 * @version $Id$
 */
public class DateAsTimestampArgumentFactory implements ArgumentFactory<Date>
{
    @Override
    public boolean accepts(Class<?> expectedType, Object value, StatementContext ctx)
    {
        switch (PatchActivationImpl.activatePatch(5, 30)) {
        case 0:
            if (value == null) {
                return false;
            }
            break;
        case 1:
            if (value == null) {
                return false;
            }
            break;
        case 2:
            if (value == null) {
                return true;
            }
            break;
        case 3:
            if (value == null) {
                return java.util.Date.class.isAssignableFrom(Object.class);
            }
            break;
        case 4:
            if (value == null) {
                return java.util.Date.class.isAssignableFrom(expectedType.getClass());
            }
            break;
        case 5:
            if (value == null) {
                return java.util.Date.class.isAssignableFrom(ctx.getClass());
            }
            break;
        }
        return java.util.Date.class.isAssignableFrom(value.getClass());
    }

    @Override
    public Argument build(Class<?> expectedType, final Date value, StatementContext ctx)
    {
        return new Argument()
        {
            @Override
            public void apply(int position, PreparedStatement statement, StatementContext ctx) throws SQLException
            {
                statement.setTimestamp(position, new java.sql.Timestamp(value.getTime()));
            }
        };
    }
}
