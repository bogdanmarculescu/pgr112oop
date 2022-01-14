package org.pgr112.lesson6;

import org.pgr112.solutions.sol4.Book;
import org.pgr112.solutions.sol4.BookRegister;
import org.pgr112.solutions.sol4.Genre;

import java.util.ArrayList;

public class SomeExplanations {

    public BookRegister initializeBookRegister(){
        BookRegister br = new BookRegister();

        br.addBook(new Book("Dune", "Frank Herbert", 750, Genre.OTHER));

        br.addBook(new Book("Fellowship of the Ring", "J.R.R. Tolkien", 750, Genre.FANTASY));
        br.addBook(new Book("The Two Towers", "J.R.R. Tolkien", 750, Genre.FANTASY));
        br.addBook(new Book("Return of the King", "J.R.R. Tolkien", 750, Genre.FANTASY));

        br.addBook(new Book("Guards! Guards!", "Terry Pratchett", 750, Genre.FANTASY));

        return br;
    }

    public BookRegister initializeBookRegister(int number){
        BookRegister br = new BookRegister();

        for (int i = 0; i < number; i++){
            br.addBook(new Book("Title" + i, "Author" + i%4, i*50, Genre.OTHER ));
        }

        return br;
    }

    public void forEachExample(){
        BookRegister br = initializeBookRegister();

        ArrayList<Book> books = br.allRegisteredBooks();
        ArrayList<String> authorNames = new ArrayList<>();

        for(Book bok : books){
            authorNames.add(bok.getAuthor());
            books.indexOf(bok);
        }

    }
}
