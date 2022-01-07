package org.pgr112.solutions.sol3;

import java.util.ArrayList;

public class BookSolution {
    private String title;
    private String author;
    private int numberOfpages = 1;
    private Genre genre;
    /*
    This is one of the alternatives to an array: the object ArrayList
     */
    private ArrayList<Chapter> chapters = new ArrayList<Chapter>();

    public BookSolution(String title, String author, int pages){
        this.title = title;
        this.author = author;
        if(pages > 0) {
            this.numberOfpages = pages;
        }
        this.genre = Genre.OTHER;
    }

    public BookSolution(String title, String author, int pages, Genre genre){
        this.title = title;
        this.author = author;
        if(pages > 0) {
            this.numberOfpages = pages;
        }
        this.genre = genre;
    }

    public BookSolution(){
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

    public int getNumberOfpages() {
        return numberOfpages;
    }

    public void setNumberOfpages(int numberOfpages) {
        if(numberOfpages > 0) this.numberOfpages = numberOfpages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    //Extra task 3:
    public void addChapter(Chapter ch){
        this.chapters.add(ch);
    }
    public int readingTime(){
        int sum = 0;
        for(Chapter ch : chapters){
            sum+= ch.getReadingTime();
        }
        return sum;
    }
}
