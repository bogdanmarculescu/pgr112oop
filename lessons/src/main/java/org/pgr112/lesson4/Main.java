package org.pgr112.lesson4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add(" Now I see it");
        list.add("you run and repeat it");
        list.add(0, "The Kid Laroi");
        System.out.println(list.get(1).indexOf('o'));
    }

}
