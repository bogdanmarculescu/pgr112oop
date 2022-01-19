package org.pgr112.solutions.sol7;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {

    @Test
    public void testCircle1(){
        Circle c1 = new Circle();

        assertTrue(c1.isFilled());
        assertEquals(Color.RED, c1.getColor());
        assertEquals(1.0, c1.getRadius());

        assertEquals(2*Math.PI, c1.getPerimeter());
        assertEquals(Math.PI, c1.getArea());
    }

    @Test
    public void testCircle2(){
        Circle c1 = new Circle(2.0);

        assertTrue(c1.isFilled());
        assertEquals(Color.RED, c1.getColor());
        assertEquals(2.0, c1.getRadius());

        assertEquals(2*Math.PI*2, c1.getPerimeter());
        assertEquals(4*Math.PI, c1.getArea());
    }


    @Test
    public void testCircle3(){
        Circle c1 = new Circle(3.0, Color.BLUE, false);

        assertFalse(c1.isFilled());
        assertEquals(Color.BLUE, c1.getColor());
        assertEquals(3.0, c1.getRadius());

        assertEquals(2*Math.PI*3, c1.getPerimeter());
        assertEquals(9*Math.PI, c1.getArea());
    }

    @Test
    public void testToString(){
        Circle c1 = new Circle();

        assertTrue(c1.toString().contains("Circle"));
        assertTrue(c1.toString().contains("Radius"));
    }
}
