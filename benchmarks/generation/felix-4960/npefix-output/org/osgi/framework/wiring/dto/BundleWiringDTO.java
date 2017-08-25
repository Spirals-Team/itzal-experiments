package org.osgi.framework.wiring.dto;

import org.osgi.resource.dto.WiringDTO;
import java.util.Set;
import org.osgi.dto.DTO;

public class BundleWiringDTO extends DTO {
    public long bundle;

    public int root;

    public Set<BundleWiringDTO.NodeDTO> nodes;

    public Set<BundleRevisionDTO> resources;

    public static class NodeDTO extends WiringDTO {
        public boolean inUse;

        public boolean current;
    }
}

