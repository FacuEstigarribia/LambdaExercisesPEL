package task9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Task 9.
A sequence of non-empty strings stringList is given, containing only uppercase letters of the Latin alphabet.
For all strings starting with the same letter,
determine their total length and obtain a sequence of strings of the form “S-C”,
where S is the total length of all strings from stringList that begin with the character C.
Order the resulting sequence in descending order of the numerical values of the sums,
and for equal values of the sums, in ascending order of the C character codes.
For example:
input: {“ABC”, “A”, “BCD”, “D”}
output: {“4-A”, “3-B”, “1-D”}

 */
public class Task9 {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("ABC", "A", "BCD", "D");

        List<String> result = solution(stringList);
        result.forEach(System.out::println);
    }

    public static List<String> solution(List<String> strList){

        return  strList.stream()
                .collect(Collectors.groupingBy(
                        s -> s.substring(0, 1), // Group by the starting character
                        Collectors.summingInt(String::length) // Compute total length of strings in each group
                ))
                .entrySet().stream()
                .map(entry -> String.format("%d-%s", entry.getValue(), entry.getKey())) // Format as "S-C"
                .sorted((a, b) -> {
                    // Compare based on total length in descending order and then by character in ascending order
                    int lengthCompare = Integer.compare(
                            Integer.parseInt(b.split("-")[0]), // Extract length from "S-C" format
                            Integer.parseInt(a.split("-")[0])
                    );
                    if (lengthCompare == 0) {
                        return a.compareTo(b); // Compare lexicographically if lengths are equal
                    }
                    return lengthCompare;
                })
                .toList();
    }
}
