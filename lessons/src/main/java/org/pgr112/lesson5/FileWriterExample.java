package org.pgr112.lesson5;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public void writeToFile() throws IOException {
        FileWriter writer = new FileWriter("ut.txt");
        writer.write("Dette er en test!\n");
        writer.write("Ser ut som om det gikk bra!!!");
        writer.close();
    }
}
