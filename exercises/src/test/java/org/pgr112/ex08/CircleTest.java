package org.pgr112.ex08;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    @Test
    public void testCircle1(){
        Circle c1 = new Circle();
        // Test inherited stuff
        assertEquals(Color.RED, c1.getColor());
        assertFalse(c1.isFilled());

        // Test circle specific stuff
        assertEquals(1.0, c1.getRadius());
        assertEquals(Math.PI, c1.getArea());
        assertEquals(Math.PI*2, c1.getPerimeter());
    }

    @Test
    public void testCircle3(){
        Circle c3 = new Circle(3.0, Color.BLUE, true);

        // Test inherited stuff
        assertEquals(Color.BLUE, c3.getColor());
        assertTrue(c3.isFilled());

        // Test Circle stuff
        assertEquals(3.0, c3.getRadius());
        assertEquals(Math.PI*9.0, c3.getArea());
        assertEquals(Math.PI*6.0, c3.getPerimeter());
    }

    @Test
    public void testNegativeRadius(){
        // This is a bit of a facetious code. Just for giggles.
        Circle cn = new Circle( -5.0);

        // Test inherited stuff
        assertEquals(Color.RED, cn.getColor());
        assertFalse(cn.isFilled());

        // Test circle stuff
        assertEquals(-5.0, cn.getRadius());
        assertEquals(-Math.PI*10.0, cn.getPerimeter());
        assertEquals(Math.PI*25.0, cn.getArea());
    }
}
