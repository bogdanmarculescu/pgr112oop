package org.pgr112.solutions.sol13;

import java.io.*;
import java.util.ArrayList;

public class ShapesDB {

    public static void main(String[] args) {
        ShapesDB db = new ShapesDB();

    }

    public ShapesDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
}
