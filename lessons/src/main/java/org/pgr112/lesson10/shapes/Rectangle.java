package org.pgr112.lesson10.shapes;

import java.awt.*;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(){
        this.width = 1.0;
        this.length = 2.0;
    }

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public Rectangle(double length, double width, Color color, boolean isFilled){
        super(color, isFilled);
        this.length = length;
        this.width = width;
    }

    public double getArea(){
        System.out.println("this is the rectangle implementation");
        return this.width*this.length;
    }

    public double getPerimeter(){
        return 2*(this.width + this.length);
    }

    public String toString(){
        return "Rectangle: ";
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void rectangleOnly(){
        System.out.println("Only me");
    }
}
