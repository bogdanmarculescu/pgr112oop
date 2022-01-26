package org.pgr112.lesson10.animals;

public class Cat extends Animal {

    public Cat(int id, String name){
        super(id, name);
    }

    @Override
    public void animalSound() {
        System.out.println("The cat says: miaaauuu");
    }

    @Override
    public String toString() {
        return String.format("Cat{%s}", super.toString());
    }

}
