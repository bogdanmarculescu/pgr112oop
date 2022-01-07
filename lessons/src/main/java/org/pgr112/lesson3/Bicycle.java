package org.pgr112.lesson3;

public class Bicycle {

    int speed = 0;
    int gear = 1;

    void changeGear(int newValue) {
        gear = newValue;
    }

    void speedUp(int increment) {
        speed = speed + increment;
    }

    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }

    void printStats() {
        System.out.println("Speed:" +
                speed + " gear:" + gear);
    }
}
