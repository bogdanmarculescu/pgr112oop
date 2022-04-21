package org.pgr112.solutions.sol14.shapes;

public class Rectangle extends Shape {

    private double width;
    private double length;
    /*
        We use aggregation to ensure a circle has a position.
        We need two points, one for topLeft and one for bottomRight.
     */
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public Rectangle() {
        super("BLUE", true);
        this.width = 0;
        this.length = 0;
        this.bottomRight = null;
        this.topLeft = null;
    }

    public Rectangle(double width, double length, String color, boolean filled,
                     MovablePoint topLeft, MovablePoint bottomRight) {

        super(color, filled);
        this.width = width;
        this.length = length;
        this.bottomRight = bottomRight;
        this.topLeft = topLeft;
    }

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Setter for width
    public void setWidth(double width) {
        this.width = width;
    }

    // Getter for length
    public double getLength() {
        return length;
    }

    // Setter for length
    public void setLength(double length) {
        this.length = length;
    }

    // Getter for topLeft
    public MovablePoint getTopLeft() {
        return topLeft;
    }

    // Setter for topLeft
    public void setTopLeft(MovablePoint topLeft) {
        this.topLeft = topLeft;
    }

    // Getter for bottomRight
    public MovablePoint getBottomRight() {
        return bottomRight;
    }

    // Setter for bottomRight
    public void setBottomRight(MovablePoint bottomRight) {
        this.bottomRight = bottomRight;
    }

    /*
            We override the abstract method getArea in Shape.
            If we do not do this, this class (Rectangle) must be abstract as we are missing
            implementation details for an abstract method defined in class Shape.
        */
    public double getArea() {
        return length * width;
    }

    /*
        We override the abstract method getPerimeter in Shape.
        If we do not do this, this class (Rectangle) must be abstract as we are missing
        implementation details for an abstract method defined in class Shape.
    */
    public double getPerimeter() {
        return 2 * (length + width);
    }

    /*
        We override a method from the Object class.
        Remember that all classes inherit from the Object class.
        It is normal to override this method as the method
        inherited from Object provides little information.
     */
    public String toString() {
        return "A Rectangle with width = " + width + " and length = " +
                length + ", topLeft: " + topLeft + ", bottomRight: " +
                bottomRight + " which is a subclass of " + super.toString();
    }

    @Override
    public void moveUp(double distance) {
        topLeft.moveUp(distance);
        bottomRight.moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        topLeft.moveDown(distance);
        bottomRight.moveDown(distance);
    }

    @Override
    public void moveLeft(double distance) {
        topLeft.moveLeft(distance);
        bottomRight.moveLeft(distance);
    }

    @Override
    public void moveRight(double distance) {
        topLeft.moveRight(distance);
        bottomRight.moveRight(distance);
    }

}