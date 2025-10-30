package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    Dealership dealership;
    //will be using dealership class - can call

    // Show main menu and handle user choices (by calling display)
    public void display() {
        init(); //loads dealership

        Scanner myScanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayVehicleMenu(); // calling helper method
            System.out.print("Enter your choice: ");
            int input = myScanner.nextInt(); //trying out nextInt

            switch (input) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 99 -> running = false;
                default -> System.out.println("Invalid option, try again!");
            }
        }
    }

    private void displayVehicleMenu() {
        System.out.println("""
                    === Dealership App - Home Menu ===
                    1) Find vehicles by price range
                    2) Find vehicles by make / model
                    3) Find vehicles by year range
                    4) Find vehicles by color
                    5) Find vehicles by mileage range
                    6) Find vehicles by type
                    7) List ALL vehicles
                    8) Add a vehicle
                    9) Remove a vehicle
                    10) Quit
                    """);
        System.out.print("Enter your choice: ");
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();  // loads from file
    }

    public void processAddVehicleRequest() {
        Vehicle v = new Vehicle();
        dealership.addVehicle(v);

        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(this.dealership);
    }

    private void processGetByPriceRequest() {}
    private void processGetByMakeModelRequest() {}
    private void processGetByYearRequest() {}

}
