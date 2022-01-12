package org.pgr112.lesson5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //System.out.println("In the beginning of main");
        //NullExample ne = new NullExample();
        //ne.trickyNull();
        //new Kahoot().run();
        //System.out.println("main done:)");
        //String path = "lessons/src/main/java/org/pgr112/lesson5/eksempel.txt";
        //fileReaderExample(path);

        fileWriterExample();

    }

    public static void fileReaderExample(String path){
        FileReaderExample readerExample = new FileReaderExample();
        ArrayList<String> fileContents = new ArrayList<>();
        try {
            fileContents = readerExample.readFile(path);
        }
        catch(FileNotFoundException fileNotFound){
            System.out.println("Oh no! An exception!");
            System.out.println(fileNotFound.getMessage());
        }
        System.out.println("Let's have another look at the contents, using an ArrayList.");

        for(String line : fileContents){
            System.out.println(line);
        }
    }

    public static void fileWriterExample(){
        FileWriterExample fileWriter = new FileWriterExample();
        String fileName = "lessons/src/main/java/org/pgr112/lesson5/exampleWrite.txt";
        ArrayList<String> content = new ArrayList<>();

        content.add("We've learned loops");
        content.add("We've learned objects");
        content.add("and now we know about exceptions and reading/writing!");

        try {
            System.out.println("I am writing to file...");
            fileWriter.writeToFile(fileName, content);
        }
        catch(IOException ioex){
            System.out.println("Not another exception!!!");
            ioex.printStackTrace();
        }
    }

    public void callStackExample(){
        CallStackExample callStack = new CallStackExample();
        callStack.run();
    }
}
