// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if (N == 0)
            return 0;
        // the built-in sorting function performs O(n*log(n)) time complexity
        // even in the worst case
        Arrays.sort(A);
        int num = 1;
        int preDist = A[0];
        for (int i = 1; i < N; i++) {
            // add 1 to the number when there is a bigger element.
            if (A[i] != preDist) {
                preDist = A[i];
                num++;
            }
        }
        return num;
    }
}
