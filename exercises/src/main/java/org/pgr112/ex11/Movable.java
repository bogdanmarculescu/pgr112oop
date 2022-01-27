package org.pgr112.ex11;

/*
    If a class would like to call themselves Movable,
    they need to implement the methods in this interface.
    How they implement it is up to them.
    No need of access modifiers for the methods. They are all public anyhow.
 */
public interface Movable {
    //abstract method to move up
    void moveUp(double distance);

    //abstract method to move down
    void moveDown(double distance);

    //abstract method to move left
    void moveLeft(double distance);

    //abstract method to move right
    void moveRight(double distance);
}
