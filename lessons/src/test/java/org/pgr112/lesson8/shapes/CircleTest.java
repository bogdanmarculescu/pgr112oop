package org.pgr112.lesson8.shapes;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class CircleTest {

    @Test
    void createCircleEmptyConstructor() {
        Circle circle = new Circle();
        assertTrue(circle.isFilled());
        assertEquals(circle.getRadius(), 1.0);
        assertEquals(Color.RED, circle.getColor());
    }

    @Test
    void createCircleRadiusConstructor() {
        Circle circle = new Circle(2.0);
        assertTrue(circle.isFilled());
        assertEquals(circle.getRadius(), 2.0);
        assertEquals(Color.RED, circle.getColor());
    }
    @Test
    void createCircleFullConstructor() {
        Circle circle = new Circle(2.0);
        assertTrue(circle.isFilled());
        assertEquals(circle.getRadius(), 2.0);
        assertEquals(Color.RED, circle.getColor());
    }


    @Test
    void getPerimeter() {
        Circle circle = new Circle(2.0);
        assertEquals(4.0 * Math.PI, circle.getPerimeter());
    }

    @Test
    void getArea() {
        Circle circle = new Circle(3.0);
        assertEquals(Math.PI * 3.0 * 3.0, circle.getArea());
    }

}