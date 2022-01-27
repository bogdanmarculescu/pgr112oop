package org.pgr112.lesson11.gc;

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
}
