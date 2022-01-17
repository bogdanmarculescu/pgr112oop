package org.pgr112.ex07;

import java.awt.Color;

public class Circle extends AbstractShape {
    public Circle(double v) {
        super();
    }

    public Circle() {

    }

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public Color getColor() {
        return null;
    }

    public double getRadius(){
        return 0.0;
    }

    public double getPerimeter(){
        return 0.0;
    }

    public double getArea(){
        return 0.0;
    }
}
