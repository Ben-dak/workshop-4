package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class DealershipFileManager {

    public Dealership getDealership() {
        // loads file
       try (BufferedReader bReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
           //NEED HEADER
           //

       }


//
//            while ((info = bReader.readLine()) != null) {   // When readLine() returns null it means there are no more lines
//                String[] parts = info.split("\\|");   // Splits the line into separate pieces using "|" (pipe)
//                LocalDate date = LocalDate.parse(parts[0]); // converts date string into LocalDate object
//                LocalTime time = LocalTime.parse(parts[1]); // converts time string into LocalTime object (did this for these as I wanted to keep them all together so I could
//                String description = parts[2];
//                String vendor = parts[3];
//                double amount = Double.parseDouble(parts[4]); // Converts "amount" string into a double
//
//                Vehicle inventory = new Vehicle(vin, year, make, model,
//                        vehicleType, color, odometer, price); // Creates a new Transaction object using the data we just read and converted
//                inventory.add(transactions);                                                             // Adds this new Transaction object to the Array list (tList)
//            }
//
//        } catch (FileNotFoundException e) {                 // runs if the file can’t be found
//            System.err.println("Error: " + e.getMessage());
//            // This catch handles general input/output problems
//        } catch (IOException e) {
//            System.err.println("Error" + e.getMessage());
//        }


        return null;
    }

    public void saveDealership(Dealership dealership) {
        // Write file
    }
}
