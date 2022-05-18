package org.pgr112.lesson10.animals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pgr112.lesson10.animals.Animal;
import org.pgr112.lesson10.animals.Cat;
import org.pgr112.lesson10.animals.Pig;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalsTest {
    private HashSet<Animal> animals;

    @BeforeEach
    public void initTest() {
        animals = new HashSet<>();
        initHashSet();
    }

    private void initHashSet() {
        animals.add(new Pig(1, "Petter"));
        animals.add(new Pig(2, "Jens"));
        animals.add(new Pig(3, "Harald"));
        animals.add(new Cat(4, "Mia"));
        animals.add(new Cat(5, "Kitty"));
    }

    @Test
    public void doMagic() {
        boolean isEmpty = animals.isEmpty();
        System.out.println("HashSet is empty:" + isEmpty);
        printAllAnimals();
        boolean petterRemoved = animals.remove(new Pig(1, "Petter"));
        System.out.println("Petter removed:");
        System.out.println(petterRemoved);
    }

    @Test
    public void testPresence() {
        org.pgr112.lesson10.animals.Test test = new org.pgr112.lesson10.animals.Test();
        test.doMagic();
        Optional<Animal> a = test.getAnimal(4);
        if(a.isPresent()){
            System.out.println("Found animal with id = 4:"+a.get().getName());
        }

    }

    private void printAllAnimals() {
        for (Animal a :
                animals) {
            System.out.println(a);
        }
    }

    public Optional<Animal> getAnimal(int id){
        for (Animal a :
                animals) {
            if(a.getId()==id){
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }

    /**
     * Simply adding length of two strings
     * @param s1 string 1
     * @param s2 string 2
     * @return sum length of two strings
     *
     * @throws IllegalArgumentException if one or more strings are null
     */
    public int sumOfTwoStrings(String s1, String s2){
        if(s1==null||s2==null){
            throw new IllegalArgumentException("Expecting non-null values. Null found.");
        }
        return s1.length() + s2.length();
    }

    @Test
    public void testAnimals(){
        assertEquals(5, animals.size());

    }

}
