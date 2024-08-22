import java.util.*;
import java.util.stream.Collectors;

/*
Task 7.
You are given a positive integer K and a sequence of integers integerList.
Calculate the symmetrical difference between two subsets of integer values:
the first subset is all even integerList values,
the second subset is the integerList values excluding the first K elements.
In the resulting difference, replace the order with the reversed.
//Example: Input 123456789, result 9,7,4,2 For example:
input: number = 5, {1, 2, 3, 4, 5, 6, 7, 8, 9}
output: {9, 7, 4, 2}

 */
public class Task7 {
    public static void main(String[] args) {
        int K = 5;
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
    }
    private static List<Integer> calculateSymmetricalDifference(int k, List<Integer> integerList){
        Set<Integer> evenSet = integerList.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toSet());

        Set<Integer> excludedSet = integerList.stream()
                .skip(k)
                .collect(Collectors.toSet());
        return evenSet.stream().collect(Collectors.toList());

    }
}
