package org.apache.felix.framework;

import org.osgi.resource.dto.WiringDTO;
import org.osgi.resource.Wiring;
import org.osgi.resource.dto.WireDTO;
import org.osgi.resource.Wire;
import org.osgi.framework.launch.Framework;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.dto.DTO;
import org.osgi.framework.Constants;
import org.osgi.resource.dto.CapabilityRefDTO;
import org.osgi.resource.dto.CapabilityDTO;
import org.osgi.resource.Capability;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.dto.BundleWiringDTO;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.framework.wiring.dto.BundleWireDTO;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.dto.BundleDTO;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.dto.BundleRevisionDTO;
import org.osgi.framework.wiring.BundleRevisions;
import org.osgi.framework.startlevel.BundleStartLevel;
import org.osgi.framework.startlevel.dto.BundleStartLevelDTO;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.dto.FrameworkDTO;
import org.osgi.framework.startlevel.FrameworkStartLevel;
import org.osgi.framework.startlevel.dto.FrameworkStartLevelDTO;
import java.util.HashMap;
import java.util.HashSet;
import org.osgi.framework.InvalidSyntaxException;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.resource.Requirement;
import org.osgi.resource.dto.RequirementDTO;
import org.osgi.resource.dto.RequirementRefDTO;
import org.osgi.resource.Resource;
import org.osgi.resource.dto.ResourceDTO;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.dto.ServiceReferenceDTO;
import java.util.Set;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.osgi.framework.Version;

public class DTOFactory {
    private DTOFactory() {
        MethodContext _bcornu_methode_context50 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    static <T> T createDTO(Bundle bundle, Class<T> type) {
        if (CallChecker.beforeDeref(bundle, Bundle.class, 74, 2747, 2752)) {
            bundle = CallChecker.beforeCalled(bundle, Bundle.class, 74, 2747, 2752);
            if ((Bundle.UNINSTALLED) == (CallChecker.isCalled(bundle, Bundle.class, 74, 2747, 2752).getState()))
                return null;
            
        }else
            throw new AbnormalExecutionError();
        
        if (type == (BundleDTO.class)) {
            if (CallChecker.beforeDeref(type, Class.class, 79, 2858, 2861)) {
                return type.cast(DTOFactory.createBundleDTO(bundle));
            }else
                throw new AbnormalExecutionError();
            
        }else
            if (type == (BundleStartLevelDTO.class)) {
                if (CallChecker.beforeDeref(type, Class.class, 83, 2985, 2988)) {
                    return type.cast(DTOFactory.createBundleStartLevelDTO(bundle));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (type == (BundleRevisionDTO.class)) {
                    if (CallChecker.beforeDeref(type, Class.class, 87, 3120, 3123)) {
                        return type.cast(DTOFactory.createBundleRevisionDTO(bundle));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (type == (BundleRevisionDTO[].class)) {
                        if (CallChecker.beforeDeref(type, Class.class, 91, 3255, 3258)) {
                            return type.cast(DTOFactory.createBundleRevisionDTOArray(bundle));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (type == (BundleWiringDTO.class)) {
                            if (CallChecker.beforeDeref(type, Class.class, 95, 3391, 3394)) {
                                return type.cast(DTOFactory.createBundleWiringDTO(bundle));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            if (type == (BundleWiringDTO[].class)) {
                                if (CallChecker.beforeDeref(type, Class.class, 99, 3522, 3525)) {
                                    return type.cast(DTOFactory.createBundleWiringDTOArray(bundle));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                if (type == (ServiceReferenceDTO[].class)) {
                                    if (CallChecker.beforeDeref(type, Class.class, 103, 3662, 3665)) {
                                        return type.cast(DTOFactory.createServiceReferenceDTOArray(bundle));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    if ((type == (FrameworkDTO.class)) && (bundle instanceof Felix)) {
                                        if (CallChecker.beforeDeref(type, Class.class, 107, 3824, 3827)) {
                                            return type.cast(DTOFactory.createFrameworkDTO(((Felix) (bundle))));
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        if ((type == (FrameworkStartLevelDTO.class)) && (bundle instanceof Framework)) {
                                            if (CallChecker.beforeDeref(type, Class.class, 111, 3996, 3999)) {
                                                return type.cast(DTOFactory.createFrameworkStartLevelDTO(((Framework) (bundle))));
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }
                                    
                                
                            
                        
                    
                
            
        
        return null;
    }

    private static BundleDTO createBundleDTO(Bundle bundle) {
        MethodContext _bcornu_methode_context710 = new MethodContext(BundleDTO.class);
        try {
            CallChecker.varInit(bundle, "bundle", 116, 4099, 4458);
            BundleDTO dto = CallChecker.varInit(new BundleDTO(), "dto", 118, 4169, 4200);
            if (CallChecker.beforeDeref(dto, BundleDTO.class, 119, 4210, 4212)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 119, 4219, 4224)) {
                    dto = CallChecker.beforeCalled(dto, BundleDTO.class, 119, 4210, 4212);
                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 119, 4219, 4224);
                    CallChecker.isCalled(dto, BundleDTO.class, 119, 4210, 4212).id = CallChecker.isCalled(bundle, Bundle.class, 119, 4219, 4224).getBundleId();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleDTO.class, 119, 4210, 4212).id, "CallChecker.isCalled(dto, BundleDTO.class, 119, 4210, 4212).id", 119, 4210, 4239);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleDTO.class, 120, 4249, 4251)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 120, 4268, 4273)) {
                    dto = CallChecker.beforeCalled(dto, BundleDTO.class, 120, 4249, 4251);
                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 120, 4268, 4273);
                    CallChecker.isCalled(dto, BundleDTO.class, 120, 4249, 4251).lastModified = CallChecker.isCalled(bundle, Bundle.class, 120, 4268, 4273).getLastModified();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleDTO.class, 120, 4249, 4251).lastModified, "CallChecker.isCalled(dto, BundleDTO.class, 120, 4249, 4251).lastModified", 120, 4249, 4292);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleDTO.class, 121, 4302, 4304)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 121, 4314, 4319)) {
                    dto = CallChecker.beforeCalled(dto, BundleDTO.class, 121, 4302, 4304);
                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 121, 4314, 4319);
                    CallChecker.isCalled(dto, BundleDTO.class, 121, 4302, 4304).state = CallChecker.isCalled(bundle, Bundle.class, 121, 4314, 4319).getState();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleDTO.class, 121, 4302, 4304).state, "CallChecker.isCalled(dto, BundleDTO.class, 121, 4302, 4304).state", 121, 4302, 4331);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleDTO.class, 122, 4341, 4343)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 122, 4360, 4365)) {
                    dto = CallChecker.beforeCalled(dto, BundleDTO.class, 122, 4341, 4343);
                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 122, 4360, 4365);
                    CallChecker.isCalled(dto, BundleDTO.class, 122, 4341, 4343).symbolicName = CallChecker.isCalled(bundle, Bundle.class, 122, 4360, 4365).getSymbolicName();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleDTO.class, 122, 4341, 4343).symbolicName, "CallChecker.isCalled(dto, BundleDTO.class, 122, 4341, 4343).symbolicName", 122, 4341, 4384);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleDTO.class, 123, 4394, 4396)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 123, 4413, 4418)) {
                    dto = CallChecker.beforeCalled(dto, BundleDTO.class, 123, 4394, 4396);
                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 123, 4413, 4418);
                    CallChecker.isCalled(dto, BundleDTO.class, 123, 4394, 4396).version = "" + (CallChecker.isCalled(bundle, Bundle.class, 123, 4413, 4418).getVersion());
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleDTO.class, 123, 4394, 4396).version, "CallChecker.isCalled(dto, BundleDTO.class, 123, 4394, 4396).version", 123, 4394, 4432);
                }
            }
            return dto;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context710.methodEnd();
        }
    }

    private static BundleRevisionDTO createBundleRevisionDTO(Bundle bundle) {
        MethodContext _bcornu_methode_context711 = new MethodContext(BundleRevisionDTO.class);
        try {
            CallChecker.varInit(bundle, "bundle", 127, 4465, 4793);
            BundleRevision br = CallChecker.init(BundleRevision.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 129, 4571, 4576)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 129, 4571, 4576);
                br = CallChecker.isCalled(bundle, Bundle.class, 129, 4571, 4576).adapt(BundleRevision.class);
                CallChecker.varAssign(br, "br", 129, 4571, 4576);
            }
            if (!(br instanceof BundleRevisionImpl))
                return null;
            
            return DTOFactory.createBundleRevisionDTO(bundle, ((BundleRevisionImpl) (br)), new HashSet<BundleRevisionDTO>());
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevisionDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context711.methodEnd();
        }
    }

    private static BundleRevisionDTO[] createBundleRevisionDTOArray(Bundle bundle) {
        MethodContext _bcornu_methode_context712 = new MethodContext(BundleRevisionDTO[].class);
        try {
            CallChecker.varInit(bundle, "bundle", 136, 4800, 5460);
            BundleRevisions brs = CallChecker.init(BundleRevisions.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 138, 4915, 4920)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 138, 4915, 4920);
                brs = CallChecker.isCalled(bundle, Bundle.class, 138, 4915, 4920).adapt(BundleRevisions.class);
                CallChecker.varAssign(brs, "brs", 138, 4915, 4920);
            }
            if ((brs == null) || ((brs.getRevisions()) == null))
                return null;
            
            List<BundleRevision> revisions = CallChecker.varInit(brs.getRevisions(), "revisions", 142, 5041, 5092);
            BundleRevisionDTO[] dtos = CallChecker.init(BundleRevisionDTO[].class);
            if (CallChecker.beforeDeref(revisions, List.class, 143, 5151, 5159)) {
                revisions = CallChecker.beforeCalled(revisions, List.class, 143, 5151, 5159);
                dtos = new BundleRevisionDTO[CallChecker.isCalled(revisions, List.class, 143, 5151, 5159).size()];
                CallChecker.varAssign(dtos, "dtos", 143, 5151, 5159);
            }
            revisions = CallChecker.beforeCalled(revisions, List.class, 144, 5196, 5204);
            for (int i = 0; i < (CallChecker.isCalled(revisions, List.class, 144, 5196, 5204).size()); i++) {
                if (CallChecker.beforeDeref(revisions, List.class, 146, 5245, 5253)) {
                    revisions = CallChecker.beforeCalled(revisions, List.class, 146, 5245, 5253);
                    if ((CallChecker.isCalled(revisions, List.class, 146, 5245, 5253).get(i)) instanceof BundleRevisionImpl)
                        if (CallChecker.beforeDeref(dtos, BundleRevisionDTO[].class, 147, 5309, 5312)) {
                            if (CallChecker.beforeDeref(revisions, List.class, 147, 5372, 5380)) {
                                dtos = CallChecker.beforeCalled(dtos, BundleRevisionDTO[].class, 147, 5309, 5312);
                                revisions = CallChecker.beforeCalled(revisions, List.class, 147, 5372, 5380);
                                CallChecker.isCalled(dtos, BundleRevisionDTO[].class, 147, 5309, 5312)[i] = DTOFactory.createBundleRevisionDTO(bundle, ((BundleRevisionImpl) (CallChecker.isCalled(revisions, List.class, 147, 5372, 5380).get(i))), new HashSet<BundleRevisionDTO>());
                                CallChecker.varAssign(CallChecker.isCalled(dtos, BundleRevisionDTO[].class, 147, 5309, 5312)[i], "CallChecker.isCalled(dtos, BundleRevisionDTO[].class, 147, 5309, 5312)[i]", 147, 5309, 5423);
                            }
                        }
                    
                }
            }
            return dtos;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevisionDTO[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context712.methodEnd();
        }
    }

    private static BundleRevisionDTO createBundleRevisionDTO(BundleRevision revision, Set<BundleRevisionDTO> resources) {
        MethodContext _bcornu_methode_context713 = new MethodContext(BundleRevisionDTO.class);
        try {
            CallChecker.varInit(resources, "resources", 152, 5467, 5791);
            CallChecker.varInit(revision, "revision", 152, 5467, 5791);
            if (revision instanceof BundleRevisionImpl)
                if (CallChecker.beforeDeref(revision, BundleRevision.class, 155, 5684, 5691)) {
                    revision = CallChecker.beforeCalled(revision, BundleRevision.class, 155, 5684, 5691);
                    return DTOFactory.createBundleRevisionDTO(CallChecker.isCalled(revision, BundleRevision.class, 155, 5684, 5691).getBundle(), ((BundleRevisionImpl) (revision)), resources);
                }else
                    throw new AbnormalExecutionError();
                
            else
                return null;
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevisionDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context713.methodEnd();
        }
    }

    private static BundleRevisionDTO createBundleRevisionDTO(Bundle bundle, BundleRevisionImpl revision, Set<BundleRevisionDTO> resources) {
        MethodContext _bcornu_methode_context714 = new MethodContext(BundleRevisionDTO.class);
        try {
            CallChecker.varInit(resources, "resources", 160, 5798, 7426);
            CallChecker.varInit(revision, "revision", 160, 5798, 7426);
            CallChecker.varInit(bundle, "bundle", 160, 5798, 7426);
            BundleRevisionDTO dto = CallChecker.varInit(new BundleRevisionDTO(), "dto", 162, 5947, 5994);
            if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 163, 6004, 6006)) {
                dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 163, 6004, 6006);
                CallChecker.isCalled(dto, BundleRevisionDTO.class, 163, 6004, 6006).id = DTOFactory.getRevisionID(revision);
                CallChecker.varAssign(CallChecker.isCalled(dto, BundleRevisionDTO.class, 163, 6004, 6006).id, "CallChecker.isCalled(dto, BundleRevisionDTO.class, 163, 6004, 6006).id", 163, 6004, 6036);
            }
            DTOFactory.addBundleRevisionDTO(dto, resources);
            if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 166, 6093, 6095)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 166, 6106, 6111)) {
                    dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 166, 6093, 6095);
                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 166, 6106, 6111);
                    CallChecker.isCalled(dto, BundleRevisionDTO.class, 166, 6093, 6095).bundle = CallChecker.isCalled(bundle, Bundle.class, 166, 6106, 6111).getBundleId();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleRevisionDTO.class, 166, 6093, 6095).bundle, "CallChecker.isCalled(dto, BundleRevisionDTO.class, 166, 6093, 6095).bundle", 166, 6093, 6126);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 167, 6136, 6138)) {
                if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 167, 6155, 6162)) {
                    dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 167, 6136, 6138);
                    revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 167, 6155, 6162);
                    CallChecker.isCalled(dto, BundleRevisionDTO.class, 167, 6136, 6138).symbolicName = CallChecker.isCalled(revision, BundleRevisionImpl.class, 167, 6155, 6162).getSymbolicName();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleRevisionDTO.class, 167, 6136, 6138).symbolicName, "CallChecker.isCalled(dto, BundleRevisionDTO.class, 167, 6136, 6138).symbolicName", 167, 6136, 6181);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 168, 6191, 6193)) {
                if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 168, 6202, 6209)) {
                    dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 168, 6191, 6193);
                    revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 168, 6202, 6209);
                    CallChecker.isCalled(dto, BundleRevisionDTO.class, 168, 6191, 6193).type = CallChecker.isCalled(revision, BundleRevisionImpl.class, 168, 6202, 6209).getTypes();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleRevisionDTO.class, 168, 6191, 6193).type, "CallChecker.isCalled(dto, BundleRevisionDTO.class, 168, 6191, 6193).type", 168, 6191, 6221);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 169, 6231, 6233)) {
                if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 169, 6245, 6252)) {
                    revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 169, 6245, 6252);
                    final Version npe_invocation_var228 = CallChecker.isCalled(revision, BundleRevisionImpl.class, 169, 6245, 6252).getVersion();
                    if (CallChecker.beforeDeref(npe_invocation_var228, Version.class, 169, 6245, 6265)) {
                        dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 169, 6231, 6233);
                        CallChecker.isCalled(dto, BundleRevisionDTO.class, 169, 6231, 6233).version = CallChecker.isCalled(npe_invocation_var228, Version.class, 169, 6245, 6265).toString();
                        CallChecker.varAssign(CallChecker.isCalled(dto, BundleRevisionDTO.class, 169, 6231, 6233).version, "CallChecker.isCalled(dto, BundleRevisionDTO.class, 169, 6231, 6233).version", 169, 6231, 6277);
                    }
                }
            }
            if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 171, 6288, 6290)) {
                dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 171, 6288, 6290);
                CallChecker.isCalled(dto, BundleRevisionDTO.class, 171, 6288, 6290).capabilities = new ArrayList<CapabilityDTO>();
                CallChecker.varAssign(CallChecker.isCalled(dto, BundleRevisionDTO.class, 171, 6288, 6290).capabilities, "CallChecker.isCalled(dto, BundleRevisionDTO.class, 171, 6288, 6290).capabilities", 171, 6288, 6337);
            }
            revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 172, 6369, 6376);
            for (Capability cap : CallChecker.isCalled(revision, BundleRevisionImpl.class, 172, 6369, 6376).getCapabilities(null)) {
                CapabilityDTO cdto = CallChecker.varInit(new CapabilityDTO(), "cdto", 174, 6423, 6463);
                if (CallChecker.beforeDeref(cdto, CapabilityDTO.class, 175, 6477, 6480)) {
                    cdto = CallChecker.beforeCalled(cdto, CapabilityDTO.class, 175, 6477, 6480);
                    CallChecker.isCalled(cdto, CapabilityDTO.class, 175, 6477, 6480).id = DTOFactory.getCapabilityID(cap);
                    CallChecker.varAssign(CallChecker.isCalled(cdto, CapabilityDTO.class, 175, 6477, 6480).id, "CallChecker.isCalled(cdto, CapabilityDTO.class, 175, 6477, 6480).id", 175, 6477, 6507);
                }
                if (CallChecker.beforeDeref(cdto, CapabilityDTO.class, 176, 6521, 6524)) {
                    if (CallChecker.beforeDeref(cap, Capability.class, 176, 6538, 6540)) {
                        cdto = CallChecker.beforeCalled(cdto, CapabilityDTO.class, 176, 6521, 6524);
                        CallChecker.isCalled(cdto, CapabilityDTO.class, 176, 6521, 6524).namespace = CallChecker.isCalled(cap, Capability.class, 176, 6538, 6540).getNamespace();
                        CallChecker.varAssign(CallChecker.isCalled(cdto, CapabilityDTO.class, 176, 6521, 6524).namespace, "CallChecker.isCalled(cdto, CapabilityDTO.class, 176, 6521, 6524).namespace", 176, 6521, 6556);
                    }
                }
                if (CallChecker.beforeDeref(cdto, CapabilityDTO.class, 177, 6570, 6573)) {
                    if (CallChecker.beforeDeref(cap, Capability.class, 177, 6606, 6608)) {
                        cdto = CallChecker.beforeCalled(cdto, CapabilityDTO.class, 177, 6570, 6573);
                        CallChecker.isCalled(cdto, CapabilityDTO.class, 177, 6570, 6573).attributes = DTOFactory.convertAttrsToDTO(CallChecker.isCalled(cap, Capability.class, 177, 6606, 6608).getAttributes());
                        CallChecker.varAssign(CallChecker.isCalled(cdto, CapabilityDTO.class, 177, 6570, 6573).attributes, "CallChecker.isCalled(cdto, CapabilityDTO.class, 177, 6570, 6573).attributes", 177, 6570, 6626);
                    }
                }
                if (CallChecker.beforeDeref(cdto, CapabilityDTO.class, 178, 6640, 6643)) {
                    if (CallChecker.beforeDeref(cap, Capability.class, 178, 6686, 6688)) {
                        cdto = CallChecker.beforeCalled(cdto, CapabilityDTO.class, 178, 6640, 6643);
                        CallChecker.isCalled(cdto, CapabilityDTO.class, 178, 6640, 6643).directives = new HashMap<String, String>(CallChecker.isCalled(cap, Capability.class, 178, 6686, 6688).getDirectives());
                        CallChecker.varAssign(CallChecker.isCalled(cdto, CapabilityDTO.class, 178, 6640, 6643).directives, "CallChecker.isCalled(cdto, CapabilityDTO.class, 178, 6640, 6643).directives", 178, 6640, 6706);
                    }
                }
                if (CallChecker.beforeDeref(cdto, CapabilityDTO.class, 179, 6720, 6723)) {
                    if (CallChecker.beforeDeref(cap, Capability.class, 179, 6756, 6758)) {
                        cdto = CallChecker.beforeCalled(cdto, CapabilityDTO.class, 179, 6720, 6723);
                        CallChecker.isCalled(cdto, CapabilityDTO.class, 179, 6720, 6723).resource = DTOFactory.getResourceIDAndAdd(CallChecker.isCalled(cap, Capability.class, 179, 6756, 6758).getResource(), resources);
                        CallChecker.varAssign(CallChecker.isCalled(cdto, CapabilityDTO.class, 179, 6720, 6723).resource, "CallChecker.isCalled(cdto, CapabilityDTO.class, 179, 6720, 6723).resource", 179, 6720, 6785);
                    }
                }
                if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 181, 6800, 6802)) {
                    dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 181, 6800, 6802);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(dto, BundleRevisionDTO.class, 181, 6800, 6802).capabilities, List.class, 181, 6800, 6815)) {
                        dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 181, 6800, 6802);
                        CallChecker.isCalled(CallChecker.isCalled(dto, BundleRevisionDTO.class, 181, 6800, 6802).capabilities, List.class, 181, 6800, 6815).add(cdto);
                    }
                }
            }
            if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 184, 6847, 6849)) {
                dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 184, 6847, 6849);
                CallChecker.isCalled(dto, BundleRevisionDTO.class, 184, 6847, 6849).requirements = new ArrayList<RequirementDTO>();
                CallChecker.varAssign(CallChecker.isCalled(dto, BundleRevisionDTO.class, 184, 6847, 6849).requirements, "CallChecker.isCalled(dto, BundleRevisionDTO.class, 184, 6847, 6849).requirements", 184, 6847, 6897);
            }
            revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 185, 6930, 6937);
            for (Requirement req : CallChecker.isCalled(revision, BundleRevisionImpl.class, 185, 6930, 6937).getRequirements(null)) {
                RequirementDTO rdto = CallChecker.varInit(new RequirementDTO(), "rdto", 187, 6984, 7026);
                if (CallChecker.beforeDeref(rdto, RequirementDTO.class, 188, 7040, 7043)) {
                    rdto = CallChecker.beforeCalled(rdto, RequirementDTO.class, 188, 7040, 7043);
                    CallChecker.isCalled(rdto, RequirementDTO.class, 188, 7040, 7043).id = DTOFactory.getRequirementID(req);
                    CallChecker.varAssign(CallChecker.isCalled(rdto, RequirementDTO.class, 188, 7040, 7043).id, "CallChecker.isCalled(rdto, RequirementDTO.class, 188, 7040, 7043).id", 188, 7040, 7071);
                }
                if (CallChecker.beforeDeref(rdto, RequirementDTO.class, 189, 7085, 7088)) {
                    if (CallChecker.beforeDeref(req, Requirement.class, 189, 7102, 7104)) {
                        rdto = CallChecker.beforeCalled(rdto, RequirementDTO.class, 189, 7085, 7088);
                        CallChecker.isCalled(rdto, RequirementDTO.class, 189, 7085, 7088).namespace = CallChecker.isCalled(req, Requirement.class, 189, 7102, 7104).getNamespace();
                        CallChecker.varAssign(CallChecker.isCalled(rdto, RequirementDTO.class, 189, 7085, 7088).namespace, "CallChecker.isCalled(rdto, RequirementDTO.class, 189, 7085, 7088).namespace", 189, 7085, 7120);
                    }
                }
                if (CallChecker.beforeDeref(rdto, RequirementDTO.class, 190, 7134, 7137)) {
                    if (CallChecker.beforeDeref(req, Requirement.class, 190, 7170, 7172)) {
                        rdto = CallChecker.beforeCalled(rdto, RequirementDTO.class, 190, 7134, 7137);
                        CallChecker.isCalled(rdto, RequirementDTO.class, 190, 7134, 7137).attributes = DTOFactory.convertAttrsToDTO(CallChecker.isCalled(req, Requirement.class, 190, 7170, 7172).getAttributes());
                        CallChecker.varAssign(CallChecker.isCalled(rdto, RequirementDTO.class, 190, 7134, 7137).attributes, "CallChecker.isCalled(rdto, RequirementDTO.class, 190, 7134, 7137).attributes", 190, 7134, 7190);
                    }
                }
                if (CallChecker.beforeDeref(rdto, RequirementDTO.class, 191, 7204, 7207)) {
                    if (CallChecker.beforeDeref(req, Requirement.class, 191, 7250, 7252)) {
                        rdto = CallChecker.beforeCalled(rdto, RequirementDTO.class, 191, 7204, 7207);
                        CallChecker.isCalled(rdto, RequirementDTO.class, 191, 7204, 7207).directives = new HashMap<String, String>(CallChecker.isCalled(req, Requirement.class, 191, 7250, 7252).getDirectives());
                        CallChecker.varAssign(CallChecker.isCalled(rdto, RequirementDTO.class, 191, 7204, 7207).directives, "CallChecker.isCalled(rdto, RequirementDTO.class, 191, 7204, 7207).directives", 191, 7204, 7270);
                    }
                }
                if (CallChecker.beforeDeref(rdto, RequirementDTO.class, 192, 7284, 7287)) {
                    if (CallChecker.beforeDeref(req, Requirement.class, 192, 7320, 7322)) {
                        rdto = CallChecker.beforeCalled(rdto, RequirementDTO.class, 192, 7284, 7287);
                        CallChecker.isCalled(rdto, RequirementDTO.class, 192, 7284, 7287).resource = DTOFactory.getResourceIDAndAdd(CallChecker.isCalled(req, Requirement.class, 192, 7320, 7322).getResource(), resources);
                        CallChecker.varAssign(CallChecker.isCalled(rdto, RequirementDTO.class, 192, 7284, 7287).resource, "CallChecker.isCalled(rdto, RequirementDTO.class, 192, 7284, 7287).resource", 192, 7284, 7349);
                    }
                }
                if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 194, 7364, 7366)) {
                    dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 194, 7364, 7366);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(dto, BundleRevisionDTO.class, 194, 7364, 7366).requirements, List.class, 194, 7364, 7379)) {
                        dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 194, 7364, 7366);
                        CallChecker.isCalled(CallChecker.isCalled(dto, BundleRevisionDTO.class, 194, 7364, 7366).requirements, List.class, 194, 7364, 7379).add(rdto);
                    }
                }
            }
            return dto;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevisionDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context714.methodEnd();
        }
    }

    private static BundleWiringDTO createBundleWiringDTO(Bundle bundle) {
        MethodContext _bcornu_methode_context715 = new MethodContext(BundleWiringDTO.class);
        try {
            CallChecker.varInit(bundle, "bundle", 199, 7433, 7613);
            BundleWiring bw = CallChecker.init(BundleWiring.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 201, 7533, 7538)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 201, 7533, 7538);
                bw = CallChecker.isCalled(bundle, Bundle.class, 201, 7533, 7538).adapt(BundleWiring.class);
                CallChecker.varAssign(bw, "bw", 201, 7533, 7538);
            }
            return DTOFactory.createBundleWiringDTO(bw);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleWiringDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context715.methodEnd();
        }
    }

    private static BundleWiringDTO createBundleWiringDTO(BundleWiring wiring) {
        MethodContext _bcornu_methode_context716 = new MethodContext(BundleWiringDTO.class);
        try {
            CallChecker.varInit(wiring, "wiring", 205, 7620, 8131);
            BundleWiringDTO dto = CallChecker.varInit(new BundleWiringDTO(), "dto", 207, 7708, 7751);
            if (CallChecker.beforeDeref(dto, BundleWiringDTO.class, 208, 7761, 7763)) {
                if (CallChecker.beforeDeref(wiring, BundleWiring.class, 208, 7774, 7779)) {
                    wiring = CallChecker.beforeCalled(wiring, BundleWiring.class, 208, 7774, 7779);
                    final Bundle npe_invocation_var229 = CallChecker.isCalled(wiring, BundleWiring.class, 208, 7774, 7779).getBundle();
                    if (CallChecker.beforeDeref(npe_invocation_var229, Bundle.class, 208, 7774, 7791)) {
                        dto = CallChecker.beforeCalled(dto, BundleWiringDTO.class, 208, 7761, 7763);
                        CallChecker.isCalled(dto, BundleWiringDTO.class, 208, 7761, 7763).bundle = CallChecker.isCalled(npe_invocation_var229, Bundle.class, 208, 7774, 7791).getBundleId();
                        CallChecker.varAssign(CallChecker.isCalled(dto, BundleWiringDTO.class, 208, 7761, 7763).bundle, "CallChecker.isCalled(dto, BundleWiringDTO.class, 208, 7761, 7763).bundle", 208, 7761, 7806);
                    }
                }
            }
            if (CallChecker.beforeDeref(dto, BundleWiringDTO.class, 209, 7816, 7818)) {
                dto = CallChecker.beforeCalled(dto, BundleWiringDTO.class, 209, 7816, 7818);
                CallChecker.isCalled(dto, BundleWiringDTO.class, 209, 7816, 7818).root = DTOFactory.getWiringID(wiring);
                CallChecker.varAssign(CallChecker.isCalled(dto, BundleWiringDTO.class, 209, 7816, 7818).root, "CallChecker.isCalled(dto, BundleWiringDTO.class, 209, 7816, 7818).root", 209, 7816, 7846);
            }
            if (CallChecker.beforeDeref(dto, BundleWiringDTO.class, 210, 7856, 7858)) {
                dto = CallChecker.beforeCalled(dto, BundleWiringDTO.class, 210, 7856, 7858);
                CallChecker.isCalled(dto, BundleWiringDTO.class, 210, 7856, 7858).nodes = new HashSet<BundleWiringDTO.NodeDTO>();
                CallChecker.varAssign(CallChecker.isCalled(dto, BundleWiringDTO.class, 210, 7856, 7858).nodes, "CallChecker.isCalled(dto, BundleWiringDTO.class, 210, 7856, 7858).nodes", 210, 7856, 7906);
            }
            if (CallChecker.beforeDeref(dto, BundleWiringDTO.class, 211, 7916, 7918)) {
                dto = CallChecker.beforeCalled(dto, BundleWiringDTO.class, 211, 7916, 7918);
                CallChecker.isCalled(dto, BundleWiringDTO.class, 211, 7916, 7918).resources = new HashSet<BundleRevisionDTO>();
                CallChecker.varAssign(CallChecker.isCalled(dto, BundleWiringDTO.class, 211, 7916, 7918).resources, "CallChecker.isCalled(dto, BundleWiringDTO.class, 211, 7916, 7918).resources", 211, 7916, 7964);
            }
            if (CallChecker.beforeDeref(wiring, BundleWiring.class, 213, 7999, 8004)) {
                if (CallChecker.beforeDeref(dto, BundleWiringDTO.class, 213, 8021, 8023)) {
                    wiring = CallChecker.beforeCalled(wiring, BundleWiring.class, 213, 7999, 8004);
                    dto = CallChecker.beforeCalled(dto, BundleWiringDTO.class, 213, 8021, 8023);
                    DTOFactory.createBundleRevisionDTO(CallChecker.isCalled(wiring, BundleWiring.class, 213, 7999, 8004).getRevision(), CallChecker.isCalled(dto, BundleWiringDTO.class, 213, 8021, 8023).resources);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleWiringDTO.class, 214, 8079, 8081)) {
                if (CallChecker.beforeDeref(dto, BundleWiringDTO.class, 214, 8094, 8096)) {
                    dto = CallChecker.beforeCalled(dto, BundleWiringDTO.class, 214, 8079, 8081);
                    dto = CallChecker.beforeCalled(dto, BundleWiringDTO.class, 214, 8094, 8096);
                    DTOFactory.createBundleWiringNodeDTO(wiring, CallChecker.isCalled(dto, BundleWiringDTO.class, 214, 8079, 8081).resources, CallChecker.isCalled(dto, BundleWiringDTO.class, 214, 8094, 8096).nodes);
                }
            }
            return dto;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleWiringDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context716.methodEnd();
        }
    }

    private static BundleWiringDTO[] createBundleWiringDTOArray(Bundle bundle) {
        MethodContext _bcornu_methode_context717 = new MethodContext(BundleWiringDTO[].class);
        try {
            CallChecker.varInit(bundle, "bundle", 219, 8138, 8711);
            BundleRevisions brs = CallChecker.init(BundleRevisions.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 221, 8249, 8254)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 221, 8249, 8254);
                brs = CallChecker.isCalled(bundle, Bundle.class, 221, 8249, 8254).adapt(BundleRevisions.class);
                CallChecker.varAssign(brs, "brs", 221, 8249, 8254);
            }
            if ((brs == null) || ((brs.getRevisions()) == null))
                return null;
            
            List<BundleRevision> revisions = CallChecker.varInit(brs.getRevisions(), "revisions", 225, 8375, 8426);
            BundleWiringDTO[] dtos = CallChecker.init(BundleWiringDTO[].class);
            if (CallChecker.beforeDeref(revisions, List.class, 226, 8481, 8489)) {
                revisions = CallChecker.beforeCalled(revisions, List.class, 226, 8481, 8489);
                dtos = new BundleWiringDTO[CallChecker.isCalled(revisions, List.class, 226, 8481, 8489).size()];
                CallChecker.varAssign(dtos, "dtos", 226, 8481, 8489);
            }
            revisions = CallChecker.beforeCalled(revisions, List.class, 227, 8526, 8534);
            for (int i = 0; i < (CallChecker.isCalled(revisions, List.class, 227, 8526, 8534).size()); i++) {
                BundleWiring wiring = CallChecker.init(BundleWiring.class);
                if (CallChecker.beforeDeref(revisions, List.class, 229, 8593, 8601)) {
                    revisions = CallChecker.beforeCalled(revisions, List.class, 229, 8593, 8601);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(revisions, List.class, 229, 8593, 8601).get(i), BundleRevision.class, 229, 8593, 8608)) {
                        revisions = CallChecker.beforeCalled(revisions, List.class, 229, 8593, 8601);
                        wiring = CallChecker.isCalled(CallChecker.isCalled(revisions, List.class, 229, 8593, 8601).get(i), BundleRevision.class, 229, 8593, 8608).getWiring();
                        CallChecker.varAssign(wiring, "wiring", 229, 8593, 8601);
                    }
                }
                if (CallChecker.beforeDeref(dtos, BundleWiringDTO[].class, 230, 8635, 8638)) {
                    dtos = CallChecker.beforeCalled(dtos, BundleWiringDTO[].class, 230, 8635, 8638);
                    CallChecker.isCalled(dtos, BundleWiringDTO[].class, 230, 8635, 8638)[i] = DTOFactory.createBundleWiringDTO(wiring);
                    CallChecker.varAssign(CallChecker.isCalled(dtos, BundleWiringDTO[].class, 230, 8635, 8638)[i], "CallChecker.isCalled(dtos, BundleWiringDTO[].class, 230, 8635, 8638)[i]", 230, 8635, 8674);
                }
            }
            return dtos;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleWiringDTO[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context717.methodEnd();
        }
    }

    private static void createBundleWiringNodeDTO(BundleWiring bw, Set<BundleRevisionDTO> resources, Set<BundleWiringDTO.NodeDTO> nodes) {
        MethodContext _bcornu_methode_context718 = new MethodContext(void.class);
        try {
            CallChecker.varInit(nodes, "nodes", 235, 8718, 10268);
            CallChecker.varInit(resources, "resources", 235, 8718, 10268);
            CallChecker.varInit(bw, "bw", 235, 8718, 10268);
            BundleWiringDTO.NodeDTO node = CallChecker.varInit(new BundleWiringDTO.NodeDTO(), "node", 237, 8849, 8893);
            if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 238, 8903, 8906)) {
                node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 238, 8903, 8906);
                CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 238, 8903, 8906).id = DTOFactory.getWiringID(bw);
                CallChecker.varAssign(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 238, 8903, 8906).id, "CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 238, 8903, 8906).id", 238, 8903, 8928);
            }
            if (CallChecker.beforeDeref(nodes, Set.class, 239, 8938, 8942)) {
                nodes = CallChecker.beforeCalled(nodes, Set.class, 239, 8938, 8942);
                CallChecker.isCalled(nodes, Set.class, 239, 8938, 8942).add(node);
            }
            if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 241, 8964, 8967)) {
                if (CallChecker.beforeDeref(bw, BundleWiring.class, 241, 8979, 8980)) {
                    node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 241, 8964, 8967);
                    bw = CallChecker.beforeCalled(bw, BundleWiring.class, 241, 8979, 8980);
                    CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 241, 8964, 8967).current = CallChecker.isCalled(bw, BundleWiring.class, 241, 8979, 8980).isCurrent();
                    CallChecker.varAssign(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 241, 8964, 8967).current, "CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 241, 8964, 8967).current", 241, 8964, 8993);
                }
            }
            if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 242, 9003, 9006)) {
                if (CallChecker.beforeDeref(bw, BundleWiring.class, 242, 9016, 9017)) {
                    node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 242, 9003, 9006);
                    bw = CallChecker.beforeCalled(bw, BundleWiring.class, 242, 9016, 9017);
                    CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 242, 9003, 9006).inUse = CallChecker.isCalled(bw, BundleWiring.class, 242, 9016, 9017).isInUse();
                    CallChecker.varAssign(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 242, 9003, 9006).inUse, "CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 242, 9003, 9006).inUse", 242, 9003, 9028);
                }
            }
            if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 243, 9038, 9041)) {
                if (CallChecker.beforeDeref(bw, BundleWiring.class, 243, 9074, 9075)) {
                    node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 243, 9038, 9041);
                    bw = CallChecker.beforeCalled(bw, BundleWiring.class, 243, 9074, 9075);
                    CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 243, 9038, 9041).resource = DTOFactory.getResourceIDAndAdd(CallChecker.isCalled(bw, BundleWiring.class, 243, 9074, 9075).getResource(), resources);
                    CallChecker.varAssign(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 243, 9038, 9041).resource, "CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 243, 9038, 9041).resource", 243, 9038, 9102);
                }
            }
            if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 245, 9113, 9116)) {
                node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 245, 9113, 9116);
                CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 245, 9113, 9116).capabilities = new ArrayList<CapabilityRefDTO>();
                CallChecker.varAssign(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 245, 9113, 9116).capabilities, "CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 245, 9113, 9116).capabilities", 245, 9113, 9166);
            }
            bw = CallChecker.beforeCalled(bw, BundleWiring.class, 246, 9198, 9199);
            for (Capability cap : CallChecker.isCalled(bw, BundleWiring.class, 246, 9198, 9199).getCapabilities(null)) {
                CapabilityRefDTO cdto = CallChecker.varInit(new CapabilityRefDTO(), "cdto", 248, 9246, 9292);
                if (CallChecker.beforeDeref(cdto, CapabilityRefDTO.class, 249, 9306, 9309)) {
                    cdto = CallChecker.beforeCalled(cdto, CapabilityRefDTO.class, 249, 9306, 9309);
                    CallChecker.isCalled(cdto, CapabilityRefDTO.class, 249, 9306, 9309).capability = DTOFactory.getCapabilityID(cap);
                    CallChecker.varAssign(CallChecker.isCalled(cdto, CapabilityRefDTO.class, 249, 9306, 9309).capability, "CallChecker.isCalled(cdto, CapabilityRefDTO.class, 249, 9306, 9309).capability", 249, 9306, 9344);
                }
                if (CallChecker.beforeDeref(cdto, CapabilityRefDTO.class, 250, 9358, 9361)) {
                    if (CallChecker.beforeDeref(cap, Capability.class, 250, 9394, 9396)) {
                        cdto = CallChecker.beforeCalled(cdto, CapabilityRefDTO.class, 250, 9358, 9361);
                        CallChecker.isCalled(cdto, CapabilityRefDTO.class, 250, 9358, 9361).resource = DTOFactory.getResourceIDAndAdd(CallChecker.isCalled(cap, Capability.class, 250, 9394, 9396).getResource(), resources);
                        CallChecker.varAssign(CallChecker.isCalled(cdto, CapabilityRefDTO.class, 250, 9358, 9361).resource, "CallChecker.isCalled(cdto, CapabilityRefDTO.class, 250, 9358, 9361).resource", 250, 9358, 9423);
                    }
                }
                if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 251, 9437, 9440)) {
                    node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 251, 9437, 9440);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 251, 9437, 9440).capabilities, List.class, 251, 9437, 9453)) {
                        node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 251, 9437, 9440);
                        CallChecker.isCalled(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 251, 9437, 9440).capabilities, List.class, 251, 9437, 9453).add(cdto);
                    }
                }
            }
            if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 254, 9485, 9488)) {
                node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 254, 9485, 9488);
                CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 254, 9485, 9488).requirements = new ArrayList<RequirementRefDTO>();
                CallChecker.varAssign(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 254, 9485, 9488).requirements, "CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 254, 9485, 9488).requirements", 254, 9485, 9539);
            }
            bw = CallChecker.beforeCalled(bw, BundleWiring.class, 255, 9572, 9573);
            for (Requirement req : CallChecker.isCalled(bw, BundleWiring.class, 255, 9572, 9573).getRequirements(null)) {
                RequirementRefDTO rdto = CallChecker.varInit(new RequirementRefDTO(), "rdto", 257, 9620, 9668);
                if (CallChecker.beforeDeref(rdto, RequirementRefDTO.class, 258, 9682, 9685)) {
                    rdto = CallChecker.beforeCalled(rdto, RequirementRefDTO.class, 258, 9682, 9685);
                    CallChecker.isCalled(rdto, RequirementRefDTO.class, 258, 9682, 9685).requirement = DTOFactory.getRequirementID(req);
                    CallChecker.varAssign(CallChecker.isCalled(rdto, RequirementRefDTO.class, 258, 9682, 9685).requirement, "CallChecker.isCalled(rdto, RequirementRefDTO.class, 258, 9682, 9685).requirement", 258, 9682, 9722);
                }
                if (CallChecker.beforeDeref(rdto, RequirementRefDTO.class, 259, 9736, 9739)) {
                    if (CallChecker.beforeDeref(req, Requirement.class, 259, 9772, 9774)) {
                        rdto = CallChecker.beforeCalled(rdto, RequirementRefDTO.class, 259, 9736, 9739);
                        CallChecker.isCalled(rdto, RequirementRefDTO.class, 259, 9736, 9739).resource = DTOFactory.getResourceIDAndAdd(CallChecker.isCalled(req, Requirement.class, 259, 9772, 9774).getResource(), resources);
                        CallChecker.varAssign(CallChecker.isCalled(rdto, RequirementRefDTO.class, 259, 9736, 9739).resource, "CallChecker.isCalled(rdto, RequirementRefDTO.class, 259, 9736, 9739).resource", 259, 9736, 9801);
                    }
                }
                if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 260, 9815, 9818)) {
                    node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 260, 9815, 9818);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 260, 9815, 9818).requirements, List.class, 260, 9815, 9831)) {
                        node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 260, 9815, 9818);
                        CallChecker.isCalled(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 260, 9815, 9818).requirements, List.class, 260, 9815, 9831).add(rdto);
                    }
                }
            }
            if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 263, 9863, 9866)) {
                node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 263, 9863, 9866);
                CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 263, 9863, 9866).providedWires = new ArrayList<WireDTO>();
                CallChecker.varAssign(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 263, 9863, 9866).providedWires, "CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 263, 9863, 9866).providedWires", 263, 9863, 9908);
            }
            bw = CallChecker.beforeCalled(bw, BundleWiring.class, 264, 9933, 9934);
            for (Wire pw : CallChecker.isCalled(bw, BundleWiring.class, 264, 9933, 9934).getProvidedWires(null)) {
                if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 266, 9982, 9985)) {
                    node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 266, 9982, 9985);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 266, 9982, 9985).providedWires, List.class, 266, 9982, 9999)) {
                        node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 266, 9982, 9985);
                        CallChecker.isCalled(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 266, 9982, 9985).providedWires, List.class, 266, 9982, 9999).add(DTOFactory.createBundleWireDTO(pw, resources, nodes));
                    }
                }
            }
            if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 269, 10068, 10071)) {
                node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 269, 10068, 10071);
                CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 269, 10068, 10071).requiredWires = new ArrayList<WireDTO>();
                CallChecker.varAssign(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 269, 10068, 10071).requiredWires, "CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 269, 10068, 10071).requiredWires", 269, 10068, 10113);
            }
            bw = CallChecker.beforeCalled(bw, BundleWiring.class, 270, 10138, 10139);
            for (Wire rw : CallChecker.isCalled(bw, BundleWiring.class, 270, 10138, 10139).getRequiredWires(null)) {
                if (CallChecker.beforeDeref(node, BundleWiringDTO.NodeDTO.class, 272, 10187, 10190)) {
                    node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 272, 10187, 10190);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 272, 10187, 10190).requiredWires, List.class, 272, 10187, 10204)) {
                        node = CallChecker.beforeCalled(node, BundleWiringDTO.NodeDTO.class, 272, 10187, 10190);
                        CallChecker.isCalled(CallChecker.isCalled(node, BundleWiringDTO.NodeDTO.class, 272, 10187, 10190).requiredWires, List.class, 272, 10187, 10204).add(DTOFactory.createBundleWireDTO(rw, resources, nodes));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context718.methodEnd();
        }
    }

    private static BundleWireDTO createBundleWireDTO(Wire wire, Set<BundleRevisionDTO> resources, Set<BundleWiringDTO.NodeDTO> nodes) {
        MethodContext _bcornu_methode_context719 = new MethodContext(BundleWireDTO.class);
        try {
            CallChecker.varInit(nodes, "nodes", 276, 10275, 11526);
            CallChecker.varInit(resources, "resources", 276, 10275, 11526);
            CallChecker.varInit(wire, "wire", 276, 10275, 11526);
            BundleWireDTO wdto = CallChecker.varInit(new BundleWireDTO(), "wdto", 278, 10403, 10443);
            if (wire instanceof BundleWire) {
                BundleWire w = CallChecker.varInit(((BundleWire) (wire)), "w", 281, 10507, 10539);
                BundleWiring pw = CallChecker.init(BundleWiring.class);
                if (CallChecker.beforeDeref(w, BundleWire.class, 283, 10572, 10572)) {
                    w = CallChecker.beforeCalled(w, BundleWire.class, 283, 10572, 10572);
                    pw = CallChecker.isCalled(w, BundleWire.class, 283, 10572, 10572).getProviderWiring();
                    CallChecker.varAssign(pw, "pw", 283, 10572, 10572);
                }
                DTOFactory.addWiringNodeIfNotPresent(pw, resources, nodes);
                if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 285, 10668, 10671)) {
                    wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 285, 10668, 10671);
                    CallChecker.isCalled(wdto, BundleWireDTO.class, 285, 10668, 10671).providerWiring = DTOFactory.getWiringID(pw);
                    CallChecker.varAssign(CallChecker.isCalled(wdto, BundleWireDTO.class, 285, 10668, 10671).providerWiring, "CallChecker.isCalled(wdto, BundleWireDTO.class, 285, 10668, 10671).providerWiring", 285, 10668, 10705);
                }
                BundleWiring rw = CallChecker.init(BundleWiring.class);
                if (CallChecker.beforeDeref(w, BundleWire.class, 287, 10738, 10738)) {
                    w = CallChecker.beforeCalled(w, BundleWire.class, 287, 10738, 10738);
                    rw = CallChecker.isCalled(w, BundleWire.class, 287, 10738, 10738).getRequirerWiring();
                    CallChecker.varAssign(rw, "rw", 287, 10738, 10738);
                }
                DTOFactory.addWiringNodeIfNotPresent(rw, resources, nodes);
                if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 289, 10834, 10837)) {
                    wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 289, 10834, 10837);
                    CallChecker.isCalled(wdto, BundleWireDTO.class, 289, 10834, 10837).requirerWiring = DTOFactory.getWiringID(rw);
                    CallChecker.varAssign(CallChecker.isCalled(wdto, BundleWireDTO.class, 289, 10834, 10837).requirerWiring, "CallChecker.isCalled(wdto, BundleWireDTO.class, 289, 10834, 10837).requirerWiring", 289, 10834, 10871);
                }
            }
            if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 291, 10891, 10894)) {
                if (CallChecker.beforeDeref(wire, Wire.class, 291, 10927, 10930)) {
                    wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 291, 10891, 10894);
                    wire = CallChecker.beforeCalled(wire, Wire.class, 291, 10927, 10930);
                    CallChecker.isCalled(wdto, BundleWireDTO.class, 291, 10891, 10894).provider = DTOFactory.getResourceIDAndAdd(CallChecker.isCalled(wire, Wire.class, 291, 10927, 10930).getProvider(), resources);
                    CallChecker.varAssign(CallChecker.isCalled(wdto, BundleWireDTO.class, 291, 10891, 10894).provider, "CallChecker.isCalled(wdto, BundleWireDTO.class, 291, 10891, 10894).provider", 291, 10891, 10957);
                }
            }
            if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 292, 10967, 10970)) {
                if (CallChecker.beforeDeref(wire, Wire.class, 292, 11003, 11006)) {
                    wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 292, 10967, 10970);
                    wire = CallChecker.beforeCalled(wire, Wire.class, 292, 11003, 11006);
                    CallChecker.isCalled(wdto, BundleWireDTO.class, 292, 10967, 10970).requirer = DTOFactory.getResourceIDAndAdd(CallChecker.isCalled(wire, Wire.class, 292, 11003, 11006).getRequirer(), resources);
                    CallChecker.varAssign(CallChecker.isCalled(wdto, BundleWireDTO.class, 292, 10967, 10970).requirer, "CallChecker.isCalled(wdto, BundleWireDTO.class, 292, 10967, 10970).requirer", 292, 10967, 11033);
                }
            }
            if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 293, 11043, 11046)) {
                wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 293, 11043, 11046);
                CallChecker.isCalled(wdto, BundleWireDTO.class, 293, 11043, 11046).capability = new CapabilityRefDTO();
                CallChecker.varAssign(CallChecker.isCalled(wdto, BundleWireDTO.class, 293, 11043, 11046).capability, "CallChecker.isCalled(wdto, BundleWireDTO.class, 293, 11043, 11046).capability", 293, 11043, 11083);
            }
            if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 294, 11093, 11096)) {
                wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 294, 11093, 11096);
                if (CallChecker.beforeDeref(CallChecker.isCalled(wdto, BundleWireDTO.class, 294, 11093, 11096).capability, CapabilityRefDTO.class, 294, 11093, 11107)) {
                    if (CallChecker.beforeDeref(wire, Wire.class, 294, 11138, 11141)) {
                        wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 294, 11093, 11096);
                        CallChecker.isCalled(wdto, BundleWireDTO.class, 294, 11093, 11096).capability = CallChecker.beforeCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 294, 11093, 11096).capability, CapabilityRefDTO.class, 294, 11093, 11107);
                        wire = CallChecker.beforeCalled(wire, Wire.class, 294, 11138, 11141);
                        CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 294, 11093, 11096).capability, CapabilityRefDTO.class, 294, 11093, 11107).capability = DTOFactory.getCapabilityID(CallChecker.isCalled(wire, Wire.class, 294, 11138, 11141).getCapability());
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 294, 11093, 11096).capability, CapabilityRefDTO.class, 294, 11093, 11107).capability, "CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 294, 11093, 11096).capability, CapabilityRefDTO.class, 294, 11093, 11107).capability", 294, 11093, 11159);
                    }
                }
            }
            if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 295, 11169, 11172)) {
                wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 295, 11169, 11172);
                if (CallChecker.beforeDeref(CallChecker.isCalled(wdto, BundleWireDTO.class, 295, 11169, 11172).capability, CapabilityRefDTO.class, 295, 11169, 11183)) {
                    if (CallChecker.beforeDeref(wire, Wire.class, 295, 11216, 11219)) {
                        wire = CallChecker.beforeCalled(wire, Wire.class, 295, 11216, 11219);
                        final Capability npe_invocation_var230 = CallChecker.isCalled(wire, Wire.class, 295, 11216, 11219).getCapability();
                        if (CallChecker.beforeDeref(npe_invocation_var230, Capability.class, 295, 11216, 11235)) {
                            wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 295, 11169, 11172);
                            CallChecker.isCalled(wdto, BundleWireDTO.class, 295, 11169, 11172).capability = CallChecker.beforeCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 295, 11169, 11172).capability, CapabilityRefDTO.class, 295, 11169, 11183);
                            CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 295, 11169, 11172).capability, CapabilityRefDTO.class, 295, 11169, 11183).resource = DTOFactory.getResourceIDAndAdd(CallChecker.isCalled(npe_invocation_var230, Capability.class, 295, 11216, 11235).getResource(), resources);
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 295, 11169, 11172).capability, CapabilityRefDTO.class, 295, 11169, 11183).resource, "CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 295, 11169, 11172).capability, CapabilityRefDTO.class, 295, 11169, 11183).resource", 295, 11169, 11262);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 296, 11272, 11275)) {
                wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 296, 11272, 11275);
                CallChecker.isCalled(wdto, BundleWireDTO.class, 296, 11272, 11275).requirement = new RequirementRefDTO();
                CallChecker.varAssign(CallChecker.isCalled(wdto, BundleWireDTO.class, 296, 11272, 11275).requirement, "CallChecker.isCalled(wdto, BundleWireDTO.class, 296, 11272, 11275).requirement", 296, 11272, 11314);
            }
            if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 297, 11324, 11327)) {
                wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 297, 11324, 11327);
                if (CallChecker.beforeDeref(CallChecker.isCalled(wdto, BundleWireDTO.class, 297, 11324, 11327).requirement, RequirementRefDTO.class, 297, 11324, 11339)) {
                    if (CallChecker.beforeDeref(wire, Wire.class, 297, 11372, 11375)) {
                        wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 297, 11324, 11327);
                        CallChecker.isCalled(wdto, BundleWireDTO.class, 297, 11324, 11327).requirement = CallChecker.beforeCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 297, 11324, 11327).requirement, RequirementRefDTO.class, 297, 11324, 11339);
                        wire = CallChecker.beforeCalled(wire, Wire.class, 297, 11372, 11375);
                        CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 297, 11324, 11327).requirement, RequirementRefDTO.class, 297, 11324, 11339).requirement = DTOFactory.getRequirementID(CallChecker.isCalled(wire, Wire.class, 297, 11372, 11375).getRequirement());
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 297, 11324, 11327).requirement, RequirementRefDTO.class, 297, 11324, 11339).requirement, "CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 297, 11324, 11327).requirement, RequirementRefDTO.class, 297, 11324, 11339).requirement", 297, 11324, 11394);
                    }
                }
            }
            if (CallChecker.beforeDeref(wdto, BundleWireDTO.class, 298, 11404, 11407)) {
                wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 298, 11404, 11407);
                if (CallChecker.beforeDeref(CallChecker.isCalled(wdto, BundleWireDTO.class, 298, 11404, 11407).requirement, RequirementRefDTO.class, 298, 11404, 11419)) {
                    if (CallChecker.beforeDeref(wire, Wire.class, 298, 11452, 11455)) {
                        wire = CallChecker.beforeCalled(wire, Wire.class, 298, 11452, 11455);
                        final Requirement npe_invocation_var231 = CallChecker.isCalled(wire, Wire.class, 298, 11452, 11455).getRequirement();
                        if (CallChecker.beforeDeref(npe_invocation_var231, Requirement.class, 298, 11452, 11472)) {
                            wdto = CallChecker.beforeCalled(wdto, BundleWireDTO.class, 298, 11404, 11407);
                            CallChecker.isCalled(wdto, BundleWireDTO.class, 298, 11404, 11407).requirement = CallChecker.beforeCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 298, 11404, 11407).requirement, RequirementRefDTO.class, 298, 11404, 11419);
                            CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 298, 11404, 11407).requirement, RequirementRefDTO.class, 298, 11404, 11419).resource = DTOFactory.getResourceIDAndAdd(CallChecker.isCalled(npe_invocation_var231, Requirement.class, 298, 11452, 11472).getResource(), resources);
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 298, 11404, 11407).requirement, RequirementRefDTO.class, 298, 11404, 11419).resource, "CallChecker.isCalled(CallChecker.isCalled(wdto, BundleWireDTO.class, 298, 11404, 11407).requirement, RequirementRefDTO.class, 298, 11404, 11419).resource", 298, 11404, 11499);
                        }
                    }
                }
            }
            return wdto;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleWireDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context719.methodEnd();
        }
    }

    private static BundleStartLevelDTO createBundleStartLevelDTO(Bundle bundle) {
        MethodContext _bcornu_methode_context720 = new MethodContext(BundleStartLevelDTO.class);
        try {
            CallChecker.varInit(bundle, "bundle", 302, 11533, 11984);
            BundleStartLevelDTO dto = CallChecker.varInit(new BundleStartLevelDTO(), "dto", 304, 11623, 11674);
            if (CallChecker.beforeDeref(dto, BundleStartLevelDTO.class, 305, 11684, 11686)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 305, 11697, 11702)) {
                    dto = CallChecker.beforeCalled(dto, BundleStartLevelDTO.class, 305, 11684, 11686);
                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 305, 11697, 11702);
                    CallChecker.isCalled(dto, BundleStartLevelDTO.class, 305, 11684, 11686).bundle = CallChecker.isCalled(bundle, Bundle.class, 305, 11697, 11702).getBundleId();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleStartLevelDTO.class, 305, 11684, 11686).bundle, "CallChecker.isCalled(dto, BundleStartLevelDTO.class, 305, 11684, 11686).bundle", 305, 11684, 11717);
                }
            }
            BundleStartLevel sl = CallChecker.init(BundleStartLevel.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 307, 11750, 11755)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 307, 11750, 11755);
                sl = CallChecker.isCalled(bundle, Bundle.class, 307, 11750, 11755).adapt(BundleStartLevel.class);
                CallChecker.varAssign(sl, "sl", 307, 11750, 11755);
            }
            if (CallChecker.beforeDeref(dto, BundleStartLevelDTO.class, 308, 11796, 11798)) {
                if (CallChecker.beforeDeref(sl, BundleStartLevel.class, 308, 11823, 11824)) {
                    dto = CallChecker.beforeCalled(dto, BundleStartLevelDTO.class, 308, 11796, 11798);
                    sl = CallChecker.beforeCalled(sl, BundleStartLevel.class, 308, 11823, 11824);
                    CallChecker.isCalled(dto, BundleStartLevelDTO.class, 308, 11796, 11798).activationPolicyUsed = CallChecker.isCalled(sl, BundleStartLevel.class, 308, 11823, 11824).isActivationPolicyUsed();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleStartLevelDTO.class, 308, 11796, 11798).activationPolicyUsed, "CallChecker.isCalled(dto, BundleStartLevelDTO.class, 308, 11796, 11798).activationPolicyUsed", 308, 11796, 11850);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleStartLevelDTO.class, 309, 11860, 11862)) {
                if (CallChecker.beforeDeref(sl, BundleStartLevel.class, 309, 11886, 11887)) {
                    dto = CallChecker.beforeCalled(dto, BundleStartLevelDTO.class, 309, 11860, 11862);
                    sl = CallChecker.beforeCalled(sl, BundleStartLevel.class, 309, 11886, 11887);
                    CallChecker.isCalled(dto, BundleStartLevelDTO.class, 309, 11860, 11862).persistentlyStarted = CallChecker.isCalled(sl, BundleStartLevel.class, 309, 11886, 11887).isPersistentlyStarted();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleStartLevelDTO.class, 309, 11860, 11862).persistentlyStarted, "CallChecker.isCalled(dto, BundleStartLevelDTO.class, 309, 11860, 11862).persistentlyStarted", 309, 11860, 11912);
                }
            }
            if (CallChecker.beforeDeref(dto, BundleStartLevelDTO.class, 310, 11922, 11924)) {
                if (CallChecker.beforeDeref(sl, BundleStartLevel.class, 310, 11939, 11940)) {
                    dto = CallChecker.beforeCalled(dto, BundleStartLevelDTO.class, 310, 11922, 11924);
                    sl = CallChecker.beforeCalled(sl, BundleStartLevel.class, 310, 11939, 11940);
                    CallChecker.isCalled(dto, BundleStartLevelDTO.class, 310, 11922, 11924).startLevel = CallChecker.isCalled(sl, BundleStartLevel.class, 310, 11939, 11940).getStartLevel();
                    CallChecker.varAssign(CallChecker.isCalled(dto, BundleStartLevelDTO.class, 310, 11922, 11924).startLevel, "CallChecker.isCalled(dto, BundleStartLevelDTO.class, 310, 11922, 11924).startLevel", 310, 11922, 11957);
                }
            }
            return dto;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleStartLevelDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context720.methodEnd();
        }
    }

    private static ServiceReferenceDTO[] createServiceReferenceDTOArray(Bundle bundle) {
        MethodContext _bcornu_methode_context721 = new MethodContext(ServiceReferenceDTO[].class);
        try {
            CallChecker.varInit(bundle, "bundle", 315, 11991, 12551);
            BundleContext ctx = CallChecker.init(BundleContext.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 317, 12108, 12113)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 317, 12108, 12113);
                ctx = CallChecker.isCalled(bundle, Bundle.class, 317, 12108, 12113).getBundleContext();
                CallChecker.varAssign(ctx, "ctx", 317, 12108, 12113);
            }
            if (ctx == null)
                return null;
            
            ServiceReference<?>[] svcs = CallChecker.init(ServiceReference[].class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 321, 12223, 12228)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 321, 12223, 12228);
                svcs = CallChecker.isCalled(bundle, Bundle.class, 321, 12223, 12228).getRegisteredServices();
                CallChecker.varAssign(svcs, "svcs", 321, 12223, 12228);
            }
            if (svcs == null)
                return new ServiceReferenceDTO[0];
            
            ServiceReferenceDTO[] dtos = CallChecker.varInit(new ServiceReferenceDTO[svcs.length], "dtos", 325, 12337, 12402);
            for (int i = 0; i < (svcs.length); i++) {
                if (CallChecker.beforeDeref(dtos, ServiceReferenceDTO[].class, 328, 12470, 12473)) {
                    dtos = CallChecker.beforeCalled(dtos, ServiceReferenceDTO[].class, 328, 12470, 12473);
                    CallChecker.isCalled(dtos, ServiceReferenceDTO[].class, 328, 12470, 12473)[i] = DTOFactory.createServiceReferenceDTO(svcs[i]);
                    CallChecker.varAssign(CallChecker.isCalled(dtos, ServiceReferenceDTO[].class, 328, 12470, 12473)[i], "CallChecker.isCalled(dtos, ServiceReferenceDTO[].class, 328, 12470, 12473)[i]", 328, 12470, 12514);
                }
            }
            return dtos;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReferenceDTO[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context721.methodEnd();
        }
    }

    private static ServiceReferenceDTO createServiceReferenceDTO(ServiceReference<?> svc) {
        MethodContext _bcornu_methode_context722 = new MethodContext(ServiceReferenceDTO.class);
        try {
            CallChecker.varInit(svc, "svc", 333, 12558, 13454);
            ServiceReferenceDTO dto = CallChecker.varInit(new ServiceReferenceDTO(), "dto", 335, 12658, 12709);
            if (CallChecker.beforeDeref(dto, ServiceReferenceDTO.class, 336, 12719, 12721)) {
                if (CallChecker.beforeDeref(svc, ServiceReference.class, 336, 12732, 12734)) {
                    svc = CallChecker.beforeCalled(svc, ServiceReference.class, 336, 12732, 12734);
                    final Bundle npe_invocation_var232 = CallChecker.isCalled(svc, ServiceReference.class, 336, 12732, 12734).getBundle();
                    if (CallChecker.beforeDeref(npe_invocation_var232, Bundle.class, 336, 12732, 12746)) {
                        dto = CallChecker.beforeCalled(dto, ServiceReferenceDTO.class, 336, 12719, 12721);
                        CallChecker.isCalled(dto, ServiceReferenceDTO.class, 336, 12719, 12721).bundle = CallChecker.isCalled(npe_invocation_var232, Bundle.class, 336, 12732, 12746).getBundleId();
                        CallChecker.varAssign(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 336, 12719, 12721).bundle, "CallChecker.isCalled(dto, ServiceReferenceDTO.class, 336, 12719, 12721).bundle", 336, 12719, 12761);
                    }
                }
            }
            if (CallChecker.beforeDeref(dto, ServiceReferenceDTO.class, 337, 12771, 12773)) {
                if (CallChecker.beforeDeref(svc, ServiceReference.class, 337, 12787, 12789)) {
                    dto = CallChecker.beforeCalled(dto, ServiceReferenceDTO.class, 337, 12771, 12773);
                    svc = CallChecker.beforeCalled(svc, ServiceReference.class, 337, 12787, 12789);
                    CallChecker.isCalled(dto, ServiceReferenceDTO.class, 337, 12771, 12773).id = ((Long) (CallChecker.isCalled(svc, ServiceReference.class, 337, 12787, 12789).getProperty(Constants.SERVICE_ID)));
                    CallChecker.varAssign(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 337, 12771, 12773).id, "CallChecker.isCalled(dto, ServiceReferenceDTO.class, 337, 12771, 12773).id", 337, 12771, 12824);
                }
            }
            Map<String, Object> props = CallChecker.varInit(new HashMap<String, Object>(), "props", 338, 12834, 12891);
            svc = CallChecker.beforeCalled(svc, ServiceReference.class, 339, 12919, 12921);
            for (String key : CallChecker.isCalled(svc, ServiceReference.class, 339, 12919, 12921).getPropertyKeys()) {
                if (CallChecker.beforeDeref(svc, ServiceReference.class, 341, 12979, 12981)) {
                    if (CallChecker.beforeDeref(props, Map.class, 341, 12964, 12968)) {
                        svc = CallChecker.beforeCalled(svc, ServiceReference.class, 341, 12979, 12981);
                        props = CallChecker.beforeCalled(props, Map.class, 341, 12964, 12968);
                        CallChecker.isCalled(props, Map.class, 341, 12964, 12968).put(key, CallChecker.isCalled(svc, ServiceReference.class, 341, 12979, 12981).getProperty(key));
                    }
                }
            }
            if (CallChecker.beforeDeref(dto, ServiceReferenceDTO.class, 343, 13020, 13022)) {
                dto = CallChecker.beforeCalled(dto, ServiceReferenceDTO.class, 343, 13020, 13022);
                CallChecker.isCalled(dto, ServiceReferenceDTO.class, 343, 13020, 13022).properties = new HashMap<String, Object>(props);
                CallChecker.varAssign(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 343, 13020, 13022).properties, "CallChecker.isCalled(dto, ServiceReferenceDTO.class, 343, 13020, 13022).properties", 343, 13020, 13071);
            }
            Bundle[] ubs = CallChecker.init(Bundle[].class);
            if (CallChecker.beforeDeref(svc, ServiceReference.class, 345, 13097, 13099)) {
                svc = CallChecker.beforeCalled(svc, ServiceReference.class, 345, 13097, 13099);
                ubs = CallChecker.isCalled(svc, ServiceReference.class, 345, 13097, 13099).getUsingBundles();
                CallChecker.varAssign(ubs, "ubs", 345, 13097, 13099);
            }
            if (ubs == null) {
                if (CallChecker.beforeDeref(dto, ServiceReferenceDTO.class, 348, 13167, 13169)) {
                    dto = CallChecker.beforeCalled(dto, ServiceReferenceDTO.class, 348, 13167, 13169);
                    CallChecker.isCalled(dto, ServiceReferenceDTO.class, 348, 13167, 13169).usingBundles = new long[0];
                    CallChecker.varAssign(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 348, 13167, 13169).usingBundles, "CallChecker.isCalled(dto, ServiceReferenceDTO.class, 348, 13167, 13169).usingBundles", 348, 13167, 13197);
                }
            }else {
                if (CallChecker.beforeDeref(dto, ServiceReferenceDTO.class, 352, 13244, 13246)) {
                    dto = CallChecker.beforeCalled(dto, ServiceReferenceDTO.class, 352, 13244, 13246);
                    CallChecker.isCalled(dto, ServiceReferenceDTO.class, 352, 13244, 13246).usingBundles = new long[ubs.length];
                    CallChecker.varAssign(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 352, 13244, 13246).usingBundles, "CallChecker.isCalled(dto, ServiceReferenceDTO.class, 352, 13244, 13246).usingBundles", 352, 13244, 13283);
                }
                for (int j = 0; j < (ubs.length); j++) {
                    if (CallChecker.beforeDeref(dto, ServiceReferenceDTO.class, 355, 13362, 13364)) {
                        dto = CallChecker.beforeCalled(dto, ServiceReferenceDTO.class, 355, 13362, 13364);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 355, 13362, 13364).usingBundles, long[].class, 355, 13362, 13377)) {
                            ubs = CallChecker.beforeCalled(ubs, Bundle[].class, 355, 13384, 13386);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ubs, Bundle[].class, 355, 13384, 13386)[j], Bundle.class, 355, 13384, 13389)) {
                                dto = CallChecker.beforeCalled(dto, ServiceReferenceDTO.class, 355, 13362, 13364);
                                CallChecker.isCalled(dto, ServiceReferenceDTO.class, 355, 13362, 13364).usingBundles = CallChecker.beforeCalled(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 355, 13362, 13364).usingBundles, long[].class, 355, 13362, 13377);
                                ubs[j] = CallChecker.beforeCalled(ubs[j], Bundle.class, 355, 13384, 13389);
                                CallChecker.isCalled(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 355, 13362, 13364).usingBundles, long[].class, 355, 13362, 13377)[j] = CallChecker.isCalled(ubs[j], Bundle.class, 355, 13384, 13389).getBundleId();
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 355, 13362, 13364).usingBundles, long[].class, 355, 13362, 13377)[j], "CallChecker.isCalled(CallChecker.isCalled(dto, ServiceReferenceDTO.class, 355, 13362, 13364).usingBundles, long[].class, 355, 13362, 13377)[j]", 355, 13362, 13404);
                            }
                        }
                    }
                }
            }
            return dto;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReferenceDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context722.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private static FrameworkDTO createFrameworkDTO(Felix framework) {
        MethodContext _bcornu_methode_context723 = new MethodContext(FrameworkDTO.class);
        try {
            CallChecker.varInit(framework, "framework", 362, 13461, 14370);
            FrameworkDTO dto = CallChecker.varInit(new FrameworkDTO(), "dto", 364, 13574, 13611);
            if (CallChecker.beforeDeref(dto, FrameworkDTO.class, 365, 13621, 13623)) {
                if (CallChecker.beforeDeref(framework, Felix.class, 365, 13656, 13664)) {
                    dto = CallChecker.beforeCalled(dto, FrameworkDTO.class, 365, 13621, 13623);
                    framework = CallChecker.beforeCalled(framework, Felix.class, 365, 13656, 13664);
                    CallChecker.isCalled(dto, FrameworkDTO.class, 365, 13621, 13623).properties = DTOFactory.convertAttrsToDTO(CallChecker.isCalled(framework, Felix.class, 365, 13656, 13664).getConfig());
                    CallChecker.varAssign(CallChecker.isCalled(dto, FrameworkDTO.class, 365, 13621, 13623).properties, "CallChecker.isCalled(dto, FrameworkDTO.class, 365, 13621, 13623).properties", 365, 13621, 13678);
                }
            }
            if (CallChecker.beforeDeref(dto, FrameworkDTO.class, 367, 13689, 13691)) {
                dto = CallChecker.beforeCalled(dto, FrameworkDTO.class, 367, 13689, 13691);
                CallChecker.isCalled(dto, FrameworkDTO.class, 367, 13689, 13691).bundles = new ArrayList<BundleDTO>();
                CallChecker.varAssign(CallChecker.isCalled(dto, FrameworkDTO.class, 367, 13689, 13691).bundles, "CallChecker.isCalled(dto, FrameworkDTO.class, 367, 13689, 13691).bundles", 367, 13689, 13729);
            }
            framework = CallChecker.beforeCalled(framework, Felix.class, 368, 13755, 13763);
            for (Bundle b : CallChecker.isCalled(CallChecker.isCalled(framework, Felix.class, 368, 13755, 13763).getBundleContext(), BundleContext.class, 368, 13755, 13782).getBundles()) {
                if (CallChecker.beforeDeref(dto, FrameworkDTO.class, 370, 13820, 13822)) {
                    dto = CallChecker.beforeCalled(dto, FrameworkDTO.class, 370, 13820, 13822);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(dto, FrameworkDTO.class, 370, 13820, 13822).bundles, List.class, 370, 13820, 13830)) {
                        dto = CallChecker.beforeCalled(dto, FrameworkDTO.class, 370, 13820, 13822);
                        CallChecker.isCalled(CallChecker.isCalled(dto, FrameworkDTO.class, 370, 13820, 13822).bundles, List.class, 370, 13820, 13830).add(DTOFactory.createDTO(b, BundleDTO.class));
                    }
                }
            }
            if (CallChecker.beforeDeref(dto, FrameworkDTO.class, 373, 13898, 13900)) {
                dto = CallChecker.beforeCalled(dto, FrameworkDTO.class, 373, 13898, 13900);
                CallChecker.isCalled(dto, FrameworkDTO.class, 373, 13898, 13900).services = new ArrayList<ServiceReferenceDTO>();
                CallChecker.varAssign(CallChecker.isCalled(dto, FrameworkDTO.class, 373, 13898, 13900).services, "CallChecker.isCalled(dto, FrameworkDTO.class, 373, 13898, 13900).services", 373, 13898, 13949);
            }
            ServiceReference<?>[] refs = CallChecker.varInit(null, "refs", 375, 13960, 13993);
            TryContext _bcornu_try_context_264 = new TryContext(264, DTOFactory.class, "org.osgi.framework.InvalidSyntaxException");
            try {
                if (CallChecker.beforeDeref(framework, Felix.class, 378, 14036, 14044)) {
                    framework = CallChecker.beforeCalled(framework, Felix.class, 378, 14036, 14044);
                    final BundleContext npe_invocation_var233 = CallChecker.isCalled(framework, Felix.class, 378, 14036, 14044).getBundleContext();
                    if (CallChecker.beforeDeref(npe_invocation_var233, BundleContext.class, 378, 14036, 14063)) {
                        refs = CallChecker.isCalled(npe_invocation_var233, BundleContext.class, 378, 14036, 14063).getAllServiceReferences(null, null);
                        CallChecker.varAssign(refs, "refs", 378, 14029, 14100);
                    }
                }
            } catch (InvalidSyntaxException e) {
                _bcornu_try_context_264.catchStart(264);
            } finally {
                _bcornu_try_context_264.finallyStart(264);
            }
            if (CallChecker.beforeDeref(refs, FrameworkDTO.class, 385, 14258, 14261)) {
                for (ServiceReference<?> sr : refs) {
                    if (CallChecker.beforeDeref(dto, FrameworkDTO.class, 387, 14286, 14288)) {
                        dto = CallChecker.beforeCalled(dto, FrameworkDTO.class, 387, 14286, 14288);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(dto, FrameworkDTO.class, 387, 14286, 14288).services, List.class, 387, 14286, 14297)) {
                            dto = CallChecker.beforeCalled(dto, FrameworkDTO.class, 387, 14286, 14288);
                            CallChecker.isCalled(CallChecker.isCalled(dto, FrameworkDTO.class, 387, 14286, 14288).services, List.class, 387, 14286, 14297).add(DTOFactory.createServiceReferenceDTO(sr));
                        }
                    }
                }
            }
            return dto;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FrameworkDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context723.methodEnd();
        }
    }

    private static FrameworkStartLevelDTO createFrameworkStartLevelDTO(Framework framework) {
        MethodContext _bcornu_methode_context724 = new MethodContext(FrameworkStartLevelDTO.class);
        try {
            CallChecker.varInit(framework, "framework", 393, 14377, 14760);
            FrameworkStartLevel fsl = CallChecker.init(FrameworkStartLevel.class);
            if (CallChecker.beforeDeref(framework, Framework.class, 395, 14505, 14513)) {
                framework = CallChecker.beforeCalled(framework, Framework.class, 395, 14505, 14513);
                fsl = CallChecker.isCalled(framework, Framework.class, 395, 14505, 14513).adapt(FrameworkStartLevel.class);
                CallChecker.varAssign(fsl, "fsl", 395, 14505, 14513);
            }
            FrameworkStartLevelDTO dto = CallChecker.varInit(new FrameworkStartLevelDTO(), "dto", 397, 14558, 14615);
            if (CallChecker.beforeDeref(dto, FrameworkStartLevelDTO.class, 398, 14625, 14627)) {
                if (CallChecker.beforeDeref(fsl, FrameworkStartLevel.class, 398, 14655, 14657)) {
                    dto = CallChecker.beforeCalled(dto, FrameworkStartLevelDTO.class, 398, 14625, 14627);
                    fsl = CallChecker.beforeCalled(fsl, FrameworkStartLevel.class, 398, 14655, 14657);
                    CallChecker.isCalled(dto, FrameworkStartLevelDTO.class, 398, 14625, 14627).initialBundleStartLevel = CallChecker.isCalled(fsl, FrameworkStartLevel.class, 398, 14655, 14657).getInitialBundleStartLevel();
                    CallChecker.varAssign(CallChecker.isCalled(dto, FrameworkStartLevelDTO.class, 398, 14625, 14627).initialBundleStartLevel, "CallChecker.isCalled(dto, FrameworkStartLevelDTO.class, 398, 14625, 14627).initialBundleStartLevel", 398, 14625, 14687);
                }
            }
            if (CallChecker.beforeDeref(dto, FrameworkStartLevelDTO.class, 399, 14697, 14699)) {
                if (CallChecker.beforeDeref(fsl, FrameworkStartLevel.class, 399, 14714, 14716)) {
                    dto = CallChecker.beforeCalled(dto, FrameworkStartLevelDTO.class, 399, 14697, 14699);
                    fsl = CallChecker.beforeCalled(fsl, FrameworkStartLevel.class, 399, 14714, 14716);
                    CallChecker.isCalled(dto, FrameworkStartLevelDTO.class, 399, 14697, 14699).startLevel = CallChecker.isCalled(fsl, FrameworkStartLevel.class, 399, 14714, 14716).getStartLevel();
                    CallChecker.varAssign(CallChecker.isCalled(dto, FrameworkStartLevelDTO.class, 399, 14697, 14699).startLevel, "CallChecker.isCalled(dto, FrameworkStartLevelDTO.class, 399, 14697, 14699).startLevel", 399, 14697, 14733);
                }
            }
            return dto;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FrameworkStartLevelDTO) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context724.methodEnd();
        }
    }

    private static void addBundleRevisionDTO(BundleRevisionDTO dto, Set<BundleRevisionDTO> resources) {
        MethodContext _bcornu_methode_context725 = new MethodContext(void.class);
        try {
            CallChecker.varInit(resources, "resources", 404, 14767, 15025);
            CallChecker.varInit(dto, "dto", 404, 14767, 15025);
            if (CallChecker.beforeDeref(resources, void.class, 406, 14906, 14914)) {
                for (BundleRevisionDTO r : resources) {
                    if (CallChecker.beforeDeref(r, BundleRevisionDTO.class, 408, 14943, 14943)) {
                        if (CallChecker.beforeDeref(dto, BundleRevisionDTO.class, 408, 14951, 14953)) {
                            dto = CallChecker.beforeCalled(dto, BundleRevisionDTO.class, 408, 14951, 14953);
                            if ((CallChecker.isCalled(r, BundleRevisionDTO.class, 408, 14943, 14943).id) == (CallChecker.isCalled(dto, BundleRevisionDTO.class, 408, 14951, 14953).id))
                                return ;
                            
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(resources, Set.class, 411, 15001, 15009)) {
                resources = CallChecker.beforeCalled(resources, Set.class, 411, 15001, 15009);
                CallChecker.isCalled(resources, Set.class, 411, 15001, 15009).add(dto);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context725.methodEnd();
        }
    }

    private static void addWiringNodeIfNotPresent(BundleWiring bw, Set<BundleRevisionDTO> resources, Set<BundleWiringDTO.NodeDTO> nodes) {
        MethodContext _bcornu_methode_context726 = new MethodContext(void.class);
        try {
            CallChecker.varInit(nodes, "nodes", 414, 15032, 15366);
            CallChecker.varInit(resources, "resources", 414, 15032, 15366);
            CallChecker.varInit(bw, "bw", 414, 15032, 15366);
            int wiringID = CallChecker.varInit(((int) (DTOFactory.getWiringID(bw))), "wiringID", 416, 15163, 15193);
            if (CallChecker.beforeDeref(nodes, void.class, 417, 15220, 15224)) {
                for (BundleWiringDTO.NodeDTO n : nodes) {
                    if (CallChecker.beforeDeref(n, BundleWiringDTO.NodeDTO.class, 419, 15253, 15253)) {
                        if ((CallChecker.isCalled(n, BundleWiringDTO.NodeDTO.class, 419, 15253, 15253).id) == wiringID)
                            return ;
                        
                    }
                }
            }
            DTOFactory.createBundleWiringNodeDTO(bw, resources, nodes);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context726.methodEnd();
        }
    }

    private static Map<String, Object> convertAttrsToDTO(Map<String, Object> map) {
        MethodContext _bcornu_methode_context727 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(map, "map", 427, 15373, 15941);
            Map<String, Object> m = CallChecker.varInit(new HashMap<String, Object>(), "m", 429, 15613, 15666);
            map = CallChecker.beforeCalled(map, Map.class, 430, 15715, 15717);
            for (Map.Entry<String, Object> entry : CallChecker.isCalled(map, Map.class, 430, 15715, 15717).entrySet()) {
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 432, 15785, 15789)) {
                    value = DTOFactory.convertAttrToDTO(CallChecker.isCalled(entry, Map.Entry.class, 432, 15785, 15789).getValue());
                    CallChecker.varAssign(value, "value", 432, 15785, 15789);
                }
                if (value != null) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 435, 15871, 15875)) {
                        if (CallChecker.beforeDeref(m, Map.class, 435, 15865, 15865)) {
                            m = CallChecker.beforeCalled(m, Map.class, 435, 15865, 15865);
                            CallChecker.isCalled(m, Map.class, 435, 15865, 15865).put(CallChecker.isCalled(entry, Map.Entry.class, 435, 15871, 15875).getKey(), value);
                        }
                    }
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context727.methodEnd();
        }
    }

    private static Object convertAttrToDTO(Object value) {
        MethodContext _bcornu_methode_context728 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(value, "value", 441, 15948, 16396);
            if (value instanceof Version) {
                if (CallChecker.beforeDeref(value, Object.class, 445, 16074, 16078)) {
                    value = CallChecker.beforeCalled(value, Object.class, 445, 16074, 16078);
                    return CallChecker.isCalled(value, Object.class, 445, 16074, 16078).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (CallChecker.beforeDeref(value, Object.class, 447, 16142, 16146)) {
                    if (CallChecker.beforeDeref(value, Object.class, 448, 16180, 16184)) {
                        value = CallChecker.beforeCalled(value, Object.class, 448, 16180, 16184);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(value, Object.class, 448, 16180, 16184).getClass(), Class.class, 448, 16180, 16195)) {
                            if (CallChecker.beforeDeref(value, Object.class, 449, 16249, 16253)) {
                                value = CallChecker.beforeCalled(value, Object.class, 449, 16249, 16253);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(value, Object.class, 449, 16249, 16253).getClass(), Class.class, 449, 16249, 16264)) {
                                    value = CallChecker.beforeCalled(value, Object.class, 447, 16142, 16146);
                                    value = CallChecker.beforeCalled(value, Object.class, 448, 16180, 16184);
                                    value = CallChecker.beforeCalled(value, Object.class, 449, 16249, 16253);
                                    if ((DTOFactory.isPermissibleAttribute(CallChecker.isCalled(value, Object.class, 447, 16142, 16146).getClass())) || ((CallChecker.isCalled(CallChecker.isCalled(value, Object.class, 448, 16180, 16184).getClass(), Class.class, 448, 16180, 16195).isArray()) && (DTOFactory.isPermissibleAttribute(CallChecker.isCalled(CallChecker.isCalled(value, Object.class, 449, 16249, 16253).getClass(), Class.class, 449, 16249, 16264).getComponentType())))) {
                                        return value;
                                    }else {
                                        return null;
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
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context728.methodEnd();
        }
    }

    private static boolean isPermissibleAttribute(Class clazz) {
        MethodContext _bcornu_methode_context729 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(clazz, "clazz", 459, 16403, 16589);
            return ((clazz == (Boolean.class)) || (clazz == (String.class))) || (DTO.class.isAssignableFrom(clazz));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context729.methodEnd();
        }
    }

    private static int getWiringID(Wiring bw) {
        MethodContext _bcornu_methode_context730 = new MethodContext(int.class);
        try {
            CallChecker.varInit(bw, "bw", 465, 16596, 16678);
            if (CallChecker.beforeDeref(bw, Wiring.class, 467, 16659, 16660)) {
                bw = CallChecker.beforeCalled(bw, Wiring.class, 467, 16659, 16660);
                return CallChecker.isCalled(bw, Wiring.class, 467, 16659, 16660).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context730.methodEnd();
        }
    }

    private static int getCapabilityID(Capability capability) {
        MethodContext _bcornu_methode_context731 = new MethodContext(int.class);
        try {
            CallChecker.varInit(capability, "capability", 470, 16685, 16791);
            if (CallChecker.beforeDeref(capability, Capability.class, 472, 16764, 16773)) {
                capability = CallChecker.beforeCalled(capability, Capability.class, 472, 16764, 16773);
                return CallChecker.isCalled(capability, Capability.class, 472, 16764, 16773).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context731.methodEnd();
        }
    }

    private static int getRequirementID(Requirement requirement) {
        MethodContext _bcornu_methode_context732 = new MethodContext(int.class);
        try {
            CallChecker.varInit(requirement, "requirement", 475, 16798, 16908);
            if (CallChecker.beforeDeref(requirement, Requirement.class, 477, 16880, 16890)) {
                requirement = CallChecker.beforeCalled(requirement, Requirement.class, 477, 16880, 16890);
                return CallChecker.isCalled(requirement, Requirement.class, 477, 16880, 16890).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context732.methodEnd();
        }
    }

    private static int getResourceIDAndAdd(Resource res, Set<BundleRevisionDTO> resources) {
        MethodContext _bcornu_methode_context733 = new MethodContext(int.class);
        try {
            CallChecker.varInit(resources, "resources", 480, 16915, 17508);
            CallChecker.varInit(res, "res", 480, 16915, 17508);
            if (res instanceof BundleRevisionImpl) {
                BundleRevisionImpl bres = CallChecker.varInit(((BundleRevisionImpl) (res)), "bres", 484, 17077, 17127);
                int id = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(bres, BundleRevisionImpl.class, 485, 17150, 17153)) {
                    bres = CallChecker.beforeCalled(bres, BundleRevisionImpl.class, 485, 17150, 17153);
                    final String npe_invocation_var234 = CallChecker.isCalled(bres, BundleRevisionImpl.class, 485, 17150, 17153).getId();
                    if (CallChecker.beforeDeref(npe_invocation_var234, String.class, 485, 17150, 17161)) {
                        id = CallChecker.isCalled(npe_invocation_var234, String.class, 485, 17150, 17161).hashCode();
                        CallChecker.varAssign(id, "id", 485, 17150, 17153);
                    }
                }
                if (resources == null)
                    return id;
                
                for (BundleRevisionDTO rdto : resources) {
                    if (CallChecker.beforeDeref(rdto, BundleRevisionDTO.class, 492, 17326, 17329)) {
                        if ((CallChecker.isCalled(rdto, BundleRevisionDTO.class, 492, 17326, 17329).id) == id)
                            return id;
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                DTOFactory.createBundleRevisionDTO(bres, resources);
                return id;
            }
            if (CallChecker.beforeDeref(res, Resource.class, 498, 17488, 17490)) {
                res = CallChecker.beforeCalled(res, Resource.class, 498, 17488, 17490);
                return CallChecker.isCalled(res, Resource.class, 498, 17488, 17490).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context733.methodEnd();
        }
    }

    private static int getRevisionID(BundleRevisionImpl revision) {
        MethodContext _bcornu_methode_context734 = new MethodContext(int.class);
        try {
            CallChecker.varInit(revision, "revision", 501, 17515, 17631);
            if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 503, 17598, 17605)) {
                revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 503, 17598, 17605);
                final String npe_invocation_var235 = CallChecker.isCalled(revision, BundleRevisionImpl.class, 503, 17598, 17605).getId();
                if (CallChecker.beforeDeref(npe_invocation_var235, String.class, 503, 17598, 17613)) {
                    return CallChecker.isCalled(npe_invocation_var235, String.class, 503, 17598, 17613).hashCode();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context734.methodEnd();
        }
    }
}

