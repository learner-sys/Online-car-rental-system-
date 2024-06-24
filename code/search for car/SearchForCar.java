import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Car {
    private String name;
    private String color;
    private String model;
    private String companyName;
    private String carStatus;

    public Car(String name, String color, String model, String companyName, String carStatus) {
        this.name = name;
        this.color = color;
        this.model = model;
        this.companyName = companyName;
        this.carStatus = carStatus;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public static String removeSpecialCharacters(String input) {

        return input.replaceAll("[^a-zA-Z0-9 ]", "");
    }
}
public class SearchForCar {
    private static List<Car> availableCars = Arrays.asList(
            new Car("Ford Mustang", "Red", "Sedan", "Ford", "Reserved"),
            new Car("Mercedes-Benz C-Class", "Red", "Convertible", "Mercedes", "Not Reserved"),
            new Car("Toyota Yaris", "Gold", "SUV", "Toyota", "Reserved"),
            new Car("Toyota Camry", "Silver", "Coupe", "Toyota", "Not Reserved"),
            new Car("Honda Civic", "Blue", "Pickup Truck", "Honda", "Not Reserved"),
            new Car("Honda Civic", "White", "Pickup Truck", "Honda", "Reserved"),
            new Car("BMW X5", "Silver", "Sports Car", "BMW", "Not Reserved"),
            new Car("Ferrari Roma", "Red", "Sports Car", "Ferrari", "Not Reserved"),
            new Car("Chevrolet Corvette", "Green", "Minivan", "Chevrolet", "Reserved"),
            new Car("Audi A4", "Gray", "Hybrid", "Audi", "Reserved"),
            new Car("Nissan Altima", "Pearl White", "Coupe", "Nissan", "Reserved"),
            new Car("Volkswagen Golf", "Black", "Hatchback", "Volkswagen", "Not Reserved"),
            new Car("Tesla Model S", "Green", "Electric Vehicle (EV)", "Tesla", "Not Reserved")
    );

    public static boolean validateUserInput(String input) {

        return input.matches("[a-zA-Z0-9 ]+");
    }

    public static List<Car> convertArrayToArrayList(Car[] cars) {

        return new ArrayList<>(Arrays.asList(cars));
    }

    public static List<Car> searchCars(String name, String color, String model, String companyName, String carStatus) {
        List<Car> searchedCars = new ArrayList<>();

        for (Car car : availableCars) {
            if ((name.equals("") || car.getName().equals(name))
                    && (color.equals("") || car.getColor().equals(color))
                    && (model.equals("") || car.getModel().equals(model))
                    && (companyName.equals("") || car.getCompanyName().equals(companyName))
                    && (carStatus.equals("") || car.getCarStatus().equals(carStatus))) {
                searchedCars.add(car);
            }
        }

        return searchedCars;
    }

    public static String showCarDetails(Car[] cars) {
        StringBuilder details = new StringBuilder();
        for (Car car : cars) {
            details.append("Name: ").append(car.getName()).append("\n");
            details.append("Color: ").append(car.getColor()).append("\n");
            details.append("Model: ").append(car.getModel()).append("\n");
            details.append("Company Name: ").append(car.getCompanyName()).append("\n");
            details.append("Car Status: ").append(car.getCarStatus()).append("\n\n");
        }
        return details.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Online Car Rental System!\n");
        System.out.print("Please enter the following information to search for a Car:\n");
        System.out.print("Note: you can write 'anything' in the filed that you don't want to specify.\n");
        System.out.print("Enter car name: ");
        String name = scanner.nextLine();
        System.out.print("Enter car color: ");
        String color = scanner.nextLine();
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        System.out.print("Enter car company name: ");
        String companyName = scanner.nextLine();

        String cleanedName = Car.removeSpecialCharacters(name);
        String cleanedColor = Car.removeSpecialCharacters(color);
        String cleanedModel = Car.removeSpecialCharacters(model);
        String cleanedCompanyName = Car.removeSpecialCharacters(companyName);
        String carStatus = "";

        if (!validateUserInput(cleanedName) || !validateUserInput(cleanedColor)
                || !validateUserInput(cleanedModel) || !validateUserInput(cleanedCompanyName)) {
            System.out.println("Invalid input! Please enter re-enter alphanumeric values only.");
            return;
        }

        Car[] carsArray = {
                new Car(cleanedName, cleanedColor, cleanedModel, cleanedCompanyName, carStatus)
        };

        List<Car> carsList = convertArrayToArrayList(carsArray);

        List<Car> matchingCars = new ArrayList<>();
        for (Car car : availableCars) {
            if (car.getName().equalsIgnoreCase(cleanedName) ||
                    car.getColor().equalsIgnoreCase(cleanedColor) ||
                    car.getModel().equalsIgnoreCase(cleanedModel) ||
                    car.getCompanyName().equalsIgnoreCase(cleanedCompanyName)) {
                matchingCars.add(car);
            }
        }

        if (matchingCars.isEmpty()) {
            System.out.println("No cars found matching the entered input!.");
        } else {
            System.out.println("\nAvailable Cars:\n");
            System.out.println(showCarDetails(matchingCars.toArray(new Car[0])));
        }
    }
}
