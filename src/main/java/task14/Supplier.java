package task14;

public class Supplier {
    int customerId;
    int yearOfBirthday;
    String streetOfResidence;

    public Supplier(int customerId, int yearOfBirthday, String streetOfResidence) {
        this.customerId = customerId;
        this.yearOfBirthday = yearOfBirthday;
        this.streetOfResidence = streetOfResidence;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getYearOfBirthday() {
        return yearOfBirthday;
    }

    public String getStreetOfResidence() {
        return streetOfResidence;
    }
}
