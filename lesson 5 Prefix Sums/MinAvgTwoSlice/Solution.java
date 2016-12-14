// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

// this solution is based on the fact that there must be minimal average slice
// of length 2 or 3 in all the minimal average slices.
// we can use the slice of length 4 and 5 to prove it.
// if there is a slice of length 4 is the minimal average slice, then
// (a1+a2+a3+a4)/4 <= (a1+a2)/2 -> a3+a4 <= a1+a2
// (a1+a2+a3+a4)/4 <= (a3+a4)/2 -> a1+a2 <= a3+a4
// so a1+a2 = a3+a4 -> (a1+a2+a3+a4)/4 = (a1+a2)/2
// if there is a slice of length 5 is the minimal average slice, then
// we can use the same method to prove it.
// it's easy to conclude that (a1+a2+a3+a4+a5)/5 = (a1+a2)/2 = (a3+a4+a5)/3.
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int[] sum = new int[N+1];
        // calculate the prefix sum of array A
        for (int i = 0; i < N; i++)
            sum[i+1] = sum[i] + A[i];
        int minTwoSum = 20000;
        int minTwoStartIndex = 0;
        // calculate the minimal average slice of length 2
        for (int i = 0; i < N-1; i++) {
            // the average is not been used because the division of integer in
            // Java will cut the decimal part and it will make the comparison
            // inaccurately.
            int twoSum = (sum[i+2] - sum[i]);
            if (twoSum < minTwoSum) {
                minTwoSum = twoSum;
                minTwoStartIndex = i;
            }
        }
        int minThreeSum = 30000;
        int minThreeStartIndex = 0;
        // calculate the minimal average slice of length 3
        for (int i = 0; i < N-2; i++) {
            int threeSum = (sum[i+3] - sum[i]);
            if (threeSum < minThreeSum) {
                minThreeSum = threeSum;
                minThreeStartIndex = i;
            }
        }
        // return the minimal result from slice of length 2 or 3
        if (minTwoSum * 3 <= minThreeSum * 2)
            return minTwoStartIndex;
        else
            return minThreeStartIndex;
    }
}
