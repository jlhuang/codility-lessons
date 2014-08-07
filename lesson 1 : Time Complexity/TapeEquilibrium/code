// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
            // write your code in Java SE 8
        int len = A.length;
        int[] sum = new int[len];
        sum[0] = A[0];
        for (int i = 1; i < len; i++) {
                    sum[i] = sum[i-1] + A[i];
        }
        int min = Math.abs(sum[len-1] -2*sum[0]);
        for (int i = 2; i < len; i++) {
            int temp = Math.abs(sum[len-1] -2*sum[i-1]);
            if (temp < min)
                min = temp;
        }
        return min;
    }
}