package task11;

public class Entrant {
    int schoolNumber;
    int yearOfEntering;
    String lastName;

    Entrant(int schoolNumber, int yearOfEntering, String lastName) {
        this.schoolNumber = schoolNumber;
        this.yearOfEntering = yearOfEntering;
        this.lastName = lastName;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public int getYearOfEntering() {
        return yearOfEntering;
    }
}
