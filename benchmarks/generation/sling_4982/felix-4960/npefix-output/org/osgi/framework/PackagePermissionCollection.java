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

final class PackagePermissionCollection extends PermissionCollection {
    static final long serialVersionUID = -3350758995234427603L;

    private transient Map<String, PackagePermission> permissions;

    private boolean all_allowed;

    private Map<String, PackagePermission> filterPermissions;

    public PackagePermissionCollection() {
        MethodContext _bcornu_methode_context6 = new MethodContext(null);
        try {
            permissions = new HashMap<String, PackagePermission>();
            CallChecker.varAssign(this.permissions, "this.permissions", 603, 17822, 17876);
            all_allowed = false;
            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 604, 17880, 17899);
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    @Override
    public void add(final Permission permission) {
        MethodContext _bcornu_methode_context112 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 618, 17906, 19587);
            CallChecker.varInit(permission, "permission", 618, 17906, 19587);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.PackagePermissionCollection.serialPersistentFields", 618, 17906, 19587);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 618, 17906, 19587);
            CallChecker.varInit(this.all_allowed, "all_allowed", 618, 17906, 19587);
            CallChecker.varInit(this.permissions, "permissions", 618, 17906, 19587);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermissionCollection.serialVersionUID", 618, 17906, 19587);
            if (!(permission instanceof PackagePermission)) {
                throw new IllegalArgumentException(("invalid permission: " + permission));
            }
            if (isReadOnly()) {
                throw new SecurityException(("attempt to add a Permission to a " + "readonly PermissionCollection"));
            }
            final PackagePermission pp = CallChecker.varInit(((PackagePermission) (permission)), "pp", 626, 18657, 18716);
            if (CallChecker.beforeDeref(pp, PackagePermission.class, 627, 18724, 18725)) {
                if ((CallChecker.isCalled(pp, PackagePermission.class, 627, 18724, 18725).bundle) != null) {
                    throw new IllegalArgumentException(("cannot add to collection: " + pp));
                }
            }
            final String name = CallChecker.varInit(CallChecker.isCalled(pp, PackagePermission.class, 631, 18846, 18847).getName(), "name", 631, 18826, 18858);
            final Filter f = CallChecker.varInit(CallChecker.isCalled(pp, PackagePermission.class, 632, 18879, 18880).filter, "f", 632, 18862, 18888);
            synchronized(this) {
                Map<String, PackagePermission> pc = CallChecker.init(Map.class);
                if (f != null) {
                    pc = filterPermissions;
                    CallChecker.varAssign(pc, "pc", 637, 19022, 19044);
                    if (pc == null) {
                        filterPermissions = pc = new HashMap<String, PackagePermission>();
                        CallChecker.varAssign(this.filterPermissions, "this.filterPermissions", 639, 19073, 19138);
                        CallChecker.varAssign(pc, "pc", 639, 19093, 19137);
                    }
                }else {
                    pc = permissions;
                    CallChecker.varAssign(pc, "pc", 642, 19162, 19178);
                }
                pc = CallChecker.beforeCalled(pc, Map.class, 645, 19224, 19225);
                final PackagePermission existing = CallChecker.varInit(CallChecker.isCalled(pc, Map.class, 645, 19224, 19225).get(name), "existing", 645, 19189, 19236);
                if (existing != null) {
                    final int oldMask = CallChecker.varInit(((int) (existing.action_mask)), "oldMask", 647, 19269, 19309);
                    final int newMask = CallChecker.varInit(((int) (CallChecker.isCalled(pp, PackagePermission.class, 648, 19335, 19336).action_mask)), "newMask", 648, 19315, 19349);
                    if (oldMask != newMask) {
                        if (CallChecker.beforeDeref(pc, Map.class, 650, 19386, 19387)) {
                            pc = CallChecker.beforeCalled(pc, Map.class, 650, 19386, 19387);
                            CallChecker.isCalled(pc, Map.class, 650, 19386, 19387).put(name, new PackagePermission(name, (oldMask | newMask)));
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(pc, Map.class, 654, 19471, 19472)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 654, 19471, 19472);
                        CallChecker.isCalled(pc, Map.class, 654, 19471, 19472).put(name, pp);
                    }
                }
                if (!(all_allowed)) {
                    if (CallChecker.beforeDeref(name, String.class, 658, 19526, 19529)) {
                        if (CallChecker.isCalled(name, String.class, 658, 19526, 19529).equals("*")) {
                            all_allowed = true;
                            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 659, 19551, 19569);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context112.methodEnd();
        }
    }

    @Override
    public boolean implies(final Permission permission) {
        MethodContext _bcornu_methode_context113 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 675, 19591, 21926);
            CallChecker.varInit(permission, "permission", 675, 19591, 21926);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.PackagePermissionCollection.serialPersistentFields", 675, 19591, 21926);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 675, 19591, 21926);
            CallChecker.varInit(this.all_allowed, "all_allowed", 675, 19591, 21926);
            CallChecker.varInit(this.permissions, "permissions", 675, 19591, 21926);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermissionCollection.serialVersionUID", 675, 19591, 21926);
            if (!(permission instanceof PackagePermission)) {
                return false;
            }
            final PackagePermission requested = CallChecker.varInit(((PackagePermission) (permission)), "requested", 679, 20092, 20158);
            if (CallChecker.beforeDeref(requested, PackagePermission.class, 681, 20243, 20251)) {
                if ((CallChecker.isCalled(requested, PackagePermission.class, 681, 20243, 20251).filter) != null) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            String requestedName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(requested, PackagePermission.class, 684, 20317, 20325)) {
                requestedName = CallChecker.isCalled(requested, PackagePermission.class, 684, 20317, 20325).getName();
                CallChecker.varAssign(requestedName, "requestedName", 684, 20317, 20325);
            }
            final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, PackagePermission.class, 685, 20360, 20368).action_mask)), "desired", 685, 20340, 20381);
            int effective = CallChecker.varInit(((int) (PackagePermission.ACTION_NONE)), "effective", 686, 20385, 20430);
            Collection<PackagePermission> perms = CallChecker.init(Collection.class);
            synchronized(this) {
                Map<String, PackagePermission> pc = CallChecker.varInit(permissions, "pc", 690, 20499, 20546);
                PackagePermission pp = CallChecker.init(PackagePermission.class);
                if (all_allowed) {
                    if (CallChecker.beforeDeref(pc, Map.class, 694, 20659, 20660)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 694, 20659, 20660);
                        pp = CallChecker.isCalled(pc, Map.class, 694, 20659, 20660).get("*");
                        CallChecker.varAssign(pp, "pp", 694, 20654, 20670);
                    }
                    if (pp != null) {
                        effective |= pp.action_mask;
                        CallChecker.varAssign(effective, "effective", 696, 20699, 20726);
                        if ((effective & desired) == desired) {
                            return true;
                        }
                    }
                }
                if (CallChecker.beforeDeref(pc, Map.class, 706, 20940, 20941)) {
                    pc = CallChecker.beforeCalled(pc, Map.class, 706, 20940, 20941);
                    pp = CallChecker.isCalled(pc, Map.class, 706, 20940, 20941).get(requestedName);
                    CallChecker.varAssign(pp, "pp", 706, 20935, 20961);
                }
                if (pp != null) {
                    effective |= pp.action_mask;
                    CallChecker.varAssign(effective, "effective", 709, 21020, 21047);
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }
                int last = CallChecker.init(int.class);
                int offset = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(requestedName, String.class, 716, 21188, 21200)) {
                    requestedName = CallChecker.beforeCalled(requestedName, String.class, 716, 21188, 21200);
                    offset = (CallChecker.isCalled(requestedName, String.class, 716, 21188, 21200).length()) - 1;
                    CallChecker.varAssign(offset, "offset", 716, 21188, 21200);
                }
                requestedName = CallChecker.beforeCalled(requestedName, String.class, 717, 21234, 21246);
                while ((last = CallChecker.isCalled(requestedName, String.class, 717, 21234, 21246).lastIndexOf(".", offset)) != (-1)) {
                    CallChecker.varAssign(last, "last", 717, 21226, 21272);
                    if (CallChecker.beforeDeref(requestedName, String.class, 718, 21303, 21315)) {
                        requestedName = CallChecker.beforeCalled(requestedName, String.class, 718, 21303, 21315);
                        requestedName = (CallChecker.isCalled(requestedName, String.class, 718, 21303, 21315).substring(0, (last + 1))) + "*";
                        CallChecker.varAssign(requestedName, "requestedName", 718, 21287, 21345);
                    }
                    if (CallChecker.beforeDeref(pc, Map.class, 719, 21356, 21357)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 719, 21356, 21357);
                        pp = CallChecker.isCalled(pc, Map.class, 719, 21356, 21357).get(requestedName);
                        CallChecker.varAssign(pp, "pp", 719, 21351, 21377);
                    }
                    if (pp != null) {
                        effective |= pp.action_mask;
                        CallChecker.varAssign(effective, "effective", 721, 21406, 21433);
                        if ((effective & desired) == desired) {
                            return true;
                        }
                    }
                    offset = last - 1;
                    CallChecker.varAssign(offset, "offset", 726, 21516, 21533);
                } 
                pc = filterPermissions;
                CallChecker.varAssign(pc, "pc", 732, 21648, 21670);
                if (pc == null) {
                    return false;
                }
                perms = pc.values();
                CallChecker.varAssign(perms, "perms", 736, 21719, 21738);
            }
            if (CallChecker.beforeDeref(perms, boolean.class, 739, 21828, 21832)) {
                for (PackagePermission perm : perms) {
                    if (CallChecker.beforeDeref(perm, PackagePermission.class, 740, 21844, 21847)) {
                        if (CallChecker.isCalled(perm, PackagePermission.class, 740, 21844, 21847).implies0(requested, effective)) {
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
            _bcornu_methode_context113.methodEnd();
        }
    }

    @Override
    public synchronized Enumeration<Permission> elements() {
        MethodContext _bcornu_methode_context114 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 754, 21930, 22392);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.PackagePermissionCollection.serialPersistentFields", 754, 21930, 22392);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 754, 21930, 22392);
            CallChecker.varInit(this.all_allowed, "all_allowed", 754, 21930, 22392);
            CallChecker.varInit(this.permissions, "permissions", 754, 21930, 22392);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermissionCollection.serialVersionUID", 754, 21930, 22392);
            List<Permission> all = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(permissions, Map.class, 755, 22220, 22230)) {
                permissions = CallChecker.beforeCalled(permissions, Map.class, 755, 22220, 22230);
                all = new ArrayList<Permission>(CallChecker.isCalled(permissions, Map.class, 755, 22220, 22230).values());
                CallChecker.varAssign(all, "all", 755, 22220, 22230);
            }
            Map<String, PackagePermission> pc = CallChecker.varInit(filterPermissions, "pc", 756, 22245, 22298);
            if (pc != null) {
                if (CallChecker.beforeDeref(all, List.class, 758, 22323, 22325)) {
                    all = CallChecker.beforeCalled(all, List.class, 758, 22323, 22325);
                    CallChecker.isCalled(all, List.class, 758, 22323, 22325).addAll(pc.values());
                }
            }
            return Collections.enumeration(all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<Permission>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context114.methodEnd();
        }
    }

    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", Hashtable.class) , new ObjectStreamField("all_allowed", Boolean.TYPE) , new ObjectStreamField("filterPermissions", HashMap.class) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context115 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 767, 22663, 23070);
            CallChecker.varInit(out, "out", 767, 22663, 23070);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.PackagePermissionCollection.serialPersistentFields", 767, 22663, 23070);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 767, 22663, 23070);
            CallChecker.varInit(this.all_allowed, "all_allowed", 767, 22663, 23070);
            CallChecker.varInit(this.permissions, "permissions", 767, 22663, 23070);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermissionCollection.serialVersionUID", 767, 22663, 23070);
            Hashtable<String, PackagePermission> hashtable = CallChecker.varInit(new Hashtable<String, PackagePermission>(permissions), "hashtable", 768, 22748, 22850);
            ObjectOutputStream.PutField pfields = CallChecker.init(ObjectOutputStream.PutField.class);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 769, 22892, 22894)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 769, 22892, 22894);
                pfields = CallChecker.isCalled(out, ObjectOutputStream.class, 769, 22892, 22894).putFields();
                CallChecker.varAssign(pfields, "pfields", 769, 22892, 22894);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 770, 22911, 22917)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 770, 22911, 22917);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 770, 22911, 22917).put("permissions", hashtable);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 771, 22952, 22958)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 771, 22952, 22958);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 771, 22952, 22958).put("all_allowed", all_allowed);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 772, 22995, 23001)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 772, 22995, 23001);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 772, 22995, 23001).put("filterPermissions", filterPermissions);
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 773, 23050, 23052)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 773, 23050, 23052);
                CallChecker.isCalled(out, ObjectOutputStream.class, 773, 23050, 23052).writeFields();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context115.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context116 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 776, 23074, 23696);
            CallChecker.varInit(in, "in", 776, 23074, 23696);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.PackagePermissionCollection.serialPersistentFields", 776, 23074, 23696);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 776, 23074, 23696);
            CallChecker.varInit(this.all_allowed, "all_allowed", 776, 23074, 23696);
            CallChecker.varInit(this.permissions, "permissions", 776, 23074, 23696);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.PackagePermissionCollection.serialVersionUID", 776, 23074, 23696);
            ObjectInputStream.GetField gfields = CallChecker.init(ObjectInputStream.GetField.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 777, 23225, 23226)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 777, 23225, 23226);
                gfields = CallChecker.isCalled(in, ObjectInputStream.class, 777, 23225, 23226).readFields();
                CallChecker.varAssign(gfields, "gfields", 777, 23225, 23226);
            }
            Hashtable<String, PackagePermission> hashtable = CallChecker.init(Hashtable.class);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 779, 23365, 23371)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 779, 23365, 23371);
                hashtable = ((Hashtable<String, PackagePermission>) (CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 779, 23365, 23371).get("permissions", null)));
                CallChecker.varAssign(hashtable, "hashtable", 779, 23365, 23371);
            }
            permissions = new HashMap<String, PackagePermission>(hashtable);
            CallChecker.varAssign(this.permissions, "this.permissions", 780, 23401, 23464);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 781, 23482, 23488)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 781, 23482, 23488);
                all_allowed = CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 781, 23482, 23488).get("all_allowed", false);
                CallChecker.varAssign(this.all_allowed, "this.all_allowed", 781, 23468, 23515);
            }
            HashMap<String, PackagePermission> fp = CallChecker.init(HashMap.class);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 783, 23629, 23635)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 783, 23629, 23635);
                fp = ((HashMap<String, PackagePermission>) (CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 783, 23629, 23635).get("filterPermissions", null)));
                CallChecker.varAssign(fp, "fp", 783, 23629, 23635);
            }
            filterPermissions = fp;
            CallChecker.varAssign(this.filterPermissions, "this.filterPermissions", 784, 23671, 23693);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context116.methodEnd();
        }
    }
}

