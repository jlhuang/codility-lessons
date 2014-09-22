// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int K, int[] A) {
        // write your code in Java SE 8
        // use the greedy algorithm to solve this problem
        // because we can only tie the adjacent ropes, so for each rope we can
        // count the length of the consecutive ropes and figure out if there is
        // a tied rope that the length is greater than or equal to K.
        int N = A.length;
        int result = 0;
        int length = 0;
        for (int rope : A) {
            length += rope;
            if (length >= K) {
                result++;
                length = 0;
            }
        }
        return result;
    }
}
