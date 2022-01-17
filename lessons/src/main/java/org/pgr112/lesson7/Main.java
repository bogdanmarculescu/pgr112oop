package org.pgr112.lesson7;

public class Main {
    public static void main(String[] args) {
        //Examples examples = new Examples();
        //examples.formatExamples();
        //Examples.saySomething();
        //examples.staticExample();
        //examples.inheritanceConstructorExample();

        /*
        Book b = new Book("1234567", "Markens grøde", "Knut Hamsun", 123);
        System.out.println(" Print state: ");
        b.printState();

        System.out.println("To string:");
        System.out.println(b.toString());

        System.out.println(" Print with formatting:");
        System.out.printf("Se denne nydelige boken:%s%n", b);

         */

        ParentClass parent = new ParentClass("parentString");
        //parent.fantasticMethod();
        ParentClass duplicateP = parent.duplicateObject();
        //duplicateP.fantasticMethod();

        MiddleClass middle = new MiddleClass("parentString", "middle");
        //middle.fantasticMethod();

        MiddleClass duplicateMiddle = middle.duplicateObject();
        //duplicateMiddle.fantasticMethod();

        System.out.println("-------");

        //parent.equals( duplicateP);

        System.out.println(parent.equals( (ParentClass) middle));
        //System.out.println(parent.equals((Object) duplicateP));
    }
}
