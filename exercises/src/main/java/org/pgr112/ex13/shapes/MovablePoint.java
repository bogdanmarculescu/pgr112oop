package org.pgr112.ex13.shapes;

public class MovablePoint implements Movable {
    // instance variables
    private double x, y;

    // Constructor
    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void moveUp(double distance) {
        y += distance; //move up along y axis
    }

    @Override
    public void moveDown(double distance) {
        y -= distance; // move down along y axis
    }

    @Override
    public void moveLeft(double distance) {
        x -= distance; //move left along x axis
    }

    @Override
    public void moveRight(double distance) {
        x += distance; //move right along x axis
    }

    @Override
    public String toString(){
        return "x is " + this.x + ", y is " + this.y;
    }
}
