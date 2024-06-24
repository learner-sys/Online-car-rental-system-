import java.time.LocalDate;

class Car {
    private final String name;
    private final String model;
    private final String color;
    private LocalDate rentDate;
    private LocalDate returnDate;

    public Car(String name, String model, String color) {
        this.name = name;
        this.model = model;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getModel() {

        return model;
    }

    public String getColor() {

        return color;
    }

    public void setRentDate(LocalDate rentDate) {

        this.rentDate = rentDate;
    }

    public void setReturnDate(LocalDate returnDate) {

        this.returnDate = returnDate;
    }

}
