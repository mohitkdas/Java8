package streaminterviewQA;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestNumber {
    public static void main(String[] args) {
        // 4. Java program to find second-highest number from a given array.
        int[] numbers = {5, 9, 11, 2, 8, 21, 1};

        /*
          sort in reverse order
          skip the first element
          after skipping find the first element
         */
        Integer secHighest = Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();

        System.out.println(secHighest);

        Integer secLowest = Arrays.stream(numbers).boxed()
                .sorted()
                .skip(1)
                .findFirst().get();
        System.out.println(secLowest);
    }
}
