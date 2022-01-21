package org.pgr112.lesson9.shapes;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeTest {

    @Test
    public void testShapeExample(){
        Circle c1 = new Circle(2, Color.BLUE, true);
        Square s1 = new Square(3, Color.GRAY, false);

        HashMap<String, Shape> shapes = new HashMap<>();
        shapes.put("Circle-1", c1);
        shapes.put("Square-1", s1);

        assertTrue(shapes.size()==2);
        assertTrue(shapes.containsKey("Circle-1"));
    }

    @Test
    public void compilePoly(){
        Square s1 = new Square();

        s1.getArea();
        s1.rectangleOnly();

        Rectangle r2 = new Square();
        r2.getArea();
    }

    public HashMap<String, Rectangle> initValues(){
        HashMap<String, Rectangle> hash = new HashMap<>();

        Rectangle example = new Rectangle(100, 100, Color.GREEN, true);
        example.setId(1);

        Square s1 = new Square(1.0);
        Square s2 = new Square(2.0);

        WeirdRhombus wr1 = new WeirdRhombus(2.0);
        WeirdRhombus wr2 = new WeirdRhombus(1.0);

        hash.put("key1", s1);
        hash.put("key2", s2);
        hash.put("key3", wr1);
        hash.put("key1", wr2);

        return hash;
    }

    @Test
    public void testDowncast(){
        HashMap<String, Rectangle> hash = initValues();

        Rectangle result = hash.get("key2");

        if(result instanceof Square){
            ((Square) result).getSquareOnly();
        }

        if(result instanceof WeirdRhombus){
            ((WeirdRhombus) result).getRhombusOnly();
        }

        //((WeirdRhombus) result).getRhombusOnly();
    }


}
