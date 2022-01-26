package org.pgr112.lesson10.shapes;

import java.awt.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object s2){

        if(this == s2) return true;

        if(s2 == null || s2.getClass() != this.getClass()) return false;

        boolean equals = false;

        if(s2 instanceof Shape){
            Shape shape2 = (Shape) s2;
            equals = (this.id == shape2.id
                    && this.isFilled == shape2.isFilled
                    && this.color == shape2.color);
        }
        return equals;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, color, isFilled);
    }
}
