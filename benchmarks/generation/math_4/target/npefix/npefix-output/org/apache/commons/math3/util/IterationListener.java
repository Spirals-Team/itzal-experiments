package org.apache.commons.math3.util;

import java.util.EventListener;

public interface IterationListener extends EventListener {
    void initializationPerformed(IterationEvent e);

    void iterationPerformed(IterationEvent e);

    void iterationStarted(IterationEvent e);

    void terminationPerformed(IterationEvent e);
}

