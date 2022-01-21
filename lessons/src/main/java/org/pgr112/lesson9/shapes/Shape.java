package org.pgr112.lesson9.shapes;

import java.awt.*;

public abstract class Shape {
    private Color color;
    private boolean isFilled;
    private int id;

    public Shape(){
        this.color = Color.RED;
        this.isFilled = false;
    }

    public Shape(Color color, boolean isFilled){
        this.color = color;
        this.isFilled = isFilled;
    }

    public String toString(){
        return "Shape. Color: " + this.color + "; " +
                "isFilled: " + this.isFilled + "; ";
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
