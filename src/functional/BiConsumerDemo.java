package functional;

import java.util.function.BiConsumer;

public class BiConsumerDemo implements BiConsumer<Integer, Integer> {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> biConsumer = new BiConsumerDemo();
        biConsumer.accept(10, 20);

        BiConsumer<Integer, Integer> biConsumerLambda = (a, b) -> System.out.println(a + b);
        biConsumerLambda.accept(10, 30);
    }

    @Override
    public void accept(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
