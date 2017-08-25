package org.apache.commons.math3;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;

public interface FieldElement<T> {
    T add(T a) throws NullArgumentException;

    T subtract(T a) throws NullArgumentException;

    T negate();

    T multiply(int n);

    T multiply(T a) throws NullArgumentException;

    T divide(T a) throws MathArithmeticException, NullArgumentException;

    T reciprocal() throws MathArithmeticException;

    Field<T> getField();
}

