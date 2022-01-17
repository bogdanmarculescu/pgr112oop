package org.pgr112.ex07;

import java.awt.Color;

public abstract class AbstractShape {

    private boolean isFilled;
    protected Color color;

    public abstract boolean isFilled();

    public abstract Color getColor();
}
