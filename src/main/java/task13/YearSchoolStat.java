package task13;

public class YearSchoolStat {
    int yearOfEntering;
    int schoolsNumber;

    public YearSchoolStat(int yearOfEntering, int schoolsNumber) {
        this.yearOfEntering = yearOfEntering;
        this.schoolsNumber = schoolsNumber;
    }

    public int getYearOfEntering() {
        return yearOfEntering;
    }

    public int getSchoolsNumber() {
        return schoolsNumber;
    }

    @Override
    public String toString() {
        return "YearSchoolStat{" +
                "yearOfEntering=" + yearOfEntering +
                ", schoolsNumber=" + schoolsNumber +
                '}';
    }
}
