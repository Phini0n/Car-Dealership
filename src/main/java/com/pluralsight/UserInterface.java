package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public final class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    private enum Menu {
        MENU_MAIN,
        MENU_FILTER
    }

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public void display() {
        // Initialize dealership
        init();

        // Menu Display
        handleDisplay(Menu.MENU_MAIN);
    }

    private void handleDisplay(Menu menuType) {
        int choice = -1;
        int exitValue = 0; // Value that exits the selected menu

        // MAIN MENU
        if (menuType == Menu.MENU_MAIN) {
            exitValue = 99;
            // Main Menu Switch Case
            while (choice != exitValue) {
                try {
                    DisplayHelper.displayMainMenu(dealership);
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    // Passing to requests
                    switch (choice) {
                        case 1:
                            processGetAllVehicleRequest();
                            break;
                        case 2:
                            choice = exitValue;
                            handleDisplay(Menu.MENU_FILTER); // Recursively makes the Filter Menu
                            break;
                        case 3:
                            System.out.println("Add Vehicle NYI");
                            break;
                        case 4:
                            System.out.println("Remove Vehicle NYI");
                            break;
                        case 99:
                            DisplayHelper.displayGoodbye();
                            break;
                        default:
                            DisplayHelper.invalidEntry();
                            break;
                    }
                } catch (Exception e) {
                    DisplayHelper.displayError(e);
                    scanner.nextLine();
                }
            }

        // FILTER MENU
        } else if (menuType == Menu.MENU_FILTER) {
            exitValue = 7;
            //Filter Menu Switch Case
            while (choice != exitValue) {
                DisplayHelper.displayFilterMenu();
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    // Passing to requests
                    switch (choice) {
                        case 1:
                            processGetByPriceRequest();
                            break;
                        case 2:
                            processGetByMakeModelRequest();
                            break;
                        case 3:
                            processGetByYearRequest();
                            break;
                        case 4:
                            processGetByColorRequest();
                            break;
                        case 5:
                            processGetByMileageRequest();
                            break;
                        case 6:
                            processGetByVehicleTypeRequest();
                        case 7:
                            choice = exitValue;
                            handleDisplay(Menu.MENU_MAIN); // Recursively goes into the main meu
                        default:
                            DisplayHelper.invalidEntry();
                            break;
                    }
                } catch (Exception e) {
                    DisplayHelper.displayError(e);
                    scanner.nextLine();
                }
            }
        }
    }

    private void processGetByPriceRequest() {
        DisplayHelper.displayFilterRequest(1); // Displays filter request for price range.
        String[] priceRange = scanner.nextLine().split("-");
        try {
            DisplayHelper.displayVehicles((ArrayList<Vehicle>) dealership.getVehiclesByPrice(
                    new BigDecimal(priceRange[0]),
                    new BigDecimal(priceRange[1])));
        } catch (Exception e) {
            DisplayHelper.displayError(e);
            scanner.nextLine();
        }
    }

    private void processGetByMakeModelRequest() {

    }

    //Comment
    private void processGetByYearRequest() {
        DisplayHelper.displayFilterRequest(3);
        String[] yearRange = scanner.nextLine().split("-");
        try {
            DisplayHelper.displayVehicles((ArrayList<Vehicle>) dealership.getVehiclesByYear(
                    Integer.parseInt(yearRange[0]),
                    Integer.parseInt(yearRange[1])));
        } catch (Exception e) {
            DisplayHelper.displayError(e);
            scanner.nextLine();
        }
    }

    private void processGetByColorRequest() {
        DisplayHelper.displayFilterRequest(4); // Displays filter request for color.
        DisplayHelper.displayVehicles((ArrayList<Vehicle>) dealership.getVehiclesByColor(scanner.nextLine()));
    }

    private void processGetByMileageRequest() {

    }

    private void processGetByVehicleTypeRequest() {
        DisplayHelper.displayFilterRequest(6);
    }

    private void processGetAllVehicleRequest() {
        DisplayHelper.displayVehicles((ArrayList<Vehicle>) dealership.getAllVehicles());
    }

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest(){

    }
}
