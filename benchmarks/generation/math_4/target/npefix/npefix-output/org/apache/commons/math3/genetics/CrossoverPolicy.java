package org.apache.commons.math3.genetics;

import org.apache.commons.math3.exception.MathIllegalArgumentException;

public interface CrossoverPolicy {
    ChromosomePair crossover(Chromosome first, Chromosome second) throws MathIllegalArgumentException;
}

