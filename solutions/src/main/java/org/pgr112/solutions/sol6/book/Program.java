package org.pgr112.solutions.sol6.book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public BookRegister register;

    public Program(){
        this.register = new BookRegister();
        ArrayList<Book> books = readDefaultBooks();
        for(Book b : books){
            this.register.addBook(b);
        }
    }

    public void runProgram(){
        displayMenu();

        Scanner inputs = new Scanner(System.in);
        String input = "0";

        while(!input.equals("8")){
            input = inputs.nextLine();
            switch (input){
                case "0" -> {
                    System.out.println("Menu");
                    displayMenu();
                }
                case "1" -> {
                    System.out.println("Overview of all books");
                    for(Book b : register.allRegisteredBooks()){
                        System.out.println(b.toString());
                    }
                }
                case "2" -> {
                    System.out.println("Add a book");
                    Book newBook = newBook(inputs);
                    register.addBook(newBook);
                    System.out.println("Added");
                    System.out.println(newBook.toString());
                }

                case "3" -> {
                    System.out.println("Which book do you want to modify (by ISBN):");
                    String isbn = inputs.nextLine();
                    Book book = register.bookByISBN(isbn);

                    modifyBook(book, inputs);
                    System.out.println("Modified.");
                    System.out.println(book.toString());
                }
                case "4" -> {
                    System.out.println("Find based on Genre:");
                    Genre genre = parseGenre(inputs.nextLine());

                    for (Book b : register.booksInGenre(genre)){
                        System.out.println(b.toString());
                    }
                }

                case "5" -> {
                    System.out.println("Find based on Author:");
                    String author = inputs.nextLine();

                    for (Book b : register.booksByAuthor(author)){
                        System.out.println(b.toString());
                    }
                }

                case "6" -> {
                    System.out.println("Find based on ISBN:");
                    String isbn = inputs.nextLine();

                    Book b = register.bookByISBN(isbn);
                    System.out.println(b.toString());
                }

                case "7" -> {
                    System.out.println("Remove by ISBN:");
                    String isbn = inputs.nextLine();
                    register.removeBookByISBN(isbn);
                    System.out.println("Removed!");
                }

                case "8" -> {
                    System.out.println("Exiting");
                    writeBooksDefault();
                }
                default -> {
                    System.out.println("What on Earth are you on about?");
                    System.out.println("Just type \"0\" to see what I can actually do.");
                    //input = "0";
                    //displayMenu();
                }
            }
        }
    }

    public Book newBook(Scanner sc){
        System.out.println("New book:");
        System.out.println("Title: ");
        String title = sc.nextLine();

        System.out.println("Author: ");
        String author = sc.nextLine();

        System.out.println("ISBN: ");
        String isbn = sc.nextLine();

        System.out.println("Pages: ");
        String p = sc.nextLine();
        int pages = 1;
        try{
            pages = Integer.parseInt(p);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Genre: ");
        Genre genre = parseGenre(sc.nextLine());

        Book b = new Book(title, author, genre);
        b.setIsbn(isbn);
        b.setPages(pages);

        return b;
    }

    public void modifyBook(Book book, Scanner sc){
        System.out.println("New book:");
        System.out.println("Title: ");
        String title = sc.nextLine();

        System.out.println("Author: ");
        String author = sc.nextLine();

        System.out.println("Pages: ");
        String p = sc.nextLine();
        int pages = 1;
        try{
            pages = Integer.parseInt(p);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Genre: ");
        Genre genre = parseGenre(sc.nextLine());

        book.setAuthor(author);
        book.setTitle(title);
        book.setGenre(genre);
        book.setPages(pages);
    }

    public void displayMenu(){
        // I'm mostly putting the menu in an array list because I don't want to make changes manually
        ArrayList<String> menu = new ArrayList<>();
        menu.add(0, "Display Menu");
        menu.add(1, "Overview of all books");
        menu.add(2, "Add a book");
        menu.add(3, "Modify a book");
        menu.add(4, "Find based on Genre");
        menu.add(5, "Find based on author");
        menu.add(6, "Find based on ISBN");
        menu.add(7, "Remove a book");
        menu.add(8, "Exit");

        for (int i = 0; i < menu.size(); i++){
            System.out.println("" + i + " -> " + menu.get(i));
        }

    }

    public ArrayList<Book> readBooks(String fileName){
        ArrayList<Book> result = new ArrayList<>();
        try{
            File file = new File(fileName);
            Scanner bookSource = new Scanner(file);

            while(bookSource.hasNextLine()){
                // We can now read the entries
                String isbn = bookSource.nextLine();
                String title = bookSource.nextLine();
                String author = bookSource.nextLine();

                String p = bookSource.nextLine();
                int pages = Integer.parseInt(p);

                String genre = bookSource.nextLine();
                Genre gen = parseGenre(genre);

                bookSource.nextLine(); // To skip the delimiter ---

                Book b = new Book(title, author, gen);
                b.setIsbn(isbn);
                b.setPages(pages);
                result.add(b);

            }
        }
        catch(FileNotFoundException ex){
            System.out.println("Couldn't find that!");
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<Book> readDefaultBooks(){
        return readBooks("solutions/src/main/resources/sol06/bok.txt");
    }

    public void writeBooksDefault(){
        String now = LocalDate.now().toString() + "-" + System.currentTimeMillis();
        String destinationFile = "solutions/src/main/resources/sol06/books" + now + ".txt";

        writeBooks(destinationFile, register);
    }

    public void writeBooks(String fileName, BookRegister books){
        try{
            FileWriter fw = new FileWriter(fileName);
            for(Book b : books.allRegisteredBooks()){
                fw.write(b.getIsbn() + "\n");
                fw.write(b.getTitle() + "\n");
                fw.write(b.getAuthor() + "\n");
                fw.write(b.getPages() + "\n");
                fw.write(b.getGenre().toString() + "\n");
                fw.write("---" + "\n");
            }
            fw.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public Genre parseGenre(String s){
        return switch (s) {
            case "CRIME" -> Genre.CRIME;
            case "FANTASY" -> Genre.FANTASY;
            case "CLASSIC" -> Genre.CLASSIC;
            case "SCIFI" -> Genre.SCIFI;
            default -> Genre.OTHER;
        };
    }
}
