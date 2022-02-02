package org.pgr112.lesson12.exam2021.equipment;

public class BasketBall extends Ball{

    private final String TYPE = "BasketBall";

    public BasketBall(int id) {
        super(id);
    }

    public String getType(){
        return TYPE;
    }
}
