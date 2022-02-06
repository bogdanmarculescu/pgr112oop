package org.pgr112.lesson12.exam2021;

import org.pgr112.lesson12.exam2021.equipment.Ball;
import org.pgr112.lesson12.exam2021.equipment.Equipment;
import org.pgr112.lesson12.exam2021.equipment.TableTennisRacket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class EquipmentReader {

    private final String DEFAULT_FILE = "lessons/src/main/resources/lesson12/equipment.txt";
    // this will be the class that reads the information from file.

    /***
     * This method reads from the default file
     * @return - the HashMap of equipment in the file
     */
    public HashMap<Integer, Equipment> readFromFile(){
        return readFromFile(DEFAULT_FILE);
    }

    /***
     * This method reads from a given file
     * @param fileName - describes the file that we will read from
     * @return - the HashMap of equipment in the file
     */
    public HashMap<Integer, Equipment> readFromFile(String fileName) {
        // this is the method that will read from file
        HashMap<Integer, Equipment> result = new HashMap<>();

        try {
            Scanner fileInput = new Scanner(new File(fileName));

            while(fileInput.hasNextLine()){
                String type = fileInput.nextLine();
                switch (type){
                    case "Ball" : {
                        // Read 5 more lines - 6 lines in total
                        String sId = fileInput.nextLine(); // 4 lines left
                        int iId = Integer.parseInt(sId);

                        // Alternatively
                        //int eId = fileInput.nextInt();
                        //fileInput.nextLine();

                        String location = fileInput.nextLine(); // 3 lines left

                        String sReplacement = fileInput.nextLine(); // 2 lines left
                        boolean bReplacement = Boolean.parseBoolean(sReplacement);

                        String ballType = fileInput.nextLine(); // 1 lines left

                        String sAir = fileInput.nextLine(); // last line of the object
                        boolean bAir = Boolean.parseBoolean(sAir);

                        Ball b1 = Ball.chooseAppropriateBall(iId, ballType);

                        // at this point, b1 only has a type and an id.
                        b1.setLocation(location); // inherited from Equipment
                        b1.setReplace(bReplacement); // inherited from Equipment
                        b1.setHasAir(bAir);

                        result.put(iId, b1);
                        break;
                    }
                    case "TableTennisRacket" : {
                        // Read 4 more lines - 5 lines in total
                        String sId = fileInput.nextLine(); // 3 lines left
                        int iId = Integer.parseInt(sId);

                        String location = fileInput.nextLine(); // 2 lines left

                        String sReplacement = fileInput.nextLine(); // 1 lines left
                        boolean bReplacement = Boolean.parseBoolean(sReplacement);

                        String sNewFace = fileInput.nextLine(); // this is the last line
                        boolean bNewFace = Boolean.parseBoolean(sNewFace);

                        TableTennisRacket ttr = new TableTennisRacket(iId);
                        ttr.setLocation(location);
                        ttr.setReplace(bReplacement);
                        ttr.setNewFace(bNewFace);

                        result.put(iId, ttr);
                        break;
                    }
                    default : {
                        // Panic!
                        // maybe throw exception
                        break;
                    }
                }
            }

        }
        catch(FileNotFoundException ex){
            // this is where I handle the exception
            ex.printStackTrace();
        }

        return result;
    }

    public void miscelaneousExamples(){
        String s = "123";
        String s2 = "blorp";
        int i = Integer.parseInt(s);
        int j = Integer.parseInt(s2);
    }

    public void writeToFile(String fileName, HashMap<Integer, Equipment> data){
        //this method will write to file when we are done
    }
}
