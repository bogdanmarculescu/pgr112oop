package org.pgr112.lesson12.exam2021.equipment;

import java.util.Locale;

public abstract class Ball extends Equipment{

    private boolean hasAir;

    public Ball(int id){
        super(id);
        this.hasAir = false;
    }

    public boolean hasAir() {
        return hasAir;
    }

    public void setHasAir(boolean needsAir) {
        this.hasAir = needsAir;
    }

    /***
     * This method selects and appropriate constructor for the individual Ball Type
     * @param id - required for the new object
     * @param type - the type of Ball to be created
     * @return A Ball of appropriate subtype
     *
     * NOTE: You can avoid this complication by just having a string field that
     * describes the type. This will be quicker and easier and faster to implement,
     * but it will not be as easy to extend further down the line.
     */
    public static Ball chooseAppropriateBall(int id, String type){
        String typeNoCase = type.toLowerCase();
        switch (typeNoCase){
            case "football" : return new FootBall(id);
            case "volleyball" : return new VolleyBall(id);
            case "handball" : return new HandBall(id);
            case "basketball" : return new BasketBall(id);
            default : throw new IllegalArgumentException("I do not support type: " + type);
        }
    }

    public abstract String getType();
}
