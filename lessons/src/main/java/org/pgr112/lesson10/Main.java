package org.pgr112.lesson10;

import org.pgr112.lesson8.shapes.AbstractShape;
import org.pgr112.lesson8.shapes.Circle;
import org.pgr112.lesson8.shapes.Rectangle;
import org.pgr112.lesson8.shapes.Square;
import org.pgr112.solutions.sol7.EquilateralTriangle;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args){

        // 1st way to get Java to be random
        double rand = Math.random(); // rand is going between 0 and 1.
        double dieRoll = rand * 6; // 0 and 1

        // 2nd way to get Java to be random
        Random randGen = new Random();
        int dieRoll2 = 1 + randGen.nextInt(6);

        System.out.println("Blue: " + new Color(123, 42, 13));
        System.out.println("Green: " + Color.GREEN);
        System.out.println("Yellow: " + Color.YELLOW);

        // Discussions on HashMap, and hashCode

        System.out.println("Rand: " + randGen.hashCode());


        if(dieRoll2 == 1){
            System.out.println("Tough luck!");
        }

        String s = "Some string";

        HashMap<SomeAuxRubbish, Random> weird = new HashMap<>();

        if(s.equalsIgnoreCase("soMe sTrIng")){
            SomeAuxRubbish currentKey = new SomeAuxRubbish();
            weird.put(currentKey, new Random() ); // THis is just for display purposes.
            // I don't know why anyone would want to do this.
        }


    }

    public void aMethod(){
        HashMap<Integer, AbstractShape> myHash = new HashMap<>();

        Circle c1 = new Circle();
        Circle c2 = new Circle(2.0);

        myHash.put(1, c1);
        myHash.put(42, c2);
        //myHash.put(2, new EquilateralTriangle());
        myHash.put(3, new Rectangle());
        myHash.put(4, new Square(42));

        for (Integer i : myHash.keySet()) {
            System.out.println("Key: " + i + ", " + " Value: " + myHash.get(i));
        }
        System.out.println(myHash.get(3));
    }
}

class SomeAuxRubbish{

}
