package org.pgr112.lesson12.exam2021;

import org.pgr112.lesson12.exam2021.equipment.Equipment;

import java.util.HashMap;

public class Main {

    public static void main(String[] args){
        Program program = new Program();

        HashMap<Integer, Equipment> equipmentMap = program.getEquipmentMap();

        //System.out.println(equipmentMap);

        System.out.println(" === balls that need more air ===");
        HashMap<Integer, Equipment> ballsNeedingAir = program.printBallsNeedingMoreAir();

    }
}
