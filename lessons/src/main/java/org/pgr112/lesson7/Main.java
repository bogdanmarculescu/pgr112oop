package org.pgr112.lesson7;

public class Main {
    public static void main(String[] args) {
        //Examples examples = new Examples();
        //examples.formatExamples();
        //Examples.saySomething();
        //examples.staticExample();
        //examples.inheritanceConstructorExample();

        Book b = new Book("1234567", "Markens grøde", "Knut Hamsun", 123);
        b.printState();
        System.out.println(b.toString());

        System.out.printf("Se denne nydelige boken:%s%n", b);
    }
}
