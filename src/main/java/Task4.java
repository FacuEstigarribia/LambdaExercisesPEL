
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Task 4.
A positive integer K and a sequence of non-empty strings stringList are given.
Strings of the sequence contain only numbers and capital letters of the Latin alphabet.
Get from stringList all strings of length K ending in a digit and sort them in ascending order.
For example:
input: number = 2, {“8DC3”, “4F”, “B”, “3S”, “S3”, “A1", “2A3G”, “1B”}
output: {“A1”, “S3"}

 */
public class Task4 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("8DC3", "4F", "B", "3S", "S3", "A1", "2A3G", "1B");
        int k = 2;
        List<String> result = manipulateList(stringList, k);
        for(String s : result){
            System.out.println(s);
        }
    }

    private static List<String> manipulateList(List<String> stringList, int n){
        return stringList.stream()
                .filter(s -> s.length() == n && Character.isDigit(s.charAt(s.length() - 1)))
                .sorted()
                .collect(Collectors.toList());
    }
}
