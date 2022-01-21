package org.pgr112.lesson9.shapes;

import java.awt.*;

public class WeirdRhombus extends Rectangle {
    public WeirdRhombus(){
        super(1.0, 1.0, Color.GREEN, true);
    }

    public WeirdRhombus(double side){
        super(side, side, Color.GREEN, true);
    }
    public WeirdRhombus(double side, Color color, boolean isFilled){
        super(side, side, color, isFilled);
    }
    public void getRhombusOnly(){
        System.out.println("I'm a rhombus, me");
    }
}
