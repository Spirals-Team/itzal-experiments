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

public final class ServicePermission extends BasicPermission {
    static final long serialVersionUID = -7662148639076511574L;

    public static final String GET = "get";

    public static final String REGISTER = "register";

    private static final int ACTION_GET = 1;

    private static final int ACTION_REGISTER = 2;

    private static final int ACTION_ALL = (ServicePermission.ACTION_GET) | (ServicePermission.ACTION_REGISTER);

    static final int ACTION_NONE = 0;

    transient int action_mask;

    private volatile String actions = null;

    final transient ServiceReference<?> service;

    final transient String[] objectClass;

    transient Filter filter;

    private transient volatile Map<String, Object> properties;

    private transient boolean wildcard;

    private transient String prefix;

    public ServicePermission(String name, String actions) {
        this(name, ServicePermission.parseActions(actions));
        MethodContext _bcornu_methode_context61 = new MethodContext(null);
        try {
            if (((filter) != null) && (((action_mask) & (ServicePermission.ACTION_ALL)) != (ServicePermission.ACTION_GET))) {
                throw new IllegalArgumentException("invalid action string for filter expression");
            }
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    public ServicePermission(ServiceReference<?> reference, String actions) {
        super(ServicePermission.createName(reference));
        MethodContext _bcornu_methode_context62 = new MethodContext(null);
        try {
            setTransients(null, ServicePermission.parseActions(actions));
            this.service = reference;
            CallChecker.varAssign(this.service, "this.service", 193, 6715, 6739);
            reference = CallChecker.beforeCalled(reference, ServiceReference.class, 194, 6773, 6781);
            this.objectClass = ((String[]) (CallChecker.isCalled(reference, ServiceReference.class, 194, 6773, 6781).getProperty(Constants.OBJECTCLASS)));
            CallChecker.varAssign(this.objectClass, "this.objectClass", 194, 6743, 6817);
            if (((action_mask) & (ServicePermission.ACTION_ALL)) != (ServicePermission.ACTION_GET)) {
                throw new IllegalArgumentException("invalid action string");
            }
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    private static String createName(ServiceReference<?> reference) {
        MethodContext _bcornu_methode_context785 = new MethodContext(String.class);
        try {
            CallChecker.varInit(reference, "reference", 206, 6942, 7450);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 206, 6942, 7450);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 206, 6942, 7450);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 206, 6942, 7450);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 206, 6942, 7450);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 206, 6942, 7450);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 206, 6942, 7450);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 206, 6942, 7450);
            if (reference == null) {
                throw new IllegalArgumentException("reference must not be null");
            }
            StringBuffer sb = CallChecker.varInit(new StringBuffer((("(" + (Constants.SERVICE_ID)) + "=")), "sb", 210, 7279, 7347);
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 211, 7351, 7352)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 211, 7351, 7352);
                CallChecker.isCalled(sb, StringBuffer.class, 211, 7351, 7352).append(reference.getProperty(Constants.SERVICE_ID));
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 212, 7409, 7410)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 212, 7409, 7410);
                CallChecker.isCalled(sb, StringBuffer.class, 212, 7409, 7410).append(")");
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 213, 7434, 7435)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 213, 7434, 7435);
                return CallChecker.isCalled(sb, StringBuffer.class, 213, 7434, 7435).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context785.methodEnd();
        }
    }

    ServicePermission(String name, int mask) {
        super(name);
        MethodContext _bcornu_methode_context63 = new MethodContext(null);
        try {
            setTransients(ServicePermission.parseFilter(name), mask);
            this.service = null;
            CallChecker.varAssign(this.service, "this.service", 225, 7695, 7714);
            this.objectClass = null;
            CallChecker.varAssign(this.objectClass, "this.objectClass", 226, 7718, 7741);
        } finally {
            _bcornu_methode_context63.methodEnd();
        }
    }

    private void setTransients(Filter f, int mask) {
        MethodContext _bcornu_methode_context786 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 234, 7748, 8333);
            CallChecker.varInit(mask, "mask", 234, 7748, 8333);
            CallChecker.varInit(f, "f", 234, 7748, 8333);
            CallChecker.varInit(this.prefix, "prefix", 234, 7748, 8333);
            CallChecker.varInit(this.wildcard, "wildcard", 234, 7748, 8333);
            CallChecker.varInit(this.properties, "properties", 234, 7748, 8333);
            CallChecker.varInit(this.filter, "filter", 234, 7748, 8333);
            CallChecker.varInit(this.objectClass, "objectClass", 234, 7748, 8333);
            CallChecker.varInit(this.service, "service", 234, 7748, 8333);
            CallChecker.varInit(this.actions, "actions", 234, 7748, 8333);
            CallChecker.varInit(this.action_mask, "action_mask", 234, 7748, 8333);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 234, 7748, 8333);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 234, 7748, 8333);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 234, 7748, 8333);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 234, 7748, 8333);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 234, 7748, 8333);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 234, 7748, 8333);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 234, 7748, 8333);
            if ((mask == (ServicePermission.ACTION_NONE)) || ((mask & (ServicePermission.ACTION_ALL)) != mask)) {
                throw new IllegalArgumentException("invalid action string");
            }
            action_mask = mask;
            CallChecker.varAssign(this.action_mask, "this.action_mask", 238, 8024, 8042);
            filter = f;
            CallChecker.varAssign(this.filter, "this.filter", 239, 8046, 8056);
            if (f == null) {
                String name = CallChecker.varInit(getName(), "name", 241, 8080, 8103);
                int l = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(name, String.class, 242, 8116, 8119)) {
                    name = CallChecker.beforeCalled(name, String.class, 242, 8116, 8119);
                    l = CallChecker.isCalled(name, String.class, 242, 8116, 8119).length();
                    CallChecker.varAssign(l, "l", 242, 8116, 8119);
                }
                if (CallChecker.beforeDeref(name, String.class, 244, 8180, 8183)) {
                    if (CallChecker.beforeDeref(name, String.class, 244, 8224, 8227)) {
                        name = CallChecker.beforeCalled(name, String.class, 244, 8180, 8183);
                        name = CallChecker.beforeCalled(name, String.class, 244, 8224, 8227);
                        wildcard = ((CallChecker.isCalled(name, String.class, 244, 8180, 8183).charAt((l - 1))) == '*') && ((l == 1) || ((CallChecker.isCalled(name, String.class, 244, 8224, 8227).charAt((l - 2))) == '.'));
                        CallChecker.varAssign(this.wildcard, "this.wildcard", 244, 8167, 8252);
                    }
                }
                if ((wildcard) && (l > 1)) {
                    if (CallChecker.beforeDeref(name, String.class, 246, 8297, 8300)) {
                        name = CallChecker.beforeCalled(name, String.class, 246, 8297, 8300);
                        prefix = CallChecker.isCalled(name, String.class, 246, 8297, 8300).substring(0, (l - 1));
                        CallChecker.varAssign(this.prefix, "this.prefix", 246, 8288, 8321);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context786.methodEnd();
        }
    }

    private static int parseActions(String actions) {
        MethodContext _bcornu_methode_context787 = new MethodContext(int.class);
        try {
            CallChecker.varInit(actions, "actions", 257, 8337, 10314);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 257, 8337, 10314);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 257, 8337, 10314);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 257, 8337, 10314);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 257, 8337, 10314);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 257, 8337, 10314);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 257, 8337, 10314);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 257, 8337, 10314);
            boolean seencomma = CallChecker.varInit(((boolean) (false)), "seencomma", 258, 8505, 8530);
            int mask = CallChecker.varInit(((int) (ServicePermission.ACTION_NONE)), "mask", 260, 8535, 8557);
            if (actions == null) {
                return mask;
            }
            char[] a = CallChecker.varInit(actions.toCharArray(), "a", 266, 8608, 8640);
            int i = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(a, char[].class, 268, 8653, 8653)) {
                a = CallChecker.beforeCalled(a, char[].class, 268, 8653, 8653);
                i = (CallChecker.isCalled(a, char[].class, 268, 8653, 8653).length) - 1;
                CallChecker.varAssign(i, "i", 268, 8653, 8653);
            }
            if (i < 0)
                return mask;
            
            while (i != (-1)) {
                char c = CallChecker.init(char.class);
                a = CallChecker.beforeCalled(a, char[].class, 276, 8780, 8780);
                while ((i != (-1)) && ((((((c = CallChecker.isCalled(a, char[].class, 276, 8780, 8780)[i]) == ' ') || (c == '\r')) || (c == '\n')) || (c == '\f')) || (c == '\t'))) {
                    CallChecker.varAssign(c, "c", 276, 8775, 8784);
                    i--;
                } 
                int matchlen = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(a, char[].class, 282, 8927, 8927)) {
                    if (CallChecker.beforeDeref(a, char[].class, 282, 8946, 8946)) {
                        if (CallChecker.beforeDeref(a, char[].class, 283, 8972, 8972)) {
                            if (CallChecker.beforeDeref(a, char[].class, 283, 8991, 8991)) {
                                if (CallChecker.beforeDeref(a, char[].class, 284, 9017, 9017)) {
                                    if (CallChecker.beforeDeref(a, char[].class, 284, 9032, 9032)) {
                                        a = CallChecker.beforeCalled(a, char[].class, 282, 8927, 8927);
                                        a = CallChecker.beforeCalled(a, char[].class, 282, 8946, 8946);
                                        a = CallChecker.beforeCalled(a, char[].class, 283, 8972, 8972);
                                        a = CallChecker.beforeCalled(a, char[].class, 283, 8991, 8991);
                                        a = CallChecker.beforeCalled(a, char[].class, 284, 9017, 9017);
                                        a = CallChecker.beforeCalled(a, char[].class, 284, 9032, 9032);
                                        if ((((i >= 2) && (((CallChecker.isCalled(a, char[].class, 282, 8927, 8927)[(i - 2)]) == 'g') || ((CallChecker.isCalled(a, char[].class, 282, 8946, 8946)[(i - 2)]) == 'G'))) && (((CallChecker.isCalled(a, char[].class, 283, 8972, 8972)[(i - 1)]) == 'e') || ((CallChecker.isCalled(a, char[].class, 283, 8991, 8991)[(i - 1)]) == 'E'))) && (((CallChecker.isCalled(a, char[].class, 284, 9017, 9017)[i]) == 't') || ((CallChecker.isCalled(a, char[].class, 284, 9032, 9032)[i]) == 'T'))) {
                                            matchlen = 3;
                                            CallChecker.varAssign(matchlen, "matchlen", 285, 9052, 9064);
                                            mask |= ServicePermission.ACTION_GET;
                                            CallChecker.varAssign(mask, "mask", 286, 9070, 9088);
                                        }else
                                            if (CallChecker.beforeDeref(a, char[].class, 289, 9120, 9120)) {
                                                if (CallChecker.beforeDeref(a, char[].class, 289, 9139, 9139)) {
                                                    if (CallChecker.beforeDeref(a, char[].class, 290, 9166, 9166)) {
                                                        if (CallChecker.beforeDeref(a, char[].class, 290, 9185, 9185)) {
                                                            if (CallChecker.beforeDeref(a, char[].class, 291, 9212, 9212)) {
                                                                if (CallChecker.beforeDeref(a, char[].class, 291, 9231, 9231)) {
                                                                    if (CallChecker.beforeDeref(a, char[].class, 292, 9258, 9258)) {
                                                                        if (CallChecker.beforeDeref(a, char[].class, 292, 9277, 9277)) {
                                                                            if (CallChecker.beforeDeref(a, char[].class, 293, 9304, 9304)) {
                                                                                if (CallChecker.beforeDeref(a, char[].class, 293, 9323, 9323)) {
                                                                                    if (CallChecker.beforeDeref(a, char[].class, 294, 9350, 9350)) {
                                                                                        if (CallChecker.beforeDeref(a, char[].class, 294, 9369, 9369)) {
                                                                                            if (CallChecker.beforeDeref(a, char[].class, 295, 9396, 9396)) {
                                                                                                if (CallChecker.beforeDeref(a, char[].class, 295, 9415, 9415)) {
                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 296, 9442, 9442)) {
                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 296, 9457, 9457)) {
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 289, 9120, 9120);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 289, 9139, 9139);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 290, 9166, 9166);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 290, 9185, 9185);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 291, 9212, 9212);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 291, 9231, 9231);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 292, 9258, 9258);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 292, 9277, 9277);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 293, 9304, 9304);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 293, 9323, 9323);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 294, 9350, 9350);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 294, 9369, 9369);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 295, 9396, 9396);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 295, 9415, 9415);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 296, 9442, 9442);
                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 296, 9457, 9457);
                                                                                                            if (((((((((i >= 7) && (((CallChecker.isCalled(a, char[].class, 289, 9120, 9120)[(i - 7)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 289, 9139, 9139)[(i - 7)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 290, 9166, 9166)[(i - 6)]) == 'e') || ((CallChecker.isCalled(a, char[].class, 290, 9185, 9185)[(i - 6)]) == 'E'))) && (((CallChecker.isCalled(a, char[].class, 291, 9212, 9212)[(i - 5)]) == 'g') || ((CallChecker.isCalled(a, char[].class, 291, 9231, 9231)[(i - 5)]) == 'G'))) && (((CallChecker.isCalled(a, char[].class, 292, 9258, 9258)[(i - 4)]) == 'i') || ((CallChecker.isCalled(a, char[].class, 292, 9277, 9277)[(i - 4)]) == 'I'))) && (((CallChecker.isCalled(a, char[].class, 293, 9304, 9304)[(i - 3)]) == 's') || ((CallChecker.isCalled(a, char[].class, 293, 9323, 9323)[(i - 3)]) == 'S'))) && (((CallChecker.isCalled(a, char[].class, 294, 9350, 9350)[(i - 2)]) == 't') || ((CallChecker.isCalled(a, char[].class, 294, 9369, 9369)[(i - 2)]) == 'T'))) && (((CallChecker.isCalled(a, char[].class, 295, 9396, 9396)[(i - 1)]) == 'e') || ((CallChecker.isCalled(a, char[].class, 295, 9415, 9415)[(i - 1)]) == 'E'))) && (((CallChecker.isCalled(a, char[].class, 296, 9442, 9442)[i]) == 'r') || ((CallChecker.isCalled(a, char[].class, 296, 9457, 9457)[i]) == 'R'))) {
                                                                                                                matchlen = 8;
                                                                                                                CallChecker.varAssign(matchlen, "matchlen", 297, 9478, 9490);
                                                                                                                mask |= ServicePermission.ACTION_REGISTER;
                                                                                                                CallChecker.varAssign(mask, "mask", 298, 9497, 9520);
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
                
                seencomma = false;
                CallChecker.varAssign(seencomma, "seencomma", 307, 9752, 9769);
                while ((i >= matchlen) && (!seencomma)) {
                    if (CallChecker.beforeDeref(a, char[].class, 309, 9824, 9824)) {
                        a = CallChecker.beforeCalled(a, char[].class, 309, 9824, 9824);
                        switch (CallChecker.isCalled(a, char[].class, 309, 9824, 9824)[(i - matchlen)]) {
                            case ',' :
                                seencomma = true;
                                CallChecker.varAssign(seencomma, "seencomma", 311, 9865, 9881);
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
                CallChecker.varAssign(i, "i", 326, 10181, 10194);
            } 
            if (seencomma) {
                throw new IllegalArgumentException(("invalid permission: " + actions));
            }
            return mask;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context787.methodEnd();
        }
    }

    private static Filter parseFilter(String filterString) {
        MethodContext _bcornu_methode_context788 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(filterString, "filterString", 344, 10318, 11016);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 344, 10318, 11016);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 344, 10318, 11016);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 344, 10318, 11016);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 344, 10318, 11016);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 344, 10318, 11016);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 344, 10318, 11016);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 344, 10318, 11016);
            if (CallChecker.beforeDeref(filterString, String.class, 345, 10714, 10725)) {
                filterString = CallChecker.beforeCalled(filterString, String.class, 345, 10714, 10725);
                filterString = CallChecker.isCalled(filterString, String.class, 345, 10714, 10725).trim();
                CallChecker.varAssign(filterString, "filterString", 345, 10699, 10733);
            }
            if (CallChecker.beforeDeref(filterString, String.class, 346, 10741, 10752)) {
                filterString = CallChecker.beforeCalled(filterString, String.class, 346, 10741, 10752);
                if ((CallChecker.isCalled(filterString, String.class, 346, 10741, 10752).charAt(0)) != '(') {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            TryContext _bcornu_try_context_277 = new TryContext(277, ServicePermission.class, "org.osgi.framework.InvalidSyntaxException");
            try {
                return FrameworkUtil.createFilter(filterString);
            } catch (InvalidSyntaxException e) {
                _bcornu_try_context_277.catchStart(277);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException("invalid filter"), "iae", 353, 10897, 10974);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 354, 10979, 10981)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 354, 10979, 10981);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 354, 10979, 10981).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_277.finallyStart(277);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context788.methodEnd();
        }
    }

    @Override
    public boolean implies(Permission p) {
        MethodContext _bcornu_methode_context789 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 368, 11020, 11678);
            CallChecker.varInit(p, "p", 368, 11020, 11678);
            CallChecker.varInit(this.prefix, "prefix", 368, 11020, 11678);
            CallChecker.varInit(this.wildcard, "wildcard", 368, 11020, 11678);
            CallChecker.varInit(this.properties, "properties", 368, 11020, 11678);
            CallChecker.varInit(this.filter, "filter", 368, 11020, 11678);
            CallChecker.varInit(this.objectClass, "objectClass", 368, 11020, 11678);
            CallChecker.varInit(this.service, "service", 368, 11020, 11678);
            CallChecker.varInit(this.actions, "actions", 368, 11020, 11678);
            CallChecker.varInit(this.action_mask, "action_mask", 368, 11020, 11678);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 368, 11020, 11678);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 368, 11020, 11678);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 368, 11020, 11678);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 368, 11020, 11678);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 368, 11020, 11678);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 368, 11020, 11678);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 368, 11020, 11678);
            if (!(p instanceof ServicePermission)) {
                return false;
            }
            ServicePermission requested = CallChecker.varInit(((ServicePermission) (p)), "requested", 372, 11406, 11457);
            if ((service) != null) {
                return false;
            }
            if (CallChecker.beforeDeref(requested, ServicePermission.class, 377, 11585, 11593)) {
                requested = CallChecker.beforeCalled(requested, ServicePermission.class, 377, 11585, 11593);
                if ((CallChecker.isCalled(requested, ServicePermission.class, 377, 11585, 11593).filter) != null) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return implies0(requested, ServicePermission.ACTION_NONE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context789.methodEnd();
        }
    }

    boolean implies0(ServicePermission requested, int effective) {
        MethodContext _bcornu_methode_context790 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 394, 11682, 13318);
            CallChecker.varInit(effective, "effective", 394, 11682, 13318);
            CallChecker.varInit(requested, "requested", 394, 11682, 13318);
            CallChecker.varInit(this.prefix, "prefix", 394, 11682, 13318);
            CallChecker.varInit(this.wildcard, "wildcard", 394, 11682, 13318);
            CallChecker.varInit(this.properties, "properties", 394, 11682, 13318);
            CallChecker.varInit(this.filter, "filter", 394, 11682, 13318);
            CallChecker.varInit(this.objectClass, "objectClass", 394, 11682, 13318);
            CallChecker.varInit(this.service, "service", 394, 11682, 13318);
            CallChecker.varInit(this.actions, "actions", 394, 11682, 13318);
            CallChecker.varInit(this.action_mask, "action_mask", 394, 11682, 13318);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 394, 11682, 13318);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 394, 11682, 13318);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 394, 11682, 13318);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 394, 11682, 13318);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 394, 11682, 13318);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 394, 11682, 13318);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 394, 11682, 13318);
            effective |= action_mask;
            CallChecker.varAssign(effective, "effective", 396, 12280, 12304);
            requested = CallChecker.beforeCalled(requested, ServicePermission.class, 397, 12328, 12336);
            final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, ServicePermission.class, 397, 12328, 12336).action_mask)), "desired", 397, 12308, 12349);
            if ((effective & desired) != desired) {
                return false;
            }
            if ((wildcard) && ((prefix) == null)) {
                return true;
            }
            Filter f = CallChecker.varInit(filter, "f", 406, 12530, 12547);
            if (f != null) {
                if (CallChecker.beforeDeref(requested, ServicePermission.class, 408, 12588, 12596)) {
                    requested = CallChecker.beforeCalled(requested, ServicePermission.class, 408, 12588, 12596);
                    return f.matches(CallChecker.isCalled(requested, ServicePermission.class, 408, 12588, 12596).getProperties());
                }else
                    throw new AbnormalExecutionError();
                
            }
            String[] requestedNames = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(requested, ServicePermission.class, 411, 12714, 12722)) {
                requested = CallChecker.beforeCalled(requested, ServicePermission.class, 411, 12714, 12722);
                requestedNames = CallChecker.isCalled(requested, ServicePermission.class, 411, 12714, 12722).objectClass;
                CallChecker.varAssign(requestedNames, "requestedNames", 411, 12714, 12722);
            }
            if (requestedNames == null) {
                return super.implies(requested);
            }
            if (wildcard) {
                int pl = CallChecker.varInit(((int) (this.prefix.length())), "pl", 417, 12889, 12913);
                for (int i = 0, l = requestedNames.length; i < l; i++) {
                    String requestedName = CallChecker.varInit(requestedNames[i], "requestedName", 419, 12979, 13019);
                    if (CallChecker.beforeDeref(requestedName, String.class, 420, 13030, 13042)) {
                        if (CallChecker.beforeDeref(requestedName, String.class, 420, 13062, 13074)) {
                            requestedName = CallChecker.beforeCalled(requestedName, String.class, 420, 13030, 13042);
                            requestedName = CallChecker.beforeCalled(requestedName, String.class, 420, 13062, 13074);
                            if (((CallChecker.isCalled(requestedName, String.class, 420, 13030, 13042).length()) > pl) && (CallChecker.isCalled(requestedName, String.class, 420, 13062, 13074).startsWith(prefix))) {
                                return true;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else {
                String name = CallChecker.varInit(getName(), "name", 425, 13141, 13164);
                for (int i = 0, l = requestedNames.length; i < l; i++) {
                    requestedNames = CallChecker.beforeCalled(requestedNames, String[].class, 427, 13234, 13247);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(requestedNames, String[].class, 427, 13234, 13247)[i], String.class, 427, 13234, 13250)) {
                        requestedNames[i] = CallChecker.beforeCalled(requestedNames[i], String.class, 427, 13234, 13250);
                        if (CallChecker.isCalled(requestedNames[i], String.class, 427, 13234, 13250).equals(name)) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context790.methodEnd();
        }
    }

    @Override
    public String getActions() {
        MethodContext _bcornu_methode_context791 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 443, 13322, 14014);
            CallChecker.varInit(this.prefix, "prefix", 443, 13322, 14014);
            CallChecker.varInit(this.wildcard, "wildcard", 443, 13322, 14014);
            CallChecker.varInit(this.properties, "properties", 443, 13322, 14014);
            CallChecker.varInit(this.filter, "filter", 443, 13322, 14014);
            CallChecker.varInit(this.objectClass, "objectClass", 443, 13322, 14014);
            CallChecker.varInit(this.service, "service", 443, 13322, 14014);
            CallChecker.varInit(this.actions, "actions", 443, 13322, 14014);
            CallChecker.varInit(this.action_mask, "action_mask", 443, 13322, 14014);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 443, 13322, 14014);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 443, 13322, 14014);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 443, 13322, 14014);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 443, 13322, 14014);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 443, 13322, 14014);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 443, 13322, 14014);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 443, 13322, 14014);
            String result = CallChecker.varInit(actions, "result", 444, 13601, 13624);
            if (result == null) {
                StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 446, 13653, 13689);
                boolean comma = CallChecker.varInit(((boolean) (false)), "comma", 447, 13694, 13715);
                int mask = CallChecker.varInit(((int) (this.action_mask)), "mask", 449, 13721, 13743);
                if ((mask & (ServicePermission.ACTION_GET)) == (ServicePermission.ACTION_GET)) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 451, 13793, 13794)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 451, 13793, 13794);
                        CallChecker.isCalled(sb, StringBuffer.class, 451, 13793, 13794).append(ServicePermission.GET);
                    }
                    comma = true;
                    CallChecker.varAssign(comma, "comma", 452, 13813, 13825);
                }
                if ((mask & (ServicePermission.ACTION_REGISTER)) == (ServicePermission.ACTION_REGISTER)) {
                    if (comma)
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 457, 13907, 13908)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 457, 13907, 13908);
                            CallChecker.isCalled(sb, StringBuffer.class, 457, 13907, 13908).append(',');
                        }
                    
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 458, 13927, 13928)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 458, 13927, 13928);
                        CallChecker.isCalled(sb, StringBuffer.class, 458, 13927, 13928).append(ServicePermission.REGISTER);
                    }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 461, 13976, 13977)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 461, 13976, 13977);
                    actions = result = CallChecker.isCalled(sb, StringBuffer.class, 461, 13976, 13977).toString();
                    CallChecker.varAssign(this.actions, "this.actions", 461, 13957, 13989);
                    CallChecker.varAssign(result, "result", 461, 13967, 13988);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context791.methodEnd();
        }
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        MethodContext _bcornu_methode_context792 = new MethodContext(PermissionCollection.class);
        try {
            CallChecker.varInit(this, "this", 475, 14018, 14372);
            CallChecker.varInit(this.prefix, "prefix", 475, 14018, 14372);
            CallChecker.varInit(this.wildcard, "wildcard", 475, 14018, 14372);
            CallChecker.varInit(this.properties, "properties", 475, 14018, 14372);
            CallChecker.varInit(this.filter, "filter", 475, 14018, 14372);
            CallChecker.varInit(this.objectClass, "objectClass", 475, 14018, 14372);
            CallChecker.varInit(this.service, "service", 475, 14018, 14372);
            CallChecker.varInit(this.actions, "actions", 475, 14018, 14372);
            CallChecker.varInit(this.action_mask, "action_mask", 475, 14018, 14372);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 475, 14018, 14372);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 475, 14018, 14372);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 475, 14018, 14372);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 475, 14018, 14372);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 475, 14018, 14372);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 475, 14018, 14372);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 475, 14018, 14372);
            return new ServicePermissionCollection();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PermissionCollection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context792.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context793 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 491, 14376, 15176);
            CallChecker.varInit(obj, "obj", 491, 14376, 15176);
            CallChecker.varInit(this.prefix, "prefix", 491, 14376, 15176);
            CallChecker.varInit(this.wildcard, "wildcard", 491, 14376, 15176);
            CallChecker.varInit(this.properties, "properties", 491, 14376, 15176);
            CallChecker.varInit(this.filter, "filter", 491, 14376, 15176);
            CallChecker.varInit(this.objectClass, "objectClass", 491, 14376, 15176);
            CallChecker.varInit(this.service, "service", 491, 14376, 15176);
            CallChecker.varInit(this.actions, "actions", 491, 14376, 15176);
            CallChecker.varInit(this.action_mask, "action_mask", 491, 14376, 15176);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 491, 14376, 15176);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 491, 14376, 15176);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 491, 14376, 15176);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 491, 14376, 15176);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 491, 14376, 15176);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 491, 14376, 15176);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 491, 14376, 15176);
            if (obj == (this)) {
                return true;
            }
            if (!(obj instanceof ServicePermission)) {
                return false;
            }
            ServicePermission sp = CallChecker.varInit(((ServicePermission) (obj)), "sp", 500, 14958, 15004);
            if (CallChecker.beforeDeref(sp, ServicePermission.class, 502, 15068, 15069)) {
                if (CallChecker.beforeDeref(sp, ServicePermission.class, 502, 15154, 15155)) {
                    sp = CallChecker.beforeCalled(sp, ServicePermission.class, 502, 15032, 15033);
                    sp = CallChecker.beforeCalled(sp, ServicePermission.class, 502, 15068, 15069);
                    sp = CallChecker.beforeCalled(sp, ServicePermission.class, 502, 15098, 15099);
                    sp = CallChecker.beforeCalled(sp, ServicePermission.class, 502, 15154, 15155);
                    return (((action_mask) == (CallChecker.isCalled(sp, ServicePermission.class, 502, 15032, 15033).action_mask)) && (CallChecker.isCalled(getName(), String.class, 502, 15051, 15059).equals(CallChecker.isCalled(sp, ServicePermission.class, 502, 15068, 15069).getName()))) && (((service) == (CallChecker.isCalled(sp, ServicePermission.class, 502, 15098, 15099).service)) || (((service) != null) && ((CallChecker.isCalled(service, ServiceReference.class, 502, 15136, 15142).compareTo(CallChecker.isCalled(sp, ServicePermission.class, 502, 15154, 15155).service)) == 0)));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context793.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context794 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 511, 15180, 15484);
            CallChecker.varInit(this.prefix, "prefix", 511, 15180, 15484);
            CallChecker.varInit(this.wildcard, "wildcard", 511, 15180, 15484);
            CallChecker.varInit(this.properties, "properties", 511, 15180, 15484);
            CallChecker.varInit(this.filter, "filter", 511, 15180, 15484);
            CallChecker.varInit(this.objectClass, "objectClass", 511, 15180, 15484);
            CallChecker.varInit(this.service, "service", 511, 15180, 15484);
            CallChecker.varInit(this.actions, "actions", 511, 15180, 15484);
            CallChecker.varInit(this.action_mask, "action_mask", 511, 15180, 15484);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 511, 15180, 15484);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 511, 15180, 15484);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 511, 15180, 15484);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 511, 15180, 15484);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 511, 15180, 15484);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 511, 15180, 15484);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 511, 15180, 15484);
            int h = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(getName(), String.class, 512, 15344, 15352)) {
                h = (31 * 17) + (CallChecker.isCalled(getName(), String.class, 512, 15344, 15352).hashCode());
                CallChecker.varAssign(h, "h", 512, 15344, 15352);
            }
            final String npe_invocation_var245 = getActions();
            if (CallChecker.beforeDeref(npe_invocation_var245, String.class, 513, 15381, 15392)) {
                h = (31 * h) + (CallChecker.isCalled(npe_invocation_var245, String.class, 513, 15381, 15392).hashCode());
                CallChecker.varAssign(h, "h", 513, 15368, 15404);
            }
            if ((service) != null) {
                h = (31 * h) + (service.hashCode());
                CallChecker.varAssign(h, "h", 515, 15434, 15465);
            }
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context794.methodEnd();
        }
    }

    private synchronized void writeObject(ObjectOutputStream s) throws IOException {
        MethodContext _bcornu_methode_context795 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 524, 15488, 16022);
            CallChecker.varInit(s, "s", 524, 15488, 16022);
            CallChecker.varInit(this.prefix, "prefix", 524, 15488, 16022);
            CallChecker.varInit(this.wildcard, "wildcard", 524, 15488, 16022);
            CallChecker.varInit(this.properties, "properties", 524, 15488, 16022);
            CallChecker.varInit(this.filter, "filter", 524, 15488, 16022);
            CallChecker.varInit(this.objectClass, "objectClass", 524, 15488, 16022);
            CallChecker.varInit(this.service, "service", 524, 15488, 16022);
            CallChecker.varInit(this.actions, "actions", 524, 15488, 16022);
            CallChecker.varInit(this.action_mask, "action_mask", 524, 15488, 16022);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 524, 15488, 16022);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 524, 15488, 16022);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 524, 15488, 16022);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 524, 15488, 16022);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 524, 15488, 16022);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 524, 15488, 16022);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 524, 15488, 16022);
            if ((service) != null) {
                throw new NotSerializableException("cannot serialize");
            }
            if ((actions) == null)
                getActions();
            
            if (CallChecker.beforeDeref(s, ObjectOutputStream.class, 532, 15997, 15997)) {
                s = CallChecker.beforeCalled(s, ObjectOutputStream.class, 532, 15997, 15997);
                CallChecker.isCalled(s, ObjectOutputStream.class, 532, 15997, 15997).defaultWriteObject();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context795.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context796 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 539, 16026, 16371);
            CallChecker.varInit(s, "s", 539, 16026, 16371);
            CallChecker.varInit(this.prefix, "prefix", 539, 16026, 16371);
            CallChecker.varInit(this.wildcard, "wildcard", 539, 16026, 16371);
            CallChecker.varInit(this.properties, "properties", 539, 16026, 16371);
            CallChecker.varInit(this.filter, "filter", 539, 16026, 16371);
            CallChecker.varInit(this.objectClass, "objectClass", 539, 16026, 16371);
            CallChecker.varInit(this.service, "service", 539, 16026, 16371);
            CallChecker.varInit(this.actions, "actions", 539, 16026, 16371);
            CallChecker.varInit(this.action_mask, "action_mask", 539, 16026, 16371);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 539, 16026, 16371);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 539, 16026, 16371);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 539, 16026, 16371);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 539, 16026, 16371);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 539, 16026, 16371);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 539, 16026, 16371);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 539, 16026, 16371);
            if (CallChecker.beforeDeref(s, ObjectInputStream.class, 541, 16283, 16283)) {
                s = CallChecker.beforeCalled(s, ObjectInputStream.class, 541, 16283, 16283);
                CallChecker.isCalled(s, ObjectInputStream.class, 541, 16283, 16283).defaultReadObject();
            }
            setTransients(ServicePermission.parseFilter(getName()), ServicePermission.parseActions(actions));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context796.methodEnd();
        }
    }

    private Map<String, Object> getProperties() {
        MethodContext _bcornu_methode_context798 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 551, 16375, 17558);
            CallChecker.varInit(this.prefix, "prefix", 551, 16375, 17558);
            CallChecker.varInit(this.wildcard, "wildcard", 551, 16375, 17558);
            CallChecker.varInit(this.properties, "properties", 551, 16375, 17558);
            CallChecker.varInit(this.filter, "filter", 551, 16375, 17558);
            CallChecker.varInit(this.objectClass, "objectClass", 551, 16375, 17558);
            CallChecker.varInit(this.service, "service", 551, 16375, 17558);
            CallChecker.varInit(this.actions, "actions", 551, 16375, 17558);
            CallChecker.varInit(this.action_mask, "action_mask", 551, 16375, 17558);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.ServicePermission.ACTION_NONE", 551, 16375, 17558);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.ServicePermission.ACTION_ALL", 551, 16375, 17558);
            CallChecker.varInit(ACTION_REGISTER, "org.osgi.framework.ServicePermission.ACTION_REGISTER", 551, 16375, 17558);
            CallChecker.varInit(ACTION_GET, "org.osgi.framework.ServicePermission.ACTION_GET", 551, 16375, 17558);
            CallChecker.varInit(REGISTER, "org.osgi.framework.ServicePermission.REGISTER", 551, 16375, 17558);
            CallChecker.varInit(GET, "org.osgi.framework.ServicePermission.GET", 551, 16375, 17558);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermission.serialVersionUID", 551, 16375, 17558);
            Map<String, Object> result = CallChecker.varInit(properties, "result", 552, 16641, 16680);
            if (result != null) {
                return result;
            }
            if ((service) == null) {
                result = new HashMap<String, Object>(1);
                CallChecker.varAssign(result, "result", 557, 16756, 16795);
                if (CallChecker.beforeDeref(result, Map.class, 558, 16800, 16805)) {
                    result = CallChecker.beforeCalled(result, Map.class, 558, 16800, 16805);
                    CallChecker.isCalled(result, Map.class, 558, 16800, 16805).put(Constants.OBJECTCLASS, new String[]{ getName() });
                }
                return properties = result;
            }
            final Map<String, Object> props = CallChecker.varInit(new HashMap<String, Object>(4), "props", 561, 16898, 16962);
            final Bundle bundle = CallChecker.varInit(service.getBundle(), "bundle", 562, 16966, 17007);
            if (bundle != null) {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {
                    public Void run() {
                        MethodContext _bcornu_methode_context797 = new MethodContext(Void.class);
                        try {
                            CallChecker.varInit(this, "this", 565, 17101, 17490);
                            if (CallChecker.beforeDeref(props, Map.class, 566, 17126, 17130)) {
                                CallChecker.isCalled(props, Map.class, 566, 17126, 17130).put("id", new Long(bundle.getBundleId()));
                            }
                            if (CallChecker.beforeDeref(props, Map.class, 567, 17180, 17184)) {
                                CallChecker.isCalled(props, Map.class, 567, 17180, 17184).put("location", bundle.getLocation());
                            }
                            String name = CallChecker.varInit(bundle.getSymbolicName(), "name", 568, 17230, 17268);
                            if (name != null) {
                                if (CallChecker.beforeDeref(props, Map.class, 570, 17301, 17305)) {
                                    CallChecker.isCalled(props, Map.class, 570, 17301, 17305).put("name", name);
                                }
                            }
                            SignerProperty signer = CallChecker.varInit(new SignerProperty(bundle), "signer", 572, 17338, 17388);
                            if (CallChecker.beforeDeref(signer, SignerProperty.class, 573, 17399, 17404)) {
                                signer = CallChecker.beforeCalled(signer, SignerProperty.class, 573, 17399, 17404);
                                if (CallChecker.isCalled(signer, SignerProperty.class, 573, 17399, 17404).isBundleSigned()) {
                                    if (CallChecker.beforeDeref(props, Map.class, 574, 17432, 17436)) {
                                        CallChecker.isCalled(props, Map.class, 574, 17432, 17436).put("signer", signer);
                                    }
                                }
                            }
                            return null;
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Void) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context797.methodEnd();
                        }
                    }
                });
            }
            return properties = new ServicePermission.Properties(props, service);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context798.methodEnd();
        }
    }

    private static final class Properties extends AbstractMap<String, Object> {
        private final Map<String, Object> properties;

        private final ServiceReference<?> service;

        private transient volatile Set<Map.Entry<String, Object>> entries;

        Properties(Map<String, Object> properties, ServiceReference<?> service) {
            MethodContext _bcornu_methode_context64 = new MethodContext(null);
            try {
                this.properties = properties;
                CallChecker.varAssign(this.properties, "this.properties", 589, 17892, 17920);
                this.service = service;
                CallChecker.varAssign(this.service, "this.service", 590, 17925, 17947);
                entries = null;
                CallChecker.varAssign(this.entries, "this.entries", 591, 17952, 17966);
            } finally {
                _bcornu_methode_context64.methodEnd();
            }
        }

        @Override
        public Object get(Object k) {
            MethodContext _bcornu_methode_context799 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 595, 17975, 18345);
                CallChecker.varInit(k, "k", 595, 17975, 18345);
                CallChecker.varInit(this.entries, "entries", 595, 17975, 18345);
                CallChecker.varInit(this.service, "service", 595, 17975, 18345);
                CallChecker.varInit(this.properties, "properties", 595, 17975, 18345);
                if (!(k instanceof String)) {
                    return null;
                }
                String key = CallChecker.varInit(((String) (k)), "key", 599, 18075, 18098);
                if (CallChecker.beforeDeref(key, String.class, 600, 18107, 18109)) {
                    key = CallChecker.beforeCalled(key, String.class, 600, 18107, 18109);
                    if ((CallChecker.isCalled(key, String.class, 600, 18107, 18109).charAt(0)) == '@') {
                        if (CallChecker.beforeDeref(key, String.class, 601, 18162, 18164)) {
                            if (CallChecker.beforeDeref(service, ServiceReference.class, 601, 18142, 18148)) {
                                key = CallChecker.beforeCalled(key, String.class, 601, 18162, 18164);
                                return CallChecker.isCalled(service, ServiceReference.class, 601, 18142, 18148).getProperty(CallChecker.isCalled(key, String.class, 601, 18162, 18164).substring(1));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(properties, Map.class, 603, 18204, 18213)) {
                    value = CallChecker.isCalled(properties, Map.class, 603, 18204, 18213).get(key);
                    CallChecker.varAssign(value, "value", 603, 18204, 18213);
                }
                if (value != null) {
                    return value;
                }
                if (CallChecker.beforeDeref(service, ServiceReference.class, 607, 18317, 18323)) {
                    return CallChecker.isCalled(service, ServiceReference.class, 607, 18317, 18323).getProperty(key);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context799.methodEnd();
            }
        }

        public Set<Map.Entry<String, Object>> entrySet() {
            MethodContext _bcornu_methode_context800 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 610, 18350, 18838);
                CallChecker.varInit(this.entries, "entries", 610, 18350, 18838);
                CallChecker.varInit(this.service, "service", 610, 18350, 18838);
                CallChecker.varInit(this.properties, "properties", 610, 18350, 18838);
                if ((entries) != null) {
                    return entries;
                }
                Set<Map.Entry<String, Object>> all = CallChecker.init(Set.class);
                if (CallChecker.beforeDeref(properties, Map.class, 614, 18531, 18540)) {
                    all = new HashSet<Map.Entry<String, Object>>(CallChecker.isCalled(properties, Map.class, 614, 18531, 18540).entrySet());
                    CallChecker.varAssign(all, "all", 614, 18531, 18540);
                }
                add : for (String key : CallChecker.isCalled(service, ServiceReference.class, 615, 18581, 18587).getPropertyKeys()) {
                    for (String k : CallChecker.isCalled(properties, Map.class, 616, 18630, 18639).keySet()) {
                        if (CallChecker.beforeDeref(key, String.class, 617, 18662, 18664)) {
                            if (CallChecker.isCalled(key, String.class, 617, 18662, 18664).equalsIgnoreCase(k)) {
                                continue add;
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(service, ServiceReference.class, 621, 18749, 18755)) {
                        if (CallChecker.beforeDeref(all, Set.class, 621, 18726, 18728)) {
                            all = CallChecker.beforeCalled(all, Set.class, 621, 18726, 18728);
                            CallChecker.isCalled(all, Set.class, 621, 18726, 18728).add(new ServicePermission.Properties.Entry(key, CallChecker.isCalled(service, ServiceReference.class, 621, 18749, 18755).getProperty(key)));
                        }
                    }
                }
                return entries = Collections.unmodifiableSet(all);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<String, Object>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context800.methodEnd();
            }
        }

        private static final class Entry implements Map.Entry<String, Object> {
            private final String k;

            private final Object v;

            Entry(String key, Object value) {
                MethodContext _bcornu_methode_context65 = new MethodContext(null);
                try {
                    this.k = key;
                    CallChecker.varAssign(this.k, "this.k", 631, 19011, 19023);
                    this.v = value;
                    CallChecker.varAssign(this.v, "this.v", 632, 19029, 19043);
                } finally {
                    _bcornu_methode_context65.methodEnd();
                }
            }

            public String getKey() {
                MethodContext _bcornu_methode_context801 = new MethodContext(String.class);
                try {
                    CallChecker.varInit(this, "this", 635, 19054, 19096);
                    CallChecker.varInit(this.v, "v", 635, 19054, 19096);
                    CallChecker.varInit(this.k, "k", 635, 19054, 19096);
                    return k;
                } catch (ForceReturn _bcornu_return_t) {
                    return ((String) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context801.methodEnd();
                }
            }

            public Object getValue() {
                MethodContext _bcornu_methode_context802 = new MethodContext(Object.class);
                try {
                    CallChecker.varInit(this, "this", 639, 19102, 19146);
                    CallChecker.varInit(this.v, "v", 639, 19102, 19146);
                    CallChecker.varInit(this.k, "k", 639, 19102, 19146);
                    return v;
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Object) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context802.methodEnd();
                }
            }

            public Object setValue(Object value) {
                MethodContext _bcornu_methode_context803 = new MethodContext(Object.class);
                try {
                    CallChecker.varInit(this, "this", 643, 19152, 19241);
                    CallChecker.varInit(value, "value", 643, 19152, 19241);
                    CallChecker.varInit(this.v, "v", 643, 19152, 19241);
                    CallChecker.varInit(this.k, "k", 643, 19152, 19241);
                    throw new UnsupportedOperationException();
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Object) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context803.methodEnd();
                }
            }

            @Override
            public String toString() {
                MethodContext _bcornu_methode_context804 = new MethodContext(String.class);
                try {
                    CallChecker.varInit(this, "this", 648, 19247, 19314);
                    CallChecker.varInit(this.v, "v", 648, 19247, 19314);
                    CallChecker.varInit(this.k, "k", 648, 19247, 19314);
                    return ((k) + "=") + (v);
                } catch (ForceReturn _bcornu_return_t) {
                    return ((String) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context804.methodEnd();
                }
            }

            @Override
            public int hashCode() {
                MethodContext _bcornu_methode_context805 = new MethodContext(int.class);
                try {
                    CallChecker.varInit(this, "this", 653, 19320, 19440);
                    CallChecker.varInit(this.v, "v", 653, 19320, 19440);
                    CallChecker.varInit(this.k, "k", 653, 19320, 19440);
                    if (((k) == null) || (CallChecker.beforeDeref(k, String.class, 654, 19387, 19387))) {
                        if (((v) == null) || (CallChecker.beforeDeref(v, Object.class, 654, 19422, 19422))) {
                            return (((k) == null) ? 0 : CallChecker.isCalled(k, String.class, 654, 19387, 19387).hashCode()) ^ (((v) == null) ? 0 : CallChecker.isCalled(v, Object.class, 654, 19422, 19422).hashCode());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context805.methodEnd();
                }
            }

            @Override
            public boolean equals(Object obj) {
                MethodContext _bcornu_methode_context806 = new MethodContext(boolean.class);
                try {
                    CallChecker.varInit(this, "this", 658, 19446, 19898);
                    CallChecker.varInit(obj, "obj", 658, 19446, 19898);
                    CallChecker.varInit(this.v, "v", 658, 19446, 19898);
                    CallChecker.varInit(this.k, "k", 658, 19446, 19898);
                    if (obj == (this)) {
                        return true;
                    }
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "e", 665, 19610, 19651);
                    final Object key = CallChecker.varInit(e.getKey(), "key", 666, 19657, 19686);
                    if (((k) == key) || (((k) != null) && (k.equals(key)))) {
                        final Object value = CallChecker.varInit(e.getValue(), "value", 668, 19749, 19782);
                        if (((v) == value) || (((v) != null) && (v.equals(value)))) {
                            return true;
                        }
                    }
                    return false;
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context806.methodEnd();
                }
            }
        }
    }
}

