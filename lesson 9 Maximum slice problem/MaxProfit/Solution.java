// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if (N < 2)
            return 0;
        // stores the A[i] - A[i-1] in the A[i], then calculate A[Q] - A[P]
        // means the sum of A[P+1] + A[P+2] ... + A[Q], so we can use the
        // algorithm of maximum slice problem.
        for (int i = N - 1; i > 0; i--) {
            A[i] = A[i] - A[i - 1];
        }
        A[0] = 0;
        int maxEnding = 0;
        int maxSlice = 0;
        for (int ele : A) {
            // the maximum slice is not quite right when the first element is
            // negative, but the result is OK.
            maxEnding = Math.max(0, maxEnding + ele);
            maxSlice = Math.max(maxSlice, maxEnding);
        }
        return maxSlice;
    }
}
