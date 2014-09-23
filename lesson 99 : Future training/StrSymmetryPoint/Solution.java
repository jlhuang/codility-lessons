// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        int length = S.length();
        if (length == 0)
            return -1;
        int tail = 0;
        int head = length - 1;
        int result = 0;
        while (tail < head) {
            // symmetry character exists
            if (S.charAt(tail) == S.charAt(head)) {
                tail++;
                head--;
            // symmetry character not exists
            } else
                return -1;
        }
        // find the index
        if (tail == head)
            return tail;
        // can not find the index
        else
            return -1;
    }
}
