package org.pgr112.solutions.sol8;

import java.awt.*;

public class EquilateralTriangle extends Shape {
    public double side;

    public EquilateralTriangle(){
        super();
        this.side = 1.0;
    }

    public EquilateralTriangle(double side){
        this.side = side;
    }

    public EquilateralTriangle(double side, Color color, boolean isFilled){
        super(color, isFilled);
        this.side = side;
    }

    public double getPerimeter(){
        return 3.0 * this.side;
    }

    public double getArea(){

        // Triangle area: A = sqrt( s * (s-a) * (s-b) * (s-c))
        // where s is the semiperimeter.

        double semiperimeter = 1.5 * this.side;
        double area = Math.sqrt( semiperimeter *
                Math.pow((semiperimeter - this.side), 3) );
        return area;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public String toString(){
        return "Equilateral Triangle: " +
                "Side: " + this.side + "; " +
                "Color: " + this.getColor() + "; " +
                "filled: " + this.isFilled() + ";\n";
    }
}
