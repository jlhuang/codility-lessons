// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // this algorithm performance O(N*log(N)) time complexity based on the
        // codility.com, but in fact because of using the caterpillar method it should
        // has the O(N) time complexity.any way, it doesn't need extra space.
        int N = A.length;
        int start = 0;
        int end = N - 1;
        int count = 0;
        while (start <= end) {
            int leftPivot = A[start];
            // if the element of array equals A[start], do not count
            while (start <= end && A[start] == leftPivot)
                start++;
            // count the element of A[start]
            count++;
            if (leftPivot == Integer.MIN_VALUE)
                continue;
            int rightPivot = -1;
            // count the number of element right end that bigger than A[start]
            while (start <= end && Math.abs(A[end]) > Math.abs(leftPivot)) {
                if (Math.abs(A[end]) != rightPivot) {
                    count++;
                    rightPivot = Math.abs(A[end]);
                }
                // if the element of array equals A[end], do not count
                end--;
            }
            // if the element of array equals A[start], do not count
            while (start <= end && Math.abs(A[end]) == Math.abs(leftPivot))
                end--;
        }
        return count;
    }
}

