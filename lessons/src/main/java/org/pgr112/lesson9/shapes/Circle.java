package org.pgr112.lesson9.shapes;

import java.awt.*;

public class Circle extends Shape{

    private double radius;

    public Circle(){
        super();
        this.radius = 1.0;
    }

    public Circle(double radius){
        super();
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
