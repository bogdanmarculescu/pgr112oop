package org.pgr112.lesson7;

import java.time.LocalDate;

public class Examples {

    static int intFIeld = 2;

    public void formatExamples(){
        String name = "Per";
        String artist = "Tix";
        String formattedText = String.format("%1$s digger %2$s, eller hva, %1$s?", name, artist);
        System.out.println(formattedText);

        LocalDate now = LocalDate.now();
        String formattedText2 = String.format("I dag er det %tA!", now);
        System.out.println(formattedText2);

        String formattedText3 = String.format(
                "%1$tA %1$te. %1$tB %1$tY", now);
        System.out.println(formattedText3);

        System.out.println("Jeg må ikke referere til argumentets plassering:");
        System.out.printf("%s digger %s!%n", name, artist);
        System.out.println(name + " digger " + artist + "!");
    }

    public static void saySomething(){
        System.out.println("Wow! This is a great number:"+intFIeld);
    }

    public void staticExample(){
        MyClass myClass1 = new MyClass(1);
        MyClass myClass2 = new MyClass(2);

        System.out.println("MyClass.getStaticValue()"+MyClass.getStaticValue());
        System.out.println("Sum, myClass1:" + myClass1.getSum());
        System.out.println("Sum, myClass2:" + myClass2.getSum());
        System.out.println("Changing static value to 5");
        MyClass.setStaticValue(5);
        System.out.println("New sum, myClass1:" + myClass1.getSum());
        System.out.println("New sum, myClass2:" + myClass2.getSum());
    }

    public void inheritanceConstructorExample(){
        System.out.println("Oppretter parent med tom konstruktør:");
        ParentClass parentClass1 = new ParentClass();
        parentClass1.printState();
        System.out.println();
        System.out.println("Oppretter parent med string=Parent:");
        ParentClass parentClass2 = new ParentClass("Parent");
        parentClass2.printState();
        System.out.println();
        System.out.println("Oppretter middle med tom konstruktør:");
        MiddleClass middleClass1 = new MiddleClass();
        middleClass1.printState();
        System.out.println();
        System.out.println("Oppretter middle med string=Middle:");
        MiddleClass middleClass2 = new MiddleClass("Middle");
        middleClass2.printState();
        System.out.println();
        System.out.println("Oppretter middle med string=Parent og string=Middle:");
        MiddleClass middleClass3 = new MiddleClass("Parent", "Middle");
        middleClass3.printState();
        /*
        SubClass subclass1 = new SubClass();
        subclass1.printSubClassState();
        SubClass subclass2 = new SubClass("Sub");
        subclass2.printSubClassState();
        SubClass subclass3 = new SubClass("Middle", "Sub");
        subclass3.printSubClassState();
        SubClass subclass4 = new SubClass("Parent", "Middle", "Sub");
        subclass4.printSubClassState();
         */
    }
}
