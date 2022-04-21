package org.pgr112.solutions.sol14.shapes;

import org.pgr112.solutions.sol9.Movable;

public class MovablePoint implements Movable {

    private int id;
    private double x;
    private double y;

    public MovablePoint(){
        this.x = 0.0;
        this.y = 0.0;
        this.id = 0;
    }

    public MovablePoint(double x, double y){
        this.x = x;
        this.y = y;

        // Just some way to create an id based on the
        // values, to reduce duplicates.
        this.id = (int) ((100_000 * x) + (1000 * y));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        this.id = (int) ((100_000 * x) + (1000 * y));
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        this.id = (int) ((100_000 * x) + (1000 * y));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void moveUp(double distance) {
        y += distance;
    }

    @Override
    public void moveDown(double distance) {
        y -= distance;
    }

    @Override
    public void moveRight(double distance) {
        x += distance;
    }

    @Override
    public void moveLeft(double distance) {
        x -= distance;
    }

    public String toString(){
        return "Point; (x=" + this.x + "; y=" + this.y +").";
    }
}
