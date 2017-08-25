package org.apache.commons.math3.random;

import java.util.Collection;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;

public interface RandomData {
    String nextHexString(int len) throws NotStrictlyPositiveException;

    int nextInt(int lower, int upper) throws NumberIsTooLargeException;

    long nextLong(long lower, long upper) throws NumberIsTooLargeException;

    String nextSecureHexString(int len) throws NotStrictlyPositiveException;

    int nextSecureInt(int lower, int upper) throws NumberIsTooLargeException;

    long nextSecureLong(long lower, long upper) throws NumberIsTooLargeException;

    long nextPoisson(double mean) throws NotStrictlyPositiveException;

    double nextGaussian(double mu, double sigma) throws NotStrictlyPositiveException;

    double nextExponential(double mean) throws NotStrictlyPositiveException;

    double nextUniform(double lower, double upper) throws NotANumberException, NotFiniteNumberException, NumberIsTooLargeException;

    double nextUniform(double lower, double upper, boolean lowerInclusive) throws NotANumberException, NotFiniteNumberException, NumberIsTooLargeException;

    int[] nextPermutation(int n, int k) throws NotStrictlyPositiveException, NumberIsTooLargeException;

    Object[] nextSample(Collection<?> c, int k) throws NotStrictlyPositiveException, NumberIsTooLargeException;
}

