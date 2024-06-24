import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Car {
    private String name;
    private String brand;
    private String model;
    private String ownerName;
    private String renterName;
    private String engine;
    private String condition;
    private String company;
    private ArrayList<String> receivingMethods;

    public Car(String name, String brand, String model, String ownerName, String renterName, String engine, String condition, String company) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.ownerName = ownerName;
        this.renterName = renterName;
        this.engine = engine;
        this.condition = condition;
        this.company = company;
        this.receivingMethods = new ArrayList<>();
    }

    public void addReceivingMethod(String method) {
        receivingMethods.add(method);
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getRenterName() {
        return renterName;
    }

    public String getEngine() {
        return engine;
    }

    public String getBrand() {
        return brand;
    }

    public String getCondition() {
        return condition;
    }

    public String getCompany() {
        return company;
    }

    public List<String> getReceivingMethods() {
        return receivingMethods;
    }
}

public class CarReport {
    private ArrayList<Car> carList;

    public CarReport() {
        carList = new ArrayList<>();
        carList.add(new Car("Camry", "Toyota", "2019", "Ali Ahmed", "Mariam Ali", "2.5L 4-cylinder", "Excellent", "ABC Car Rentals"));
        carList.add(new Car("Civic", "Honda", "2020", "Mohammed Hasan", "Noor Ahmed", "1.8L 4-cylinder", "Good", "XYZ Car Rentals"));
        carList.add(new Car("X5", "BMW", "2021", "Zahra'a Hasan", "Ahmed Ali", "3.0L 6-cylinder", "Excellent", "PQR Car Rentals"));
        carList.add(new Car("Mustang", "Ford", "2018", "Jassim Nooh", "Jaffer Hasan", "3.0L 6-cylinder", "Excellent", "XYZ Car Rentals"));
        carList.add(new Car("Corvette", "Chevrolet", "2022", "Omar Ahmed", "Saqer Mohammed", "6.2L V8", "Excellent", "ABC Car Rentals"));
        carList.add(new Car("Corvette", "Chevrolet", "2005", "Omar Ahmed", "Marwa Ahmed", "6.2L V8", "Good", "ABC Car Rentals"));

    }

    public String generateReport(Car car) {
        String report = "Car Report:\n";
        report += "Name: " + car.getName() + "\n";
        report += "Brand: " + car.getBrand() + "\n";
        report += "Model: " + car.getModel() + "\n";
        report += "Owner Name: " + car.getOwnerName() + "\n";
        report += "Renter Name: " + car.getRenterName() + "\n";
        report += "Engine: " + car.getEngine() + "\n";
        report += "Condition: " + car.getCondition() + "\n";
        report += "Company: " + car.getCompany() + "\n";
        report += "Receiving Methods: " + car.getReceivingMethods() + "\n";
        return report;
    }

    public List<Car> findCar(String name, String ownerName) {
        List<Car> matchingCars = new ArrayList<>();
        for (Car car : carList) {
            if (car.getName().equalsIgnoreCase(name) && car.getOwnerName().equalsIgnoreCase(ownerName)) {
                matchingCars.add(car);
            }
        }
        return matchingCars;
    }

    public static void main(String[] args) {
        CarReport report = new CarReport();
        Scanner kbd = new Scanner(System.in);

        System.out.print("Enter car name: ");
        String name = kbd.nextLine();

        System.out.print("Enter owner name: ");
        String ownerName = kbd.nextLine();

        // find car with selected name and ownername then retrieve car report information
        List<Car> matchingCars = report.findCar(name, ownerName);
        if (matchingCars.isEmpty()) {
            System.out.println("Car not found");
            return;
        }



        System.out.print("Enter receiving method (Drop-off/Pick-up): ");
        String receivingMethod = kbd.nextLine();

        for (Car selectedCar : matchingCars) {
            selectedCar.addReceivingMethod(receivingMethod);

            String generatedReport = report.generateReport(selectedCar);
            System.out.println(generatedReport);

        }
    }
}
