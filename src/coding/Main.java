package coding;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //find the duplicate elements in a given integers list using stream
        List<Integer> list = List.of(10, 28, 87, 10, 20, 76, 28, 80, 80, 80);

        Set<Integer> set = new HashSet<>();

        list.stream()
                .filter(x -> !set.add(x))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        //Multiply two numbers using Lambda Interface
        System.out.println("Multiply two numbers");
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x * y);
        biConsumer.accept(10, 20);

        Finterface total = (x, y) -> x * y;
        System.out.println(total.multiply(10, 30));

        //difference between limit and skip
        System.out.println("Limit");
        list.stream().limit(7).forEach(System.out::println);
        List<Integer> list1 = list.stream().limit(7).toList();
        System.out.println("Skip");
        list.stream().skip(7).forEach(System.out::println);

        //prime number in java 8;
        System.out.println("Prime Number");
        int number = 7;
        System.out.println(IntStream.range(2, number).noneMatch(n -> number%n == 0));

        //sqrt of first 10 prime numbers;
        System.out.println("Sqrt of first 10 prime numbers");
        List<Double> sqrtList = Stream.iterate(1, i -> i + 1)
                .filter(num -> IntStream.range(2, num).noneMatch(n -> num%2==0)).peek(System.out::println)
                .map(Math::sqrt)
                .limit(10)
                .toList();
        System.out.println(sqrtList);

        //usage of reduce;
        System.out.println("Usage of reduce");
        System.out.println(IntStream.range(1, 6).reduce(Integer::sum).getAsInt());
        String str = "Java is a programming language";
        String[] strArr = str.split(" ");
        System.out.println(Arrays.stream(strArr).reduce((a, b) -> a + "-" + b).get());

        List<Integer> integers = List.of(30, 35, 32, 28, 25);
        System.out.println(integers.stream().mapToInt(x -> x).summaryStatistics().getMin());
        System.out.println(integers.stream().mapToInt(x -> x).summaryStatistics().getAverage());

        //get second and the third highest element or slicing
        System.out.println(integers.stream().sorted(Comparator.reverseOrder()).skip(1).limit(2).toList());
        System.out.println(Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.joining(", ")));

    }
}

@FunctionalInterface
interface Finterface {
    int multiply(int x, int y);
}