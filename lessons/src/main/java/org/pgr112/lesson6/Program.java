package org.pgr112.lesson6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public void task8(){
        ArrayList<Artist> artists = new ArrayList<>();

        // Read from opg7.txt
        try {
            artists = readFromFile("lessons/src/main/java/org/pgr112/lesson6/opg7.txt");
        }
        catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
        // Change stuff
        for(Artist a : artists){
            if(a.getCountry().equalsIgnoreCase("Norge")){
                a.setCountry("Norway");
            }
        }
        // artists.get(42);
        // Write to opg8.txt
        writeToFile("lessons/src/main/java/org/pgr112/lesson6/opg8.txt", artists);
    }

    private void writeToFile(String fileName, ArrayList<Artist> artists){
        try {
            FileWriter fw = new FileWriter(fileName);

            for(Artist a : artists){
                fw.write(a.getName() + "\n");
                fw.write(a.getBirthday().toString() + "\n");
                fw.write(a.getCity() + "\n");
                fw.write(a.getCountry() + "\n");
                fw.write("---\n");
            }

            fw.close();
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private ArrayList<Artist> readFromFile(String fileName) throws FileNotFoundException{
        ArrayList<Artist> result = new ArrayList<>();

        Scanner input = new Scanner(new File(fileName)).useDelimiter("\n");

            while(input.hasNext()){
                String name = input.nextLine();
                Artist temp = new Artist(name);

                String date = input.nextLine();
                temp.setBirthday(date);
                temp.setCity(input.nextLine());
                temp.setCountry(input.nextLine());
                input.nextLine();

                result.add(temp);
            }

        return result;
    }
}

class Artist{
    private String name;
    private LocalDate birthday;
    private String city;
    private String country;

    public Artist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
