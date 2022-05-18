package org.pgr112.recap7;

public class Squirrel {
    private String name;
    private int stash;
    private String favoriteTree;

    public Squirrel(){
        stash = 0;
        name = "Placeholder name";
    }

    public Squirrel(String name, String favoriteTree, int stash){
        this.name = name;
        this.stash = stash;
        this.favoriteTree = favoriteTree;
    }

    public Squirrel(String name){
        this.name = name;
        this.favoriteTree = "That one!";
        this.stash = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getStash(){
        return stash;
    }
}
