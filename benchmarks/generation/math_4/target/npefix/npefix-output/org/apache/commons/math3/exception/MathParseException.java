package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.ExceptionContextProvider;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MathParseException extends MathIllegalStateException implements ExceptionContextProvider {
    private static final long serialVersionUID = -6024911025449780478L;

    public MathParseException(String wrong, int position, Class<?> type) {
        ConstructorContext _bcornu_methode_context358 = new ConstructorContext(MathParseException.class, 40, 1285, 1848);
        try {
            if (CallChecker.beforeDeref(type, Class.class, 44, 1827, 1830)) {
                final ExceptionContext npe_invocation_var139 = getContext();
                if (CallChecker.beforeDeref(npe_invocation_var139, ExceptionContext.class, 43, 1698, 1709)) {
                    type = CallChecker.beforeCalled(type, Class.class, 44, 1827, 1830);
                    CallChecker.isCalled(npe_invocation_var139, ExceptionContext.class, 43, 1698, 1709).addMessage(LocalizedFormats.CANNOT_PARSE_AS_TYPE, wrong, Integer.valueOf(position), CallChecker.isCalled(type, Class.class, 44, 1827, 1830).getName());
                }
            }
        } finally {
            _bcornu_methode_context358.methodEnd();
        }
    }

    public MathParseException(String wrong, int position) {
        ConstructorContext _bcornu_methode_context359 = new ConstructorContext(MathParseException.class, 52, 1855, 2251);
        try {
            final ExceptionContext npe_invocation_var140 = getContext();
            if (CallChecker.beforeDeref(npe_invocation_var140, ExceptionContext.class, 54, 2125, 2136)) {
                CallChecker.isCalled(npe_invocation_var140, ExceptionContext.class, 54, 2125, 2136).addMessage(LocalizedFormats.CANNOT_PARSE, wrong, Integer.valueOf(position));
            }
        } finally {
            _bcornu_methode_context359.methodEnd();
        }
    }
}

