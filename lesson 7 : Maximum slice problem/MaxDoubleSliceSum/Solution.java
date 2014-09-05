// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // the answer of the example (3,4,5) is 0 is very important,it means
        // both minimal values of A[X+1] + A[X+2] + ... + A[Y-1] and A[Y+1] +
        // A[Y+2] + ... + A[Z-1] is 0.
        int N = A.length;
        if (N == 3)
            return 0;
        int maxEnding = 0;
        int maxSlice = 0;
        // stores the sum value of max slice of A[1] A[2] ... A[i] in maxSliceLeft[i]
        int[] maxSliceLeft = new int[N];
        for (int i = 1; i < N-1; i++) {
            // maxEnding = Math.max(A[i], maxEnding + A[i]);
            maxEnding = Math.max(0, maxEnding + A[i]);
            // maxSlice = Math.max(maxSlice, maxEnding);
            // maxSliceLeft[i] = maxSlice;
            maxSliceLeft[i] = maxEnding;
        }
        // stores the sum value of max slice of A[N-2] A[N-1] ... A[i] in maxSliceRight[i]
        int[] maxSliceRight = new int[N];
        maxEnding = 0;
        maxSlice = 0;
        for (int i = N-2; i >= 1; i--) {
            // maxEnding = Math.max(A[i], maxEnding + A[i]);
            maxEnding = Math.max(0, maxEnding + A[i]);
            // maxSlice = Math.max(maxSlice, maxEnding);
            // maxSliceRight[i] = maxSlice;
            maxSliceRight[i] = maxEnding;
        }
        int maxDoubleSlice = 0;
        // calculate the max double slice from Y == 1 to Y == N-2
        for (int i = 1; i < N-1; i++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxSliceLeft[i-1] + maxSliceRight[i+1]);
        }
        return maxDoubleSlice;
    }
}
