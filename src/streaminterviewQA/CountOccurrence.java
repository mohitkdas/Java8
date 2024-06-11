package streaminterviewQA;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrence {
    public static void main(String[] args) {
        // 1. Java program to count the occurrence of each character in a string
        String str = "Java is a programming language";
        String[] strArray = str.split("");
        System.out.println(Arrays.toString(strArray));

        // print each item and occurrence
        Map<String, List<String>> collect = Arrays.stream(strArray).
                collect(Collectors.groupingBy(s -> s));
        System.out.println(collect);

        // print each item and count
        Map<String, Long> map = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        // without stream
        Map<String, Integer> map2 = new HashMap<>();
        System.out.println("Without Stream: ");
        for (String s: strArray) {
            if (map2.containsKey(s)) {
                map2.put(s, map2.get(s)+1);
            } else {
                map2.put(s, 1);
            }
        }
        System.out.println(map2);

        String[] str2 = {"java", "java", "is", "a", "programming", "language"};

        Map<String, Long> map3 = Arrays.stream(str2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map3);

        Set<String> set = new HashSet<>();
        Set<String> duplicate = Arrays.stream(str2).filter(x -> !set.add(x)).collect(Collectors.toSet());

        List<String> frequency = Arrays.stream(str2).filter(x -> Collections.frequency(Arrays.asList(str2), x) == 1).collect(Collectors.toList());

        List<String> list =  Arrays.stream(str2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(list);

        System.out.println(set);
        System.out.println(duplicate);
        System.out.println(frequency);
    }
}
