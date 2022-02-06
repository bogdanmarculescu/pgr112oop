package org.pgr112.lesson8.shapes;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

abstract class SquareTest {

    @Test
    void createSquareEmptyConstructor() {
        Square square = new Square();
        assertTrue(square.isFilled());
        assertEquals(square.getLength(), 1.0);
        assertEquals(square.getWidth(), 1.0);
        assertEquals(Color.GREEN, square.getColor());
    }

    @Test
    void createSquareWidthSideConstructor() {
        Square square = new Square(5.0);
        assertTrue(square.isFilled());
        assertEquals(square.getLength(), 5.0);
        assertEquals(square.getWidth(), 5.0);
        assertEquals(Color.GREEN, square.getColor());
    }
    @Test
    void createSquareFullConstructor() {
        Square square = new Square(7.0, Color.DARK_GRAY, false);
        assertFalse(square.isFilled());
        assertEquals(square.getLength(), 7.0);
        assertEquals(square.getWidth(), 7.0);
        assertEquals(Color.DARK_GRAY, square.getColor());
    }

    @Test
    void getArea() {
        Square square = new Square(5.0);
        assertEquals(square.getArea(), 25.0);
    }

    @Test
    void getPerimeter() {
        Square square = new Square(5.0);
        assertEquals(square.getPerimeter(), 20.0);
    }

}