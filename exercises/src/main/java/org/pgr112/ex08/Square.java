package org.pgr112.ex08;

import java.awt.*;

public class Square extends Rectangle{

    public Square(){
        super(1.0, 1.0, Color.GREEN, true);
    }

    public Square(double side){
        super(side, side, Color.GREEN, true);
    }
    public Square(double side, Color color, boolean isFilled){
        super(side, side, color, isFilled);
    }

    public String toString(){
        return "String:";
    }
}
