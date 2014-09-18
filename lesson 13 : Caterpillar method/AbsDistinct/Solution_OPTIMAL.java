// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // this algorithm also uses the caterpillar method but it is easier to
        // understand, and the time complexity is still O(N*log(N)).
        int N = A.length;
        int head = 0;
        int tail = N - 1;
        int result = 1;
        // the current maximal value
        int currMaxValue = Math.max(Math.abs(A[head]), Math.abs(A[tail]));
        // we should be careful of the minimal integer number in JAVA, because
        // the absolute value of it is still a negative number.
        if (A[head] == Integer.MIN_VALUE)
            currMaxValue = Math.abs(A[head]);
        while (head <= tail) {
            int currHead = Math.abs(A[head]);
            // the same value of the current maximal value should not be counted
            if (currHead == currMaxValue) {
                head++;
                continue;
            }
            int currTail = Math.abs(A[tail]);
            // the same value of the current maximal value should not be counted
            if (currTail == currMaxValue) {
                tail--;
                continue;
            }
            // get the new current maximal value
            if (currHead >= currTail) {
                currMaxValue = currHead;
                head++;
            } else {
                currMaxValue = currTail;
                tail--;
            }
            // meet a new distinct absolute value
            result++;
        }
        return result;
    }
}
