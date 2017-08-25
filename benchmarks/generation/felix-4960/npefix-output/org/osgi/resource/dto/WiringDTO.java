package org.osgi.resource.dto;

import java.util.List;
import org.osgi.dto.DTO;

public class WiringDTO extends DTO {
    public int id;

    public List<CapabilityRefDTO> capabilities;

    public List<RequirementRefDTO> requirements;

    public List<WireDTO> providedWires;

    public List<WireDTO> requiredWires;

    public int resource;
}

