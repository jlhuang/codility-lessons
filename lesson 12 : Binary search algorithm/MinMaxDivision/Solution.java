// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int K, int M, int[] A) {
        // write your code in Java SE 8
        // using the binary search algorithm to solve this problem
        long N = (long)A.length;
        // assume the max of the large sum is N * M
        long max = N * M;
        // assume the min of the large sum is 0
        long min = 0;
        long result = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            int count = 0;
            long sum = 0;
            for (long ele : A) {
                sum += ele;
                // there is an element which is larger than the large sum, so it
                // is not a valid trial
                if (ele > mid) {
                    count = K + 1;
                    break;
                }
                if (sum > mid) {
                    count++;
                    sum = ele;
                }
            }
            // we know that the last piece of the divide has not been counted
            count++;
            if (count <= K) {
                max = mid - 1;
                result = mid;
            } else {
                min = mid + 1;
            }
        }
        return (int)result;
    }
}
