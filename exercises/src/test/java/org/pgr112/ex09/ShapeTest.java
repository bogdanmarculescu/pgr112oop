package org.pgr112.ex09;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class ShapeTest {

    @Test
    public void testShapeExample(){
        Circle c1 = new Circle(2, Color.BLUE, true);
        Square s1 = new Square(3, Color.GRAY, false);

        HashMap<String, Shape> shapes = new HashMap<>();
        shapes.put("Circle-1", c1);
        shapes.put("Square-1", s1);

        assertTrue(shapes.size()==2);
        assertTrue(shapes.containsKey("Circle-1"));
    }
}
