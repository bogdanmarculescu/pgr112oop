package org.pgr112.solutions.sol14.shapes;

public class Circle extends Shape {

    private double radius;
    // We use aggregation to ensure a circle has a position
    private MovablePoint center;

    public Circle(){
        this.radius = 1.0;
        this.center = new MovablePoint();
    }
    //Getter for radius
    public double getRadius() {
        return radius;
    }

    //Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //Getter for center
    public MovablePoint getCenter() {
        return center;
    }

    //Setter for center
    public void setCenter(MovablePoint center) {
        this.center = center;
    }

    /*
            We override the abstract method getArea in Shape.
            If we do not do this, this class (Circle) must be abstract as we are missing
            implementation details for an abstract method defined in class Shape.
         */
    @Override
    public double getArea() {
        return (radius*radius)*Math.PI;
    }

    /*
        We override the abstract method getPerimeter in Shape.
        If we do not do this, this class (Circle) must be abstract as we are missing
        implementation details for an abstract method defined in class Shape.
     */
    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    /*
        We override a method from the Object class.
        Remember that all classes inherit from the Object class.
        It is normal to override this method as the method
        inherited from Object provides little information.
     */
    @Override
    public String toString() {
        // Using the String class static method "format" as an alternative string concatenation.
        return String.format("A Circle with radius = %s and center=%s, which is a subclass of %s",
                radius, center, super.toString()); // Look! I can call my parent version of toString:)
    }

    /*
        Look how easy it is to move the circle!
        We can delegate the job using our reference to our MovablePoint (center)
        available as one of our fields.
     */
    @Override
    public void moveUp(double distance) {
        center.moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        center.moveDown(distance);
    }

    @Override
    public void moveLeft(double distance) {
        center.moveLeft(distance);
    }

    @Override
    public void moveRight(double distance) {
        center.moveRight(distance);
    }

}