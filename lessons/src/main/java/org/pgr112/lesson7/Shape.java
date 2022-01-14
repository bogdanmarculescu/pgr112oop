package org.pgr112.lesson7;

import java.awt.*;

public class Shape extends AbstractShape {

    public Shape(){
        super();
    }

    public Shape(Color color, boolean filled){
        super();
    }

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
