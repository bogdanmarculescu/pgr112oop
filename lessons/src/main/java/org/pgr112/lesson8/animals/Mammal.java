package org.pgr112.lesson8.animals;

public abstract class Mammal extends Animal{

    public Mammal(int id){
        super(id);
    }

    public void regulateBodyHeat(){
        System.out.println("Change in temp. Regulating body heat.");
    }
    public abstract void provideMilkForBaby();
}
