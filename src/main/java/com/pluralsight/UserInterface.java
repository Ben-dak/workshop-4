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
            int input = myScanner.nextInt();
            myScanner.nextLine(); //trying out nextInt

            switch (input) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 10 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();  // loads from file
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

    public void processAddVehicleRequest() {
        Vehicle v = new Vehicle();
        dealership.addVehicle(v);

        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(this.dealership);
    }

    private void processGetByPriceRequest() {

    }
    private void processGetByMakeModelRequest() {

    }
    private void processGetByYearRequest() {

    }

    private void processRemoveVehicleRequest() {

    }

    private void processGetByVehicleTypeRequest() {

    }

    private void processGetAllVehiclesRequest() {

    }

    private void processGetByMileageRequest() {
    }

    private void processGetByColorRequest() {

    }


}
