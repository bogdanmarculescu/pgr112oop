package org.pgr112.lesson8.shapes;

import java.awt.*;

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
