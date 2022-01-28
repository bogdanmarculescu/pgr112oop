package org.pgr112.lesson11.gc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Per");
        // Nullifying the reference variable
        p = null;

        p = new Person("Lars");
        // Re-assigning the reference variable
        p = new Person("Mari");
        beautifulMethod();
        // The beautiful string is no longer referenced
    }

    private static void beautifulMethod() {
        String s = "Beautiful String";
        System.out.println(s);
    }

    public void someMethod(){
        try{
            File f = new File("somefile.txt");
            //Scanner s = new Scanner(new File("Somefile.txt"));
            Scanner s = new Scanner(f);
            FileWriter fw = new FileWriter("someotherfile.txt");
        }
        catch(FileNotFoundException ex){
            // maybe ask for the file name again
            ex.printStackTrace();
        }
        catch (IOException ioex){
            // couldn't write. Maybe try a different file
            ioex.printStackTrace();
        }
    }
}
