package org.apache.commons.math3.exception.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ExceptionContext implements Serializable {
    private static final long serialVersionUID = -6024911025449780478L;

    private Throwable throwable;

    private List<Localizable> msgPatterns;

    private List<Object[]> msgArguments;

    private Map<String, Object> context;

    public ExceptionContext(final Throwable throwable) {
        ConstructorContext _bcornu_methode_context178 = new ConstructorContext(ExceptionContext.class, 64, 2115, 2469);
        try {
            this.throwable = throwable;
            CallChecker.varAssign(this.throwable, "this.throwable", 65, 2274, 2300);
            msgPatterns = new ArrayList<Localizable>();
            CallChecker.varAssign(this.msgPatterns, "this.msgPatterns", 66, 2310, 2355);
            msgArguments = new ArrayList<Object[]>();
            CallChecker.varAssign(this.msgArguments, "this.msgArguments", 67, 2365, 2407);
            context = new HashMap<String, Object>();
            CallChecker.varAssign(this.context, "this.context", 68, 2417, 2463);
        } finally {
            _bcornu_methode_context178.methodEnd();
        }
    }

    public Throwable getThrowable() {
        MethodContext _bcornu_methode_context648 = new MethodContext(Throwable.class, 74, 2476, 2692);
        try {
            CallChecker.varInit(this, "this", 74, 2476, 2692);
            CallChecker.varInit(this.context, "context", 74, 2476, 2692);
            CallChecker.varInit(this.msgArguments, "msgArguments", 74, 2476, 2692);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 74, 2476, 2692);
            CallChecker.varInit(this.throwable, "throwable", 74, 2476, 2692);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 74, 2476, 2692);
            return throwable;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Throwable) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context648.methodEnd();
        }
    }

    public void addMessage(Localizable pattern, Object... arguments) {
        MethodContext _bcornu_methode_context649 = new MethodContext(void.class, 85, 2699, 3065);
        try {
            CallChecker.varInit(this, "this", 85, 2699, 3065);
            CallChecker.varInit(arguments, "arguments", 85, 2699, 3065);
            CallChecker.varInit(pattern, "pattern", 85, 2699, 3065);
            CallChecker.varInit(this.context, "context", 85, 2699, 3065);
            CallChecker.varInit(this.msgArguments, "msgArguments", 85, 2699, 3065);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 85, 2699, 3065);
            CallChecker.varInit(this.throwable, "throwable", 85, 2699, 3065);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 85, 2699, 3065);
            if (CallChecker.beforeDeref(msgPatterns, List.class, 87, 2980, 2990)) {
                msgPatterns = CallChecker.beforeCalled(msgPatterns, List.class, 87, 2980, 2990);
                CallChecker.isCalled(msgPatterns, List.class, 87, 2980, 2990).add(pattern);
            }
            if (CallChecker.beforeDeref(msgArguments, List.class, 88, 3014, 3025)) {
                msgArguments = CallChecker.beforeCalled(msgArguments, List.class, 88, 3014, 3025);
                CallChecker.isCalled(msgArguments, List.class, 88, 3014, 3025).add(ArgUtils.flatten(arguments));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context649.methodEnd();
        }
    }

    public void setValue(String key, Object value) {
        MethodContext _bcornu_methode_context650 = new MethodContext(void.class, 99, 3072, 3437);
        try {
            CallChecker.varInit(this, "this", 99, 3072, 3437);
            CallChecker.varInit(value, "value", 99, 3072, 3437);
            CallChecker.varInit(key, "key", 99, 3072, 3437);
            CallChecker.varInit(this.context, "context", 99, 3072, 3437);
            CallChecker.varInit(this.msgArguments, "msgArguments", 99, 3072, 3437);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 99, 3072, 3437);
            CallChecker.varInit(this.throwable, "throwable", 99, 3072, 3437);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 99, 3072, 3437);
            if (CallChecker.beforeDeref(context, Map.class, 100, 3408, 3414)) {
                context = CallChecker.beforeCalled(context, Map.class, 100, 3408, 3414);
                CallChecker.isCalled(context, Map.class, 100, 3408, 3414).put(key, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context650.methodEnd();
        }
    }

    public Object getValue(String key) {
        MethodContext _bcornu_methode_context651 = new MethodContext(Object.class, 109, 3444, 3707);
        try {
            CallChecker.varInit(this, "this", 109, 3444, 3707);
            CallChecker.varInit(key, "key", 109, 3444, 3707);
            CallChecker.varInit(this.context, "context", 109, 3444, 3707);
            CallChecker.varInit(this.msgArguments, "msgArguments", 109, 3444, 3707);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 109, 3444, 3707);
            CallChecker.varInit(this.throwable, "throwable", 109, 3444, 3707);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 109, 3444, 3707);
            if (CallChecker.beforeDeref(context, Map.class, 110, 3685, 3691)) {
                context = CallChecker.beforeCalled(context, Map.class, 110, 3685, 3691);
                return CallChecker.isCalled(context, Map.class, 110, 3685, 3691).get(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context651.methodEnd();
        }
    }

    public Set<String> getKeys() {
        MethodContext _bcornu_methode_context652 = new MethodContext(Set.class, 118, 3714, 3886);
        try {
            CallChecker.varInit(this, "this", 118, 3714, 3886);
            CallChecker.varInit(this.context, "context", 118, 3714, 3886);
            CallChecker.varInit(this.msgArguments, "msgArguments", 118, 3714, 3886);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 118, 3714, 3886);
            CallChecker.varInit(this.throwable, "throwable", 118, 3714, 3886);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 118, 3714, 3886);
            if (CallChecker.beforeDeref(context, Map.class, 119, 3864, 3870)) {
                context = CallChecker.beforeCalled(context, Map.class, 119, 3864, 3870);
                return CallChecker.isCalled(context, Map.class, 119, 3864, 3870).keySet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context652.methodEnd();
        }
    }

    public String getMessage() {
        MethodContext _bcornu_methode_context653 = new MethodContext(String.class, 127, 3893, 4048);
        try {
            CallChecker.varInit(this, "this", 127, 3893, 4048);
            CallChecker.varInit(this.context, "context", 127, 3893, 4048);
            CallChecker.varInit(this.msgArguments, "msgArguments", 127, 3893, 4048);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 127, 3893, 4048);
            CallChecker.varInit(this.throwable, "throwable", 127, 3893, 4048);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 127, 3893, 4048);
            return getMessage(Locale.US);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context653.methodEnd();
        }
    }

    public String getLocalizedMessage() {
        MethodContext _bcornu_methode_context654 = new MethodContext(String.class, 136, 4055, 4253);
        try {
            CallChecker.varInit(this, "this", 136, 4055, 4253);
            CallChecker.varInit(this.context, "context", 136, 4055, 4253);
            CallChecker.varInit(this.msgArguments, "msgArguments", 136, 4055, 4253);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 136, 4055, 4253);
            CallChecker.varInit(this.throwable, "throwable", 136, 4055, 4253);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 136, 4055, 4253);
            return getMessage(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context654.methodEnd();
        }
    }

    public String getMessage(final Locale locale) {
        MethodContext _bcornu_methode_context655 = new MethodContext(String.class, 146, 4260, 4534);
        try {
            CallChecker.varInit(this, "this", 146, 4260, 4534);
            CallChecker.varInit(locale, "locale", 146, 4260, 4534);
            CallChecker.varInit(this.context, "context", 146, 4260, 4534);
            CallChecker.varInit(this.msgArguments, "msgArguments", 146, 4260, 4534);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 146, 4260, 4534);
            CallChecker.varInit(this.throwable, "throwable", 146, 4260, 4534);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 146, 4260, 4534);
            return buildMessage(locale, ": ");
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context655.methodEnd();
        }
    }

    public String getMessage(final Locale locale, final String separator) {
        MethodContext _bcornu_methode_context656 = new MethodContext(String.class, 157, 4541, 4943);
        try {
            CallChecker.varInit(this, "this", 157, 4541, 4943);
            CallChecker.varInit(separator, "separator", 157, 4541, 4943);
            CallChecker.varInit(locale, "locale", 157, 4541, 4943);
            CallChecker.varInit(this.context, "context", 157, 4541, 4943);
            CallChecker.varInit(this.msgArguments, "msgArguments", 157, 4541, 4943);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 157, 4541, 4943);
            CallChecker.varInit(this.throwable, "throwable", 157, 4541, 4943);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 157, 4541, 4943);
            return buildMessage(locale, separator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context656.methodEnd();
        }
    }

    private String buildMessage(Locale locale, String separator) {
        MethodContext _bcornu_methode_context657 = new MethodContext(String.class, 169, 4950, 5917);
        try {
            CallChecker.varInit(this, "this", 169, 4950, 5917);
            CallChecker.varInit(separator, "separator", 169, 4950, 5917);
            CallChecker.varInit(locale, "locale", 169, 4950, 5917);
            CallChecker.varInit(this.context, "context", 169, 4950, 5917);
            CallChecker.varInit(this.msgArguments, "msgArguments", 169, 4950, 5917);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 169, 4950, 5917);
            CallChecker.varInit(this.throwable, "throwable", 169, 4950, 5917);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 169, 4950, 5917);
            final StringBuilder sb = CallChecker.varInit(new StringBuilder(), "sb", 171, 5265, 5309);
            int count = CallChecker.varInit(((int) (0)), "count", 172, 5319, 5332);
            msgPatterns = CallChecker.beforeCalled(msgPatterns, List.class, 173, 5358, 5368);
            final int len = CallChecker.varInit(((int) (CallChecker.isCalled(this.msgPatterns, List.class, 173, 5358, 5368).size())), "len", 173, 5342, 5376);
            for (int i = 0; i < len; i++) {
                msgPatterns = CallChecker.beforeCalled(msgPatterns, List.class, 175, 5454, 5464);
                final Localizable pat = CallChecker.varInit(CallChecker.isCalled(msgPatterns, List.class, 175, 5454, 5464).get(i), "pat", 175, 5430, 5472);
                msgArguments = CallChecker.beforeCalled(msgArguments, List.class, 176, 5508, 5519);
                final Object[] args = CallChecker.varInit(CallChecker.isCalled(msgArguments, List.class, 176, 5508, 5519).get(i), "args", 176, 5486, 5527);
                final MessageFormat fmt = CallChecker.varInit(new MessageFormat(CallChecker.isCalled(pat, Localizable.class, 177, 5585, 5587).getLocalizedString(locale), locale), "fmt", 177, 5541, 5680);
                if (CallChecker.beforeDeref(fmt, MessageFormat.class, 179, 5704, 5706)) {
                    if (CallChecker.beforeDeref(sb, StringBuilder.class, 179, 5694, 5695)) {
                        CallChecker.isCalled(sb, StringBuilder.class, 179, 5694, 5695).append(CallChecker.isCalled(fmt, MessageFormat.class, 179, 5704, 5706).format(args));
                    }
                }
                if ((++count) < len) {
                    if (CallChecker.beforeDeref(sb, StringBuilder.class, 182, 5836, 5837)) {
                        CallChecker.isCalled(sb, StringBuilder.class, 182, 5836, 5837).append(separator);
                    }
                }
            }
            if (CallChecker.beforeDeref(sb, StringBuilder.class, 186, 5898, 5899)) {
                return CallChecker.isCalled(sb, StringBuilder.class, 186, 5898, 5899).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context657.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context658 = new MethodContext(void.class, 195, 5924, 6257);
        try {
            CallChecker.varInit(this, "this", 195, 5924, 6257);
            CallChecker.varInit(out, "out", 195, 5924, 6257);
            CallChecker.varInit(this.context, "context", 195, 5924, 6257);
            CallChecker.varInit(this.msgArguments, "msgArguments", 195, 5924, 6257);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 195, 5924, 6257);
            CallChecker.varInit(this.throwable, "throwable", 195, 5924, 6257);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 195, 5924, 6257);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 197, 6162, 6164)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 197, 6162, 6164);
                CallChecker.isCalled(out, ObjectOutputStream.class, 197, 6162, 6164).writeObject(throwable);
            }
            serializeMessages(out);
            serializeContext(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context658.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context659 = new MethodContext(void.class, 208, 6263, 6714);
        try {
            CallChecker.varInit(this, "this", 208, 6263, 6714);
            CallChecker.varInit(in, "in", 208, 6263, 6714);
            CallChecker.varInit(this.context, "context", 208, 6263, 6714);
            CallChecker.varInit(this.msgArguments, "msgArguments", 208, 6263, 6714);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 208, 6263, 6714);
            CallChecker.varInit(this.throwable, "throwable", 208, 6263, 6714);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 208, 6263, 6714);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 211, 6628, 6629)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 211, 6628, 6629);
                throwable = ((Throwable) (CallChecker.isCalled(in, ObjectInputStream.class, 211, 6628, 6629).readObject()));
                CallChecker.varAssign(this.throwable, "this.throwable", 211, 6604, 6643);
            }
            deSerializeMessages(in);
            deSerializeContext(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context659.methodEnd();
        }
    }

    private void serializeMessages(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context660 = new MethodContext(void.class, 222, 6721, 7742);
        try {
            CallChecker.varInit(this, "this", 222, 6721, 7742);
            CallChecker.varInit(out, "out", 222, 6721, 7742);
            CallChecker.varInit(this.context, "context", 222, 6721, 7742);
            CallChecker.varInit(this.msgArguments, "msgArguments", 222, 6721, 7742);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 222, 6721, 7742);
            CallChecker.varInit(this.throwable, "throwable", 222, 6721, 7742);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 222, 6721, 7742);
            msgPatterns = CallChecker.beforeCalled(msgPatterns, List.class, 225, 7016, 7026);
            final int len = CallChecker.varInit(((int) (CallChecker.isCalled(this.msgPatterns, List.class, 225, 7016, 7026).size())), "len", 225, 6981, 7034);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 226, 7044, 7046)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 226, 7044, 7046);
                CallChecker.isCalled(out, ObjectOutputStream.class, 226, 7044, 7046).writeInt(len);
            }
            for (int i = 0; i < len; i++) {
                msgPatterns = CallChecker.beforeCalled(msgPatterns, List.class, 229, 7158, 7168);
                final Localizable pat = CallChecker.varInit(CallChecker.isCalled(msgPatterns, List.class, 229, 7158, 7168).get(i), "pat", 229, 7134, 7176);
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 231, 7213, 7215)) {
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 231, 7213, 7215);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 231, 7213, 7215).writeObject(pat);
                }
                msgArguments = CallChecker.beforeCalled(msgArguments, List.class, 232, 7269, 7280);
                final Object[] args = CallChecker.varInit(CallChecker.isCalled(msgArguments, List.class, 232, 7269, 7280).get(i), "args", 232, 7247, 7288);
                final int aLen = CallChecker.varInit(((int) (CallChecker.isCalled(args, Object[].class, 233, 7319, 7322).length)), "aLen", 233, 7302, 7330);
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 235, 7367, 7369)) {
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 235, 7367, 7369);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 235, 7367, 7369).writeInt(aLen);
                }
                for (int j = 0; j < aLen; j++) {
                    if (CallChecker.beforeDeref(args, Object[].class, 237, 7452, 7455)) {
                        if ((CallChecker.isCalled(args, Object[].class, 237, 7452, 7455)[j]) instanceof Serializable) {
                            if (CallChecker.beforeDeref(args, Object[].class, 239, 7555, 7558)) {
                                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 239, 7539, 7541)) {
                                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 239, 7539, 7541);
                                    CallChecker.isCalled(out, ObjectOutputStream.class, 239, 7539, 7541).writeObject(CallChecker.isCalled(args, Object[].class, 239, 7555, 7558)[j]);
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(args, Object[].class, 242, 7685, 7688)) {
                                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 242, 7642, 7644)) {
                                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 242, 7642, 7644);
                                    CallChecker.isCalled(out, ObjectOutputStream.class, 242, 7642, 7644).writeObject(nonSerializableReplacement(CallChecker.isCalled(args, Object[].class, 242, 7685, 7688)[j]));
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context660.methodEnd();
        }
    }

    private void deSerializeMessages(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context661 = new MethodContext(void.class, 255, 7749, 8749);
        try {
            CallChecker.varInit(this, "this", 255, 7749, 8749);
            CallChecker.varInit(in, "in", 255, 7749, 8749);
            CallChecker.varInit(this.context, "context", 255, 7749, 8749);
            CallChecker.varInit(this.msgArguments, "msgArguments", 255, 7749, 8749);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 255, 7749, 8749);
            CallChecker.varInit(this.throwable, "throwable", 255, 7749, 8749);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 255, 7749, 8749);
            in = CallChecker.beforeCalled(in, ObjectInputStream.class, 259, 8147, 8148);
            final int len = CallChecker.varInit(((int) (CallChecker.isCalled(in, ObjectInputStream.class, 259, 8147, 8148).readInt())), "len", 259, 8112, 8159);
            msgPatterns = new ArrayList<Localizable>(len);
            CallChecker.varAssign(this.msgPatterns, "this.msgPatterns", 260, 8169, 8214);
            msgArguments = new ArrayList<Object[]>(len);
            CallChecker.varAssign(this.msgArguments, "this.msgArguments", 261, 8224, 8267);
            for (int i = 0; i < len; i++) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 265, 8401, 8402);
                final Localizable pat = CallChecker.varInit(((Localizable) (CallChecker.isCalled(in, ObjectInputStream.class, 265, 8401, 8402).readObject())), "pat", 265, 8340, 8416);
                if (CallChecker.beforeDeref(msgPatterns, List.class, 266, 8430, 8440)) {
                    msgPatterns = CallChecker.beforeCalled(msgPatterns, List.class, 266, 8430, 8440);
                    CallChecker.isCalled(msgPatterns, List.class, 266, 8430, 8440).add(pat);
                }
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 268, 8504, 8505);
                final int aLen = CallChecker.varInit(((int) (CallChecker.isCalled(in, ObjectInputStream.class, 268, 8504, 8505).readInt())), "aLen", 268, 8464, 8516);
                final Object[] args = CallChecker.varInit(new Object[aLen], "args", 269, 8530, 8568);
                for (int j = 0; j < aLen; j++) {
                    if (CallChecker.beforeDeref(args, Object[].class, 272, 8658, 8661)) {
                        if (CallChecker.beforeDeref(in, ObjectInputStream.class, 272, 8668, 8669)) {
                            in = CallChecker.beforeCalled(in, ObjectInputStream.class, 272, 8668, 8669);
                            CallChecker.isCalled(args, Object[].class, 272, 8658, 8661)[j] = CallChecker.isCalled(in, ObjectInputStream.class, 272, 8668, 8669).readObject();
                            CallChecker.varAssign(CallChecker.isCalled(args, Object[].class, 272, 8658, 8661)[j], "CallChecker.isCalled(args, Object[].class, 272, 8658, 8661)[j]", 272, 8658, 8683);
                        }
                    }
                }
                if (CallChecker.beforeDeref(msgArguments, List.class, 274, 8711, 8722)) {
                    msgArguments = CallChecker.beforeCalled(msgArguments, List.class, 274, 8711, 8722);
                    CallChecker.isCalled(msgArguments, List.class, 274, 8711, 8722).add(args);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context661.methodEnd();
        }
    }

    private void serializeContext(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context662 = new MethodContext(void.class, 284, 8756, 9487);
        try {
            CallChecker.varInit(this, "this", 284, 8756, 9487);
            CallChecker.varInit(out, "out", 284, 8756, 9487);
            CallChecker.varInit(this.context, "context", 284, 8756, 9487);
            CallChecker.varInit(this.msgArguments, "msgArguments", 284, 8756, 9487);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 284, 8756, 9487);
            CallChecker.varInit(this.throwable, "throwable", 284, 8756, 9487);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 284, 8756, 9487);
            context = CallChecker.beforeCalled(context, Map.class, 287, 9019, 9025);
            final int len = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.context, Map.class, 287, 9019, 9025).keySet(), Set.class, 287, 9019, 9034).size())), "len", 287, 8984, 9042);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 288, 9052, 9054)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 288, 9052, 9054);
                CallChecker.isCalled(out, ObjectOutputStream.class, 288, 9052, 9054).writeInt(len);
            }
            context = CallChecker.beforeCalled(context, Map.class, 289, 9097, 9103);
            for (String key : CallChecker.isCalled(context, Map.class, 289, 9097, 9103).keySet()) {
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 291, 9152, 9154)) {
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 291, 9152, 9154);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 291, 9152, 9154).writeObject(key);
                }
                context = CallChecker.beforeCalled(context, Map.class, 292, 9207, 9213);
                final Object value = CallChecker.varInit(CallChecker.isCalled(context, Map.class, 292, 9207, 9213).get(key), "value", 292, 9186, 9223);
                if (value instanceof Serializable) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 295, 9318, 9320)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 295, 9318, 9320);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 295, 9318, 9320).writeObject(value);
                    }
                }else {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 298, 9407, 9409)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 298, 9407, 9409);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 298, 9407, 9409).writeObject(nonSerializableReplacement(value));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context662.methodEnd();
        }
    }

    private void deSerializeContext(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context663 = new MethodContext(void.class, 310, 9494, 10168);
        try {
            CallChecker.varInit(this, "this", 310, 9494, 10168);
            CallChecker.varInit(in, "in", 310, 9494, 10168);
            CallChecker.varInit(this.context, "context", 310, 9494, 10168);
            CallChecker.varInit(this.msgArguments, "msgArguments", 310, 9494, 10168);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 310, 9494, 10168);
            CallChecker.varInit(this.throwable, "throwable", 310, 9494, 10168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 310, 9494, 10168);
            in = CallChecker.beforeCalled(in, ObjectInputStream.class, 314, 9861, 9862);
            final int len = CallChecker.varInit(((int) (CallChecker.isCalled(in, ObjectInputStream.class, 314, 9861, 9862).readInt())), "len", 314, 9826, 9873);
            context = new HashMap<String, Object>();
            CallChecker.varAssign(this.context, "this.context", 315, 9883, 9922);
            for (int i = 0; i < len; i++) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 318, 10027, 10028);
                final String key = CallChecker.varInit(((String) (CallChecker.isCalled(in, ObjectInputStream.class, 318, 10027, 10028).readObject())), "key", 318, 9976, 10042);
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 320, 10100, 10101);
                final Object value = CallChecker.varInit(CallChecker.isCalled(in, ObjectInputStream.class, 320, 10100, 10101).readObject(), "value", 320, 10056, 10115);
                if (CallChecker.beforeDeref(context, Map.class, 321, 10129, 10135)) {
                    context = CallChecker.beforeCalled(context, Map.class, 321, 10129, 10135);
                    CallChecker.isCalled(context, Map.class, 321, 10129, 10135).put(key, value);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context663.methodEnd();
        }
    }

    private String nonSerializableReplacement(Object obj) {
        MethodContext _bcornu_methode_context664 = new MethodContext(String.class, 332, 10175, 10582);
        try {
            CallChecker.varInit(this, "this", 332, 10175, 10582);
            CallChecker.varInit(obj, "obj", 332, 10175, 10582);
            CallChecker.varInit(this.context, "context", 332, 10175, 10582);
            CallChecker.varInit(this.msgArguments, "msgArguments", 332, 10175, 10582);
            CallChecker.varInit(this.msgPatterns, "msgPatterns", 332, 10175, 10582);
            CallChecker.varInit(this.throwable, "throwable", 332, 10175, 10582);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.ExceptionContext.serialVersionUID", 332, 10175, 10582);
            if (CallChecker.beforeDeref(obj, Object.class, 333, 10546, 10548)) {
                obj = CallChecker.beforeCalled(obj, Object.class, 333, 10546, 10548);
                return ("[Object could not be serialized: " + (CallChecker.isCalled(CallChecker.isCalled(obj, Object.class, 333, 10546, 10548).getClass(), Class.class, 333, 10546, 10559).getName())) + "]";
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context664.methodEnd();
        }
    }
}

