package functional;

import java.util.List;
import java.util.function.Function;

class FunctionImpl implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}

public class FunctionDemo {
    public static void main(String[] args) {
//        Function<String, Integer> function = new FunctionImpl();
//        System.out.println(function.apply("String"));

        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("Mohit"));

        List<String> s = List.of("2");
        s.stream().map(r -> r + "hello").forEach(System.out::println);
    }
}
