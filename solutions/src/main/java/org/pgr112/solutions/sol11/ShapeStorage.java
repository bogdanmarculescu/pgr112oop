package org.pgr112.solutions.sol11;

import java.util.Set;

public interface ShapeStorage {
    Set<Shape> retrieveShapes() throws Exception;
    void storeShapes(Set<Shape> shapes) throws Exception;
}
