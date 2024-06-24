import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class CarRentalSystem {
    private final ArrayList<Car> carList;

    public CarRentalSystem() {
        carList = new ArrayList<>();
        carList.add(new Car("Corolla", "2022", "Red"));
        carList.add(new Car("Mercedes", "2024", "Black"));
        carList.add(new Car("Camry", "2004", "Blue"));
        carList.add(new Car("Audi", "2020", "gray"));
    }

    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        rentalSystem.run();
    }

    public void run() {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Car Rental System\n");

        // Input
        System.out.print("Enter car name: ");
        String carName = in.nextLine();
        System.out.print("Enter car model (4-digit year): ");
        String carModel = in.nextLine();
        System.out.print("Enter car color: ");
        String carColor = in.nextLine();
        System.out.print("Enter rent date (YYYY-MM-DD): ");
        String rentDateStr = in.nextLine();
        System.out.print("Enter return date (YYYY-MM-DD): ");
        String returnDateStr = in.nextLine();



        // Find the car in the carList based on carName, carModel, and carColor
        Car selectedCar = findCar(carName, carModel, carColor);
        if (selectedCar == null) {
            System.out.println("Car not found");
            return;
        }

        selectedCar.setRentDate(LocalDate.parse(rentDateStr));
        selectedCar.setReturnDate(LocalDate.parse(returnDateStr));

        System.out.println("Car rented successfully");
    }

    public String rentCar(String carName, String carModel, String carColor, LocalDate rentDate, LocalDate returnDate) {
        if (carName.length() < 5 || carName.length() > 50) {
            return "Car name must contain a minimum of 5 letters and a maximum of 50 letters";
        }

        if (carModel.length() != 4 || !carModel.matches("\\d{4}")) {
            return "Invalid car model. Please provide a 4-digit model year between 2004 and 2026";
        }

        if (carColor.length() < 3 || carColor.length() > 20) {
            return "Car color must contain a minimum of 3 letters and a maximum of 20 letters";
        }

        LocalDate currentDate = LocalDate.now();
        if (rentDate.isBefore(currentDate)) {
            return "Invalid rent date. Rent date must be the current date or a future date";
        }

        if (returnDate.isBefore(rentDate) || returnDate.isAfter(rentDate.plusDays(5))) {
            return "Invalid return date. Return date must be within 5 days from the rent date";
        }


      // Check if the car with the given name, model, and color exists in the carList
        Car selectedCar = findCar(carName, carModel, carColor);
        if (selectedCar == null) {
            return "Car not found";
        }

        return "success";
    }


   private Car findCar(String carName, String carModel, String carColor) {
        for (Car car : carList) {
            if (car.getName().equalsIgnoreCase(carName) && car.getModel().equalsIgnoreCase(carModel) && car.getColor().equalsIgnoreCase(carColor)) {
                return car;
            }
        }
        return null;
    }
}
