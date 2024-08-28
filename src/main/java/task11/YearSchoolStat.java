package task11;

public class YearSchoolStat {
    int yearOfEntering;
    int numberOfSchools;

    YearSchoolStat(int yearOfEntering, int numberOfSchools){
        this.yearOfEntering = yearOfEntering;
        this.numberOfSchools = numberOfSchools;
    }

    public int getYearOfEntering(){
        return yearOfEntering;
    }

    public int getNumberOfSchools(){
        return numberOfSchools;
    }

    @Override
    public String toString() {
        return "YearSchoolStat{yearOfEntering=" + yearOfEntering + ", numberOfSchools=" + numberOfSchools + "}";
    }
}
