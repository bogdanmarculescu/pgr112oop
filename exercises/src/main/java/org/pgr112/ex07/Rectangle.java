package org.pgr112.ex07;

import java.awt.Color;

public class Rectangle extends AbstractShape {

    public Rectangle(){
        super();
    }
    public Rectangle(double width, double length){
        super();
    }

    public Rectangle(double v, double v1, Color blue, boolean b) {
        super();
    }

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public Color getColor() {
        return null;
    }

    public double getLength(){
        return 0.0;
    }

    public double getWidth(){
        return 0.0;
    }

    public double getArea(){
        return 0.0;
    }

    public double getPerimeter(){
        return 0.0;
    }
}
