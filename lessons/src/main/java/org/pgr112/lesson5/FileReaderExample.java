package org.pgr112.lesson5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReaderExample {
    public void readFile() throws FileNotFoundException {
        File file = new File("eksempel.txt");
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            System.out.println(input.nextLine());
        }
        input.close();
    }
    public ArrayList<String> readFile(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        ArrayList<String> contents = new ArrayList<>();

        while(input.hasNextLine()){
            String line = input.nextLine();
            System.out.println(line);
            contents.add(line);
        }
        input.close();
        return contents;
    }
}
