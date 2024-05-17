package methodref;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Printable {
    void print(String msg);
}

public class MethodReferenceDemo {

    public void display(String msg) {
        msg = msg.toUpperCase();
        System.out.println(msg);
    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 1. Method reference to a static method
        // using lambda expression
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));

        // using method reference
        Function<Integer, Double> functionMethodRef = Math::sqrt;
        System.out.println(functionMethodRef.apply(4));

        // lambda expression
        BiFunction<Integer, Integer, Integer> biFunctionLambda = (a,b) -> MethodReferenceDemo.addition(a, b);
        System.out.println(biFunctionLambda.apply(10, 20));

        // method reference
        BiFunction<Integer, Integer, Integer> biFunction= MethodReferenceDemo::addition;
        System.out.println(biFunction.apply(10, 40));

        // 2. Method Reference to an instance method of an object
        MethodReferenceDemo demo = new MethodReferenceDemo();

        // lambda expression
        Printable printable = msg -> demo.display(msg);
        printable.print("Hello World!");

        // method reference
        Printable print = demo::display;
        print.print("Hello World! in method ref ...");

        // 3. Reference to the instance method of an arbitrary object
        // Sometimes, we call a method of argument in the lambda expression.
        // In that case, we can use a method reference to call an instance
        // method of an arbitrary object of a specific type.

        // lambda expression
        Function<String, String> stringFunction = (String input) -> input.toLowerCase();
        System.out.println(stringFunction.apply("Java Guide"));

        // method reference
        Function<String, String> stringFunctionMethodRef = String::toLowerCase;
        System.out.println(stringFunctionMethodRef.apply("Java Guide in method ref ..."));

        String[] strArray = { "A", "E", "I", "O", "U", "a", "e", "i", "o", "u" };
        for (String s : strArray) {
            System.out.print(s);
        }

        // using lambda
        Arrays.sort(strArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println();
        for (String s : strArray) {
            System.out.print(s);
        }

        // using method reference
        Arrays.sort(strArray, String::compareToIgnoreCase);
        System.out.println();
        for (String s : strArray) {
            System.out.print(s);
        }
        System.out.println();

        // 4. reference to a constructor
        List<String> fruits = new ArrayList<>();
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("mango");
        fruits.add("watermelon");

        // using lambda
        Function<List<String>, Set<String>> setFunction = fruitsList -> new HashSet<>(fruitsList);
        System.out.println(setFunction.apply(fruits));

        // method reference
        Function<List<String>, Set<String>> setMethodRef = HashSet::new;
        System.out.println(setMethodRef.apply(fruits));
    }
}
