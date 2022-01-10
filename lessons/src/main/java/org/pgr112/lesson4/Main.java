package org.pgr112.lesson4;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("");
        list.add("There is a trick, or rather a knack, to flying,");
        list.add("it consists of throwing yourself at the ground");
        list.add("and missing.");

        /*
        for(String s : list){
            System.out.println(s);
        }
         */

        list.add(0, "Douglas Adams");
        //list.remove(1);

        for(int i = 0; i<list.size(); i++){
            System.out.println("" + i + " -> " + list.get(i));
        }

        //System.out.println(list.get(1).indexOf('o'));

        list.remove(0);

        System.out.println(list);
    }

}
