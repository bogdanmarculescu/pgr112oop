package org.pgr112.solutions.sol4;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public void runProgram(){
        System.out.println("Program Starting...");
    }

    public void task4(){
        Scanner inputs = new Scanner(System.in);
        ArrayList<String> inputValues = new ArrayList<>();
        System.out.println("I'm waiting for 3 inputs:");

        for(int i=0; i<3; i++){
            inputValues.add(i, inputs.next());
        }

        System.out.println(" --- Values --- ");
        for(String s : inputValues){
            System.out.println(s);
        }
    }

    public void task6(){
        System.out.println("Input numbers (negative number will stop the sequence):");
        Scanner inputs = new Scanner(System.in);

        int input = inputs.nextInt();
        int sum = 0;

        while(input >= 0){
            sum += input;
            input = inputs.nextInt();
        }

        System.out.println(sum);

    }

    public void task7(){
        displayMenu();

        Scanner inputs = new Scanner(System.in);
        String input = inputs.next();
        ArrayList<String> stringsSoFar = new ArrayList<>();

        while(!input.equals("2")){
            if(input.equals("0")){
                // add new string
                System.out.println("New word to add:");
                stringsSoFar.add(inputs.next());
            }
            else if(input.equals("1")){
                // display all strings
                System.out.println("Strings so far: ->");
                for (String s : stringsSoFar){
                    System.out.println(s);
                }
            }
            else{
                System.out.println("I don't know that.");
            }
            displayMenu();
            input = inputs.next();
        }
    }

    public void displayMenu(){
        // I'm mostly putting the menu in an array list because I don't want to make changes manually

        ArrayList<String> menu = new ArrayList<>();
        menu.add("Add single word");
        menu.add("Display all words");
        menu.add("Exit");

        for (int i = 0; i < menu.size(); i++){
            System.out.println("" + i + " -> " + menu.get(i));
        }
    }
}
