package streaminterviewQA;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElement {
    public static void main(String[] args) {
        // 2. Find all duplicate elements in a given string
        String str = "Java is a programming language";
        List<String> duplicate = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey).toList();
        System.out.println(duplicate);

        // Find all unique elements in a given string
        List<String> unique = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey).toList();
        System.out.println(unique);
    }
}
