package org.pgr112.lesson11.valuereference;

import org.pgr112.lesson11.gc.Person;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Lars");
        System.out.println("Person object before method call:"+p);
        changePerson(p);
        System.out.println("Person object after method call:"+p);

        int number = 0;
        System.out.println("Number before method call:"+number);
        changeInt(number);
        System.out.println("Number after method call:"+number);


        String string = "Wow, the greatest String I have ever seen!";
        System.out.println("string object before method call:"+string);
        changeString(string);
        System.out.println("string object after method call:"+string);


        p = new Person("Lars");
        System.out.println("Person object before revisited method call:"+p);
        changePersonRevisited(p);
        System.out.println("Person object after revisited method call:"+p);

    }

    private static void changePerson(Person p) {
        p.setName("Per");
    }

    private static void changeInt(int i) {
        i+=100;
        System.out.println("In changeInt method. I is now:"+i);
    }

    private static void changeString(String s) {
        s+=" Are you sure? I have seen better!";
        System.out.println("In changeString method. s is now:"+s);
    }

    private static void changePersonRevisited(Person p) {
        p = new Person("Per");
        System.out.println("In revisited change person method. p is now:"+p);
    }
}
