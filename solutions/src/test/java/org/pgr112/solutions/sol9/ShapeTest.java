package org.pgr112.solutions.sol9;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeTest {

    @Test
    public void task7(){
        Circle c1 = new Circle(2.0);
        Rectangle r1 = new Rectangle(2.0, 3.0);
        Square s1 = new Square(2.0);

        ArrayList<Shape> list = new ArrayList<>();
        list.add(c1);
        list.add(r1);
        list.add(s1);

        assertEquals(3, list.size());
    }

    @Test
    public void task8(){
        Shape s1 = new Circle(1, Color.PINK, true, new MovablePoint(0.0, 0.0));
        Shape s2 = new Circle(1.2, 0.0, 0.0, Color.PINK, true);
        Shape s3 = new Rectangle(1.3, 4.2);
        Shape s4 = new Square(1.6);

        String circleUnique = ((Circle) s1).uniqueCircleMethod();
        String rectangleUnique = ((Rectangle) s3).uniqueRectangleMethod();
        String squareUnique = ((Square) s4).uniqueSquareMethod();

        ArrayList<Shape> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        for(Shape sh : list){
            System.out.println(sh.toString() + "; Area: " + sh.getArea() + "; Perimeter: " + sh.getPerimeter());
            if(sh instanceof Circle){
                String currentS = ((Circle) sh).uniqueCircleMethod();
                assertTrue(circleUnique.equalsIgnoreCase(currentS));
            }
            if(sh instanceof Rectangle){
                String currentS = ((Rectangle) sh).uniqueRectangleMethod();
                assertTrue(rectangleUnique.equalsIgnoreCase(currentS));
            }
            if(sh instanceof Square){
                String currentS = ((Square) sh).uniqueSquareMethod();
                assertTrue(squareUnique.equalsIgnoreCase(currentS));
            }
        }

    }
}
