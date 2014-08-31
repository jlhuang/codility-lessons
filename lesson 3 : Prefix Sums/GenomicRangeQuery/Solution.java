// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int N = S.length();
        int M = P.length;
        int[] result = new int[M];
        // store the position of A in the String S
        int[] posOfA = new int[N+1];
        int[] posOfC = new int[N+1];
        int[] posOfG = new int[N+1];
        int[] posOfT = new int[N+1];
        for (int i = 0; i < N; i++) {
            // when A appears, assign 1 to the value of posOfA with the same index.
            if (S.charAt(i) == 'A')
                posOfA[i+1] = 1;
            if (S.charAt(i) == 'C')
                posOfC[i+1] = 1;
            if (S.charAt(i) == 'G')
                posOfG[i+1] = 1;
            if (S.charAt(i) == 'T')
                posOfT[i+1] = 1;
        }
        for (int i = 1; i <= N; i++) {
            // prefix sum of the array
            posOfA[i] += posOfA[i-1];
            posOfC[i] += posOfC[i-1];
            posOfG[i] += posOfG[i-1];
            posOfT[i] += posOfT[i-1];
        }
        for (int i = 0; i < M; i++) {
            // calculate the sum between P[i] and Q[i] in O(1) time complexity
            // if the value is not zero, then A has appeared in the slice.
            if ((posOfA[Q[i]+1] - posOfA[P[i]]) != 0)
                result[i] = 1;
            else if ((posOfC[Q[i]+1] - posOfC[P[i]]) != 0)
                result[i] = 2;
            else if ((posOfG[Q[i]+1] - posOfG[P[i]]) != 0)
                result[i] = 3;
            else if ((posOfT[Q[i]+1] - posOfT[P[i]]) != 0)
                result[i] = 4;
        }
        return result;
    }
}
