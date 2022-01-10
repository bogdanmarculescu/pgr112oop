package org.pgr112.solutions.sol4;

import java.util.ArrayList;

public class BookRegister {

    private ArrayList<Book> books;
    //private ArrayList<BookSolution> books;
    private int numberOfBooks;

    public BookRegister(){
        this.books = new ArrayList<>();
        this.numberOfBooks = 0;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public boolean addBook(Book book){
        if(numberOfBooks <= 19){
            books.add(book);
            numberOfBooks++;
            return true;
        }
        return false;
    }

    public ArrayList<Book> allRegisteredBooks(){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){
            result.add(b);
        }
        return result;
    }

    public ArrayList<Book> booksInGenre(Genre genre){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){
            if(b.getGenre()==genre) {
                result.add(b);
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

    public ArrayList<Book> booksWithReadingTimeLessThan(int minutes){
        ArrayList<Book> result = new ArrayList<>();

        for(Book b : this.books){
            if(b.readingTime() <= minutes){
                result.add(b);
            }
        }
        return result;
    }

}
