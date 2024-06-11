import java.util.Comparator;
import java.util.List;

class AnyCharMatch {
    public static void main(String[] args) {
        //match the below string using lambda such that the count is 5
        List<String> list = List.of("ab", "bc", "cd", "de", "aa", "cb");
        String abc = "abc";
        System.out.println(abc.indexOf('d'));

        // count the number of elements that contain any of the characters in abc
        long count = list.stream().filter(s -> s.chars().anyMatch(c -> abc.indexOf(c) >= 0)).count();
        System.out.println(count);
    }
}
