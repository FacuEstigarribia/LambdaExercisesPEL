import java.util.*;
import java.util.stream.Collectors;

/*
Task 2.
A sequence of non-empty strings stringList is given.
Get a sequence of ascending sorted integer values equal to the lengths of the strings included in the stringList sequence.
For example:
input: {"Hello”, "world”, "!”, "Good”, "morning”, "!”}
output: {1, 1, 4, 5, 5, 7}

 */
public class Task2 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Hello","world", "!", "Good", "morning", "!");
        List<Integer> result = getAscendingSorted(stringList);
        showSorted(result);
    }

    private static List<Integer> getAscendingSorted(List<String> stringList){
        return stringList.stream()
                .map(String::length)
                .sorted()
                .collect(Collectors.toList());
    }
    public static void showSorted(List<Integer> integers){
        integers.stream().forEach(System.out::println);
    }
}

