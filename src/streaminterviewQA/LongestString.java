package streaminterviewQA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestString {
    public static void main(String[] args) {
        // 5. Java program to find longest string in an array
        String[] arr = {"Java", "is", "a", "programming", "language"};
        String longest = Arrays.stream(arr).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2 ).get();
        System.out.println(longest);

        // 6. Java program to find all elements from array that start with 1
        int[] numbers = {2, 5, 11, 21, 1, 31, 23};
        List<String> collect = Arrays.stream(numbers).boxed()
                .map(String::valueOf)
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(collect);

        // 8. String.join example
        List<String> nos = Arrays.asList("1", "2", "3", "4");
        String results = String.join("-", nos);
        System.out.println(results);

        // 9. Skip and limit method use case example
        IntStream.rangeClosed(1, 10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);
    }
}
