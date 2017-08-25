package org.osgi.framework.startlevel.dto;

import org.osgi.dto.DTO;

public class BundleStartLevelDTO extends DTO {
    public long bundle;

    public int startLevel;

    public boolean activationPolicyUsed;

    public boolean persistentlyStarted;
}

