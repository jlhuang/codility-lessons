// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        // we know that the minimal perimeter of a rectangle is when the length and
        // width are very close.
        int length = 0;
        int width = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                length = i;
                width = N / i;
            }
        }
        return 2 * (length + width);
    }
}
