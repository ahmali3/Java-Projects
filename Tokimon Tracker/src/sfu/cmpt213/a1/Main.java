package sfu.cmpt213.a1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ahmed Ali
 * Student Number 301329325
 * @version 1.0
 * Main.java must be used with Tokimon.java
 * Program that tracks the characteristics of Tokimons
 */
public class Main {
    /**
     * Main class used that displays the menu and gathers the correct input from the user in order to create
     * the ArrayList filled with Tokimons.
     */

    static ArrayList<Tokimon> tokiList = new ArrayList<>();
    static boolean exit = false;
    private static final Scanner menuInput = new Scanner(System.in);
    private static final Scanner tokiInput = new Scanner(System.in);

    private static void displayMainMenu() {

        System.out.println("*****************************************************\n" +
                "* Tokimon Tracker created by Ahmed Ali sn 301329325 *\n" +
                "*****************************************************\n\n" +
                "Main Menu\n" +
                "1. List Tokimons\n" +
                "2. Add a new Tokimon\n" +
                "3. Remove a Tokimon\n" +
                "4. Change Tokimon strength\n" +
                "5. DEBUG: Dump objects (tostring)\n" +
                "6. Exit");
        System.out.println("Enter choice: ");
        int choice;
        choice = menuInput.nextInt();
        switch (choice) {
            case 1:
                displayAllTokis();
                pressEnterToContinue();
                break;
            case 2:
                addNewToki();
                break;
            case 3:
                deleteToki();
                break;
            case 4:
                alterToki();
                break;
            case 5:
                toStringDebug();
                pressEnterToContinue();
                break;
            case 6:
                exit = true;
                System.out.println("Goodbye!");
                break;
        }
    }

    private static void addNewToki() {
        String name;
        String type;
        double height;
        double weight;
        double strength = 0;

        System.out.println("Please enter name of Tokimon: ");
        name = tokiInput.next();

        System.out.println("Please enter type: ");
        type = tokiInput.next();

        System.out.println("Please enter height: ");
        height = tokiInput.nextDouble();

        System.out.println("Please enter weight: ");
        weight = tokiInput.nextDouble();

        tokiList.add(new Tokimon(name, type, height, weight, strength));

        System.out.println("Tokimon added.\n");
        pressEnterToContinue();

    }

    private static void displayAllTokis() {
        System.out.println("List of Tokimons:\n");

        for (int i = 0; i < tokiList.size(); i++) {
            System.out.println((i + 1) + ". " + tokiList.get(i).getName() + ", " + tokiList.get(i).getType()
                    + " ability, " + tokiList.get(i).getHeight() + "m, " + tokiList.get(i).getWeight() + "kg, "
                    + tokiList.get(i).getStrength() + " strength\n");
        }

    }


    private static void toStringDebug() {
        for (int i = 0; i < tokiList.size(); i++) {
            System.out.println((i + 1) + ") " + tokiList.get(i));
        }
    }

    private static void deleteToki() {
        int index;
        displayAllTokis();
        System.out.println("Please enter the index of the Tokimon you would like to remove or enter 0 to cancel: ");
        index = tokiInput.nextInt();
        if (index != 0) {
            tokiList.remove((index - 1));
            System.out.println("Tokimon removed.\n");
            pressEnterToContinue();
        } else {
            System.out.println("Cancelling...");
        }
    }

    private static void alterToki() {
        int index;
        double inc;
        displayAllTokis();
        System.out.println("Please enter the index of the Tokimon to be altered or enter 0 to cancel.");
        index = tokiInput.nextInt();
        if (index != 0) {
            System.out.println("Please enter the Tokimon strength amount to increment: ");
            inc = tokiInput.nextDouble();
            if (inc + tokiList.get(index - 1).getStrength() >= 0 && inc + tokiList.get(index - 1).getStrength() <= 100) {
                tokiList.get(index - 1).incrementStrength(inc);
                System.out.println("Tokimon strength incremented.\n");
                pressEnterToContinue();
            } else {
                System.out.println("Value will make Tokimon's strength out of range. Please try again.\n");
                alterToki();
            }
        } else
            System.out.println("Cancelling...");
    }

    private static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    //Main method that runs the program through the loop
    public static void main(String[] args) {
        while (!exit)
            displayMainMenu();
    }

}
