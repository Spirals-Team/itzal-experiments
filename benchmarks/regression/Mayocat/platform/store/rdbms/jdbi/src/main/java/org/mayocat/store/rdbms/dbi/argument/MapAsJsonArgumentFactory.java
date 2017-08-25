/*
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.store.rdbms.dbi.argument;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.inria.spirals.npefix.resi.PatchActivationImpl;
import org.postgresql.util.PGobject;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;
import org.skife.jdbi.v2.tweak.ArgumentFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * @version $Id$
 */
public class MapAsJsonArgumentFactory implements ArgumentFactory<Map>
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
                value = expectedType;
            }
            break;
        case 4:
            if (value == null) {
                value = ctx;
            }
            break;
        case 5:
            if (value == null) {
                value = new Object();
            }
            break;
        }
        return Map.class.isAssignableFrom(value.getClass());
    }

    @Override
    public Argument build(Class<?> expectedType, final Map value, StatementContext ctx)
    {
        try {
            final PGobject jsonObject = new PGobject();
            final ObjectMapper mapper = new ObjectMapper();

            jsonObject.setType("json");
            jsonObject.setValue(mapper.writeValueAsString(value));

            return new Argument()
            {
                @Override
                public void apply(int position, PreparedStatement statement, StatementContext ctx) throws SQLException
                {
                    statement.setObject(position, jsonObject);
                }
            };
        } catch (JsonProcessingException | SQLException e) {
            throw new RuntimeException("Failed to convert map argument to JSON", e);
        }
    }
}
