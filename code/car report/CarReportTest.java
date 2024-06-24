import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarReportTest {
    private CarReport report;

    @BeforeEach
    void setUp() {
        report = new CarReport();
    }

    // testGenerateReport Valid Car And OwnerName
    @Test
    void TestCase_1() {
        String expectedReport = "Car Report:\n" +
                "Name: Camry\n" +
                "Brand: Toyota\n" +
                "Model: 2019\n" +
                "Owner Name: Ali Ahmed\n" +
                "Renter Name: Mariam Ali\n" +
                "Engine: 2.5L 4-cylinder\n" +
                "Condition: Excellent\n" +
                "Company: ABC Car Rentals\n" +
                "Receiving Methods: []\n";

        List<Car> matchingCars = report.findCar("Camry", "Ali Ahmed");
        if (matchingCars.isEmpty()) {
            System.out.println("Car not found");
            return;
        }
        Car car = matchingCars.get(0);
        String generatedReport = report.generateReport(car);
        Assertions.assertEquals(expectedReport, generatedReport);
    }

    // Valid Car And OwnerName With ReceivingMethod
    @Test
    void TestCase_2() {
        String expectedReport = "Car Report:\n" +
                "Name: Camry\n" +
                "Brand: Toyota\n" +
                "Model: 2019\n" +
                "Owner Name: Ali Ahmed\n" +
                "Renter Name: Mariam Ali\n" +
                "Engine: 2.5L 4-cylinder\n" +
                "Condition: Excellent\n" +
                "Company: ABC Car Rentals\n" +
                "Receiving Methods: [Drop-off]\n";


        List<Car> matchingCars = report.findCar("Camry", "Ali Ahmed");
        if (matchingCars.isEmpty()) {
            System.out.println("Car not found");
            return;
        }
        Car car = matchingCars.get(0);
        car.addReceivingMethod("Drop-off");
        String generatedReport = report.generateReport(car);

        Assertions.assertEquals(expectedReport, generatedReport);
    }

    // Invalid Car Or OwnerName Returns Null
    @Test
    void TestCase_3() {
        List<Car> matchingCars = report.findCar("InvalidCar", "InvalidOwner");
        if (matchingCars.isEmpty()) {
            System.out.println("Car not found");
            return;
        }

        Car car = matchingCars.get(0);
        String generatedReport = report.generateReport(car);

        Assertions.assertNull(car);
        Assertions.assertNull(generatedReport);
    }



    // Duplicate CarName And OwnerName Returns All Matching Car
    @Test
    void TestCase_4() {
        String expectedCarName = "Corvette";
        String expectedOwnerName = "Omar Ahmed";

        List<Car> matchingCars = report.findCar("Corvette", "Omar Ahmed");

        Assertions.assertEquals(2, matchingCars.size());
        for (Car car : matchingCars) {
            Assertions.assertEquals(expectedCarName, car.getName());
            Assertions.assertEquals(expectedOwnerName, car.getOwnerName());
        }
    }
}