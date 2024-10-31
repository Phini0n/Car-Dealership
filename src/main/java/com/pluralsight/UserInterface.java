package com.pluralsight;

import java.math.BigDecimal;
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
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                // Passing to requests
                switch (choice) {
                    case 1:
                        processGetAllVehicleRequest();
                        break;
                    case 2:
                        processGetByPriceRequest();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 99:
                        MenuHelper.displayGoodbye();
                        break;
                    default:
                        System.out.println("\nInvalid choice!");
                        break;
                }
            } catch (Exception e) {
                MenuHelper.displayError(e);
                scanner.nextLine();
            }
        }
    }

    public void processGetByPriceRequest() {
        MenuHelper.displayPriceRequest();
        String[] priceRange = scanner.nextLine().split("-");
        try {
            MenuHelper.displayVehicles((ArrayList<Vehicle>) dealership.getVehiclesByPrice(new BigDecimal(priceRange[0]),
                    new BigDecimal(priceRange[1])));
        } catch (Exception e) {
            MenuHelper.displayError(e);
            scanner.nextLine();
        }
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
        MenuHelper.displayVehicles((ArrayList<Vehicle>) dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest(){

    }
}
