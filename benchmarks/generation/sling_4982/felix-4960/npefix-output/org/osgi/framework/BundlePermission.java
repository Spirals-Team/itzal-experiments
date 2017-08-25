package org.osgi.framework;

import java.security.PermissionCollection;
import java.security.Permission;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.security.BasicPermission;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class BundlePermission extends BasicPermission {
    private static final long serialVersionUID = 3257846601685873716L;

    public static final String PROVIDE = "provide";

    public static final String REQUIRE = "require";

    public static final String HOST = "host";

    public static final String FRAGMENT = "fragment";

    private static final int ACTION_PROVIDE = 1;

    private static final int ACTION_REQUIRE = 2;

    private static final int ACTION_HOST = 4;

    private static final int ACTION_FRAGMENT = 8;

    private static final int ACTION_ALL = (((BundlePermission.ACTION_PROVIDE) | (BundlePermission.ACTION_REQUIRE)) | (BundlePermission.ACTION_HOST)) | (BundlePermission.ACTION_FRAGMENT);

    static final int ACTION_NONE = 0;

    private transient int action_mask;

    private volatile String actions = null;

    public BundlePermission(String symbolicName, String actions) {
        this(symbolicName, BundlePermission.parseActions(actions));
        MethodContext _bcornu_methode_context94 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context94.methodEnd();
        }
    }

    BundlePermission(String symbolicName, int mask) {
        super(symbolicName);
        MethodContext _bcornu_methode_context95 = new MethodContext(null);
        try {
            setTransients(mask);
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }

    private synchronized void setTransients(int mask) {
        MethodContext _bcornu_methode_context992 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 144, 4141, 4430);
            CallChecker.varInit(mask, "mask", 144, 4141, 4430);
            CallChecker.varInit(this.actions, "actions", 144, 4141, 4430);
            CallChecker.varInit(this.action_mask, "action_mask", 144, 4141, 4430);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 144, 4141, 4430);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 144, 4141, 4430);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 144, 4141, 4430);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 144, 4141, 4430);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 144, 4141, 4430);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 144, 4141, 4430);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 144, 4141, 4430);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 144, 4141, 4430);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 144, 4141, 4430);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 144, 4141, 4430);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 144, 4141, 4430);
            if ((mask == (BundlePermission.ACTION_NONE)) || ((mask & (BundlePermission.ACTION_ALL)) != mask)) {
                throw new IllegalArgumentException("invalid action string");
            }
            action_mask = mask;
            CallChecker.varAssign(this.action_mask, "this.action_mask", 149, 4409, 4427);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context992.methodEnd();
        }
    }

    synchronized int getActionsMask() {
        MethodContext _bcornu_methode_context993 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 159, 4434, 4636);
            CallChecker.varInit(this.actions, "actions", 159, 4434, 4636);
            CallChecker.varInit(this.action_mask, "action_mask", 159, 4434, 4636);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 159, 4434, 4636);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 159, 4434, 4636);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 159, 4434, 4636);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 159, 4434, 4636);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 159, 4434, 4636);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 159, 4434, 4636);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 159, 4434, 4636);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 159, 4434, 4636);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 159, 4434, 4636);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 159, 4434, 4636);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 159, 4434, 4636);
            return action_mask;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context993.methodEnd();
        }
    }

    private static int parseActions(String actions) {
        MethodContext _bcornu_methode_context994 = new MethodContext(int.class);
        try {
            CallChecker.varInit(actions, "actions", 169, 4640, 7479);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 169, 4640, 7479);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 169, 4640, 7479);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 169, 4640, 7479);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 169, 4640, 7479);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 169, 4640, 7479);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 169, 4640, 7479);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 169, 4640, 7479);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 169, 4640, 7479);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 169, 4640, 7479);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 169, 4640, 7479);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 169, 4640, 7479);
            boolean seencomma = CallChecker.varInit(((boolean) (false)), "seencomma", 170, 4808, 4833);
            int mask = CallChecker.varInit(((int) (BundlePermission.ACTION_NONE)), "mask", 172, 4838, 4860);
            if (actions == null) {
                return mask;
            }
            char[] a = CallChecker.varInit(actions.toCharArray(), "a", 178, 4911, 4943);
            int i = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(a, char[].class, 180, 4956, 4956)) {
                a = CallChecker.beforeCalled(a, char[].class, 180, 4956, 4956);
                i = (CallChecker.isCalled(a, char[].class, 180, 4956, 4956).length) - 1;
                CallChecker.varAssign(i, "i", 180, 4956, 4956);
            }
            if (i < 0)
                return mask;
            
            while (i != (-1)) {
                char c = CallChecker.init(char.class);
                a = CallChecker.beforeCalled(a, char[].class, 188, 5083, 5083);
                while ((i != (-1)) && ((((((c = CallChecker.isCalled(a, char[].class, 188, 5083, 5083)[i]) == ' ') || (c == '\r')) || (c == '\n')) || (c == '\f')) || (c == '\t'))) {
                    CallChecker.varAssign(c, "c", 188, 5078, 5087);
                    i--;
                } 
                int matchlen = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(a, char[].class, 194, 5230, 5230)) {
                    if (CallChecker.beforeDeref(a, char[].class, 194, 5249, 5249)) {
                        if (CallChecker.beforeDeref(a, char[].class, 195, 5275, 5275)) {
                            if (CallChecker.beforeDeref(a, char[].class, 195, 5294, 5294)) {
                                if (CallChecker.beforeDeref(a, char[].class, 196, 5320, 5320)) {
                                    if (CallChecker.beforeDeref(a, char[].class, 196, 5339, 5339)) {
                                        if (CallChecker.beforeDeref(a, char[].class, 197, 5365, 5365)) {
                                            if (CallChecker.beforeDeref(a, char[].class, 197, 5384, 5384)) {
                                                if (CallChecker.beforeDeref(a, char[].class, 198, 5410, 5410)) {
                                                    if (CallChecker.beforeDeref(a, char[].class, 198, 5429, 5429)) {
                                                        if (CallChecker.beforeDeref(a, char[].class, 199, 5455, 5455)) {
                                                            if (CallChecker.beforeDeref(a, char[].class, 199, 5474, 5474)) {
                                                                if (CallChecker.beforeDeref(a, char[].class, 200, 5500, 5500)) {
                                                                    if (CallChecker.beforeDeref(a, char[].class, 200, 5515, 5515)) {
                                                                        a = CallChecker.beforeCalled(a, char[].class, 194, 5230, 5230);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 194, 5249, 5249);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 195, 5275, 5275);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 195, 5294, 5294);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 196, 5320, 5320);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 196, 5339, 5339);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 197, 5365, 5365);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 197, 5384, 5384);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 198, 5410, 5410);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 198, 5429, 5429);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 199, 5455, 5455);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 199, 5474, 5474);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 200, 5500, 5500);
                                                                        a = CallChecker.beforeCalled(a, char[].class, 200, 5515, 5515);
                                                                        if ((((((((i >= 6) && (((CallChecker.isCalled(a, char[].class, 194, 5230, 5230)[(i - 6)]) == 'p') || ((CallChecker.isCalled(a, char[].class, 194, 5249, 5249)[(i - 6)]) == 'P'))) && (((CallChecker.isCalled(a, char[].class, 195, 5275, 5275)[(i - 5)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 195, 5294, 5294)[(i - 5)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 196, 5320, 5320)[(i - 4)]) == 'o') || ((CallChecker.isCalled(a, char[].class, 196, 5339, 5339)[(i - 4)]) == 'O'))) && (((CallChecker.isCalled(a, char[].class, 197, 5365, 5365)[(i - 3)]) == 'v') || ((CallChecker.isCalled(a, char[].class, 197, 5384, 5384)[(i - 3)]) == 'V'))) && (((CallChecker.isCalled(a, char[].class, 198, 5410, 5410)[(i - 2)]) == 'i') || ((CallChecker.isCalled(a, char[].class, 198, 5429, 5429)[(i - 2)]) == 'I'))) && (((CallChecker.isCalled(a, char[].class, 199, 5455, 5455)[(i - 1)]) == 'd') || ((CallChecker.isCalled(a, char[].class, 199, 5474, 5474)[(i - 1)]) == 'D'))) && (((CallChecker.isCalled(a, char[].class, 200, 5500, 5500)[i]) == 'e') || ((CallChecker.isCalled(a, char[].class, 200, 5515, 5515)[i]) == 'E'))) {
                                                                            matchlen = 7;
                                                                            CallChecker.varAssign(matchlen, "matchlen", 201, 5535, 5547);
                                                                            mask |= (BundlePermission.ACTION_PROVIDE) | (BundlePermission.ACTION_REQUIRE);
                                                                            CallChecker.varAssign(mask, "mask", 202, 5553, 5592);
                                                                        }else
                                                                            if (CallChecker.beforeDeref(a, char[].class, 204, 5623, 5623)) {
                                                                                if (CallChecker.beforeDeref(a, char[].class, 204, 5642, 5642)) {
                                                                                    if (CallChecker.beforeDeref(a, char[].class, 205, 5669, 5669)) {
                                                                                        if (CallChecker.beforeDeref(a, char[].class, 205, 5688, 5688)) {
                                                                                            if (CallChecker.beforeDeref(a, char[].class, 206, 5715, 5715)) {
                                                                                                if (CallChecker.beforeDeref(a, char[].class, 206, 5734, 5734)) {
                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 207, 5761, 5761)) {
                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 207, 5780, 5780)) {
                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 208, 5807, 5807)) {
                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 208, 5826, 5826)) {
                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 209, 5853, 5853)) {
                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 209, 5872, 5872)) {
                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 210, 5899, 5899)) {
                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 210, 5914, 5914)) {
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 204, 5623, 5623);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 204, 5642, 5642);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 205, 5669, 5669);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 205, 5688, 5688);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 206, 5715, 5715);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 206, 5734, 5734);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 207, 5761, 5761);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 207, 5780, 5780);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 208, 5807, 5807);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 208, 5826, 5826);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 209, 5853, 5853);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 209, 5872, 5872);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 210, 5899, 5899);
                                                                                                                                    a = CallChecker.beforeCalled(a, char[].class, 210, 5914, 5914);
                                                                                                                                    if ((((((((i >= 6) && (((CallChecker.isCalled(a, char[].class, 204, 5623, 5623)[(i - 6)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 204, 5642, 5642)[(i - 6)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 205, 5669, 5669)[(i - 5)]) == 'e') || ((CallChecker.isCalled(a, char[].class, 205, 5688, 5688)[(i - 5)]) == 'E'))) && (((CallChecker.isCalled(a, char[].class, 206, 5715, 5715)[(i - 4)]) == 'q') || ((CallChecker.isCalled(a, char[].class, 206, 5734, 5734)[(i - 4)]) == 'Q'))) && (((CallChecker.isCalled(a, char[].class, 207, 5761, 5761)[(i - 3)]) == 'u') || ((CallChecker.isCalled(a, char[].class, 207, 5780, 5780)[(i - 3)]) == 'U'))) && (((CallChecker.isCalled(a, char[].class, 208, 5807, 5807)[(i - 2)]) == 'i') || ((CallChecker.isCalled(a, char[].class, 208, 5826, 5826)[(i - 2)]) == 'I'))) && (((CallChecker.isCalled(a, char[].class, 209, 5853, 5853)[(i - 1)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 209, 5872, 5872)[(i - 1)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 210, 5899, 5899)[i]) == 'e') || ((CallChecker.isCalled(a, char[].class, 210, 5914, 5914)[i]) == 'E'))) {
                                                                                                                                        matchlen = 7;
                                                                                                                                        CallChecker.varAssign(matchlen, "matchlen", 211, 5935, 5947);
                                                                                                                                        mask |= BundlePermission.ACTION_REQUIRE;
                                                                                                                                        CallChecker.varAssign(mask, "mask", 212, 5954, 5976);
                                                                                                                                    }else
                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 214, 6009, 6009)) {
                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 214, 6028, 6028)) {
                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 215, 6056, 6056)) {
                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 215, 6075, 6075)) {
                                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 216, 6103, 6103)) {
                                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 216, 6122, 6122)) {
                                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 217, 6150, 6150)) {
                                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 217, 6165, 6165)) {
                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 214, 6009, 6009);
                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 214, 6028, 6028);
                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 215, 6056, 6056);
                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 215, 6075, 6075);
                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 216, 6103, 6103);
                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 216, 6122, 6122);
                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 217, 6150, 6150);
                                                                                                                                                                        a = CallChecker.beforeCalled(a, char[].class, 217, 6165, 6165);
                                                                                                                                                                        if (((((i >= 3) && (((CallChecker.isCalled(a, char[].class, 214, 6009, 6009)[(i - 3)]) == 'h') || ((CallChecker.isCalled(a, char[].class, 214, 6028, 6028)[(i - 3)]) == 'H'))) && (((CallChecker.isCalled(a, char[].class, 215, 6056, 6056)[(i - 2)]) == 'o') || ((CallChecker.isCalled(a, char[].class, 215, 6075, 6075)[(i - 2)]) == 'O'))) && (((CallChecker.isCalled(a, char[].class, 216, 6103, 6103)[(i - 1)]) == 's') || ((CallChecker.isCalled(a, char[].class, 216, 6122, 6122)[(i - 1)]) == 'S'))) && (((CallChecker.isCalled(a, char[].class, 217, 6150, 6150)[i]) == 't') || ((CallChecker.isCalled(a, char[].class, 217, 6165, 6165)[i]) == 'T'))) {
                                                                                                                                                                            matchlen = 4;
                                                                                                                                                                            CallChecker.varAssign(matchlen, "matchlen", 218, 6187, 6199);
                                                                                                                                                                            mask |= BundlePermission.ACTION_HOST;
                                                                                                                                                                            CallChecker.varAssign(mask, "mask", 219, 6207, 6226);
                                                                                                                                                                        }else
                                                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 221, 6261, 6261)) {
                                                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 221, 6280, 6280)) {
                                                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 222, 6309, 6309)) {
                                                                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 222, 6328, 6328)) {
                                                                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 223, 6357, 6357)) {
                                                                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 223, 6376, 6376)) {
                                                                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 224, 6405, 6405)) {
                                                                                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 224, 6424, 6424)) {
                                                                                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 225, 6453, 6453)) {
                                                                                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 225, 6472, 6472)) {
                                                                                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 226, 6501, 6501)) {
                                                                                                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 226, 6520, 6520)) {
                                                                                                                                                                                                                            if (CallChecker.beforeDeref(a, char[].class, 227, 6549, 6549)) {
                                                                                                                                                                                                                                if (CallChecker.beforeDeref(a, char[].class, 227, 6568, 6568)) {
                                                                                                                                                                                                                                    if (CallChecker.beforeDeref(a, char[].class, 228, 6597, 6597)) {
                                                                                                                                                                                                                                        if (CallChecker.beforeDeref(a, char[].class, 228, 6612, 6612)) {
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 221, 6261, 6261);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 221, 6280, 6280);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 222, 6309, 6309);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 222, 6328, 6328);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 223, 6357, 6357);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 223, 6376, 6376);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 224, 6405, 6405);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 224, 6424, 6424);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 225, 6453, 6453);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 225, 6472, 6472);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 226, 6501, 6501);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 226, 6520, 6520);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 227, 6549, 6549);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 227, 6568, 6568);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 228, 6597, 6597);
                                                                                                                                                                                                                                            a = CallChecker.beforeCalled(a, char[].class, 228, 6612, 6612);
                                                                                                                                                                                                                                            if (((((((((i >= 7) && (((CallChecker.isCalled(a, char[].class, 221, 6261, 6261)[(i - 7)]) == 'f') || ((CallChecker.isCalled(a, char[].class, 221, 6280, 6280)[(i - 7)]) == 'F'))) && (((CallChecker.isCalled(a, char[].class, 222, 6309, 6309)[(i - 6)]) == 'r') || ((CallChecker.isCalled(a, char[].class, 222, 6328, 6328)[(i - 6)]) == 'R'))) && (((CallChecker.isCalled(a, char[].class, 223, 6357, 6357)[(i - 5)]) == 'a') || ((CallChecker.isCalled(a, char[].class, 223, 6376, 6376)[(i - 5)]) == 'A'))) && (((CallChecker.isCalled(a, char[].class, 224, 6405, 6405)[(i - 4)]) == 'g') || ((CallChecker.isCalled(a, char[].class, 224, 6424, 6424)[(i - 4)]) == 'G'))) && (((CallChecker.isCalled(a, char[].class, 225, 6453, 6453)[(i - 3)]) == 'm') || ((CallChecker.isCalled(a, char[].class, 225, 6472, 6472)[(i - 3)]) == 'M'))) && (((CallChecker.isCalled(a, char[].class, 226, 6501, 6501)[(i - 2)]) == 'e') || ((CallChecker.isCalled(a, char[].class, 226, 6520, 6520)[(i - 2)]) == 'E'))) && (((CallChecker.isCalled(a, char[].class, 227, 6549, 6549)[(i - 1)]) == 'n') || ((CallChecker.isCalled(a, char[].class, 227, 6568, 6568)[(i - 1)]) == 'N'))) && (((CallChecker.isCalled(a, char[].class, 228, 6597, 6597)[i]) == 't') || ((CallChecker.isCalled(a, char[].class, 228, 6612, 6612)[i]) == 'T'))) {
                                                                                                                                                                                                                                                matchlen = 8;
                                                                                                                                                                                                                                                CallChecker.varAssign(matchlen, "matchlen", 229, 6635, 6647);
                                                                                                                                                                                                                                                mask |= BundlePermission.ACTION_FRAGMENT;
                                                                                                                                                                                                                                                CallChecker.varAssign(mask, "mask", 230, 6656, 6679);
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
                CallChecker.varAssign(seencomma, "seencomma", 238, 6917, 6934);
                while ((i >= matchlen) && (!seencomma)) {
                    if (CallChecker.beforeDeref(a, char[].class, 240, 6989, 6989)) {
                        a = CallChecker.beforeCalled(a, char[].class, 240, 6989, 6989);
                        switch (CallChecker.isCalled(a, char[].class, 240, 6989, 6989)[(i - matchlen)]) {
                            case ',' :
                                seencomma = true;
                                CallChecker.varAssign(seencomma, "seencomma", 242, 7030, 7046);
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
                CallChecker.varAssign(i, "i", 257, 7346, 7359);
            } 
            if (seencomma) {
                throw new IllegalArgumentException(("invalid permission: " + actions));
            }
            return mask;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context994.methodEnd();
        }
    }

    @Override
    public boolean implies(Permission p) {
        MethodContext _bcornu_methode_context995 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 291, 7483, 8811);
            CallChecker.varInit(p, "p", 291, 7483, 8811);
            CallChecker.varInit(this.actions, "actions", 291, 7483, 8811);
            CallChecker.varInit(this.action_mask, "action_mask", 291, 7483, 8811);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 291, 7483, 8811);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 291, 7483, 8811);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 291, 7483, 8811);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 291, 7483, 8811);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 291, 7483, 8811);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 291, 7483, 8811);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 291, 7483, 8811);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 291, 7483, 8811);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 291, 7483, 8811);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 291, 7483, 8811);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 291, 7483, 8811);
            if (!(p instanceof BundlePermission)) {
                return false;
            }
            BundlePermission requested = CallChecker.varInit(((BundlePermission) (p)), "requested", 295, 8593, 8642);
            final int effective = CallChecker.varInit(((int) (getActionsMask())), "effective", 297, 8647, 8685);
            requested = CallChecker.beforeCalled(requested, BundlePermission.class, 298, 8709, 8717);
            final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, BundlePermission.class, 298, 8709, 8717).getActionsMask())), "desired", 298, 8689, 8735);
            return ((effective & desired) == desired) && (super.implies(requested));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context995.methodEnd();
        }
    }

    @Override
    public String getActions() {
        MethodContext _bcornu_methode_context996 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 314, 8815, 9918);
            CallChecker.varInit(this.actions, "actions", 314, 8815, 9918);
            CallChecker.varInit(this.action_mask, "action_mask", 314, 8815, 9918);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 314, 8815, 9918);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 314, 8815, 9918);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 314, 8815, 9918);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 314, 8815, 9918);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 314, 8815, 9918);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 314, 8815, 9918);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 314, 8815, 9918);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 314, 8815, 9918);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 314, 8815, 9918);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 314, 8815, 9918);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 314, 8815, 9918);
            String result = CallChecker.varInit(actions, "result", 315, 9230, 9253);
            if (result == null) {
                StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 317, 9282, 9318);
                boolean comma = CallChecker.varInit(((boolean) (false)), "comma", 318, 9323, 9344);
                if (((action_mask) & (BundlePermission.ACTION_PROVIDE)) == (BundlePermission.ACTION_PROVIDE)) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 321, 9410, 9411)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 321, 9410, 9411);
                        CallChecker.isCalled(sb, StringBuffer.class, 321, 9410, 9411).append(BundlePermission.PROVIDE);
                    }
                    comma = true;
                    CallChecker.varAssign(comma, "comma", 322, 9434, 9446);
                }
                if (((action_mask) & (BundlePermission.ACTION_REQUIRE)) == (BundlePermission.ACTION_REQUIRE)) {
                    if (comma)
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 327, 9533, 9534)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 327, 9533, 9534);
                            CallChecker.isCalled(sb, StringBuffer.class, 327, 9533, 9534).append(',');
                        }
                    
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 328, 9553, 9554)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 328, 9553, 9554);
                        CallChecker.isCalled(sb, StringBuffer.class, 328, 9553, 9554).append(BundlePermission.REQUIRE);
                    }
                    comma = true;
                    CallChecker.varAssign(comma, "comma", 329, 9577, 9589);
                }
                if (((action_mask) & (BundlePermission.ACTION_HOST)) == (BundlePermission.ACTION_HOST)) {
                    if (comma)
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 334, 9670, 9671)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 334, 9670, 9671);
                            CallChecker.isCalled(sb, StringBuffer.class, 334, 9670, 9671).append(',');
                        }
                    
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 335, 9690, 9691)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 335, 9690, 9691);
                        CallChecker.isCalled(sb, StringBuffer.class, 335, 9690, 9691).append(BundlePermission.HOST);
                    }
                    comma = true;
                    CallChecker.varAssign(comma, "comma", 336, 9711, 9723);
                }
                if (((action_mask) & (BundlePermission.ACTION_FRAGMENT)) == (BundlePermission.ACTION_FRAGMENT)) {
                    if (comma)
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 341, 9812, 9813)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 341, 9812, 9813);
                            CallChecker.isCalled(sb, StringBuffer.class, 341, 9812, 9813).append(',');
                        }
                    
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 342, 9832, 9833)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 342, 9832, 9833);
                        CallChecker.isCalled(sb, StringBuffer.class, 342, 9832, 9833).append(BundlePermission.FRAGMENT);
                    }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 345, 9881, 9882)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 345, 9881, 9882);
                    actions = result = CallChecker.isCalled(sb, StringBuffer.class, 345, 9881, 9882).toString();
                    CallChecker.varAssign(this.actions, "this.actions", 345, 9862, 9894);
                    CallChecker.varAssign(result, "result", 345, 9872, 9893);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context996.methodEnd();
        }
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        MethodContext _bcornu_methode_context997 = new MethodContext(PermissionCollection.class);
        try {
            CallChecker.varInit(this, "this", 357, 9922, 10216);
            CallChecker.varInit(this.actions, "actions", 357, 9922, 10216);
            CallChecker.varInit(this.action_mask, "action_mask", 357, 9922, 10216);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 357, 9922, 10216);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 357, 9922, 10216);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 357, 9922, 10216);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 357, 9922, 10216);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 357, 9922, 10216);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 357, 9922, 10216);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 357, 9922, 10216);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 357, 9922, 10216);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 357, 9922, 10216);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 357, 9922, 10216);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 357, 9922, 10216);
            return new BundlePermissionCollection();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PermissionCollection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context997.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context998 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 375, 10220, 11077);
            CallChecker.varInit(obj, "obj", 375, 10220, 11077);
            CallChecker.varInit(this.actions, "actions", 375, 10220, 11077);
            CallChecker.varInit(this.action_mask, "action_mask", 375, 10220, 11077);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 375, 10220, 11077);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 375, 10220, 11077);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 375, 10220, 11077);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 375, 10220, 11077);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 375, 10220, 11077);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 375, 10220, 11077);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 375, 10220, 11077);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 375, 10220, 11077);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 375, 10220, 11077);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 375, 10220, 11077);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 375, 10220, 11077);
            if (obj == (this)) {
                return true;
            }
            if (!(obj instanceof BundlePermission)) {
                return false;
            }
            BundlePermission bp = CallChecker.varInit(((BundlePermission) (obj)), "bp", 384, 10943, 10987);
            if (CallChecker.beforeDeref(bp, BundlePermission.class, 386, 11061, 11062)) {
                bp = CallChecker.beforeCalled(bp, BundlePermission.class, 386, 11020, 11021);
                bp = CallChecker.beforeCalled(bp, BundlePermission.class, 386, 11061, 11062);
                return ((getActionsMask()) == (CallChecker.isCalled(bp, BundlePermission.class, 386, 11020, 11021).getActionsMask())) && (CallChecker.isCalled(getName(), String.class, 386, 11044, 11052).equals(CallChecker.isCalled(bp, BundlePermission.class, 386, 11061, 11062).getName()));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context998.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context999 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 395, 11081, 11322);
            CallChecker.varInit(this.actions, "actions", 395, 11081, 11322);
            CallChecker.varInit(this.action_mask, "action_mask", 395, 11081, 11322);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 395, 11081, 11322);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 395, 11081, 11322);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 395, 11081, 11322);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 395, 11081, 11322);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 395, 11081, 11322);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 395, 11081, 11322);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 395, 11081, 11322);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 395, 11081, 11322);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 395, 11081, 11322);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 395, 11081, 11322);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 395, 11081, 11322);
            int h = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(getName(), String.class, 396, 11247, 11255)) {
                h = (31 * 17) + (CallChecker.isCalled(getName(), String.class, 396, 11247, 11255).hashCode());
                CallChecker.varAssign(h, "h", 396, 11247, 11255);
            }
            final String npe_invocation_var390 = getActions();
            if (CallChecker.beforeDeref(npe_invocation_var390, String.class, 397, 11284, 11295)) {
                h = (31 * h) + (CallChecker.isCalled(npe_invocation_var390, String.class, 397, 11284, 11295).hashCode());
                CallChecker.varAssign(h, "h", 397, 11271, 11307);
            }
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context999.methodEnd();
        }
    }

    private synchronized void writeObject(ObjectOutputStream s) throws IOException {
        MethodContext _bcornu_methode_context1000 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 406, 11326, 11796);
            CallChecker.varInit(s, "s", 406, 11326, 11796);
            CallChecker.varInit(this.actions, "actions", 406, 11326, 11796);
            CallChecker.varInit(this.action_mask, "action_mask", 406, 11326, 11796);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 406, 11326, 11796);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 406, 11326, 11796);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 406, 11326, 11796);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 406, 11326, 11796);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 406, 11326, 11796);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 406, 11326, 11796);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 406, 11326, 11796);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 406, 11326, 11796);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 406, 11326, 11796);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 406, 11326, 11796);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 406, 11326, 11796);
            if ((actions) == null)
                getActions();
            
            if (CallChecker.beforeDeref(s, ObjectOutputStream.class, 411, 11771, 11771)) {
                s = CallChecker.beforeCalled(s, ObjectOutputStream.class, 411, 11771, 11771);
                CallChecker.isCalled(s, ObjectOutputStream.class, 411, 11771, 11771).defaultWriteObject();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1000.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1001 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 418, 11800, 12126);
            CallChecker.varInit(s, "s", 418, 11800, 12126);
            CallChecker.varInit(this.actions, "actions", 418, 11800, 12126);
            CallChecker.varInit(this.action_mask, "action_mask", 418, 11800, 12126);
            CallChecker.varInit(ACTION_NONE, "org.osgi.framework.BundlePermission.ACTION_NONE", 418, 11800, 12126);
            CallChecker.varInit(ACTION_ALL, "org.osgi.framework.BundlePermission.ACTION_ALL", 418, 11800, 12126);
            CallChecker.varInit(ACTION_FRAGMENT, "org.osgi.framework.BundlePermission.ACTION_FRAGMENT", 418, 11800, 12126);
            CallChecker.varInit(ACTION_HOST, "org.osgi.framework.BundlePermission.ACTION_HOST", 418, 11800, 12126);
            CallChecker.varInit(ACTION_REQUIRE, "org.osgi.framework.BundlePermission.ACTION_REQUIRE", 418, 11800, 12126);
            CallChecker.varInit(ACTION_PROVIDE, "org.osgi.framework.BundlePermission.ACTION_PROVIDE", 418, 11800, 12126);
            CallChecker.varInit(FRAGMENT, "org.osgi.framework.BundlePermission.FRAGMENT", 418, 11800, 12126);
            CallChecker.varInit(HOST, "org.osgi.framework.BundlePermission.HOST", 418, 11800, 12126);
            CallChecker.varInit(REQUIRE, "org.osgi.framework.BundlePermission.REQUIRE", 418, 11800, 12126);
            CallChecker.varInit(PROVIDE, "org.osgi.framework.BundlePermission.PROVIDE", 418, 11800, 12126);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermission.serialVersionUID", 418, 11800, 12126);
            if (CallChecker.beforeDeref(s, ObjectInputStream.class, 420, 12062, 12062)) {
                s = CallChecker.beforeCalled(s, ObjectInputStream.class, 420, 12062, 12062);
                CallChecker.isCalled(s, ObjectInputStream.class, 420, 12062, 12062).defaultReadObject();
            }
            setTransients(BundlePermission.parseActions(actions));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1001.methodEnd();
        }
    }
}

