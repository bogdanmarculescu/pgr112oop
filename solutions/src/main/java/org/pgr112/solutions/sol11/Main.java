package org.pgr112.solutions.sol11;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ShapeStorage storage = new ShapeFileStorage("solutions/src/main/resources/sol11/shapes.txt");
        try {
            Program program = new Program(storage);
            program.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
