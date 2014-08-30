// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        boolean[] count = new boolean[N+1];
        for (int element : A)
            if (element > N)
                return 0;
            else
                count[element] = true;
        for (int i = 1; i <= N; i++) {
            if (!count[i])
                return 0;
        }
        return 1;
    }
}
