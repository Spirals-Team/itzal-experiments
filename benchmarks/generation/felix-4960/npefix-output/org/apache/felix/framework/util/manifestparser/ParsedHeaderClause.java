package org.apache.felix.framework.util.manifestparser;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import java.util.List;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ParsedHeaderClause {
    public final List<String> m_paths;

    public final Map<String, String> m_dirs;

    public final Map<String, Object> m_attrs;

    public final Map<String, String> m_types;

    public ParsedHeaderClause(List<String> paths, Map<String, String> dirs, Map<String, Object> attrs, Map<String, String> types) {
        MethodContext _bcornu_methode_context51 = new MethodContext(null);
        try {
            m_paths = paths;
            CallChecker.varAssign(this.m_paths, "this.m_paths", 35, 1283, 1298);
            m_dirs = dirs;
            CallChecker.varAssign(this.m_dirs, "this.m_dirs", 36, 1308, 1321);
            m_attrs = attrs;
            CallChecker.varAssign(this.m_attrs, "this.m_attrs", 37, 1331, 1346);
            m_types = types;
            CallChecker.varAssign(this.m_types, "this.m_types", 38, 1356, 1371);
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }
}

