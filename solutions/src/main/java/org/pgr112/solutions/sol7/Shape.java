package org.pgr112.solutions.sol7;

import java.awt.Color;

public class Shape {
    private Color color;
    private boolean isFilled;

    public Shape(){
        this.color = Color.RED;
        this.isFilled = true;
    }
    public Shape(Color color, boolean isFilled){
        this.color = color;
        this.isFilled = isFilled;
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

    public String toString(){
        return "Shape. Color: " + this.color + ", filled: " + this.isFilled + "; \n";
    }
}
