// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8
        // we know that the result of a number modulo 2^P is the bit under P, so
        // if we first let the number modulo 2^Q(Q > P) and then modulo 2^P, the
        // result is the same.
        int L = A.length;
        int[] fib = new int[L+2];
        int[] result = new int[L];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i <= L; i++) {
            // make sure the fibonacci number will not exceed the max integer in java
            fib[i] = (fib[i-1] + fib[i-2]) % (1 << 30);
        }
        for (int i = 0; i < L; i++) {
            result[i] = fib[A[i]] % (1 << B[i]);
        }
        return result;
    }
}
