// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        // using the algorithm in the reading material
        int M = P.length;
        // if the number is prime, then the element of this array is 0,
        // otherwise the element of this array is the minimal prime factor of
        // the number.
        int[] minPrimeFactor = new int[N + 1];
        for (int i = 2; i * i <= N; i++) {
            if (minPrimeFactor[i] == 0) {
                int k = i * i;
                while (k <= N) {
                    if (minPrimeFactor[k] == 0)
                        minPrimeFactor[k] = i;
                    k += i;
                }
            }
        }
        // the prefix sum of the count of semiprime
        int[] semiprimeCount = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            // whether the number i is a semiprime or not
            if (minPrimeFactor[i] != 0 && minPrimeFactor[i / minPrimeFactor[i]] == 0)
                semiprimeCount[i] = semiprimeCount[i-1] + 1;
            else
                semiprimeCount[i] = semiprimeCount[i-1];
        }
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            result[i] = semiprimeCount[Q[i]] - semiprimeCount[P[i]-1];
        }
        return result;
    }
}
