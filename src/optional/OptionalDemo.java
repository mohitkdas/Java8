package optional;

import java.util.Optional;
import java.util.function.Predicate;

public class OptionalDemo {
    public static void main(String[] args) {
//        String email = "ramesh@ramesh.com";
        String email = null;

        //of, empty, ofNullable

        // create empty optional
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        // throws NullPointerException if object is null
//        Optional<String> emailOptional = Optional.of(email);
//        System.out.println(emailOptional);

        // gives empty if object is null
        Optional<String> stringOptional = Optional.ofNullable(email);
//        System.out.println(stringOptional.get());

//        if(stringOptional.isPresent()) {
//            System.out.println(stringOptional.get());
//        } else {
//            System.out.println("no value present");
//        }

        String defaultOptional = stringOptional.orElse("default@default.com");
        System.out.println(defaultOptional);

        String defaultOptional2 = stringOptional.orElseGet(() -> "default@default.com");
        System.out.println(defaultOptional2);

//        String optionalObject = stringOptional.orElseThrow(() -> new IllegalArgumentException("Email does not exist"));
//        System.out.println(optionalObject);

        // ifPresent

        Optional<String> gender = Optional.of("MALE");

        gender.ifPresent((s) -> System.out.println("Value is present"));
        emptyOptional.ifPresent((s) -> System.out.println("no value present"));

        String result = " abc ";
        if(result != null && result.contains("abc"))
            System.out.println(result);

        Optional<String> optionalS = Optional.of(result);
        optionalS.filter(res -> res.contains("abc"))
                .map(String::trim)
                .ifPresent(res -> System.out.println(res));
    }
}
