// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // this solution is based on the algorithm of the official solution
        int N = A.length;
        boolean[] peak = new boolean[N];
        for (int i = 1; i < N-1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1])
                peak[i] = true;
        }
        int[] next = new int[N];
        next[N-1] = -1;
        for (int i = N-2; i >= 0; i--) {
            if (peak[i])
                next[i] = i;
            else
                next[i] = next[i+1];
        }
        int flags = 1;
        int result = 0;
        while (flags * flags <= 2 * N) {
            int pos = 0;
            int count = 0;
            while (pos < N && count < flags) {
                pos = next[pos];
                if (pos == -1)
                    break;
                count++;
                pos += flags;
            }
            result = Math.max(result, count);
            flags++;
        }
        return result;
    }
}
