package org.pgr112.lesson4;

import java.util.ArrayList;
import java.util.Scanner;

public class Examples {
    public void start() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while(choice!=3){
            System.out.println("Velg et tall, 1=Noe, 2=Noe annet, 3=Avslutt");
            choice = input.nextInt();
            if(choice==1){
                doSomething();
            } else if(choice == 2){
                doSomethingElse();
            } else if(choice==3){
                sayGoodBye();
            }
        }
        ArrayList<Character> list = new ArrayList<Character>();
    }

    private void sayGoodBye() {
        System.out.println("Ha det!");
    }

    private void doSomethingElse() {
        System.out.println("I do something else");
    }

    private void doSomething() {
        System.out.println("I do something");
    }

}
