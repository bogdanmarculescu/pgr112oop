package org.pgr112.lesson10.shapes;

import java.util.HashSet;

public class SomeOther {

    private HashSet<Shape> shapes;
    private HashSet<Rectangle> rectangles;

    public SomeOther(){
        shapes = new HashSet<>();
        rectangles = new HashSet<>();
        initShapes();
    }

    public void initShapes(){
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle();

        boolean add1 = shapes.add(c1);
        boolean add2 = shapes.add(c2);

        System.out.println("Are they equal? - " + c1.equals(c2));

        //Reflexive
        boolean reflexive = c1.equals(c1);

        // Symmetric
        boolean sym = (c1.equals(c2) == c2.equals(c1));

        //Transitive

        boolean transitive = ((c1.equals(c2) && c2.equals(c3)) == c1.equals(c3));

        // Consistent
        boolean run1 = c1.equals(c2);
        boolean run2 = c1.equals(c2);

        int c1hash = c1.hashCode();
        int c2hash = c2.hashCode();
        int c3hash = c3.hashCode();

        System.out.println("Added c1: " + add1);
        System.out.println("Added c2: " + add2);
    }

    public static void main(String[] args){
        SomeOther so = new SomeOther();

    }

}
