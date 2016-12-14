// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int M, int[] A) {
        // write your code in Java SE 8
        // the algorithm is that for each tail the head points at the most right
        // place where there is no same element between tail and head.we know
        // that the worst case is that all the elements of the array are the
        // same, and at this circumstance the time complexity is O(2*N).
        int N = A.length;
        // the counter array for every element in the array A
        int[] counters = new int[M+1];
        int head = 0;
        int tail = 0;
        int result = 0;
        while (tail < N) {
            // find the most right end of the array for each tail
            while (head < N && counters[A[head]] != 2) {
                counters[A[head]]++;
                if (counters[A[head]] == 2)
                    break;
                head++;
            }
            result += head - tail;
            if (result > 1000000000)
                return 1000000000;
            // set the counter of the element before tail to be 0
            counters[A[tail]] = 0;
            tail++;
        }
        return result;
    }
}
