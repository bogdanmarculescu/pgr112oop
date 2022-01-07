package org.pgr112.lesson8.animals;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Pig myPig = new Pig(1); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
        myPig.provideMilkForBaby();
        myPig.regulateBodyHeat();

        Cat cat = new Cat(2);
        cat.animalSound();
        cat.sleep();
        cat.provideMilkForBaby();
        cat.regulateBodyHeat();

        HashMap<Integer, Animal> animals = new HashMap<>();
        animals.put(myPig.id, myPig);
        animals.put(cat.id, cat);
        System.out.println("Printing animals:");
        for (Animal animal :
                animals.values()) {
            animal.animalSound();
            animal.sleep();
            System.out.println(animal.toString());
        }
        System.out.println("retrieving by id:");
        System.out.println(animals.get(1));
        System.out.println(animals.get(2));
    }
}
