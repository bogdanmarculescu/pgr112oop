package org.pgr112.lesson11.gc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Person p = new Person("Per");
        System.out.println(p.toString());
        // Nullifying the reference variable
        p = null;

        p = new Person("Lars");
        // Re-assigning the reference variable
        p = new Person("Mari");
        beautifulMethod();
        // The beautiful string is no longer referenced

        for(int i = 0; i < 10; i++){
            Person pf = new Person("For Insider");
            System.out.println(i);
            System.out.println(pf);
        }

        System.out.println("--- Some reference maintained ---");

        Person p1 = new Person("Bogdan");
        System.out.println("-- reassign Bogdan -- ");
        Person p2 = p1;

        int someInt = 42;

        intMethod(someInt);


        System.out.println("-- Outside the method: " + p1.hashCode());
        personMethod(p1);
        System.out.println("-- Back Outside: " + p1.hashCode());


        p1 = null;
        p2 = p1;
        // Beyond this point
        System.out.println(p2);


        System.out.println("Inline:" + inlineIf(42));
        System.out.println("Regular:" + regularIf(42));

    }

    public Person varExample(){
        var p1 = new Person("Variable person");
        Person p2 = null;
        p2 = new Person("Regular");

        return p1;
    }

    public static int inlineIf( int input){
        int b = (input >= 0) ? input : input*3;
        return b;
    }

    public static int regularIf(int input){
        int b = 0;
        if(input >= 0){
            b = input;
        }
        else {
            b = input*3;
        }
        return b;
    }



    private static void beautifulMethod() {
        String s = "Beautiful String";
        System.out.println(s);
    }

    public static int personMethod(Person p){
        System.out.println("-- Inside method: " + p.hashCode());
        p.setName("Renamed");
        System.out.println("-- Inside method (after rename): " + p.hashCode());
        return p.toString().hashCode();
    }

    public static int intMethod(int i){
        return i*10;
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
