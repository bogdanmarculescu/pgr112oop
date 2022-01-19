package org.pgr112.solutions.sol7;

import java.awt.Color;

public class Circle extends Shape{
    private double radius;

    public Circle(){
        radius = 1.0;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, Color color, boolean isFilled){
        super(color, isFilled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        double result = Math.PI * Math.pow(this.radius, 2) ; // Area: pi * r^2
        return result;
    }
    public double getPerimeter(){
        double result = 2 * Math.PI * this.radius; // Perimeter: 2 * pi * r
        return result;
    }
    public String toString(){
        return "Circle. Radius: " + this.radius + "; " +
                "Color: " + this.getColor() + "; " +
                "filled: " + this.isFilled() + "; \n";
    }
}
