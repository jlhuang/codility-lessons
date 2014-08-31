// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        // count array of 1 2 3 ... X.
        boolean[] count = new boolean[X+1];
        int position = 0;
        for (int i = 0; i < N; i++) {
            // count the leaves from 1 to X.
            if (!count[A[i]]) {
                count[A[i]] = true;
                position++;
            }
            // if the leaves appear at every position from 1 to X, return the index.
            if (position == X)
                return i;
        }
        // can't jump to the other side of the river.
        return -1;
    }
}
