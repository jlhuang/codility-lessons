// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // the original version is at
        // http://stackoverflow.com/questions/4801242/algorithm-to-calculate-number-of-intersecting-discs
        int N = A.length;
        if (N < 2)
            return 0;
        // stores the number of discs which start at each point
        int[] discStart = new int[N];
        // stores the number of discs which end at each point
        int[] discEnd = new int[N];
        for (int i = 0; i < N; i++) {
            discStart[Math.max(0, i - A[i])]++;
            // the result of i + A[i] could be over the max integer in java and
            // it will become a negative integer.
            if (i + A[i] < 0)
                discEnd[N-1]++;
            else
                discEnd[Math.min(N - 1, i + A[i])]++;
        }
        // the number of discs which haven't been calculated at a very point
        int unCalcDiscNo = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (discStart[i] > 0) {
                // calculate the product of the number of discs that haven't
                // been calculated and the number of started discs at this point
                result += unCalcDiscNo * discStart[i];
                // calculate the number of intersections of the started discs at
                // this point, the algorithm is 1+2+...+N = N*(N-1)/2
                result += discStart[i] *(discStart[i] - 1) / 2;
                if (result > 10000000)
                    return -1;
                // add the number of start discs to unCalcDiscNo
                unCalcDiscNo += discStart[i];
            }
            if (discEnd[i] > 0)
                // subtract the calculated discs from unCalcDiscNo
                unCalcDiscNo -= discEnd[i];
        }
        return result;
    }
}
