package org.pgr112.lesson12.exam2021;

import org.pgr112.lesson12.exam2021.equipment.Ball;
import org.pgr112.lesson12.exam2021.equipment.Equipment;

import java.util.HashMap;
import java.util.Map;

public class Program {

    private HashMap<Integer, Equipment> equipmentMap;
    private EquipmentReader equipmentReader;

    public Program(){
        equipmentReader = new EquipmentReader();
        equipmentMap = equipmentReader.readFromFile();
    }

    public HashMap<Integer, Equipment> getEquipmentMap() {
        return equipmentMap;
    }

    public HashMap<Integer, Equipment> printBallsNeedingMoreAir(){
        HashMap<Integer, Equipment> result = new HashMap<>();
        // Is a ball && Needs more air

        for(Integer key : equipmentMap.keySet()){
            Equipment currentElement = equipmentMap.get(key);
            if(currentElement instanceof Ball){ // if the current element is some type of Ball
                Ball current = (Ball) currentElement;
                if(!current.hasAir()){ // cast to Ball (see check above)
                    // and then call method .hasAir() which is a method of class Ball
                    result.put(key, current);
                    System.out.println("" + key +  " -> " +
                            current.getLocation() + " - " +
                            current.getType());
                }
            }
        }

        return result;
    }
}
