package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner myScanner = new Scanner(System.in);
    //will be using dealership class - can call

    // Show main menu and handle user choices (by calling display)
    public void display() {
        init();        //loads dealership

        boolean running = true;

        while (running) {
            displayMenu(); // calling helper method
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
                default -> System.err.println("Invalid option.");
            }
        }
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();  // loads from file
    }

    private void displayMenu() {
        System.out.println("""
                    === Dealership Home Menu ===
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
        System.out.println("Enter your choice: ");
    }

    private void processGetByPriceRequest() {
        System.out.println("Enter minimum price: ");
        String userInput = myScanner.nextLine();
        double min = Double.parseDouble(userInput);

        System.out.println("Enter maximum price: ");
        userInput = myScanner.nextLine();
        double max = Double.parseDouble(userInput);

        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByPrice(min, max);
        printVehicles(vehicles);
    }

    private void printVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println("\nVehicles matching your search: ");
        for (Vehicle v: vehicles) {
            System.out.println("Vin: " + v.getVin() + "|" +
                    "Year: " + v.getYear() + "|" +
                    "Make: " + v.getMake() + "|" +
                    "Model: " + v.getModel() + "|" +
                    "Type: " + v.getVehicleType() + "|" +
                    "Color: " + v.getColor() + "|" +
                    "Odometer: " + v.getOdometer() + "|" +
                    "Price: " + v.getPrice());
        }
    }

    private void processGetByMakeModelRequest() {
        System.out.println("Enter make to search by: ");
        String make = this.myScanner.nextLine();

        System.out.println("Enter model to search by: ");
        String model = this.myScanner.nextLine();

        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByMakeModel(make, model);
        printVehicles(vehicles);
    }

    private void processGetByYearRequest() {
        System.out.println("Enter minimum year to search by: ");
        String userInput = myScanner.nextLine();
        int minYear = Integer.parseInt(userInput);

        System.out.println("Enter maximum year to search by: ");
        userInput = myScanner.nextLine();
        int maxYear = Integer.parseInt(userInput);

        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByYear(minYear, maxYear);
        printVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.println("Enter color to search by: ");
        String color = this.myScanner.nextLine();

        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByColor(color);
        printVehicles(vehicles);

    }

    private void processGetByMileageRequest() {
        System.out.println("Enter minimum mileage to search by: ");
        String userInput = myScanner.nextLine();
        int minMileage = Integer.parseInt(userInput);

        System.out.println("Enter maximum mileage to search by: ");
        userInput = myScanner.nextLine();
        int maxMileage = Integer.parseInt(userInput);

        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByMileage(minMileage, maxMileage);
        printVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("Enter vehicle type to search by: ");
        String type = this.myScanner.nextLine();

        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByType(type);
        printVehicles(vehicles);

    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = this.dealership.getAllVehicles();
        printVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        Vehicle v = new Vehicle();
        dealership.addVehicle(v);

        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(this.dealership);
    }

    private void processRemoveVehicleRequest() {

    }






}


