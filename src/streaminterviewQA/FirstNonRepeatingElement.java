package streaminterviewQA;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        // 3. Java program to find first non-repeating element from a given string
        String str = "Java is a programming language";

        String key = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println(key);

       // first repeating character
        String repeat = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .findFirst().get().getKey();
        System.out.println(repeat);

    }
}
