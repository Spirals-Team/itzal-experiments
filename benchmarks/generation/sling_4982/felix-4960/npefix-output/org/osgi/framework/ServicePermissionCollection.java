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

final class ServicePermissionCollection extends PermissionCollection {
    static final long serialVersionUID = 662615640374640621L;

    private transient Map<String, ServicePermission> permissions;

    private boolean all_allowed;

    private Map<String, ServicePermission> filterPermissions;

    public ServicePermissionCollection() {
        MethodContext _bcornu_methode_context117 = new MethodContext(null);
        try {
            permissions = new HashMap<String, ServicePermission>();
            CallChecker.varAssign(this.permissions, "this.permissions", 715, 20740, 20794);
            all_allowed = false;
            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 716, 20798, 20817);
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    @Override
    public void add(final Permission permission) {
        MethodContext _bcornu_methode_context1118 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 729, 20824, 22428);
            CallChecker.varInit(permission, "permission", 729, 20824, 22428);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.ServicePermissionCollection.serialPersistentFields", 729, 20824, 22428);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 729, 20824, 22428);
            CallChecker.varInit(this.all_allowed, "all_allowed", 729, 20824, 22428);
            CallChecker.varInit(this.permissions, "permissions", 729, 20824, 22428);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermissionCollection.serialVersionUID", 729, 20824, 22428);
            if (!(permission instanceof ServicePermission)) {
                throw new IllegalArgumentException(("invalid permission: " + permission));
            }
            if (isReadOnly()) {
                throw new SecurityException(("attempt to add a Permission to a " + "readonly PermissionCollection"));
            }
            final ServicePermission sp = CallChecker.varInit(((ServicePermission) (permission)), "sp", 737, 21498, 21557);
            if (CallChecker.beforeDeref(sp, ServicePermission.class, 738, 21565, 21566)) {
                if ((CallChecker.isCalled(sp, ServicePermission.class, 738, 21565, 21566).service) != null) {
                    throw new IllegalArgumentException(("cannot add to collection: " + sp));
                }
            }
            final String name = CallChecker.varInit(CallChecker.isCalled(sp, ServicePermission.class, 742, 21688, 21689).getName(), "name", 742, 21668, 21700);
            final Filter f = CallChecker.varInit(CallChecker.isCalled(sp, ServicePermission.class, 743, 21721, 21722).filter, "f", 743, 21704, 21730);
            synchronized(this) {
                Map<String, ServicePermission> pc = CallChecker.init(Map.class);
                if (f != null) {
                    pc = filterPermissions;
                    CallChecker.varAssign(pc, "pc", 748, 21864, 21886);
                    if (pc == null) {
                        filterPermissions = pc = new HashMap<String, ServicePermission>();
                        CallChecker.varAssign(this.filterPermissions, "this.filterPermissions", 750, 21915, 21980);
                        CallChecker.varAssign(pc, "pc", 750, 21935, 21979);
                    }
                }else {
                    pc = permissions;
                    CallChecker.varAssign(pc, "pc", 753, 22004, 22020);
                }
                pc = CallChecker.beforeCalled(pc, Map.class, 755, 22065, 22066);
                final ServicePermission existing = CallChecker.varInit(CallChecker.isCalled(pc, Map.class, 755, 22065, 22066).get(name), "existing", 755, 22030, 22077);
                if (existing != null) {
                    final int oldMask = CallChecker.varInit(((int) (existing.action_mask)), "oldMask", 758, 22111, 22151);
                    final int newMask = CallChecker.varInit(((int) (CallChecker.isCalled(sp, ServicePermission.class, 759, 22177, 22178).action_mask)), "newMask", 759, 22157, 22191);
                    if (oldMask != newMask) {
                        if (CallChecker.beforeDeref(pc, Map.class, 761, 22228, 22229)) {
                            pc = CallChecker.beforeCalled(pc, Map.class, 761, 22228, 22229);
                            CallChecker.isCalled(pc, Map.class, 761, 22228, 22229).put(name, new ServicePermission(name, (oldMask | newMask)));
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(pc, Map.class, 764, 22312, 22313)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 764, 22312, 22313);
                        CallChecker.isCalled(pc, Map.class, 764, 22312, 22313).put(name, sp);
                    }
                }
                if (!(all_allowed)) {
                    if (CallChecker.beforeDeref(name, String.class, 768, 22367, 22370)) {
                        if (CallChecker.isCalled(name, String.class, 768, 22367, 22370).equals("*")) {
                            all_allowed = true;
                            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 769, 22392, 22410);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1118.methodEnd();
        }
    }

    @Override
    public boolean implies(final Permission permission) {
        MethodContext _bcornu_methode_context1119 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 784, 22432, 24357);
            CallChecker.varInit(permission, "permission", 784, 22432, 24357);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.ServicePermissionCollection.serialPersistentFields", 784, 22432, 24357);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 784, 22432, 24357);
            CallChecker.varInit(this.all_allowed, "all_allowed", 784, 22432, 24357);
            CallChecker.varInit(this.permissions, "permissions", 784, 22432, 24357);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermissionCollection.serialVersionUID", 784, 22432, 24357);
            if (!(permission instanceof ServicePermission)) {
                return false;
            }
            final ServicePermission requested = CallChecker.varInit(((ServicePermission) (permission)), "requested", 788, 22874, 22940);
            if (CallChecker.beforeDeref(requested, ServicePermission.class, 790, 23025, 23033)) {
                if ((CallChecker.isCalled(requested, ServicePermission.class, 790, 23025, 23033).filter) != null) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            int effective = CallChecker.varInit(((int) (ServicePermission.ACTION_NONE)), "effective", 794, 23077, 23122);
            Collection<ServicePermission> perms = CallChecker.init(Collection.class);
            synchronized(this) {
                final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, ServicePermission.class, 797, 23210, 23218).action_mask)), "desired", 797, 23190, 23231);
                if (all_allowed) {
                    ServicePermission sp = CallChecker.init(ServicePermission.class);
                    if (CallChecker.beforeDeref(permissions, Map.class, 800, 23337, 23347)) {
                        permissions = CallChecker.beforeCalled(permissions, Map.class, 800, 23337, 23347);
                        sp = CallChecker.isCalled(permissions, Map.class, 800, 23337, 23347).get("*");
                        CallChecker.varAssign(sp, "sp", 800, 23337, 23347);
                    }
                    if (sp != null) {
                        effective |= sp.action_mask;
                        CallChecker.varAssign(effective, "effective", 802, 23386, 23413);
                        if ((effective & desired) == desired) {
                            return true;
                        }
                    }
                }
                String[] requestedNames = CallChecker.init(String[].class);
                if (CallChecker.beforeDeref(requested, ServicePermission.class, 809, 23527, 23535)) {
                    requestedNames = CallChecker.isCalled(requested, ServicePermission.class, 809, 23527, 23535).objectClass;
                    CallChecker.varAssign(requestedNames, "requestedNames", 809, 23527, 23535);
                }
                if (requestedNames == null) {
                    if (CallChecker.beforeDeref(requested, ServicePermission.class, 812, 23677, 23685)) {
                        effective |= effective(CallChecker.isCalled(requested, ServicePermission.class, 812, 23677, 23685).getName(), desired, effective);
                        CallChecker.varAssign(effective, "effective", 812, 23654, 23717);
                    }
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }else {
                    for (int i = 0, l = requestedNames.length; i < l; i++) {
                        if (((effective(requestedNames[i], desired, effective)) & desired) == desired) {
                            return true;
                        }
                    }
                }
                Map<String, ServicePermission> pc = CallChecker.varInit(filterPermissions, "pc", 825, 24047, 24100);
                if (pc == null) {
                    return false;
                }
                perms = pc.values();
                CallChecker.varAssign(perms, "perms", 829, 24149, 24168);
            }
            if (CallChecker.beforeDeref(perms, boolean.class, 833, 24259, 24263)) {
                for (ServicePermission perm : perms) {
                    if (CallChecker.beforeDeref(perm, ServicePermission.class, 834, 24275, 24278)) {
                        if (CallChecker.isCalled(perm, ServicePermission.class, 834, 24275, 24278).implies0(requested, effective)) {
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
            _bcornu_methode_context1119.methodEnd();
        }
    }

    private int effective(String requestedName, final int desired, int effective) {
        MethodContext _bcornu_methode_context1120 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 850, 24361, 25634);
            CallChecker.varInit(effective, "effective", 850, 24361, 25634);
            CallChecker.varInit(desired, "desired", 850, 24361, 25634);
            CallChecker.varInit(requestedName, "requestedName", 850, 24361, 25634);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.ServicePermissionCollection.serialPersistentFields", 850, 24361, 25634);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 850, 24361, 25634);
            CallChecker.varInit(this.all_allowed, "all_allowed", 850, 24361, 25634);
            CallChecker.varInit(this.permissions, "permissions", 850, 24361, 25634);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermissionCollection.serialVersionUID", 850, 24361, 25634);
            final Map<String, ServicePermission> pc = CallChecker.varInit(permissions, "pc", 851, 24737, 24790);
            ServicePermission sp = CallChecker.init(ServicePermission.class);
            if (CallChecker.beforeDeref(pc, Map.class, 852, 24817, 24818)) {
                sp = CallChecker.isCalled(pc, Map.class, 852, 24817, 24818).get(requestedName);
                CallChecker.varAssign(sp, "sp", 852, 24817, 24818);
            }
            if (sp != null) {
                effective |= sp.action_mask;
                CallChecker.varAssign(effective, "effective", 858, 25003, 25030);
                if ((effective & desired) == desired) {
                    return effective;
                }
            }
            int last = CallChecker.init(int.class);
            int offset = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(requestedName, String.class, 865, 25166, 25178)) {
                requestedName = CallChecker.beforeCalled(requestedName, String.class, 865, 25166, 25178);
                offset = (CallChecker.isCalled(requestedName, String.class, 865, 25166, 25178).length()) - 1;
                CallChecker.varAssign(offset, "offset", 865, 25166, 25178);
            }
            requestedName = CallChecker.beforeCalled(requestedName, String.class, 866, 25211, 25223);
            while ((last = CallChecker.isCalled(requestedName, String.class, 866, 25211, 25223).lastIndexOf(".", offset)) != (-1)) {
                CallChecker.varAssign(last, "last", 866, 25203, 25249);
                if (CallChecker.beforeDeref(requestedName, String.class, 867, 25279, 25291)) {
                    requestedName = CallChecker.beforeCalled(requestedName, String.class, 867, 25279, 25291);
                    requestedName = (CallChecker.isCalled(requestedName, String.class, 867, 25279, 25291).substring(0, (last + 1))) + "*";
                    CallChecker.varAssign(requestedName, "requestedName", 867, 25263, 25321);
                }
                if (CallChecker.beforeDeref(pc, Map.class, 868, 25331, 25332)) {
                    sp = CallChecker.isCalled(pc, Map.class, 868, 25331, 25332).get(requestedName);
                    CallChecker.varAssign(sp, "sp", 868, 25326, 25352);
                }
                if (sp != null) {
                    effective |= sp.action_mask;
                    CallChecker.varAssign(effective, "effective", 870, 25379, 25406);
                    if ((effective & desired) == desired) {
                        return effective;
                    }
                }
                offset = last - 1;
                CallChecker.varAssign(offset, "offset", 875, 25489, 25506);
            } 
            return effective;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1120.methodEnd();
        }
    }

    @Override
    public synchronized Enumeration<Permission> elements() {
        MethodContext _bcornu_methode_context1121 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 891, 25638, 26100);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.ServicePermissionCollection.serialPersistentFields", 891, 25638, 26100);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 891, 25638, 26100);
            CallChecker.varInit(this.all_allowed, "all_allowed", 891, 25638, 26100);
            CallChecker.varInit(this.permissions, "permissions", 891, 25638, 26100);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermissionCollection.serialVersionUID", 891, 25638, 26100);
            List<Permission> all = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(permissions, Map.class, 892, 25928, 25938)) {
                permissions = CallChecker.beforeCalled(permissions, Map.class, 892, 25928, 25938);
                all = new ArrayList<Permission>(CallChecker.isCalled(permissions, Map.class, 892, 25928, 25938).values());
                CallChecker.varAssign(all, "all", 892, 25928, 25938);
            }
            Map<String, ServicePermission> pc = CallChecker.varInit(filterPermissions, "pc", 893, 25953, 26006);
            if (pc != null) {
                if (CallChecker.beforeDeref(all, List.class, 895, 26031, 26033)) {
                    all = CallChecker.beforeCalled(all, List.class, 895, 26031, 26033);
                    CallChecker.isCalled(all, List.class, 895, 26031, 26033).addAll(pc.values());
                }
            }
            return Collections.enumeration(all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<Permission>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1121.methodEnd();
        }
    }

    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", Hashtable.class) , new ObjectStreamField("all_allowed", Boolean.TYPE) , new ObjectStreamField("filterPermissions", HashMap.class) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1122 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 904, 26371, 26778);
            CallChecker.varInit(out, "out", 904, 26371, 26778);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.ServicePermissionCollection.serialPersistentFields", 904, 26371, 26778);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 904, 26371, 26778);
            CallChecker.varInit(this.all_allowed, "all_allowed", 904, 26371, 26778);
            CallChecker.varInit(this.permissions, "permissions", 904, 26371, 26778);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermissionCollection.serialVersionUID", 904, 26371, 26778);
            Hashtable<String, ServicePermission> hashtable = CallChecker.varInit(new Hashtable<String, ServicePermission>(permissions), "hashtable", 905, 26456, 26558);
            ObjectOutputStream.PutField pfields = CallChecker.init(ObjectOutputStream.PutField.class);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 906, 26600, 26602)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 906, 26600, 26602);
                pfields = CallChecker.isCalled(out, ObjectOutputStream.class, 906, 26600, 26602).putFields();
                CallChecker.varAssign(pfields, "pfields", 906, 26600, 26602);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 907, 26619, 26625)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 907, 26619, 26625);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 907, 26619, 26625).put("permissions", hashtable);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 908, 26660, 26666)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 908, 26660, 26666);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 908, 26660, 26666).put("all_allowed", all_allowed);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 909, 26703, 26709)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 909, 26703, 26709);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 909, 26703, 26709).put("filterPermissions", filterPermissions);
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 910, 26758, 26760)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 910, 26758, 26760);
                CallChecker.isCalled(out, ObjectOutputStream.class, 910, 26758, 26760).writeFields();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1122.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1123 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 913, 26782, 27404);
            CallChecker.varInit(in, "in", 913, 26782, 27404);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.ServicePermissionCollection.serialPersistentFields", 913, 26782, 27404);
            CallChecker.varInit(this.filterPermissions, "filterPermissions", 913, 26782, 27404);
            CallChecker.varInit(this.all_allowed, "all_allowed", 913, 26782, 27404);
            CallChecker.varInit(this.permissions, "permissions", 913, 26782, 27404);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServicePermissionCollection.serialVersionUID", 913, 26782, 27404);
            ObjectInputStream.GetField gfields = CallChecker.init(ObjectInputStream.GetField.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 914, 26933, 26934)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 914, 26933, 26934);
                gfields = CallChecker.isCalled(in, ObjectInputStream.class, 914, 26933, 26934).readFields();
                CallChecker.varAssign(gfields, "gfields", 914, 26933, 26934);
            }
            Hashtable<String, ServicePermission> hashtable = CallChecker.init(Hashtable.class);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 916, 27073, 27079)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 916, 27073, 27079);
                hashtable = ((Hashtable<String, ServicePermission>) (CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 916, 27073, 27079).get("permissions", null)));
                CallChecker.varAssign(hashtable, "hashtable", 916, 27073, 27079);
            }
            permissions = new HashMap<String, ServicePermission>(hashtable);
            CallChecker.varAssign(this.permissions, "this.permissions", 917, 27109, 27172);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 918, 27190, 27196)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 918, 27190, 27196);
                all_allowed = CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 918, 27190, 27196).get("all_allowed", false);
                CallChecker.varAssign(this.all_allowed, "this.all_allowed", 918, 27176, 27223);
            }
            HashMap<String, ServicePermission> fp = CallChecker.init(HashMap.class);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 920, 27337, 27343)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 920, 27337, 27343);
                fp = ((HashMap<String, ServicePermission>) (CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 920, 27337, 27343).get("filterPermissions", null)));
                CallChecker.varAssign(fp, "fp", 920, 27337, 27343);
            }
            filterPermissions = fp;
            CallChecker.varAssign(this.filterPermissions, "this.filterPermissions", 921, 27379, 27401);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1123.methodEnd();
        }
    }
}

