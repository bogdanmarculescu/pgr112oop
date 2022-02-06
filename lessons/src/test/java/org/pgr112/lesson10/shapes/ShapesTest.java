package org.pgr112.lesson10.shapes;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ShapesTest {

    @Test
    public void simpleTest(){
        Circle c1 = new Circle();
        Rectangle r1 = new Rectangle();

        assertTrue(!c1.equals(r1));
    }

    @Test
    public void simpleSetTest(){
        HashSet<Shape> shapes = new HashSet<>();

        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Rectangle r1 = new Rectangle();

        shapes.add(c1);
        shapes.add(c2);
        shapes.add(r1);

        assertEquals(2, shapes.size());

        shapes.remove(c2);

        assertFalse(shapes.contains(c1));
        assertTrue(shapes.contains(r1));

    }

    @Test
    public void testOptional(){
        Square s1 = new Square();
        Square s2;
        Square s3 = null;
        Optional<Square> s4 = Square.randomSquare();

        if(s4.isPresent()){
            // do a bunch of stuff with s4
            System.out.println(s4.toString());
        }
        if(s4.isEmpty()){
            System.out.println("it's empty, guv.");
        }
    }

    @Test
    public void testInputValidation(){

        // An example of asserting an exception is thrown
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Circle c1 = new Circle(-42.0);
        });

        String expectedMessage = "guv";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
