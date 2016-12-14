// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int M = A.length;
        int[] counters = new int[N];
        int maxValue= 0; // store the max value in the counters array
        int currMax = 0; // store the max value when there is a max counter
        for (int i = 0; i < M; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                // max counter
                if (counters[A[i]-1] < currMax)
                    counters[A[i]-1] = currMax;
            // increase (X)
                counters[A[i]-1]++;
                if (counters[A[i]-1] > maxValue)
                    maxValue = counters[A[i]-1];
            }
            // update current max value when there is a max counter
            if (A[i] == N + 1) {
                currMax = maxValue;
            }
        }
        for (int i = 0; i < N; i++) {
            // update the rest elements of counters which aren't assigned above.
            if (counters[i] < currMax)
                counters[i] = currMax;
        }
        return counters;
    }
}
