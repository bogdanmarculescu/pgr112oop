package org.pgr112.solutions.sol7;

import java.awt.*;

public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(){
        this.width = 1.0;
        this.length = 2.0;
    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
        this.setColor(Color.GREEN);
    }
    public Rectangle(double width, double length, Color color, boolean isFilled){
        this.width = width;
        this.length = length;
        this.setColor(color);
        this.setFilled(isFilled);
    }

    public double getArea(){
        double result = this.length * this.width;
        return result;
    }

    public double getPerimeter(){
        double result = 2*(this.width + this.length);
        return result;
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
    public String toString(){
        return "Rectangle. Width: " + this.width + "; " +
                "Length: " + this.length + "; " +
                "Color: " + this.getColor() + "; " +
                "filled: " + this.isFilled() + ";\n";
    }
}
