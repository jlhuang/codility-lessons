// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        Arrays.sort(A);
        // index is the index of the minimal absolute element of array A
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] >= 0) {
                index = i;
                break;
            }
            if (i == N - 1)
                index = i;
        }
        int head = index;
        int tail = index;
        int minAbsSum = Math.abs(A[tail] + A[head]);
        while (true) {
            // stores the current absolute sum of tail and head
            int currentAbsSum = Math.abs(A[tail] + A[head]);
            if (currentAbsSum < minAbsSum)
                minAbsSum = currentAbsSum;
            // for each head figure out the most left end that tail can be
            if (tail - 1 >= 0 && Math.abs(A[tail - 1] + A[head]) <= currentAbsSum) {
                tail--;
                // for each tail figure out the most right end that head can be
            } else if (head + 1 < N && Math.abs(A[tail] + A[head + 1]) <= currentAbsSum) {
                head++;
                // we can not move either tail or head, so we should move them both
            } else if (tail - 1 >= 0 && head + 1 < N) {
                tail--;
                head++;
                // head is at the right end
            } else if (tail - 1 >= 0) {
                tail--;
                // tail is at the left end
            } else if (head + 1 < N) {
                head++;
            } else
                // there is no more move for tail and head
                return minAbsSum;
        }
    }
}
