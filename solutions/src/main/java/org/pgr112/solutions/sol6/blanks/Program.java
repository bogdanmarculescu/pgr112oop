package org.pgr112.solutions.sol6.blanks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
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

    public void completeStory(String sourceFile, ArrayList<String> adjectives, String destinationFile){
        //int index = 0;
        Random rand = new Random();
        StringBuilder story = new StringBuilder();
        try{
            File file = new File(sourceFile);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){
                // An index can be used, if you don't want the adjectives randomly
                // But a bit of care must be taken not to end up out of bounds:
                // if(index >= adjectives.size()){
                //    System.out.println("Well, I'm out of ideas. But don't want to crash. So we'll start again, from the top.");
                //    index = 0;
                //}

                String lineToken = sc.nextLine();
                String[] tokens = lineToken.split(" ");
                StringBuilder modifiedLine = new StringBuilder();
                for(int i = 0; i<tokens.length; i++){
                    if(tokens[i].equalsIgnoreCase("__")){
                        // Random adjective?
                        int inde = rand.nextInt(adjectives.size());
                        tokens[i] = adjectives.get(inde);
                        //index++;
                    }
                    modifiedLine.append(tokens[i] +  " ");
                }
                story.append(modifiedLine.toString());
                story.append("\n");
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

        printStory(destinationFile, story.toString());
    }

    public ArrayList<String> addAdjectives (Scanner sc){
        String input = "";
        ArrayList<String> adj = new ArrayList<>();
        while(!input.contains("exit")){
            input = sc.nextLine();
            adj.add(input);
        }
        return adj;
    }

    public void autoStory(){
        String adjectivesFile = "solutions/src/main/resources/sol06/adjektiv.txt";
        String sourceFile = "solutions/src/main/resources/sol06/story.txt";

        // A fairly easy way to ensure a unique (for all practical purposes) file name
        // is to append the current time (in milliseconds).
        // Unless you create more than one file per millisecond, it should work well.
        String now = "" + System.currentTimeMillis();
        String destinationFile = "solutions/src/main/resources/sol06/story" + now + ".txt";

        adjectives = readAdjectives(adjectivesFile);
        completeStory(sourceFile, adjectives, destinationFile);
    }

    public void story(){
        String sourceFile = "solutions/src/main/resources/sol06/story.txt";
        String now = LocalDate.now().toString();
        String destinationFile = "solutions/src/main/resources/sol06/story" + now + ".txt";

        completeStory(sourceFile, adjectives, destinationFile);
    }

    public void printStory(String destinationFile, String story){
        try{
            FileWriter fw = new FileWriter(destinationFile);
            fw.write(story);
            fw.close(); // This necessary. This is where the writing takes.
        }
        catch (IOException ex){
            System.out.println("Well... something went wrong... Have a look:");
            ex.printStackTrace();
        }
    }

    public void printStory(String destinationFile, ArrayList<String> story){
        try{
            FileWriter fw = new FileWriter(destinationFile);
            for(String line : story){
                fw.write(line);
            }
            //fw.write(story);
            fw.close(); // This necessary. This is where the writing takes.
        }
        catch (IOException ex){
            System.out.println("Well... something went wrong... Have a look:");
            ex.printStackTrace();
        }
    }

    public void printMenu(){
        System.out.println("=== Menu ==");
        System.out.println(" 0 -> Display menu (i.e. this thing)");
        System.out.println(" 1 -> Fill story with adjectives automatically ");
        System.out.println(" 2 -> Fill story with your own adjectives");
        System.out.println(" 3 -> Exit ");
    }

    public void run(){
        this.printMenu();

        Scanner userInput = new Scanner(System.in);

        String choice = "0";

        while(!choice.equalsIgnoreCase("3")){
            choice = userInput.nextLine();
            switch (choice){
                case "0" -> {
                    System.out.println("Menu");
                    printMenu();
                }
                case "1" -> {
                    System.out.println("Auto");
                    autoStory();
                    printMenu();
                }
                case "2" -> {
                    System.out.println("Personalized. Enter adjectives. Type \"exit\" to stop the list.");
                    System.out.println("Note, right now I have " + adjectives.size() + " adjectives. Try to do better!");
                    this.adjectives = addAdjectives(userInput);
                    story();
                    printMenu();
                }
                case "3" -> System.out.println("Exiting");
                default -> {
                    System.out.println("Dunno that one, guv.");
                    printMenu();
                }
            }
        }
    }
}
