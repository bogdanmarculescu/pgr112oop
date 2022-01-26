package org.pgr112.lesson10.animals;

class Pig extends Animal {

    public Pig(int id, String name){
        super(id, name);
    }

    @Override
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }

    @Override
    public String toString() {
        return String.format("Pig{%s}", super.toString());
    }
}
