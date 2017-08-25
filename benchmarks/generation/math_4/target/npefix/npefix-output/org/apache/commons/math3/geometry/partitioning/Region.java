package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;

public interface Region<S extends Space> {
    public static enum Location {
INSIDE, OUTSIDE, BOUNDARY;    }

    Region<S> buildNew(BSPTree<S> newTree);

    Region<S> copySelf();

    boolean isEmpty();

    boolean isEmpty(final BSPTree<S> node);

    boolean contains(final Region<S> region);

    Region.Location checkPoint(final Vector<S> point);

    BSPTree<S> getTree(final boolean includeBoundaryAttributes);

    double getBoundarySize();

    double getSize();

    Vector<S> getBarycenter();

    Side side(final Hyperplane<S> hyperplane);

    SubHyperplane<S> intersection(final SubHyperplane<S> sub);
}

