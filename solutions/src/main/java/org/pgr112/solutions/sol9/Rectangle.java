package org.pgr112.solutions.sol9;

import java.awt.*;

public class Rectangle extends Shape {
    private double width;
    private double length;

    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public Rectangle(){
        this.width = 1.0;
        this.length = 2.0;
        this.topLeft = new MovablePoint(0, 1);
        this.bottomRight = new MovablePoint(2,0);
    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
        this.setColor(Color.GREEN);
        // We'll assume the rectangle is horizontal
        this.topLeft = new MovablePoint(0, width);
        this.bottomRight = new MovablePoint(length,0);
    }
    public Rectangle(double width, double length, MovablePoint topLeft, MovablePoint bottomRight){
        this.width = width;
        this.length = length;
        // Let's check validity (Extra task 1, 2)
        // topLeft should be above and to the left of bottomRight

        boolean positionCheck = topLeft.getY() >= bottomRight.getY() // vertical check
                && topLeft.getX() <= bottomRight.getX(); // horizontal check


        boolean sideXCheck = (bottomRight.getX() - topLeft.getX()) == this.length ||
                (bottomRight.getX() - topLeft.getX()) == this.width;
        boolean sideYCheck = (topLeft.getY() - bottomRight.getY()) == this.length ||
                (topLeft.getY() - bottomRight.getY()) == this.width;


        if(positionCheck && sideXCheck && sideYCheck){
            // assign valid values
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }
        else{
            // invalid input. So add some sensible defaults
            this.topLeft = new MovablePoint(0, width);
            this.bottomRight = new MovablePoint(length,0);
        }


    }
    public Rectangle(double width, double length, Color color, boolean isFilled){
        this.width = width;
        this.length = length;
        this.setColor(color);
        this.setFilled(isFilled);
        this.topLeft = new MovablePoint(0, width);
        this.bottomRight = new MovablePoint(length,0);
    }

    public double getArea(){
        double result = this.length * this.width;
        return result;
    }

    public double getPerimeter(){
        double result = 2*(this.width + this.length);
        return result;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public MovablePoint getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(MovablePoint topLeft) {
        this.topLeft = topLeft;
    }

    public MovablePoint getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(MovablePoint bottomRight) {
        this.bottomRight = bottomRight;
    }

    public String toString(){
        return "Rectangle. Width: " + this.width + "; " +
                "Length: " + this.length + "; " +
                "Color: " + this.getColor() + "; " +
                "filled: " + this.isFilled() + ";\n";
    }

    @Override
    public void moveUp(double distance) {
        this.topLeft.moveUp(distance);
        this.bottomRight.moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        this.bottomRight.moveDown(distance);
        this.topLeft.moveDown(distance);
    }

    @Override
    public void moveRight(double distance) {
        this.topLeft.moveRight(distance);
        this.bottomRight.moveRight(distance);
    }

    @Override
    public void moveLeft(double distance) {
        this.bottomRight.moveLeft(distance);
        this.topLeft.moveLeft(distance);
    }

    public final String uniqueRectangleMethod(){
        System.out.println("I'm a rectangle, what of it?");
        return "rectangle";
    }
}
