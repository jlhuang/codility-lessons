// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int Z = A.length;
        int count = 0;
        for (int i = 0; i < Z; i++) {
            int a = A[i];
            int b = B[i];
            // we know that if two numbers have the same prime divisors then
            // the gcd of both numbers and the result of each number divided by
            // gcd must have the same prime divisors too.
            int gcdOfBoth = gcd(a, b);
            int divisorOfA = a / gcdOfBoth;
            int gcdOfA = gcd(gcdOfBoth, divisorOfA);
            while (gcdOfA != 1) {
                divisorOfA /= gcdOfA;
                gcdOfA = gcd(gcdOfBoth, divisorOfA);
            }
            int divisorOfB = b / gcdOfBoth;
            int gcdOfB = gcd(gcdOfBoth, divisorOfB);
            while (gcdOfB != 1) {
                divisorOfB /= gcdOfB;
                gcdOfB = gcd(gcdOfBoth, divisorOfB);
            }
            if (divisorOfA == 1 && divisorOfB == 1)
                count++;
        }
        return count;
    }

    // calculate the greatest common divisor using non-recursively method
    public int gcd(int a, int b) {
        int temp;
        while (a % b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return b;
    }
}
