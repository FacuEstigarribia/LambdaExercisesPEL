import java.util.*;
import java.util.stream.Collectors;
/*
Task 12.
A sequence of positive integers integerList1 and integerList2 are given.
All values in each sequence are different.
Get a set (list of NumberPair values) of all value pairs that satisfy the following conditions:
the first element of the pair belongs to the sequence integerList1,
the second belongs to integerList2, and both elements end with the same digit.
The NumberPair type includes <value_1> <value_2> fields.
The resulting NumberPair list must be sorted in ascending order by the first field,
and if they are equal, by the second. For example:
input: {1, 2, 33, 44}, {11, 22, 13}
output: {NumberPair(1, 11), NumberPair(2, 22), NumberPair(33, 13)}

 */

public class Task12 {

    public static void main(String[] args) {
        List<Integer> integerList1 = Arrays.asList(1, 2, 33, 44);
        List<Integer> integerList2 = Arrays.asList(11, 22, 13);

        List<NumberPair> result = integerList1.stream()
                .flatMap(num1 -> integerList2.stream()
                        .filter(num2 -> num1 % 10 == num2 % 10) // Filter pairs where last digits match
                        .map(num2 -> new NumberPair(num1, num2))) // Map to NumberPair
                .sorted(Comparator.comparingInt((NumberPair np) -> np.value1) // Sort by value1
                        .thenComparingInt(np -> np.value2)) // Then by value2 if value1 is the same
                .collect(Collectors.toList()); // Collect into a list

        // Print the result
        System.out.println(result);

    }

    static class NumberPair{
        int value1;
        int value2;

        NumberPair(int n1, int n2){
            this.value1 = n1;
            this.value2 = n2;
        }

        public int getValue1(){
            return value1;
        }

        public int getValue2(){
            return value2;
        }

        @Override
        public String toString(){
            return "Number Pair (" + value1 + " " + value2 + ")";
        }
    }
}
