package org.pgr112.lesson8.shapes;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    void testHashMap(){
        HashMap<String, AbstractShape> myMap = new HashMap<>();
        ArrayList<AbstractShape> shapeArrayList = new ArrayList<>();

        Circle c1 = new Circle();
        Rectangle r1 = new Rectangle();
        Square s1 = new Square();


        myMap.put("default circle", c1);
        myMap.put("default square", s1);

        shapeArrayList.add(c1);

        assertTrue(myMap.isEmpty() == false);
        assertTrue(myMap.size() == 2);

        String s = "pgr112";
        s += " - I mean OOP";


    }

    @Test
    public void testPerimeter(){
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(1.0, 2.0);

        r1.getPerimeter();
        r2.getPerimeter();
    }
}