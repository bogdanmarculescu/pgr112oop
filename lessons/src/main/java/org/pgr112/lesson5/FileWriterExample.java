package org.pgr112.lesson5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriterExample {
    public void writeToFile() throws IOException {
        FileWriter writer = new FileWriter("ut.txt");
        writer.write("Dette er en test!\n");
        writer.write("Ser ut som om det gikk bra!!!");
        writer.close();
    }

    public void writeToFile(String filePath, ArrayList<String> contents) throws IOException{
        FileWriter writer = new FileWriter(filePath);

        for(String line : contents){
            writer.write(line + "\n");
        }
        writer.close();
    }
}
