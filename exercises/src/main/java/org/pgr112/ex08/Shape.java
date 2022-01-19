package org.pgr112.ex08;

import java.awt.Color;

public class Shape {
    private Color color;
    private boolean isFilled;

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
}
