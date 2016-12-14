// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if (N < 2)
            return 0;
        // intervals stores the two elements : i - A[i] and i + A[i]
        long[][] intervals = new long[N][2];
        for (int i = 0; i < N; i++) {
            intervals[i][0] = (long)i - A[i];
            intervals[i][1] = (long)i + A[i];
        }
        // using the lambda expression to sort a two dimensional array by the
        // intervals left end in ascending order
        Arrays.sort(intervals, (long[] a, long[] b) -> Long.signum(a[0] - b[0]));
        int result = 0;
        for (int i = 0; i < N-1; i++) {
            // using the intervals' right end as the key value of binary search
            long rightEnd = intervals[i][1];
            int binarySearchLeft = i+1;
            int binarySearchRight = N-1;
            int resultIndex = i;
            // using the binary search to find the number of intersections
            while (binarySearchLeft <= binarySearchRight) {
                int binarySearchMid = (binarySearchLeft + binarySearchRight) / 2;
                if (intervals[binarySearchMid][0] <= rightEnd) {
                    resultIndex = binarySearchMid;
                    binarySearchLeft = binarySearchMid + 1;
                }
                else
                    binarySearchRight = binarySearchMid - 1;
            }
            // count the number of intersections
            result += (resultIndex - i);
            if (result > 10000000)
                return -1;
        }
        return result;
    }
}
