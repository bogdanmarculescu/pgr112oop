package org.pgr112.lesson13.equipment;

import java.util.Random;

public class Ball extends Equipment {

    private boolean hasAir;
    private String type;

    public Ball(){
        this.type = "Handball";
        this.hasAir = false;
    }

    public Ball(int id){
        super(id);
        this.type = "Handball";
        this.hasAir = false;
    }

    public Ball(int id, String type){
        super(id);
        this.type = type;
        this.hasAir = false;
    }

    public boolean needsAir() {
        return hasAir;
    }

    public void setNeedsAir(boolean needsAir) {
        this.hasAir = needsAir;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public static String getRandomType(){
        String[] options = {"Handball", "Volleyball", "Football", "Basketball"};
        Random random = new Random();

        int index = random.nextInt(options.length);
        return options[index];

    }
}
