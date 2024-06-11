package coding;

import java.util.HashSet;
import java.util.Set;

public class InterviewPrograms {
    public static void main(String[] args) {
        InterviewPrograms ip = new InterviewPrograms();
        System.out.println(ip.isIsogram("mag"));
        System.out.println(ip.fibRecursion(10));
        System.out.println(ip.fibonacciDp(10));
        System.out.println(ip.fibonacci(10));
    }

    private int fibonacci(int n) {
        int num1 = 0, num2 = 1;
        for(int i = 0; i < n; i++) {
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
        return num1;

    }

    private int fibonacciDp(int N) {
        int[] fib = new int[N];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i < N; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[N-1];
    }

    private int fibRecursion(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibRecursion(n-1) + fibRecursion(n - 2);
        }
    }

    private boolean isIsogram(String s) {
        char[] c = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for(char ch : c) {
            if(!charSet.add(ch)) {
                return false;
            }
        }
        return true;
    }
}
