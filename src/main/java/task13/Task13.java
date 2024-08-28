package task13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Task 13.
A sequence of data about applicants nameList of type Entrant and a sequence of integers yearList representing years are given.
Each element of the nameList sequence includes the fields <school_number> <year_of_entering> <last_name>.
Get data (a list of YearSchoolStat values) about the number of different schools that applicants graduated from, for each year from the yearList.
YearSchoolStat includes < year_of_entering> <number_of_schools> fields.
If in the given year of admission there are no applicants from the listed schools, indicate zero in the field < number_of_schools >.
The YearSchoolStat list must be sorted in ascending order by the number of schools, and for matching values, in ascending order by the year number. For example:
input: { 2001, 1999, 2000, 2002, 2003 }
{ (11, 2003, “Ivanov”), (11, 2001, “Petrov”), (11, 2001, “Pupkin”), (10, 1999, “Zobkin”), (10, 1999, “Zabkin”), (10, 1999, “Ivanov”), (10, 2000, “Petrov”), (14, 2001, “Pupkin”), (15, 2000, “Zobkin”), (10, 2000, “Ivanov”), (12, 2003, “Petrov”), (11, 2003, “Pupkin”), (10, 2003, “Zobkin”), }
output: { (2002, 0), (1999, 1), (2000, 2) (2001, 2) (2003, 3) }

 */
public class Task13 {
    public static void main(String[] args) {
        List<Integer> yearsList = Arrays.asList(2001, 1999, 2000, 2002, 2003);
        List<Entrant> nameList = Arrays.asList(
                new Entrant(11, 2003, "Ivanov"),
                new Entrant(11, 2001, "Petrov"),
                new Entrant(11, 2001, "Pupkin"),
                new Entrant(10, 1999, "Zobkin"),
                new Entrant(10, 1999, "Zabkin"),
                new Entrant(10, 1999, "Ivanov"),
                new Entrant(10, 2000, "Petrov"),
                new Entrant(14, 2001, "Pupkin"),
                new Entrant(15, 2000, "Zobkin"),
                new Entrant(10, 2000, "Ivanov"),
                new Entrant(12, 2003, "Petrov"),
                new Entrant(11, 2003, "Pupkin"),
                new Entrant(10, 2003, "Zobkin")
        );

        Map<Integer, Integer> yearSchoolCountMap = getMapYearSchoolCount(nameList);
        List<YearSchoolStat> result = solution(yearsList, yearSchoolCountMap);
        result.forEach(System.out::println);
    }

    public static Map<Integer, Integer> getMapYearSchoolCount(List<Entrant> nameList){
        return nameList.stream()
                .collect(Collectors.groupingBy(
                        Entrant::getYearOfEntering,
                        Collectors.mapping(Entrant::getSchoolNumber, Collectors.toSet())
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size()
                ));
    }

    public static List<YearSchoolStat> solution(List<Integer> yearsList, Map<Integer, Integer> yearSchoolCountMap){
        return yearsList.stream()
                .map(year -> new YearSchoolStat(year, yearSchoolCountMap.getOrDefault(year, 0)))
                .sorted(Comparator.comparingInt(YearSchoolStat::getSchoolsNumber)
                        .thenComparingInt(YearSchoolStat::getYearOfEntering))
                .toList();
    }
}
