package org.pgr112.lesson9.animal;

import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void testPiggie(){
        Pig p = new Pig();
        p.animalSound();
    }

    @Test
    public void catCompilePoly(){
        Cat cat = new Cat();

        cat.beCatLike("cat");
        cat.beCatLike();
        cat.beCatLike(23);

    }
}
