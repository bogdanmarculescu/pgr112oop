package org.pgr112.lesson5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderExample {
    public void readFile() throws FileNotFoundException {
        File file = new File("eksempel.txt");
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            System.out.println(input.nextLine());
        }
        input.close();
    }
}
