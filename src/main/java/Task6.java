
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Task 6.
A sequence of positive integers numbers and a sequence of strings stringList are given.
Get a new sequence of strings according to the following rule: for each value n from sequence numbers,
select a string from sequence stringList that starts with a digit and has length n.
If Look at the template on the end of the task before solving the problem.
there are several required strings in the stringList sequence, return the first; if there are none,
then return the string “Not found” For example:
input: {1, 3, 4}, {“1aa”, “aaa”, “1”, “a”}
output: {“1”, “1aa”, “Not Found”}

 */
public class Task6 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,3,4,5);
        List<String> stringList = Arrays.asList("1aa", "aaa", "1", "a", "aghd", "6jkl","8kj");

        getStringListFilter(integerList, stringList);

    }

    private static void getStringListFilter(List<Integer> integers, List<String> strings){
        integers.stream()
                .map(i -> strings.stream()
                        .filter(s -> s.length() == i && Character.isDigit(s.charAt(0)))
                        .findFirst()// Optional<String>
                        .orElse("Not Found")
                )
                .forEach(System.out::println);
    }
}
