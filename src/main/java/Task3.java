import java.util.*;
import java.util.stream.Collectors;

/*
Task 3.
A sequence of non-empty strings stringList is given. Get a new sequence of strings,
where each string consists of the first and last characters of the corresponding string in the stringList sequence.
For example:
input: {“asd”, “a”, “basdw”}
output: {“ad”, “aa”, “bw”}
 */
public class Task3 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("asfd", "a", "basdw");
        firstAndLastCharacterString(stringList);
    }
    public static void firstAndLastCharacterString(List<String> strList) {

        strList.stream()
                .map(s -> s.length() == 1 ? s + s : "" + s.charAt(0) + s.charAt(s.length() - 1))
                .forEach(System.out::println);

    }
}