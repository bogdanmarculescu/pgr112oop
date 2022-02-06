package org.pgr112.ex08;

import org.junit.jupiter.api.Test;
import org.pgr112.ex08.Shape;

import java.util.HashMap;

public abstract class ShapeTests {

    @Test
    void newTest(){
        HashMap<String, Shape> myMap = new HashMap<>();

        for(Shape shape : myMap.values()){
            double area = shape.getArea();
        }
    }
}
