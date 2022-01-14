package org.pgr112.lesson7;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void createRectangleEmptyConstructor() {
        Rectangle rectangle = new Rectangle();
        assertTrue(rectangle.isFilled());
        assertEquals(rectangle.getLength(), 2.0);
        assertEquals(rectangle.getWidth(), 1.0);
        assertEquals(Color.GREEN, rectangle.getColor());
    }

    @Test
    void createRectangleWidthAndLengthConstructor() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        assertTrue(rectangle.isFilled());
        assertEquals(rectangle.getLength(), 4.0);
        assertEquals(rectangle.getWidth(), 3.0);
        assertEquals(Color.GREEN, rectangle.getColor());
    }
    @Test
    void createRectangleFullConstructor() {
        Rectangle rectangle = new Rectangle(4.0, 5.0, Color.BLUE, false);
        assertFalse(rectangle.isFilled());
        assertEquals(rectangle.getLength(), 5.0);
        assertEquals(rectangle.getWidth(), 4.0);
        assertEquals(Color.BLUE, rectangle.getColor());
    }

    @Test
    void getArea() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        assertEquals(rectangle.getArea(), 12.0);
    }

    @Test
    void getPerimeter() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        assertEquals(rectangle.getPerimeter(), 14.0);
    }
}