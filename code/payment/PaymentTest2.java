import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest2 {
    private Payment payment;
    @Test
    void useCase01()
    {
        // INVALID PAYMENT METHOD
        int paymentMethod = 3;
        Payment payment = new Payment(new Scanner(""));
        assertEquals("Invalid payment method selected", payment.processPaymentMethod(paymentMethod));
    }

    @Test
    void useCase02()
    {
        //VALID CASH PAYMENT, VALID RECEIVING METHOD
        //user entering 1 for cash and 2 for pickup
        String input = "2";
        Payment payment = new Payment(input);
        assertEquals("Cash payment accepted for pickup", payment.processCashPayment());
    }
    @Test
    void useCase03()
    {
        //VALID CASH PAYMENT, INVALID RECEIVING METHOD
        //user entering 1 for cash and 1 for pickup
        String input = "1";
        Payment payment = new Payment(input);
        assertEquals("Cash payment is not accepted for drop-off", payment.processCashPayment());
    }
    @Test
    void useCase04()
    {
        //VALID CASH PAYMENT, INVALID RECEIVING METHOD
        //user entering 1 for cash and 3 for pickup
        String input = "3";
        Payment payment = new Payment(input);
        assertEquals("Invalid receiving method selected", payment.processCashPayment());
    }

    @Test
    void useCase05()
    {
        //CREDITCARD- PICKUP - ALL INFORMATIONS ARE CORRECT
        String input = "2\nSara\n1234567890123456\n12/2024\n";
        Payment payment = new Payment(input);
        assertEquals("Credit card payment accepted", payment.processCreditCardPayment());
    }
    @Test
    void useCase06()
    {
        //CREDITCARD- DROPPOFF - ALL INFORMATIONS ARE CORRECT
        String input = "1\nSara\n1234567890123456\n12/2024\n";
        Payment payment = new Payment(input);
        assertEquals("Credit card payment accepted", payment.processCreditCardPayment());
    }
    @Test
    void useCase07()
    {
        //INVALID CARD NAME
        String input = "2\n123Sara\n1234567890123456\n12/2024\n";
        Payment payment = new Payment(input);
        assertEquals("Invalid name. Name should not contain digits.", payment.processCreditCardPayment());
    }
    @Test
    void useCase08()
    {
        //INVALID CARD Number
        String input = "2\nSara\n123456\n12/2024\n";
        Payment payment = new Payment(input);
        assertEquals("Invalid card number. It should be numeric and have more than 16 digits.", payment.processCreditCardPayment());
    }
    @Test
    void useCase09()
    {
        //INVALID expiryDate
        String input = "2\nSara\n1234567890123456\n12\n";
        Payment payment = new Payment(input);
        assertEquals("Invalid expiry date. It should be in the format MM/YYYY and not in the past.", payment.processCreditCardPayment());
    }
    @Test
    void useCase10()
    {
        // expiryDate IN PAST
        String input = "2\nSara\n1234567890123456\n12/2014\n";
        Payment payment = new Payment(input);
        assertEquals("Invalid expiry date. It should be in the format MM/YYYY and not in the past.", payment.processCreditCardPayment());
    }
    @Test
    void useCase11()
    {
        // INVALID Recieving method for Credit Card payment
        String input = "3\nSara\n1234567890123456\n12/2014\n";
        Payment payment = new Payment(input);
        assertEquals("Invalid receiving method selected", payment.processCreditCardPayment());
    }




    }





