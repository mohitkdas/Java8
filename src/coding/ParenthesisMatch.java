package coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisMatch {
    public static void main(String[] args) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        String s = "(){}()";
        Stack<Character> chr = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (chr.isEmpty()) {
                chr.push(s.charAt(i));
            } else {
                char c = chr.peek();
                if (s.charAt(i) == (map.get(c) == null ? ' ' : map.get(c))) {
                    chr.pop();
                } else {
                    chr.push(s.charAt(i));
                }
            }
        }

        System.out.println(chr.isEmpty());
    }
}
