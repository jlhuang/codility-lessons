// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        // count array of 1 2 ... N
        boolean[] count = new boolean[N+1];
        for (int element : A)
            // if there is an element bigger than N, then it is not a permutation.
            if (element > N)
                return 0;
            else
                // assign true to the element of count array. 
                count[element] = true;
        for (int i = 1; i <= N; i++) {
            // if there is an element of the count array that is false, then it is not a permutation.
            if (!count[i])
                return 0;
        }
        return 1;
    }
}
