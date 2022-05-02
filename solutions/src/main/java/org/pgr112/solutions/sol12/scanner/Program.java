package org.pgr112.solutions.sol12.scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    private static final String done = "avslutt";
    private static final String welcomeMessage =
            "Velkommen! Skriv inn navn separerte med <Enter>. Skriv \"" + done + "\" for å avslutte.";
    private static final String incorrectNameWarning =
            "Navn må være på minst to bokstaver og ikke inneholde tall. Prøv igjen!";
    private static final String noNamesMessage = "Hmm. Du skrev ikke inn noen navn...";
    private static final String resultHeaderMessage = "Her er resultatet:";
    private static final String longestNameMessage = "Lengste navn:";
    private static final String averageNameLengthMessage = "Gjennomsnittlig lengde på navnene:";

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(welcomeMessage);
        ArrayList<String> names = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (inputDone(input)) {
                // The user is done, we break the while-loop
                break;
            }
            if (inputOk(input)) {
                names.add(input);
            } else {
                System.out.println(incorrectNameWarning);
            }
        }
        printResults(names);
    }

    private void printResults(ArrayList<String> names) {
        if (names.size()==0) {
            System.out.println(noNamesMessage);
            return;
        }
        System.out.println(resultHeaderMessage);
        printNamesAlphabetically(names);
        printAverageNameLength(names);
        printLongestName(names);
    }

    private void printLongestName(ArrayList<String> names) {
        String longestName = names.get(0);
        for (int i = 1; i<names.size(); i++){
            if (names.get(i).length() > longestName.length()){
                longestName = names.get(i);
            }
        }
        System.out.println(longestNameMessage+longestName);
    }

    private void printAverageNameLength(ArrayList<String> names) {
        int allCharacters = 0;
        for (String name: names) {
            allCharacters+=name.length();
        }
        System.out.println(averageNameLengthMessage+allCharacters/names.size());
    }

    private void printNamesAlphabetically(ArrayList<String> names) {
        Collections.sort(names, new NameComparator());
        for (String name: names) {
            System.out.println(name);
        }
    }

    private boolean inputDone(String input) {
        if (input == null){
            return false;
        }
        return input.equalsIgnoreCase(done);
    }

    private boolean inputOk(String input) {
        if (input == null || input.length() < 2) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isLetter(c))
                return false;
        }
        return true;
    }
}

class NameComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2) {
        return s1.compareToIgnoreCase(s2);
    }
}
