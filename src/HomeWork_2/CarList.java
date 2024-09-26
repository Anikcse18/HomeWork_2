package HomeWork_2;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class CarList {
    public static void main(String[] args) throws IOException {
        // Create a list of car objects
        List<Car> carList = new ArrayList<>();
        Car car_1 = new Car(1, "Toyota", "Corolla", 2010, "Blue", 8000.00, "ABC123");
        Car car_2 = new Car(2, "Honda", "Civic", 2015, "Black", 12000.00, "XYZ456");
        Car car_3 = new Car(3, "Ford", "Focus", 2018, "Red", 14000.00, "LMN789");
        Car car_4 = new Car(4, "Toyota", "Camry", 2012, "White", 9000.00, "QRS321");
        Car car_5 = new Car(5, "Honda", "Accord", 2008, "Green", 7000.00, "TUV654");
        Car car_6 = new Car(6, "Toyota", "RAV4", 2020, "Silver", 25000.00, "JKL012");
        Car car_7 = new Car(7, "Honda", "CR-V", 2019, "Blue", 27000.00, "MNO345");
        Car car_8 = new Car(8, "Ford", "Escape", 2017, "Black", 22000.00, "PQR678");
        Car car_9 = new Car(9, "Toyota", "Highlander", 2021, "Gray", 35000.00, "STU901");
        Car car_10 = new Car(10, "Honda", "Fit", 2014, "Red", 15000.00, "VWX234");
        
        carList.add(car_1);
        carList.add(car_2);
        carList.add(car_3);
        carList.add(car_4);
        carList.add(car_5);
        carList.add(car_6);
        carList.add(car_7);
        carList.add(car_8);
        carList.add(car_9);
        carList.add(car_10);
        
        
        

        // Filter cars by a specific make (brand)
        List<Car> carsByMake = filterCarsByMake(carList, "Toyota");
        saveToFile(carsByMake, "cars_by_make.txt");

        // Filter cars by a specific model that have been in use for more than 'n' years
        List<Car> carsByModelAndYears = filterCarsByModelAndYears(carList, "Civic", 5);
        saveToFile(carsByModelAndYears, "cars_by_model_and_years.txt");

        // Filter cars by year of manufacture and price
        List<Car> carsByYearAndPrice = filterCarsByYearAndPrice(carList, 2010, 8000);
        saveToFile(carsByYearAndPrice, "cars_by_year_and_price.txt");
        
        
    }

    // Filter cars by a given make (brand)
    public static List<Car> filterCarsByMake(List<Car> carList, String make) {
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.make.equalsIgnoreCase(make)) {
                result.add(car);
            }
        }
        return result;
    }

    // Filter cars by model that have been in use for more than 'n' years
    public static List<Car> filterCarsByModelAndYears(List<Car> carList, String model, int years) {
        List<Car> result = new ArrayList<>();
        int currentYear = Year.now().getValue();
        for (Car car : carList) {
            if (car.model.equalsIgnoreCase(model) && (currentYear - car.yearOfManufacture) > years) {
                result.add(car);
            }
        }
        return result;
    }

    // Filter cars by year of manufacture and price higher than specified value
    public static List<Car> filterCarsByYearAndPrice(List<Car> carList, int year, double price) {
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.yearOfManufacture == year && car.price > price) {
                result.add(car);
            }
        }
        return result;
    }

    // Save the list of cars to a file
    public static void saveToFile(List<Car> cars, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (Car car : cars) {
            writer.write(car.toString() + "\n");
        }
        writer.close();
        System.out.println("Saved to " + fileName);
    }
}