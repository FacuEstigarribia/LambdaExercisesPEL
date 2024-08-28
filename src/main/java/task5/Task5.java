package task5;

import java.util.*;
import java.util.stream.Collectors;

/*
Task 5.
A sequence of positive integer values integerList is given.
Get sequence of string representations of only odd integerList values and sort in ascending order.
For example:
input: {1, 2, 3, 4, 5, 6}
output: {“1”, “3", “5”}
At the MIDDLE level, you need to solve the following five tasks:

 */
public class Task5 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strOddNumbers =  getOddNumbers(integerList);
        strOddNumbers.forEach(System.out::println);
    }

    private static List<String> getOddNumbers(List<Integer> integers){
        return integers.stream()
                .filter(n -> n % 2 != 0)
                .sorted()
                .map(i -> i.toString())
                .collect(Collectors.toList());

    }
}
