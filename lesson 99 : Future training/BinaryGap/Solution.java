// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int positionOneLow = 30;
        int positionOneHigh = 30;
        int gap = 0;
        int position = 0;
        while (N != 0) {
            // using the & operator can also determine whether
            // N is an odd or even, but the result almost the same.
            // if ((N & 1) == 1)
            if (N % 2 == 1) {
                positionOneLow = positionOneHigh;
                positionOneHigh = position;
                gap = Math.max(gap, positionOneHigh - positionOneLow - 1);
            }
            N /= 2;
            position++;
        }
        return gap;
    }
}
