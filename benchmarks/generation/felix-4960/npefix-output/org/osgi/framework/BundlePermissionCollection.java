package org.osgi.framework;

import java.security.PermissionCollection;
import java.security.Permission;
import java.io.ObjectStreamField;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collections;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.util.Hashtable;
import java.io.IOException;

final class BundlePermissionCollection extends PermissionCollection {
    private static final long serialVersionUID = 3258407326846433079L;

    private transient Map<String, BundlePermission> permissions;

    private boolean all_allowed;

    public BundlePermissionCollection() {
        MethodContext _bcornu_methode_context7 = new MethodContext(null);
        try {
            permissions = new HashMap<String, BundlePermission>();
            CallChecker.varAssign(this.permissions, "this.permissions", 456, 12815, 12868);
            all_allowed = false;
            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 457, 12872, 12891);
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    @Override
    public void add(final Permission permission) {
        MethodContext _bcornu_methode_context117 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 470, 12898, 14146);
            CallChecker.varInit(permission, "permission", 470, 12898, 14146);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.BundlePermissionCollection.serialPersistentFields", 470, 12898, 14146);
            CallChecker.varInit(this.all_allowed, "all_allowed", 470, 12898, 14146);
            CallChecker.varInit(this.permissions, "permissions", 470, 12898, 14146);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermissionCollection.serialVersionUID", 470, 12898, 14146);
            if (!(permission instanceof BundlePermission)) {
                throw new IllegalArgumentException(("invalid permission: " + permission));
            }
            if (isReadOnly()) {
                throw new SecurityException(("attempt to add a Permission to a " + "readonly PermissionCollection"));
            }
            final BundlePermission bp = CallChecker.varInit(((BundlePermission) (permission)), "bp", 477, 13581, 13638);
            final String name = CallChecker.varInit(CallChecker.isCalled(bp, BundlePermission.class, 478, 13662, 13663).getName(), "name", 478, 13642, 13674);
            synchronized(this) {
                Map<String, BundlePermission> pc = CallChecker.varInit(permissions, "pc", 480, 13703, 13749);
                BundlePermission existing = CallChecker.init(BundlePermission.class);
                if (CallChecker.beforeDeref(pc, Map.class, 481, 13782, 13783)) {
                    pc = CallChecker.beforeCalled(pc, Map.class, 481, 13782, 13783);
                    existing = CallChecker.isCalled(pc, Map.class, 481, 13782, 13783).get(name);
                    CallChecker.varAssign(existing, "existing", 481, 13782, 13783);
                }
                if (existing != null) {
                    final int oldMask = CallChecker.varInit(((int) (existing.getActionsMask())), "oldMask", 483, 13827, 13872);
                    final int newMask = CallChecker.varInit(((int) (CallChecker.isCalled(bp, BundlePermission.class, 484, 13898, 13899).getActionsMask())), "newMask", 484, 13878, 13917);
                    if (oldMask != newMask) {
                        if (CallChecker.beforeDeref(pc, Map.class, 486, 13954, 13955)) {
                            pc = CallChecker.beforeCalled(pc, Map.class, 486, 13954, 13955);
                            CallChecker.isCalled(pc, Map.class, 486, 13954, 13955).put(name, new BundlePermission(name, (oldMask | newMask)));
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(pc, Map.class, 490, 14038, 14039)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 490, 14038, 14039);
                        CallChecker.isCalled(pc, Map.class, 490, 14038, 14039).put(name, bp);
                    }
                }
                if (!(all_allowed)) {
                    if (CallChecker.beforeDeref(name, String.class, 494, 14093, 14096)) {
                        if (CallChecker.isCalled(name, String.class, 494, 14093, 14096).equals("*")) {
                            all_allowed = true;
                            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 495, 14116, 14134);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    @Override
    public boolean implies(final Permission permission) {
        MethodContext _bcornu_methode_context118 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 510, 14150, 16062);
            CallChecker.varInit(permission, "permission", 510, 14150, 16062);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.BundlePermissionCollection.serialPersistentFields", 510, 14150, 16062);
            CallChecker.varInit(this.all_allowed, "all_allowed", 510, 14150, 16062);
            CallChecker.varInit(this.permissions, "permissions", 510, 14150, 16062);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermissionCollection.serialVersionUID", 510, 14150, 16062);
            if (!(permission instanceof BundlePermission)) {
                return false;
            }
            BundlePermission requested = CallChecker.varInit(((BundlePermission) (permission)), "requested", 514, 14649, 14707);
            String requestedName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(requested, BundlePermission.class, 515, 14734, 14742)) {
                requested = CallChecker.beforeCalled(requested, BundlePermission.class, 515, 14734, 14742);
                requestedName = CallChecker.isCalled(requested, BundlePermission.class, 515, 14734, 14742).getName();
                CallChecker.varAssign(requestedName, "requestedName", 515, 14734, 14742);
            }
            requested = CallChecker.beforeCalled(requested, BundlePermission.class, 516, 14777, 14785);
            final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, BundlePermission.class, 516, 14777, 14785).getActionsMask())), "desired", 516, 14757, 14803);
            int effective = CallChecker.varInit(((int) (BundlePermission.ACTION_NONE)), "effective", 517, 14807, 14851);
            BundlePermission bp = CallChecker.init(BundlePermission.class);
            synchronized(this) {
                Map<String, BundlePermission> pc = CallChecker.varInit(permissions, "pc", 521, 14904, 14950);
                if (all_allowed) {
                    if (CallChecker.beforeDeref(pc, Map.class, 524, 15038, 15039)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 524, 15038, 15039);
                        bp = CallChecker.isCalled(pc, Map.class, 524, 15038, 15039).get("*");
                        CallChecker.varAssign(bp, "bp", 524, 15033, 15049);
                    }
                    if (bp != null) {
                        effective |= bp.getActionsMask();
                        CallChecker.varAssign(effective, "effective", 526, 15078, 15110);
                        if ((effective & desired) == desired) {
                            return true;
                        }
                    }
                }
                if (CallChecker.beforeDeref(pc, Map.class, 532, 15202, 15203)) {
                    pc = CallChecker.beforeCalled(pc, Map.class, 532, 15202, 15203);
                    bp = CallChecker.isCalled(pc, Map.class, 532, 15202, 15203).get(requestedName);
                    CallChecker.varAssign(bp, "bp", 532, 15197, 15223);
                }
                if (bp != null) {
                    effective |= bp.getActionsMask();
                    CallChecker.varAssign(effective, "effective", 538, 15394, 15426);
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }
                int last = CallChecker.init(int.class);
                int offset = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(requestedName, String.class, 545, 15564, 15576)) {
                    requestedName = CallChecker.beforeCalled(requestedName, String.class, 545, 15564, 15576);
                    offset = (CallChecker.isCalled(requestedName, String.class, 545, 15564, 15576).length()) - 1;
                    CallChecker.varAssign(offset, "offset", 545, 15564, 15576);
                }
                requestedName = CallChecker.beforeCalled(requestedName, String.class, 546, 15610, 15622);
                while ((last = CallChecker.isCalled(requestedName, String.class, 546, 15610, 15622).lastIndexOf(".", offset)) != (-1)) {
                    CallChecker.varAssign(last, "last", 546, 15602, 15648);
                    if (CallChecker.beforeDeref(requestedName, String.class, 547, 15679, 15691)) {
                        requestedName = CallChecker.beforeCalled(requestedName, String.class, 547, 15679, 15691);
                        requestedName = (CallChecker.isCalled(requestedName, String.class, 547, 15679, 15691).substring(0, (last + 1))) + "*";
                        CallChecker.varAssign(requestedName, "requestedName", 547, 15663, 15721);
                    }
                    if (CallChecker.beforeDeref(pc, Map.class, 548, 15732, 15733)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 548, 15732, 15733);
                        bp = CallChecker.isCalled(pc, Map.class, 548, 15732, 15733).get(requestedName);
                        CallChecker.varAssign(bp, "bp", 548, 15727, 15753);
                    }
                    if (bp != null) {
                        effective |= bp.getActionsMask();
                        CallChecker.varAssign(effective, "effective", 550, 15782, 15814);
                        if ((effective & desired) == desired) {
                            return true;
                        }
                    }
                    offset = last - 1;
                    CallChecker.varAssign(offset, "offset", 555, 15897, 15914);
                } 
                return false;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context118.methodEnd();
        }
    }

    @Override
    public synchronized Enumeration<Permission> elements() {
        MethodContext _bcornu_methode_context119 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 570, 16066, 16417);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.BundlePermissionCollection.serialPersistentFields", 570, 16066, 16417);
            CallChecker.varInit(this.all_allowed, "all_allowed", 570, 16066, 16417);
            CallChecker.varInit(this.permissions, "permissions", 570, 16066, 16417);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermissionCollection.serialVersionUID", 570, 16066, 16417);
            List<Permission> all = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(permissions, Map.class, 571, 16354, 16364)) {
                permissions = CallChecker.beforeCalled(permissions, Map.class, 571, 16354, 16364);
                all = new ArrayList<Permission>(CallChecker.isCalled(permissions, Map.class, 571, 16354, 16364).values());
                CallChecker.varAssign(all, "all", 571, 16354, 16364);
            }
            return Collections.enumeration(all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<Permission>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context119.methodEnd();
        }
    }

    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", Hashtable.class) , new ObjectStreamField("all_allowed", Boolean.TYPE) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context120 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 578, 16625, 16975);
            CallChecker.varInit(out, "out", 578, 16625, 16975);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.BundlePermissionCollection.serialPersistentFields", 578, 16625, 16975);
            CallChecker.varInit(this.all_allowed, "all_allowed", 578, 16625, 16975);
            CallChecker.varInit(this.permissions, "permissions", 578, 16625, 16975);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermissionCollection.serialVersionUID", 578, 16625, 16975);
            Hashtable<String, BundlePermission> hashtable = CallChecker.varInit(new Hashtable<String, BundlePermission>(permissions), "hashtable", 579, 16710, 16810);
            ObjectOutputStream.PutField pfields = CallChecker.init(ObjectOutputStream.PutField.class);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 580, 16852, 16854)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 580, 16852, 16854);
                pfields = CallChecker.isCalled(out, ObjectOutputStream.class, 580, 16852, 16854).putFields();
                CallChecker.varAssign(pfields, "pfields", 580, 16852, 16854);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 581, 16871, 16877)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 581, 16871, 16877);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 581, 16871, 16877).put("permissions", hashtable);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 582, 16912, 16918)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 582, 16912, 16918);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 582, 16912, 16918).put("all_allowed", all_allowed);
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 583, 16955, 16957)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 583, 16955, 16957);
                CallChecker.isCalled(out, ObjectOutputStream.class, 583, 16955, 16957).writeFields();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context120.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context121 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 586, 16979, 17420);
            CallChecker.varInit(in, "in", 586, 16979, 17420);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.BundlePermissionCollection.serialPersistentFields", 586, 16979, 17420);
            CallChecker.varInit(this.all_allowed, "all_allowed", 586, 16979, 17420);
            CallChecker.varInit(this.permissions, "permissions", 586, 16979, 17420);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundlePermissionCollection.serialVersionUID", 586, 16979, 17420);
            ObjectInputStream.GetField gfields = CallChecker.init(ObjectInputStream.GetField.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 587, 17130, 17131)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 587, 17130, 17131);
                gfields = CallChecker.isCalled(in, ObjectInputStream.class, 587, 17130, 17131).readFields();
                CallChecker.varAssign(gfields, "gfields", 587, 17130, 17131);
            }
            Hashtable<String, BundlePermission> hashtable = CallChecker.init(Hashtable.class);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 589, 17268, 17274)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 589, 17268, 17274);
                hashtable = ((Hashtable<String, BundlePermission>) (CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 589, 17268, 17274).get("permissions", null)));
                CallChecker.varAssign(hashtable, "hashtable", 589, 17268, 17274);
            }
            permissions = new HashMap<String, BundlePermission>(hashtable);
            CallChecker.varAssign(this.permissions, "this.permissions", 590, 17304, 17366);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 591, 17384, 17390)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 591, 17384, 17390);
                all_allowed = CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 591, 17384, 17390).get("all_allowed", false);
                CallChecker.varAssign(this.all_allowed, "this.all_allowed", 591, 17370, 17417);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context121.methodEnd();
        }
    }
}

