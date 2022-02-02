package org.pgr112.lesson12.exam2021.equipment;

public class HandBall extends Ball{

    public final String TYPE = "Handball";

    public HandBall(int id){
        super(id);
    }

    public String getType(){
        return TYPE;
    }
}
