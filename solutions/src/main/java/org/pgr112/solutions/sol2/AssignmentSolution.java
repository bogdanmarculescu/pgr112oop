package org.pgr112.solutions.sol2;

import java.util.Locale;

public class AssignmentSolution {
    /**
     * Returns the sum of all the received numbers.
     */
    public int addThreeNumbers(int i, int j, int k) {
        return i + j + k;
    }

    /**
     * Evaluates if the received number is
     * Small (less than 100).
     * Big (greater than 1000).
     * Medium (not small or big)
     */
    public String isNumberSmallMediumOrBig(int number){
        if(number < 100) return "Small";
        if(number > 1000) return "Big";
        return "Medium";
    }

    /**
     * Prints all Strings in received array to standard output.
     * One String on each line.
     */
    public void printAllStrings(String[] strings){
        for(String s : strings){
            System.out.println(s);
        }
    }

    /**
     * Returns the sum of all numbers in received array.
     */
    public int arraySum(int[] numbers){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++){
            sum += numbers[i];
        }
        return sum;
    }

    /**
     * Print all characters until a char is "."
     * Do not print in separate lines.
     */
    public void printFirstSentence(char[] chars) {
        boolean stop = false;
        int index = 0;
        while(!stop && index < chars.length){
            if(chars[index]=='.'){
                stop = true;
            }
            System.out.print(chars[index]);
            index++;
        }
    }

    /**
     * Prints course name for provided course code.
     * PGR103 -> Objektorientert programmering
     * DB1102 -> Database
     * TK2100 -> Informasjonssikkerhet
     * or "Unknown" if none of the above.
     */
    public void printCourseName(String courseCode){
        switch (courseCode){
            case "PGR103" -> System.out.println("Objektorientert programmering");
            case "PGR112" -> System.out.println("Object Oriented Programming"); // :D
            case "DB1102" -> System.out.println("Database");
            case "TK2100" -> System.out.println("Informasjonssikkerhet");
            default -> System.out.println("Unknown");
        }
    }

    /**
     * Prints all Strings in received array to standard output.
     * One String on each line.
     * But only if the String is not exactly "Corona".
     */
    public void printAllStringsNotCorona(String[] strings){
        for(String s : strings){
            if(!s.equals("Corona")){
                System.out.println(s);
            }
        }
    }

    /**
     * Prints the provided strings in upper case letters.
     * One String on each line.
     */
    public void printUpperCaseStrings(String[] strings){
        for(String s: strings){
            System.out.println(s.toUpperCase());
        }
    }

    /**
     * Returns true if provided color is represented in the Norwegian flag.
     * Color input is lowercase only.
     */
    public boolean isColorInNorwegianFlag(String color){
        return color.equalsIgnoreCase("red")
                || color.equalsIgnoreCase("white")
                || color.equalsIgnoreCase("blue");
    }

    /**
     * Returns the index of the first occurrence of char c in String string.
     * Returns -1 if char is not found.
     */
    public int firstOccurrence(String string, char c){
        char[] auxString = string.toCharArray();
        for(int i=0; i < auxString.length; i++ ){
            if(auxString[i] == c){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the combined length of the provided Strings.
     */
    public int combinedLength(String s1, String s2){
        return s1.length() + s2.length();
    }

    /**
     * Returns the sum of all the received numbers.
     */
    public int addNumbers(int... numbers){
        int sum = 0;
        for(int number: numbers){
            sum += number;
        }
        return sum;
    }

    /**
     * Prints all Strings in received array to standard output.
     * One String on each line.
     * But only if the String is not Corona (case insensitive).
     */
    public void printAllStringsNotCoronaCaseInsensitive(String[] strings){
        for(String st : strings){
            if(!st.equalsIgnoreCase("Corona")) System.out.println(st);
        }
    }

}
