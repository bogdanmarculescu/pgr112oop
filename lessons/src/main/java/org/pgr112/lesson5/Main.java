package org.pgr112.lesson5;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //System.out.println("In the beginning of main");
        //NullExample ne = new NullExample();
        //ne.trickyNull();
        //new Kahoot().run();
        //System.out.println("main done:)");

        CallStackExample callStack = new CallStackExample();
        callStack.run();
    }
}
