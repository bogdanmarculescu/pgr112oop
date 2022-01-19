package org.pgr112.solutions.sol7;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    @Test
    public void testBasicShape(){
        Shape sh = new Shape();

        assertTrue(sh.isFilled());
        assertEquals(Color.RED, sh.getColor());

        Shape sh2 = new Shape(Color.BLUE, false);
        assertFalse(sh2.isFilled());
        assertEquals(Color.BLUE, sh2.getColor());
    }

    @Test
    public void testToString(){
        Shape sh = new Shape();
        assertTrue(sh.toString().contains("Shape"));
    }
}
