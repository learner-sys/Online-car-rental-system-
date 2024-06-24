import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Payment {
    private Scanner scanner;

    private String cName;
    private String cNumber;
    private String eDate;

    public Payment(String cName, String cNumber, String eDate) {
        this.cName = cName;
        this.cNumber = cNumber;
        this.eDate = eDate;
        this.scanner = new Scanner("");
    }

    public Payment(Scanner scanner) {
        this.scanner = scanner;
    }

    public Payment(String inputString) {
        this.scanner = new Scanner(inputString);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method:\n1.Cash\n2.Credit Card");
        int paymentMethod = scanner.nextInt();
        System.out.println("-----------------------------------------");
        Payment payment = new Payment(scanner);
        String result = payment.processPaymentMethod(paymentMethod);
        System.out.println(result);
        scanner.close();
    }
    public String processPaymentMethod(int paymentMethod) {
        if (paymentMethod == 1) {
            return processCashPayment();
        }
        else if (paymentMethod == 2)
        {
            return processCreditCardPayment();
        }
        else
        {
            return "Invalid payment method selected";
        }
    }

    public String processCashPayment() {


        System.out.println("Select receiving method:\n1.Drop-off\n2.Pickup");
        int receivingMethod = scanner.nextInt();
        System.out.println("-----------------------------------------");

        if (receivingMethod == 2)
        {
            return "Cash payment accepted for pickup";
        }
        else if (receivingMethod == 1)
        {
            return "Cash payment is not accepted for drop-off";
        }
        else
        {
            return "Invalid receiving method selected";
        }
    }

    public String processCreditCardPayment()
    {
        System.out.println("Select receiving method:\n1.Drop-off\n2.Pickup");
        int receivingMethod = scanner.nextInt();
        System.out.println("-----------------------------------------");
        if (receivingMethod == 1 || receivingMethod == 2) // validate credit card payment for the selected receiving method
        {
            System.out.println("Enter cardholder's name: ");
            String cardholderName = scanner.next();
            System.out.println("Enter card number: ");
            String cardNumber = scanner.next();
            System.out.println("Enter expiry date (MM/YYYY): ");
            String expiryDate = scanner.next();
            if (!isValidName(cardholderName)) // validation for credit card
            {
                System.out.println("Invalid name. Name should not contain digits.");
                return "Invalid name. Name should not contain digits.";
            }

            if (!isValidCardNumber(cardNumber)) {
                System.out.println("Invalid card number. It should be numeric and have more than 16 digits.");
                return "Invalid card number. It should be numeric and have more than 16 digits.";
            }

            if (!isValidExpiryDate(expiryDate)) {
                System.out.println("Invalid expiry date. It should be in the format MM/YYYY and not in the past.");
                return "Invalid expiry date. It should be in the format MM/YYYY and not in the past.";
            }
            // display payment confirmation
            System.out.println("Credit card payment accepted");
            return "Credit card payment accepted";
        }
        else
        {
            System.out.println("Invalid receiving method selected");
            return "Invalid receiving method selected";
        }

    }

    private boolean isValidName(String name) {
        // check if name contains only letters (no digits)
        return !Pattern.compile("[0-9]").matcher(name).find();
    }

    private boolean isValidCardNumber(String cardNumber)
    {
        return cardNumber.matches("\\d{16}");// check if card number is numeric and has more than 16 digits
    }

    private boolean isValidExpiryDate(String expiryDate)
    {
        int i = 0;
        while (i < expiryDate.length()) {
            if (!(Character.isDigit(expiryDate.charAt(i)) || expiryDate.charAt(i) == '/')) {
                return false;
            }
            i++;
        }

        if (expiryDate.matches("^(0[1-9]|1[0-2])/\\d{4}$"))
        {
            String year = expiryDate.substring(3); // extract the year from the input string
            int expiryYear = Integer.parseInt(year);

            if (expiryYear <= 2023)
            {
                return false; // if the year is less than or equal 2023, return false
            }
            return true;
        }
        else {
            return false;
        }
    }

}
