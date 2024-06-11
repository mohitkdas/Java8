import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(checkIsometric("foo", "bar"));

        String str = "Java is a programming language";
        String[] strArray = str.split("");

        //occurrence of a character
        Map<String, Long> map = Arrays.stream(strArray).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(map);

        //find duplicate elements
        List<String> list = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(list);

        //find unique elements
        Arrays.stream(strArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1).map(Map.Entry::getKey).forEach(System.out::print);
    }

    private static boolean checkIsometric(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else if (map.containsValue(t.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}