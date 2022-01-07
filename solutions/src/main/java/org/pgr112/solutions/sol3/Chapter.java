package org.pgr112.solutions.sol3;

public class Chapter {
    private String title;
    private int pages;
    private int minutes;

    public Chapter(String title, int pages){
        this.title = title;
        this.pages = pages;
        this.minutes = pages*2; // to account for the occasional sip of coffee;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getReadingTime() {
        return minutes;
    }
}
