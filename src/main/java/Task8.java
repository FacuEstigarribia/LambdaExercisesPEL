import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Task 8.
You are given a positive integer K and integer D and a sequence of integers integerList.
Compute a union of two subsets of integers:
the first subset is all values of integerList greater than D,
the second subset is an integer list of values starting with an element with ordinal number K inclusive
(the numbering of elements in the integer list starting from 0).
Sort the resulting sequence in descending order. For example:
input: D = 3, K = 4, integerList{-10, 3, -3, 4, 55, 6}
output: {55, 6, 4}

 */
public class Task8 {
    public static void main(String[] args) {
        // Example input
        int D = 3;
        int K = 4;
        List<Integer> integerList = Arrays.asList(-10, 3, -3, 4, 55, 6);

        // Compute the union of the two subsets and sort in descending order
        List<Integer> result = integerList.stream()
                .filter(n -> n > D)
                .collect(Collectors.toList()); // Collect as a list

        // Adding second subset: elements starting from index K
        result.addAll(
                integerList.stream()
                        .skip(K) // Second subset: elements from index K
                        .toList()
        );

        // Remove duplicates and sort in descending order
        List<Integer> finalResult = result.stream()
                .distinct() // Remove duplicates if any
                .sorted((a, b) -> b - a) // Sort in descending order
                .toList();

        // Print the result
        finalResult.forEach(System.out::println);
    }
}
