package org.pgr112.lesson7;

import java.awt.*;

public class Shape extends AbstractShape {

    public Shape(){
        super();
    }

    public Shape(Color color, boolean filled){
        super();
        this.color = color;
        this.isFilled = filled;
    }

    @Override
    public boolean isFilled() {
        return this.isFilled;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
