package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership() { //Dealership here is the return type - will return a Dealership object
        Dealership dealership = null; //had a scope issue and this fixed it (couldnt use teh last return)

        try (BufferedReader bReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            // think of line like header from capstone 1
            String line = bReader.readLine();
            String[] h = line.split("\\|"); // array and splits sections with bar in the middle
            dealership = new Dealership(h[0], h[1], h[2]); // h[0] will be dealership name, h[1] -address, h[2] -phone

            while ((line = bReader.readLine()) != null) { // When readLine() returns null it means there are no more lines
                String[] parts = line.split("\\|"); // Splits the line into separate pieces using "|" (pipe)
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                // Creates a new Vehicle object using the data we just read and converted
                Vehicle v = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(v);                        // Uses Dealership to fill its inventory
            }
        } catch (IOException ex) {
            System.err.println("Problem reading inventory: " + ex.getMessage());
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv"))) {

            bWriter.write(dealership.getName() + "|" +
                    dealership.getAddress() + "|" +
                    dealership.getPhone());
            bWriter.newLine();

            // Write each vehicle
            for (Vehicle v : dealership.getAllVehicles()) {
                bWriter.write(v.getVin() + "|" +
                        v.getYear() + "|" +
                        v.getMake() + "|" +
                        v.getModel() + "|" +
                        v.getVehicleType() + "|" +
                        v.getColor() + "|" +
                        v.getOdometer() + "|" +
                        v.getPrice());
                bWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing dealership file: " + e.getMessage());
        }
    }

}
