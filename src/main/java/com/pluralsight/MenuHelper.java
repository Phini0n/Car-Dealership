package com.pluralsight;

import java.util.ArrayList;

public final class MenuHelper {

    private static boolean firstRun = true;

    private MenuHelper() {}

    public static void displayMainMenu() {
        if (firstRun) {
            System.out.println("Welcome to the car dealership!\n");
            System.out.println("Loaded dealership info from: " + DealershipFileManager.getFileLocation());
            System.out.println();
            firstRun = false;
        }
        System.out.print(
                """
                        1) Show All Vehicles
                        2) Filter Vehicles
                        3) Add a Vehicle
                        4) Remove a Vehicle
                        99) Exit
                        Enter:\s"""
        );
    }

    public static void showFilterMenu() {
        System.out.print(
                "Filter by:\n" +
                "1) Price Range\n" +
                "2) Make / Model\n" +
                "3) Year Range\n" +
                "4) Color\n" +
                "5) Mileage Range\n" +
                "6) Vehicle Type (car, truck, SUV, van)\n" +
                "7) Return to Main Menu\n"
        );
    }

    public static void displayAddVehicle() {
        System.out.print("Would you like to add a vehicle?");
    }

    public static void displayRemoveVehicle() {
        System.out.print("Would you like to remove a vehicle?");
    }

    // TODO: Remove this if unnecessary
    public static void displayVehicles(ArrayList<Vehicle> vehicles, boolean condition) {
        if (condition) {
            System.out.println();
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
            System.out.println();
        }
    }
}
