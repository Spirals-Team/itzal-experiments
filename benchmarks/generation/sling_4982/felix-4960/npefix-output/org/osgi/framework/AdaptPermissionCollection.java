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

final class AdaptPermissionCollection extends PermissionCollection {
    static final long serialVersionUID = -3350758995234427603L;

    private Map<String, AdaptPermission> permissions;

    private boolean all_allowed;

    public AdaptPermissionCollection() {
        MethodContext _bcornu_methode_context79 = new MethodContext(null);
        try {
            permissions = new HashMap<String, AdaptPermission>();
            CallChecker.varAssign(this.permissions, "this.permissions", 495, 14123, 14175);
            all_allowed = false;
            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 496, 14179, 14198);
        } finally {
            _bcornu_methode_context79.methodEnd();
        }
    }

    @Override
    public void add(final Permission permission) {
        MethodContext _bcornu_methode_context852 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 510, 14205, 15629);
            CallChecker.varInit(permission, "permission", 510, 14205, 15629);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdaptPermissionCollection.serialPersistentFields", 510, 14205, 15629);
            CallChecker.varInit(this.all_allowed, "all_allowed", 510, 14205, 15629);
            CallChecker.varInit(this.permissions, "permissions", 510, 14205, 15629);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermissionCollection.serialVersionUID", 510, 14205, 15629);
            if (!(permission instanceof AdaptPermission)) {
                throw new IllegalArgumentException(("invalid permission: " + permission));
            }
            if (isReadOnly()) {
                throw new SecurityException(("attempt to add a Permission to a " + "readonly PermissionCollection"));
            }
            final AdaptPermission ap = CallChecker.varInit(((AdaptPermission) (permission)), "ap", 518, 14948, 15003);
            if (CallChecker.beforeDeref(ap, AdaptPermission.class, 519, 15011, 15012)) {
                if ((CallChecker.isCalled(ap, AdaptPermission.class, 519, 15011, 15012).bundle) != null) {
                    throw new IllegalArgumentException(("cannot add to collection: " + ap));
                }
            }
            final String name = CallChecker.varInit(CallChecker.isCalled(ap, AdaptPermission.class, 523, 15133, 15134).getName(), "name", 523, 15113, 15145);
            synchronized(this) {
                Map<String, AdaptPermission> pc = CallChecker.varInit(permissions, "pc", 525, 15174, 15219);
                pc = CallChecker.beforeCalled(pc, Map.class, 526, 15257, 15258);
                final AdaptPermission existing = CallChecker.varInit(CallChecker.isCalled(pc, Map.class, 526, 15257, 15258).get(name), "existing", 526, 15224, 15269);
                if (existing != null) {
                    final int oldMask = CallChecker.varInit(((int) (existing.action_mask)), "oldMask", 528, 15302, 15342);
                    final int newMask = CallChecker.varInit(((int) (CallChecker.isCalled(ap, AdaptPermission.class, 529, 15368, 15369).action_mask)), "newMask", 529, 15348, 15382);
                    if (oldMask != newMask) {
                        if (CallChecker.beforeDeref(pc, Map.class, 531, 15419, 15420)) {
                            pc = CallChecker.beforeCalled(pc, Map.class, 531, 15419, 15420);
                            CallChecker.isCalled(pc, Map.class, 531, 15419, 15420).put(name, new AdaptPermission(existing.filter, (oldMask | newMask)));
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(pc, Map.class, 535, 15513, 15514)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 535, 15513, 15514);
                        CallChecker.isCalled(pc, Map.class, 535, 15513, 15514).put(name, ap);
                    }
                }
                if (!(all_allowed)) {
                    if (CallChecker.beforeDeref(name, String.class, 539, 15568, 15571)) {
                        if (CallChecker.isCalled(name, String.class, 539, 15568, 15571).equals("*")) {
                            all_allowed = true;
                            CallChecker.varAssign(this.all_allowed, "this.all_allowed", 540, 15593, 15611);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context852.methodEnd();
        }
    }

    @Override
    public boolean implies(final Permission permission) {
        MethodContext _bcornu_methode_context853 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 556, 15633, 16995);
            CallChecker.varInit(permission, "permission", 556, 15633, 16995);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdaptPermissionCollection.serialPersistentFields", 556, 15633, 16995);
            CallChecker.varInit(this.all_allowed, "all_allowed", 556, 15633, 16995);
            CallChecker.varInit(this.permissions, "permissions", 556, 15633, 16995);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermissionCollection.serialVersionUID", 556, 15633, 16995);
            if (!(permission instanceof AdaptPermission)) {
                return false;
            }
            final AdaptPermission requested = CallChecker.varInit(((AdaptPermission) (permission)), "requested", 560, 16130, 16192);
            if (CallChecker.beforeDeref(requested, AdaptPermission.class, 562, 16277, 16285)) {
                if ((CallChecker.isCalled(requested, AdaptPermission.class, 562, 16277, 16285).filter) != null) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            int effective = CallChecker.varInit(((int) (AdaptPermission.ACTION_NONE)), "effective", 566, 16329, 16372);
            Collection<AdaptPermission> perms = CallChecker.init(Collection.class);
            synchronized(this) {
                Map<String, AdaptPermission> pc = CallChecker.varInit(permissions, "pc", 570, 16439, 16484);
                if (all_allowed) {
                    AdaptPermission ap = CallChecker.init(AdaptPermission.class);
                    if (CallChecker.beforeDeref(pc, Map.class, 573, 16588, 16589)) {
                        pc = CallChecker.beforeCalled(pc, Map.class, 573, 16588, 16589);
                        ap = CallChecker.isCalled(pc, Map.class, 573, 16588, 16589).get("*");
                        CallChecker.varAssign(ap, "ap", 573, 16588, 16589);
                    }
                    if (ap != null) {
                        effective |= ap.action_mask;
                        CallChecker.varAssign(effective, "effective", 575, 16628, 16655);
                        final int desired = CallChecker.varInit(((int) (CallChecker.isCalled(requested, AdaptPermission.class, 576, 16682, 16690).action_mask)), "desired", 576, 16662, 16703);
                        if ((effective & desired) == desired) {
                            return true;
                        }
                    }
                }
                if (CallChecker.beforeDeref(pc, Map.class, 582, 16798, 16799)) {
                    pc = CallChecker.beforeCalled(pc, Map.class, 582, 16798, 16799);
                    perms = CallChecker.isCalled(pc, Map.class, 582, 16798, 16799).values();
                    CallChecker.varAssign(perms, "perms", 582, 16790, 16809);
                }
            }
            if (CallChecker.beforeDeref(perms, boolean.class, 585, 16897, 16901)) {
                for (AdaptPermission perm : perms) {
                    if (CallChecker.beforeDeref(perm, AdaptPermission.class, 586, 16913, 16916)) {
                        if (CallChecker.isCalled(perm, AdaptPermission.class, 586, 16913, 16916).implies0(requested, effective)) {
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
            _bcornu_methode_context853.methodEnd();
        }
    }

    @Override
    public synchronized Enumeration<Permission> elements() {
        MethodContext _bcornu_methode_context854 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 600, 16999, 17348);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdaptPermissionCollection.serialPersistentFields", 600, 16999, 17348);
            CallChecker.varInit(this.all_allowed, "all_allowed", 600, 16999, 17348);
            CallChecker.varInit(this.permissions, "permissions", 600, 16999, 17348);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermissionCollection.serialVersionUID", 600, 16999, 17348);
            List<Permission> all = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(permissions, Map.class, 601, 17285, 17295)) {
                permissions = CallChecker.beforeCalled(permissions, Map.class, 601, 17285, 17295);
                all = new ArrayList<Permission>(CallChecker.isCalled(permissions, Map.class, 601, 17285, 17295).values());
                CallChecker.varAssign(all, "all", 601, 17285, 17295);
            }
            return Collections.enumeration(all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<Permission>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context854.methodEnd();
        }
    }

    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", HashMap.class) , new ObjectStreamField("all_allowed", Boolean.TYPE) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context855 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 608, 17554, 17802);
            CallChecker.varInit(out, "out", 608, 17554, 17802);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdaptPermissionCollection.serialPersistentFields", 608, 17554, 17802);
            CallChecker.varInit(this.all_allowed, "all_allowed", 608, 17554, 17802);
            CallChecker.varInit(this.permissions, "permissions", 608, 17554, 17802);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermissionCollection.serialVersionUID", 608, 17554, 17802);
            ObjectOutputStream.PutField pfields = CallChecker.init(ObjectOutputStream.PutField.class);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 609, 17677, 17679)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 609, 17677, 17679);
                pfields = CallChecker.isCalled(out, ObjectOutputStream.class, 609, 17677, 17679).putFields();
                CallChecker.varAssign(pfields, "pfields", 609, 17677, 17679);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 610, 17696, 17702)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 610, 17696, 17702);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 610, 17696, 17702).put("permissions", permissions);
            }
            if (CallChecker.beforeDeref(pfields, ObjectOutputStream.PutField.class, 611, 17739, 17745)) {
                pfields = CallChecker.beforeCalled(pfields, ObjectOutputStream.PutField.class, 611, 17739, 17745);
                CallChecker.isCalled(pfields, ObjectOutputStream.PutField.class, 611, 17739, 17745).put("all_allowed", all_allowed);
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 612, 17782, 17784)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 612, 17782, 17784);
                CallChecker.isCalled(out, ObjectOutputStream.class, 612, 17782, 17784).writeFields();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context855.methodEnd();
        }
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context856 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 615, 17806, 18186);
            CallChecker.varInit(in, "in", 615, 17806, 18186);
            CallChecker.varInit(serialPersistentFields, "org.osgi.framework.AdaptPermissionCollection.serialPersistentFields", 615, 17806, 18186);
            CallChecker.varInit(this.all_allowed, "all_allowed", 615, 17806, 18186);
            CallChecker.varInit(this.permissions, "permissions", 615, 17806, 18186);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.AdaptPermissionCollection.serialVersionUID", 615, 17806, 18186);
            ObjectInputStream.GetField gfields = CallChecker.init(ObjectInputStream.GetField.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 616, 17957, 17958)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 616, 17957, 17958);
                gfields = CallChecker.isCalled(in, ObjectInputStream.class, 616, 17957, 17958).readFields();
                CallChecker.varAssign(gfields, "gfields", 616, 17957, 17958);
            }
            HashMap<String, AdaptPermission> p = CallChecker.init(HashMap.class);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 618, 18081, 18087)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 618, 18081, 18087);
                p = ((HashMap<String, AdaptPermission>) (CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 618, 18081, 18087).get("permissions", null)));
                CallChecker.varAssign(p, "p", 618, 18081, 18087);
            }
            permissions = p;
            CallChecker.varAssign(this.permissions, "this.permissions", 619, 18117, 18132);
            if (CallChecker.beforeDeref(gfields, ObjectInputStream.GetField.class, 620, 18150, 18156)) {
                gfields = CallChecker.beforeCalled(gfields, ObjectInputStream.GetField.class, 620, 18150, 18156);
                all_allowed = CallChecker.isCalled(gfields, ObjectInputStream.GetField.class, 620, 18150, 18156).get("all_allowed", false);
                CallChecker.varAssign(this.all_allowed, "this.all_allowed", 620, 18136, 18183);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context856.methodEnd();
        }
    }
}

