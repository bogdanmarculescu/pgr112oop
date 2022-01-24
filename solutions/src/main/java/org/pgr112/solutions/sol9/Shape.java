package org.pgr112.solutions.sol9;

import java.awt.*;

public abstract class Shape implements Movable{
    private Color color;
    private boolean isFilled;
    private final int id;

    public Shape(){
        this.color = Color.RED;
        this.isFilled = true;
        this.id = this.hashCode();
    }
    public Shape(Color color, boolean isFilled){
        this.color = color;
        this.isFilled = isFilled;
        this.id = this.hashCode();
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

    public int getId() {
        return id;
    }

    public String toString(){
        return "Shape. Color: " + this.color + ", filled: " + this.isFilled + "; \n";
    }
}
