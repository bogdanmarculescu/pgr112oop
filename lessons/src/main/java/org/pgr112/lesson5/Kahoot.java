package org.pgr112.lesson5;

public class Kahoot {
    public void run(){
        try {
            int[] ints = new int[3];
            ints[3] = 1;
            System.out.print("Karantene");
        }catch (ArrayIndexOutOfBoundsException ae){
            System.out.print("Musikk");
        }
        finally {
            System.out.print("Hockey");
        }
        System.out.print("Skjerm");
    }
}
