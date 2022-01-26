package org.pgr112.lesson10.shapes;

import java.awt.*;

public class Circle extends Shape {

    private double radius;

    public Circle(){
        super();
        this.radius = 1.0;
    }

    /***
     * Constructor for a Circle, that takes radius as input.
     * Note: if rad is < 0, it will throw a IllegalArgumentException.
     * @param rad = radius of the circle to be created.
     */
    public Circle(double rad){
        super();
        if(rad < 0){
            System.out.println("Not right");
            // default value
            // this.radius = Math.abs(rad);
            throw new IllegalArgumentException("Can't do that , guv.");
        }
        this.radius = radius;
    }
    public Circle(double radius, Color color, boolean isFilled){
        super(color, isFilled);
        this.radius = radius;
    }

    public double getArea(){
        // Area of a circle: Pi * r^2
        double rsquare = Math.pow(this.radius, 2);
        return (Math.PI * rsquare);
    }

    public double getPerimeter(){
        // Perimeter of a circle: 2 * Pi * r
        return (2.0 * Math.PI * this.radius);
    }

    public String toString(){
        return "Circle: " +
                "Radius: " + this.radius + "; " +
                "Color: " + this.getColor() + "; " +
                "isFilled: " + this.isFilled() + "; ";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
