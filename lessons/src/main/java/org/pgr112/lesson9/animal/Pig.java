package org.pgr112.lesson9.animal;

// Pig "implements" the Animal interface
class Pig implements Animal {
    @Override
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
    @Override
    public void sleep() {
        // The body of sleep() is provided here
        System.out.println("Zzz");
    }
}
