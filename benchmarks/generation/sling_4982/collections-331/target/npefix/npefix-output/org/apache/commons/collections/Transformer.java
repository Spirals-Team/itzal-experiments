package org.apache.commons.collections;


public interface Transformer<I, O> {
    public O transform(I input);
}

