package org.pgr112.lesson12.exam2021.equipment;

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
        switch (type){
            case "Football" -> {
                return new FootBall(id);
            }
            case "Volleyball" -> {
                return new VolleyBall(id);
            }
            default -> {
                return null;
            }
        }
    }
}
