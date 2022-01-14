package org.pgr112.lesson7;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AbstractShapeTest {

    private AbstractShape getShapeInstance(){
        return new Shape();
    }

    @Test
    void createShapeEmptyConstructor() {
        AbstractShape abstractShape = getShapeInstance();
        assertTrue(abstractShape.isFilled());
        assertEquals(Color.RED, abstractShape.getColor());
    }

    @Test
    void createShapeFullConstructor() {
        AbstractShape abstractShape = new Shape(Color.CYAN, false);
        assertFalse(abstractShape.isFilled());
        assertEquals(Color.CYAN, abstractShape.getColor());
    }
}