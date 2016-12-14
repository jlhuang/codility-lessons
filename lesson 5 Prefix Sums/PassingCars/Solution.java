// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        // store the times of zero's occurrences
        int zeroCount = 0;
        int result = 0;
        for (int element : A) {
            if (element == 0)
                zeroCount++;
            // add the count of zero to the result when the car is traveling west
            if (element == 1 && zeroCount != 0)
                result += zeroCount;
            // the number of passing cars exceeds 1,000,000,000
            if (result > 1000000000)
                return -1;
        }
        return result;
    }
}
