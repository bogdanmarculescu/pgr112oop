package org.pgr112.lesson7;

import java.awt.*;

public abstract class AbstractShape {

    protected boolean isFilled = true;
    protected Color color;

    public abstract boolean isFilled();

    public abstract Color getColor();

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
