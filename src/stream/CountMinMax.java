package stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class CountMinMax {
    public static void main(String[] args) {
        // count(), min() and max() methods

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(stream.count());

        Integer integer = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(" Min => " + integer);

        Integer max = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(" Max => " + max);
    }
}
