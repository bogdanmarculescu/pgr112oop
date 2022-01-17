package org.pgr112.ex07;

import java.awt.Color;

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
