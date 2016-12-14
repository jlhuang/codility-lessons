// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // using the Kadane's algorithm will make the task very simple
        int N = A.length;
        int maxEnding = 0;
        int maxSlice = -1000000;
        for (int ele : A) {
            maxEnding = Math.max(ele, maxEnding + ele);
            maxSlice = Math.max(maxSlice, maxEnding);
        }
        return maxSlice;
    }
}
