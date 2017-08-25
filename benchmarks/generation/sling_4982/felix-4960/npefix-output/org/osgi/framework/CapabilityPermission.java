package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.Set;
import java.security.PrivilegedAction;
import java.security.PermissionCollection;
import java.util.HashSet;
import java.util.HashMap;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collections;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.security.BasicPermission;
import java.security.AccessController;
import java.util.AbstractMap;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.io.IOException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Permission;

public final class CapabilityPermission extends BasicPermission {
    static final long serialVersionUID = -7662148639076511574L;

    public static final String REQUIRE = "require";

    public static final String PROVIDE = "provide";

    private static final int ACTION_REQUIRE = 1;

    private static final int ACTION_PROVIDE = 2;

    private static final int ACTION_ALL = (CapabilityPermission.ACTION_REQUIRE) | (CapabilityPermission.ACTION_PROVIDE);

    static final int ACTION_NONE = 0;

    transient int action_mask;

    private volatile String actions = null;

    final transient Map<String, Object> attributes;

    final transient Bundle bundle;

    transient Filter filter;

    private transient volatile Map<String, Object> properties;

    public CapabilityPermission(String name, String actions) {
        this(name, CapabilityPermission.parseActions(actions));
        MethodContext _bcornu_methode_context151 = new MethodContext(null);
        try {
            if (((this.filter) != null) && (((action_mask) & (CapabilityPermission.ACTION_ALL)) != (CapabilityPermission.ACTION_REQUIRE))) {
                throw new IllegalArgumentException("invalid action string for filter expression");
            }
        } finally {
            _bcornu_methode_context151.methodEnd();
        }
    }

    public CapabilityPermission(String namespace, Map<String, ?> attributes, Bundle providingBundle, String actions) {
        super(namespace);
        MethodContext _bcornu_methode_context152 = new MethodContext(null);
        try {
            setTransients(namespace, CapabilityPermission.parseActions(actions));
            if (attributes == null) {
                throw new IllegalArgumentException("attributes must not be null");
            }
            if (providingBundle == null) {
                throw new IllegalArgumentException("bundle must not be null");
            }
            this.attributes = new HashMap<String, Object>(attributes);
            CallChecker.varAssign(this.attributes, "this.attributes", 187, 6668, 6725);
            this.bundle = providingBundle;
            CallChecker.varAssign(this.bundle, "this.bundle", 188, 6729, 6758);
            if (((action_mask) & (CapabilityPermission.ACTION_ALL)) != (CapabilityPermission.ACTION_REQUIRE)) {
                throw new IllegalArgumentException("invalid action string");
            }
        } finally {
            _bcornu_methode_context152.methodEnd();
        }
    }

    CapabilityPermission(String name, int mask) {
        super(name);
        MethodContext _bcornu_methode_context153 = new MethodContext(null);
        try {
            setTransients(name, mask);
            this.attributes = null;
            CallChecker.varAssign(this.attributes, "this.attributes", 203, 7121, 7143);
            this.bundle = null;
            CallChecker.varAssign(this.bundle, "this.bundle", 204, 7147, 7165);
        } finally {
            _bcornu_methode_context153.methodEnd();
        }
    }

    private void setTransients(String name, int mask) {
        MethodContext _bcornu_methode_context1513 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 212, 7172, 7502);
            CallChecker.varInit(mask, "mask", 212, 7172, 7502);
            CallChecker.varInit(name, "name", 212, 7172, 7502);
            CallChecker.varInit(this.properties, "properties", 212, 7172, 7502);
            CallChecker.varInit(this.filter, "filter", 212, 7172, 7502);
            CallChecker.varInit(this.bundle, "bundle", 212, 7172, 7502);
            CallChecker.varInit(this.attributes, "attributes", 212, 7172, 7502);
            CallChecker.varInit(this.actions, "actions", 212, 7172, 7502);
            CallChecker.varInit(this.action_mask, "action_mask", 212, 7172, 7502);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 212, 7172, 7502);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 212, 7172, 7502);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 212, 7172, 7502);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 212, 7172, 7502);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 212, 7172, 7502);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 212, 7172, 7502);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 212, 7172, 7502);
            if ((mask == (CapabilityPermission.ACTION_NONE)) || ((mask & (CapabilityPermission.ACTION_ALL)) != mask)) {
                throw new IllegalArgumentException("invalid action string");
            }
            action_mask = mask;
            CallChecker.varAssign(this.action_mask, "this.action_mask", 216, 7451, 7469);
            filter = CapabilityPermission.parseFilter(name);
            CallChecker.varAssign(this.filter, "this.filter", 217, 7473, 7499);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1513.methodEnd();
        }
    }

    private static int parseActions(String actions) {
        MethodContext _bcornu_methode_context1514 = new MethodContext(int.class);
        try {
            CallChecker.varInit(actions, "actions", 226, 7506, 9617);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 226, 7506, 9617);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 226, 7506, 9617);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 226, 7506, 9617);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 226, 7506, 9617);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 226, 7506, 9617);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 226, 7506, 9617);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 226, 7506, 9617);
            boolean seencomma = CallChecker.varInit(((boolean) (false)), "seencomma", 227, 7674, 7699);
            int mask = CallChecker.varInit(((int) (CapabilityPermission.ACTION_NONE)), "mask", 229, 7704, 7726);
            if (actions == null) {
                return mask;
            }
            char[] a = CallChecker.varInit(actions.toCharArray(), "a", 235, 7777, 7809);
            int i = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(a, char[].class, 237, 7822, 7822)) {
                a = CallChecker.beforeCalled(a, char[].class, 237, 7822, 7822);
                i = (CallChecker.isCalled(a, char[].class, 237, 7822, 7822).length) - 1;
                CallChecker.varAssign(i, "i", 237, 7822, 7822);
            }
            if (i < 0)
                return mask;
            
            while (i != (-1)) {
                char c = CallChecker.init(char.class);
                a = CallChecker.beforeCalled(a, char[].class, 245, 7949, 7949);
                while ((i != (-1)) && ((((((c = CallChecker.isCalled(a, char[].class, 245, 7949, 7949)[i]) == ' ') || (c == '\r')) || (c == '\n')) || (c == '\f')) || (c == '\t'))) {
                    CallChecker.varAssign(c, "c", 245, 7944, 7953);
                    i--;
                } 
                int matchlen = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(a, char[].class, 251, 8096, 8096)) {
                    if (CallChecker.beforeDeref(a, char[].class, 251, 8115, 8115)) {
                        if (CallChecker.beforeDeref(a, char[].class, 252, 8141, 8141)) {
                            if (CallChecker.beforeDeref(a, char[].class, 252, 8160, 8160)) {
                                if (CallChecker.beforeDeref(a, char[].class, 253, 8186, 8186)) {
                                    if (CallChecker.beforeDeref(a, char[].class, 253, 8205, 8205)) {
                                        if (CallChecker.beforeDeref(a, char[].class, 254, 8231, 8231)) {
                                            if (CallChecker.beforeDeref(a, char[].class, 254, 8250, 8250)) {
                                                if (CallChecker.beforeDeref(a, char[].class, 255, 8276, 8276)) {
                                                    if (CallChecker.beforeDeref(a, char[].class, 255, 8295, 8295)) {
                                                        if (CallChecker.beforeDeref(a, char[].class, 256, 8321, 8321)) {
                                                            if (CallChecker.beforeDeref(a, char[].class, 256, 8340, 8340)) {
                                                                if (CallChecker.beforeDeref(a, char[].class, 257, 8366, 8366)) {
                                                                    if (CallChecker.beforeDeref(a, char[].class, 257, 8381, 8381)) {
                                                                        a = CallChecker.beforeCalled(a, char[].class, 251, 8096, 8096);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 251, 8115, 8115);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 252, 8141, 8141);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 252, 8160, 8160);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 253, 8186, 8186);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 253, 8205, 8205);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 254, 8231, 8231);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 254, 8250, 8250);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 255, 8276, 8276);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 255, 8295, 8295);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 256, 8321, 8321);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 256, 8340, 8340);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 257, 8366, 8366);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 257, 8381, 8381);
                                                                        if ((((((((i >= 6) && (((CallChecker.isCalled(a, char[].class, 251, 8096, 8096)[(i - 6)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 251, 8115, 8115)[(i - 6)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 252, 8141, 8141)[(i - 5)]) == 'e') || ((CallChecker.isCalled(a, char[].class, 252, 8160, 8160)[(i - 5)]) == 'E'))) && (((CallChecker.isCalled(a, char[].class, 253, 8186, 8186)[(i - 4)]) == 'q') || ((CallChecker.isCalled(a, char[].class, 253, 8205, 8205)[(i - 4)]) == 'Q'))) && (((CallChecker.isCalled(a, char[].class, 254, 8231, 8231)[(i - 3)]) == 'u') || ((CallChecker.isCalled(a, char[].class, 254, 8250, 8250)[(i - 3)]) == 'U'))) && (((CallChecker.isCalled(a, char[].class, 255, 8276, 8276)[(i - 2)]) == 'i') || ((CallChecker.isCalled(a, char[].class, 255, 8295, 8295)[(i - 2)]) == 'I'))) && (((CallChecker.isCalled(a, char[].class, 256, 8321, 8321)[(i - 1)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 256, 8340, 8340)[(i - 1)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 257, 8366, 8366)[i]) == 'e') || ((CallChecker.isCalled(a, char[].class, 257, 8381, 8381)[i]) == 'E'))) {
                                                                            matchlen = 7;
                                                                            CallChecker.varAssign(matchlen, "matchlen", 258, 8401, 8413);
                                                                            mask |= CapabilityPermission.ACTION_REQUIRE;
                                                                            CallChecker.varAssign(mask, "mask", 259, 8419, 8441);
                                                                        }else
                                                                            if (CallChecker.beforeDeref(a, char[].class, 261, 8472, 8472)) {
                                                                                if (CallChecker.beforeDeref(a, char[].class, 261, 8491, 8491)) {
                                                                                    if (CallChecker.beforeDeref(a, char[].class, 262, 8518, 8518)) {
                                                                                        if (CallChecker.beforeDeref(a, char[].class, 262, 8537, 8537)) {
                                                                                            if (CallChecker.beforeDeref(a, char[].class, 263, 8564, 8564)) {
                                                                                                if (CallChecker.beforeDeref(a, char[].class, 263, 8583, 8583)) {
                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 264, 8610, 8610)) {
                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 264, 8629, 8629)) {
                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 265, 8656, 8656)) {
                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 265, 8675, 8675)) {
                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 266, 8702, 8702)) {
                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 266, 8721, 8721)) {
                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 267, 8748, 8748)) {
                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 267, 8763, 8763)) {
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 261, 8472, 8472);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 261, 8491, 8491);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 262, 8518, 8518);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 262, 8537, 8537);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 263, 8564, 8564);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 263, 8583, 8583);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 264, 8610, 8610);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 264, 8629, 8629);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 265, 8656, 8656);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 265, 8675, 8675);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 266, 8702, 8702);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 266, 8721, 8721);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 267, 8748, 8748);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 267, 8763, 8763);
                                                                                                                                    if ((((((((i >= 6) && (((CallChecker.isCalled(a, char[].class, 261, 8472, 8472)[(i - 6)]) == 'p') || ((CallChecker.isCalled(a, char[].class, 261, 8491, 8491)[(i - 6)]) == 'P'))) && (((CallChecker.isCalled(a, char[].class, 262, 8518, 8518)[(i - 5)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 262, 8537, 8537)[(i - 5)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 263, 8564, 8564)[(i - 4)]) == 'o') || ((CallChecker.isCalled(a, char[].class, 263, 8583, 8583)[(i - 4)]) == 'O'))) && (((CallChecker.isCalled(a, char[].class, 264, 8610, 8610)[(i - 3)]) == 'v') || ((CallChecker.isCalled(a, char[].class, 264, 8629, 8629)[(i - 3)]) == 'V'))) && (((CallChecker.isCalled(a, char[].class, 265, 8656, 8656)[(i - 2)]) == 'i') || ((CallChecker.isCalled(a, char[].class, 265, 8675, 8675)[(i - 2)]) == 'I'))) && (((CallChecker.isCalled(a, char[].class, 266, 8702, 8702)[(i - 1)]) == 'd') || ((CallChecker.isCalled(a, char[].class, 266, 8721, 8721)[(i - 1)]) == 'D'))) && (((CallChecker.isCalled(a, char[].class, 267, 8748, 8748)[i]) == 'e') || ((CallChecker.isCalled(a, char[].class, 267, 8763, 8763)[i]) == 'E'))) {
                                                                                                                                        matchlen = 7;
                                                                                                                                        CallChecker.varAssign(matchlen, "matchlen", 268, 8784, 8796);
                                                                                                                                        mask |= CapabilityPermission.ACTION_PROVIDE;
                                                                                                                                        CallChecker.varAssign(mask, "mask", 269, 8803, 8825);
                                                                                                                                    }else {
                                                                                                                                        throw new IllegalArgumentException(("invalid permission: " + actions));
                                                                                                                                    }
                                                                                                                                }else
                                                                                                                                    throw new AbnormalExecutionError();
                                                                                                                                
                                                                                                                            }else
                                                                                                                                throw new AbnormalExecutionError();
                                                                                                                            
                                                                                                                        }else
                                                                                                                            throw new AbnormalExecutionError();
                                                                                                                        
                                                                                                                    }else
                                                                                                                        throw new AbnormalExecutionError();
                                                                                                                    
                                                                                                                }else
                                                                                                                    throw new AbnormalExecutionError();
                                                                                                                
                                                                                                            }else
                                                                                                                throw new AbnormalExecutionError();
                                                                                                            
                                                                                                        }else
                                                                                                            throw new AbnormalExecutionError();
                                                                                                        
                                                                                                    }else
                                                                                                        throw new AbnormalExecutionError();
                                                                                                    
                                                                                                }else
                                                                                                    throw new AbnormalExecutionError();
                                                                                                
                                                                                            }else
                                                                                                throw new AbnormalExecutionError();
                                                                                            
                                                                                        }else
                                                                                            throw new AbnormalExecutionError();
                                                                                        
                                                                                    }else
                                                                                        throw new AbnormalExecutionError();
                                                                                    
                                                                                }else
                                                                                    throw new AbnormalExecutionError();
                                                                                
                                                                            }else
                                                                                throw new AbnormalExecutionError();
                                                                            
                                                                        
                                                                    }else
                                                                        throw new AbnormalExecutionError();
                                                                    
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                seencomma = false;
                CallChecker.varAssign(seencomma, "seencomma", 277, 9055, 9072);
                while ((i >= matchlen) && (!seencomma)) {
                    if (CallChecker.beforeDeref(a, char[].class, 279, 9127, 9127)) {
                        a = CallChecker.beforeCalled(a, char[].class, 279, 9127, 9127);
                        switch (CallChecker.isCalled(a, char[].class, 279, 9127, 9127)[(i - matchlen)]) {
                            case ',' :
                                seencomma = true;
                                CallChecker.varAssign(seencomma, "seencomma", 281, 9168, 9184);
                            case ' ' :
                            case '\r' :
                            case '\n' :
                            case '\f' :
                            case '\t' :
                                break;
                            default :
                                throw new IllegalArgumentException(("invalid permission: " + actions));
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    i--;
                } 
                i -= matchlen;
                CallChecker.varAssign(i, "i", 296, 9484, 9497);
            } 
            if (seencomma) {
                throw new IllegalArgumentException(("invalid permission: " + actions));
            }
            return mask;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1514.methodEnd();
        }
    }

    private static Filter parseFilter(String filterString) {
        MethodContext _bcornu_methode_context1515 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(filterString, "filterString", 314, 9621, 10319);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 314, 9621, 10319);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 314, 9621, 10319);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 314, 9621, 10319);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 314, 9621, 10319);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 314, 9621, 10319);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 314, 9621, 10319);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 314, 9621, 10319);
            if (CallChecker.beforeDeref(filterString, String.class, 315, 10017, 10028)) {
                filterString = CallChecker.beforeCalled(filterString, String.class, 315, 10017, 10028);
                filterString = CallChecker.isCalled(filterString, String.class, 315, 10017, 10028).trim();
                CallChecker.varAssign(filterString, "filterString", 315, 10002, 10036);
            }
            if (CallChecker.beforeDeref(filterString, String.class, 316, 10044, 10055)) {
                filterString = CallChecker.beforeCalled(filterString, String.class, 316, 10044, 10055);
                if ((CallChecker.isCalled(filterString, String.class, 316, 10044, 10055).charAt(0)) != '(') {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            TryContext _bcornu_try_context_427 = new TryContext(427, CapabilityPermission.class, "org.osgi.framework.InvalidSyntaxException");
            try {
                return FrameworkUtil.createFilter(filterString);
            } catch (InvalidSyntaxException e) {
                _bcornu_try_context_427.catchStart(427);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException("invalid filter"), "iae", 323, 10200, 10277);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 324, 10282, 10284)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 324, 10282, 10284);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 324, 10282, 10284).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_427.finallyStart(427);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1515.methodEnd();
        }
    }

    @Override
    public boolean implies(Permission p) {
        MethodContext _bcornu_methode_context1516 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 338, 10323, 10992);
            CallChecker.varInit(p, "p", 338, 10323, 10992);
            CallChecker.varInit(this.properties, "properties", 338, 10323, 10992);
            CallChecker.varInit(this.filter, "filter", 338, 10323, 10992);
            CallChecker.varInit(this.bundle, "bundle", 338, 10323, 10992);
            CallChecker.varInit(this.attributes, "attributes", 338, 10323, 10992);
            CallChecker.varInit(this.actions, "actions", 338, 10323, 10992);
            CallChecker.varInit(this.action_mask, "action_mask", 338, 10323, 10992);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 338, 10323, 10992);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 338, 10323, 10992);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 338, 10323, 10992);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 338, 10323, 10992);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 338, 10323, 10992);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 338, 10323, 10992);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 338, 10323, 10992);
            if (!(p instanceof CapabilityPermission)) {
                return false;
            }
            CapabilityPermission requested = CallChecker.varInit(((CapabilityPermission) (p)), "requested", 342, 10715, 10772);
            if ((bundle) != null) {
                return false;
            }
            if (CallChecker.beforeDeref(requested, CapabilityPermission.class, 347, 10899, 10907)) {
                requested = CallChecker.beforeCalled(requested, CapabilityPermission.class, 347, 10899, 10907);
                if ((CallChecker.isCalled(requested, CapabilityPermission.class, 347, 10899, 10907).filter) != null) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return implies0(requested, CapabilityPermission.ACTION_NONE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1516.methodEnd();
        }
    }

    boolean implies0(CapabilityPermission requested, int effective) {
        MethodContext _bcornu_methode_context1517 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 364, 10996, 11891);
            CallChecker.varInit(effective, "effective", 364, 10996, 11891);
            CallChecker.varInit(requested, "requested", 364, 10996, 11891);
            CallChecker.varInit(this.properties, "properties", 364, 10996, 11891);
            CallChecker.varInit(this.filter, "filter", 364, 10996, 11891);
            CallChecker.varInit(this.bundle, "bundle", 364, 10996, 11891);
            CallChecker.varInit(this.attributes, "attributes", 364, 10996, 11891);
            CallChecker.varInit(this.actions, "actions", 364, 10996, 11891);
            CallChecker.varInit(this.action_mask, "action_mask", 364, 10996, 11891);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 364, 10996, 11891);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 364, 10996, 11891);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 364, 10996, 11891);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 364, 10996, 11891);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 364, 10996, 11891);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 364, 10996, 11891);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 364, 10996, 11891);
            effective |= action_mask;
            CallChecker.varAssign(effective, "effective", 366, 11603, 11627);
            requested = CallChecker.beforeCalled(requested, CapabilityPermission.class, 367, 11651, 11659);
            final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, CapabilityPermission.class, 367, 11651, 11659).action_mask)), "desired", 367, 11631, 11672);
            if ((effective & desired) != desired) {
                return false;
            }
            Filter f = CallChecker.varInit(filter, "f", 372, 11765, 11782);
            if (f == null) {
                return super.implies(requested);
            }
            if (CallChecker.beforeDeref(requested, CapabilityPermission.class, 376, 11862, 11870)) {
                requested = CallChecker.beforeCalled(requested, CapabilityPermission.class, 376, 11862, 11870);
                return f.matches(CallChecker.isCalled(requested, CapabilityPermission.class, 376, 11862, 11870).getProperties());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1517.methodEnd();
        }
    }

    @Override
    public String getActions() {
        MethodContext _bcornu_methode_context1518 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 387, 11895, 12599);
            CallChecker.varInit(this.properties, "properties", 387, 11895, 12599);
            CallChecker.varInit(this.filter, "filter", 387, 11895, 12599);
            CallChecker.varInit(this.bundle, "bundle", 387, 11895, 12599);
            CallChecker.varInit(this.attributes, "attributes", 387, 11895, 12599);
            CallChecker.varInit(this.actions, "actions", 387, 11895, 12599);
            CallChecker.varInit(this.action_mask, "action_mask", 387, 11895, 12599);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 387, 11895, 12599);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 387, 11895, 12599);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 387, 11895, 12599);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 387, 11895, 12599);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 387, 11895, 12599);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 387, 11895, 12599);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 387, 11895, 12599);
            String result = CallChecker.varInit(actions, "result", 388, 12177, 12200);
            if (result == null) {
                StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 390, 12229, 12265);
                boolean comma = CallChecker.varInit(((boolean) (false)), "comma", 391, 12270, 12291);
                int mask = CallChecker.varInit(((int) (this.action_mask)), "mask", 393, 12297, 12319);
                if ((mask & (CapabilityPermission.ACTION_REQUIRE)) == (CapabilityPermission.ACTION_REQUIRE)) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 395, 12377, 12378)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 395, 12377, 12378);
                        CallChecker.isCalled(sb, StringBuffer.class, 395, 12377, 12378).append(CapabilityPermission.REQUIRE);
                    }
                    comma = true;
                    CallChecker.varAssign(comma, "comma", 396, 12401, 12413);
                }
                if ((mask & (CapabilityPermission.ACTION_PROVIDE)) == (CapabilityPermission.ACTION_PROVIDE)) {
                    if (comma)
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 401, 12493, 12494)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 401, 12493, 12494);
                            CallChecker.isCalled(sb, StringBuffer.class, 401, 12493, 12494).append(',');
                        }
                    
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 402, 12513, 12514)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 402, 12513, 12514);
                        CallChecker.isCalled(sb, StringBuffer.class, 402, 12513, 12514).append(CapabilityPermission.PROVIDE);
                    }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 405, 12561, 12562)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 405, 12561, 12562);
                    actions = result = CallChecker.isCalled(sb, StringBuffer.class, 405, 12561, 12562).toString();
                    CallChecker.varAssign(this.actions, "this.actions", 405, 12542, 12574);
                    CallChecker.varAssign(result, "result", 405, 12552, 12573);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1518.methodEnd();
        }
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        MethodContext _bcornu_methode_context1519 = new MethodContext(PermissionCollection.class);
        try {
            CallChecker.varInit(this, "this", 419, 12603, 12966);
            CallChecker.varInit(this.properties, "properties", 419, 12603, 12966);
            CallChecker.varInit(this.filter, "filter", 419, 12603, 12966);
            CallChecker.varInit(this.bundle, "bundle", 419, 12603, 12966);
            CallChecker.varInit(this.attributes, "attributes", 419, 12603, 12966);
            CallChecker.varInit(this.actions, "actions", 419, 12603, 12966);
            CallChecker.varInit(this.action_mask, "action_mask", 419, 12603, 12966);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 419, 12603, 12966);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 419, 12603, 12966);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 419, 12603, 12966);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 419, 12603, 12966);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 419, 12603, 12966);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 419, 12603, 12966);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 419, 12603, 12966);
            return new CapabilityPermissionCollection();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PermissionCollection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1519.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1520 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 435, 12970, 13867);
            CallChecker.varInit(obj, "obj", 435, 12970, 13867);
            CallChecker.varInit(this.properties, "properties", 435, 12970, 13867);
            CallChecker.varInit(this.filter, "filter", 435, 12970, 13867);
            CallChecker.varInit(this.bundle, "bundle", 435, 12970, 13867);
            CallChecker.varInit(this.attributes, "attributes", 435, 12970, 13867);
            CallChecker.varInit(this.actions, "actions", 435, 12970, 13867);
            CallChecker.varInit(this.action_mask, "action_mask", 435, 12970, 13867);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 435, 12970, 13867);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 435, 12970, 13867);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 435, 12970, 13867);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 435, 12970, 13867);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 435, 12970, 13867);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 435, 12970, 13867);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 435, 12970, 13867);
            if (obj == (this)) {
                return true;
            }
            if (!(obj instanceof CapabilityPermission)) {
                return false;
            }
            CapabilityPermission cp = CallChecker.varInit(((CapabilityPermission) (obj)), "cp", 444, 13555, 13607);
            if (CallChecker.beforeDeref(cp, CapabilityPermission.class, 446, 13671, 13672)) {
                if (CallChecker.beforeDeref(cp, CapabilityPermission.class, 446, 13766, 13767)) {
                    if (CallChecker.beforeDeref(cp, CapabilityPermission.class, 447, 13852, 13853)) {
                        cp = CallChecker.beforeCalled(cp, CapabilityPermission.class, 446, 13635, 13636);
                        cp = CallChecker.beforeCalled(cp, CapabilityPermission.class, 446, 13671, 13672);
                        cp = CallChecker.beforeCalled(cp, CapabilityPermission.class, 446, 13704, 13705);
                        cp = CallChecker.beforeCalled(cp, CapabilityPermission.class, 446, 13766, 13767);
                        cp = CallChecker.beforeCalled(cp, CapabilityPermission.class, 447, 13803, 13804);
                        cp = CallChecker.beforeCalled(cp, CapabilityPermission.class, 447, 13852, 13853);
                        return ((((action_mask) == (CallChecker.isCalled(cp, CapabilityPermission.class, 446, 13635, 13636).action_mask)) && (CallChecker.isCalled(getName(), String.class, 446, 13654, 13662).equals(CallChecker.isCalled(cp, CapabilityPermission.class, 446, 13671, 13672).getName()))) && (((attributes) == (CallChecker.isCalled(cp, CapabilityPermission.class, 446, 13704, 13705).attributes)) || (((attributes) != null) && (CallChecker.isCalled(attributes, Map.class, 446, 13748, 13757).equals(CallChecker.isCalled(cp, CapabilityPermission.class, 446, 13766, 13767).attributes))))) && (((bundle) == (CallChecker.isCalled(cp, CapabilityPermission.class, 447, 13803, 13804).bundle)) || (((bundle) != null) && (CallChecker.isCalled(bundle, Bundle.class, 447, 13838, 13843).equals(CallChecker.isCalled(cp, CapabilityPermission.class, 447, 13852, 13853).bundle))));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1520.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1521 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 456, 13871, 14244);
            CallChecker.varInit(this.properties, "properties", 456, 13871, 14244);
            CallChecker.varInit(this.filter, "filter", 456, 13871, 14244);
            CallChecker.varInit(this.bundle, "bundle", 456, 13871, 14244);
            CallChecker.varInit(this.attributes, "attributes", 456, 13871, 14244);
            CallChecker.varInit(this.actions, "actions", 456, 13871, 14244);
            CallChecker.varInit(this.action_mask, "action_mask", 456, 13871, 14244);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 456, 13871, 14244);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 456, 13871, 14244);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 456, 13871, 14244);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 456, 13871, 14244);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 456, 13871, 14244);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 456, 13871, 14244);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 456, 13871, 14244);
            int h = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(getName(), String.class, 457, 14035, 14043)) {
                h = (31 * 17) + (CallChecker.isCalled(getName(), String.class, 457, 14035, 14043).hashCode());
                CallChecker.varAssign(h, "h", 457, 14035, 14043);
            }
            final String npe_invocation_var534 = getActions();
            if (CallChecker.beforeDeref(npe_invocation_var534, String.class, 458, 14072, 14083)) {
                h = (31 * h) + (CallChecker.isCalled(npe_invocation_var534, String.class, 458, 14072, 14083).hashCode());
                CallChecker.varAssign(h, "h", 458, 14059, 14095);
            }
            if ((attributes) != null) {
                h = (31 * h) + (attributes.hashCode());
                CallChecker.varAssign(h, "h", 460, 14128, 14162);
            }
            if ((bundle) != null) {
                h = (31 * h) + (bundle.hashCode());
                CallChecker.varAssign(h, "h", 463, 14195, 14225);
            }
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1521.methodEnd();
        }
    }

    private synchronized void writeObject(ObjectOutputStream s) throws IOException {
        MethodContext _bcornu_methode_context1522 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 472, 14248, 14781);
            CallChecker.varInit(s, "s", 472, 14248, 14781);
            CallChecker.varInit(this.properties, "properties", 472, 14248, 14781);
            CallChecker.varInit(this.filter, "filter", 472, 14248, 14781);
            CallChecker.varInit(this.bundle, "bundle", 472, 14248, 14781);
            CallChecker.varInit(this.attributes, "attributes", 472, 14248, 14781);
            CallChecker.varInit(this.actions, "actions", 472, 14248, 14781);
            CallChecker.varInit(this.action_mask, "action_mask", 472, 14248, 14781);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 472, 14248, 14781);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 472, 14248, 14781);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 472, 14248, 14781);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 472, 14248, 14781);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 472, 14248, 14781);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 472, 14248, 14781);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 472, 14248, 14781);
            if ((bundle) != null) {
                throw new NotSerializableException("cannot serialize");
            }
            if ((actions) == null)
                getActions();
            
            if (CallChecker.beforeDeref(s, ObjectOutputStream.class, 480, 14756, 14756)) {
                s = CallChecker.beforeCalled(s, ObjectOutputStream.class, 480, 14756, 14756);
                CallChecker.isCalled(s, ObjectOutputStream.class, 480, 14756, 14756).defaultWriteObject();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1522.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1523 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 487, 14785, 15117);
            CallChecker.varInit(s, "s", 487, 14785, 15117);
            CallChecker.varInit(this.properties, "properties", 487, 14785, 15117);
            CallChecker.varInit(this.filter, "filter", 487, 14785, 15117);
            CallChecker.varInit(this.bundle, "bundle", 487, 14785, 15117);
            CallChecker.varInit(this.attributes, "attributes", 487, 14785, 15117);
            CallChecker.varInit(this.actions, "actions", 487, 14785, 15117);
            CallChecker.varInit(this.action_mask, "action_mask", 487, 14785, 15117);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 487, 14785, 15117);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 487, 14785, 15117);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 487, 14785, 15117);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 487, 14785, 15117);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 487, 14785, 15117);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 487, 14785, 15117);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 487, 14785, 15117);
            if (CallChecker.beforeDeref(s, ObjectInputStream.class, 489, 15042, 15042)) {
                s = CallChecker.beforeCalled(s, ObjectInputStream.class, 489, 15042, 15042);
                CallChecker.isCalled(s, ObjectInputStream.class, 489, 15042, 15042).defaultReadObject();
            }
            setTransients(getName(), CapabilityPermission.parseActions(actions));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1523.methodEnd();
        }
    }

    private Map<String, Object> getProperties() {
        MethodContext _bcornu_methode_context1525 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 499, 15121, 16160);
            CallChecker.varInit(this.properties, "properties", 499, 15121, 16160);
            CallChecker.varInit(this.filter, "filter", 499, 15121, 16160);
            CallChecker.varInit(this.bundle, "bundle", 499, 15121, 16160);
            CallChecker.varInit(this.attributes, "attributes", 499, 15121, 16160);
            CallChecker.varInit(this.actions, "actions", 499, 15121, 16160);
            CallChecker.varInit(this.action_mask, "action_mask", 499, 15121, 16160);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.CapabilityPermission.ACTION_NONE", 499, 15121, 16160);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.CapabilityPermission.ACTION_ALL", 499, 15121, 16160);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.CapabilityPermission.ACTION_PROVIDE", 499, 15121, 16160);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.CapabilityPermission.ACTION_REQUIRE", 499, 15121, 16160);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.CapabilityPermission.PROVIDE", 499, 15121, 16160);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.CapabilityPermission.REQUIRE", 499, 15121, 16160);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermission.serialVersionUID", 499, 15121, 16160);
            Map<String, Object> result = CallChecker.varInit(properties, "result", 500, 15390, 15429);
            if (result != null) {
                return result;
            }
            final Map<String, Object> props = CallChecker.varInit(new HashMap<String, Object>(5), "props", 504, 15479, 15543);
            if (CallChecker.beforeDeref(props, Map.class, 505, 15547, 15551)) {
                CallChecker.isCalled(props, Map.class, 505, 15547, 15551).put("capability.namespace", getName());
            }
            if ((bundle) == null) {
                return properties = props;
            }
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    MethodContext _bcornu_methode_context1524 = new MethodContext(Void.class);
                    try {
                        CallChecker.varInit(this, "this", 510, 15717, 16094);
                        if (CallChecker.beforeDeref(props, Map.class, 511, 15741, 15745)) {
                            CallChecker.isCalled(props, Map.class, 511, 15741, 15745).put("id", new Long(bundle.getBundleId()));
                        }
                        if (CallChecker.beforeDeref(props, Map.class, 512, 15794, 15798)) {
                            CallChecker.isCalled(props, Map.class, 512, 15794, 15798).put("location", bundle.getLocation());
                        }
                        String name = CallChecker.varInit(bundle.getSymbolicName(), "name", 513, 15843, 15881);
                        if (name != null) {
                            if (CallChecker.beforeDeref(props, Map.class, 515, 15912, 15916)) {
                                CallChecker.isCalled(props, Map.class, 515, 15912, 15916).put("name", name);
                            }
                        }
                        SignerProperty signer = CallChecker.varInit(new SignerProperty(bundle), "signer", 517, 15947, 15997);
                        if (CallChecker.beforeDeref(signer, SignerProperty.class, 518, 16007, 16012)) {
                            signer = CallChecker.beforeCalled(signer, SignerProperty.class, 518, 16007, 16012);
                            if (CallChecker.isCalled(signer, SignerProperty.class, 518, 16007, 16012).isBundleSigned()) {
                                if (CallChecker.beforeDeref(props, Map.class, 519, 16039, 16043)) {
                                    CallChecker.isCalled(props, Map.class, 519, 16039, 16043).put("signer", signer);
                                }
                            }
                        }
                        return null;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Void) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1524.methodEnd();
                    }
                }
            });
            return properties = new CapabilityPermission.Properties(props, attributes);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1525.methodEnd();
        }
    }

    private static final class Properties extends AbstractMap<String, Object> {
        private final Map<String, Object> properties;

        private final Map<String, Object> attributes;

        private transient volatile Set<Map.Entry<String, Object>> entries;

        Properties(Map<String, Object> properties, Map<String, Object> attributes) {
            MethodContext _bcornu_methode_context154 = new MethodContext(null);
            try {
                this.properties = properties;
                CallChecker.varAssign(this.properties, "this.properties", 533, 16500, 16528);
                this.attributes = attributes;
                CallChecker.varAssign(this.attributes, "this.attributes", 534, 16533, 16561);
                entries = null;
                CallChecker.varAssign(this.entries, "this.entries", 535, 16566, 16580);
            } finally {
                _bcornu_methode_context154.methodEnd();
            }
        }

        @Override
        public Object get(Object k) {
            MethodContext _bcornu_methode_context1526 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 539, 16589, 16949);
                CallChecker.varInit(k, "k", 539, 16589, 16949);
                CallChecker.varInit(this.entries, "entries", 539, 16589, 16949);
                CallChecker.varInit(this.attributes, "attributes", 539, 16589, 16949);
                CallChecker.varInit(this.properties, "properties", 539, 16589, 16949);
                if (!(k instanceof String)) {
                    return null;
                }
                String key = CallChecker.varInit(((String) (k)), "key", 543, 16689, 16712);
                if (CallChecker.beforeDeref(key, String.class, 544, 16721, 16723)) {
                    key = CallChecker.beforeCalled(key, String.class, 544, 16721, 16723);
                    if ((CallChecker.isCalled(key, String.class, 544, 16721, 16723).charAt(0)) == '@') {
                        if (CallChecker.beforeDeref(key, String.class, 545, 16771, 16773)) {
                            if (CallChecker.beforeDeref(attributes, Map.class, 545, 16756, 16765)) {
                                key = CallChecker.beforeCalled(key, String.class, 545, 16771, 16773);
                                return CallChecker.isCalled(attributes, Map.class, 545, 16756, 16765).get(CallChecker.isCalled(key, String.class, 545, 16771, 16773).substring(1));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(properties, Map.class, 547, 16813, 16822)) {
                    value = CallChecker.isCalled(properties, Map.class, 547, 16813, 16822).get(key);
                    CallChecker.varAssign(value, "value", 547, 16813, 16822);
                }
                if (value != null) {
                    return value;
                }
                if (CallChecker.beforeDeref(attributes, Map.class, 551, 16926, 16935)) {
                    return CallChecker.isCalled(attributes, Map.class, 551, 16926, 16935).get(key);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1526.methodEnd();
            }
        }

        public Set<Map.Entry<String, Object>> entrySet() {
            MethodContext _bcornu_methode_context1527 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 554, 16954, 17307);
                CallChecker.varInit(this.entries, "entries", 554, 16954, 17307);
                CallChecker.varInit(this.attributes, "attributes", 554, 16954, 17307);
                CallChecker.varInit(this.properties, "properties", 554, 16954, 17307);
                if ((entries) != null) {
                    return entries;
                }
                Set<Map.Entry<String, Object>> all = CallChecker.init(Set.class);
                if (CallChecker.beforeDeref(attributes, Map.class, 558, 17135, 17144)) {
                    if (CallChecker.beforeDeref(properties, Map.class, 558, 17155, 17164)) {
                        all = new HashSet<Map.Entry<String, Object>>(((CallChecker.isCalled(attributes, Map.class, 558, 17135, 17144).size()) + (CallChecker.isCalled(properties, Map.class, 558, 17155, 17164).size())));
                        CallChecker.varAssign(all, "all", 558, 17135, 17144);
                    }
                }
                if (CallChecker.beforeDeref(attributes, Map.class, 559, 17189, 17198)) {
                    if (CallChecker.beforeDeref(all, Set.class, 559, 17178, 17180)) {
                        all = CallChecker.beforeCalled(all, Set.class, 559, 17178, 17180);
                        CallChecker.isCalled(all, Set.class, 559, 17178, 17180).addAll(CallChecker.isCalled(attributes, Map.class, 559, 17189, 17198).entrySet());
                    }
                }
                if (CallChecker.beforeDeref(properties, Map.class, 560, 17227, 17236)) {
                    if (CallChecker.beforeDeref(all, Set.class, 560, 17216, 17218)) {
                        all = CallChecker.beforeCalled(all, Set.class, 560, 17216, 17218);
                        CallChecker.isCalled(all, Set.class, 560, 17216, 17218).addAll(CallChecker.isCalled(properties, Map.class, 560, 17227, 17236).entrySet());
                    }
                }
                return entries = Collections.unmodifiableSet(all);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<String, Object>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1527.methodEnd();
            }
        }
    }
}

