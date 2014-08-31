// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        boolean[] count = new boolean[X+1];
        int position = 0;
        for (int i = 0; i < N; i++) {
            if (!count[A[i]]) {
                count[A[i]] = true;
                position++;
            }
            if (position == X)
                return i;
        }
        return -1;
    }
}
