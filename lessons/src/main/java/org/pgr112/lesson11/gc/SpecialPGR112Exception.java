package org.pgr112.lesson11.gc;

public class SpecialPGR112Exception extends Exception{

    public SpecialPGR112Exception(String message){
        super(message);
    }

    public SpecialPGR112Exception(String message, Throwable ex){
        super(message, ex);
    }

    public double someMethod(){
        return Math.PI;
    }
}
