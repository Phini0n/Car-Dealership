package com.pluralsight;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public final class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public void display() {
        // Initialize dealership
        init();

        // Main Menu Display
        int choice = -1;
        while (choice != 99) {
            MenuHelper.displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            // Passing to requests
            switch (choice) {
                case 1:
                    processGetAllVehicleRequest();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 99:
                    System.out.println("\nThank you for browsing!");
                    break;
                default:
                    System.out.println("\nInvalid choice!");
                    break;
            }
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles, boolean condition) {
        for (Vehicle vehicle : vehicles) {
            if (condition) {
                System.out.println(vehicle);
            }
        }
    }

    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehicleRequest() {
        System.out.println();
        displayVehicles((ArrayList<Vehicle>) dealership.getAllVehicles(), true);
        System.out.println();
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest(){

    }
}
