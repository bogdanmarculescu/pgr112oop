package org.pgr112.solutions.sol9;

import java.awt.*;

public class Circle extends Shape {
    private double radius;
    private MovablePoint center;

    public Circle(){
        this.radius = 1.0;
        this.center = new MovablePoint(0, 0);

    }
    public Circle(double radius){
        this.radius = radius;
        this.center = new MovablePoint(0, 0);
    }
    public Circle(double radius, double x, double y, Color color, boolean isFilled){
        super(color, isFilled);
        this.radius = radius;
        this.center = new MovablePoint(x, y);
    }
    public Circle(double radius, double x, double y){
        this.radius = radius;
        this.center = new MovablePoint(x, y);
    }
    public Circle(double radius, Color color, boolean isFilled, MovablePoint p){
        super(color, isFilled);
        this.radius = radius;
        this.center = p;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }
    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }
    public String toString(){
        return "Circle. Radius: " + this.radius + "; " +
                "Color: " + this.getColor() + "; " +
                "filled: " + this.isFilled() + "; \n";
    }

    public MovablePoint getCenter() {
        return center;
    }

    public void setCenter(MovablePoint center) {
        this.center = center;
    }

    @Override
    public void moveUp(double distance) {
        this.center.moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        this.center.moveDown(distance);
    }

    @Override
    public void moveRight(double distance) {
        this.center.moveRight(distance);
    }

    @Override
    public void moveLeft(double distance) {
        this.center.moveLeft(distance);
    }

    public String uniqueCircleMethod(){
        System.out.println("I'm a circle!!");
        return "circle";
    }
}
