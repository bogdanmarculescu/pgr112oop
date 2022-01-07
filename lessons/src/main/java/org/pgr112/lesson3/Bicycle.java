package org.pgr112.lesson3;

public class Bicycle {

    int speed = 0;
    private int gear = 1;
    Color color = Color.RED;

    public Bicycle(int speed, int gear){
        this.speed = speed;
        if(gear <= 0){
            this.gear = 1;
        }
        else {
            this.gear = gear;
        }
        //System.out.println("Now building:");
        //this.printStats();
    }

    public Bicycle(int s){
        speed = s;
        gear = 1;
    }

    public Bicycle(){
        speed = 0;
        gear = 1;
    }

    void changeGear(int newValue) {
        if(newValue <= 0){
            gear = 1;
        }
        else {
            gear = newValue;
        }
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

    public int getGear() {
        return gear;
    }

    private void setGear(int gear) {
        this.gear = gear;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

enum Color{
    BLUE, GREEN, PURPLE, YELLOW, RED
}
