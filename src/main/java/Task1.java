

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Task 1.
The character C and a sequence of non-empty strings stringList are given.
Get a new sequence of strings with more than one character from the stringList,
starting and ending with C. For example:
input: Symbol = ‘a’, {“Hello”, “qwerty”, “asda”, “asdfa”, “as”, “a”}
output: {“asda”, “asdfa”}
*/
public class Task1 {
    public static void main(String[] args) {
        char symbol = 'a';
        List<String> stringList = Arrays.asList("Hello", "qwerty", "asda", "asdfa", "as", "a");
        List<String> result = filterStrings(stringList, symbol);
        System.out.println(result);
    }
    private static List<String> filterStrings(List<String> listString, char c){
        return listString.stream()
                .filter(str -> str.length() > 1 && str.startsWith(String.valueOf(c)) && str.endsWith(String.valueOf(c)))
                .collect(Collectors.toList());
    }
}
