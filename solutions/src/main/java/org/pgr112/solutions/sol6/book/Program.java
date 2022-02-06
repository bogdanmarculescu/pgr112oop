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
    public final String DEFAULT_SOURCE_FILE = "solutions/src/main/resources/sol06/bok.txt";
    public ArrayList<String> menu;

    public Program(){
        this.register = new BookRegister(); // initialize the BookRegister
        this.menu = initializeMenu();       // initialize the menu
        ArrayList<Book> books = readDefaultBooks(); // read the books from file in the temporary variable [books]
        for(Book b : books){
            this.register.addBook(b); // add each of the books to the register
        }
    }

    public void runProgram(){
        displayMenu(); // first, we display the menu of options

        // We initialize the reader. The initial input is "0" - so the first thing is to print the menu.
        Scanner inputs = new Scanner(System.in);
        String input = "0";

        // A quick look at the menu shows that 8 is the option for exit.
        // While the input chosen is NOT the exit, continue to accept inputs.
        while(!input.equals("8")){
            // Read the next input from the command line.
            input = inputs.nextLine();
            // what is the value of that input?
            switch (input){
                // if the input is 0 - print the menu.
                case "0" : {
                    System.out.println("Menu");
                    displayMenu();
                    break;
                }
                // if the input is 1 - show an overview of all the books
                case "1" : {
                    System.out.println("Overview of all books");
                    for(Book b : register.allRegisteredBooks()){ // for every book
                        System.out.println(b.toString());       // print to console
                    }
                    break;
                }
                // if the input is 2 - add a book
                case "2" : {
                    System.out.println("Add a book");
                    // create a new book object - use the method new book (and pass the input scanner as a parameter to it).
                    Book newBook = newBook(inputs); // this is so that no additional scanner is created.
                    register.addBook(newBook);      // add the newly created book to the register
                    System.out.println("Added");    // inform the user the book was added
                    System.out.println(newBook.toString()); // show the added book (also for informing the user).
                    break;
                }
                // if the input is 3 - modify a book
                case "3" : {
                    System.out.println("Which book do you want to modify (by ISBN):");
                    String isbn = inputs.nextLine(); // read the ISBN of the book to be modified
                    Book book = register.bookByISBN(isbn); // find the book with that ISBN in the register

                    modifyBook(book, inputs);   // modify the book (pass the book to be modified and the scanner as parameters).
                    System.out.println("Modified."); // inform the user.
                    System.out.println(book.toString());
                    break;
                }
                // if the input is 4 - find all books based on a genre selected by the user.
                case "4" : {
                    System.out.println("Find based on Genre:");
                    Genre genre = parseGenre(inputs.nextLine()); // read the genre the user is interested in

                    for (Book b : register.booksInGenre(genre)){    // the [booksInGenre] method returns all the books of a given genre (see the BookRegister class for the code).
                        System.out.println(b.toString()); // for each book in the genre, print the info to console.
                    }
                    break;
                }
                // when the input is 5 - find all books with a given author
                case "5" : {
                    System.out.println("Find based on Author:");
                    String author = inputs.nextLine(); // read the author the user is interested in

                    for (Book b : register.booksByAuthor(author)){ // the method [booksByAuthor] returns all the books with that author
                        System.out.println(b.toString());   // for each such book, print to console.
                    }
                    break;
                }
                // if the input is 6 - find a book based on ISBN (remember the ISBN is unique)
                case "6" : {
                    System.out.println("Find based on ISBN:");
                    String isbn = inputs.nextLine(); // read the desired ISBN from console

                    Book b = register.bookByISBN(isbn); // find the appropriate book (if it exists)
                    if(b!=null) System.out.println(b.toString());   // if the book exists, print
                    else System.out.println("No such book found");  // if it does not, inform the user.
                    break;
                }
                // if the input is 7 - remove a book based on ISBN
                case "7" : {
                    System.out.println("Remove by ISBN:");
                    String isbn = inputs.nextLine();    // read the ISBN to be removed
                    register.removeBookByISBN(isbn);    // call the appropriate method in the BookRegister
                    System.out.println("Removed!");     // inform the user.
                    break;
                }
                // if the input is 8 - clean up and exit
                case "8" : {
                    System.out.println("Exiting"); // inform the user
                    writeBooksDefault();            // write the changes to file
                    break;
                } // remember the actual exiting is done by breaking out of the while loop!
                // what if the input is not something we recognize?
                default : { // if the input is unknown, I would rather not crash to whole program
                    System.out.println("What on Earth are you on about?"); // inform the user
                    System.out.println("Just type \"0\" to see what I can actually do.");   // provide some guidance
                    //input = "0";
                    //displayMenu();
                    break;
                }
            }
        }
    }

    //Notice that newBook and modifyBook are quite similar
    // Maybe you can find a way to reuse the code here in a better way?
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

        Book b = new Book(isbn);
        b.setTitle(title);
        b.setAuthor(author);
        b.setGenre(genre);
        b.setPages(pages);

        return b;
    }

    /***
     * The method modifies a Book object with the values read from a given Scanner.
     *
     * @param book - the Book object to be modified.
     * @param sc   - an object of type [Scanner] that will provide new information.
     *             In this example, the Scanner is assumed to be connected to a console [System.IN]
     *             where a user may input new values.
     */
    public void modifyBook(Book book, Scanner sc){
        System.out.println("Modify book - " + book.getIsbn());
        System.out.println("Title: ");
        String title = sc.nextLine();   // Read the new information of the book, line by line from the user.
                // All the values read from the user are stored in local variables.
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

        // Alter the information in the Book object to match the inputs provided by the user.
        // NOTE: since an ISBN uniquely identifies a book, that cannot be changed.
        // To change the ISBN of a book, simply create a new book with the desired ISBN.
        book.setAuthor(author);
        book.setTitle(title);
        book.setGenre(genre);
        book.setPages(pages);
    }

    public ArrayList<String> initializeMenu(){
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

        return menu;
    }

    public void displayMenu(){
        for (int i = 0; i < menu.size(); i++){
            System.out.println("" + i + " -> " + menu.get(i));
        }

    }

    public ArrayList<Book> readBooks(String fileName){
        // The method will return an ArrayList of books. So, first let's prepare such an object.
        // This of [result] as a box where we will place all the objects that we want to return.
        ArrayList<Book> result = new ArrayList<>();

        try{ // Some of the methods lower down might throw and exception. We need to use a try to handle that.
            File file = new File(fileName);    // Create a new object of type File, using the fileName parameter.
            Scanner bookSource = new Scanner(file); // Create a new Scanner object that reads from the given file.

            while(bookSource.hasNextLine()){      // We know the structure of the file, but not it's overall length. So we keep reading so long as there is more file to read from.
                // We can now read the entries - see the bok.txt file.
                String isbn = bookSource.nextLine();    // 1st line - the isbn
                String title = bookSource.nextLine();   // 2nd line - title
                String author = bookSource.nextLine();  // 3rd line - the author's name

                String p = bookSource.nextLine();       // 4th line - the number of pages.
                int pages = Integer.parseInt(p);        // the number of pages is expected as an int, so we must parse the string we read from the file to an int.
                        // WARNING - if the string p does not contain a valid int, this will throw an exception
                String genre = bookSource.nextLine();
                Genre gen = parseGenre(genre); // the method [parseGenre] will try to match a string to a Genre object (see the enum Genre).

                bookSource.nextLine(); // To skip the delimiter ---

                // At this moment the variables above contain all the information we have read from our file
                // To add the appropriate object of type [Book] to the register

                Book b =  new Book(isbn); // First we create a book, using some of the information we have
                b.setTitle(title);// Then we add all the remaining information to the new object
                b.setAuthor(author);
                b.setGenre(gen);
                b.setPages(pages);
                // At this point, we have an object of type Book that contains all the information we have read from the file
                // And we add that object to the ArrayList of returned objects [result]
                result.add(b);

            }
        }
        catch(FileNotFoundException ex){
            System.out.println("Couldn't find that!");
            ex.printStackTrace();
        }
        return result; // If we got to this point, it means we have read the entire file and have encountered no exception.
        // so we can return the ArrayList [result], that contains all the Book objects that match the information in the text file.
    }

    public ArrayList<Book> readDefaultBooks(){
        //return readBooks("solutions/src/main/resources/sol06/bok.txt");
        // read the file from the Default source.
        return readBooks(DEFAULT_SOURCE_FILE);
    }

    public void writeBooksDefault(){
        String now = LocalDate.now().toString() + "-" + System.currentTimeMillis();
        String destinationFile = "solutions/src/main/resources/sol06/books" + now + ".txt";

        writeBooks(destinationFile, register);
        //writeBooks(DEFAULT_SOURCE_FILE, register);
    }

    public void writeBooks(String fileName, BookRegister books){
        try{
            FileWriter fw = new FileWriter(fileName); // Create a new FileWriter to write in the file [fileName].
            for(Book b : books.allRegisteredBooks()){
                // For each book in the register, write the values in this order, one on each line.
                fw.write(b.getIsbn() + "\n");
                fw.write(b.getTitle() + "\n");
                fw.write(b.getAuthor() + "\n");
                fw.write(b.getPages() + "\n");
                fw.write(b.getGenre().toString() + "\n");
                fw.write("---" + "\n");
            }
            // It's only when we close the FileWriter object [fw] that the contents are actually written to file.
            fw.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    /***
     * This method matches the Genre string in the text file to the appropriate value in the
     * Genre enum.
     * @param s - the string that describes the genre in the text file.
     * @return - returns the appropriate Genre matching the string. Returns [Genre.OTHER] for any string that does not match any other value.
     */
    public Genre parseGenre(String s){

        Genre ret;
        switch (s) {
            case "CRIME" : ret = Genre.CRIME;
            case "FANTASY" : ret = Genre.FANTASY;
            case "CLASSIC"  : ret =  Genre.CLASSIC;
            case "SCIFI"  : ret =  Genre.SCIFI;
            default  : ret =  Genre.OTHER;
        }
        return ret;
    }
}
