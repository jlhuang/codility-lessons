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
        for (char ele : S.toCharArray()) {
            // push the left half in the stack, and because of the same length
            // of string s and stack array so there is no need to worry about if
            // the stack is full.
            if (ele == '(' || ele == '{' || ele == '[') {
                stack[num++] = ele;
            }
            // pop the left half out of the stack if the element can be matched
            // from the top of the stack
            else if (num != 0 &&
                    (ele == ')' && stack[num-1] == '(' ||
                     ele == '}' && stack[num-1] == '{' ||
                     ele == ']' && stack[num-1] == '['))
                num--;
            // if there is no match character we can sure that this is not a
            // properly nested string
            else
                return 0;
        }
        // if the stack is empty, then the string is properly nested.
        if (num == 0)
            return 1;
        else
            return 0;
    }
}
