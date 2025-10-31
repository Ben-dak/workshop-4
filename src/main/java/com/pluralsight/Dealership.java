package com.pluralsight;

import java.time.Year;
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
    //instance method
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> result = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if(v.getPrice() >= min && v.getPrice() <= max ) {
                result.add(v);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> result = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if(v.getMake().equalsIgnoreCase(make) && (v.getModel().equalsIgnoreCase(model)) ) {
                result.add(v);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        ArrayList<Vehicle> result = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if(v.getYear() >= minYear && v.getYear() <= maxYear) {
                result.add(v);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

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

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> result = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if(v.getColor().equalsIgnoreCase(color)) {
                result.add(v);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        ArrayList<Vehicle> result = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if(v.getOdometer() >= minMileage && v.getOdometer() <= maxMileage) {
                result.add(v);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> result = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if(v.getVehicleType().equalsIgnoreCase(type)) {
                result.add(v);
            }
        }
        return result;
    }
    public void removeVehicle(Vehicle vehicle) {
    }
}
