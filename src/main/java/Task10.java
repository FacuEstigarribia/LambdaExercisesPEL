import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Task 10.
A sequence of non-empty strings of Latin alphabet characters stringList is given.
Select the last character from each string, converting it to uppercase.
Return sorted sequence of characters in descending order by initial string length.
For example:
input: {“asnsbiu”, “asdsad”, “asnsb”, “asdf”, “asdfb”, “as”, “a”, “aop”}
output: {‘U’, ‘D’, ‘B’, ‘B’, ‘F’, ‘P’, ‘S’, ‘A’}

 */
public class Task10 {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("asnsbiu", "asdsad", "asnsb","asdf", "asdfb", "as", "a", "aop");
        List<Character> result = solution(input);
        result.forEach(System.out::println);
    }

    public static List<Character> solution(List<String> stringList){
        return stringList.stream()
                .map(s -> new Pair(s.length(), Character.toUpperCase(s.charAt(s.length() - 1))))
                .sorted(Comparator.comparingInt((Pair p) -> -p.lenght)
                        .thenComparing(p -> p.lastChar))
                .map(p -> p.lastChar)
                .collect(Collectors.toList());
    }

    public static class Pair{
        final int lenght;
        final char lastChar;

        Pair(int lenght, char lastChar){
            this.lenght = lenght;
            this.lastChar = lastChar;
        }
    }
}
