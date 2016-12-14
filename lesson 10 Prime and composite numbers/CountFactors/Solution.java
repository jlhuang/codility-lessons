// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        // the algorithm is all right but it can not pass the performance
        // test, the score is 92%.If we use the same algorithm in Python or
        // other scripting languages, we can pass the performance test.
        int result = 0;
        int factor = 1;
        while (factor * factor < N) {
            if (N % factor == 0)
                // the factors of N will be symmetrical when the second power of
                // factors less than N
                result += 2;
            factor++;
        }
        // if N is like K^2 then the number of factors should add 1
        if (factor * factor == N)
            result++;
        return result;
    }
}
