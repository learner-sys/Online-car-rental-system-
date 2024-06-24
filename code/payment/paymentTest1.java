import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    private Payment payment;

    @BeforeEach
    void setup() {
        // Set up the input stream for testing user input
        String input = "1\n2"; // Simulates user entering 1 for cash and 2 for pickup
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Create the Payment instance with the mock scanner
        this.payment = new Payment(scanner);
    }

    @Test
    void processCashPayment() {
        assertEquals("Cash payment accepted for pickup", payment.processCashPayment());
    }



}
