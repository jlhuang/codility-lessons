// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // this is the key declaration.if you use int instead of long, you'll
        // not pass the performance test.
        long N = A.length + 1;
        // calculate the sum of 1 + 2 + ... + (N + 1)
        long result = (N * (N + 1)) / 2;
        // get the result by subtracting all the array element from 1 + 2 +
        // ... (N + 1)
        for (int element : A)
            result -= element;
        return (int)result;
    }
}
