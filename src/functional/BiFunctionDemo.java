package functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BiFunctionDemo implements BiFunction<Integer, Integer, Integer> {
    @Override
    public Integer apply(Integer t, Integer u) {
        return (t + u);
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction =  new BiFunctionDemo();
        System.out.println(biFunction.apply(20, 30));
        System.out.println(biFunction.apply(100, 200));

        BiFunction<Integer, Integer, Integer> biFunctionLambda = (t, u) -> (t + u);
        System.out.println(biFunctionLambda.apply(20, 40));

        Function<Integer, Integer> function = num -> num * num;

        Integer integer = biFunctionLambda.andThen(function).apply(10, 20);
        System.out.println(integer);
    }
}
