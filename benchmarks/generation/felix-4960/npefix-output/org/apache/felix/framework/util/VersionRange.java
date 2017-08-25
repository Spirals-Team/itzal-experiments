package org.apache.felix.framework.util;

import org.osgi.framework.Version;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class VersionRange {
    private final Version m_floor;

    private final boolean m_isFloorInclusive;

    private final Version m_ceiling;

    private final boolean m_isCeilingInclusive;

    public static final VersionRange infiniteRange = new VersionRange(Version.emptyVersion, true, null, true);

    public VersionRange(Version low, boolean isLowInclusive, Version high, boolean isHighInclusive) {
        MethodContext _bcornu_methode_context173 = new MethodContext(null);
        try {
            m_floor = low;
            CallChecker.varAssign(this.m_floor, "this.m_floor", 36, 1332, 1345);
            m_isFloorInclusive = isLowInclusive;
            CallChecker.varAssign(this.m_isFloorInclusive, "this.m_isFloorInclusive", 37, 1355, 1390);
            m_ceiling = high;
            CallChecker.varAssign(this.m_ceiling, "this.m_ceiling", 38, 1400, 1416);
            m_isCeilingInclusive = isHighInclusive;
            CallChecker.varAssign(this.m_isCeilingInclusive, "this.m_isCeilingInclusive", 39, 1426, 1464);
        } finally {
            _bcornu_methode_context173.methodEnd();
        }
    }

    public Version getFloor() {
        MethodContext _bcornu_methode_context1747 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(this, "this", 42, 1477, 1537);
            CallChecker.varInit(infiniteRange, "org.apache.felix.framework.util.VersionRange.infiniteRange", 42, 1477, 1537);
            CallChecker.varInit(this.m_isCeilingInclusive, "m_isCeilingInclusive", 42, 1477, 1537);
            CallChecker.varInit(this.m_ceiling, "m_ceiling", 42, 1477, 1537);
            CallChecker.varInit(this.m_isFloorInclusive, "m_isFloorInclusive", 42, 1477, 1537);
            CallChecker.varInit(this.m_floor, "m_floor", 42, 1477, 1537);
            return m_floor;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1747.methodEnd();
        }
    }

    public boolean isFloorInclusive() {
        MethodContext _bcornu_methode_context1748 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 47, 1544, 1623);
            CallChecker.varInit(infiniteRange, "org.apache.felix.framework.util.VersionRange.infiniteRange", 47, 1544, 1623);
            CallChecker.varInit(this.m_isCeilingInclusive, "m_isCeilingInclusive", 47, 1544, 1623);
            CallChecker.varInit(this.m_ceiling, "m_ceiling", 47, 1544, 1623);
            CallChecker.varInit(this.m_isFloorInclusive, "m_isFloorInclusive", 47, 1544, 1623);
            CallChecker.varInit(this.m_floor, "m_floor", 47, 1544, 1623);
            return m_isFloorInclusive;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1748.methodEnd();
        }
    }

    public Version getCeiling() {
        MethodContext _bcornu_methode_context1749 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(this, "this", 52, 1630, 1694);
            CallChecker.varInit(infiniteRange, "org.apache.felix.framework.util.VersionRange.infiniteRange", 52, 1630, 1694);
            CallChecker.varInit(this.m_isCeilingInclusive, "m_isCeilingInclusive", 52, 1630, 1694);
            CallChecker.varInit(this.m_ceiling, "m_ceiling", 52, 1630, 1694);
            CallChecker.varInit(this.m_isFloorInclusive, "m_isFloorInclusive", 52, 1630, 1694);
            CallChecker.varInit(this.m_floor, "m_floor", 52, 1630, 1694);
            return m_ceiling;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1749.methodEnd();
        }
    }

    public boolean isCeilingInclusive() {
        MethodContext _bcornu_methode_context1750 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 57, 1701, 1784);
            CallChecker.varInit(infiniteRange, "org.apache.felix.framework.util.VersionRange.infiniteRange", 57, 1701, 1784);
            CallChecker.varInit(this.m_isCeilingInclusive, "m_isCeilingInclusive", 57, 1701, 1784);
            CallChecker.varInit(this.m_ceiling, "m_ceiling", 57, 1701, 1784);
            CallChecker.varInit(this.m_isFloorInclusive, "m_isFloorInclusive", 57, 1701, 1784);
            CallChecker.varInit(this.m_floor, "m_floor", 57, 1701, 1784);
            return m_isCeilingInclusive;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1750.methodEnd();
        }
    }

    public boolean isInRange(Version version) {
        MethodContext _bcornu_methode_context1751 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 62, 1791, 2565);
            CallChecker.varInit(version, "version", 62, 1791, 2565);
            CallChecker.varInit(infiniteRange, "org.apache.felix.framework.util.VersionRange.infiniteRange", 62, 1791, 2565);
            CallChecker.varInit(this.m_isCeilingInclusive, "m_isCeilingInclusive", 62, 1791, 2565);
            CallChecker.varInit(this.m_ceiling, "m_ceiling", 62, 1791, 2565);
            CallChecker.varInit(this.m_isFloorInclusive, "m_isFloorInclusive", 62, 1791, 2565);
            CallChecker.varInit(this.m_floor, "m_floor", 62, 1791, 2565);
            if ((m_ceiling) == null) {
                version = CallChecker.beforeCalled(version, Version.class, 67, 1956, 1962);
                return (CallChecker.isCalled(version, Version.class, 67, 1956, 1962).compareTo(m_floor)) >= 0;
            }else
                if ((isFloorInclusive()) && (isCeilingInclusive())) {
                    version = CallChecker.beforeCalled(version, Version.class, 71, 2091, 2097);
                    version = CallChecker.beforeCalled(version, Version.class, 71, 2128, 2134);
                    return ((CallChecker.isCalled(version, Version.class, 71, 2091, 2097).compareTo(m_floor)) >= 0) && ((CallChecker.isCalled(version, Version.class, 71, 2128, 2134).compareTo(m_ceiling)) <= 0);
                }else
                    if (isCeilingInclusive()) {
                        version = CallChecker.beforeCalled(version, Version.class, 75, 2243, 2249);
                        version = CallChecker.beforeCalled(version, Version.class, 75, 2279, 2285);
                        return ((CallChecker.isCalled(version, Version.class, 75, 2243, 2249).compareTo(m_floor)) > 0) && ((CallChecker.isCalled(version, Version.class, 75, 2279, 2285).compareTo(m_ceiling)) <= 0);
                    }else
                        if (isFloorInclusive()) {
                            version = CallChecker.beforeCalled(version, Version.class, 79, 2392, 2398);
                            version = CallChecker.beforeCalled(version, Version.class, 79, 2429, 2435);
                            return ((CallChecker.isCalled(version, Version.class, 79, 2392, 2398).compareTo(m_floor)) >= 0) && ((CallChecker.isCalled(version, Version.class, 79, 2429, 2435).compareTo(m_ceiling)) < 0);
                        }
                    
                
            
            version = CallChecker.beforeCalled(version, Version.class, 81, 2490, 2496);
            version = CallChecker.beforeCalled(version, Version.class, 81, 2526, 2532);
            return ((CallChecker.isCalled(version, Version.class, 81, 2490, 2496).compareTo(m_floor)) > 0) && ((CallChecker.isCalled(version, Version.class, 81, 2526, 2532).compareTo(m_ceiling)) < 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1751.methodEnd();
        }
    }

    public static VersionRange parse(String range) {
        MethodContext _bcornu_methode_context1752 = new MethodContext(VersionRange.class);
        try {
            CallChecker.varInit(range, "range", 84, 2572, 3223);
            CallChecker.varInit(infiniteRange, "org.apache.felix.framework.util.VersionRange.infiniteRange", 84, 2572, 3223);
            if (CallChecker.beforeDeref(range, String.class, 87, 2685, 2689)) {
                range = CallChecker.beforeCalled(range, String.class, 87, 2685, 2689);
                if ((CallChecker.isCalled(range, String.class, 87, 2685, 2689).indexOf(',')) >= 0) {
                    String s = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(range, String.class, 89, 2762, 2766)) {
                        if (CallChecker.beforeDeref(range, String.class, 89, 2743, 2747)) {
                            range = CallChecker.beforeCalled(range, String.class, 89, 2762, 2766);
                            range = CallChecker.beforeCalled(range, String.class, 89, 2743, 2747);
                            s = CallChecker.isCalled(range, String.class, 89, 2743, 2747).substring(1, ((CallChecker.isCalled(range, String.class, 89, 2762, 2766).length()) - 1));
                            CallChecker.varAssign(s, "s", 89, 2762, 2766);
                        }
                    }
                    String vlo = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(s, String.class, 90, 2823, 2823)) {
                        if (CallChecker.beforeDeref(s, String.class, 90, 2808, 2808)) {
                            s = CallChecker.beforeCalled(s, String.class, 90, 2823, 2823);
                            s = CallChecker.beforeCalled(s, String.class, 90, 2808, 2808);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(s, String.class, 90, 2808, 2808).substring(0, CallChecker.isCalled(s, String.class, 90, 2823, 2823).indexOf(',')), String.class, 90, 2808, 2837)) {
                                s = CallChecker.beforeCalled(s, String.class, 90, 2823, 2823);
                                s = CallChecker.beforeCalled(s, String.class, 90, 2808, 2808);
                                vlo = CallChecker.isCalled(CallChecker.isCalled(s, String.class, 90, 2808, 2808).substring(0, CallChecker.isCalled(s, String.class, 90, 2823, 2823).indexOf(',')), String.class, 90, 2808, 2837).trim();
                                CallChecker.varAssign(vlo, "vlo", 90, 2823, 2823);
                            }
                        }
                    }
                    String vhi = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(s, String.class, 91, 2884, 2884)) {
                        if (CallChecker.beforeDeref(s, String.class, 91, 2904, 2904)) {
                            if (CallChecker.beforeDeref(s, String.class, 91, 2872, 2872)) {
                                s = CallChecker.beforeCalled(s, String.class, 91, 2884, 2884);
                                s = CallChecker.beforeCalled(s, String.class, 91, 2904, 2904);
                                s = CallChecker.beforeCalled(s, String.class, 91, 2872, 2872);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(s, String.class, 91, 2872, 2872).substring(((CallChecker.isCalled(s, String.class, 91, 2884, 2884).indexOf(',')) + 1), CallChecker.isCalled(s, String.class, 91, 2904, 2904).length()), String.class, 91, 2872, 2914)) {
                                    s = CallChecker.beforeCalled(s, String.class, 91, 2884, 2884);
                                    s = CallChecker.beforeCalled(s, String.class, 91, 2904, 2904);
                                    s = CallChecker.beforeCalled(s, String.class, 91, 2872, 2872);
                                    vhi = CallChecker.isCalled(CallChecker.isCalled(s, String.class, 91, 2872, 2872).substring(((CallChecker.isCalled(s, String.class, 91, 2884, 2884).indexOf(',')) + 1), CallChecker.isCalled(s, String.class, 91, 2904, 2904).length()), String.class, 91, 2872, 2914).trim();
                                    CallChecker.varAssign(vhi, "vhi", 91, 2884, 2884);
                                }
                            }
                        }
                    }
                    range = CallChecker.beforeCalled(range, String.class, 93, 2997, 3001);
                    range = CallChecker.beforeCalled(range, String.class, 94, 3070, 3074);
                    range = CallChecker.beforeCalled(range, String.class, 94, 3057, 3061);
                    return new VersionRange(new Version(vlo), ((CallChecker.isCalled(range, String.class, 93, 2997, 3001).charAt(0)) == '['), new Version(vhi), ((CallChecker.isCalled(range, String.class, 94, 3057, 3061).charAt(((CallChecker.isCalled(range, String.class, 94, 3070, 3074).length()) - 1))) == ']'));
                }else {
                    return new VersionRange(new Version(range), true, null, false);
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((VersionRange) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1752.methodEnd();
        }
    }

    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1753 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 102, 3230, 4013);
            CallChecker.varInit(obj, "obj", 102, 3230, 4013);
            CallChecker.varInit(infiniteRange, "org.apache.felix.framework.util.VersionRange.infiniteRange", 102, 3230, 4013);
            CallChecker.varInit(this.m_isCeilingInclusive, "m_isCeilingInclusive", 102, 3230, 4013);
            CallChecker.varInit(this.m_ceiling, "m_ceiling", 102, 3230, 4013);
            CallChecker.varInit(this.m_isFloorInclusive, "m_isFloorInclusive", 102, 3230, 4013);
            CallChecker.varInit(this.m_floor, "m_floor", 102, 3230, 4013);
            if (obj == null) {
                return false;
            }
            if ((getClass()) != (obj.getClass())) {
                return false;
            }
            final VersionRange other = CallChecker.varInit(((VersionRange) (obj)), "other", 112, 3437, 3482);
            if (CallChecker.beforeDeref(other, VersionRange.class, 113, 3507, 3511)) {
                if (CallChecker.beforeDeref(other, VersionRange.class, 113, 3560, 3564)) {
                    if (((m_floor) != (CallChecker.isCalled(other, VersionRange.class, 113, 3507, 3511).m_floor)) && (((m_floor) == null) || (!(m_floor.equals(CallChecker.isCalled(other, VersionRange.class, 113, 3560, 3564).m_floor))))) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(other, VersionRange.class, 117, 3657, 3661)) {
                if ((m_isFloorInclusive) != (CallChecker.isCalled(other, VersionRange.class, 117, 3657, 3661).m_isFloorInclusive)) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(other, VersionRange.class, 121, 3754, 3758)) {
                if (CallChecker.beforeDeref(other, VersionRange.class, 121, 3813, 3817)) {
                    if (((m_ceiling) != (CallChecker.isCalled(other, VersionRange.class, 121, 3754, 3758).m_ceiling)) && (((m_ceiling) == null) || (!(m_ceiling.equals(CallChecker.isCalled(other, VersionRange.class, 121, 3813, 3817).m_ceiling))))) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(other, VersionRange.class, 125, 3914, 3918)) {
                if ((m_isCeilingInclusive) != (CallChecker.isCalled(other, VersionRange.class, 125, 3914, 3918).m_isCeilingInclusive)) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1753.methodEnd();
        }
    }

    public int hashCode() {
        MethodContext _bcornu_methode_context1754 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 132, 4020, 4357);
            CallChecker.varInit(infiniteRange, "org.apache.felix.framework.util.VersionRange.infiniteRange", 132, 4020, 4357);
            CallChecker.varInit(this.m_isCeilingInclusive, "m_isCeilingInclusive", 132, 4020, 4357);
            CallChecker.varInit(this.m_ceiling, "m_ceiling", 132, 4020, 4357);
            CallChecker.varInit(this.m_isFloorInclusive, "m_isFloorInclusive", 132, 4020, 4357);
            CallChecker.varInit(this.m_floor, "m_floor", 132, 4020, 4357);
            int hash = CallChecker.varInit(((int) (5)), "hash", 134, 4056, 4068);
            if ((m_floor) != null) {
                hash = (97 * hash) + (m_floor.hashCode());
                CallChecker.varAssign(hash, "hash", 135, 4078, 4139);
            }else {
                hash = (97 * hash) + 0;
                CallChecker.varAssign(hash, "hash", 135, 4078, 4139);
            }
            if (m_isFloorInclusive) {
                hash = (97 * hash) + 1;
                CallChecker.varAssign(hash, "hash", 136, 4149, 4196);
            }else {
                hash = (97 * hash) + 0;
                CallChecker.varAssign(hash, "hash", 136, 4149, 4196);
            }
            if ((m_ceiling) != null) {
                hash = (97 * hash) + (m_ceiling.hashCode());
                CallChecker.varAssign(hash, "hash", 137, 4206, 4271);
            }else {
                hash = (97 * hash) + 0;
                CallChecker.varAssign(hash, "hash", 137, 4206, 4271);
            }
            if (m_isCeilingInclusive) {
                hash = (97 * hash) + 1;
                CallChecker.varAssign(hash, "hash", 138, 4281, 4330);
            }else {
                hash = (97 * hash) + 0;
                CallChecker.varAssign(hash, "hash", 138, 4281, 4330);
            }
            return hash;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1754.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context1755 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 142, 4364, 4834);
            CallChecker.varInit(infiniteRange, "org.apache.felix.framework.util.VersionRange.infiniteRange", 142, 4364, 4834);
            CallChecker.varInit(this.m_isCeilingInclusive, "m_isCeilingInclusive", 142, 4364, 4834);
            CallChecker.varInit(this.m_ceiling, "m_ceiling", 142, 4364, 4834);
            CallChecker.varInit(this.m_isFloorInclusive, "m_isFloorInclusive", 142, 4364, 4834);
            CallChecker.varInit(this.m_floor, "m_floor", 142, 4364, 4834);
            if ((m_ceiling) != null) {
                StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 146, 4448, 4484);
                if (m_isFloorInclusive) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 147, 4498, 4499)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 147, 4498, 4499);
                        CallChecker.isCalled(sb, StringBuffer.class, 147, 4498, 4499).append('[');
                    }
                }else {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 147, 4498, 4499)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 147, 4498, 4499);
                        CallChecker.isCalled(sb, StringBuffer.class, 147, 4498, 4499).append('(');
                    }
                }
                if (CallChecker.beforeDeref(m_floor, Version.class, 148, 4563, 4569)) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 148, 4553, 4554)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 148, 4553, 4554);
                        CallChecker.isCalled(sb, StringBuffer.class, 148, 4553, 4554).append(CallChecker.isCalled(m_floor, Version.class, 148, 4563, 4569).toString());
                    }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 149, 4596, 4597)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 149, 4596, 4597);
                    CallChecker.isCalled(sb, StringBuffer.class, 149, 4596, 4597).append(',');
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 150, 4624, 4625)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 150, 4624, 4625);
                    CallChecker.isCalled(sb, StringBuffer.class, 150, 4624, 4625).append(m_ceiling.toString());
                }
                if (m_isCeilingInclusive) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 151, 4669, 4670)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 151, 4669, 4670);
                        CallChecker.isCalled(sb, StringBuffer.class, 151, 4669, 4670).append(']');
                    }
                }else {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 151, 4669, 4670)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 151, 4669, 4670);
                        CallChecker.isCalled(sb, StringBuffer.class, 151, 4669, 4670).append(')');
                    }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 152, 4733, 4734)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 152, 4733, 4734);
                    return CallChecker.isCalled(sb, StringBuffer.class, 152, 4733, 4734).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                if (CallChecker.beforeDeref(m_floor, Version.class, 156, 4800, 4806)) {
                    return CallChecker.isCalled(m_floor, Version.class, 156, 4800, 4806).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1755.methodEnd();
        }
    }
}

