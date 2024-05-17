package functional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

class SupplierImpl implements Supplier<LocalDateTime> {

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
}

public class SupplierDemo {
    public static void main(String[] args) {
//        Supplier<LocalDateTime> supplier = new SupplierImpl();
//        System.out.println(supplier.get());

        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());

        Supplier<String> hello = () -> "Hello Mohit";

        List<String> list = Arrays.asList();
        System.out.println(list.stream().findAny().orElseGet(() -> "Hello World!"));
        System.out.println(list.stream().findAny().orElseGet(hello));
    }
}
