package org.osgi.framework;

import java.security.PermissionCollection;
import java.security.Permission;
import java.io.ObjectStreamField;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import java.util.List;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.io.IOException;

final class CapabilityPermissionCollection extends PermissionCollection {
    static final long serialVersionUID = -615322242639008920L;

    private Map<String, CapabilityPermission> permissions;

    private boolean all_allowed;

    private Map<String, CapabilityPermission> filterPermissions;

    public CapabilityPermissionCollection() {
        MethodContext _bcornu_methode_context81 = new MethodContext(null);
        try {
            permissions = new HashMap<String, CapabilityPermission>();
            CallChecker.varAssign(this.permissions, "this.permissions", 604, 18169, 18226);
            all_allowed = false;
            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 605, 18230, 18249);
        } finally {
            _bcornu_methode_context81.methodEnd();
        }
    }

    @Override
    public void add(final Permission permission) {
        MethodContext _bcornu_methode_context865 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 618, 18256, 19886);
            CallChecker.varInit(permission, "permission", 618, 18256, 19886);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.CapabilityPermissionCollection.serialPersistentFields", 618, 18256, 19886);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 618, 18256, 19886);
            CallChecker.varInit(this.all_allowed, "all_allowed", 618, 18256, 19886);
            CallChecker.varInit(this.permissions, "permissions", 618, 18256, 19886);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermissionCollection.serialVersionUID", 618, 18256, 19886);
            if (!(permission instanceof CapabilityPermission)) {
                throw new IllegalArgumentException(("invalid permission: " + permission));
            }
            if (isReadOnly()) {
                throw new SecurityException(("attempt to add a Permission to a " + "readonly PermissionCollection"));
            }
            final CapabilityPermission cp = CallChecker.varInit(((CapabilityPermission) (permission)), "cp", 626, 18939, 19004);
            if (CallChecker.beforeDeref(cp, CapabilityPermission.class, 627, 19012, 19013)) {
                if ((CallChecker.isCalled(cp, CapabilityPermission.class, 627, 19012, 19013).bundle) != null) {
                    throw new IllegalArgumentException(("cannot add to collection: " + cp));
                }
            }
            final String name = CallChecker.varInit(CallChecker.isCalled(cp, CapabilityPermission.class, 631, 19134, 19135).getName(), "name", 631, 19114, 19146);
            final Filter f = CallChecker.varInit(CallChecker.isCalled(cp, CapabilityPermission.class, 632, 19167, 19168).filter, "f", 632, 19150, 19176);
            synchronized(this) {
                Map<String, CapabilityPermission> pc = CallChecker.init(Map.class);
                if (f != null) {
                    pc = filterPermissions;
                    CallChecker.varAssign(pc, "pc", 637, 19313, 19335);
                    if (pc == null) {
                        filterPermissions = pc = new HashMap<String, CapabilityPermission>();
                        CallChecker.varAssign(this.filterPermissions, "this.filterPermissions", 639, 19364, 19432);
                        CallChecker.varAssign(pc, "pc", 639, 19384, 19431);
                    }
                }else {
                    pc = permissions;
                    CallChecker.varAssign(pc, "pc", 642, 19456, 19472);
                }
                pc = CallChecker.beforeCalled(pc, Map.class, 644, 19520, 19521);
                final CapabilityPermission existing = CallChecker.varInit(CallChecker.isCalled(pc, Map.class, 644, 19520, 19521).get(name), "existing", 644, 19482, 19532);
                if (existing != null) {
                    final int oldMask = CallChecker.varInit(((int) (existing.action_mask)), "oldMask", 647, 19566, 19606);
                    final int newMask = CallChecker.varInit(((int) (CallChecker.isCalled(cp, CapabilityPermission.class, 648, 19632, 19633).action_mask)), "newMask", 648, 19612, 19646);
                    if (oldMask != newMask) {
                        if (CallChecker.beforeDeref(pc, Map.class, 650, 19683, 19684)) {
                            pc = CallChecker.beforeCalled(pc, Map.class, 650, 19683, 19684);
                            CallChecker.isCalled(pc, Map.class, 650, 19683, 19684).put(name, new CapabilityPermission(name, (oldMask | newMask)));
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(pc, Map.class, 653, 19770, 19771)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 653, 19770, 19771);
                        CallChecker.isCalled(pc, Map.class, 653, 19770, 19771).put(name, cp);
                    }
                }
                if (!(all_allowed)) {
                    if (CallChecker.beforeDeref(name, String.class, 657, 19825, 19828)) {
                        if (CallChecker.isCalled(name, String.class, 657, 19825, 19828).equals("*")) {
                            all_allowed = true;
                            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 658, 19850, 19868);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context865.methodEnd();
        }
    }

    @Override
    public boolean implies(final Permission permission) {
        MethodContext _bcornu_methode_context866 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 673, 19890, 22192);
            CallChecker.varInit(permission, "permission", 673, 19890, 22192);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.CapabilityPermissionCollection.serialPersistentFields", 673, 19890, 22192);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 673, 19890, 22192);
            CallChecker.varInit(this.all_allowed, "all_allowed", 673, 19890, 22192);
            CallChecker.varInit(this.permissions, "permissions", 673, 19890, 22192);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermissionCollection.serialVersionUID", 673, 19890, 22192);
            if (!(permission instanceof CapabilityPermission)) {
                return false;
            }
            final CapabilityPermission requested = CallChecker.varInit(((CapabilityPermission) (permission)), "requested", 677, 20335, 20407);
            if (CallChecker.beforeDeref(requested, CapabilityPermission.class, 679, 20492, 20500)) {
                if ((CallChecker.isCalled(requested, CapabilityPermission.class, 679, 20492, 20500).filter) != null) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            String requestedName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(requested, CapabilityPermission.class, 683, 20567, 20575)) {
                requestedName = CallChecker.isCalled(requested, CapabilityPermission.class, 683, 20567, 20575).getName();
                CallChecker.varAssign(requestedName, "requestedName", 683, 20567, 20575);
            }
            final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, CapabilityPermission.class, 684, 20610, 20618).action_mask)), "desired", 684, 20590, 20631);
            int effective = CallChecker.varInit(((int) (CapabilityPermission.ACTION_NONE)), "effective", 685, 20635, 20683);
            Collection<CapabilityPermission> perms = CallChecker.init(Collection.class);
            synchronized(this) {
                Map<String, CapabilityPermission> pc = CallChecker.varInit(permissions, "pc", 689, 20755, 20805);
                CapabilityPermission cp = CallChecker.init(CapabilityPermission.class);
                if (all_allowed) {
                    if (CallChecker.beforeDeref(pc, Map.class, 693, 20921, 20922)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 693, 20921, 20922);
                        cp = CallChecker.isCalled(pc, Map.class, 693, 20921, 20922).get("*");
                        CallChecker.varAssign(cp, "cp", 693, 20916, 20932);
                    }
                    if (cp != null) {
                        effective |= cp.action_mask;
                        CallChecker.varAssign(effective, "effective", 695, 20961, 20988);
                        if ((effective & desired) == desired) {
                            return true;
                        }
                    }
                }
                if (CallChecker.beforeDeref(pc, Map.class, 706, 21203, 21204)) {
                    pc = CallChecker.beforeCalled(pc, Map.class, 706, 21203, 21204);
                    cp = CallChecker.isCalled(pc, Map.class, 706, 21203, 21204).get(requestedName);
                    CallChecker.varAssign(cp, "cp", 706, 21198, 21224);
                }
                if (cp != null) {
                    effective |= cp.action_mask;
                    CallChecker.varAssign(effective, "effective", 709, 21283, 21310);
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }
                int last = CallChecker.init(int.class);
                int offset = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(requestedName, String.class, 716, 21451, 21463)) {
                    requestedName = CallChecker.beforeCalled(requestedName, String.class, 716, 21451, 21463);
                    offset = (CallChecker.isCalled(requestedName, String.class, 716, 21451, 21463).length()) - 1;
                    CallChecker.varAssign(offset, "offset", 716, 21451, 21463);
                }
                requestedName = CallChecker.beforeCalled(requestedName, String.class, 717, 21497, 21509);
                while ((last = CallChecker.isCalled(requestedName, String.class, 717, 21497, 21509).lastIndexOf(".", offset)) != (-1)) {
                    CallChecker.varAssign(last, "last", 717, 21489, 21535);
                    if (CallChecker.beforeDeref(requestedName, String.class, 718, 21566, 21578)) {
                        requestedName = CallChecker.beforeCalled(requestedName, String.class, 718, 21566, 21578);
                        requestedName = (CallChecker.isCalled(requestedName, String.class, 718, 21566, 21578).substring(0, (last + 1))) + "*";
                        CallChecker.varAssign(requestedName, "requestedName", 718, 21550, 21608);
                    }
                    if (CallChecker.beforeDeref(pc, Map.class, 719, 21619, 21620)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 719, 21619, 21620);
                        cp = CallChecker.isCalled(pc, Map.class, 719, 21619, 21620).get(requestedName);
                        CallChecker.varAssign(cp, "cp", 719, 21614, 21640);
                    }
                    if (cp != null) {
                        effective |= cp.action_mask;
                        CallChecker.varAssign(effective, "effective", 721, 21669, 21696);
                        if ((effective & desired) == desired) {
                            return true;
                        }
                    }
                    offset = last - 1;
                    CallChecker.varAssign(offset, "offset", 726, 21779, 21796);
                } 
                pc = filterPermissions;
                CallChecker.varAssign(pc, "pc", 732, 21911, 21933);
                if (pc == null) {
                    return false;
                }
                perms = pc.values();
                CallChecker.varAssign(perms, "perms", 736, 21982, 22001);
            }
            if (CallChecker.beforeDeref(perms, boolean.class, 739, 22094, 22098)) {
                for (CapabilityPermission perm : perms) {
                    if (CallChecker.beforeDeref(perm, CapabilityPermission.class, 740, 22110, 22113)) {
                        if (CallChecker.isCalled(perm, CapabilityPermission.class, 740, 22110, 22113).implies0(requested, effective)) {
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
            _bcornu_methode_context866.methodEnd();
        }
    }

    @Override
    public synchronized Enumeration<Permission> elements() {
        MethodContext _bcornu_methode_context867 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 754, 22196, 22667);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.CapabilityPermissionCollection.serialPersistentFields", 754, 22196, 22667);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 754, 22196, 22667);
            CallChecker.varInit(this.all_allowed, "all_allowed", 754, 22196, 22667);
            CallChecker.varInit(this.permissions, "permissions", 754, 22196, 22667);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermissionCollection.serialVersionUID", 754, 22196, 22667);
            List<Permission> all = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(permissions, Map.class, 755, 22492, 22502)) {
                permissions = CallChecker.beforeCalled(permissions, Map.class, 755, 22492, 22502);
                all = new ArrayList<Permission>(CallChecker.isCalled(permissions, Map.class, 755, 22492, 22502).values());
                CallChecker.varAssign(all, "all", 755, 22492, 22502);
            }
            Map<String, CapabilityPermission> pc = CallChecker.varInit(filterPermissions, "pc", 756, 22517, 22573);
            if (pc != null) {
                if (CallChecker.beforeDeref(all, List.class, 758, 22598, 22600)) {
                    all = CallChecker.beforeCalled(all, List.class, 758, 22598, 22600);
                    CallChecker.isCalled(all, List.class, 758, 22598, 22600).addAll(pc.values());
                }
            }
            return Collections.enumeration(all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<Permission>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context867.methodEnd();
        }
    }

    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", HashMap.class) , new ObjectStreamField("all_allowed", Boolean.TYPE) , new ObjectStreamField("filterPermissions", HashMap.class) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context868 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 767, 22936, 23239);
            CallChecker.varInit(out, "out", 767, 22936, 23239);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.CapabilityPermissionCollection.serialPersistentFields", 767, 22936, 23239);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 767, 22936, 23239);
            CallChecker.varInit(this.all_allowed, "all_allowed", 767, 22936, 23239);
            CallChecker.varInit(this.permissions, "permissions", 767, 22936, 23239);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermissionCollection.serialVersionUID", 767, 22936, 23239);
            ObjectOutputStream.PutField pfields = CallChecker.init(ObjectOutputStream.PutField.class);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 768, 23059, 23061)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 768, 23059, 23061);
                pfields = CallChecker.isCalled(out, ObjectOutputStream.class, 768, 23059, 23061).putFields();
                CallChecker.varAssign(pfields, "pfields", 768, 23059, 23061);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 769, 23078, 23084)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 769, 23078, 23084);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 769, 23078, 23084).put("permissions", permissions);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 770, 23121, 23127)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 770, 23121, 23127);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 770, 23121, 23127).put("all_allowed", all_allowed);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 771, 23164, 23170)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 771, 23164, 23170);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 771, 23164, 23170).put("filterPermissions", filterPermissions);
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 772, 23219, 23221)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 772, 23219, 23221);
                CallChecker.isCalled(out, ObjectOutputStream.class, 772, 23219, 23221).writeFields();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context868.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context869 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 775, 23243, 23817);
            CallChecker.varInit(in, "in", 775, 23243, 23817);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.CapabilityPermissionCollection.serialPersistentFields", 775, 23243, 23817);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 775, 23243, 23817);
            CallChecker.varInit(this.all_allowed, "all_allowed", 775, 23243, 23817);
            CallChecker.varInit(this.permissions, "permissions", 775, 23243, 23817);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.CapabilityPermissionCollection.serialVersionUID", 775, 23243, 23817);
            ObjectInputStream.GetField gfields = CallChecker.init(ObjectInputStream.GetField.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 776, 23394, 23395)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 776, 23394, 23395);
                gfields = CallChecker.isCalled(in, ObjectInputStream.class, 776, 23394, 23395).readFields();
                CallChecker.varAssign(gfields, "gfields", 776, 23394, 23395);
            }
            HashMap<String, CapabilityPermission> p = CallChecker.init(HashMap.class);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 778, 23528, 23534)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 778, 23528, 23534);
                p = ((HashMap<String, CapabilityPermission>) (CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 778, 23528, 23534).get("permissions", null)));
                CallChecker.varAssign(p, "p", 778, 23528, 23534);
            }
            permissions = p;
            CallChecker.varAssign(this.permissions, "this.permissions", 779, 23564, 23579);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 780, 23597, 23603)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 780, 23597, 23603);
                all_allowed = CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 780, 23597, 23603).get("all_allowed", false);
                CallChecker.varAssign(this.all_allowed, "this.all_allowed", 780, 23583, 23630);
            }
            HashMap<String, CapabilityPermission> fp = CallChecker.init(HashMap.class);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 782, 23750, 23756)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 782, 23750, 23756);
                fp = ((HashMap<String, CapabilityPermission>) (CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 782, 23750, 23756).get("filterPermissions", null)));
                CallChecker.varAssign(fp, "fp", 782, 23750, 23756);
            }
            filterPermissions = fp;
            CallChecker.varAssign(this.filterPermissions, "this.filterPermissions", 783, 23792, 23814);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context869.methodEnd();
        }
    }
}

