package org.pgr112.lesson4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("There is a trick, or rather a knack, to flying,");
        list.add("it consists of throwing yourself at the ground");
        list.add("and missing.");
        list.add(0, "Douglas Adams");
        System.out.println(list.get(1).indexOf('o'));
    }

}
