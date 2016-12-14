// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N, int M) {
        // write your code in Java SE 8
        // we know that the answer is finding a X that makes M * X = N * Y(Y is
        // an integer), so the question becomes calculate the LCM of N and M.
        int gcd = 0;
        int lcm = 0;
        int a = N;
        int b = M;
        // the recursive algorithm may be easy to understand, but it's not the
        // efficient way to get the gcd, so we use a loop to calculate it.
        // int gcd(int a, int b) {
        //     if (a % b == 0)
        //         return b;
        //     else
        //         return gcd(b, a % b);
        // }
        while (a % b != 0) {
            gcd = b;
            b = a % gcd;
            a = gcd;
        }
        gcd = b;
        // the product of N * M may exceed the max value of integer in java
        // lcm = N * M / gcd;
        // return lcm / M;
        return N / gcd;
    }
}
