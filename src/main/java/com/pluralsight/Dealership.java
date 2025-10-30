package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory; //keep private
     //instantiated array list vehicle so its never null

    //constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    // These 2 instance methods get inventory from the Vehicle class
    public void addVehicle(Vehicle newVehicle) {
        inventory.add(newVehicle);
    }
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    // placeholders
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByType(String type) {
        return null;
    }
    public void removeVehicle(Vehicle vehicle) {
        // intentionally blank
    }

    //getters and setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
