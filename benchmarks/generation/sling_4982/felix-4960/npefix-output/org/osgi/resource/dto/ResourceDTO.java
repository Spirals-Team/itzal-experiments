package org.osgi.resource.dto;

import java.util.List;
import org.osgi.dto.DTO;

public class ResourceDTO extends DTO {
    public int id;

    public List<CapabilityDTO> capabilities;

    public List<RequirementDTO> requirements;
}

