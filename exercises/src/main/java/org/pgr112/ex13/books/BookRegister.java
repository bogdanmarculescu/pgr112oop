package org.pgr112.ex13.books;

import java.util.ArrayList;

public class BookRegister {

    // The array list here can be final:
    // this means that the contents may change, but the ArrayList object may not change.
    private final ArrayList<Book> books;
    private int numberOfBooks;
    private final int MAX_CAPACITY = 20;

    public BookRegister(){
        this.books = new ArrayList<>();
        this.numberOfBooks = 0;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public boolean addBook(Book book){
        // we can add a book so long as we are below MAX_CAPACITY
        // This replaces the previously hard coded value (in general, it's better to use constants than hardcoded values).
        if(numberOfBooks < MAX_CAPACITY){   // if there is still room for more books (i.e. the number is below MAX_CAPACITY
            books.add(book);                // add the book object to the collection (ArrayList in this case)
            numberOfBooks++;                // increment the counter that keeps track of the number of books.
            return true;                    // return true, (i.e. book was successfully added).
        }
        return false;                       // if the condition is NOT met: return false - (i.e. the book was not added).
    }

    /***
     * Method returns an ArrayList with all the registered books in the current Repository
     * @return - An ArrayList containing objects of type [Book]
     */
    public ArrayList<Book> allRegisteredBooks(){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){   // iterate through all the objects in the ArrayList [books]
            result.add(b);          // add each such object to the result list
        }
        return result;              // return the result list
    }

    public ArrayList<Book> booksInGenre(Genre genre){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){       // iterate through all the objects in the ArrayList [books]
            if(b.getGenre()==genre) {   // if the current object [b] meets the condition
                result.add(b);          // add to the result.
            }
        }
        return result;
    }

    public ArrayList<Book> booksByAuthor(String author){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){
            if(b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    /***
     *
     * @param isbn - unique identifier for a book
     * @return the matching book, if any.
     */
    public Book bookByISBN(String isbn){
        for(Book b : this.books){                       // for each book in the ArrayList
            if(b.getIsbn().equalsIgnoreCase(isbn)) {    // if the ISBN has been found
                return b;                               // return element
            }
        }
        // NOTE: this method returns the first book with a matching ISBN.
        // The ISBN should be unique, so it assumes that there is AT MOST one such book.
        return null; // if no book with a matching ISBN was found, the method returns null.
    }

    public void removeBook(Book book){
        if(books.contains(book)){
            books.remove(book);
        }
    }

    public void removeBookByISBN(String isbn){
        for(Book book : books){
            if(book.getIsbn().equalsIgnoreCase(isbn)){
                books.remove(book);
            }
        }

    }
}
