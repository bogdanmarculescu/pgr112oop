package org.pgr112.lesson9.shapes;

import java.awt.*;

public class Square extends Rectangle {

    public Square(){
        super(1.0, 1.0, Color.GREEN, true);
    }

    public Square(double side){
        super(side, side, Color.GREEN, true);
    }
    public Square(double side, Color color, boolean isFilled){
        super(side, side, color, isFilled);
    }

    @Override
    public double getArea(){
        System.out.println("This is the square implementation");
        return Math.pow(this.getLength(), 2);

    }

    public void getSquareOnly(){
        System.out.println("I'm a square");
    }

    public String toString(){
        return "Square:";
    }
}
