package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.io.IOException;
import java.util.HashMap;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.security.BasicPermission;
import java.security.AccessController;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.PrivilegedAction;

public final class AdaptPermission extends BasicPermission {
    private static final long serialVersionUID = 1L;

    public static final String ADAPT = "adapt";

    private static final int ACTION_ADAPT = 1;

    private static final int ACTION_ALL = AdaptPermission.ACTION_ADAPT;

    static final int ACTION_NONE = 0;

    transient int action_mask;

    private volatile String actions = null;

    final transient Bundle bundle;

    transient Filter filter;

    private transient volatile Map<String, Object> properties;

    public AdaptPermission(String filter, String actions) {
        this(AdaptPermission.parseFilter(filter), AdaptPermission.parseActions(actions));
        MethodContext _bcornu_methode_context52 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    public AdaptPermission(String adaptClass, Bundle adaptableBundle, String actions) {
        super(adaptClass);
        MethodContext _bcornu_methode_context53 = new MethodContext(null);
        try {
            setTransients(null, AdaptPermission.parseActions(actions));
            this.bundle = adaptableBundle;
            CallChecker.varAssign(this.bundle, "this.bundle", 144, 4674, 4703);
            if (adaptClass == null) {
                throw new NullPointerException("adaptClass must not be null");
            }
            if (adaptableBundle == null) {
                throw new NullPointerException("adaptableBundle must not be null");
            }
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    AdaptPermission(Filter filter, int mask) {
        super((filter == null ? "*" : CallChecker.isCalled(filter, Filter.class, 160, 5132, 5137).toString()));
        MethodContext _bcornu_methode_context54 = new MethodContext(null);
        try {
            setTransients(filter, mask);
            this.bundle = null;
            CallChecker.varAssign(this.bundle, "this.bundle", 162, 5185, 5203);
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    private void setTransients(Filter filter, int mask) {
        MethodContext _bcornu_methode_context736 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 171, 5210, 5609);
            CallChecker.varInit(mask, "mask", 171, 5210, 5609);
            CallChecker.varInit(filter, "filter", 171, 5210, 5609);
            CallChecker.varInit(this.properties, "properties", 171, 5210, 5609);
            CallChecker.varInit(this.filter, "filter", 171, 5210, 5609);
            CallChecker.varInit(this.bundle, "bundle", 171, 5210, 5609);
            CallChecker.varInit(this.actions, "actions", 171, 5210, 5609);
            CallChecker.varInit(this.action_mask, "action_mask", 171, 5210, 5609);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 171, 5210, 5609);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 171, 5210, 5609);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 171, 5210, 5609);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 171, 5210, 5609);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 171, 5210, 5609);
            this.filter = filter;
            CallChecker.varAssign(this.filter, "this.filter", 172, 5427, 5447);
            if ((mask == (AdaptPermission.ACTION_NONE)) || ((mask & (AdaptPermission.ACTION_ALL)) != mask)) {
                throw new IllegalArgumentException("invalid action string");
            }
            this.action_mask = mask;
            CallChecker.varAssign(this.action_mask, "this.action_mask", 176, 5583, 5606);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context736.methodEnd();
        }
    }

    private static int parseActions(String actions) {
        MethodContext _bcornu_methode_context737 = new MethodContext(int.class);
        try {
            CallChecker.varInit(actions, "actions", 185, 5613, 7237);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 185, 5613, 7237);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 185, 5613, 7237);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 185, 5613, 7237);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 185, 5613, 7237);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 185, 5613, 7237);
            boolean seencomma = CallChecker.varInit(((boolean) (false)), "seencomma", 186, 5781, 5806);
            int mask = CallChecker.varInit(((int) (AdaptPermission.ACTION_NONE)), "mask", 188, 5811, 5833);
            if (actions == null) {
                return mask;
            }
            char[] a = CallChecker.varInit(actions.toCharArray(), "a", 194, 5884, 5916);
            int i = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(a, char[].class, 196, 5929, 5929)) {
                a = CallChecker.beforeCalled(a, char[].class, 196, 5929, 5929);
                i = (CallChecker.isCalled(a, char[].class, 196, 5929, 5929).length) - 1;
                CallChecker.varAssign(i, "i", 196, 5929, 5929);
            }
            if (i < 0)
                return mask;
            
            while (i != (-1)) {
                char c = CallChecker.init(char.class);
                a = CallChecker.beforeCalled(a, char[].class, 204, 6056, 6056);
                while ((i != (-1)) && ((((((c = CallChecker.isCalled(a, char[].class, 204, 6056, 6056)[i]) == ' ') || (c == '\r')) || (c == '\n')) || (c == '\f')) || (c == '\t'))) {
                    CallChecker.varAssign(c, "c", 204, 6051, 6060);
                    i--;
                } 
                int matchlen = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(a, char[].class, 210, 6203, 6203)) {
                    if (CallChecker.beforeDeref(a, char[].class, 210, 6222, 6222)) {
                        if (CallChecker.beforeDeref(a, char[].class, 211, 6248, 6248)) {
                            if (CallChecker.beforeDeref(a, char[].class, 211, 6267, 6267)) {
                                if (CallChecker.beforeDeref(a, char[].class, 212, 6293, 6293)) {
                                    if (CallChecker.beforeDeref(a, char[].class, 212, 6312, 6312)) {
                                        if (CallChecker.beforeDeref(a, char[].class, 213, 6338, 6338)) {
                                            if (CallChecker.beforeDeref(a, char[].class, 213, 6357, 6357)) {
                                                if (CallChecker.beforeDeref(a, char[].class, 214, 6383, 6383)) {
                                                    if (CallChecker.beforeDeref(a, char[].class, 214, 6398, 6398)) {
                                                        a = CallChecker.beforeCalled(a, char[].class, 210, 6203, 6203);
                                                        a = CallChecker.beforeCalled(a, char[].class, 210, 6222, 6222);
                                                        a = CallChecker.beforeCalled(a, char[].class, 211, 6248, 6248);
                                                        a = CallChecker.beforeCalled(a, char[].class, 211, 6267, 6267);
                                                        a = CallChecker.beforeCalled(a, char[].class, 212, 6293, 6293);
                                                        a = CallChecker.beforeCalled(a, char[].class, 212, 6312, 6312);
                                                        a = CallChecker.beforeCalled(a, char[].class, 213, 6338, 6338);
                                                        a = CallChecker.beforeCalled(a, char[].class, 213, 6357, 6357);
                                                        a = CallChecker.beforeCalled(a, char[].class, 214, 6383, 6383);
                                                        a = CallChecker.beforeCalled(a, char[].class, 214, 6398, 6398);
                                                        if ((((((i >= 4) && (((CallChecker.isCalled(a, char[].class, 210, 6203, 6203)[(i - 4)]) == 'a') || ((CallChecker.isCalled(a, char[].class, 210, 6222, 6222)[(i - 4)]) == 'A'))) && (((CallChecker.isCalled(a, char[].class, 211, 6248, 6248)[(i - 3)]) == 'd') || ((CallChecker.isCalled(a, char[].class, 211, 6267, 6267)[(i - 3)]) == 'D'))) && (((CallChecker.isCalled(a, char[].class, 212, 6293, 6293)[(i - 2)]) == 'a') || ((CallChecker.isCalled(a, char[].class, 212, 6312, 6312)[(i - 2)]) == 'A'))) && (((CallChecker.isCalled(a, char[].class, 213, 6338, 6338)[(i - 1)]) == 'p') || ((CallChecker.isCalled(a, char[].class, 213, 6357, 6357)[(i - 1)]) == 'P'))) && (((CallChecker.isCalled(a, char[].class, 214, 6383, 6383)[i]) == 't') || ((CallChecker.isCalled(a, char[].class, 214, 6398, 6398)[i]) == 'T'))) {
                                                            matchlen = 5;
                                                            CallChecker.varAssign(matchlen, "matchlen", 215, 6418, 6430);
                                                            mask |= AdaptPermission.ACTION_ADAPT;
                                                            CallChecker.varAssign(mask, "mask", 216, 6436, 6456);
                                                        }else {
                                                            throw new IllegalArgumentException(("invalid actions: " + actions));
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
                
                seencomma = false;
                CallChecker.varAssign(seencomma, "seencomma", 225, 6678, 6695);
                while ((i >= matchlen) && (!seencomma)) {
                    if (CallChecker.beforeDeref(a, char[].class, 227, 6750, 6750)) {
                        a = CallChecker.beforeCalled(a, char[].class, 227, 6750, 6750);
                        switch (CallChecker.isCalled(a, char[].class, 227, 6750, 6750)[(i - matchlen)]) {
                            case ',' :
                                seencomma = true;
                                CallChecker.varAssign(seencomma, "seencomma", 229, 6791, 6807);
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
                CallChecker.varAssign(i, "i", 244, 7107, 7120);
            } 
            if (seencomma) {
                throw new IllegalArgumentException(("invalid actions: " + actions));
            }
            return mask;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context737.methodEnd();
        }
    }

    private static Filter parseFilter(String filterString) {
        MethodContext _bcornu_methode_context738 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(filterString, "filterString", 261, 7241, 7832);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 261, 7241, 7832);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 261, 7241, 7832);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 261, 7241, 7832);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 261, 7241, 7832);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 261, 7241, 7832);
            if (CallChecker.beforeDeref(filterString, String.class, 262, 7536, 7547)) {
                filterString = CallChecker.beforeCalled(filterString, String.class, 262, 7536, 7547);
                filterString = CallChecker.isCalled(filterString, String.class, 262, 7536, 7547).trim();
                CallChecker.varAssign(filterString, "filterString", 262, 7521, 7555);
            }
            if (CallChecker.beforeDeref(filterString, String.class, 263, 7563, 7574)) {
                filterString = CallChecker.beforeCalled(filterString, String.class, 263, 7563, 7574);
                if (CallChecker.isCalled(filterString, String.class, 263, 7563, 7574).equals("*")) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            TryContext _bcornu_try_context_265 = new TryContext(265, AdaptPermission.class, "org.osgi.framework.InvalidSyntaxException");
            try {
                return FrameworkUtil.createFilter(filterString);
            } catch (InvalidSyntaxException e) {
                _bcornu_try_context_265.catchStart(265);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException("invalid filter"), "iae", 269, 7713, 7790);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 270, 7795, 7797)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 270, 7795, 7797);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 270, 7795, 7797).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_265.finallyStart(265);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context738.methodEnd();
        }
    }

    @Override
    public boolean implies(Permission p) {
        MethodContext _bcornu_methode_context739 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 290, 7836, 8752);
            CallChecker.varInit(p, "p", 290, 7836, 8752);
            CallChecker.varInit(this.properties, "properties", 290, 7836, 8752);
            CallChecker.varInit(this.filter, "filter", 290, 7836, 8752);
            CallChecker.varInit(this.bundle, "bundle", 290, 7836, 8752);
            CallChecker.varInit(this.actions, "actions", 290, 7836, 8752);
            CallChecker.varInit(this.action_mask, "action_mask", 290, 7836, 8752);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 290, 7836, 8752);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 290, 7836, 8752);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 290, 7836, 8752);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 290, 7836, 8752);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 290, 7836, 8752);
            if (!(p instanceof AdaptPermission)) {
                return false;
            }
            AdaptPermission requested = CallChecker.varInit(((AdaptPermission) (p)), "requested", 294, 8485, 8532);
            if ((bundle) != null) {
                return false;
            }
            if (CallChecker.beforeDeref(requested, AdaptPermission.class, 299, 8659, 8667)) {
                requested = CallChecker.beforeCalled(requested, AdaptPermission.class, 299, 8659, 8667);
                if ((CallChecker.isCalled(requested, AdaptPermission.class, 299, 8659, 8667).filter) != null) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return implies0(requested, AdaptPermission.ACTION_NONE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context739.methodEnd();
        }
    }

    boolean implies0(AdaptPermission requested, int effective) {
        MethodContext _bcornu_methode_context740 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 316, 8756, 9624);
            CallChecker.varInit(effective, "effective", 316, 8756, 9624);
            CallChecker.varInit(requested, "requested", 316, 8756, 9624);
            CallChecker.varInit(this.properties, "properties", 316, 8756, 9624);
            CallChecker.varInit(this.filter, "filter", 316, 8756, 9624);
            CallChecker.varInit(this.bundle, "bundle", 316, 8756, 9624);
            CallChecker.varInit(this.actions, "actions", 316, 8756, 9624);
            CallChecker.varInit(this.action_mask, "action_mask", 316, 8756, 9624);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 316, 8756, 9624);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 316, 8756, 9624);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 316, 8756, 9624);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 316, 8756, 9624);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 316, 8756, 9624);
            effective |= action_mask;
            CallChecker.varAssign(effective, "effective", 318, 9348, 9372);
            requested = CallChecker.beforeCalled(requested, AdaptPermission.class, 319, 9396, 9404);
            final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, AdaptPermission.class, 319, 9396, 9404).action_mask)), "desired", 319, 9376, 9417);
            if ((effective & desired) != desired) {
                return false;
            }
            Filter f = CallChecker.varInit(filter, "f", 324, 9503, 9520);
            if (f == null) {
                return true;
            }
            if (CallChecker.beforeDeref(requested, AdaptPermission.class, 329, 9595, 9603)) {
                requested = CallChecker.beforeCalled(requested, AdaptPermission.class, 329, 9595, 9603);
                return f.matches(CallChecker.isCalled(requested, AdaptPermission.class, 329, 9595, 9603).getProperties());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context740.methodEnd();
        }
    }

    @Override
    public String getActions() {
        MethodContext _bcornu_methode_context741 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 344, 9628, 10088);
            CallChecker.varInit(this.properties, "properties", 344, 9628, 10088);
            CallChecker.varInit(this.filter, "filter", 344, 9628, 10088);
            CallChecker.varInit(this.bundle, "bundle", 344, 9628, 10088);
            CallChecker.varInit(this.actions, "actions", 344, 9628, 10088);
            CallChecker.varInit(this.action_mask, "action_mask", 344, 9628, 10088);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 344, 9628, 10088);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 344, 9628, 10088);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 344, 9628, 10088);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 344, 9628, 10088);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 344, 9628, 10088);
            String result = CallChecker.varInit(actions, "result", 345, 9988, 10011);
            if (result == null) {
                actions = result = AdaptPermission.ADAPT;
                CallChecker.varAssign(this.actions, "this.actions", 347, 10040, 10064);
                CallChecker.varAssign(result, "result", 347, 10050, 10063);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context741.methodEnd();
        }
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        MethodContext _bcornu_methode_context742 = new MethodContext(PermissionCollection.class);
        try {
            CallChecker.varInit(this, "this", 359, 10092, 10384);
            CallChecker.varInit(this.properties, "properties", 359, 10092, 10384);
            CallChecker.varInit(this.filter, "filter", 359, 10092, 10384);
            CallChecker.varInit(this.bundle, "bundle", 359, 10092, 10384);
            CallChecker.varInit(this.actions, "actions", 359, 10092, 10384);
            CallChecker.varInit(this.action_mask, "action_mask", 359, 10092, 10384);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 359, 10092, 10384);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 359, 10092, 10384);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 359, 10092, 10384);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 359, 10092, 10384);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 359, 10092, 10384);
            return new AdaptPermissionCollection();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PermissionCollection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context742.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context743 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 376, 10388, 11271);
            CallChecker.varInit(obj, "obj", 376, 10388, 11271);
            CallChecker.varInit(this.properties, "properties", 376, 10388, 11271);
            CallChecker.varInit(this.filter, "filter", 376, 10388, 11271);
            CallChecker.varInit(this.bundle, "bundle", 376, 10388, 11271);
            CallChecker.varInit(this.actions, "actions", 376, 10388, 11271);
            CallChecker.varInit(this.action_mask, "action_mask", 376, 10388, 11271);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 376, 10388, 11271);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 376, 10388, 11271);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 376, 10388, 11271);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 376, 10388, 11271);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 376, 10388, 11271);
            if (obj == (this)) {
                return true;
            }
            if (!(obj instanceof AdaptPermission)) {
                return false;
            }
            AdaptPermission cp = CallChecker.varInit(((AdaptPermission) (obj)), "cp", 385, 11072, 11114);
            if (CallChecker.beforeDeref(cp, AdaptPermission.class, 387, 11178, 11179)) {
                if (CallChecker.beforeDeref(cp, AdaptPermission.class, 387, 11256, 11257)) {
                    cp = CallChecker.beforeCalled(cp, AdaptPermission.class, 387, 11142, 11143);
                    cp = CallChecker.beforeCalled(cp, AdaptPermission.class, 387, 11178, 11179);
                    cp = CallChecker.beforeCalled(cp, AdaptPermission.class, 387, 11207, 11208);
                    cp = CallChecker.beforeCalled(cp, AdaptPermission.class, 387, 11256, 11257);
                    return (((action_mask) == (CallChecker.isCalled(cp, AdaptPermission.class, 387, 11142, 11143).action_mask)) && (CallChecker.isCalled(getName(), String.class, 387, 11161, 11169).equals(CallChecker.isCalled(cp, AdaptPermission.class, 387, 11178, 11179).getName()))) && (((bundle) == (CallChecker.isCalled(cp, AdaptPermission.class, 387, 11207, 11208).bundle)) || (((bundle) != null) && (CallChecker.isCalled(bundle, Bundle.class, 387, 11242, 11247).equals(CallChecker.isCalled(cp, AdaptPermission.class, 387, 11256, 11257).bundle))));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context743.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context744 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 396, 11275, 11579);
            CallChecker.varInit(this.properties, "properties", 396, 11275, 11579);
            CallChecker.varInit(this.filter, "filter", 396, 11275, 11579);
            CallChecker.varInit(this.bundle, "bundle", 396, 11275, 11579);
            CallChecker.varInit(this.actions, "actions", 396, 11275, 11579);
            CallChecker.varInit(this.action_mask, "action_mask", 396, 11275, 11579);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 396, 11275, 11579);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 396, 11275, 11579);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 396, 11275, 11579);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 396, 11275, 11579);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 396, 11275, 11579);
            int h = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(getName(), String.class, 397, 11441, 11449)) {
                h = (31 * 17) + (CallChecker.isCalled(getName(), String.class, 397, 11441, 11449).hashCode());
                CallChecker.varAssign(h, "h", 397, 11441, 11449);
            }
            final String npe_invocation_var236 = getActions();
            if (CallChecker.beforeDeref(npe_invocation_var236, String.class, 398, 11478, 11489)) {
                h = (31 * h) + (CallChecker.isCalled(npe_invocation_var236, String.class, 398, 11478, 11489).hashCode());
                CallChecker.varAssign(h, "h", 398, 11465, 11501);
            }
            if ((bundle) != null) {
                h = (31 * h) + (bundle.hashCode());
                CallChecker.varAssign(h, "h", 400, 11530, 11560);
            }
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context744.methodEnd();
        }
    }

    private synchronized void writeObject(ObjectOutputStream s) throws IOException {
        MethodContext _bcornu_methode_context745 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 410, 11583, 12127);
            CallChecker.varInit(s, "s", 410, 11583, 12127);
            CallChecker.varInit(this.properties, "properties", 410, 11583, 12127);
            CallChecker.varInit(this.filter, "filter", 410, 11583, 12127);
            CallChecker.varInit(this.bundle, "bundle", 410, 11583, 12127);
            CallChecker.varInit(this.actions, "actions", 410, 11583, 12127);
            CallChecker.varInit(this.action_mask, "action_mask", 410, 11583, 12127);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 410, 11583, 12127);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 410, 11583, 12127);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 410, 11583, 12127);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 410, 11583, 12127);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 410, 11583, 12127);
            if ((bundle) != null) {
                throw new NotSerializableException("cannot serialize");
            }
            if ((actions) == null)
                getActions();
            
            if (CallChecker.beforeDeref(s, ObjectOutputStream.class, 418, 12102, 12102)) {
                s = CallChecker.beforeCalled(s, ObjectOutputStream.class, 418, 12102, 12102);
                CallChecker.isCalled(s, ObjectOutputStream.class, 418, 12102, 12102).defaultWriteObject();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context745.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context746 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 425, 12131, 12476);
            CallChecker.varInit(s, "s", 425, 12131, 12476);
            CallChecker.varInit(this.properties, "properties", 425, 12131, 12476);
            CallChecker.varInit(this.filter, "filter", 425, 12131, 12476);
            CallChecker.varInit(this.bundle, "bundle", 425, 12131, 12476);
            CallChecker.varInit(this.actions, "actions", 425, 12131, 12476);
            CallChecker.varInit(this.action_mask, "action_mask", 425, 12131, 12476);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 425, 12131, 12476);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 425, 12131, 12476);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 425, 12131, 12476);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 425, 12131, 12476);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 425, 12131, 12476);
            if (CallChecker.beforeDeref(s, ObjectInputStream.class, 427, 12388, 12388)) {
                s = CallChecker.beforeCalled(s, ObjectInputStream.class, 427, 12388, 12388);
                CallChecker.isCalled(s, ObjectInputStream.class, 427, 12388, 12388).defaultReadObject();
            }
            setTransients(AdaptPermission.parseFilter(getName()), AdaptPermission.parseActions(actions));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context746.methodEnd();
        }
    }

    private Map<String, Object> getProperties() {
        MethodContext _bcornu_methode_context748 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 437, 12480, 13447);
            CallChecker.varInit(this.properties, "properties", 437, 12480, 13447);
            CallChecker.varInit(this.filter, "filter", 437, 12480, 13447);
            CallChecker.varInit(this.bundle, "bundle", 437, 12480, 13447);
            CallChecker.varInit(this.actions, "actions", 437, 12480, 13447);
            CallChecker.varInit(this.action_mask, "action_mask", 437, 12480, 13447);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.AdaptPermission.ACTION_NONE", 437, 12480, 13447);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.AdaptPermission.ACTION_ALL", 437, 12480, 13447);
            CallChecker.varInit(ACTION_ADAPT, "org.osgi.framework.AdaptPermission.ACTION_ADAPT", 437, 12480, 13447);
            CallChecker.varInit(ADAPT, "org.osgi.framework.AdaptPermission.ADAPT", 437, 12480, 13447);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermission.serialVersionUID", 437, 12480, 13447);
            Map<String, Object> result = CallChecker.varInit(properties, "result", 438, 12744, 12783);
            if (result != null) {
                return result;
            }
            final Map<String, Object> map = CallChecker.varInit(new HashMap<String, Object>(5), "map", 442, 12833, 12895);
            if (CallChecker.beforeDeref(map, Map.class, 443, 12899, 12901)) {
                CallChecker.isCalled(map, Map.class, 443, 12899, 12901).put("adaptClass", getName());
            }
            if ((bundle) != null) {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {
                    public Void run() {
                        MethodContext _bcornu_methode_context747 = new MethodContext(Void.class);
                        try {
                            CallChecker.varInit(this, "this", 446, 13025, 13406);
                            if (CallChecker.beforeDeref(map, Map.class, 447, 13050, 13052)) {
                                CallChecker.isCalled(map, Map.class, 447, 13050, 13052).put("id", new Long(bundle.getBundleId()));
                            }
                            if (CallChecker.beforeDeref(map, Map.class, 448, 13102, 13104)) {
                                CallChecker.isCalled(map, Map.class, 448, 13102, 13104).put("location", bundle.getLocation());
                            }
                            String name = CallChecker.varInit(bundle.getSymbolicName(), "name", 449, 13150, 13188);
                            if (name != null) {
                                if (CallChecker.beforeDeref(map, Map.class, 451, 13221, 13223)) {
                                    CallChecker.isCalled(map, Map.class, 451, 13221, 13223).put("name", name);
                                }
                            }
                            SignerProperty signer = CallChecker.varInit(new SignerProperty(bundle), "signer", 453, 13256, 13306);
                            if (CallChecker.beforeDeref(signer, SignerProperty.class, 454, 13317, 13322)) {
                                signer = CallChecker.beforeCalled(signer, SignerProperty.class, 454, 13317, 13322);
                                if (CallChecker.isCalled(signer, SignerProperty.class, 454, 13317, 13322).isBundleSigned()) {
                                    if (CallChecker.beforeDeref(map, Map.class, 455, 13350, 13352)) {
                                        CallChecker.isCalled(map, Map.class, 455, 13350, 13352).put("signer", signer);
                                    }
                                }
                            }
                            return null;
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Void) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context747.methodEnd();
                        }
                    }
                });
            }
            return properties = map;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context748.methodEnd();
        }
    }
}

