package org.pgr112.solutions.sol6.blanks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public ArrayList<String> adjectives;
    public final String DEFAULT_FILE = "solutions/src/main/resources/sol06/adjektiv.txt";

    public Program(){
        this.adjectives = readAdjectives(DEFAULT_FILE);
    }

    public Program(String fileName){
        this.adjectives = readAdjectives(fileName);
    }

    public ArrayList<String> readAdjectives(String fileName){
        ArrayList<String> result = new ArrayList<>();
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                result.add(sc.nextLine());
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        return result;
    }

    public void printMenu(){
        System.out.println("=== Menu ==");
        System.out.println(" 1 -> Fill story with adjectives automatically ");
        System.out.println(" 2 -> Fill story with your own adjectives");
        System.out.println(" 3 -> Exit ");
    }

    public void run(){
        this.printMenu();

        Scanner userInput = new Scanner(System.in);

        String choice = "0";

        while(!choice.equalsIgnoreCase("3")){

        }
    }
}
