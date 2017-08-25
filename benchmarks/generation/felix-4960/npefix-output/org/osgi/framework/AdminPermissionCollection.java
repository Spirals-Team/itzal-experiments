package org.osgi.framework;

import java.util.Hashtable;
import java.util.HashMap;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Enumeration;
import java.util.Collections;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.Permission;
import java.security.PermissionCollection;

final class AdminPermissionCollection extends PermissionCollection {
    private static final long serialVersionUID = 3906372644575328048L;

    private transient Map<String, AdminPermission> permissions;

    private boolean all_allowed;

    public AdminPermissionCollection() {
        MethodContext _bcornu_methode_context55 = new MethodContext(null);
        try {
            permissions = new HashMap<String, AdminPermission>();
            CallChecker.varAssign(this.permissions, "this.permissions", 892, 27944, 27996);
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }

    @Override
    public void add(Permission permission) {
        MethodContext _bcornu_methode_context749 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 906, 28003, 29401);
            CallChecker.varInit(permission, "permission", 906, 28003, 29401);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdminPermissionCollection.serialPersistentFields", 906, 28003, 29401);
            CallChecker.varInit(this.all_allowed, "all_allowed", 906, 28003, 29401);
            CallChecker.varInit(this.permissions, "permissions", 906, 28003, 29401);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdminPermissionCollection.serialVersionUID", 906, 28003, 29401);
            if (!(permission instanceof AdminPermission)) {
                throw new IllegalArgumentException(("invalid permission: " + permission));
            }
            if (isReadOnly()) {
                throw new SecurityException(("attempt to add a Permission to a " + "readonly PermissionCollection"));
            }
            final AdminPermission ap = CallChecker.varInit(((AdminPermission) (permission)), "ap", 913, 28740, 28795);
            if (CallChecker.beforeDeref(ap, AdminPermission.class, 914, 28803, 28804)) {
                if ((CallChecker.isCalled(ap, AdminPermission.class, 914, 28803, 28804).bundle) != null) {
                    throw new IllegalArgumentException(("cannot add to collection: " + ap));
                }
            }
            final String name = CallChecker.varInit(CallChecker.isCalled(ap, AdminPermission.class, 917, 28924, 28925).getName(), "name", 917, 28904, 28936);
            synchronized(this) {
                Map<String, AdminPermission> pc = CallChecker.varInit(permissions, "pc", 919, 28965, 29010);
                AdminPermission existing = CallChecker.init(AdminPermission.class);
                if (CallChecker.beforeDeref(pc, Map.class, 920, 29042, 29043)) {
                    pc = CallChecker.beforeCalled(pc, Map.class, 920, 29042, 29043);
                    existing = CallChecker.isCalled(pc, Map.class, 920, 29042, 29043).get(name);
                    CallChecker.varAssign(existing, "existing", 920, 29042, 29043);
                }
                if (existing != null) {
                    int oldMask = CallChecker.varInit(((int) (existing.action_mask)), "oldMask", 922, 29087, 29121);
                    int newMask = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(ap, AdminPermission.class, 923, 29141, 29142)) {
                        newMask = CallChecker.isCalled(ap, AdminPermission.class, 923, 29141, 29142).action_mask;
                        CallChecker.varAssign(newMask, "newMask", 923, 29141, 29142);
                    }
                    if (oldMask != newMask) {
                        if (CallChecker.beforeDeref(pc, Map.class, 926, 29193, 29194)) {
                            pc = CallChecker.beforeCalled(pc, Map.class, 926, 29193, 29194);
                            CallChecker.isCalled(pc, Map.class, 926, 29193, 29194).put(name, new AdminPermission(existing.filter, (oldMask | newMask)));
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(pc, Map.class, 929, 29286, 29287)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 929, 29286, 29287);
                        CallChecker.isCalled(pc, Map.class, 929, 29286, 29287).put(name, ap);
                    }
                }
                if (!(all_allowed)) {
                    if (CallChecker.beforeDeref(name, String.class, 932, 29340, 29343)) {
                        if (CallChecker.isCalled(name, String.class, 932, 29340, 29343).equals("*")) {
                            all_allowed = true;
                            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 933, 29365, 29383);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context749.methodEnd();
        }
    }

    @Override
    public boolean implies(Permission permission) {
        MethodContext _bcornu_methode_context750 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 950, 29405, 30771);
            CallChecker.varInit(permission, "permission", 950, 29405, 30771);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdminPermissionCollection.serialPersistentFields", 950, 29405, 30771);
            CallChecker.varInit(this.all_allowed, "all_allowed", 950, 29405, 30771);
            CallChecker.varInit(this.permissions, "permissions", 950, 29405, 30771);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdminPermissionCollection.serialVersionUID", 950, 29405, 30771);
            if (!(permission instanceof AdminPermission)) {
                return false;
            }
            AdminPermission requested = CallChecker.varInit(((AdminPermission) (permission)), "requested", 955, 29942, 29998);
            if (CallChecker.beforeDeref(requested, AdminPermission.class, 957, 30080, 30088)) {
                requested = CallChecker.beforeCalled(requested, AdminPermission.class, 957, 30080, 30088);
                if ((CallChecker.isCalled(requested, AdminPermission.class, 957, 30080, 30088).filter) != null) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            int effective = CallChecker.varInit(((int) (AdminPermission.ACTION_NONE)), "effective", 960, 30131, 30174);
            Collection<AdminPermission> perms = CallChecker.init(Collection.class);
            synchronized(this) {
                Map<String, AdminPermission> pc = CallChecker.varInit(permissions, "pc", 963, 30240, 30285);
                if (all_allowed) {
                    AdminPermission ap = CallChecker.init(AdminPermission.class);
                    if (CallChecker.beforeDeref(pc, Map.class, 966, 30386, 30387)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 966, 30386, 30387);
                        ap = CallChecker.isCalled(pc, Map.class, 966, 30386, 30387).get("*");
                        CallChecker.varAssign(ap, "ap", 966, 30386, 30387);
                    }
                    if (ap != null) {
                        effective |= ap.action_mask;
                        CallChecker.varAssign(effective, "effective", 968, 30426, 30453);
                        requested = CallChecker.beforeCalled(requested, AdminPermission.class, 969, 30480, 30488);
                        final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, AdminPermission.class, 969, 30480, 30488).action_mask)), "desired", 969, 30460, 30501);
                        if ((effective & desired) == desired) {
                            return true;
                        }
                    }
                }
                if (CallChecker.beforeDeref(pc, Map.class, 975, 30596, 30597)) {
                    pc = CallChecker.beforeCalled(pc, Map.class, 975, 30596, 30597);
                    perms = CallChecker.isCalled(pc, Map.class, 975, 30596, 30597).values();
                    CallChecker.varAssign(perms, "perms", 975, 30588, 30607);
                }
            }
            if (CallChecker.beforeDeref(perms, boolean.class, 979, 30673, 30677)) {
                for (AdminPermission perm : perms) {
                    if (CallChecker.beforeDeref(perm, AdminPermission.class, 980, 30689, 30692)) {
                        if (CallChecker.isCalled(perm, AdminPermission.class, 980, 30689, 30692).implies0(requested, effective)) {
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
            _bcornu_methode_context750.methodEnd();
        }
    }

    @Override
    public synchronized Enumeration<Permission> elements() {
        MethodContext _bcornu_methode_context751 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 994, 30775, 31124);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdminPermissionCollection.serialPersistentFields", 994, 30775, 31124);
            CallChecker.varInit(this.all_allowed, "all_allowed", 994, 30775, 31124);
            CallChecker.varInit(this.permissions, "permissions", 994, 30775, 31124);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdminPermissionCollection.serialVersionUID", 994, 30775, 31124);
            List<Permission> all = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(permissions, Map.class, 995, 31061, 31071)) {
                permissions = CallChecker.beforeCalled(permissions, Map.class, 995, 31061, 31071);
                all = new ArrayList<Permission>(CallChecker.isCalled(permissions, Map.class, 995, 31061, 31071).values());
                CallChecker.varAssign(all, "all", 995, 31061, 31071);
            }
            return Collections.enumeration(all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<Permission>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context751.methodEnd();
        }
    }

    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", Hashtable.class) , new ObjectStreamField("all_allowed", Boolean.TYPE) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context752 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1002, 31332, 31680);
            CallChecker.varInit(out, "out", 1002, 31332, 31680);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdminPermissionCollection.serialPersistentFields", 1002, 31332, 31680);
            CallChecker.varInit(this.all_allowed, "all_allowed", 1002, 31332, 31680);
            CallChecker.varInit(this.permissions, "permissions", 1002, 31332, 31680);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdminPermissionCollection.serialVersionUID", 1002, 31332, 31680);
            Hashtable<String, AdminPermission> hashtable = CallChecker.varInit(new Hashtable<String, AdminPermission>(permissions), "hashtable", 1003, 31417, 31515);
            ObjectOutputStream.PutField pfields = CallChecker.init(ObjectOutputStream.PutField.class);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1004, 31557, 31559)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1004, 31557, 31559);
                pfields = CallChecker.isCalled(out, ObjectOutputStream.class, 1004, 31557, 31559).putFields();
                CallChecker.varAssign(pfields, "pfields", 1004, 31557, 31559);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 1005, 31576, 31582)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 1005, 31576, 31582);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 1005, 31576, 31582).put("permissions", hashtable);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 1006, 31617, 31623)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 1006, 31617, 31623);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 1006, 31617, 31623).put("all_allowed", all_allowed);
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1007, 31660, 31662)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1007, 31660, 31662);
                CallChecker.isCalled(out, ObjectOutputStream.class, 1007, 31660, 31662).writeFields();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context752.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context753 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1010, 31684, 32122);
            CallChecker.varInit(in, "in", 1010, 31684, 32122);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdminPermissionCollection.serialPersistentFields", 1010, 31684, 32122);
            CallChecker.varInit(this.all_allowed, "all_allowed", 1010, 31684, 32122);
            CallChecker.varInit(this.permissions, "permissions", 1010, 31684, 32122);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdminPermissionCollection.serialVersionUID", 1010, 31684, 32122);
            ObjectInputStream.GetField gfields = CallChecker.init(ObjectInputStream.GetField.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1011, 31835, 31836)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1011, 31835, 31836);
                gfields = CallChecker.isCalled(in, ObjectInputStream.class, 1011, 31835, 31836).readFields();
                CallChecker.varAssign(gfields, "gfields", 1011, 31835, 31836);
            }
            Hashtable<String, AdminPermission> hashtable = CallChecker.init(Hashtable.class);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 1013, 31971, 31977)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 1013, 31971, 31977);
                hashtable = ((Hashtable<String, AdminPermission>) (CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 1013, 31971, 31977).get("permissions", null)));
                CallChecker.varAssign(hashtable, "hashtable", 1013, 31971, 31977);
            }
            permissions = new HashMap<String, AdminPermission>(hashtable);
            CallChecker.varAssign(this.permissions, "this.permissions", 1014, 32007, 32068);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 1015, 32086, 32092)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 1015, 32086, 32092);
                all_allowed = CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 1015, 32086, 32092).get("all_allowed", false);
                CallChecker.varAssign(this.all_allowed, "this.all_allowed", 1015, 32072, 32119);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context753.methodEnd();
        }
    }
}

