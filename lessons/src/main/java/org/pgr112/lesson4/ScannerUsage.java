package org.pgr112.lesson4;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerUsage {

    public static void main(String[] args){

        ThingDoer doer = new ThingDoer();
        ArrayList<String> menu = new ArrayList<>();


        menu.add("Do a cool thing");
        menu.add("Do a cooler thing");
        menu.add("Do nothing");
        menu.add("Exit");

        for(int i = 0; i< menu.size(); i++){
            System.out.println("" + i + " -> " + menu.get(i) + " : press " + i);
        }

        Scanner input = new Scanner(System.in);

        //int choice = input.nextInt();

        // Input sanitizing

        String userInput = input.next();

        int choice = -1;

        try {
            choice = Integer.parseInt(userInput);
        }
        catch (NumberFormatException exception){
            System.out.println("No, that's not what I meant! Try Again!");
        }

        while(choice!=3){
            switch (choice){
                case 0: {
                    System.out.println(doer.thing());
                    break;
                }
                case 1: {
                    System.out.println(doer.coolerThing());
                    break;
                }
                case 2: {
                    System.out.println(doer.doNothing());
                    break;
                }
                default: {
                    System.out.println("Dunno that; Try Again");
                    break;
                }
            }
            choice = input.nextInt();
        }

        /*
        while(!choice.equals("3")){
            if(choice.equals("0")){
                System.out.println(doer.thing());
            }
            else if (choice.equals("1")){
                System.out.println(doer.coolerThing());
            }
            else if (choice.equals("2")){
                System.out.println(doer.doNothing());
            }
            else {
                System.out.println("I don't know that");
            }
            choice = input.next();
        }
        */

        input.close();
        System.out.println(doer.exit());

    }


}

