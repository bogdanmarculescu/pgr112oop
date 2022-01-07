package org.pgr112.solutions.sol3;

import java.util.ArrayList;

public class BookRegister {

    private BookSolution[] books;
    //private ArrayList<BookSolution> books;
    private int numberOfBooks;

    public BookRegister(){
        this.books = new BookSolution[20];
        this.numberOfBooks = 0;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public boolean addBook(BookSolution book){
        if(numberOfBooks <= 19){
            books[numberOfBooks] = book;
            numberOfBooks++;
            return true;
        }
        return false;
    }

    public BookSolution[] allRegisteredBooks(){
        BookSolution[] result = new BookSolution[20];
        int index = 0;
        for(BookSolution b : this.books){
            result[index] = b;
            index++;
        }
        return result;
    }

    public BookSolution[] booksInGenre(Genre genre){
        BookSolution[] result = new BookSolution[20];
        int index = 0;
        for(int i = 0; i < numberOfBooks; i++){
            if(books[i].getGenre()==genre) {
                result[index] = books[i];
                index++;
            }
        }
        return result;
    }

    public BookSolution[] booksByAuthor(String author){
        BookSolution[] result = new BookSolution[20];
        int index = 0;
        for(int i = 0; i < numberOfBooks; i++){
            if(books[i].getAuthor().equalsIgnoreCase(author)) {
                result[index] = books[i];
                index++;
            }
        }
        return result;
    }

    public ArrayList<BookSolution> booksWithReadingTimeLessThan(int minutes){
        ArrayList<BookSolution> result = new ArrayList<BookSolution>();

        for(int i = 0; i < numberOfBooks; i++){
            if(books[i].readingTime() <= minutes){
                result.add(books[i]);
            }
        }
        return result;
    }

}
