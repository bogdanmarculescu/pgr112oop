package org.pgr112.lesson8.shapes;

import java.awt.*;

public class Square extends Rectangle {
    public Square(double v) {
        super();
    }

    public Square() {

    }

    public Square(double v, Color darkGray, boolean b) {
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
