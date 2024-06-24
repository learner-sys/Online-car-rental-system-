import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class CarRentalSystemTest {
    private CarRentalSystem rentalSystem;

    @BeforeEach
    public void setUp() {
        rentalSystem = new CarRentalSystem();
    }

    // Test with exist, and correct car details.
    @Test
    public void testRentCar_Successfully() {
        String carName = "Corolla";
        String carModel = "2022";
        String carColor = "Red";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("success", result);
    }

    // invalid car name that contains less than 5 letters.
    @Test
    public void Invalid_CarName() {
        String carName = "Co";
        String carModel = "2022";
        String carColor = "Red";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Car name must contain a minimum of 5 letters and a maximum of 50 letters", result);
    }

    // invalid car name that contains more than 50 letters.
    @Test
    public void Invalid_Car_Name() {
        String carName = "Corollaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String carModel = "2022";
        String carColor = "Red";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Car name must contain a minimum of 5 letters and a maximum of 50 letters", result);
    }

 // Test with non-existent, and correct car details.
    @Test
    public void NotFound() {
        String carName = "Nissan";
        String carModel = "2022";
        String carColor = "Blue";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Car not found", result);
    }

    // Test with invalid car model that contains (letters) instead of digits.
    @Test
    public void InvalidCarModel() {
        String carName = "Corolla";
        String carModel = "abc";
        String carColor = "Red";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Invalid car model. Please provide a 4-digit model year between 2004 and 2026", result);
    }

// Test with invalid car model that contains less than 4 digits.
    @Test
    public void InvalidCarModel_() {
        String carName = "Corolla";
        String carModel = "202";
        String carColor = "Red";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Invalid car model. Please provide a 4-digit model year between 2004 and 2026", result);
    }

    // Test with invalid car model that contains more than 4 digits.
    @Test
    public void InvalidCar_Model() {
        String carName = "Corolla";
        String carModel = "20200";
        String carColor = "Red";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Invalid car model. Please provide a 4-digit model year between 2004 and 2026", result);
    }

    //Test with non-exist car model in the system.

    @Test
    public void non_ExistCarModel() {
        String carName = "Corolla";
        String carModel = "2024";
        String carColor = "Red";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Car not found", result);
    }

//Test with invalid car color that contains less than 3 letters.
    @Test
    public void InvalidCarColor() {
        String carName = "Corolla";
        String carModel = "2022";
        String carColor = "R";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Car color must contain a minimum of 3 letters and a maximum of 20 letters", result);
    }

    //Test with invalid car color that contains more than 20 letters.
    @Test
    public void InvalidCarColor_() {
        String carName = "Corolla";
        String carModel = "2022";
        String carColor = "edqoririfjfirdjeorlridfj";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Car color must contain a minimum of 3 letters and a maximum of 20 letters", result);
    }
// Test with non-exist car color.
    @Test
    public void non_ExistCarColor() {
        String carName = "Corolla";
        String carModel = "2022";
        String carColor = "Blue";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Car not found", result);
    }

//Test with invalid rent date
    @Test
    public void Invalid_RentDate() {
        String carName = "Corolla";
        String carModel = "2022";
        String carColor = "Red";
        LocalDate rentDate = LocalDate.now().minusDays(1);
        LocalDate returnDate = rentDate.plusDays(3);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Invalid rent date. Rent date must be the current date or a future date", result);
    }

    // Invalid Return date
    @Test
    public void Invalid_ReturnDate() {
        String carName = "Corolla";
        String carModel = "2022";
        String carColor = "Red";
        LocalDate rentDate = LocalDate.now().plusDays(1);
        LocalDate returnDate = rentDate.plusDays(6);

        String result = rentalSystem.rentCar(carName, carModel, carColor, rentDate, returnDate);
        assertEquals("Invalid return date. Return date must be within 5 days from the rent date", result);
    }

}