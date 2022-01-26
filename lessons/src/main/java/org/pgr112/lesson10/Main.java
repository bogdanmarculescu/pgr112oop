package org.pgr112.lesson10;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Test  test = new Test();
        test.doMagic();
        Optional<Animal> a = test.getAnimal(4);
        if(a.isPresent()){
            System.out.println("Found animal with id = 4:"+a.get().getName());
        }

    }
}
