package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public Dealership getDealership() { //Dealership here is the return type - will return a Dealership object
        // loads file
        try (BufferedReader bReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            //NEED HEADER
            String header = bReader.readLine();
            String[] h = header.split("\\|"); // creates bar in the middle
            Dealership dealership = new Dealership(h[0], h[1], h[2]); // h[0] will be dealership name, h[1] -address, h[2] -phone

            String info;
            while ((info = bReader.readLine()) != null) { // When readLine() returns null it means there are no more lines
                String[] parts = info.split("\\|"); // Splits the line into separate pieces using "|" (pipe)
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                // Creates a new Vehicle object using the data we just read and converted
                Vehicle vehicles = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicles);                        // Uses Dealership to fill its inventory
            }
            return dealership;
        } catch (IOException ex) {
            System.err.println("Problem reading inventory: " + ex.getMessage());
            return null;
        }
    }
    public void saveDealership(Dealership dealership) {
        // Write dealership and vehicles back to file
    }

}
