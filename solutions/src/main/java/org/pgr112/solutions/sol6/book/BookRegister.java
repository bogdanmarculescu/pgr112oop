package org.pgr112.solutions.sol6.book;

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

    /***
     *
     * @param isbn - unique identifier for a book
     * @return the matching book, if any.
     */
    public Book bookByISBN(String isbn){
        for(Book b : this.books){
            if(b.getIsbn().equalsIgnoreCase(isbn)) {
                return b;
            }
        }
        return null;
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

    public void modifyBook(String isbn, Book b){
        Book book = bookByISBN(isbn);
        book.setTitle(b.getTitle());
        book.setAuthor(b.getAuthor());
        book.setGenre(b.getGenre());
        book.setPages(b.getPages());
    }

}
