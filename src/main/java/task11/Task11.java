package task11;

import java.util.*;
import java.util.stream.Collectors;
/*
Task 11.
A sequence of data about applicants nameList of type Entrant is given.
Each element of the sequence includes the fields <school_number> <year_of_entering> <last_name>
Get data (list of YearSchoolStat values) about the number of different schools that applicants graduated
from for each year present in the source data.
The YearSchoolStat type includes the <year_of_entering> <number_of_schools> fields.
The list of YearSchoolStat values must be sorted in ascending order of the number of schools,
and for matching values, in ascending order of the year number.
Look at the template on the end of the task before solving the problem.
For example:
input: { (1, 1993, “Ivanov”), (2, 1992, “Petrov”), (3, 1993, “Pupkin”), (3, 2000, “Zobkin”), (3, 2000, “Zabkin”) }
output: { YearSchoolStat{yearOfEntering=1992, numberOfSchools=1}, YearSchoolStat{yearOfEntering=2000, numberOfSchools=1},
        YearSchoolStat{yearOfEntering=1993, numberOfSchools=2} }
 */

public class Task11 {
    public static void main(String[] args) {
        List<Entrant> nameList = Arrays.asList(
                new Entrant(1, 1993, "Ivanov"),
                new Entrant(2, 1992, "Petrov"),
                new Entrant(3, 1993, "Pupkin"),
                new Entrant(3, 2000, "Zobkin"),
                new Entrant(3, 2000, "Zabkin")
        );
        List<YearSchoolStat> result = solution(nameList);

        // Print the result
        result.forEach(System.out::println);
    }
    public static List<YearSchoolStat> solution(List<Entrant> nameList){
        return nameList.stream()
                .collect(Collectors.groupingBy(
                        Entrant::getYearOfEntering, // Group by year
                        Collectors.mapping(
                                Entrant::getSchoolNumber, // Extract school number
                                Collectors.toSet() // Collect distinct school numbers
                        )
                ))
                .entrySet().stream()
                .map(entry -> new YearSchoolStat(entry.getKey(), entry.getValue().size())) // Create YearSchoolStat
                .sorted(Comparator.comparingInt(YearSchoolStat::getNumberOfSchools) // Sort by number of schools
                        .thenComparingInt(YearSchoolStat::getYearOfEntering)) // Then by year of entering
                .toList(); // Collect into a list
    }
}
