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

public final class PackagePermission extends BasicPermission {
    static final long serialVersionUID = -5107705877071099135L;

    public static final String EXPORT = "export";

    public static final String EXPORTONLY = "exportonly";

    public static final String IMPORT = "import";

    private static final int ACTION_EXPORT = 1;

    private static final int ACTION_IMPORT = 2;

    private static final int ACTION_ALL = (PackagePermission.ACTION_EXPORT) | (PackagePermission.ACTION_IMPORT);

    static final int ACTION_NONE = 0;

    transient int action_mask;

    private volatile String actions = null;

    final transient Bundle bundle;

    transient Filter filter;

    private transient volatile Map<String, Object> properties;

    public PackagePermission(String name, String actions) {
        this(name, PackagePermission.parseActions(actions));
        MethodContext _bcornu_methode_context109 = new MethodContext(null);
        try {
            if (((filter) != null) && (((action_mask) & (PackagePermission.ACTION_ALL)) != (PackagePermission.ACTION_IMPORT))) {
                throw new IllegalArgumentException("invalid action string for filter expression");
            }
        } finally {
            _bcornu_methode_context109.methodEnd();
        }
    }

    public PackagePermission(String name, Bundle exportingBundle, String actions) {
        super(name);
        MethodContext _bcornu_methode_context110 = new MethodContext(null);
        try {
            setTransients(name, PackagePermission.parseActions(actions));
            this.bundle = exportingBundle;
            CallChecker.varAssign(this.bundle, "this.bundle", 191, 6335, 6364);
            if (exportingBundle == null) {
                throw new IllegalArgumentException("bundle must not be null");
            }
            if ((filter) != null) {
                throw new IllegalArgumentException("invalid name");
            }
            if (((action_mask) & (PackagePermission.ACTION_ALL)) != (PackagePermission.ACTION_IMPORT)) {
                throw new IllegalArgumentException("invalid action string");
            }
        } finally {
            _bcornu_methode_context110.methodEnd();
        }
    }

    PackagePermission(String name, int mask) {
        super(name);
        MethodContext _bcornu_methode_context111 = new MethodContext(null);
        try {
            setTransients(name, mask);
            this.bundle = null;
            CallChecker.varAssign(this.bundle, "this.bundle", 212, 6908, 6926);
        } finally {
            _bcornu_methode_context111.methodEnd();
        }
    }

    private void setTransients(String name, int mask) {
        MethodContext _bcornu_methode_context1047 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 220, 6933, 7263);
            CallChecker.varInit(mask, "mask", 220, 6933, 7263);
            CallChecker.varInit(name, "name", 220, 6933, 7263);
            CallChecker.varInit(this.properties, "properties", 220, 6933, 7263);
            CallChecker.varInit(this.filter, "filter", 220, 6933, 7263);
            CallChecker.varInit(this.bundle, "bundle", 220, 6933, 7263);
            CallChecker.varInit(this.actions, "actions", 220, 6933, 7263);
            CallChecker.varInit(this.action_mask, "action_mask", 220, 6933, 7263);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 220, 6933, 7263);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 220, 6933, 7263);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 220, 6933, 7263);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 220, 6933, 7263);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 220, 6933, 7263);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 220, 6933, 7263);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 220, 6933, 7263);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 220, 6933, 7263);
            if ((mask == (PackagePermission.ACTION_NONE)) || ((mask & (PackagePermission.ACTION_ALL)) != mask)) {
                throw new IllegalArgumentException("invalid action string");
            }
            action_mask = mask;
            CallChecker.varAssign(this.action_mask, "this.action_mask", 224, 7212, 7230);
            filter = PackagePermission.parseFilter(name);
            CallChecker.varAssign(this.filter, "this.filter", 225, 7234, 7260);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1047.methodEnd();
        }
    }

    private static int parseActions(String actions) {
        MethodContext _bcornu_methode_context1048 = new MethodContext(int.class);
        try {
            CallChecker.varInit(actions, "actions", 234, 7267, 9850);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 234, 7267, 9850);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 234, 7267, 9850);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 234, 7267, 9850);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 234, 7267, 9850);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 234, 7267, 9850);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 234, 7267, 9850);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 234, 7267, 9850);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 234, 7267, 9850);
            boolean seencomma = CallChecker.varInit(((boolean) (false)), "seencomma", 235, 7435, 7460);
            int mask = CallChecker.varInit(((int) (PackagePermission.ACTION_NONE)), "mask", 237, 7465, 7487);
            if (actions == null) {
                return mask;
            }
            char[] a = CallChecker.varInit(actions.toCharArray(), "a", 243, 7538, 7570);
            int i = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(a, char[].class, 245, 7583, 7583)) {
                a = CallChecker.beforeCalled(a, char[].class, 245, 7583, 7583);
                i = (CallChecker.isCalled(a, char[].class, 245, 7583, 7583).length) - 1;
                CallChecker.varAssign(i, "i", 245, 7583, 7583);
            }
            if (i < 0)
                return mask;
            
            while (i != (-1)) {
                char c = CallChecker.init(char.class);
                a = CallChecker.beforeCalled(a, char[].class, 253, 7710, 7710);
                while ((i != (-1)) && ((((((c = CallChecker.isCalled(a, char[].class, 253, 7710, 7710)[i]) == ' ') || (c == '\r')) || (c == '\n')) || (c == '\f')) || (c == '\t'))) {
                    CallChecker.varAssign(c, "c", 253, 7705, 7714);
                    i--;
                } 
                int matchlen = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(a, char[].class, 259, 7857, 7857)) {
                    if (CallChecker.beforeDeref(a, char[].class, 259, 7876, 7876)) {
                        if (CallChecker.beforeDeref(a, char[].class, 260, 7902, 7902)) {
                            if (CallChecker.beforeDeref(a, char[].class, 260, 7921, 7921)) {
                                if (CallChecker.beforeDeref(a, char[].class, 261, 7947, 7947)) {
                                    if (CallChecker.beforeDeref(a, char[].class, 261, 7966, 7966)) {
                                        if (CallChecker.beforeDeref(a, char[].class, 262, 7992, 7992)) {
                                            if (CallChecker.beforeDeref(a, char[].class, 262, 8011, 8011)) {
                                                if (CallChecker.beforeDeref(a, char[].class, 263, 8037, 8037)) {
                                                    if (CallChecker.beforeDeref(a, char[].class, 263, 8056, 8056)) {
                                                        if (CallChecker.beforeDeref(a, char[].class, 264, 8082, 8082)) {
                                                            if (CallChecker.beforeDeref(a, char[].class, 264, 8097, 8097)) {
                                                                a = CallChecker.beforeCalled(a, char[].class, 259, 7857, 7857);
                                                                a = CallChecker.beforeCalled(a, char[].class, 259, 7876, 7876);
                                                                a = CallChecker.beforeCalled(a, char[].class, 260, 7902, 7902);
                                                                a = CallChecker.beforeCalled(a, char[].class, 260, 7921, 7921);
                                                                a = CallChecker.beforeCalled(a, char[].class, 261, 7947, 7947);
                                                                a = CallChecker.beforeCalled(a, char[].class, 261, 7966, 7966);
                                                                a = CallChecker.beforeCalled(a, char[].class, 262, 7992, 7992);
                                                                a = CallChecker.beforeCalled(a, char[].class, 262, 8011, 8011);
                                                                a = CallChecker.beforeCalled(a, char[].class, 263, 8037, 8037);
                                                                a = CallChecker.beforeCalled(a, char[].class, 263, 8056, 8056);
                                                                a = CallChecker.beforeCalled(a, char[].class, 264, 8082, 8082);
                                                                a = CallChecker.beforeCalled(a, char[].class, 264, 8097, 8097);
                                                                if (((((((i >= 5) && (((CallChecker.isCalled(a, char[].class, 259, 7857, 7857)[(i - 5)]) == 'i') || ((CallChecker.isCalled(a, char[].class, 259, 7876, 7876)[(i - 5)]) == 'I'))) && (((CallChecker.isCalled(a, char[].class, 260, 7902, 7902)[(i - 4)]) == 'm') || ((CallChecker.isCalled(a, char[].class, 260, 7921, 7921)[(i - 4)]) == 'M'))) && (((CallChecker.isCalled(a, char[].class, 261, 7947, 7947)[(i - 3)]) == 'p') || ((CallChecker.isCalled(a, char[].class, 261, 7966, 7966)[(i - 3)]) == 'P'))) && (((CallChecker.isCalled(a, char[].class, 262, 7992, 7992)[(i - 2)]) == 'o') || ((CallChecker.isCalled(a, char[].class, 262, 8011, 8011)[(i - 2)]) == 'O'))) && (((CallChecker.isCalled(a, char[].class, 263, 8037, 8037)[(i - 1)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 263, 8056, 8056)[(i - 1)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 264, 8082, 8082)[i]) == 't') || ((CallChecker.isCalled(a, char[].class, 264, 8097, 8097)[i]) == 'T'))) {
                                                                    matchlen = 6;
                                                                    CallChecker.varAssign(matchlen, "matchlen", 265, 8117, 8129);
                                                                    mask |= PackagePermission.ACTION_IMPORT;
                                                                    CallChecker.varAssign(mask, "mask", 266, 8135, 8156);
                                                                }else
                                                                    if (CallChecker.beforeDeref(a, char[].class, 269, 8188, 8188)) {
                                                                        if (CallChecker.beforeDeref(a, char[].class, 269, 8207, 8207)) {
                                                                            if (CallChecker.beforeDeref(a, char[].class, 270, 8234, 8234)) {
                                                                                if (CallChecker.beforeDeref(a, char[].class, 270, 8253, 8253)) {
                                                                                    if (CallChecker.beforeDeref(a, char[].class, 271, 8280, 8280)) {
                                                                                        if (CallChecker.beforeDeref(a, char[].class, 271, 8299, 8299)) {
                                                                                            if (CallChecker.beforeDeref(a, char[].class, 272, 8326, 8326)) {
                                                                                                if (CallChecker.beforeDeref(a, char[].class, 272, 8345, 8345)) {
                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 273, 8372, 8372)) {
                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 273, 8391, 8391)) {
                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 274, 8418, 8418)) {
                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 274, 8433, 8433)) {
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 269, 8188, 8188);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 269, 8207, 8207);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 270, 8234, 8234);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 270, 8253, 8253);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 271, 8280, 8280);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 271, 8299, 8299);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 272, 8326, 8326);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 272, 8345, 8345);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 273, 8372, 8372);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 273, 8391, 8391);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 274, 8418, 8418);
                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 274, 8433, 8433);
                                                                                                                    if (((((((i >= 5) && (((CallChecker.isCalled(a, char[].class, 269, 8188, 8188)[(i - 5)]) == 'e') || ((CallChecker.isCalled(a, char[].class, 269, 8207, 8207)[(i - 5)]) == 'E'))) && (((CallChecker.isCalled(a, char[].class, 270, 8234, 8234)[(i - 4)]) == 'x') || ((CallChecker.isCalled(a, char[].class, 270, 8253, 8253)[(i - 4)]) == 'X'))) && (((CallChecker.isCalled(a, char[].class, 271, 8280, 8280)[(i - 3)]) == 'p') || ((CallChecker.isCalled(a, char[].class, 271, 8299, 8299)[(i - 3)]) == 'P'))) && (((CallChecker.isCalled(a, char[].class, 272, 8326, 8326)[(i - 2)]) == 'o') || ((CallChecker.isCalled(a, char[].class, 272, 8345, 8345)[(i - 2)]) == 'O'))) && (((CallChecker.isCalled(a, char[].class, 273, 8372, 8372)[(i - 1)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 273, 8391, 8391)[(i - 1)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 274, 8418, 8418)[i]) == 't') || ((CallChecker.isCalled(a, char[].class, 274, 8433, 8433)[i]) == 'T'))) {
                                                                                                                        matchlen = 6;
                                                                                                                        CallChecker.varAssign(matchlen, "matchlen", 275, 8454, 8466);
                                                                                                                        mask |= (PackagePermission.ACTION_EXPORT) | (PackagePermission.ACTION_IMPORT);
                                                                                                                        CallChecker.varAssign(mask, "mask", 276, 8473, 8510);
                                                                                                                    }else {
                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 279, 8546, 8546)) {
                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 279, 8565, 8565)) {
                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 280, 8593, 8593)) {
                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 280, 8612, 8612)) {
                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 281, 8640, 8640)) {
                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 281, 8659, 8659)) {
                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 282, 8687, 8687)) {
                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 282, 8706, 8706)) {
                                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 283, 8734, 8734)) {
                                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 283, 8753, 8753)) {
                                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 284, 8781, 8781)) {
                                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 284, 8800, 8800)) {
                                                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 285, 8828, 8828)) {
                                                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 285, 8847, 8847)) {
                                                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 286, 8875, 8875)) {
                                                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 286, 8894, 8894)) {
                                                                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 287, 8922, 8922)) {
                                                                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 287, 8941, 8941)) {
                                                                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 288, 8969, 8969)) {
                                                                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 288, 8984, 8984)) {
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 279, 8546, 8546);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 279, 8565, 8565);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 280, 8593, 8593);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 280, 8612, 8612);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 281, 8640, 8640);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 281, 8659, 8659);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 282, 8687, 8687);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 282, 8706, 8706);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 283, 8734, 8734);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 283, 8753, 8753);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 284, 8781, 8781);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 284, 8800, 8800);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 285, 8828, 8828);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 285, 8847, 8847);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 286, 8875, 8875);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 286, 8894, 8894);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 287, 8922, 8922);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 287, 8941, 8941);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 288, 8969, 8969);
                                                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 288, 8984, 8984);
                                                                                                                                                                                                        if (((((((((((i >= 9) && (((CallChecker.isCalled(a, char[].class, 279, 8546, 8546)[(i - 9)]) == 'e') || ((CallChecker.isCalled(a, char[].class, 279, 8565, 8565)[(i - 9)]) == 'E'))) && (((CallChecker.isCalled(a, char[].class, 280, 8593, 8593)[(i - 8)]) == 'x') || ((CallChecker.isCalled(a, char[].class, 280, 8612, 8612)[(i - 8)]) == 'X'))) && (((CallChecker.isCalled(a, char[].class, 281, 8640, 8640)[(i - 7)]) == 'p') || ((CallChecker.isCalled(a, char[].class, 281, 8659, 8659)[(i - 7)]) == 'P'))) && (((CallChecker.isCalled(a, char[].class, 282, 8687, 8687)[(i - 6)]) == 'o') || ((CallChecker.isCalled(a, char[].class, 282, 8706, 8706)[(i - 6)]) == 'O'))) && (((CallChecker.isCalled(a, char[].class, 283, 8734, 8734)[(i - 5)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 283, 8753, 8753)[(i - 5)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 284, 8781, 8781)[(i - 4)]) == 't') || ((CallChecker.isCalled(a, char[].class, 284, 8800, 8800)[(i - 4)]) == 'T'))) && (((CallChecker.isCalled(a, char[].class, 285, 8828, 8828)[(i - 3)]) == 'o') || ((CallChecker.isCalled(a, char[].class, 285, 8847, 8847)[(i - 3)]) == 'O'))) && (((CallChecker.isCalled(a, char[].class, 286, 8875, 8875)[(i - 2)]) == 'n') || ((CallChecker.isCalled(a, char[].class, 286, 8894, 8894)[(i - 2)]) == 'N'))) && (((CallChecker.isCalled(a, char[].class, 287, 8922, 8922)[(i - 1)]) == 'l') || ((CallChecker.isCalled(a, char[].class, 287, 8941, 8941)[(i - 1)]) == 'L'))) && (((CallChecker.isCalled(a, char[].class, 288, 8969, 8969)[i]) == 'y') || ((CallChecker.isCalled(a, char[].class, 288, 8984, 8984)[i]) == 'Y'))) {
                                                                                                                                                                                                            matchlen = 10;
                                                                                                                                                                                                            CallChecker.varAssign(matchlen, "matchlen", 289, 9006, 9019);
                                                                                                                                                                                                            mask |= PackagePermission.ACTION_EXPORT;
                                                                                                                                                                                                            CallChecker.varAssign(mask, "mask", 290, 9027, 9048);
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
                
                seencomma = false;
                CallChecker.varAssign(seencomma, "seencomma", 300, 9288, 9305);
                while ((i >= matchlen) && (!seencomma)) {
                    if (CallChecker.beforeDeref(a, char[].class, 302, 9360, 9360)) {
                        a = CallChecker.beforeCalled(a, char[].class, 302, 9360, 9360);
                        switch (CallChecker.isCalled(a, char[].class, 302, 9360, 9360)[(i - matchlen)]) {
                            case ',' :
                                seencomma = true;
                                CallChecker.varAssign(seencomma, "seencomma", 304, 9401, 9417);
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
                CallChecker.varAssign(i, "i", 319, 9717, 9730);
            } 
            if (seencomma) {
                throw new IllegalArgumentException(("invalid permission: " + actions));
            }
            return mask;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1048.methodEnd();
        }
    }

    private static Filter parseFilter(String filterString) {
        MethodContext _bcornu_methode_context1049 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(filterString, "filterString", 337, 9854, 10552);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 337, 9854, 10552);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 337, 9854, 10552);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 337, 9854, 10552);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 337, 9854, 10552);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 337, 9854, 10552);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 337, 9854, 10552);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 337, 9854, 10552);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 337, 9854, 10552);
            if (CallChecker.beforeDeref(filterString, String.class, 338, 10250, 10261)) {
                filterString = CallChecker.beforeCalled(filterString, String.class, 338, 10250, 10261);
                filterString = CallChecker.isCalled(filterString, String.class, 338, 10250, 10261).trim();
                CallChecker.varAssign(filterString, "filterString", 338, 10235, 10269);
            }
            if (CallChecker.beforeDeref(filterString, String.class, 339, 10277, 10288)) {
                filterString = CallChecker.beforeCalled(filterString, String.class, 339, 10277, 10288);
                if ((CallChecker.isCalled(filterString, String.class, 339, 10277, 10288).charAt(0)) != '(') {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            TryContext _bcornu_try_context_322 = new TryContext(322, PackagePermission.class, "org.osgi.framework.InvalidSyntaxException");
            try {
                return FrameworkUtil.createFilter(filterString);
            } catch (InvalidSyntaxException e) {
                _bcornu_try_context_322.catchStart(322);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException("invalid filter"), "iae", 346, 10433, 10510);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 347, 10515, 10517)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 347, 10515, 10517);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 347, 10515, 10517).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_322.finallyStart(322);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1049.methodEnd();
        }
    }

    @Override
    public boolean implies(Permission p) {
        MethodContext _bcornu_methode_context1050 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 376, 10556, 11878);
            CallChecker.varInit(p, "p", 376, 10556, 11878);
            CallChecker.varInit(this.properties, "properties", 376, 10556, 11878);
            CallChecker.varInit(this.filter, "filter", 376, 10556, 11878);
            CallChecker.varInit(this.bundle, "bundle", 376, 10556, 11878);
            CallChecker.varInit(this.actions, "actions", 376, 10556, 11878);
            CallChecker.varInit(this.action_mask, "action_mask", 376, 10556, 11878);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 376, 10556, 11878);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 376, 10556, 11878);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 376, 10556, 11878);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 376, 10556, 11878);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 376, 10556, 11878);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 376, 10556, 11878);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 376, 10556, 11878);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 376, 10556, 11878);
            if (!(p instanceof PackagePermission)) {
                return false;
            }
            PackagePermission requested = CallChecker.varInit(((PackagePermission) (p)), "requested", 380, 11607, 11658);
            if ((bundle) != null) {
                return false;
            }
            if (CallChecker.beforeDeref(requested, PackagePermission.class, 385, 11785, 11793)) {
                requested = CallChecker.beforeCalled(requested, PackagePermission.class, 385, 11785, 11793);
                if ((CallChecker.isCalled(requested, PackagePermission.class, 385, 11785, 11793).filter) != null) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return implies0(requested, PackagePermission.ACTION_NONE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1050.methodEnd();
        }
    }

    boolean implies0(PackagePermission requested, int effective) {
        MethodContext _bcornu_methode_context1051 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 402, 11882, 12768);
            CallChecker.varInit(effective, "effective", 402, 11882, 12768);
            CallChecker.varInit(requested, "requested", 402, 11882, 12768);
            CallChecker.varInit(this.properties, "properties", 402, 11882, 12768);
            CallChecker.varInit(this.filter, "filter", 402, 11882, 12768);
            CallChecker.varInit(this.bundle, "bundle", 402, 11882, 12768);
            CallChecker.varInit(this.actions, "actions", 402, 11882, 12768);
            CallChecker.varInit(this.action_mask, "action_mask", 402, 11882, 12768);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 402, 11882, 12768);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 402, 11882, 12768);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 402, 11882, 12768);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 402, 11882, 12768);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 402, 11882, 12768);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 402, 11882, 12768);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 402, 11882, 12768);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 402, 11882, 12768);
            effective |= action_mask;
            CallChecker.varAssign(effective, "effective", 404, 12480, 12504);
            requested = CallChecker.beforeCalled(requested, PackagePermission.class, 405, 12528, 12536);
            final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, PackagePermission.class, 405, 12528, 12536).action_mask)), "desired", 405, 12508, 12549);
            if ((effective & desired) != desired) {
                return false;
            }
            Filter f = CallChecker.varInit(filter, "f", 410, 12642, 12659);
            if (f == null) {
                return super.implies(requested);
            }
            if (CallChecker.beforeDeref(requested, PackagePermission.class, 414, 12739, 12747)) {
                requested = CallChecker.beforeCalled(requested, PackagePermission.class, 414, 12739, 12747);
                return f.matches(CallChecker.isCalled(requested, PackagePermission.class, 414, 12739, 12747).getProperties());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1051.methodEnd();
        }
    }

    @Override
    public String getActions() {
        MethodContext _bcornu_methode_context1052 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 429, 12772, 13577);
            CallChecker.varInit(this.properties, "properties", 429, 12772, 13577);
            CallChecker.varInit(this.filter, "filter", 429, 12772, 13577);
            CallChecker.varInit(this.bundle, "bundle", 429, 12772, 13577);
            CallChecker.varInit(this.actions, "actions", 429, 12772, 13577);
            CallChecker.varInit(this.action_mask, "action_mask", 429, 12772, 13577);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 429, 12772, 13577);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 429, 12772, 13577);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 429, 12772, 13577);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 429, 12772, 13577);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 429, 12772, 13577);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 429, 12772, 13577);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 429, 12772, 13577);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 429, 12772, 13577);
            String result = CallChecker.varInit(actions, "result", 430, 13158, 13181);
            if (result == null) {
                StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 432, 13210, 13246);
                boolean comma = CallChecker.varInit(((boolean) (false)), "comma", 433, 13251, 13272);
                int mask = CallChecker.varInit(((int) (this.action_mask)), "mask", 435, 13278, 13300);
                if ((mask & (PackagePermission.ACTION_EXPORT)) == (PackagePermission.ACTION_EXPORT)) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 437, 13356, 13357)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 437, 13356, 13357);
                        CallChecker.isCalled(sb, StringBuffer.class, 437, 13356, 13357).append(PackagePermission.EXPORTONLY);
                    }
                    comma = true;
                    CallChecker.varAssign(comma, "comma", 438, 13383, 13395);
                }
                if ((mask & (PackagePermission.ACTION_IMPORT)) == (PackagePermission.ACTION_IMPORT)) {
                    if (comma)
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 443, 13473, 13474)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 443, 13473, 13474);
                            CallChecker.isCalled(sb, StringBuffer.class, 443, 13473, 13474).append(',');
                        }
                    
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 444, 13493, 13494)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 444, 13493, 13494);
                        CallChecker.isCalled(sb, StringBuffer.class, 444, 13493, 13494).append(PackagePermission.IMPORT);
                    }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 447, 13540, 13541)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 447, 13540, 13541);
                    actions = result = CallChecker.isCalled(sb, StringBuffer.class, 447, 13540, 13541).toString();
                    CallChecker.varAssign(this.actions, "this.actions", 447, 13521, 13553);
                    CallChecker.varAssign(result, "result", 447, 13531, 13552);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1052.methodEnd();
        }
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        MethodContext _bcornu_methode_context1053 = new MethodContext(PermissionCollection.class);
        try {
            CallChecker.varInit(this, "this", 459, 13581, 13877);
            CallChecker.varInit(this.properties, "properties", 459, 13581, 13877);
            CallChecker.varInit(this.filter, "filter", 459, 13581, 13877);
            CallChecker.varInit(this.bundle, "bundle", 459, 13581, 13877);
            CallChecker.varInit(this.actions, "actions", 459, 13581, 13877);
            CallChecker.varInit(this.action_mask, "action_mask", 459, 13581, 13877);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 459, 13581, 13877);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 459, 13581, 13877);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 459, 13581, 13877);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 459, 13581, 13877);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 459, 13581, 13877);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 459, 13581, 13877);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 459, 13581, 13877);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 459, 13581, 13877);
            return new PackagePermissionCollection();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PermissionCollection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1053.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1054 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 477, 13881, 14799);
            CallChecker.varInit(obj, "obj", 477, 13881, 14799);
            CallChecker.varInit(this.properties, "properties", 477, 13881, 14799);
            CallChecker.varInit(this.filter, "filter", 477, 13881, 14799);
            CallChecker.varInit(this.bundle, "bundle", 477, 13881, 14799);
            CallChecker.varInit(this.actions, "actions", 477, 13881, 14799);
            CallChecker.varInit(this.action_mask, "action_mask", 477, 13881, 14799);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 477, 13881, 14799);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 477, 13881, 14799);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 477, 13881, 14799);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 477, 13881, 14799);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 477, 13881, 14799);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 477, 13881, 14799);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 477, 13881, 14799);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 477, 13881, 14799);
            if (obj == (this)) {
                return true;
            }
            if (!(obj instanceof PackagePermission)) {
                return false;
            }
            PackagePermission pp = CallChecker.varInit(((PackagePermission) (obj)), "pp", 486, 14596, 14642);
            if (CallChecker.beforeDeref(pp, PackagePermission.class, 488, 14706, 14707)) {
                if (CallChecker.beforeDeref(pp, PackagePermission.class, 488, 14784, 14785)) {
                    pp = CallChecker.beforeCalled(pp, PackagePermission.class, 488, 14670, 14671);
                    pp = CallChecker.beforeCalled(pp, PackagePermission.class, 488, 14706, 14707);
                    pp = CallChecker.beforeCalled(pp, PackagePermission.class, 488, 14735, 14736);
                    pp = CallChecker.beforeCalled(pp, PackagePermission.class, 488, 14784, 14785);
                    return (((action_mask) == (CallChecker.isCalled(pp, PackagePermission.class, 488, 14670, 14671).action_mask)) && (CallChecker.isCalled(getName(), String.class, 488, 14689, 14697).equals(CallChecker.isCalled(pp, PackagePermission.class, 488, 14706, 14707).getName()))) && (((bundle) == (CallChecker.isCalled(pp, PackagePermission.class, 488, 14735, 14736).bundle)) || (((bundle) != null) && (CallChecker.isCalled(bundle, Bundle.class, 488, 14770, 14775).equals(CallChecker.isCalled(pp, PackagePermission.class, 488, 14784, 14785).bundle))));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1054.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1055 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 497, 14803, 15107);
            CallChecker.varInit(this.properties, "properties", 497, 14803, 15107);
            CallChecker.varInit(this.filter, "filter", 497, 14803, 15107);
            CallChecker.varInit(this.bundle, "bundle", 497, 14803, 15107);
            CallChecker.varInit(this.actions, "actions", 497, 14803, 15107);
            CallChecker.varInit(this.action_mask, "action_mask", 497, 14803, 15107);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 497, 14803, 15107);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 497, 14803, 15107);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 497, 14803, 15107);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 497, 14803, 15107);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 497, 14803, 15107);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 497, 14803, 15107);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 497, 14803, 15107);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 497, 14803, 15107);
            int h = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(getName(), String.class, 498, 14969, 14977)) {
                h = (31 * 17) + (CallChecker.isCalled(getName(), String.class, 498, 14969, 14977).hashCode());
                CallChecker.varAssign(h, "h", 498, 14969, 14977);
            }
            final String npe_invocation_var416 = getActions();
            if (CallChecker.beforeDeref(npe_invocation_var416, String.class, 499, 15006, 15017)) {
                h = (31 * h) + (CallChecker.isCalled(npe_invocation_var416, String.class, 499, 15006, 15017).hashCode());
                CallChecker.varAssign(h, "h", 499, 14993, 15029);
            }
            if ((bundle) != null) {
                h = (31 * h) + (bundle.hashCode());
                CallChecker.varAssign(h, "h", 501, 15058, 15088);
            }
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1055.methodEnd();
        }
    }

    private synchronized void writeObject(ObjectOutputStream s) throws IOException {
        MethodContext _bcornu_methode_context1056 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 511, 15111, 15655);
            CallChecker.varInit(s, "s", 511, 15111, 15655);
            CallChecker.varInit(this.properties, "properties", 511, 15111, 15655);
            CallChecker.varInit(this.filter, "filter", 511, 15111, 15655);
            CallChecker.varInit(this.bundle, "bundle", 511, 15111, 15655);
            CallChecker.varInit(this.actions, "actions", 511, 15111, 15655);
            CallChecker.varInit(this.action_mask, "action_mask", 511, 15111, 15655);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 511, 15111, 15655);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 511, 15111, 15655);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 511, 15111, 15655);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 511, 15111, 15655);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 511, 15111, 15655);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 511, 15111, 15655);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 511, 15111, 15655);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 511, 15111, 15655);
            if ((bundle) != null) {
                throw new NotSerializableException("cannot serialize");
            }
            if ((actions) == null)
                getActions();
            
            if (CallChecker.beforeDeref(s, ObjectOutputStream.class, 519, 15630, 15630)) {
                s = CallChecker.beforeCalled(s, ObjectOutputStream.class, 519, 15630, 15630);
                CallChecker.isCalled(s, ObjectOutputStream.class, 519, 15630, 15630).defaultWriteObject();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1056.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1057 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 526, 15659, 15991);
            CallChecker.varInit(s, "s", 526, 15659, 15991);
            CallChecker.varInit(this.properties, "properties", 526, 15659, 15991);
            CallChecker.varInit(this.filter, "filter", 526, 15659, 15991);
            CallChecker.varInit(this.bundle, "bundle", 526, 15659, 15991);
            CallChecker.varInit(this.actions, "actions", 526, 15659, 15991);
            CallChecker.varInit(this.action_mask, "action_mask", 526, 15659, 15991);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 526, 15659, 15991);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 526, 15659, 15991);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 526, 15659, 15991);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 526, 15659, 15991);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 526, 15659, 15991);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 526, 15659, 15991);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 526, 15659, 15991);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 526, 15659, 15991);
            if (CallChecker.beforeDeref(s, ObjectInputStream.class, 528, 15916, 15916)) {
                s = CallChecker.beforeCalled(s, ObjectInputStream.class, 528, 15916, 15916);
                CallChecker.isCalled(s, ObjectInputStream.class, 528, 15916, 15916).defaultReadObject();
            }
            setTransients(getName(), PackagePermission.parseActions(actions));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1057.methodEnd();
        }
    }

    private Map<String, Object> getProperties() {
        MethodContext _bcornu_methode_context1059 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 538, 15995, 16966);
            CallChecker.varInit(this.properties, "properties", 538, 15995, 16966);
            CallChecker.varInit(this.filter, "filter", 538, 15995, 16966);
            CallChecker.varInit(this.bundle, "bundle", 538, 15995, 16966);
            CallChecker.varInit(this.actions, "actions", 538, 15995, 16966);
            CallChecker.varInit(this.action_mask, "action_mask", 538, 15995, 16966);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.PackagePermission.ACTION_NONE", 538, 15995, 16966);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.PackagePermission.ACTION_ALL", 538, 15995, 16966);
            CallChecker.varInit(ACTION_IMPORT, "org.osgi.framework.PackagePermission.ACTION_IMPORT", 538, 15995, 16966);
            CallChecker.varInit(ACTION_EXPORT, "org.osgi.framework.PackagePermission.ACTION_EXPORT", 538, 15995, 16966);
            CallChecker.varInit(IMPORT, "org.osgi.framework.PackagePermission.IMPORT", 538, 15995, 16966);
            CallChecker.varInit(EXPORTONLY, "org.osgi.framework.PackagePermission.EXPORTONLY", 538, 15995, 16966);
            CallChecker.varInit(EXPORT, "org.osgi.framework.PackagePermission.EXPORT", 538, 15995, 16966);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermission.serialVersionUID", 538, 15995, 16966);
            Map<String, Object> result = CallChecker.varInit(properties, "result", 539, 16261, 16300);
            if (result != null) {
                return result;
            }
            final Map<String, Object> map = CallChecker.varInit(new HashMap<String, Object>(5), "map", 543, 16350, 16412);
            if (CallChecker.beforeDeref(map, Map.class, 544, 16416, 16418)) {
                CallChecker.isCalled(map, Map.class, 544, 16416, 16418).put("package.name", getName());
            }
            if ((bundle) != null) {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {
                    public Void run() {
                        MethodContext _bcornu_methode_context1058 = new MethodContext(Void.class);
                        try {
                            CallChecker.varInit(this, "this", 547, 16544, 16925);
                            if (CallChecker.beforeDeref(map, Map.class, 548, 16569, 16571)) {
                                CallChecker.isCalled(map, Map.class, 548, 16569, 16571).put("id", new Long(bundle.getBundleId()));
                            }
                            if (CallChecker.beforeDeref(map, Map.class, 549, 16621, 16623)) {
                                CallChecker.isCalled(map, Map.class, 549, 16621, 16623).put("location", bundle.getLocation());
                            }
                            String name = CallChecker.varInit(bundle.getSymbolicName(), "name", 550, 16669, 16707);
                            if (name != null) {
                                if (CallChecker.beforeDeref(map, Map.class, 552, 16740, 16742)) {
                                    CallChecker.isCalled(map, Map.class, 552, 16740, 16742).put("name", name);
                                }
                            }
                            SignerProperty signer = CallChecker.varInit(new SignerProperty(bundle), "signer", 554, 16775, 16825);
                            if (CallChecker.beforeDeref(signer, SignerProperty.class, 555, 16836, 16841)) {
                                signer = CallChecker.beforeCalled(signer, SignerProperty.class, 555, 16836, 16841);
                                if (CallChecker.isCalled(signer, SignerProperty.class, 555, 16836, 16841).isBundleSigned()) {
                                    if (CallChecker.beforeDeref(map, Map.class, 556, 16869, 16871)) {
                                        CallChecker.isCalled(map, Map.class, 556, 16869, 16871).put("signer", signer);
                                    }
                                }
                            }
                            return null;
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Void) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context1058.methodEnd();
                        }
                    }
                });
            }
            return properties = map;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1059.methodEnd();
        }
    }
}

