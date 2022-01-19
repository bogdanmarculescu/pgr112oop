package org.pgr112.solutions.sol7;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    @Test
    public void testSquare1(){
        Square c1 = new Square();

        assertTrue(c1.isFilled());
        assertEquals(Color.GREEN, c1.getColor());
        assertEquals(1.0, c1.getSide());

        assertEquals(4.0, c1.getPerimeter());
        assertEquals(1.0, c1.getArea());
    }

    @Test
    public void testSquare2(){
        Square c1 = new Square(4.0);

        assertTrue(c1.isFilled());
        assertEquals(Color.GREEN, c1.getColor());
        assertEquals(4.0, c1.getSide());

        assertEquals(16.0, c1.getPerimeter());
        assertEquals(16.0, c1.getArea());
    }

    @Test
    public void testSquare3(){
        Square c1 = new Square(5.0, Color.BLUE, false);

        assertFalse(c1.isFilled());
        assertEquals(Color.BLUE, c1.getColor());
        assertEquals(5.0, c1.getSide());

        assertEquals(20.0, c1.getPerimeter());
        assertEquals(25.0, c1.getArea());
    }

    @Test
    public void testToString(){
        Square c1 = new Square();

        assertTrue(c1.toString().contains("Square"));
        assertTrue(c1.toString().contains("Side"));
    }
}
