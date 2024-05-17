package functional;

import java.util.function.BiPredicate;

public class BiPredicateDemo implements BiPredicate<String, String> {
    public static void main(String[] args) {
        BiPredicate<String, String> biPredicate = new BiPredicateDemo();
        System.out.println(biPredicate.test("mohit", "mohit"));
        System.out.println(biPredicate.test("java guides", "Java Guides"));

        BiPredicate<String, String> biPredicateLambda = (s1, s2) -> s1.equals(s2);
        System.out.println(biPredicateLambda.test("hello", "hello"));

        BiPredicate<Integer, Integer> biPredicate1 = (x, y) -> x > y;
        BiPredicate<Integer, Integer> biPredicate2 = (x, y) -> x == y;

        boolean result = biPredicate1.and(biPredicate2).test(20, 10);
        System.out.println(result);

        boolean result1 = biPredicate1.or(biPredicate2).test(20, 10);
        System.out.println(result1);

    }

    @Override
    public boolean test(String s, String s2) {
        return s.equals(s2);
    }
}
