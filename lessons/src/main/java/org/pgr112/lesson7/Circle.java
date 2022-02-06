package org.pgr112.lesson7;

import java.awt.*;

public class Circle extends AbstractShape{
    protected double radius;
    public Circle(double v) {
        super();
        this.radius = v;
        this.isFilled = true;
        this.color = Color.RED;
    }

    public Circle() {
        super();
        this.radius = 1.0;
        this.isFilled = true;
        this.color = Color.RED;
    }

    @Override
    public boolean isFilled() {
        return isFilled;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public double getRadius(){
        return radius;
    }

    public double getPerimeter(){
        return 2* Math.PI * radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }
}
