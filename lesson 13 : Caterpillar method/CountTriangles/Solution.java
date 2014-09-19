// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // The time complexity of the above algorithm is O(n^2),
        // because for every i the values of j and k increase O(n) number of times.
        int N = A.length;
        if (N < 3)
            return 0;
        // use the built in sort algorithm which can perform worst case
        // O(N*log(N)) time complexity
        Arrays.sort(A);
        int result = 0;
        for (int i = 0; i < N; i++) {
            int k = i + 1;
            for (int j = i + 1; j < N; j++) {
                // for every i and j we figure out the maximal k that can be a
                // triangular, and when we increase j the former k would still
                // be a triangular because of the sorted array, so we just need
                // to count the number of triangular between j and k.
                while (k < N && A[i] + A[j] > A[k])
                    k++;
                result += k - j - 1;
            }
        }
        return result;
    }
}
