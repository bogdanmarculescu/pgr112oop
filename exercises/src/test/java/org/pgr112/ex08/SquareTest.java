package org.pgr112.ex08;

import org.junit.jupiter.api.Test;
import org.pgr112.ex08.Square;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class SquareTest {

    @Test
    public void testSquare1(){
        Square s1 = new Square();

        // Test stuff from Shape
        assertEquals(Color.GREEN, s1.getColor());
        assertTrue(s1.isFilled());

        // Test stuff more specific to Rectangle/Square
        assertEquals(1.0, s1.getArea());
        assertEquals(4.0, s1.getPerimeter());

        // Test Square specific stuff
        assertTrue(s1.getLength() == s1.getWidth());

    }
}
