package HomeWork_2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

class Car {
    int id;
    String make;
    String model;
    int yearOfManufacture;
    String color;
    double price;
    String registrationNumber;

    // Constructor
    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    // Method to return car as a string
    @Override
    public String toString() {
        return "ID: " + id + ", Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture + 
               ", Color: " + color + ", Price: $" + price + ", Registration: " + registrationNumber;
    }
}
