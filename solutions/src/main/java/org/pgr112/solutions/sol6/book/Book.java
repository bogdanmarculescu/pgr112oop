package org.pgr112.solutions.sol6.book;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int pages;
    private Genre genre;
    private String isbn;


    public Book(String title, String author){
        this.title = title;
        this.author = author;

        this.genre = Genre.OTHER;
    }

    public Book(String title, String author, Genre genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(){
        this.title = "";
        this.author = "";
        this.genre = Genre.OTHER;
    }

    public String printBook(){
        return title + " - " + author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    public String toString(){
        return "" + author + " - " + title + ", " + genre + ", " + isbn + "; ";
    }
}
