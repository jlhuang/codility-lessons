// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        int N = S.length();
        // if the length of string s is odd, then it can't be nested.
        if (N % 2 == 1)
            return 0;
        char[] stack = new char[N];
        int num = 0;
        for (int i = 0; i < N; i++) {
            // push the '(' into the stack
            if (S.charAt(i) == '(')
                stack[num++] = S.charAt(i);
            // if the stack is not empty, pop the top element out.
            else if (num != 0)
                num--;
            // other situation means it's not a nested string
            else
                return 0;
        }
        if (num == 0)
            return 1;
        else
            return 0;
    }
}
