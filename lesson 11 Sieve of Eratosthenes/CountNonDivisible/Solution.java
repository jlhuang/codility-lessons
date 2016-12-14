// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        // stores the numbers of every element in A
        int[] counters = new int[2 * N + 1];
        // stores the numbers of divisors of A[i]
        int[] divisors = new int[2 * N + 1];
        // stores the numbers of non-divisors of A[i]
        int[] nonDivisors = new int[N];
        for (int ele : A)
            counters[ele]++;
        // using the algorithm of Sieve of Eratosthenes
        for (int i = 1; i <= 2 * N; i++) {
            // i is the element of A
            if (counters[i] > 0) {
                int k = i;
                while (k <= 2 * N) {
                    // k is also an element of A and the multiple of i
                    if (counters[k] > 0)
                        divisors[k] += counters[i];
                    k += i;
                }
            }
        }
        // the numbers of non-divisors and divisors is N
        for (int i = 0; i < N; i++) {
            nonDivisors[i] = N - divisors[A[i]];
        }
        return nonDivisors;
    }
}
