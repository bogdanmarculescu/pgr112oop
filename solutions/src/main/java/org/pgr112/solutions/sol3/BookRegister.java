package org.pgr112.solutions.sol3;

import java.util.ArrayList;

public class BookRegister {


    private ArrayList<BookSolution> books;
    private int numberOfBooks;

    public BookRegister(){
        this.books = new ArrayList<BookSolution>(20);
        this.numberOfBooks = 0;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public boolean addBook(BookSolution book){
        if(numberOfBooks <= 19){
            books.add(book);
            numberOfBooks++;
            return true;
        }
        return false;
    }

    public ArrayList<BookSolution> allRegisteredBooks(){
        ArrayList<BookSolution> result = new ArrayList<BookSolution>();
        for(BookSolution b : this.books){
            result.add(b);
        }
        return result;
    }

    public ArrayList<BookSolution> booksInGenre(Genre genre){
        ArrayList<BookSolution> result = new ArrayList<BookSolution>();
        for(BookSolution b : this.books){
            if(b.getGenre()==genre) {
                result.add(b);
            }
        }
        return result;
    }

    public ArrayList<BookSolution> booksByAuthor(String author){
        ArrayList<BookSolution> result = new ArrayList<BookSolution>();
        for(BookSolution b : this.books){
            if(b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    public ArrayList<BookSolution> booksWithReadingTimeLessThan(int minutes){
        ArrayList<BookSolution> result = new ArrayList<BookSolution>();

        for(BookSolution book : books){
            if(book.readingTime() <= minutes){
                result.add(book);
            }
        }
        return result;
    }

}
