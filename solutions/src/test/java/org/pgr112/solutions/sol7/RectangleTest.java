package org.pgr112.solutions.sol7;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

    @Test
    public void testRectangle1(){
        Rectangle c1 = new Rectangle();

        assertTrue(c1.isFilled());
        assertEquals(Color.RED, c1.getColor());
        assertEquals(1.0, c1.getWidth());
        assertEquals(2.0, c1.getLength());

        assertEquals(6.0, c1.getPerimeter());
        assertEquals(2.0, c1.getArea());
    }

    @Test
    public void testRectangle2(){
        Rectangle c1 = new Rectangle(2.0, 4.0);

        assertTrue(c1.isFilled());
        assertEquals(Color.GREEN, c1.getColor());
        assertEquals(2.0, c1.getWidth());
        assertEquals(4.0, c1.getLength());

        assertEquals(12.0, c1.getPerimeter());
        assertEquals(8.0, c1.getArea());
    }

    @Test
    public void testRectangle3(){
        Rectangle c1 = new Rectangle(3.0, 5.0, Color.BLUE, false);

        assertFalse(c1.isFilled());
        assertEquals(Color.BLUE, c1.getColor());
        assertEquals(3.0, c1.getWidth());
        assertEquals(5.0, c1.getLength());

        assertEquals(16.0, c1.getPerimeter());
        assertEquals(15.0, c1.getArea());
    }

    @Test
    public void testToString(){
        Rectangle c1 = new Rectangle();

        assertTrue(c1.toString().contains("Rectangle"));
        assertTrue(c1.toString().contains("Width"));
        assertTrue(c1.toString().contains("Length"));
    }
}
