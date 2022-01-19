package org.pgr112.solutions.sol7;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EquilateralTriangleTest {

    @Test
    public void testEquilateralTriangle1(){
        EquilateralTriangle c1 = new EquilateralTriangle();

        assertTrue(c1.isFilled());
        assertEquals(Color.RED, c1.getColor());
        assertEquals(1.0, c1.getSide());

        assertEquals(3.0, c1.getPerimeter());
        assertTrue(c1.getArea() < 9.0);
    }

    @Test
    public void testEquilateralTriangle2(){
        EquilateralTriangle c1 = new EquilateralTriangle(4.0);

        assertTrue(c1.isFilled());
        assertEquals(Color.RED, c1.getColor());
        assertEquals(4.0, c1.getSide());

        assertEquals(12.0, c1.getPerimeter());
        assertTrue(c1.getArea() < 16.0);
    }

    @Test
    public void testEquilateralTriangle3(){
        EquilateralTriangle c1 = new EquilateralTriangle(5.0, Color.BLUE, false);

        assertFalse(c1.isFilled());
        assertEquals(Color.BLUE, c1.getColor());
        assertEquals(5.0, c1.getSide());

        assertEquals(15.0, c1.getPerimeter());
        assertTrue(c1.getArea() < 25.0);
    }

    @Test
    public void testToString(){
        Square c1 = new Square();

        assertTrue(c1.toString().contains("Square"));
        assertTrue(c1.toString().contains("Side"));
    }
}
