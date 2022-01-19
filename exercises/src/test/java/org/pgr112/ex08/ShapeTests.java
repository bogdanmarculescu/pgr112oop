package org.pgr112.ex08;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ShapeTests {

    @Test
    public void newTest(){
        HashMap<String, Shape> myMap = new HashMap<>();

        for(Shape shape : myMap.values()){
            double area = shape.getArea();
        }
    }
}
