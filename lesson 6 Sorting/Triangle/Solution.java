// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if (N < 3)
            return 0;
        // using the built-in sort method because it can perform O(N*log(N))
        // time complexity at the worst case.The ordinary quick sort method can
        // not pass the performance test.
        Arrays.sort(A);
        for (int i = 0; i < N-2; i++) {
            // this algorithm can only test if there is a triangle, it can not
            // get the whole number of the triangles.
            if (A[i] > 0 && A[i] > A[i+2] - A[i+1])
                return 1;
        }
        return 0;
    }
}
