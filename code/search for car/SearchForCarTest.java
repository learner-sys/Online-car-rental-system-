import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SearchForCarTest {

    @Test //TestCase_1
    public void testSearchCarsByName() {
        List<Car> matchingCars = SearchForCar.searchCars("Honda Civic", "", "", "", "");
        Assertions.assertEquals(2, matchingCars.size());
        Assertions.assertEquals("Honda Civic", matchingCars.get(0).getName());
        Assertions.assertEquals("Honda Civic", matchingCars.get(1).getName());
    }

    @Test //TestCase_2
    public void testSearchCarsByColor() {
        List<Car> matchingCars = SearchForCar.searchCars("", "Red", "", "", "");
        Assertions.assertEquals(3, matchingCars.size());
        Assertions.assertEquals("Ford Mustang", matchingCars.get(0).getName());
        Assertions.assertEquals("Mercedes-Benz C-Class", matchingCars.get(1).getName());
        Assertions.assertEquals("Ferrari Roma", matchingCars.get(2).getName());
    }

    @Test //TestCase_3
    public void testSearchCarsByModel() {
        List<Car> matchingCars = SearchForCar.searchCars("", "", "Sports Car", "", "");
        Assertions.assertEquals(2, matchingCars.size());
        Assertions.assertEquals("BMW X5", matchingCars.get(0).getName());
        Assertions.assertEquals("Ferrari Roma", matchingCars.get(1).getName());
    }

    @Test //TestCase_4
    public void testSearchCarsByCompanyName() {
        List<Car> matchingCars = SearchForCar.searchCars("", "", "", "Toyota", "");
        Assertions.assertEquals(2, matchingCars.size());
        Assertions.assertEquals("Toyota Yaris", matchingCars.get(0).getName());
        Assertions.assertEquals("Toyota Camry", matchingCars.get(1).getName());
    }

    @Test //TestCase_5
    public void testSearchCarsByReservedStatus() {
        List<Car> matchingCars = SearchForCar.searchCars("", "", "", "", "Reserved");
        Assertions.assertEquals(6, matchingCars.size());
        Assertions.assertEquals("Ford Mustang", matchingCars.get(0).getName());
        Assertions.assertEquals("Toyota Yaris", matchingCars.get(1).getName());
        Assertions.assertEquals("Honda Civic", matchingCars.get(2).getName());
        Assertions.assertEquals("Chevrolet Corvette", matchingCars.get(3).getName());
        Assertions.assertEquals("Audi A4", matchingCars.get(4).getName());
        Assertions.assertEquals("Nissan Altima", matchingCars.get(5).getName());
    }

    @Test //TestCase_6
    public void testSearchCarsByNotReservedStatus() {
        List<Car> matchingCars = SearchForCar.searchCars("", "", "", "", "Not Reserved");
        Assertions.assertEquals(7, matchingCars.size());
        Assertions.assertEquals("Mercedes-Benz C-Class", matchingCars.get(0).getName());
        Assertions.assertEquals("Toyota Camry", matchingCars.get(1).getName());
        Assertions.assertEquals("Honda Civic", matchingCars.get(2).getName());
        Assertions.assertEquals("BMW X5", matchingCars.get(3).getName());
        Assertions.assertEquals("Ferrari Roma", matchingCars.get(4).getName());
        Assertions.assertEquals("Volkswagen Golf", matchingCars.get(5).getName());
        Assertions.assertEquals("Tesla Model S", matchingCars.get(6).getName());
    }

    @Test //TestCase_7
    public void testSearchCarsNoMatch() {
        List<Car> matchingCars = SearchForCar.searchCars("Tesla Model 3", "", "", "", "");
        Assertions.assertTrue(matchingCars.isEmpty());
    }

    @Test //TestCase_8
    public void testSearchCarsMultipleCriteria() {
        List<Car> matchingCars = SearchForCar.searchCars("Honda Civic", "White", "", "", "");
        Assertions.assertEquals(1, matchingCars.size());
        Assertions.assertEquals("Honda Civic", matchingCars.get(0).getName());
        Assertions.assertEquals("White", matchingCars.get(0).getColor());
    }

    @Test //TestCase_9
    public void testSearchCarsWithSpecialCharacters() {
        List<Car> matchingCars = SearchForCar.searchCars("Mercedes-Benz C-Class", "", "", "", "");
        Assertions.assertEquals(1, matchingCars.size());
        Assertions.assertEquals("Mercedes-Benz C-Class", matchingCars.get(0).getName());
    }

    @Test //TestCase_10
    public void testSearchCarsWithInvalidInput() {
        List<Car> matchingCars = SearchForCar.searchCars("123", "", "", "", "");
        Assertions.assertTrue(matchingCars.isEmpty());
    }

    @Test //TestCase_11
    public void testSearchCarsWithMultipleMatches() {
        List<Car> matchingCars = SearchForCar.searchCars("", "Silver", "", "", "");
        Assertions.assertEquals(2, matchingCars.size());
        Assertions.assertEquals("Toyota Camry", matchingCars.get(0).getName());
        Assertions.assertEquals("BMW X5", matchingCars.get(1).getName());
    }

    @Test //TestCase_12
    public void testSearchCarsWithNoMatches() {
        List<Car> matchingCars = SearchForCar.searchCars("Tesla Model 3", "Black", "", "", "");
        Assertions.assertTrue(matchingCars.isEmpty());
    }

    @Test //TestCase_13
    public void testValidateUserInput_ValidInput() {
        String userInput = "Toyota yaris";
        boolean result = SearchForCar.validateUserInput(userInput);
        Assertions.assertTrue(result);
    }

    @Test //TestCase_14
    public void testValidateUserInput_InvalidInput() {
        String userInput = "Chevrolet@Corvette!";
        boolean result = SearchForCar.validateUserInput(userInput);
        Assertions.assertFalse(result);
    }

}
