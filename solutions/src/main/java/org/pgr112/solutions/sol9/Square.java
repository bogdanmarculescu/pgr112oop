package org.pgr112.solutions.sol9;

import java.awt.*;

public class Square extends Rectangle {


    public Square(){
        super(1.0, 1.0);
        this.setTopLeft(new MovablePoint(0, 1));
        this.setBottomRight(new MovablePoint(1,0));
    }
    public Square(double side){
        super(side, side);
        this.setTopLeft(new MovablePoint(0, side));
        this.setBottomRight(new MovablePoint(side,0));
    }
    public Square(double side, Color color, boolean isFilled){
        super(side, side, color, isFilled);
        this.setTopLeft(new MovablePoint(0, side));
        this.setBottomRight(new MovablePoint(side,0));
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

    public String uniqueSquareMethod(){
        System.out.println("I'm a proper square");
        return "square";
    }
}
