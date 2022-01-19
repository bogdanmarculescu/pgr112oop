package org.pgr112.solutions.sol7;

import java.awt.Color;

public class Square extends Rectangle{

    public Square(){
        super(1.0, 1.0);
    }
    public Square(double side){
        super(side, side);
    }
    public Square(double side, Color color, boolean isFilled){
        super(side, side, color, isFilled);
    }

    public double getSide(){
        return this.getWidth();
    }

    public void setSide(double side){
        this.setWidth(side);
        this.setLength(side);
    }

    public String toString(){
        return "Square. Side: " + this.getSide() + "; " +
                "Color: " + this.getColor() + "; " +
                "filled: " + this.isFilled() + ";\n";
    }
}
