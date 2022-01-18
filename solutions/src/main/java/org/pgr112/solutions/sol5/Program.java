package org.pgr112.solutions.sol5;

import javax.crypto.spec.PSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Program {

    private ArrayList<Artist> artists;

    public Program(){
        artists = new ArrayList<>();
    }

    public Program(File file){
        artists = readArtistsWithId(file);
    }

    public void task4(){
        //Make a method problem4 in the Program class. In the method: read the contents of the file opg4.txt and print it (SOUT), line by line.

        File file = new File("solutions/src/main/resources/sol05/opg4.txt");
        try {
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                System.out.println(input.nextLine());
            }
            input.close();
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void task5(String... strings){
        File file = new File("solutions/src/main/resources/sol05/opg5.txt");
        try{
            FileWriter fw = new FileWriter(file);
            for(String st : strings){
                fw.write(st + "\n");
            }
            fw.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void task7(){
        File artistFile = new File("solutions/src/main/resources/sol05/opg7.txt");
        ArrayList<Artist> artistsGroup = readArtists(artistFile);

        for(Artist a : artistsGroup){
            a.printData();
        }
    }

    public void task8(){
        File sourceFile = new File("solutions/src/main/resources/sol05/opg7.txt");
        File destFile = new File("solutions/src/main/resources/sol05/opg8.txt");
        ArrayList<Artist> artists = readArtists(sourceFile);

        for (Artist ar : artists){
            if(ar.getCountry().equalsIgnoreCase("Norge")){
                ar.setCountry("Norway");
            }
        }

        writeArtists(artists, destFile);
    }

    public void writeArtistsWithId(ArrayList<Artist> artistsList, File file){
        try{
            FileWriter fw = new FileWriter(file);
            for (Artist ar : artistsList){
                fw.write(ar.getArtistName() + "\n");
                fw.write(ar.getDateOfBirth() + "\n");
                fw.write(ar.getCity() + "\n");
                fw.write(ar.getCountry() + "\n");
                fw.write(ar.getId() + "\n");
                fw.write("---\n");
            }
            fw.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void writeArtists(ArrayList<Artist> artistsList, File file){
        try{
            FileWriter fw = new FileWriter(file);
            for (Artist ar : artistsList){
                fw.write(ar.getArtistName() + "\n");
                fw.write(ar.getDateOfBirth() + "\n");
                fw.write(ar.getCity() + "\n");
                fw.write(ar.getCountry() + "\n");
                fw.write("---\n");
            }
            fw.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<Artist> readArtists(File file){
        ArrayList<Artist> artists = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                //Read the details of each artist
                String name = input.nextLine();
                String date = input.nextLine();
                LocalDate dob = LocalDate.parse(date);
                String city = input.nextLine();
                String country = input.nextLine();

                Artist aux = new Artist(name, dob, city, country);
                artists.add(aux);
                //Skip the delimiters (they are only there for readability)
                input.nextLine();
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        return artists;
    }

    public ArrayList<Artist> readArtistsWithId(File file){
        ArrayList<Artist> artists = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                //Read the details of each artist
                String name = input.nextLine();
                String date = input.nextLine();
                LocalDate dob = LocalDate.parse(date);
                String city = input.nextLine();
                String country = input.nextLine();

                String id = input.nextLine();
                int artistId = Integer.parseInt(id);

                Artist aux = new Artist(name, dob, city, country);
                aux.setId(artistId);
                artists.add(aux);

                //Skip the delimiters (they are only there for readability)
                input.nextLine();
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        return artists;
    }

    // So, I don't want to create the extra.txt file by hand. So I will automate this.
    public void createExtraFile(){
        File sourceFile = new File("solutions/src/main/resources/sol05/opg7.txt");
        File destFile = new File("solutions/src/main/resources/sol05/extra.txt");
        ArrayList<Artist> artists = readArtists(sourceFile);

        // Let's also add Bruce, for good measure. I like Iron Maiden.
        Artist a = new Artist(
                "Bruce Dickinson",
                LocalDate.parse("1958-08-07"),
                "Worksop",
                "UK"
        );
        artists.add(a);

        // we will use this index to give each artist a unique ID.
        int index = 0;

        for (Artist ar : artists){
            ar.setId(index);
            index++;
        }

        writeArtistsWithId(artists, destFile);

    }

    public ArrayList<Artist> getArtists(){
        return artists;
    }

    public void printMenu(){
        System.out.println("=== Menu ==");
        System.out.println(" 1 -> Display All Artists ");
        System.out.println(" 2 -> Get Artist Based on ID ");
        System.out.println(" 3 -> Add Artist ");
        System.out.println(" 4 -> Change artist based on ID");
        System.out.println(" 5 -> Exit ");
    }

    public Artist getFromId(int id){
        for(Artist ar : artists){
            if(ar.getId() == id){
                return ar;
            }
        }
        return null;
    }

    public void addArtist(String name, LocalDate dob, String city, String country){
        Artist aux = new Artist(name, dob, city, country);
        aux.setId(artists.size() + 1);
        artists.add(aux);
    }

    public void addArtist(Artist aux){
        aux.setId(artists.size() + 1);
        artists.add(aux);
    }



    public static void main(String[] args){
        // In order to keep the extra task separate from the other tasks,
        // I will add another main method here.

        File artistFile = new File("solutions/src/main/resources/sol05/extra.txt");
        Program pr = new Program(artistFile);

        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to my interpretation (no pun intended) of the extra task!");

        //pr.printMenu();
        String choice = "0";

        while(!choice.equalsIgnoreCase("5")){
            switch (choice){
                case "0" -> {
                    pr.printMenu();
                }
                case "1" -> {
                    System.out.println("Display all");
                    for(Artist ar : pr.getArtists()){
                        ar.printData();
                    }
                }
                case "2" -> {
                    System.out.println("Get from ID: ");
                    try{
                        int id = userInput.nextInt();
                        // This is needed to consume the \n, which nextInt does not consume
                        userInput.nextLine();

                        Artist a = pr.getFromId(id);
                        if(a!=null){
                            a.printData();
                        }

                    }
                    catch (InputMismatchException ex){
                        System.out.println("What exactly are you doing???");
                        ex.printStackTrace();
                    }
                }
                case "3" -> {
                    System.out.println("Add artist");

                    Artist a = pr.createArtist(userInput);
                    pr.addArtist(a);

                    System.out.println("Added!");
                    pr.printMenu();
                }
                case "4" -> {
                    System.out.println("Modify artist. Choose ID:");

                    try{
                        int id = userInput.nextInt();
                        // This is needed to consume the \n, which nextInt does not consume
                        userInput.nextLine();

                        Artist a = pr.getFromId(id);
                        Artist mod = pr.createArtist(userInput);

                        a.setArtistName(mod.getArtistName());
                        a.setDateOfBirth(mod.getDateOfBirth());
                        a.setCity(mod.getCity());
                        a.setCountry(mod.getCountry());

                        a.printData();
                    }
                    catch (InputMismatchException ex){
                        ex.printStackTrace();
                        System.out.println("Troubling, that.");
                    }
                }
                default -> {
                    System.out.println("I'm afraid I can't do that, Dave.");
                    pr.printMenu();
                }
            }
            System.out.println("Press 0 for menu.");
            choice = userInput.nextLine();
        }
        System.out.println("Saving");
        File dest = new File("solutions/src/main/resources/sol05/extra.txt");
        pr.writeArtistsWithId(pr.artists, dest);
        System.out.println("Exiting now!");

    }

    public Artist createArtist(Scanner userInput){
        System.out.println("Name: ");
        String name = userInput.nextLine();

        System.out.println("Date of Birth:");
        String dob = userInput.nextLine();
        LocalDate date = LocalDate.now();
        try{
            date = LocalDate.parse(dob);
        }
        catch(DateTimeParseException ex){
            System.out.println("What exactly are you doing???");
            ex.printStackTrace();
            System.out.println("I'll just default to now!");
        }
        System.out.println("City: ");
        String city = userInput.nextLine();

        System.out.println("Country: ");
        String country = userInput.nextLine();

        Artist result = new Artist(name, date, city, country);
        return result;
    }
}
