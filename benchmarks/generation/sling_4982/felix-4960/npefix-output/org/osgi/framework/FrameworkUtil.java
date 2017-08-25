package org.osgi.framework;

import javax.security.auth.x500.X500Principal;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.Set;
import java.security.PrivilegedAction;
import java.lang.reflect.Modifier;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import java.lang.reflect.AccessibleObject;
import java.security.AccessController;
import java.util.AbstractMap;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.lang.reflect.Constructor;
import java.util.Dictionary;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class FrameworkUtil {
    private FrameworkUtil() {
        MethodContext _bcornu_methode_context156 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context156.methodEnd();
        }
    }

    public static Filter createFilter(String filter) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context1563 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(filter, "filter", 78, 1650, 2642);
            return FrameworkUtil.FilterImpl.newInstance(filter);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1563.methodEnd();
        }
    }

    public static boolean matchDistinguishedNameChain(String matchPattern, List<String> dnChain) {
        MethodContext _bcornu_methode_context1564 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(dnChain, "dnChain", 191, 2646, 6561);
            CallChecker.varInit(matchPattern, "matchPattern", 191, 2646, 6561);
            return FrameworkUtil.DNChainMatching.match(matchPattern, dnChain);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1564.methodEnd();
        }
    }

    public static Bundle getBundle(final Class<?> classFromBundle) {
        MethodContext _bcornu_methode_context1566 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(classFromBundle, "classFromBundle", 205, 6565, 7420);
            Object cl = CallChecker.varInit(AccessController.doPrivileged(new PrivilegedAction<Object>() {
                public Object run() {
                    MethodContext _bcornu_methode_context1565 = new MethodContext(Object.class);
                    try {
                        CallChecker.varInit(this, "this", 209, 7236, 7306);
                        if (CallChecker.beforeDeref(classFromBundle, Class.class, 210, 7269, 7283)) {
                            return CallChecker.isCalled(classFromBundle, Class.class, 210, 7269, 7283).getClassLoader();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Object) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1565.methodEnd();
                    }
                }
            }), "cl", 208, 7158, 7312);
            if (cl instanceof BundleReference) {
                if (CallChecker.beforeDeref(cl, Object.class, 215, 7383, 7384)) {
                    cl = CallChecker.beforeCalled(cl, BundleReference.class, 215, 7383, 7384);
                    return CallChecker.isCalled(((BundleReference) (cl)), BundleReference.class, 215, 7383, 7384).getBundle();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1566.methodEnd();
        }
    }

    private static final class FilterImpl implements Filter {
        private static final int EQUAL = 1;

        private static final int APPROX = 2;

        private static final int GREATER = 3;

        private static final int LESS = 4;

        private static final int PRESENT = 5;

        private static final int SUBSTRING = 6;

        private static final int AND = 7;

        private static final int OR = 8;

        private static final int NOT = 9;

        private final int op;

        private final String attr;

        private final Object value;

        private transient String filterString;

        static FrameworkUtil.FilterImpl newInstance(String filterString) throws InvalidSyntaxException {
            MethodContext _bcornu_methode_context1567 = new MethodContext(FrameworkUtil.FilterImpl.class);
            try {
                CallChecker.varInit(filterString, "filterString", 377, 12999, 13631);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 377, 12999, 13631);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 377, 12999, 13631);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 377, 12999, 13631);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 377, 12999, 13631);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 377, 12999, 13631);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 377, 12999, 13631);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 377, 12999, 13631);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 377, 12999, 13631);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 377, 12999, 13631);
                if (CallChecker.beforeDeref(new FrameworkUtil.FilterImpl.Parser(filterString), FrameworkUtil.FilterImpl.Parser.class, 378, 13595, 13618)) {
                    return CallChecker.isCalled(new FrameworkUtil.FilterImpl.Parser(filterString), FrameworkUtil.FilterImpl.Parser.class, 378, 13595, 13618).parse();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((FrameworkUtil.FilterImpl) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1567.methodEnd();
            }
        }

        FilterImpl(int operation, String attr, Object value) {
            MethodContext _bcornu_methode_context157 = new MethodContext(null);
            try {
                this.op = operation;
                CallChecker.varAssign(this.op, "this.op", 382, 13694, 13713);
                this.attr = attr;
                CallChecker.varAssign(this.attr, "this.attr", 383, 13718, 13734);
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 384, 13739, 13757);
                filterString = null;
                CallChecker.varAssign(this.filterString, "this.filterString", 385, 13762, 13781);
            } finally {
                _bcornu_methode_context157.methodEnd();
            }
        }

        public boolean match(ServiceReference<?> reference) {
            MethodContext _bcornu_methode_context1568 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 400, 13790, 14358);
                CallChecker.varInit(reference, "reference", 400, 13790, 14358);
                CallChecker.varInit(this.filterString, "filterString", 400, 13790, 14358);
                CallChecker.varInit(this.value, "value", 400, 13790, 14358);
                CallChecker.varInit(this.attr, "attr", 400, 13790, 14358);
                CallChecker.varInit(this.op, "op", 400, 13790, 14358);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 400, 13790, 14358);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 400, 13790, 14358);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 400, 13790, 14358);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 400, 13790, 14358);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 400, 13790, 14358);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 400, 13790, 14358);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 400, 13790, 14358);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 400, 13790, 14358);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 400, 13790, 14358);
                return matches(new FrameworkUtil.ServiceReferenceMap(reference));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1568.methodEnd();
            }
        }

        public boolean match(Dictionary<String, ?> dictionary) {
            MethodContext _bcornu_methode_context1569 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 417, 14363, 15065);
                CallChecker.varInit(dictionary, "dictionary", 417, 14363, 15065);
                CallChecker.varInit(this.filterString, "filterString", 417, 14363, 15065);
                CallChecker.varInit(this.value, "value", 417, 14363, 15065);
                CallChecker.varInit(this.attr, "attr", 417, 14363, 15065);
                CallChecker.varInit(this.op, "op", 417, 14363, 15065);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 417, 14363, 15065);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 417, 14363, 15065);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 417, 14363, 15065);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 417, 14363, 15065);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 417, 14363, 15065);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 417, 14363, 15065);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 417, 14363, 15065);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 417, 14363, 15065);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 417, 14363, 15065);
                return matches(new FrameworkUtil.CaseInsensitiveMap(dictionary));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1569.methodEnd();
            }
        }

        public boolean matchCase(Dictionary<String, ?> dictionary) {
            MethodContext _bcornu_methode_context1570 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 432, 15070, 16474);
                CallChecker.varInit(dictionary, "dictionary", 432, 15070, 16474);
                CallChecker.varInit(this.filterString, "filterString", 432, 15070, 16474);
                CallChecker.varInit(this.value, "value", 432, 15070, 16474);
                CallChecker.varInit(this.attr, "attr", 432, 15070, 16474);
                CallChecker.varInit(this.op, "op", 432, 15070, 16474);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 432, 15070, 16474);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 432, 15070, 16474);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 432, 15070, 16474);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 432, 15070, 16474);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 432, 15070, 16474);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 432, 15070, 16474);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 432, 15070, 16474);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 432, 15070, 16474);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 432, 15070, 16474);
                switch (op) {
                    case FrameworkUtil.FilterImpl.AND :
                        {
                            FrameworkUtil.FilterImpl[] filters = CallChecker.varInit(((FrameworkUtil.FilterImpl[]) (value)), "filters", 435, 15624, 15667);
                            if (CallChecker.beforeDeref(filters, boolean.class, 436, 15694, 15700)) {
                                for (FrameworkUtil.FilterImpl f : filters) {
                                    if (CallChecker.beforeDeref(f, FrameworkUtil.FilterImpl.class, 437, 15716, 15716)) {
                                        if (!(CallChecker.isCalled(f, FrameworkUtil.FilterImpl.class, 437, 15716, 15716).matchCase(dictionary))) {
                                            return false;
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                            return true;
                        }
                    case FrameworkUtil.FilterImpl.OR :
                        {
                            FrameworkUtil.FilterImpl[] filters = CallChecker.varInit(((FrameworkUtil.FilterImpl[]) (value)), "filters", 445, 15825, 15868);
                            if (CallChecker.beforeDeref(filters, boolean.class, 446, 15895, 15901)) {
                                for (FrameworkUtil.FilterImpl f : filters) {
                                    if (CallChecker.beforeDeref(f, FrameworkUtil.FilterImpl.class, 447, 15916, 15916)) {
                                        if (CallChecker.isCalled(f, FrameworkUtil.FilterImpl.class, 447, 15916, 15916).matchCase(dictionary)) {
                                            return true;
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                            return false;
                        }
                    case FrameworkUtil.FilterImpl.NOT :
                        {
                            FrameworkUtil.FilterImpl filter = CallChecker.varInit(((FrameworkUtil.FilterImpl) (value)), "filter", 455, 16026, 16064);
                            if (CallChecker.beforeDeref(filter, FrameworkUtil.FilterImpl.class, 456, 16079, 16084)) {
                                filter = CallChecker.beforeCalled(filter, FrameworkUtil.FilterImpl.class, 456, 16079, 16084);
                                return !(CallChecker.isCalled(filter, FrameworkUtil.FilterImpl.class, 456, 16079, 16084).matchCase(dictionary));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    case FrameworkUtil.FilterImpl.SUBSTRING :
                    case FrameworkUtil.FilterImpl.EQUAL :
                    case FrameworkUtil.FilterImpl.GREATER :
                    case FrameworkUtil.FilterImpl.LESS :
                    case FrameworkUtil.FilterImpl.APPROX :
                        {
                            Object prop = CallChecker.init(Object.class);
                            if (dictionary == null) {
                                prop = null;
                                CallChecker.varAssign(prop, "prop", 464, 16228, 16277);
                            }else {
                                prop = dictionary.get(attr);
                                CallChecker.varAssign(prop, "prop", 464, 16228, 16277);
                            }
                            return compare(op, prop, value);
                        }
                    case FrameworkUtil.FilterImpl.PRESENT :
                        {
                            Object prop = CallChecker.init(Object.class);
                            if (dictionary == null) {
                                prop = null;
                                CallChecker.varAssign(prop, "prop", 469, 16365, 16414);
                            }else {
                                prop = dictionary.get(attr);
                                CallChecker.varAssign(prop, "prop", 469, 16365, 16414);
                            }
                            return prop != null;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1570.methodEnd();
            }
        }

        public boolean matches(Map<String, ?> map) {
            MethodContext _bcornu_methode_context1571 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 489, 16479, 17907);
                CallChecker.varInit(map, "map", 489, 16479, 17907);
                CallChecker.varInit(this.filterString, "filterString", 489, 16479, 17907);
                CallChecker.varInit(this.value, "value", 489, 16479, 17907);
                CallChecker.varInit(this.attr, "attr", 489, 16479, 17907);
                CallChecker.varInit(this.op, "op", 489, 16479, 17907);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 489, 16479, 17907);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 489, 16479, 17907);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 489, 16479, 17907);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 489, 16479, 17907);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 489, 16479, 17907);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 489, 16479, 17907);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 489, 16479, 17907);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 489, 16479, 17907);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 489, 16479, 17907);
                switch (op) {
                    case FrameworkUtil.FilterImpl.AND :
                        {
                            FrameworkUtil.FilterImpl[] filters = CallChecker.varInit(((FrameworkUtil.FilterImpl[]) (value)), "filters", 492, 17112, 17155);
                            if (CallChecker.beforeDeref(filters, boolean.class, 493, 17182, 17188)) {
                                for (FrameworkUtil.FilterImpl f : filters) {
                                    if (CallChecker.beforeDeref(f, FrameworkUtil.FilterImpl.class, 494, 17204, 17204)) {
                                        if (!(CallChecker.isCalled(f, FrameworkUtil.FilterImpl.class, 494, 17204, 17204).matches(map))) {
                                            return false;
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                            return true;
                        }
                    case FrameworkUtil.FilterImpl.OR :
                        {
                            FrameworkUtil.FilterImpl[] filters = CallChecker.varInit(((FrameworkUtil.FilterImpl[]) (value)), "filters", 502, 17304, 17347);
                            if (CallChecker.beforeDeref(filters, boolean.class, 503, 17374, 17380)) {
                                for (FrameworkUtil.FilterImpl f : filters) {
                                    if (CallChecker.beforeDeref(f, FrameworkUtil.FilterImpl.class, 504, 17395, 17395)) {
                                        if (CallChecker.isCalled(f, FrameworkUtil.FilterImpl.class, 504, 17395, 17395).matches(map)) {
                                            return true;
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                            return false;
                        }
                    case FrameworkUtil.FilterImpl.NOT :
                        {
                            FrameworkUtil.FilterImpl filter = CallChecker.varInit(((FrameworkUtil.FilterImpl) (value)), "filter", 512, 17496, 17534);
                            if (CallChecker.beforeDeref(filter, FrameworkUtil.FilterImpl.class, 513, 17549, 17554)) {
                                filter = CallChecker.beforeCalled(filter, FrameworkUtil.FilterImpl.class, 513, 17549, 17554);
                                return !(CallChecker.isCalled(filter, FrameworkUtil.FilterImpl.class, 513, 17549, 17554).matches(map));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    case FrameworkUtil.FilterImpl.SUBSTRING :
                    case FrameworkUtil.FilterImpl.EQUAL :
                    case FrameworkUtil.FilterImpl.GREATER :
                    case FrameworkUtil.FilterImpl.LESS :
                    case FrameworkUtil.FilterImpl.APPROX :
                        {
                            Object prop = CallChecker.init(Object.class);
                            if (map == null) {
                                prop = null;
                                CallChecker.varAssign(prop, "prop", 521, 17689, 17724);
                            }else {
                                prop = map.get(attr);
                                CallChecker.varAssign(prop, "prop", 521, 17689, 17724);
                            }
                            return compare(op, prop, value);
                        }
                    case FrameworkUtil.FilterImpl.PRESENT :
                        {
                            Object prop = CallChecker.init(Object.class);
                            if (map == null) {
                                prop = null;
                                CallChecker.varAssign(prop, "prop", 526, 17812, 17847);
                            }else {
                                prop = map.get(attr);
                                CallChecker.varAssign(prop, "prop", 526, 17812, 17847);
                            }
                            return prop != null;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1571.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context1572 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 543, 17912, 18327);
                CallChecker.varInit(this.filterString, "filterString", 543, 17912, 18327);
                CallChecker.varInit(this.value, "value", 543, 17912, 18327);
                CallChecker.varInit(this.attr, "attr", 543, 17912, 18327);
                CallChecker.varInit(this.op, "op", 543, 17912, 18327);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 543, 17912, 18327);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 543, 17912, 18327);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 543, 17912, 18327);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 543, 17912, 18327);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 543, 17912, 18327);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 543, 17912, 18327);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 543, 17912, 18327);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 543, 17912, 18327);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 543, 17912, 18327);
                String result = CallChecker.varInit(filterString, "result", 544, 18195, 18223);
                if (result == null) {
                    final StringBuffer npe_invocation_var535 = normalize();
                    if (CallChecker.beforeDeref(npe_invocation_var535, StringBuffer.class, 546, 18278, 18288)) {
                        filterString = result = CallChecker.isCalled(npe_invocation_var535, StringBuffer.class, 546, 18278, 18288).toString();
                        CallChecker.varAssign(this.filterString, "this.filterString", 546, 18254, 18300);
                        CallChecker.varAssign(result, "result", 546, 18269, 18299);
                    }
                }
                return result;
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1572.methodEnd();
            }
        }

        private StringBuffer normalize() {
            MethodContext _bcornu_methode_context1573 = new MethodContext(StringBuffer.class);
            try {
                CallChecker.varInit(this, "this", 559, 18332, 20161);
                CallChecker.varInit(this.filterString, "filterString", 559, 18332, 20161);
                CallChecker.varInit(this.value, "value", 559, 18332, 20161);
                CallChecker.varInit(this.attr, "attr", 559, 18332, 20161);
                CallChecker.varInit(this.op, "op", 559, 18332, 20161);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 559, 18332, 20161);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 559, 18332, 20161);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 559, 18332, 20161);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 559, 18332, 20161);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 559, 18332, 20161);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 559, 18332, 20161);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 559, 18332, 20161);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 559, 18332, 20161);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 559, 18332, 20161);
                StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 560, 18622, 18658);
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 561, 18663, 18664)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 561, 18663, 18664);
                    CallChecker.isCalled(sb, StringBuffer.class, 561, 18663, 18664).append('(');
                }
                switch (op) {
                    case FrameworkUtil.FilterImpl.AND :
                        {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 565, 18719, 18720)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 565, 18719, 18720);
                                CallChecker.isCalled(sb, StringBuffer.class, 565, 18719, 18720).append('&');
                            }
                            FrameworkUtil.FilterImpl[] filters = CallChecker.varInit(((FrameworkUtil.FilterImpl[]) (value)), "filters", 567, 18741, 18784);
                            if (CallChecker.beforeDeref(filters, StringBuffer.class, 568, 18811, 18817)) {
                                for (FrameworkUtil.FilterImpl f : filters) {
                                    if (CallChecker.beforeDeref(f, FrameworkUtil.FilterImpl.class, 569, 18838, 18838)) {
                                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 569, 18828, 18829)) {
                                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 569, 18828, 18829);
                                            CallChecker.isCalled(sb, StringBuffer.class, 569, 18828, 18829).append(CallChecker.isCalled(f, FrameworkUtil.FilterImpl.class, 569, 18838, 18838).normalize());
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    case FrameworkUtil.FilterImpl.OR :
                        {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 576, 18902, 18903)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 576, 18902, 18903);
                                CallChecker.isCalled(sb, StringBuffer.class, 576, 18902, 18903).append('|');
                            }
                            FrameworkUtil.FilterImpl[] filters = CallChecker.varInit(((FrameworkUtil.FilterImpl[]) (value)), "filters", 578, 18924, 18967);
                            if (CallChecker.beforeDeref(filters, StringBuffer.class, 579, 18994, 19000)) {
                                for (FrameworkUtil.FilterImpl f : filters) {
                                    if (CallChecker.beforeDeref(f, FrameworkUtil.FilterImpl.class, 580, 19021, 19021)) {
                                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 580, 19011, 19012)) {
                                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 580, 19011, 19012);
                                            CallChecker.isCalled(sb, StringBuffer.class, 580, 19011, 19012).append(CallChecker.isCalled(f, FrameworkUtil.FilterImpl.class, 580, 19021, 19021).normalize());
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    case FrameworkUtil.FilterImpl.NOT :
                        {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 587, 19086, 19087)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 587, 19086, 19087);
                                CallChecker.isCalled(sb, StringBuffer.class, 587, 19086, 19087).append('!');
                            }
                            FrameworkUtil.FilterImpl filter = CallChecker.varInit(((FrameworkUtil.FilterImpl) (value)), "filter", 588, 19107, 19145);
                            if (CallChecker.beforeDeref(filter, FrameworkUtil.FilterImpl.class, 589, 19162, 19167)) {
                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 589, 19152, 19153)) {
                                    filter = CallChecker.beforeCalled(filter, FrameworkUtil.FilterImpl.class, 589, 19162, 19167);
                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 589, 19152, 19153);
                                    CallChecker.isCalled(sb, StringBuffer.class, 589, 19152, 19153).append(CallChecker.isCalled(filter, FrameworkUtil.FilterImpl.class, 589, 19162, 19167).normalize());
                                }
                            }
                            break;
                        }
                    case FrameworkUtil.FilterImpl.SUBSTRING :
                        {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 595, 19231, 19232)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 595, 19231, 19232);
                                CallChecker.isCalled(sb, StringBuffer.class, 595, 19231, 19232).append(attr);
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 596, 19253, 19254)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 596, 19253, 19254);
                                CallChecker.isCalled(sb, StringBuffer.class, 596, 19253, 19254).append('=');
                            }
                            String[] substrings = CallChecker.varInit(((String[]) (value)), "substrings", 598, 19275, 19313);
                            if (CallChecker.beforeDeref(substrings, StringBuffer.class, 600, 19342, 19351)) {
                                for (String substr : substrings) {
                                    if (substr == null) {
                                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 602, 19398, 19399)) {
                                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 602, 19398, 19399);
                                            CallChecker.isCalled(sb, StringBuffer.class, 602, 19398, 19399).append('*');
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 604, 19445, 19446)) {
                                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 604, 19445, 19446);
                                            CallChecker.isCalled(sb, StringBuffer.class, 604, 19445, 19446).append(FrameworkUtil.FilterImpl.encodeValue(substr));
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    case FrameworkUtil.FilterImpl.EQUAL :
                        {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 611, 19535, 19536)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 611, 19535, 19536);
                                CallChecker.isCalled(sb, StringBuffer.class, 611, 19535, 19536).append(attr);
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 612, 19557, 19558)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 612, 19557, 19558);
                                CallChecker.isCalled(sb, StringBuffer.class, 612, 19557, 19558).append('=');
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 613, 19578, 19579)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 613, 19578, 19579);
                                CallChecker.isCalled(sb, StringBuffer.class, 613, 19578, 19579).append(FrameworkUtil.FilterImpl.encodeValue(((String) (value))));
                            }
                            break;
                        }
                    case FrameworkUtil.FilterImpl.GREATER :
                        {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 618, 19663, 19664)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 618, 19663, 19664);
                                CallChecker.isCalled(sb, StringBuffer.class, 618, 19663, 19664).append(attr);
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 619, 19685, 19686)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 619, 19685, 19686);
                                CallChecker.isCalled(sb, StringBuffer.class, 619, 19685, 19686).append(">=");
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 620, 19707, 19708)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 620, 19707, 19708);
                                CallChecker.isCalled(sb, StringBuffer.class, 620, 19707, 19708).append(FrameworkUtil.FilterImpl.encodeValue(((String) (value))));
                            }
                            break;
                        }
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 625, 19789, 19790)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 625, 19789, 19790);
                                CallChecker.isCalled(sb, StringBuffer.class, 625, 19789, 19790).append(attr);
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 626, 19811, 19812)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 626, 19811, 19812);
                                CallChecker.isCalled(sb, StringBuffer.class, 626, 19811, 19812).append("<=");
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 627, 19833, 19834)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 627, 19833, 19834);
                                CallChecker.isCalled(sb, StringBuffer.class, 627, 19833, 19834).append(FrameworkUtil.FilterImpl.encodeValue(((String) (value))));
                            }
                            break;
                        }
                    case FrameworkUtil.FilterImpl.APPROX :
                        {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 632, 19917, 19918)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 632, 19917, 19918);
                                CallChecker.isCalled(sb, StringBuffer.class, 632, 19917, 19918).append(attr);
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 633, 19939, 19940)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 633, 19939, 19940);
                                CallChecker.isCalled(sb, StringBuffer.class, 633, 19939, 19940).append("~=");
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 634, 19961, 19962)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 634, 19961, 19962);
                                CallChecker.isCalled(sb, StringBuffer.class, 634, 19961, 19962).append(FrameworkUtil.FilterImpl.encodeValue(FrameworkUtil.FilterImpl.approxString(((String) (value)))));
                            }
                            break;
                        }
                    case FrameworkUtil.FilterImpl.PRESENT :
                        {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 640, 20061, 20062)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 640, 20061, 20062);
                                CallChecker.isCalled(sb, StringBuffer.class, 640, 20061, 20062).append(attr);
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 641, 20083, 20084)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 641, 20083, 20084);
                                CallChecker.isCalled(sb, StringBuffer.class, 641, 20083, 20084).append("=*");
                            }
                            break;
                        }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 647, 20128, 20129)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 647, 20128, 20129);
                    CallChecker.isCalled(sb, StringBuffer.class, 647, 20128, 20129).append(')');
                }
                return sb;
            } catch (ForceReturn _bcornu_return_t) {
                return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1573.methodEnd();
            }
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context1574 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 666, 20166, 20845);
                CallChecker.varInit(obj, "obj", 666, 20166, 20845);
                CallChecker.varInit(this.filterString, "filterString", 666, 20166, 20845);
                CallChecker.varInit(this.value, "value", 666, 20166, 20845);
                CallChecker.varInit(this.attr, "attr", 666, 20166, 20845);
                CallChecker.varInit(this.op, "op", 666, 20166, 20845);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 666, 20166, 20845);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 666, 20166, 20845);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 666, 20166, 20845);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 666, 20166, 20845);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 666, 20166, 20845);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 666, 20166, 20845);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 666, 20166, 20845);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 666, 20166, 20845);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 666, 20166, 20845);
                if (obj == (this)) {
                    return true;
                }
                if (!(obj instanceof Filter)) {
                    return false;
                }
                if (CallChecker.beforeDeref(obj, Object.class, 675, 20826, 20828)) {
                    final String npe_invocation_var536 = this.toString();
                    if (CallChecker.beforeDeref(npe_invocation_var536, String.class, 675, 20803, 20817)) {
                        obj = CallChecker.beforeCalled(obj, Object.class, 675, 20826, 20828);
                        return CallChecker.isCalled(npe_invocation_var536, String.class, 675, 20803, 20817).equals(CallChecker.isCalled(obj, Object.class, 675, 20826, 20828).toString());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1574.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context1575 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 688, 20850, 21156);
                CallChecker.varInit(this.filterString, "filterString", 688, 20850, 21156);
                CallChecker.varInit(this.value, "value", 688, 20850, 21156);
                CallChecker.varInit(this.attr, "attr", 688, 20850, 21156);
                CallChecker.varInit(this.op, "op", 688, 20850, 21156);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 688, 20850, 21156);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 688, 20850, 21156);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 688, 20850, 21156);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 688, 20850, 21156);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 688, 20850, 21156);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 688, 20850, 21156);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 688, 20850, 21156);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 688, 20850, 21156);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 688, 20850, 21156);
                final String npe_invocation_var537 = this.toString();
                if (CallChecker.beforeDeref(npe_invocation_var537, String.class, 689, 21126, 21140)) {
                    return CallChecker.isCalled(npe_invocation_var537, String.class, 689, 21126, 21140).hashCode();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1575.methodEnd();
            }
        }

        private static String encodeValue(String value) {
            MethodContext _bcornu_methode_context1576 = new MethodContext(String.class);
            try {
                CallChecker.varInit(value, "value", 698, 21161, 21934);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 698, 21161, 21934);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 698, 21161, 21934);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 698, 21161, 21934);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 698, 21161, 21934);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 698, 21161, 21934);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 698, 21161, 21934);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 698, 21161, 21934);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 698, 21161, 21934);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 698, 21161, 21934);
                boolean encoded = CallChecker.varInit(((boolean) (false)), "encoded", 699, 21383, 21406);
                int inlen = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(value, String.class, 700, 21423, 21427)) {
                    value = CallChecker.beforeCalled(value, String.class, 700, 21423, 21427);
                    inlen = CallChecker.isCalled(value, String.class, 700, 21423, 21427).length();
                    CallChecker.varAssign(inlen, "inlen", 700, 21423, 21427);
                }
                int outlen = CallChecker.varInit(((int) (inlen << 1)), "outlen", 701, 21442, 21465);
                char[] output = CallChecker.varInit(new char[outlen], "output", 703, 21485, 21517);
                if (CallChecker.beforeDeref(value, String.class, 704, 21522, 21526)) {
                    value = CallChecker.beforeCalled(value, String.class, 704, 21522, 21526);
                    CallChecker.isCalled(value, String.class, 704, 21522, 21526).getChars(0, inlen, output, inlen);
                }
                int cursor = CallChecker.varInit(((int) (0)), "cursor", 706, 21567, 21581);
                for (int i = inlen; i < outlen; i++) {
                    char c = CallChecker.init(char.class);
                    if (CallChecker.beforeDeref(output, char[].class, 708, 21638, 21643)) {
                        output = CallChecker.beforeCalled(output, char[].class, 708, 21638, 21643);
                        c = CallChecker.isCalled(output, char[].class, 708, 21638, 21643)[i];
                        CallChecker.varAssign(c, "c", 708, 21638, 21643);
                    }
                    switch (c) {
                        case '(' :
                        case '*' :
                        case ')' :
                        case '\\' :
                            {
                                if (CallChecker.beforeDeref(output, char[].class, 715, 21740, 21745)) {
                                    output = CallChecker.beforeCalled(output, char[].class, 715, 21740, 21745);
                                    CallChecker.isCalled(output, char[].class, 715, 21740, 21745)[cursor] = '\\';
                                    CallChecker.varAssign(CallChecker.isCalled(output, char[].class, 715, 21740, 21745)[cursor], "CallChecker.isCalled(output, char[].class, 715, 21740, 21745)[cursor]", 715, 21740, 21761);
                                }
                                cursor++;
                                encoded = true;
                                CallChecker.varAssign(encoded, "encoded", 717, 21785, 21799);
                                break;
                            }
                    }
                    if (CallChecker.beforeDeref(output, char[].class, 723, 21833, 21838)) {
                        output = CallChecker.beforeCalled(output, char[].class, 723, 21833, 21838);
                        CallChecker.isCalled(output, char[].class, 723, 21833, 21838)[cursor] = c;
                        CallChecker.varAssign(CallChecker.isCalled(output, char[].class, 723, 21833, 21838)[cursor], "CallChecker.isCalled(output, char[].class, 723, 21833, 21838)[cursor]", 723, 21833, 21851);
                    }
                    cursor++;
                }
                if (encoded) {
                    return new String(output, 0, cursor);
                }else {
                    return value;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1576.methodEnd();
            }
        }

        private boolean compare(int operation, Object value1, Object value2) {
            MethodContext _bcornu_methode_context1577 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 730, 21939, 23778);
                CallChecker.varInit(value2, "value2", 730, 21939, 23778);
                CallChecker.varInit(value1, "value1", 730, 21939, 23778);
                CallChecker.varInit(operation, "operation", 730, 21939, 23778);
                CallChecker.varInit(this.filterString, "filterString", 730, 21939, 23778);
                CallChecker.varInit(this.value, "value", 730, 21939, 23778);
                CallChecker.varInit(this.attr, "attr", 730, 21939, 23778);
                CallChecker.varInit(this.op, "op", 730, 21939, 23778);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 730, 21939, 23778);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 730, 21939, 23778);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 730, 21939, 23778);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 730, 21939, 23778);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 730, 21939, 23778);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 730, 21939, 23778);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 730, 21939, 23778);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 730, 21939, 23778);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 730, 21939, 23778);
                if (value1 == null) {
                    return false;
                }
                if (value1 instanceof String) {
                    return compare_String(operation, ((String) (value1)), value2);
                }
                Class<?> clazz = CallChecker.varInit(value1.getClass(), "clazz", 738, 22165, 22199);
                if (CallChecker.beforeDeref(clazz, Class.class, 739, 22208, 22212)) {
                    clazz = CallChecker.beforeCalled(clazz, Class.class, 739, 22208, 22212);
                    if (CallChecker.isCalled(clazz, Class.class, 739, 22208, 22212).isArray()) {
                        Class<?> type = CallChecker.init(Class.class);
                        if (CallChecker.beforeDeref(clazz, Class.class, 740, 22247, 22251)) {
                            clazz = CallChecker.beforeCalled(clazz, Class.class, 740, 22247, 22251);
                            type = CallChecker.isCalled(clazz, Class.class, 740, 22247, 22251).getComponentType();
                            CallChecker.varAssign(type, "type", 740, 22247, 22251);
                        }
                        if (CallChecker.beforeDeref(type, Class.class, 741, 22281, 22284)) {
                            type = CallChecker.beforeCalled(type, Class.class, 741, 22281, 22284);
                            if (CallChecker.isCalled(type, Class.class, 741, 22281, 22284).isPrimitive()) {
                                return compare_PrimitiveArray(operation, type, value1, value2);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        return compare_ObjectArray(operation, ((Object[]) (value1)), value2);
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (value1 instanceof Collection<?>) {
                    return compare_Collection(operation, ((Collection<?>) (value1)), value2);
                }
                if (value1 instanceof Integer) {
                    return compare_Integer(operation, ((Integer) (value1)).intValue(), value2);
                }
                if (value1 instanceof Long) {
                    return compare_Long(operation, ((Long) (value1)).longValue(), value2);
                }
                if (value1 instanceof Byte) {
                    return compare_Byte(operation, ((Byte) (value1)).byteValue(), value2);
                }
                if (value1 instanceof Short) {
                    return compare_Short(operation, ((Short) (value1)).shortValue(), value2);
                }
                if (value1 instanceof Character) {
                    return compare_Character(operation, ((Character) (value1)).charValue(), value2);
                }
                if (value1 instanceof Float) {
                    return compare_Float(operation, ((Float) (value1)).floatValue(), value2);
                }
                if (value1 instanceof Double) {
                    return compare_Double(operation, ((Double) (value1)).doubleValue(), value2);
                }
                if (value1 instanceof Boolean) {
                    return compare_Boolean(operation, ((Boolean) (value1)).booleanValue(), value2);
                }
                if (value1 instanceof Comparable<?>) {
                    @SuppressWarnings(value = "unchecked")
                    Comparable<Object> comparable = CallChecker.varInit(((Comparable<Object>) (value1)), "comparable", 775, 23559, 23653);
                    return compare_Comparable(operation, comparable, value2);
                }
                return compare_Unknown(operation, value1, value2);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1577.methodEnd();
            }
        }

        private boolean compare_Collection(int operation, Collection<?> collection, Object value2) {
            MethodContext _bcornu_methode_context1578 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 781, 23783, 24008);
                CallChecker.varInit(value2, "value2", 781, 23783, 24008);
                CallChecker.varInit(collection, "collection", 781, 23783, 24008);
                CallChecker.varInit(operation, "operation", 781, 23783, 24008);
                CallChecker.varInit(this.filterString, "filterString", 781, 23783, 24008);
                CallChecker.varInit(this.value, "value", 781, 23783, 24008);
                CallChecker.varInit(this.attr, "attr", 781, 23783, 24008);
                CallChecker.varInit(this.op, "op", 781, 23783, 24008);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 781, 23783, 24008);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 781, 23783, 24008);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 781, 23783, 24008);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 781, 23783, 24008);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 781, 23783, 24008);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 781, 23783, 24008);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 781, 23783, 24008);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 781, 23783, 24008);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 781, 23783, 24008);
                if (CallChecker.beforeDeref(collection, boolean.class, 782, 23900, 23909)) {
                    for (Object value1 : collection) {
                        if (compare(operation, value1, value2)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1578.methodEnd();
            }
        }

        private boolean compare_ObjectArray(int operation, Object[] array, Object value2) {
            MethodContext _bcornu_methode_context1579 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 790, 24013, 24224);
                CallChecker.varInit(value2, "value2", 790, 24013, 24224);
                CallChecker.varInit(array, "array", 790, 24013, 24224);
                CallChecker.varInit(operation, "operation", 790, 24013, 24224);
                CallChecker.varInit(this.filterString, "filterString", 790, 24013, 24224);
                CallChecker.varInit(this.value, "value", 790, 24013, 24224);
                CallChecker.varInit(this.attr, "attr", 790, 24013, 24224);
                CallChecker.varInit(this.op, "op", 790, 24013, 24224);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 790, 24013, 24224);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 790, 24013, 24224);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 790, 24013, 24224);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 790, 24013, 24224);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 790, 24013, 24224);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 790, 24013, 24224);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 790, 24013, 24224);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 790, 24013, 24224);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 790, 24013, 24224);
                if (CallChecker.beforeDeref(array, boolean.class, 791, 24121, 24125)) {
                    for (Object value1 : array) {
                        if (compare(operation, value1, value2)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1579.methodEnd();
            }
        }

        private boolean compare_PrimitiveArray(int operation, Class<?> type, Object primarray, Object value2) {
            MethodContext _bcornu_methode_context1580 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 799, 24229, 26168);
                CallChecker.varInit(value2, "value2", 799, 24229, 26168);
                CallChecker.varInit(primarray, "primarray", 799, 24229, 26168);
                CallChecker.varInit(type, "type", 799, 24229, 26168);
                CallChecker.varInit(operation, "operation", 799, 24229, 26168);
                CallChecker.varInit(this.filterString, "filterString", 799, 24229, 26168);
                CallChecker.varInit(this.value, "value", 799, 24229, 26168);
                CallChecker.varInit(this.attr, "attr", 799, 24229, 26168);
                CallChecker.varInit(this.op, "op", 799, 24229, 26168);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 799, 24229, 26168);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 799, 24229, 26168);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 799, 24229, 26168);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 799, 24229, 26168);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 799, 24229, 26168);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 799, 24229, 26168);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 799, 24229, 26168);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 799, 24229, 26168);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 799, 24229, 26168);
                if (CallChecker.beforeDeref(Integer.TYPE, Class.class, 800, 24340, 24351)) {
                    if (CallChecker.isCalled(Integer.TYPE, Class.class, 800, 24340, 24351).isAssignableFrom(type)) {
                        int[] array = CallChecker.varInit(((int[]) (primarray)), "array", 801, 24383, 24414);
                        if (CallChecker.beforeDeref(array, boolean.class, 802, 24438, 24442)) {
                            for (int value1 : array) {
                                if (compare_Integer(operation, value1, value2)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Long.TYPE, Class.class, 809, 24564, 24572)) {
                    if (CallChecker.isCalled(Long.TYPE, Class.class, 809, 24564, 24572).isAssignableFrom(type)) {
                        long[] array = CallChecker.varInit(((long[]) (primarray)), "array", 810, 24604, 24637);
                        if (CallChecker.beforeDeref(array, boolean.class, 811, 24662, 24666)) {
                            for (long value1 : array) {
                                if (compare_Long(operation, value1, value2)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Byte.TYPE, Class.class, 818, 24785, 24793)) {
                    if (CallChecker.isCalled(Byte.TYPE, Class.class, 818, 24785, 24793).isAssignableFrom(type)) {
                        byte[] array = CallChecker.varInit(((byte[]) (primarray)), "array", 819, 24825, 24858);
                        if (CallChecker.beforeDeref(array, boolean.class, 820, 24883, 24887)) {
                            for (byte value1 : array) {
                                if (compare_Byte(operation, value1, value2)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Short.TYPE, Class.class, 827, 25006, 25015)) {
                    if (CallChecker.isCalled(Short.TYPE, Class.class, 827, 25006, 25015).isAssignableFrom(type)) {
                        short[] array = CallChecker.varInit(((short[]) (primarray)), "array", 828, 25047, 25082);
                        if (CallChecker.beforeDeref(array, boolean.class, 829, 25108, 25112)) {
                            for (short value1 : array) {
                                if (compare_Short(operation, value1, value2)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Character.TYPE, Class.class, 836, 25232, 25245)) {
                    if (CallChecker.isCalled(Character.TYPE, Class.class, 836, 25232, 25245).isAssignableFrom(type)) {
                        char[] array = CallChecker.varInit(((char[]) (primarray)), "array", 837, 25277, 25310);
                        if (CallChecker.beforeDeref(array, boolean.class, 838, 25335, 25339)) {
                            for (char value1 : array) {
                                if (compare_Character(operation, value1, value2)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Float.TYPE, Class.class, 845, 25463, 25472)) {
                    if (CallChecker.isCalled(Float.TYPE, Class.class, 845, 25463, 25472).isAssignableFrom(type)) {
                        float[] array = CallChecker.varInit(((float[]) (primarray)), "array", 846, 25504, 25539);
                        if (CallChecker.beforeDeref(array, boolean.class, 847, 25565, 25569)) {
                            for (float value1 : array) {
                                if (compare_Float(operation, value1, value2)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Double.TYPE, Class.class, 854, 25689, 25699)) {
                    if (CallChecker.isCalled(Double.TYPE, Class.class, 854, 25689, 25699).isAssignableFrom(type)) {
                        double[] array = CallChecker.varInit(((double[]) (primarray)), "array", 855, 25731, 25768);
                        if (CallChecker.beforeDeref(array, boolean.class, 856, 25795, 25799)) {
                            for (double value1 : array) {
                                if (compare_Double(operation, value1, value2)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Boolean.TYPE, Class.class, 863, 25920, 25931)) {
                    if (CallChecker.isCalled(Boolean.TYPE, Class.class, 863, 25920, 25931).isAssignableFrom(type)) {
                        boolean[] array = CallChecker.varInit(((boolean[]) (primarray)), "array", 864, 25963, 26002);
                        if (CallChecker.beforeDeref(array, boolean.class, 865, 26030, 26034)) {
                            for (boolean value1 : array) {
                                if (compare_Boolean(operation, value1, value2)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1580.methodEnd();
            }
        }

        private boolean compare_String(int operation, String string, Object value2) {
            MethodContext _bcornu_methode_context1581 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 875, 26173, 27869);
                CallChecker.varInit(value2, "value2", 875, 26173, 27869);
                CallChecker.varInit(string, "string", 875, 26173, 27869);
                CallChecker.varInit(operation, "operation", 875, 26173, 27869);
                CallChecker.varInit(this.filterString, "filterString", 875, 26173, 27869);
                CallChecker.varInit(this.value, "value", 875, 26173, 27869);
                CallChecker.varInit(this.attr, "attr", 875, 26173, 27869);
                CallChecker.varInit(this.op, "op", 875, 26173, 27869);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 875, 26173, 27869);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 875, 26173, 27869);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 875, 26173, 27869);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 875, 26173, 27869);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 875, 26173, 27869);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 875, 26173, 27869);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 875, 26173, 27869);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 875, 26173, 27869);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 875, 26173, 27869);
                switch (operation) {
                    case FrameworkUtil.FilterImpl.SUBSTRING :
                        {
                            String[] substrings = CallChecker.varInit(((String[]) (value2)), "substrings", 878, 26303, 26342);
                            int pos = CallChecker.varInit(((int) (0)), "pos", 879, 26349, 26360);
                            substrings = CallChecker.beforeCalled(substrings, String[].class, 880, 26390, 26399);
                            for (int i = 0, size = CallChecker.isCalled(substrings, String[].class, 880, 26390, 26399).length; i < size; i++) {
                                String substr = CallChecker.init(String.class);
                                if (CallChecker.beforeDeref(substrings, String[].class, 881, 26448, 26457)) {
                                    substrings = CallChecker.beforeCalled(substrings, String[].class, 881, 26448, 26457);
                                    substr = CallChecker.isCalled(substrings, String[].class, 881, 26448, 26457)[i];
                                    CallChecker.varAssign(substr, "substr", 881, 26448, 26457);
                                }
                                if ((i + 1) < size) {
                                    if (substr == null) {
                                        String substr2 = CallChecker.init(String.class);
                                        if (CallChecker.beforeDeref(substrings, String[].class, 885, 26588, 26597)) {
                                            substrings = CallChecker.beforeCalled(substrings, String[].class, 885, 26588, 26597);
                                            substr2 = CallChecker.isCalled(substrings, String[].class, 885, 26588, 26597)[(i + 1)];
                                            CallChecker.varAssign(substr2, "substr2", 885, 26588, 26597);
                                        }
                                        if (substr2 == null)
                                            continue;
                                        
                                        int index = CallChecker.init(int.class);
                                        if (CallChecker.beforeDeref(string, String.class, 890, 26727, 26732)) {
                                            string = CallChecker.beforeCalled(string, String.class, 890, 26727, 26732);
                                            index = CallChecker.isCalled(string, String.class, 890, 26727, 26732).indexOf(substr2, pos);
                                            CallChecker.varAssign(index, "index", 890, 26727, 26732);
                                        }
                                        if (index == (-1)) {
                                            return false;
                                        }
                                        if (CallChecker.beforeDeref(substr2, String.class, 895, 26840, 26846)) {
                                            substr2 = CallChecker.beforeCalled(substr2, String.class, 895, 26840, 26846);
                                            pos = index + (CallChecker.isCalled(substr2, String.class, 895, 26840, 26846).length());
                                            CallChecker.varAssign(pos, "pos", 895, 26826, 26856);
                                        }
                                        if ((i + 2) < size)
                                            i++;
                                        
                                    }else {
                                        int len = CallChecker.varInit(((int) (substr.length())), "len", 904, 27110, 27135);
                                        if (CallChecker.beforeDeref(string, String.class, 905, 27149, 27154)) {
                                            string = CallChecker.beforeCalled(string, String.class, 905, 27149, 27154);
                                            if (CallChecker.isCalled(string, String.class, 905, 27149, 27154).regionMatches(pos, substr, 0, len)) {
                                                pos += len;
                                                CallChecker.varAssign(pos, "pos", 906, 27203, 27213);
                                            }else {
                                                return false;
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }
                                }else {
                                    if (substr == null) {
                                        return true;
                                    }
                                    if (CallChecker.beforeDeref(string, String.class, 916, 27403, 27408)) {
                                        string = CallChecker.beforeCalled(string, String.class, 916, 27403, 27408);
                                        return CallChecker.isCalled(string, String.class, 916, 27403, 27408).endsWith(substr);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                            return true;
                        }
                    case FrameworkUtil.FilterImpl.EQUAL :
                        {
                            if (CallChecker.beforeDeref(string, String.class, 923, 27499, 27504)) {
                                string = CallChecker.beforeCalled(string, String.class, 923, 27499, 27504);
                                return CallChecker.isCalled(string, String.class, 923, 27499, 27504).equals(value2);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    case FrameworkUtil.FilterImpl.APPROX :
                        {
                            string = FrameworkUtil.FilterImpl.approxString(string);
                            CallChecker.varAssign(string, "string", 926, 27553, 27582);
                            String string2 = CallChecker.varInit(FrameworkUtil.FilterImpl.approxString(((String) (value2))), "string2", 927, 27589, 27635);
                            if (CallChecker.beforeDeref(string, String.class, 929, 27650, 27655)) {
                                string = CallChecker.beforeCalled(string, String.class, 929, 27650, 27655);
                                return CallChecker.isCalled(string, String.class, 929, 27650, 27655).equalsIgnoreCase(string2);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    case FrameworkUtil.FilterImpl.GREATER :
                        {
                            string = CallChecker.beforeCalled(string, String.class, 932, 27723, 27728);
                            return (CallChecker.isCalled(string, String.class, 932, 27723, 27728).compareTo(((String) (value2)))) >= 0;
                        }
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            string = CallChecker.beforeCalled(string, String.class, 935, 27799, 27804);
                            return (CallChecker.isCalled(string, String.class, 935, 27799, 27804).compareTo(((String) (value2)))) <= 0;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1581.methodEnd();
            }
        }

        private boolean compare_Integer(int operation, int intval, Object value2) {
            MethodContext _bcornu_methode_context1582 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 941, 27874, 28389);
                CallChecker.varInit(value2, "value2", 941, 27874, 28389);
                CallChecker.varInit(intval, "intval", 941, 27874, 28389);
                CallChecker.varInit(operation, "operation", 941, 27874, 28389);
                CallChecker.varInit(this.filterString, "filterString", 941, 27874, 28389);
                CallChecker.varInit(this.value, "value", 941, 27874, 28389);
                CallChecker.varInit(this.attr, "attr", 941, 27874, 28389);
                CallChecker.varInit(this.op, "op", 941, 27874, 28389);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 941, 27874, 28389);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 941, 27874, 28389);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 941, 27874, 28389);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 941, 27874, 28389);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 941, 27874, 28389);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 941, 27874, 28389);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 941, 27874, 28389);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 941, 27874, 28389);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 941, 27874, 28389);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                int intval2 = CallChecker.init(int.class);
                TryContext _bcornu_try_context_428 = new TryContext(428, FrameworkUtil.class, "java.lang.IllegalArgumentException");
                try {
                    if (CallChecker.beforeDeref(value2, Object.class, 947, 28072, 28077)) {
                        value2 = CallChecker.beforeCalled(value2, String.class, 947, 28072, 28077);
                        intval2 = Integer.parseInt(CallChecker.isCalled(((String) (value2)), String.class, 947, 28072, 28077).trim());
                        CallChecker.varAssign(intval2, "intval2", 947, 28035, 28087);
                    }
                } catch (IllegalArgumentException e) {
                    _bcornu_try_context_428.catchStart(428);
                    return false;
                } finally {
                    _bcornu_try_context_428.finallyStart(428);
                }
                switch (operation) {
                    case FrameworkUtil.FilterImpl.APPROX :
                    case FrameworkUtil.FilterImpl.EQUAL :
                        {
                            return intval == intval2;
                        }
                    case FrameworkUtil.FilterImpl.GREATER :
                        {
                            return intval >= intval2;
                        }
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            return intval <= intval2;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1582.methodEnd();
            }
        }

        private boolean compare_Long(int operation, long longval, Object value2) {
            MethodContext _bcornu_methode_context1583 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 966, 28394, 28916);
                CallChecker.varInit(value2, "value2", 966, 28394, 28916);
                CallChecker.varInit(longval, "longval", 966, 28394, 28916);
                CallChecker.varInit(operation, "operation", 966, 28394, 28916);
                CallChecker.varInit(this.filterString, "filterString", 966, 28394, 28916);
                CallChecker.varInit(this.value, "value", 966, 28394, 28916);
                CallChecker.varInit(this.attr, "attr", 966, 28394, 28916);
                CallChecker.varInit(this.op, "op", 966, 28394, 28916);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 966, 28394, 28916);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 966, 28394, 28916);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 966, 28394, 28916);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 966, 28394, 28916);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 966, 28394, 28916);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 966, 28394, 28916);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 966, 28394, 28916);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 966, 28394, 28916);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 966, 28394, 28916);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                long longval2 = CallChecker.init(long.class);
                TryContext _bcornu_try_context_429 = new TryContext(429, FrameworkUtil.class, "java.lang.IllegalArgumentException");
                try {
                    if (CallChecker.beforeDeref(value2, Object.class, 972, 28592, 28597)) {
                        value2 = CallChecker.beforeCalled(value2, String.class, 972, 28592, 28597);
                        longval2 = Long.parseLong(CallChecker.isCalled(((String) (value2)), String.class, 972, 28592, 28597).trim());
                        CallChecker.varAssign(longval2, "longval2", 972, 28556, 28607);
                    }
                } catch (IllegalArgumentException e) {
                    _bcornu_try_context_429.catchStart(429);
                    return false;
                } finally {
                    _bcornu_try_context_429.finallyStart(429);
                }
                switch (operation) {
                    case FrameworkUtil.FilterImpl.APPROX :
                    case FrameworkUtil.FilterImpl.EQUAL :
                        {
                            return longval == longval2;
                        }
                    case FrameworkUtil.FilterImpl.GREATER :
                        {
                            return longval >= longval2;
                        }
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            return longval <= longval2;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1583.methodEnd();
            }
        }

        private boolean compare_Byte(int operation, byte byteval, Object value2) {
            MethodContext _bcornu_methode_context1584 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 992, 28921, 29443);
                CallChecker.varInit(value2, "value2", 992, 28921, 29443);
                CallChecker.varInit(byteval, "byteval", 992, 28921, 29443);
                CallChecker.varInit(operation, "operation", 992, 28921, 29443);
                CallChecker.varInit(this.filterString, "filterString", 992, 28921, 29443);
                CallChecker.varInit(this.value, "value", 992, 28921, 29443);
                CallChecker.varInit(this.attr, "attr", 992, 28921, 29443);
                CallChecker.varInit(this.op, "op", 992, 28921, 29443);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 992, 28921, 29443);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 992, 28921, 29443);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 992, 28921, 29443);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 992, 28921, 29443);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 992, 28921, 29443);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 992, 28921, 29443);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 992, 28921, 29443);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 992, 28921, 29443);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 992, 28921, 29443);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                byte byteval2 = CallChecker.init(byte.class);
                TryContext _bcornu_try_context_430 = new TryContext(430, FrameworkUtil.class, "java.lang.IllegalArgumentException");
                try {
                    if (CallChecker.beforeDeref(value2, Object.class, 998, 29119, 29124)) {
                        value2 = CallChecker.beforeCalled(value2, String.class, 998, 29119, 29124);
                        byteval2 = Byte.parseByte(CallChecker.isCalled(((String) (value2)), String.class, 998, 29119, 29124).trim());
                        CallChecker.varAssign(byteval2, "byteval2", 998, 29083, 29134);
                    }
                } catch (IllegalArgumentException e) {
                    _bcornu_try_context_430.catchStart(430);
                    return false;
                } finally {
                    _bcornu_try_context_430.finallyStart(430);
                }
                switch (operation) {
                    case FrameworkUtil.FilterImpl.APPROX :
                    case FrameworkUtil.FilterImpl.EQUAL :
                        {
                            return byteval == byteval2;
                        }
                    case FrameworkUtil.FilterImpl.GREATER :
                        {
                            return byteval >= byteval2;
                        }
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            return byteval <= byteval2;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1584.methodEnd();
            }
        }

        private boolean compare_Short(int operation, short shortval, Object value2) {
            MethodContext _bcornu_methode_context1585 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1018, 29448, 29984);
                CallChecker.varInit(value2, "value2", 1018, 29448, 29984);
                CallChecker.varInit(shortval, "shortval", 1018, 29448, 29984);
                CallChecker.varInit(operation, "operation", 1018, 29448, 29984);
                CallChecker.varInit(this.filterString, "filterString", 1018, 29448, 29984);
                CallChecker.varInit(this.value, "value", 1018, 29448, 29984);
                CallChecker.varInit(this.attr, "attr", 1018, 29448, 29984);
                CallChecker.varInit(this.op, "op", 1018, 29448, 29984);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1018, 29448, 29984);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1018, 29448, 29984);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1018, 29448, 29984);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1018, 29448, 29984);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1018, 29448, 29984);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1018, 29448, 29984);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1018, 29448, 29984);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1018, 29448, 29984);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1018, 29448, 29984);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                short shortval2 = CallChecker.init(short.class);
                TryContext _bcornu_try_context_431 = new TryContext(431, FrameworkUtil.class, "java.lang.IllegalArgumentException");
                try {
                    if (CallChecker.beforeDeref(value2, Object.class, 1024, 29654, 29659)) {
                        value2 = CallChecker.beforeCalled(value2, String.class, 1024, 29654, 29659);
                        shortval2 = Short.parseShort(CallChecker.isCalled(((String) (value2)), String.class, 1024, 29654, 29659).trim());
                        CallChecker.varAssign(shortval2, "shortval2", 1024, 29615, 29669);
                    }
                } catch (IllegalArgumentException e) {
                    _bcornu_try_context_431.catchStart(431);
                    return false;
                } finally {
                    _bcornu_try_context_431.finallyStart(431);
                }
                switch (operation) {
                    case FrameworkUtil.FilterImpl.APPROX :
                    case FrameworkUtil.FilterImpl.EQUAL :
                        {
                            return shortval == shortval2;
                        }
                    case FrameworkUtil.FilterImpl.GREATER :
                        {
                            return shortval >= shortval2;
                        }
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            return shortval <= shortval2;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1585.methodEnd();
            }
        }

        private boolean compare_Character(int operation, char charval, Object value2) {
            MethodContext _bcornu_methode_context1586 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1044, 29989, 30689);
                CallChecker.varInit(value2, "value2", 1044, 29989, 30689);
                CallChecker.varInit(charval, "charval", 1044, 29989, 30689);
                CallChecker.varInit(operation, "operation", 1044, 29989, 30689);
                CallChecker.varInit(this.filterString, "filterString", 1044, 29989, 30689);
                CallChecker.varInit(this.value, "value", 1044, 29989, 30689);
                CallChecker.varInit(this.attr, "attr", 1044, 29989, 30689);
                CallChecker.varInit(this.op, "op", 1044, 29989, 30689);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1044, 29989, 30689);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1044, 29989, 30689);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1044, 29989, 30689);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1044, 29989, 30689);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1044, 29989, 30689);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1044, 29989, 30689);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1044, 29989, 30689);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1044, 29989, 30689);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1044, 29989, 30689);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                char charval2 = CallChecker.init(char.class);
                TryContext _bcornu_try_context_432 = new TryContext(432, FrameworkUtil.class, "java.lang.IndexOutOfBoundsException");
                try {
                    if (CallChecker.beforeDeref(value2, Object.class, 1050, 30177, 30182)) {
                        value2 = CallChecker.beforeCalled(value2, String.class, 1050, 30177, 30182);
                        charval2 = CallChecker.isCalled(((String) (value2)), String.class, 1050, 30177, 30182).charAt(0);
                        CallChecker.varAssign(charval2, "charval2", 1050, 30156, 30194);
                    }
                } catch (IndexOutOfBoundsException e) {
                    _bcornu_try_context_432.catchStart(432);
                    return false;
                } finally {
                    _bcornu_try_context_432.finallyStart(432);
                }
                switch (operation) {
                    case FrameworkUtil.FilterImpl.EQUAL :
                        {
                            return charval == charval2;
                        }
                    case FrameworkUtil.FilterImpl.APPROX :
                        {
                            return ((charval == charval2) || ((Character.toUpperCase(charval)) == (Character.toUpperCase(charval2)))) || ((Character.toLowerCase(charval)) == (Character.toLowerCase(charval2)));
                        }
                    case FrameworkUtil.FilterImpl.GREATER :
                        {
                            return charval >= charval2;
                        }
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            return charval <= charval2;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1586.methodEnd();
            }
        }

        private boolean compare_Boolean(int operation, boolean boolval, Object value2) {
            MethodContext _bcornu_methode_context1587 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1072, 30694, 31070);
                CallChecker.varInit(value2, "value2", 1072, 30694, 31070);
                CallChecker.varInit(boolval, "boolval", 1072, 30694, 31070);
                CallChecker.varInit(operation, "operation", 1072, 30694, 31070);
                CallChecker.varInit(this.filterString, "filterString", 1072, 30694, 31070);
                CallChecker.varInit(this.value, "value", 1072, 30694, 31070);
                CallChecker.varInit(this.attr, "attr", 1072, 30694, 31070);
                CallChecker.varInit(this.op, "op", 1072, 30694, 31070);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1072, 30694, 31070);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1072, 30694, 31070);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1072, 30694, 31070);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1072, 30694, 31070);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1072, 30694, 31070);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1072, 30694, 31070);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1072, 30694, 31070);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1072, 30694, 31070);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1072, 30694, 31070);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                boolean boolval2 = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(value2, Object.class, 1076, 30879, 30884)) {
                    value2 = CallChecker.beforeCalled(value2, String.class, 1076, 30879, 30884);
                    if (CallChecker.beforeDeref(Boolean.valueOf(CallChecker.isCalled(((String) (value2)), String.class, 1076, 30879, 30884).trim()), Boolean.class, 1076, 30853, 30893)) {
                        value2 = CallChecker.beforeCalled(value2, String.class, 1076, 30879, 30884);
                        boolval2 = CallChecker.isCalled(Boolean.valueOf(CallChecker.isCalled(((String) (value2)), String.class, 1076, 30879, 30884).trim()), Boolean.class, 1076, 30853, 30893).booleanValue();
                        CallChecker.varAssign(boolval2, "boolval2", 1076, 30879, 30884);
                    }
                }
                switch (operation) {
                    case FrameworkUtil.FilterImpl.APPROX :
                    case FrameworkUtil.FilterImpl.EQUAL :
                    case FrameworkUtil.FilterImpl.GREATER :
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            return boolval == boolval2;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1587.methodEnd();
            }
        }

        private boolean compare_Float(int operation, float floatval, Object value2) {
            MethodContext _bcornu_methode_context1588 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1088, 31075, 31665);
                CallChecker.varInit(value2, "value2", 1088, 31075, 31665);
                CallChecker.varInit(floatval, "floatval", 1088, 31075, 31665);
                CallChecker.varInit(operation, "operation", 1088, 31075, 31665);
                CallChecker.varInit(this.filterString, "filterString", 1088, 31075, 31665);
                CallChecker.varInit(this.value, "value", 1088, 31075, 31665);
                CallChecker.varInit(this.attr, "attr", 1088, 31075, 31665);
                CallChecker.varInit(this.op, "op", 1088, 31075, 31665);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1088, 31075, 31665);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1088, 31075, 31665);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1088, 31075, 31665);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1088, 31075, 31665);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1088, 31075, 31665);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1088, 31075, 31665);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1088, 31075, 31665);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1088, 31075, 31665);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1088, 31075, 31665);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                float floatval2 = CallChecker.init(float.class);
                TryContext _bcornu_try_context_433 = new TryContext(433, FrameworkUtil.class, "java.lang.IllegalArgumentException");
                try {
                    if (CallChecker.beforeDeref(value2, Object.class, 1094, 31281, 31286)) {
                        value2 = CallChecker.beforeCalled(value2, String.class, 1094, 31281, 31286);
                        floatval2 = Float.parseFloat(CallChecker.isCalled(((String) (value2)), String.class, 1094, 31281, 31286).trim());
                        CallChecker.varAssign(floatval2, "floatval2", 1094, 31242, 31296);
                    }
                } catch (IllegalArgumentException e) {
                    _bcornu_try_context_433.catchStart(433);
                    return false;
                } finally {
                    _bcornu_try_context_433.finallyStart(433);
                }
                switch (operation) {
                    case FrameworkUtil.FilterImpl.APPROX :
                    case FrameworkUtil.FilterImpl.EQUAL :
                        {
                            return (Float.compare(floatval, floatval2)) == 0;
                        }
                    case FrameworkUtil.FilterImpl.GREATER :
                        {
                            return (Float.compare(floatval, floatval2)) >= 0;
                        }
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            return (Float.compare(floatval, floatval2)) <= 0;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1588.methodEnd();
            }
        }

        private boolean compare_Double(int operation, double doubleval, Object value2) {
            MethodContext _bcornu_methode_context1589 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1114, 31670, 32277);
                CallChecker.varInit(value2, "value2", 1114, 31670, 32277);
                CallChecker.varInit(doubleval, "doubleval", 1114, 31670, 32277);
                CallChecker.varInit(operation, "operation", 1114, 31670, 32277);
                CallChecker.varInit(this.filterString, "filterString", 1114, 31670, 32277);
                CallChecker.varInit(this.value, "value", 1114, 31670, 32277);
                CallChecker.varInit(this.attr, "attr", 1114, 31670, 32277);
                CallChecker.varInit(this.op, "op", 1114, 31670, 32277);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1114, 31670, 32277);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1114, 31670, 32277);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1114, 31670, 32277);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1114, 31670, 32277);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1114, 31670, 32277);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1114, 31670, 32277);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1114, 31670, 32277);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1114, 31670, 32277);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1114, 31670, 32277);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                double doubleval2 = CallChecker.init(double.class);
                TryContext _bcornu_try_context_434 = new TryContext(434, FrameworkUtil.class, "java.lang.IllegalArgumentException");
                try {
                    if (CallChecker.beforeDeref(value2, Object.class, 1120, 31884, 31889)) {
                        value2 = CallChecker.beforeCalled(value2, String.class, 1120, 31884, 31889);
                        doubleval2 = Double.parseDouble(CallChecker.isCalled(((String) (value2)), String.class, 1120, 31884, 31889).trim());
                        CallChecker.varAssign(doubleval2, "doubleval2", 1120, 31842, 31899);
                    }
                } catch (IllegalArgumentException e) {
                    _bcornu_try_context_434.catchStart(434);
                    return false;
                } finally {
                    _bcornu_try_context_434.finallyStart(434);
                }
                switch (operation) {
                    case FrameworkUtil.FilterImpl.APPROX :
                    case FrameworkUtil.FilterImpl.EQUAL :
                        {
                            return (Double.compare(doubleval, doubleval2)) == 0;
                        }
                    case FrameworkUtil.FilterImpl.GREATER :
                        {
                            return (Double.compare(doubleval, doubleval2)) >= 0;
                        }
                    case FrameworkUtil.FilterImpl.LESS :
                        {
                            return (Double.compare(doubleval, doubleval2)) <= 0;
                        }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1589.methodEnd();
            }
        }

        private static Object valueOf(Class<?> target, String value2) {
            MethodContext _bcornu_methode_context1590 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(value2, "value2", 1140, 32282, 33331);
                CallChecker.varInit(target, "target", 1140, 32282, 33331);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1140, 32282, 33331);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1140, 32282, 33331);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1140, 32282, 33331);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1140, 32282, 33331);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1140, 32282, 33331);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1140, 32282, 33331);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1140, 32282, 33331);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1140, 32282, 33331);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1140, 32282, 33331);
                do {
                    Method method = CallChecker.init(Method.class);
                    TryContext _bcornu_try_context_435 = new TryContext(435, FrameworkUtil.class, "java.lang.NoSuchMethodException");
                    try {
                        if (CallChecker.beforeDeref(target, Class.class, 1144, 32397, 32402)) {
                            target = CallChecker.beforeCalled(target, Class.class, 1144, 32397, 32402);
                            method = CallChecker.isCalled(target, Class.class, 1144, 32397, 32402).getMethod("valueOf", String.class);
                            CallChecker.varAssign(method, "method", 1144, 32388, 32438);
                        }
                    } catch (NoSuchMethodException e) {
                        _bcornu_try_context_435.catchStart(435);
                        break;
                    } finally {
                        _bcornu_try_context_435.finallyStart(435);
                    }
                    if (CallChecker.beforeDeref(method, Method.class, 1148, 32524, 32529)) {
                        if (CallChecker.beforeDeref(method, Method.class, 1148, 32574, 32579)) {
                            if (CallChecker.beforeDeref(target, Class.class, 1148, 32550, 32555)) {
                                method = CallChecker.beforeCalled(method, Method.class, 1148, 32524, 32529);
                                method = CallChecker.beforeCalled(method, Method.class, 1148, 32574, 32579);
                                target = CallChecker.beforeCalled(target, Class.class, 1148, 32550, 32555);
                                if ((Modifier.isStatic(CallChecker.isCalled(method, Method.class, 1148, 32524, 32529).getModifiers())) && (CallChecker.isCalled(target, Class.class, 1148, 32550, 32555).isAssignableFrom(CallChecker.isCalled(method, Method.class, 1148, 32574, 32579).getReturnType()))) {
                                    FrameworkUtil.FilterImpl.setAccessible(method);
                                    TryContext _bcornu_try_context_436 = new TryContext(436, FrameworkUtil.class, "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException");
                                    try {
                                        if (CallChecker.beforeDeref(value2, String.class, 1151, 32673, 32678)) {
                                            if (CallChecker.beforeDeref(method, Method.class, 1151, 32653, 32658)) {
                                                value2 = CallChecker.beforeCalled(value2, String.class, 1151, 32673, 32678);
                                                method = CallChecker.beforeCalled(method, Method.class, 1151, 32653, 32658);
                                                return CallChecker.isCalled(method, Method.class, 1151, 32653, 32658).invoke(null, CallChecker.isCalled(value2, String.class, 1151, 32673, 32678).trim());
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    } catch (IllegalAccessException e) {
                                        _bcornu_try_context_436.catchStart(436);
                                        return null;
                                    } catch (InvocationTargetException e) {
                                        _bcornu_try_context_436.catchStart(436);
                                        return null;
                                    } finally {
                                        _bcornu_try_context_436.finallyStart(436);
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                } while (false );
                do {
                    Constructor<?> constructor = CallChecker.init(Constructor.class);
                    TryContext _bcornu_try_context_437 = new TryContext(437, FrameworkUtil.class, "java.lang.NoSuchMethodException");
                    try {
                        if (CallChecker.beforeDeref(target, Class.class, 1163, 32917, 32922)) {
                            target = CallChecker.beforeCalled(target, Class.class, 1163, 32917, 32922);
                            constructor = CallChecker.isCalled(target, Class.class, 1163, 32917, 32922).getConstructor(String.class);
                            CallChecker.varAssign(constructor, "constructor", 1163, 32903, 32952);
                        }
                    } catch (NoSuchMethodException e) {
                        _bcornu_try_context_437.catchStart(437);
                        break;
                    } finally {
                        _bcornu_try_context_437.finallyStart(437);
                    }
                    FrameworkUtil.FilterImpl.setAccessible(constructor);
                    TryContext _bcornu_try_context_438 = new TryContext(438, FrameworkUtil.class, "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException", "java.lang.InstantiationException");
                    try {
                        if (CallChecker.beforeDeref(value2, String.class, 1169, 33090, 33095)) {
                            if (CallChecker.beforeDeref(constructor, Constructor.class, 1169, 33066, 33076)) {
                                value2 = CallChecker.beforeCalled(value2, String.class, 1169, 33090, 33095);
                                return constructor.newInstance(CallChecker.isCalled(value2, String.class, 1169, 33090, 33095).trim());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (IllegalAccessException e) {
                        _bcornu_try_context_438.catchStart(438);
                        return null;
                    } catch (InvocationTargetException e) {
                        _bcornu_try_context_438.catchStart(438);
                        return null;
                    } catch (InstantiationException e) {
                        _bcornu_try_context_438.catchStart(438);
                        return null;
                    } finally {
                        _bcornu_try_context_438.finallyStart(438);
                    }
                } while (false );
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1590.methodEnd();
            }
        }

        private static void setAccessible(AccessibleObject accessible) {
            MethodContext _bcornu_methode_context1591 = new MethodContext(void.class);
            try {
                CallChecker.varInit(accessible, "accessible", 1182, 33336, 33517);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1182, 33336, 33517);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1182, 33336, 33517);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1182, 33336, 33517);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1182, 33336, 33517);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1182, 33336, 33517);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1182, 33336, 33517);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1182, 33336, 33517);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1182, 33336, 33517);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1182, 33336, 33517);
                if (CallChecker.beforeDeref(accessible, AccessibleObject.class, 1183, 33409, 33418)) {
                    accessible = CallChecker.beforeCalled(accessible, AccessibleObject.class, 1183, 33409, 33418);
                    if (!(CallChecker.isCalled(accessible, AccessibleObject.class, 1183, 33409, 33418).isAccessible())) {
                        AccessController.doPrivileged(new FrameworkUtil.SetAccessibleAction(accessible));
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1591.methodEnd();
            }
        }

        private boolean compare_Comparable(int operation, Comparable<Object> value1, Object value2) {
            MethodContext _bcornu_methode_context1592 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1188, 33522, 34184);
                CallChecker.varInit(value2, "value2", 1188, 33522, 34184);
                CallChecker.varInit(value1, "value1", 1188, 33522, 34184);
                CallChecker.varInit(operation, "operation", 1188, 33522, 34184);
                CallChecker.varInit(this.filterString, "filterString", 1188, 33522, 34184);
                CallChecker.varInit(this.value, "value", 1188, 33522, 34184);
                CallChecker.varInit(this.attr, "attr", 1188, 33522, 34184);
                CallChecker.varInit(this.op, "op", 1188, 33522, 34184);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1188, 33522, 34184);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1188, 33522, 34184);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1188, 33522, 34184);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1188, 33522, 34184);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1188, 33522, 34184);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1188, 33522, 34184);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1188, 33522, 34184);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1188, 33522, 34184);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1188, 33522, 34184);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                if (CallChecker.beforeDeref(value1, Comparable.class, 1192, 33692, 33697)) {
                    value1 = CallChecker.beforeCalled(value1, Comparable.class, 1192, 33692, 33697);
                    value2 = FrameworkUtil.FilterImpl.valueOf(CallChecker.isCalled(value1, Comparable.class, 1192, 33692, 33697).getClass(), ((String) (value2)));
                    CallChecker.varAssign(value2, "value2", 1192, 33675, 33727);
                }
                if (value2 == null) {
                    return false;
                }
                TryContext _bcornu_try_context_439 = new TryContext(439, FrameworkUtil.class, "java.lang.Exception");
                try {
                    switch (operation) {
                        case FrameworkUtil.FilterImpl.APPROX :
                        case FrameworkUtil.FilterImpl.EQUAL :
                            {
                                value1 = CallChecker.beforeCalled(value1, Comparable.class, 1200, 33863, 33868);
                                return (CallChecker.isCalled(value1, Comparable.class, 1200, 33863, 33868).compareTo(value2)) == 0;
                            }
                        case FrameworkUtil.FilterImpl.GREATER :
                            {
                                value1 = CallChecker.beforeCalled(value1, Comparable.class, 1203, 33936, 33941);
                                return (CallChecker.isCalled(value1, Comparable.class, 1203, 33936, 33941).compareTo(value2)) >= 0;
                            }
                        case FrameworkUtil.FilterImpl.LESS :
                            {
                                value1 = CallChecker.beforeCalled(value1, Comparable.class, 1206, 34006, 34011);
                                return (CallChecker.isCalled(value1, Comparable.class, 1206, 34006, 34011).compareTo(value2)) <= 0;
                            }
                    }
                } catch (Exception e) {
                    _bcornu_try_context_439.catchStart(439);
                    return false;
                } finally {
                    _bcornu_try_context_439.finallyStart(439);
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1592.methodEnd();
            }
        }

        private boolean compare_Unknown(int operation, Object value1, Object value2) {
            MethodContext _bcornu_methode_context1593 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1216, 34189, 34719);
                CallChecker.varInit(value2, "value2", 1216, 34189, 34719);
                CallChecker.varInit(value1, "value1", 1216, 34189, 34719);
                CallChecker.varInit(operation, "operation", 1216, 34189, 34719);
                CallChecker.varInit(this.filterString, "filterString", 1216, 34189, 34719);
                CallChecker.varInit(this.value, "value", 1216, 34189, 34719);
                CallChecker.varInit(this.attr, "attr", 1216, 34189, 34719);
                CallChecker.varInit(this.op, "op", 1216, 34189, 34719);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1216, 34189, 34719);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1216, 34189, 34719);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1216, 34189, 34719);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1216, 34189, 34719);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1216, 34189, 34719);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1216, 34189, 34719);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1216, 34189, 34719);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1216, 34189, 34719);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1216, 34189, 34719);
                if (operation == (FrameworkUtil.FilterImpl.SUBSTRING)) {
                    return false;
                }
                if (CallChecker.beforeDeref(value1, Object.class, 1220, 34344, 34349)) {
                    value1 = CallChecker.beforeCalled(value1, Object.class, 1220, 34344, 34349);
                    value2 = FrameworkUtil.FilterImpl.valueOf(CallChecker.isCalled(value1, Object.class, 1220, 34344, 34349).getClass(), ((String) (value2)));
                    CallChecker.varAssign(value2, "value2", 1220, 34327, 34379);
                }
                if (value2 == null) {
                    return false;
                }
                TryContext _bcornu_try_context_440 = new TryContext(440, FrameworkUtil.class, "java.lang.Exception");
                try {
                    switch (operation) {
                        case FrameworkUtil.FilterImpl.APPROX :
                        case FrameworkUtil.FilterImpl.EQUAL :
                        case FrameworkUtil.FilterImpl.GREATER :
                        case FrameworkUtil.FilterImpl.LESS :
                            {
                                if (CallChecker.beforeDeref(value1, Object.class, 1230, 34552, 34557)) {
                                    value1 = CallChecker.beforeCalled(value1, Object.class, 1230, 34552, 34557);
                                    return CallChecker.isCalled(value1, Object.class, 1230, 34552, 34557).equals(value2);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                    }
                } catch (Exception e) {
                    _bcornu_try_context_440.catchStart(440);
                    return false;
                } finally {
                    _bcornu_try_context_440.finallyStart(440);
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1593.methodEnd();
            }
        }

        private static String approxString(String input) {
            MethodContext _bcornu_methode_context1594 = new MethodContext(String.class);
            try {
                CallChecker.varInit(input, "input", 1249, 34724, 35341);
                CallChecker.varInit(NOT, "org.osgi.framework.FrameworkUtil.FilterImpl.NOT", 1249, 34724, 35341);
                CallChecker.varInit(OR, "org.osgi.framework.FrameworkUtil.FilterImpl.OR", 1249, 34724, 35341);
                CallChecker.varInit(AND, "org.osgi.framework.FrameworkUtil.FilterImpl.AND", 1249, 34724, 35341);
                CallChecker.varInit(SUBSTRING, "org.osgi.framework.FrameworkUtil.FilterImpl.SUBSTRING", 1249, 34724, 35341);
                CallChecker.varInit(PRESENT, "org.osgi.framework.FrameworkUtil.FilterImpl.PRESENT", 1249, 34724, 35341);
                CallChecker.varInit(LESS, "org.osgi.framework.FrameworkUtil.FilterImpl.LESS", 1249, 34724, 35341);
                CallChecker.varInit(GREATER, "org.osgi.framework.FrameworkUtil.FilterImpl.GREATER", 1249, 34724, 35341);
                CallChecker.varInit(APPROX, "org.osgi.framework.FrameworkUtil.FilterImpl.APPROX", 1249, 34724, 35341);
                CallChecker.varInit(EQUAL, "org.osgi.framework.FrameworkUtil.FilterImpl.EQUAL", 1249, 34724, 35341);
                boolean changed = CallChecker.varInit(((boolean) (false)), "changed", 1250, 35045, 35068);
                char[] output = CallChecker.init(char[].class);
                if (CallChecker.beforeDeref(input, String.class, 1251, 35089, 35093)) {
                    input = CallChecker.beforeCalled(input, String.class, 1251, 35089, 35093);
                    output = CallChecker.isCalled(input, String.class, 1251, 35089, 35093).toCharArray();
                    CallChecker.varAssign(output, "output", 1251, 35089, 35093);
                }
                int cursor = CallChecker.varInit(((int) (0)), "cursor", 1252, 35113, 35127);
                if (CallChecker.beforeDeref(output, String.class, 1253, 35146, 35151)) {
                    for (char c : output) {
                        if (Character.isWhitespace(c)) {
                            changed = true;
                            CallChecker.varAssign(changed, "changed", 1255, 35198, 35212);
                            continue;
                        }
                        if (CallChecker.beforeDeref(output, char[].class, 1259, 35240, 35245)) {
                            output = CallChecker.beforeCalled(output, char[].class, 1259, 35240, 35245);
                            CallChecker.isCalled(output, char[].class, 1259, 35240, 35245)[cursor] = c;
                            CallChecker.varAssign(CallChecker.isCalled(output, char[].class, 1259, 35240, 35245)[cursor], "CallChecker.isCalled(output, char[].class, 1259, 35240, 35245)[cursor]", 1259, 35240, 35258);
                        }
                        cursor++;
                    }
                }
                if (changed) {
                    return new String(output, 0, cursor);
                }else {
                    return input;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1594.methodEnd();
            }
        }

        private static final class Parser {
            private final String filterstring;

            private final char[] filterChars;

            private int pos;

            Parser(String filterstring) {
                MethodContext _bcornu_methode_context158 = new MethodContext(null);
                try {
                    this.filterstring = filterstring;
                    CallChecker.varAssign(this.filterstring, "this.filterstring", 1277, 35686, 35718);
                    filterstring = CallChecker.beforeCalled(filterstring, String.class, 1278, 35738, 35749);
                    filterChars = CallChecker.isCalled(filterstring, String.class, 1278, 35738, 35749).toCharArray();
                    CallChecker.varAssign(this.filterChars, "this.filterChars", 1278, 35724, 35764);
                    pos = 0;
                    CallChecker.varAssign(this.pos, "this.pos", 1279, 35770, 35777);
                } finally {
                    _bcornu_methode_context158.methodEnd();
                }
            }

            FrameworkUtil.FilterImpl parse() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1595 = new MethodContext(FrameworkUtil.FilterImpl.class);
                try {
                    CallChecker.varInit(this, "this", 1282, 35788, 36223);
                    CallChecker.varInit(this.pos, "pos", 1282, 35788, 36223);
                    CallChecker.varInit(this.filterChars, "filterChars", 1282, 35788, 36223);
                    CallChecker.varInit(this.filterstring, "filterstring", 1282, 35788, 36223);
                    FrameworkUtil.FilterImpl filter = CallChecker.init(FrameworkUtil.FilterImpl.class);
                    TryContext _bcornu_try_context_441 = new TryContext(441, FrameworkUtil.class, "java.lang.ArrayIndexOutOfBoundsException");
                    try {
                        filter = parse_filter();
                        CallChecker.varAssign(filter, "filter", 1285, 35877, 35900);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        _bcornu_try_context_441.catchStart(441);
                        throw new InvalidSyntaxException("Filter ended abruptly", filterstring, e);
                    } finally {
                        _bcornu_try_context_441.finallyStart(441);
                    }
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1290, 36054, 36064)) {
                        if ((pos) != (CallChecker.isCalled(filterChars, char[].class, 1290, 36054, 36064).length)) {
                            if (CallChecker.beforeDeref(filterstring, String.class, 1291, 36151, 36162)) {
                                throw new InvalidSyntaxException(("Extraneous trailing characters: " + (CallChecker.isCalled(filterstring, String.class, 1291, 36151, 36162).substring(pos))), filterstring);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    return filter;
                } catch (ForceReturn _bcornu_return_t) {
                    return ((FrameworkUtil.FilterImpl) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1595.methodEnd();
                }
            }

            private FrameworkUtil.FilterImpl parse_filter() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1596 = new MethodContext(FrameworkUtil.FilterImpl.class);
                try {
                    CallChecker.varInit(this, "this", 1296, 36229, 36751);
                    CallChecker.varInit(this.pos, "pos", 1296, 36229, 36751);
                    CallChecker.varInit(this.filterChars, "filterChars", 1296, 36229, 36751);
                    CallChecker.varInit(this.filterstring, "filterstring", 1296, 36229, 36751);
                    FrameworkUtil.FilterImpl filter = CallChecker.init(FrameworkUtil.FilterImpl.class);
                    skipWhiteSpace();
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1300, 36349, 36359)) {
                        if ((CallChecker.isCalled(filterChars, char[].class, 1300, 36349, 36359)[pos]) != '(') {
                            if (CallChecker.beforeDeref(filterstring, String.class, 1301, 36432, 36443)) {
                                throw new InvalidSyntaxException(("Missing '(': " + (CallChecker.isCalled(filterstring, String.class, 1301, 36432, 36443).substring(pos))), filterstring);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    (pos)++;
                    filter = parse_filtercomp();
                    CallChecker.varAssign(filter, "filter", 1306, 36499, 36526);
                    skipWhiteSpace();
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1310, 36560, 36570)) {
                        if ((CallChecker.isCalled(filterChars, char[].class, 1310, 36560, 36570)[pos]) != ')') {
                            if (CallChecker.beforeDeref(filterstring, String.class, 1311, 36643, 36654)) {
                                throw new InvalidSyntaxException(("Missing ')': " + (CallChecker.isCalled(filterstring, String.class, 1311, 36643, 36654).substring(pos))), filterstring);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    (pos)++;
                    skipWhiteSpace();
                    return filter;
                } catch (ForceReturn _bcornu_return_t) {
                    return ((FrameworkUtil.FilterImpl) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1596.methodEnd();
                }
            }

            private FrameworkUtil.FilterImpl parse_filtercomp() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1597 = new MethodContext(FrameworkUtil.FilterImpl.class);
                try {
                    CallChecker.varInit(this, "this", 1321, 36757, 37124);
                    CallChecker.varInit(this.pos, "pos", 1321, 36757, 37124);
                    CallChecker.varInit(this.filterChars, "filterChars", 1321, 36757, 37124);
                    CallChecker.varInit(this.filterstring, "filterstring", 1321, 36757, 37124);
                    skipWhiteSpace();
                    char c = CallChecker.init(char.class);
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1324, 36863, 36873)) {
                        c = CallChecker.isCalled(filterChars, char[].class, 1324, 36863, 36873)[pos];
                        CallChecker.varAssign(c, "c", 1324, 36863, 36873);
                    }
                    switch (c) {
                        case '&' :
                            {
                                (pos)++;
                                return parse_and();
                            }
                        case '|' :
                            {
                                (pos)++;
                                return parse_or();
                            }
                        case '!' :
                            {
                                (pos)++;
                                return parse_not();
                            }
                    }
                    return parse_item();
                } catch (ForceReturn _bcornu_return_t) {
                    return ((FrameworkUtil.FilterImpl) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1597.methodEnd();
                }
            }

            private FrameworkUtil.FilterImpl parse_and() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1598 = new MethodContext(FrameworkUtil.FilterImpl.class);
                try {
                    CallChecker.varInit(this, "this", 1343, 37130, 37613);
                    CallChecker.varInit(this.pos, "pos", 1343, 37130, 37613);
                    CallChecker.varInit(this.filterChars, "filterChars", 1343, 37130, 37613);
                    CallChecker.varInit(this.filterstring, "filterstring", 1343, 37130, 37613);
                    int lookahead = CallChecker.varInit(((int) (this.pos)), "lookahead", 1344, 37197, 37216);
                    skipWhiteSpace();
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1347, 37249, 37259)) {
                        if ((CallChecker.isCalled(filterChars, char[].class, 1347, 37249, 37259)[pos]) != '(') {
                            pos = lookahead - 1;
                            CallChecker.varAssign(this.pos, "this.pos", 1348, 37281, 37300);
                            return parse_item();
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    List<FrameworkUtil.FilterImpl> operands = CallChecker.varInit(new ArrayList<FrameworkUtil.FilterImpl>(10), "operands", 1352, 37339, 37396);
                    while ((CallChecker.isCalled(filterChars, char[].class, 1354, 37410, 37420)[pos]) == '(') {
                        FrameworkUtil.FilterImpl child = CallChecker.varInit(parse_filter(), "child", 1355, 37442, 37475);
                        if (CallChecker.beforeDeref(operands, List.class, 1356, 37482, 37489)) {
                            operands = CallChecker.beforeCalled(operands, List.class, 1356, 37482, 37489);
                            CallChecker.isCalled(operands, List.class, 1356, 37482, 37489).add(child);
                        }
                    } 
                    if (CallChecker.beforeDeref(operands, List.class, 1359, 37590, 37597)) {
                        if (CallChecker.beforeDeref(operands, List.class, 1359, 37558, 37565)) {
                            operands = CallChecker.beforeCalled(operands, List.class, 1359, 37590, 37597);
                            operands = CallChecker.beforeCalled(operands, List.class, 1359, 37558, 37565);
                            return new FrameworkUtil.FilterImpl(FrameworkUtil.FilterImpl.AND, null, CallChecker.isCalled(operands, List.class, 1359, 37558, 37565).toArray(new FrameworkUtil.FilterImpl[CallChecker.isCalled(operands, List.class, 1359, 37590, 37597).size()]));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (ForceReturn _bcornu_return_t) {
                    return ((FrameworkUtil.FilterImpl) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1598.methodEnd();
                }
            }

            private FrameworkUtil.FilterImpl parse_or() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1599 = new MethodContext(FrameworkUtil.FilterImpl.class);
                try {
                    CallChecker.varInit(this, "this", 1362, 37619, 38100);
                    CallChecker.varInit(this.pos, "pos", 1362, 37619, 38100);
                    CallChecker.varInit(this.filterChars, "filterChars", 1362, 37619, 38100);
                    CallChecker.varInit(this.filterstring, "filterstring", 1362, 37619, 38100);
                    int lookahead = CallChecker.varInit(((int) (this.pos)), "lookahead", 1363, 37685, 37704);
                    skipWhiteSpace();
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1366, 37737, 37747)) {
                        if ((CallChecker.isCalled(filterChars, char[].class, 1366, 37737, 37747)[pos]) != '(') {
                            pos = lookahead - 1;
                            CallChecker.varAssign(this.pos, "this.pos", 1367, 37769, 37788);
                            return parse_item();
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    List<FrameworkUtil.FilterImpl> operands = CallChecker.varInit(new ArrayList<FrameworkUtil.FilterImpl>(10), "operands", 1371, 37827, 37884);
                    while ((CallChecker.isCalled(filterChars, char[].class, 1373, 37898, 37908)[pos]) == '(') {
                        FrameworkUtil.FilterImpl child = CallChecker.varInit(parse_filter(), "child", 1374, 37930, 37963);
                        if (CallChecker.beforeDeref(operands, List.class, 1375, 37970, 37977)) {
                            operands = CallChecker.beforeCalled(operands, List.class, 1375, 37970, 37977);
                            CallChecker.isCalled(operands, List.class, 1375, 37970, 37977).add(child);
                        }
                    } 
                    if (CallChecker.beforeDeref(operands, List.class, 1378, 38077, 38084)) {
                        if (CallChecker.beforeDeref(operands, List.class, 1378, 38045, 38052)) {
                            operands = CallChecker.beforeCalled(operands, List.class, 1378, 38077, 38084);
                            operands = CallChecker.beforeCalled(operands, List.class, 1378, 38045, 38052);
                            return new FrameworkUtil.FilterImpl(FrameworkUtil.FilterImpl.OR, null, CallChecker.isCalled(operands, List.class, 1378, 38045, 38052).toArray(new FrameworkUtil.FilterImpl[CallChecker.isCalled(operands, List.class, 1378, 38077, 38084).size()]));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (ForceReturn _bcornu_return_t) {
                    return ((FrameworkUtil.FilterImpl) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1599.methodEnd();
                }
            }

            private FrameworkUtil.FilterImpl parse_not() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1600 = new MethodContext(FrameworkUtil.FilterImpl.class);
                try {
                    CallChecker.varInit(this, "this", 1381, 38106, 38410);
                    CallChecker.varInit(this.pos, "pos", 1381, 38106, 38410);
                    CallChecker.varInit(this.filterChars, "filterChars", 1381, 38106, 38410);
                    CallChecker.varInit(this.filterstring, "filterstring", 1381, 38106, 38410);
                    int lookahead = CallChecker.varInit(((int) (this.pos)), "lookahead", 1382, 38173, 38192);
                    skipWhiteSpace();
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1385, 38225, 38235)) {
                        if ((CallChecker.isCalled(filterChars, char[].class, 1385, 38225, 38235)[pos]) != '(') {
                            pos = lookahead - 1;
                            CallChecker.varAssign(this.pos, "this.pos", 1386, 38257, 38276);
                            return parse_item();
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    FrameworkUtil.FilterImpl child = CallChecker.varInit(parse_filter(), "child", 1390, 38315, 38348);
                    return new FrameworkUtil.FilterImpl(FrameworkUtil.FilterImpl.NOT, null, child);
                } catch (ForceReturn _bcornu_return_t) {
                    return ((FrameworkUtil.FilterImpl) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1600.methodEnd();
                }
            }

            private FrameworkUtil.FilterImpl parse_item() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1601 = new MethodContext(FrameworkUtil.FilterImpl.class);
                try {
                    CallChecker.varInit(this, "this", 1395, 38416, 39704);
                    CallChecker.varInit(this.pos, "pos", 1395, 38416, 39704);
                    CallChecker.varInit(this.filterChars, "filterChars", 1395, 38416, 39704);
                    CallChecker.varInit(this.filterstring, "filterstring", 1395, 38416, 39704);
                    String attr = CallChecker.varInit(parse_attr(), "attr", 1396, 38484, 38510);
                    skipWhiteSpace();
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1400, 38548, 38558)) {
                        switch (CallChecker.isCalled(filterChars, char[].class, 1400, 38548, 38558)[pos]) {
                            case '~' :
                                {
                                    if (CallChecker.beforeDeref(filterChars, char[].class, 1402, 38596, 38606)) {
                                        if ((CallChecker.isCalled(filterChars, char[].class, 1402, 38596, 38606)[((pos) + 1)]) == '=') {
                                            pos += 2;
                                            CallChecker.varAssign(this.pos, "this.pos", 1403, 38634, 38642);
                                            return new FrameworkUtil.FilterImpl(FrameworkUtil.FilterImpl.APPROX, attr, parse_value());
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    break;
                                }
                            case '>' :
                                {
                                    if (CallChecker.beforeDeref(filterChars, char[].class, 1409, 38770, 38780)) {
                                        if ((CallChecker.isCalled(filterChars, char[].class, 1409, 38770, 38780)[((pos) + 1)]) == '=') {
                                            pos += 2;
                                            CallChecker.varAssign(this.pos, "this.pos", 1410, 38808, 38816);
                                            return new FrameworkUtil.FilterImpl(FrameworkUtil.FilterImpl.GREATER, attr, parse_value());
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    break;
                                }
                            case '<' :
                                {
                                    if (CallChecker.beforeDeref(filterChars, char[].class, 1416, 38945, 38955)) {
                                        if ((CallChecker.isCalled(filterChars, char[].class, 1416, 38945, 38955)[((pos) + 1)]) == '=') {
                                            pos += 2;
                                            CallChecker.varAssign(this.pos, "this.pos", 1417, 38983, 38991);
                                            return new FrameworkUtil.FilterImpl(FrameworkUtil.FilterImpl.LESS, attr, parse_value());
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    break;
                                }
                            case '=' :
                                {
                                    if (CallChecker.beforeDeref(filterChars, char[].class, 1423, 39117, 39127)) {
                                        if ((CallChecker.isCalled(filterChars, char[].class, 1423, 39117, 39127)[((pos) + 1)]) == '*') {
                                            int oldpos = CallChecker.varInit(((int) (this.pos)), "oldpos", 1424, 39155, 39171);
                                            pos += 2;
                                            CallChecker.varAssign(this.pos, "this.pos", 1425, 39180, 39188);
                                            skipWhiteSpace();
                                            if (CallChecker.beforeDeref(filterChars, char[].class, 1427, 39226, 39236)) {
                                                if ((CallChecker.isCalled(filterChars, char[].class, 1427, 39226, 39236)[pos]) == ')') {
                                                    return new FrameworkUtil.FilterImpl(FrameworkUtil.FilterImpl.PRESENT, attr, null);
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                            pos = oldpos;
                                            CallChecker.varAssign(this.pos, "this.pos", 1430, 39332, 39344);
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    (pos)++;
                                    Object string = CallChecker.varInit(parse_substring(), "string", 1434, 39374, 39407);
                                    if (string instanceof String) {
                                        return new FrameworkUtil.FilterImpl(FrameworkUtil.FilterImpl.EQUAL, attr, string);
                                    }
                                    return new FrameworkUtil.FilterImpl(FrameworkUtil.FilterImpl.SUBSTRING, attr, string);
                                }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(filterstring, String.class, 1443, 39657, 39668)) {
                        throw new InvalidSyntaxException(("Invalid operator: " + (CallChecker.isCalled(filterstring, String.class, 1443, 39657, 39668).substring(pos))), filterstring);
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (ForceReturn _bcornu_return_t) {
                    return ((FrameworkUtil.FilterImpl) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1601.methodEnd();
                }
            }

            private String parse_attr() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1602 = new MethodContext(String.class);
                try {
                    CallChecker.varInit(this, "this", 1446, 39710, 40276);
                    CallChecker.varInit(this.pos, "pos", 1446, 39710, 40276);
                    CallChecker.varInit(this.filterChars, "filterChars", 1446, 39710, 40276);
                    CallChecker.varInit(this.filterstring, "filterstring", 1446, 39710, 40276);
                    skipWhiteSpace();
                    int begin = CallChecker.varInit(((int) (this.pos)), "begin", 1449, 39797, 39812);
                    int end = CallChecker.varInit(((int) (this.pos)), "end", 1450, 39818, 39831);
                    char c = CallChecker.init(char.class);
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1452, 39847, 39857)) {
                        c = CallChecker.isCalled(filterChars, char[].class, 1452, 39847, 39857)[pos];
                        CallChecker.varAssign(c, "c", 1452, 39847, 39857);
                    }
                    while ((((((c != '~') && (c != '<')) && (c != '>')) && (c != '=')) && (c != '(')) && (c != ')')) {
                        (pos)++;
                        if (!(Character.isWhitespace(c))) {
                            end = pos;
                            CallChecker.varAssign(end, "end", 1458, 40007, 40016);
                        }
                        if (CallChecker.beforeDeref(filterChars, char[].class, 1461, 40035, 40045)) {
                            c = CallChecker.isCalled(filterChars, char[].class, 1461, 40035, 40045)[pos];
                            CallChecker.varAssign(c, "c", 1461, 40031, 40051);
                        }
                    } 
                    int length = CallChecker.varInit(((int) (end - begin)), "length", 1464, 40064, 40088);
                    if (length == 0) {
                        if (CallChecker.beforeDeref(filterstring, String.class, 1467, 40171, 40182)) {
                            throw new InvalidSyntaxException(("Missing attr: " + (CallChecker.isCalled(filterstring, String.class, 1467, 40171, 40182).substring(pos))), filterstring);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                    return new String(filterChars, begin, length);
                } catch (ForceReturn _bcornu_return_t) {
                    return ((String) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1602.methodEnd();
                }
            }

            private String parse_value() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1603 = new MethodContext(String.class);
                try {
                    CallChecker.varInit(this, "this", 1473, 40282, 41041);
                    CallChecker.varInit(this.pos, "pos", 1473, 40282, 41041);
                    CallChecker.varInit(this.filterChars, "filterChars", 1473, 40282, 41041);
                    CallChecker.varInit(this.filterstring, "filterstring", 1473, 40282, 41041);
                    StringBuffer sb = CallChecker.init(StringBuffer.class);
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1474, 40382, 40392)) {
                        sb = new StringBuffer(((CallChecker.isCalled(filterChars, char[].class, 1474, 40382, 40392).length) - (pos)));
                        CallChecker.varAssign(sb, "sb", 1474, 40382, 40392);
                    }
                    parseloop : while (true) {
                        char c = CallChecker.init(char.class);
                        if (CallChecker.beforeDeref(filterChars, char[].class, 1477, 40454, 40464)) {
                            c = CallChecker.isCalled(filterChars, char[].class, 1477, 40454, 40464)[pos];
                            CallChecker.varAssign(c, "c", 1477, 40454, 40464);
                        }
                        switch (c) {
                            case ')' :
                                {
                                    break parseloop;
                                }
                            case '(' :
                                {
                                    if (CallChecker.beforeDeref(filterstring, String.class, 1485, 40622, 40633)) {
                                        throw new InvalidSyntaxException(("Invalid value: " + (CallChecker.isCalled(filterstring, String.class, 1485, 40622, 40633).substring(pos))), filterstring);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            case '\\' :
                                {
                                    (pos)++;
                                    if (CallChecker.beforeDeref(filterChars, char[].class, 1490, 40720, 40730)) {
                                        c = CallChecker.isCalled(filterChars, char[].class, 1490, 40720, 40730)[pos];
                                        CallChecker.varAssign(c, "c", 1490, 40716, 40736);
                                    }
                                }
                            default :
                                {
                                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 1495, 40811, 40812)) {
                                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 1495, 40811, 40812);
                                        CallChecker.isCalled(sb, StringBuffer.class, 1495, 40811, 40812).append(c);
                                    }
                                    (pos)++;
                                    break;
                                }
                        }
                    } 
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 1502, 40883, 40884)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 1502, 40883, 40884);
                        if ((CallChecker.isCalled(sb, StringBuffer.class, 1502, 40883, 40884).length()) == 0) {
                            if (CallChecker.beforeDeref(filterstring, String.class, 1503, 40961, 40972)) {
                                throw new InvalidSyntaxException(("Missing value: " + (CallChecker.isCalled(filterstring, String.class, 1503, 40961, 40972).substring(pos))), filterstring);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 1506, 41023, 41024)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 1506, 41023, 41024);
                        return CallChecker.isCalled(sb, StringBuffer.class, 1506, 41023, 41024).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (ForceReturn _bcornu_return_t) {
                    return ((String) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1603.methodEnd();
                }
            }

            private Object parse_substring() throws InvalidSyntaxException {
                MethodContext _bcornu_methode_context1604 = new MethodContext(Object.class);
                try {
                    CallChecker.varInit(this, "this", 1509, 41047, 42212);
                    CallChecker.varInit(this.pos, "pos", 1509, 41047, 42212);
                    CallChecker.varInit(this.filterChars, "filterChars", 1509, 41047, 42212);
                    CallChecker.varInit(this.filterstring, "filterstring", 1509, 41047, 42212);
                    StringBuffer sb = CallChecker.init(StringBuffer.class);
                    if (CallChecker.beforeDeref(filterChars, char[].class, 1510, 41151, 41161)) {
                        sb = new StringBuffer(((CallChecker.isCalled(filterChars, char[].class, 1510, 41151, 41161).length) - (pos)));
                        CallChecker.varAssign(sb, "sb", 1510, 41151, 41161);
                    }
                    List<String> operands = CallChecker.varInit(new ArrayList<String>(10), "operands", 1512, 41183, 41232);
                    parseloop : while (true) {
                        char c = CallChecker.init(char.class);
                        if (CallChecker.beforeDeref(filterChars, char[].class, 1515, 41279, 41289)) {
                            c = CallChecker.isCalled(filterChars, char[].class, 1515, 41279, 41289)[pos];
                            CallChecker.varAssign(c, "c", 1515, 41279, 41289);
                        }
                        switch (c) {
                            case ')' :
                                {
                                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 1519, 41346, 41347)) {
                                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 1519, 41346, 41347);
                                        if ((CallChecker.isCalled(sb, StringBuffer.class, 1519, 41346, 41347).length()) > 0) {
                                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 1520, 41386, 41387)) {
                                                if (CallChecker.beforeDeref(operands, List.class, 1520, 41373, 41380)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 1520, 41386, 41387);
                                                    operands = CallChecker.beforeCalled(operands, List.class, 1520, 41373, 41380);
                                                    CallChecker.isCalled(operands, List.class, 1520, 41373, 41380).add(CallChecker.isCalled(sb, StringBuffer.class, 1520, 41386, 41387).toString());
                                                }
                                            }
                                        }
                                    }
                                    break parseloop;
                                }
                            case '(' :
                                {
                                    if (CallChecker.beforeDeref(filterstring, String.class, 1527, 41524, 41535)) {
                                        throw new InvalidSyntaxException(("Invalid value: " + (CallChecker.isCalled(filterstring, String.class, 1527, 41524, 41535).substring(pos))), filterstring);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            case '*' :
                                {
                                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 1531, 41607, 41608)) {
                                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 1531, 41607, 41608);
                                        if ((CallChecker.isCalled(sb, StringBuffer.class, 1531, 41607, 41608).length()) > 0) {
                                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 1532, 41647, 41648)) {
                                                if (CallChecker.beforeDeref(operands, List.class, 1532, 41634, 41641)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 1532, 41647, 41648);
                                                    operands = CallChecker.beforeCalled(operands, List.class, 1532, 41634, 41641);
                                                    CallChecker.isCalled(operands, List.class, 1532, 41634, 41641).add(CallChecker.isCalled(sb, StringBuffer.class, 1532, 41647, 41648).toString());
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 1535, 41680, 41681)) {
                                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 1535, 41680, 41681);
                                        CallChecker.isCalled(sb, StringBuffer.class, 1535, 41680, 41681).setLength(0);
                                    }
                                    if (CallChecker.beforeDeref(operands, List.class, 1537, 41705, 41712)) {
                                        operands = CallChecker.beforeCalled(operands, List.class, 1537, 41705, 41712);
                                        CallChecker.isCalled(operands, List.class, 1537, 41705, 41712).add(null);
                                    }
                                    (pos)++;
                                    break;
                                }
                            case '\\' :
                                {
                                    (pos)++;
                                    if (CallChecker.beforeDeref(filterChars, char[].class, 1545, 41808, 41818)) {
                                        c = CallChecker.isCalled(filterChars, char[].class, 1545, 41808, 41818)[pos];
                                        CallChecker.varAssign(c, "c", 1545, 41804, 41824);
                                    }
                                }
                            default :
                                {
                                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 1550, 41899, 41900)) {
                                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 1550, 41899, 41900);
                                        CallChecker.isCalled(sb, StringBuffer.class, 1550, 41899, 41900).append(c);
                                    }
                                    (pos)++;
                                    break;
                                }
                        }
                    } 
                    int size = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(operands, List.class, 1557, 41978, 41985)) {
                        operands = CallChecker.beforeCalled(operands, List.class, 1557, 41978, 41985);
                        size = CallChecker.isCalled(operands, List.class, 1557, 41978, 41985).size();
                        CallChecker.varAssign(size, "size", 1557, 41978, 41985);
                    }
                    if (size == 0) {
                        return "";
                    }
                    if (size == 1) {
                        Object single = CallChecker.init(Object.class);
                        if (CallChecker.beforeDeref(operands, List.class, 1564, 42082, 42089)) {
                            operands = CallChecker.beforeCalled(operands, List.class, 1564, 42082, 42089);
                            single = CallChecker.isCalled(operands, List.class, 1564, 42082, 42089).get(0);
                            CallChecker.varAssign(single, "single", 1564, 42082, 42089);
                        }
                        if (single != null) {
                            return single;
                        }
                    }
                    if (CallChecker.beforeDeref(operands, List.class, 1571, 42173, 42180)) {
                        operands = CallChecker.beforeCalled(operands, List.class, 1571, 42173, 42180);
                        return CallChecker.isCalled(operands, List.class, 1571, 42173, 42180).toArray(new String[size]);
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Object) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1604.methodEnd();
                }
            }

            private void skipWhiteSpace() {
                MethodContext _bcornu_methode_context1605 = new MethodContext(void.class);
                try {
                    CallChecker.varInit(this, "this", 1574, 42218, 42376);
                    CallChecker.varInit(this.pos, "pos", 1574, 42218, 42376);
                    CallChecker.varInit(this.filterChars, "filterChars", 1574, 42218, 42376);
                    CallChecker.varInit(this.filterstring, "filterstring", 1574, 42218, 42376);
                    for (int length = CallChecker.isCalled(filterChars, char[].class, 1575, 42272, 42282).length; ((pos) < length) && (Character.isWhitespace(CallChecker.isCalled(filterChars, char[].class, 1575, 42333, 42343)[pos]));) {
                        (pos)++;
                    }
                } catch (ForceReturn _bcornu_return_t) {
                    _bcornu_return_t.getDecision().getValue();
                    return ;
                } finally {
                    _bcornu_methode_context1605.methodEnd();
                }
            }
        }
    }

    private static final class CaseInsensitiveMap extends AbstractMap<String, Object> implements Map<String, Object> {
        private final Dictionary<String, ?> dictionary;

        private final String[] keys;

        CaseInsensitiveMap(Dictionary<String, ?> dictionary) {
            MethodContext _bcornu_methode_context159 = new MethodContext(null);
            try {
                if (dictionary == null) {
                    this.dictionary = null;
                    CallChecker.varAssign(this.dictionary, "this.dictionary", 1601, 43140, 43162);
                    this.keys = new String[0];
                    CallChecker.varAssign(this.keys, "this.keys", 1602, 43168, 43193);
                    return ;
                }
                this.dictionary = dictionary;
                CallChecker.varAssign(this.dictionary, "this.dictionary", 1605, 43215, 43243);
                List<String> keyList = CallChecker.varInit(new ArrayList<String>(dictionary.size()), "keyList", 1606, 43248, 43311);
                for (Enumeration<?> e = dictionary.keys(); CallChecker.isCalled(e, Enumeration.class, 1607, 43359, 43359).hasMoreElements();) {
                    Object k = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(e, Enumeration.class, 1608, 43398, 43398)) {
                        k = e.nextElement();
                        CallChecker.varAssign(k, "k", 1608, 43398, 43398);
                    }
                    if (k instanceof String) {
                        String key = CallChecker.varInit(((String) (k)), "key", 1610, 43451, 43474);
                        if (CallChecker.beforeDeref(keyList, null, 1611, 43497, 43503)) {
                            for (String i : keyList) {
                                if (CallChecker.beforeDeref(key, String.class, 1612, 43518, 43520)) {
                                    key = CallChecker.beforeCalled(key, String.class, 1612, 43518, 43520);
                                    if (CallChecker.isCalled(key, String.class, 1612, 43518, 43520).equalsIgnoreCase(i)) {
                                        throw new IllegalArgumentException();
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                        if (CallChecker.beforeDeref(keyList, List.class, 1616, 43610, 43616)) {
                            keyList = CallChecker.beforeCalled(keyList, List.class, 1616, 43610, 43616);
                            CallChecker.isCalled(keyList, List.class, 1616, 43610, 43616).add(key);
                        }
                    }
                }
                keyList = CallChecker.beforeCalled(keyList, List.class, 1619, 43681, 43687);
                keyList = CallChecker.beforeCalled(keyList, List.class, 1619, 43654, 43660);
                this.keys = CallChecker.isCalled(keyList, List.class, 1619, 43654, 43660).toArray(new String[CallChecker.isCalled(keyList, List.class, 1619, 43681, 43687).size()]);
                CallChecker.varAssign(this.keys, "this.keys", 1619, 43642, 43697);
            } finally {
                _bcornu_methode_context159.methodEnd();
            }
        }

        @Override
        public Object get(Object o) {
            MethodContext _bcornu_methode_context1606 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 1623, 43706, 43900);
                CallChecker.varInit(o, "o", 1623, 43706, 43900);
                CallChecker.varInit(this.keys, "keys", 1623, 43706, 43900);
                CallChecker.varInit(this.dictionary, "dictionary", 1623, 43706, 43900);
                String k = CallChecker.varInit(((String) (o)), "k", 1624, 43751, 43772);
                if (CallChecker.beforeDeref(keys, Object.class, 1625, 43795, 43798)) {
                    for (String key : keys) {
                        if (CallChecker.beforeDeref(key, String.class, 1626, 43811, 43813)) {
                            if (CallChecker.isCalled(key, String.class, 1626, 43811, 43813).equalsIgnoreCase(k)) {
                                if (CallChecker.beforeDeref(dictionary, Dictionary.class, 1627, 43850, 43859)) {
                                    return dictionary.get(key);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1606.methodEnd();
            }
        }

        public Set<Map.Entry<String, Object>> entrySet() {
            MethodContext _bcornu_methode_context1607 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 1633, 43905, 44014);
                CallChecker.varInit(this.keys, "keys", 1633, 43905, 44014);
                CallChecker.varInit(this.dictionary, "dictionary", 1633, 43905, 44014);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<String, Object>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1607.methodEnd();
            }
        }
    }

    private static final class ServiceReferenceMap extends AbstractMap<String, Object> implements Map<String, Object> {
        private final ServiceReference<?> reference;

        ServiceReferenceMap(ServiceReference<?> reference) {
            MethodContext _bcornu_methode_context160 = new MethodContext(null);
            try {
                this.reference = reference;
                CallChecker.varAssign(this.reference, "this.reference", 1648, 44488, 44514);
            } finally {
                _bcornu_methode_context160.methodEnd();
            }
        }

        @Override
        public Object get(Object key) {
            MethodContext _bcornu_methode_context1608 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 1652, 44523, 44666);
                CallChecker.varInit(key, "key", 1652, 44523, 44666);
                CallChecker.varInit(this.reference, "reference", 1652, 44523, 44666);
                if ((reference) == null) {
                    return null;
                }
                return reference.getProperty(((String) (key)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1608.methodEnd();
            }
        }

        public Set<Map.Entry<String, Object>> entrySet() {
            MethodContext _bcornu_methode_context1609 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 1659, 44671, 44780);
                CallChecker.varInit(this.reference, "reference", 1659, 44671, 44780);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<String, Object>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1609.methodEnd();
            }
        }
    }

    private static final class SetAccessibleAction implements PrivilegedAction<Void> {
        private final AccessibleObject accessible;

        SetAccessibleAction(AccessibleObject accessible) {
            MethodContext _bcornu_methode_context161 = new MethodContext(null);
            try {
                this.accessible = accessible;
                CallChecker.varAssign(this.accessible, "this.accessible", 1668, 44972, 45000);
            } finally {
                _bcornu_methode_context161.methodEnd();
            }
        }

        public Void run() {
            MethodContext _bcornu_methode_context1610 = new MethodContext(Void.class);
            try {
                CallChecker.varInit(this, "this", 1671, 45009, 45082);
                CallChecker.varInit(this.accessible, "accessible", 1671, 45009, 45082);
                if (CallChecker.beforeDeref(accessible, AccessibleObject.class, 1672, 45032, 45041)) {
                    CallChecker.isCalled(accessible, AccessibleObject.class, 1672, 45032, 45041).setAccessible(true);
                }
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Void) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1610.methodEnd();
            }
        }
    }

    private static final class DNChainMatching {
        private static final String MINUS_WILDCARD = "-";

        private static final String STAR_WILDCARD = "*";

        private static boolean rdnmatch(List<?> rdn, List<?> rdnPattern) {
            MethodContext _bcornu_methode_context1611 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(rdnPattern, "rdnPattern", 1718, 46741, 47762);
                CallChecker.varInit(rdn, "rdn", 1718, 46741, 47762);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 1718, 46741, 47762);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 1718, 46741, 47762);
                if (CallChecker.beforeDeref(rdn, List.class, 1719, 47081, 47083)) {
                    if (CallChecker.beforeDeref(rdnPattern, List.class, 1719, 47095, 47104)) {
                        rdn = CallChecker.beforeCalled(rdn, List.class, 1719, 47081, 47083);
                        rdnPattern = CallChecker.beforeCalled(rdnPattern, List.class, 1719, 47095, 47104);
                        if ((CallChecker.isCalled(rdn, List.class, 1719, 47081, 47083).size()) != (CallChecker.isCalled(rdnPattern, List.class, 1719, 47095, 47104).size())) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                rdn = CallChecker.beforeCalled(rdn, List.class, 1722, 47162, 47164);
                for (int i = 0; i < (CallChecker.isCalled(rdn, List.class, 1722, 47162, 47164).size()); i++) {
                    String rdnNameValue = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(rdn, List.class, 1723, 47216, 47218)) {
                        rdnNameValue = ((String) (rdn.get(i)));
                        CallChecker.varAssign(rdnNameValue, "rdnNameValue", 1723, 47216, 47218);
                    }
                    String patNameValue = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(rdnPattern, List.class, 1724, 47263, 47272)) {
                        patNameValue = ((String) (rdnPattern.get(i)));
                        CallChecker.varAssign(patNameValue, "patNameValue", 1724, 47263, 47272);
                    }
                    int rdnNameEnd = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(rdnNameValue, String.class, 1725, 47303, 47314)) {
                        rdnNameValue = CallChecker.beforeCalled(rdnNameValue, String.class, 1725, 47303, 47314);
                        rdnNameEnd = CallChecker.isCalled(rdnNameValue, String.class, 1725, 47303, 47314).indexOf('=');
                        CallChecker.varAssign(rdnNameEnd, "rdnNameEnd", 1725, 47303, 47314);
                    }
                    int patNameEnd = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(patNameValue, String.class, 1726, 47351, 47362)) {
                        patNameValue = CallChecker.beforeCalled(patNameValue, String.class, 1726, 47351, 47362);
                        patNameEnd = CallChecker.isCalled(patNameValue, String.class, 1726, 47351, 47362).indexOf('=');
                        CallChecker.varAssign(patNameEnd, "patNameEnd", 1726, 47351, 47362);
                    }
                    if (CallChecker.beforeDeref(rdnNameValue, String.class, 1727, 47415, 47426)) {
                        rdnNameValue = CallChecker.beforeCalled(rdnNameValue, String.class, 1727, 47415, 47426);
                        if ((rdnNameEnd != patNameEnd) || (!(CallChecker.isCalled(rdnNameValue, String.class, 1727, 47415, 47426).regionMatches(0, patNameValue, 0, rdnNameEnd)))) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    String patValue = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(patNameValue, String.class, 1730, 47524, 47535)) {
                        patNameValue = CallChecker.beforeCalled(patNameValue, String.class, 1730, 47524, 47535);
                        patValue = CallChecker.isCalled(patNameValue, String.class, 1730, 47524, 47535).substring(patNameEnd);
                        CallChecker.varAssign(patValue, "patValue", 1730, 47524, 47535);
                    }
                    String rdnValue = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(rdnNameValue, String.class, 1731, 47582, 47593)) {
                        rdnNameValue = CallChecker.beforeCalled(rdnNameValue, String.class, 1731, 47582, 47593);
                        rdnValue = CallChecker.isCalled(rdnNameValue, String.class, 1731, 47582, 47593).substring(rdnNameEnd);
                        CallChecker.varAssign(rdnValue, "rdnValue", 1731, 47582, 47593);
                    }
                    if (CallChecker.beforeDeref(rdnValue, String.class, 1732, 47627, 47634)) {
                        if (CallChecker.beforeDeref(patValue, String.class, 1732, 47657, 47664)) {
                            if (CallChecker.beforeDeref(patValue, String.class, 1732, 47683, 47690)) {
                                rdnValue = CallChecker.beforeCalled(rdnValue, String.class, 1732, 47627, 47634);
                                patValue = CallChecker.beforeCalled(patValue, String.class, 1732, 47657, 47664);
                                patValue = CallChecker.beforeCalled(patValue, String.class, 1732, 47683, 47690);
                                if (((!(CallChecker.isCalled(rdnValue, String.class, 1732, 47627, 47634).equals(patValue))) && (!(CallChecker.isCalled(patValue, String.class, 1732, 47657, 47664).equals("=*")))) && (!(CallChecker.isCalled(patValue, String.class, 1732, 47683, 47690).equals("=#16012a")))) {
                                    return false;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1611.methodEnd();
            }
        }

        private static boolean dnmatch(List<?> dn, List<?> dnPattern) {
            MethodContext _bcornu_methode_context1612 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(dnPattern, "dnPattern", 1739, 47767, 48584);
                CallChecker.varInit(dn, "dn", 1739, 47767, 48584);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 1739, 47767, 48584);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 1739, 47767, 48584);
                int dnStart = CallChecker.varInit(((int) (0)), "dnStart", 1740, 47834, 47849);
                int patStart = CallChecker.varInit(((int) (0)), "patStart", 1741, 47854, 47870);
                int patLen = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(dnPattern, List.class, 1742, 47888, 47896)) {
                    dnPattern = CallChecker.beforeCalled(dnPattern, List.class, 1742, 47888, 47896);
                    patLen = CallChecker.isCalled(dnPattern, List.class, 1742, 47888, 47896).size();
                    CallChecker.varAssign(patLen, "patLen", 1742, 47888, 47896);
                }
                if (patLen == 0) {
                    return false;
                }
                if (CallChecker.beforeDeref(dnPattern, List.class, 1746, 47958, 47966)) {
                    if (CallChecker.beforeDeref(dnPattern.get(0), null, 1746, 47958, 47973)) {
                        if (dnPattern.get(0).equals(FrameworkUtil.DNChainMatching.STAR_WILDCARD)) {
                            patStart = 1;
                            CallChecker.varAssign(patStart, "patStart", 1747, 48004, 48016);
                            patLen--;
                        }
                    }
                }
                if (CallChecker.beforeDeref(dn, List.class, 1750, 48044, 48045)) {
                    dn = CallChecker.beforeCalled(dn, List.class, 1750, 48044, 48045);
                    if ((CallChecker.isCalled(dn, List.class, 1750, 48044, 48045).size()) < patLen) {
                        return false;
                    }else {
                        if (CallChecker.beforeDeref(dn, List.class, 1753, 48104, 48105)) {
                            dn = CallChecker.beforeCalled(dn, List.class, 1753, 48104, 48105);
                            if ((CallChecker.isCalled(dn, List.class, 1753, 48104, 48105).size()) > patLen) {
                                if (CallChecker.beforeDeref(dnPattern, List.class, 1754, 48136, 48144)) {
                                    if (CallChecker.beforeDeref(dnPattern.get(0), null, 1754, 48136, 48151)) {
                                        if (!(dnPattern.get(0).equals(FrameworkUtil.DNChainMatching.STAR_WILDCARD))) {
                                            return false;
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (CallChecker.beforeDeref(dn, List.class, 1761, 48376, 48377)) {
                                    dn = CallChecker.beforeCalled(dn, List.class, 1761, 48376, 48377);
                                    dnStart = (CallChecker.isCalled(dn, List.class, 1761, 48376, 48377).size()) - patLen;
                                    CallChecker.varAssign(dnStart, "dnStart", 1761, 48366, 48394);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                for (int i = 0; i < patLen; i++) {
                    if (CallChecker.beforeDeref(dn, List.class, 1765, 48473, 48474)) {
                        if (CallChecker.beforeDeref(dnPattern, List.class, 1765, 48504, 48512)) {
                            if (!(FrameworkUtil.DNChainMatching.rdnmatch(((List<?>) (dn.get((i + dnStart)))), ((List<?>) (dnPattern.get((i + patStart))))))) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1612.methodEnd();
            }
        }

        private static List<Object> parseDNchainPattern(String pattern) {
            MethodContext _bcornu_methode_context1613 = new MethodContext(List.class);
            try {
                CallChecker.varInit(pattern, "pattern", 1785, 48589, 51215);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 1785, 48589, 51215);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 1785, 48589, 51215);
                if (pattern == null) {
                    throw new IllegalArgumentException("The pattern must not be null.");
                }
                List<Object> parsed = CallChecker.varInit(new ArrayList<Object>(), "parsed", 1789, 49327, 49372);
                final int length = CallChecker.varInit(((int) (pattern.length())), "length", 1790, 49377, 49412);
                char c = CallChecker.varInit(((char) (';')), "c", 1791, 49417, 49429);
                for (int startIndex = FrameworkUtil.DNChainMatching.skipSpaces(pattern, 0); startIndex < length;) {
                    int cursor = CallChecker.varInit(((int) (startIndex)), "cursor", 1793, 49557, 49580);
                    int endIndex = CallChecker.varInit(((int) (startIndex)), "endIndex", 1794, 49586, 49611);
                    out : for (boolean inQuote = false; cursor < length; cursor++) {
                        c = pattern.charAt(cursor);
                        CallChecker.varAssign(c, "c", 1796, 49686, 49712);
                        switch (c) {
                            case '"' :
                                inQuote = !inQuote;
                                CallChecker.varAssign(inQuote, "inQuote", 1799, 49756, 49774);
                                break;
                            case '\\' :
                                cursor++;
                                if (cursor == length) {
                                    throw new IllegalArgumentException("unterminated escape");
                                }
                                break;
                            case ';' :
                                if (!inQuote) {
                                    break out;
                                }
                                break;
                        }
                        if (c != ' ') {
                            endIndex = cursor + 1;
                            CallChecker.varAssign(endIndex, "endIndex", 1814, 50135, 50156);
                        }
                    }
                    if (CallChecker.beforeDeref(parsed, List.class, 1817, 50175, 50180)) {
                        parsed = CallChecker.beforeCalled(parsed, List.class, 1817, 50175, 50180);
                        CallChecker.isCalled(parsed, List.class, 1817, 50175, 50180).add(pattern.substring(startIndex, endIndex));
                    }
                    startIndex = FrameworkUtil.DNChainMatching.skipSpaces(pattern, (cursor + 1));
                    CallChecker.varAssign(startIndex, "startIndex", 1818, 50232, 50276);
                }
                if (c == ';') {
                    throw new IllegalArgumentException("empty pattern");
                }
                parsed = CallChecker.beforeCalled(parsed, List.class, 1826, 50527, 50532);
                for (int i = 0; i < (CallChecker.isCalled(parsed, List.class, 1826, 50527, 50532).size()); i++) {
                    String dn = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(parsed, List.class, 1827, 50574, 50579)) {
                        parsed = CallChecker.beforeCalled(parsed, List.class, 1827, 50574, 50579);
                        dn = ((String) (CallChecker.isCalled(parsed, List.class, 1827, 50574, 50579).get(i)));
                        CallChecker.varAssign(dn, "dn", 1827, 50574, 50579);
                    }
                    if (CallChecker.beforeDeref(dn, String.class, 1828, 50597, 50598)) {
                        if (CallChecker.beforeDeref(dn, String.class, 1828, 50625, 50626)) {
                            dn = CallChecker.beforeCalled(dn, String.class, 1828, 50597, 50598);
                            dn = CallChecker.beforeCalled(dn, String.class, 1828, 50625, 50626);
                            if ((CallChecker.isCalled(dn, String.class, 1828, 50597, 50598).equals(FrameworkUtil.DNChainMatching.STAR_WILDCARD)) || (CallChecker.isCalled(dn, String.class, 1828, 50625, 50626).equals(FrameworkUtil.DNChainMatching.MINUS_WILDCARD))) {
                                continue;
                            }
                        }
                    }
                    List<Object> rdns = CallChecker.varInit(new ArrayList<Object>(), "rdns", 1831, 50679, 50722);
                    if (CallChecker.beforeDeref(dn, String.class, 1832, 50732, 50733)) {
                        dn = CallChecker.beforeCalled(dn, String.class, 1832, 50732, 50733);
                        if ((CallChecker.isCalled(dn, String.class, 1832, 50732, 50733).charAt(0)) == '*') {
                            int index = CallChecker.varInit(((int) (FrameworkUtil.DNChainMatching.skipSpaces(dn, 1))), "index", 1833, 50760, 50789);
                            if (CallChecker.beforeDeref(dn, String.class, 1834, 50800, 50801)) {
                                dn = CallChecker.beforeCalled(dn, String.class, 1834, 50800, 50801);
                                if ((CallChecker.isCalled(dn, String.class, 1834, 50800, 50801).charAt(index)) != ',') {
                                    throw new IllegalArgumentException("invalid wildcard prefix");
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(rdns, List.class, 1837, 50908, 50911)) {
                                rdns = CallChecker.beforeCalled(rdns, List.class, 1837, 50908, 50911);
                                CallChecker.isCalled(rdns, List.class, 1837, 50908, 50911).add(FrameworkUtil.DNChainMatching.STAR_WILDCARD);
                            }
                            if (CallChecker.beforeDeref(dn, String.class, 1838, 50961, 50962)) {
                                dn = CallChecker.beforeCalled(dn, String.class, 1838, 50961, 50962);
                                if (CallChecker.beforeDeref(new X500Principal(CallChecker.isCalled(dn, String.class, 1838, 50961, 50962).substring((index + 1))), X500Principal.class, 1838, 50943, 50984)) {
                                    dn = CallChecker.beforeCalled(dn, String.class, 1838, 50961, 50962);
                                    dn = CallChecker.isCalled(new X500Principal(CallChecker.isCalled(dn, String.class, 1838, 50961, 50962).substring((index + 1))), X500Principal.class, 1838, 50943, 50984).getName(X500Principal.CANONICAL);
                                    CallChecker.varAssign(dn, "dn", 1838, 50938, 51018);
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(new X500Principal(dn), X500Principal.class, 1840, 51043, 51063)) {
                                dn = CallChecker.isCalled(new X500Principal(dn), X500Principal.class, 1840, 51043, 51063).getName(X500Principal.CANONICAL);
                                CallChecker.varAssign(dn, "dn", 1840, 51038, 51097);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    FrameworkUtil.DNChainMatching.parseDN(dn, rdns);
                    if (CallChecker.beforeDeref(parsed, List.class, 1844, 51169, 51174)) {
                        parsed = CallChecker.beforeCalled(parsed, List.class, 1844, 51169, 51174);
                        CallChecker.isCalled(parsed, List.class, 1844, 51169, 51174).set(i, rdns);
                    }
                }
                return parsed;
            } catch (ForceReturn _bcornu_return_t) {
                return ((List<Object>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1613.methodEnd();
            }
        }

        private static List<Object> parseDNchain(List<String> chain) {
            MethodContext _bcornu_methode_context1614 = new MethodContext(List.class);
            try {
                CallChecker.varInit(chain, "chain", 1849, 51220, 51867);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 1849, 51220, 51867);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 1849, 51220, 51867);
                if (chain == null) {
                    throw new IllegalArgumentException("DN chain must not be null.");
                }
                List<Object> result = CallChecker.varInit(new ArrayList<Object>(chain.size()), "result", 1853, 51385, 51442);
                for (String dn : chain) {
                    if (CallChecker.beforeDeref(new X500Principal(dn), X500Principal.class, 1857, 51563, 51583)) {
                        dn = CallChecker.isCalled(new X500Principal(dn), X500Principal.class, 1857, 51563, 51583).getName(X500Principal.CANONICAL);
                        CallChecker.varAssign(dn, "dn", 1857, 51558, 51617);
                    }
                    List<Object> rdns = CallChecker.varInit(new ArrayList<Object>(), "rdns", 1859, 51660, 51703);
                    FrameworkUtil.DNChainMatching.parseDN(dn, rdns);
                    if (CallChecker.beforeDeref(result, List.class, 1861, 51732, 51737)) {
                        result = CallChecker.beforeCalled(result, List.class, 1861, 51732, 51737);
                        CallChecker.isCalled(result, List.class, 1861, 51732, 51737).add(rdns);
                    }
                }
                if (CallChecker.beforeDeref(result, List.class, 1863, 51762, 51767)) {
                    result = CallChecker.beforeCalled(result, List.class, 1863, 51762, 51767);
                    if ((CallChecker.isCalled(result, List.class, 1863, 51762, 51767).size()) == 0) {
                        throw new IllegalArgumentException("empty DN chain");
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return result;
            } catch (ForceReturn _bcornu_return_t) {
                return ((List<Object>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1614.methodEnd();
            }
        }

        private static int skipSpaces(String dnChain, int startIndex) {
            MethodContext _bcornu_methode_context1615 = new MethodContext(int.class);
            try {
                CallChecker.varInit(startIndex, "startIndex", 1873, 51872, 52189);
                CallChecker.varInit(dnChain, "dnChain", 1873, 51872, 52189);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 1873, 51872, 52189);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 1873, 51872, 52189);
                dnChain = CallChecker.beforeCalled(dnChain, String.class, 1874, 52085, 52091);
                dnChain = CallChecker.beforeCalled(dnChain, String.class, 1874, 52105, 52111);
                while ((startIndex < (CallChecker.isCalled(dnChain, String.class, 1874, 52085, 52091).length())) && ((CallChecker.isCalled(dnChain, String.class, 1874, 52105, 52111).charAt(startIndex)) == ' ')) {
                    startIndex++;
                } 
                return startIndex;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1615.methodEnd();
            }
        }

        private static void parseDN(String dn, List<Object> rdn) {
            MethodContext _bcornu_methode_context1616 = new MethodContext(void.class);
            try {
                CallChecker.varInit(rdn, "rdn", 1888, 52194, 53444);
                CallChecker.varInit(dn, "dn", 1888, 52194, 53444);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 1888, 52194, 53444);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 1888, 52194, 53444);
                int startIndex = CallChecker.varInit(((int) (0)), "startIndex", 1889, 52575, 52593);
                char c = CallChecker.varInit(((char) (' ')), "c", 1890, 52598, 52611);
                List<String> nameValues = CallChecker.varInit(new ArrayList<String>(), "nameValues", 1891, 52616, 52665);
                dn = CallChecker.beforeCalled(dn, String.class, 1892, 52690, 52691);
                while (startIndex < (CallChecker.isCalled(dn, String.class, 1892, 52690, 52691).length())) {
                    int endIndex = CallChecker.init(int.class);
                    dn = CallChecker.beforeCalled(dn, String.class, 1894, 52766, 52767);
                    for (endIndex = startIndex; endIndex < (CallChecker.isCalled(dn, String.class, 1894, 52766, 52767).length()); endIndex++) {
                        CallChecker.varAssign(endIndex, "endIndex", 1894, 52732, 52752);
                        if (CallChecker.beforeDeref(dn, String.class, 1895, 52802, 52803)) {
                            dn = CallChecker.beforeCalled(dn, String.class, 1895, 52802, 52803);
                            c = CallChecker.isCalled(dn, String.class, 1895, 52802, 52803).charAt(endIndex);
                            CallChecker.varAssign(c, "c", 1895, 52798, 52821);
                        }
                        if ((c == ',') || (c == '+')) {
                            break;
                        }
                        if (c == '\\') {
                            endIndex++;
                        }
                    }
                    if (CallChecker.beforeDeref(dn, String.class, 1903, 52973, 52974)) {
                        dn = CallChecker.beforeCalled(dn, String.class, 1903, 52973, 52974);
                        if (endIndex > (CallChecker.isCalled(dn, String.class, 1903, 52973, 52974).length())) {
                            throw new IllegalArgumentException(("unterminated escape " + dn));
                        }
                    }
                    if (CallChecker.beforeDeref(dn, String.class, 1906, 53083, 53084)) {
                        if (CallChecker.beforeDeref(nameValues, List.class, 1906, 53068, 53077)) {
                            dn = CallChecker.beforeCalled(dn, String.class, 1906, 53083, 53084);
                            nameValues = CallChecker.beforeCalled(nameValues, List.class, 1906, 53068, 53077);
                            CallChecker.isCalled(nameValues, List.class, 1906, 53068, 53077).add(CallChecker.isCalled(dn, String.class, 1906, 53083, 53084).substring(startIndex, endIndex));
                        }
                    }
                    if (c != '+') {
                        if (CallChecker.beforeDeref(rdn, List.class, 1908, 53145, 53147)) {
                            rdn = CallChecker.beforeCalled(rdn, List.class, 1908, 53145, 53147);
                            CallChecker.isCalled(rdn, List.class, 1908, 53145, 53147).add(nameValues);
                        }
                        if (CallChecker.beforeDeref(dn, String.class, 1909, 53187, 53188)) {
                            dn = CallChecker.beforeCalled(dn, String.class, 1909, 53187, 53188);
                            if (endIndex != (CallChecker.isCalled(dn, String.class, 1909, 53187, 53188).length())) {
                                nameValues = new ArrayList<String>();
                                CallChecker.varAssign(nameValues, "nameValues", 1910, 53208, 53244);
                            }else {
                                nameValues = null;
                                CallChecker.varAssign(nameValues, "nameValues", 1912, 53266, 53283);
                            }
                        }
                    }
                    startIndex = endIndex + 1;
                    CallChecker.varAssign(startIndex, "startIndex", 1915, 53302, 53327);
                } 
                if (nameValues != null) {
                    throw new IllegalArgumentException(("improperly terminated DN " + dn));
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1616.methodEnd();
            }
        }

        private static int skipWildCards(List<Object> dnChainPattern, int dnChainPatternIndex) {
            MethodContext _bcornu_methode_context1617 = new MethodContext(int.class);
            try {
                CallChecker.varInit(dnChainPatternIndex, "dnChainPatternIndex", 1926, 53449, 54437);
                CallChecker.varInit(dnChainPattern, "dnChainPattern", 1926, 53449, 54437);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 1926, 53449, 54437);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 1926, 53449, 54437);
                int i = CallChecker.init(int.class);
                dnChainPattern = CallChecker.beforeCalled(dnChainPattern, List.class, 1928, 53696, 53709);
                for (i = dnChainPatternIndex; i < (CallChecker.isCalled(dnChainPattern, List.class, 1928, 53696, 53709).size()); i++) {
                    CallChecker.varAssign(i, "i", 1928, 53667, 53689);
                    Object dnPattern = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(dnChainPattern, List.class, 1929, 53749, 53762)) {
                        dnChainPattern = CallChecker.beforeCalled(dnChainPattern, List.class, 1929, 53749, 53762);
                        dnPattern = CallChecker.isCalled(dnChainPattern, List.class, 1929, 53749, 53762).get(i);
                        CallChecker.varAssign(dnPattern, "dnPattern", 1929, 53749, 53762);
                    }
                    if (dnPattern instanceof String) {
                        if (CallChecker.beforeDeref(dnPattern, Object.class, 1931, 53821, 53829)) {
                            if (CallChecker.beforeDeref(dnPattern, Object.class, 1931, 53857, 53865)) {
                                dnPattern = CallChecker.beforeCalled(dnPattern, Object.class, 1931, 53821, 53829);
                                dnPattern = CallChecker.beforeCalled(dnPattern, Object.class, 1931, 53857, 53865);
                                if ((!(CallChecker.isCalled(dnPattern, Object.class, 1931, 53821, 53829).equals(FrameworkUtil.DNChainMatching.STAR_WILDCARD))) && (!(CallChecker.isCalled(dnPattern, Object.class, 1931, 53857, 53865).equals(FrameworkUtil.DNChainMatching.MINUS_WILDCARD)))) {
                                    throw new IllegalArgumentException("expected wildcard in DN pattern");
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        if (dnPattern instanceof List<?>) {
                            break;
                        }else {
                            throw new IllegalArgumentException("expected String or List in DN Pattern");
                        }
                    }
                }
                return i;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1617.methodEnd();
            }
        }

        private static boolean dnChainMatch(List<Object> dnChain, int dnChainIndex, List<Object> dnChainPattern, int dnChainPatternIndex) throws IllegalArgumentException {
            MethodContext _bcornu_methode_context1618 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(dnChainPatternIndex, "dnChainPatternIndex", 1955, 54442, 58788);
                CallChecker.varInit(dnChainPattern, "dnChainPattern", 1955, 54442, 58788);
                CallChecker.varInit(dnChainIndex, "dnChainIndex", 1955, 54442, 58788);
                CallChecker.varInit(dnChain, "dnChain", 1955, 54442, 58788);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 1955, 54442, 58788);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 1955, 54442, 58788);
                if (CallChecker.beforeDeref(dnChain, List.class, 1956, 54852, 54858)) {
                    dnChain = CallChecker.beforeCalled(dnChain, List.class, 1956, 54852, 54858);
                    if (dnChainIndex >= (CallChecker.isCalled(dnChain, List.class, 1956, 54852, 54858).size())) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(dnChainPattern, List.class, 1959, 54923, 54936)) {
                    dnChainPattern = CallChecker.beforeCalled(dnChainPattern, List.class, 1959, 54923, 54936);
                    if (dnChainPatternIndex >= (CallChecker.isCalled(dnChainPattern, List.class, 1959, 54923, 54936).size())) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                Object dnPattern = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(dnChainPattern, List.class, 1963, 55041, 55054)) {
                    dnChainPattern = CallChecker.beforeCalled(dnChainPattern, List.class, 1963, 55041, 55054);
                    dnPattern = CallChecker.isCalled(dnChainPattern, List.class, 1963, 55041, 55054).get(dnChainPatternIndex);
                    CallChecker.varAssign(dnPattern, "dnPattern", 1963, 55041, 55054);
                }
                if (dnPattern instanceof String) {
                    if (CallChecker.beforeDeref(dnPattern, Object.class, 1965, 55129, 55137)) {
                        if (CallChecker.beforeDeref(dnPattern, Object.class, 1965, 55165, 55173)) {
                            dnPattern = CallChecker.beforeCalled(dnPattern, Object.class, 1965, 55129, 55137);
                            dnPattern = CallChecker.beforeCalled(dnPattern, Object.class, 1965, 55165, 55173);
                            if ((!(CallChecker.isCalled(dnPattern, Object.class, 1965, 55129, 55137).equals(FrameworkUtil.DNChainMatching.STAR_WILDCARD))) && (!(CallChecker.isCalled(dnPattern, Object.class, 1965, 55165, 55173).equals(FrameworkUtil.DNChainMatching.MINUS_WILDCARD)))) {
                                throw new IllegalArgumentException("expected wildcard in DN pattern");
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(dnPattern, Object.class, 1970, 55379, 55387)) {
                        dnPattern = CallChecker.beforeCalled(dnPattern, Object.class, 1970, 55379, 55387);
                        if (CallChecker.isCalled(dnPattern, Object.class, 1970, 55379, 55387).equals(FrameworkUtil.DNChainMatching.MINUS_WILDCARD)) {
                            dnChainPatternIndex = FrameworkUtil.DNChainMatching.skipWildCards(dnChainPattern, dnChainPatternIndex);
                            CallChecker.varAssign(dnChainPatternIndex, "dnChainPatternIndex", 1971, 55420, 55492);
                        }else {
                            dnChainPatternIndex++;
                        }
                    }
                    if (CallChecker.beforeDeref(dnChainPattern, List.class, 1975, 55602, 55615)) {
                        dnChainPattern = CallChecker.beforeCalled(dnChainPattern, List.class, 1975, 55602, 55615);
                        if (dnChainPatternIndex >= (CallChecker.isCalled(dnChainPattern, List.class, 1975, 55602, 55615).size())) {
                            if (CallChecker.beforeDeref(dnPattern, Object.class, 1978, 55729, 55737)) {
                                dnPattern = CallChecker.beforeCalled(dnPattern, Object.class, 1978, 55729, 55737);
                                if (CallChecker.isCalled(dnPattern, Object.class, 1978, 55729, 55737).equals(FrameworkUtil.DNChainMatching.MINUS_WILDCARD)) {
                                    return true;
                                }else {
                                    dnChain = CallChecker.beforeCalled(dnChain, List.class, 1978, 55771, 55777);
                                    return ((CallChecker.isCalled(dnChain, List.class, 1978, 55771, 55777).size()) - 1) == dnChainIndex;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(dnPattern, Object.class, 1985, 55991, 55999)) {
                        dnPattern = CallChecker.beforeCalled(dnPattern, Object.class, 1985, 55991, 55999);
                        if (CallChecker.isCalled(dnPattern, Object.class, 1985, 55991, 55999).equals(FrameworkUtil.DNChainMatching.STAR_WILDCARD)) {
                            return (FrameworkUtil.DNChainMatching.dnChainMatch(dnChain, dnChainIndex, dnChainPattern, dnChainPatternIndex)) || (FrameworkUtil.DNChainMatching.dnChainMatch(dnChain, (dnChainIndex + 1), dnChainPattern, dnChainPatternIndex));
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    dnChain = CallChecker.beforeCalled(dnChain, List.class, 1989, 56277, 56283);
                    for (int i = dnChainIndex; i < (CallChecker.isCalled(dnChain, List.class, 1989, 56277, 56283).size()); i++) {
                        if (FrameworkUtil.DNChainMatching.dnChainMatch(dnChain, i, dnChainPattern, dnChainPatternIndex)) {
                            return true;
                        }
                    }
                }else {
                    if (dnPattern instanceof List<?>) {
                        do {
                            if (CallChecker.beforeDeref(dnChain, List.class, 2002, 56722, 56728)) {
                                dnChain = CallChecker.beforeCalled(dnChain, List.class, 2002, 56722, 56728);
                                if (!(FrameworkUtil.DNChainMatching.dnmatch(((List<?>) (CallChecker.isCalled(dnChain, List.class, 2002, 56722, 56728).get(dnChainIndex))), ((List<?>) (dnPattern))))) {
                                    return false;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            dnChainIndex++;
                            dnChainPatternIndex++;
                            if (CallChecker.beforeDeref(dnChain, List.class, 2009, 56987, 56993)) {
                                if (CallChecker.beforeDeref(dnChainPattern, List.class, 2009, 57030, 57043)) {
                                    dnChain = CallChecker.beforeCalled(dnChain, List.class, 2009, 56987, 56993);
                                    dnChainPattern = CallChecker.beforeCalled(dnChainPattern, List.class, 2009, 57030, 57043);
                                    if ((dnChainIndex >= (CallChecker.isCalled(dnChain, List.class, 2009, 56987, 56993).size())) && (dnChainPatternIndex >= (CallChecker.isCalled(dnChainPattern, List.class, 2009, 57030, 57043).size()))) {
                                        return true;
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(dnChain, List.class, 2015, 57262, 57268)) {
                                dnChain = CallChecker.beforeCalled(dnChain, List.class, 2015, 57262, 57268);
                                if (dnChainIndex >= (CallChecker.isCalled(dnChain, List.class, 2015, 57262, 57268).size())) {
                                    dnChainPatternIndex = FrameworkUtil.DNChainMatching.skipWildCards(dnChainPattern, dnChainPatternIndex);
                                    CallChecker.varAssign(dnChainPatternIndex, "dnChainPatternIndex", 2016, 57287, 57359);
                                    dnChainPattern = CallChecker.beforeCalled(dnChainPattern, List.class, 2020, 57544, 57557);
                                    return dnChainPatternIndex >= (CallChecker.isCalled(dnChainPattern, List.class, 2020, 57544, 57557).size());
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(dnChainPattern, List.class, 2024, 57700, 57713)) {
                                dnChainPattern = CallChecker.beforeCalled(dnChainPattern, List.class, 2024, 57700, 57713);
                                if (dnChainPatternIndex >= (CallChecker.isCalled(dnChainPattern, List.class, 2024, 57700, 57713).size())) {
                                    return false;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(dnChainPattern, List.class, 2028, 57805, 57818)) {
                                dnChainPattern = CallChecker.beforeCalled(dnChainPattern, List.class, 2028, 57805, 57818);
                                dnPattern = CallChecker.isCalled(dnChainPattern, List.class, 2028, 57805, 57818).get(dnChainPatternIndex);
                                CallChecker.varAssign(dnPattern, "dnPattern", 2028, 57793, 57844);
                            }
                            if (dnPattern instanceof String) {
                                if (CallChecker.beforeDeref(dnPattern, Object.class, 2030, 57899, 57907)) {
                                    if (CallChecker.beforeDeref(dnPattern, Object.class, 2030, 57935, 57943)) {
                                        dnPattern = CallChecker.beforeCalled(dnPattern, Object.class, 2030, 57899, 57907);
                                        dnPattern = CallChecker.beforeCalled(dnPattern, Object.class, 2030, 57935, 57943);
                                        if ((!(CallChecker.isCalled(dnPattern, Object.class, 2030, 57899, 57907).equals(FrameworkUtil.DNChainMatching.STAR_WILDCARD))) && (!(CallChecker.isCalled(dnPattern, Object.class, 2030, 57935, 57943).equals(FrameworkUtil.DNChainMatching.MINUS_WILDCARD)))) {
                                            throw new IllegalArgumentException("expected wildcard in DN pattern");
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                                return FrameworkUtil.DNChainMatching.dnChainMatch(dnChain, dnChainIndex, dnChainPattern, dnChainPatternIndex);
                            }else {
                                if (!(dnPattern instanceof List<?>)) {
                                    throw new IllegalArgumentException("expected String or List in DN Pattern");
                                }
                            }
                        } while (true );
                    }else {
                        throw new IllegalArgumentException("expected String or List in DN Pattern");
                    }
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1618.methodEnd();
            }
        }

        static boolean match(String pattern, List<String> dnChain) {
            MethodContext _bcornu_methode_context1619 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(dnChain, "dnChain", 2087, 58793, 61233);
                CallChecker.varInit(pattern, "pattern", 2087, 58793, 61233);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 2087, 58793, 61233);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 2087, 58793, 61233);
                List<Object> parsedDNChain = CallChecker.init(List.class);
                List<Object> parsedDNPattern = CallChecker.init(List.class);
                TryContext _bcornu_try_context_442 = new TryContext(442, FrameworkUtil.class, "java.lang.RuntimeException");
                try {
                    parsedDNChain = FrameworkUtil.DNChainMatching.parseDNchain(dnChain);
                    CallChecker.varAssign(parsedDNChain, "parsedDNChain", 2091, 60708, 60745);
                } catch (RuntimeException e) {
                    _bcornu_try_context_442.catchStart(442);
                    IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException(("Invalid DN chain: " + (FrameworkUtil.DNChainMatching.toString(dnChain)))), "iae", 2093, 60785, 60886);
                    if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 2094, 60892, 60894)) {
                        iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 2094, 60892, 60894);
                        CallChecker.isCalled(iae, IllegalArgumentException.class, 2094, 60892, 60894).initCause(e);
                    }
                    throw iae;
                } finally {
                    _bcornu_try_context_442.finallyStart(442);
                }
                TryContext _bcornu_try_context_443 = new TryContext(443, FrameworkUtil.class, "java.lang.RuntimeException");
                try {
                    parsedDNPattern = FrameworkUtil.DNChainMatching.parseDNchainPattern(pattern);
                    CallChecker.varAssign(parsedDNPattern, "parsedDNPattern", 2098, 60943, 60989);
                } catch (RuntimeException e) {
                    _bcornu_try_context_443.catchStart(443);
                    IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException(("Invalid match pattern: " + pattern)), "iae", 2100, 61029, 61125);
                    if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 2101, 61131, 61133)) {
                        iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 2101, 61131, 61133);
                        CallChecker.isCalled(iae, IllegalArgumentException.class, 2101, 61131, 61133).initCause(e);
                    }
                    throw iae;
                } finally {
                    _bcornu_try_context_443.finallyStart(443);
                }
                return FrameworkUtil.DNChainMatching.dnChainMatch(parsedDNChain, 0, parsedDNPattern, 0);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1619.methodEnd();
            }
        }

        private static String toString(List<?> dnChain) {
            MethodContext _bcornu_methode_context1620 = new MethodContext(String.class);
            try {
                CallChecker.varInit(dnChain, "dnChain", 2107, 61238, 61565);
                CallChecker.varInit(STAR_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.STAR_WILDCARD", 2107, 61238, 61565);
                CallChecker.varInit(MINUS_WILDCARD, "org.osgi.framework.FrameworkUtil.DNChainMatching.MINUS_WILDCARD", 2107, 61238, 61565);
                if (dnChain == null) {
                    return null;
                }
                StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 2111, 61339, 61375);
                for (Iterator<?> iChain = dnChain.iterator(); CallChecker.isCalled(iChain, Iterator.class, 2112, 61426, 61431).hasNext();) {
                    if (CallChecker.beforeDeref(iChain, Iterator.class, 2113, 61461, 61466)) {
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2113, 61451, 61452)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2113, 61451, 61452);
                            CallChecker.isCalled(sb, StringBuffer.class, 2113, 61451, 61452).append(iChain.next());
                        }
                    }
                    if (CallChecker.beforeDeref(iChain, Iterator.class, 2114, 61485, 61490)) {
                        if (CallChecker.isCalled(iChain, Iterator.class, 2114, 61485, 61490).hasNext()) {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2115, 61510, 61511)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2115, 61510, 61511);
                                CallChecker.isCalled(sb, StringBuffer.class, 2115, 61510, 61511).append("; ");
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2118, 61548, 61549)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2118, 61548, 61549);
                    return CallChecker.isCalled(sb, StringBuffer.class, 2118, 61548, 61549).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1620.methodEnd();
            }
        }
    }
}

