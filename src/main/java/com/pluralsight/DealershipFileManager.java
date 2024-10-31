package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;

public final class DealershipFileManager {

    private static final File FILE = new File("data/dealership.csv");

    private DealershipFileManager() {}

    public static Dealership getDealership() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
            String line;

            // Creating Dealership from first line
            line = bufferedReader.readLine();
            String[] str = line.split("\\|");
            Dealership dealership = new Dealership(
                    str[0], // Name
                    str[1], // Address
                    str[2]  // Phone
            );

            // Creating Vehicles from subsequent lines
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    str = line.split("\\|");
                    dealership.addVehicle(new Vehicle(
                            Integer.parseInt(str[0]), // VIN
                            Integer.parseInt(str[1]), // Year
                            str[2], // Make
                            str[3], // Model
                            str[4], // Vehicle Type
                            str[5], // Color
                            Integer.parseInt(str[6]), // Odometer
                            new BigDecimal(str[7])
                    ));
                }
            }

            bufferedReader.close();
            return dealership;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static void saveDealership(Dealership dealership) {

    }

    public static String getFileLocation() {
        return FILE.getAbsolutePath();
    }
}