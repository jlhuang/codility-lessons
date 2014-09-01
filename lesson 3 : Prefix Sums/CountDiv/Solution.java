// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        // be careful with the situation that A is divisible by K
        int lower = A % K == 0 ? A / K -1 : A / K;
        int upper = B / K;
        return upper - lower;
    }
}
