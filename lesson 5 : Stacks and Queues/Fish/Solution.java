// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int N = A.length;
        // the stack of alive fish flowing downstream
        int[] downstreamStack = new int[N];
        int num = 0;
        // store the number of alive fish flowing upstream
        int aliveUpstreamNum = 0;
        for (int i = 0; i < N; i++) {
            // current fish is flowing upstream and there isn't fish flowing
            // downstream before
            if (B[i] == 0 && num == 0)
                aliveUpstreamNum++;
            else if (B[i] == 0 && num != 0) {
                // current fish flowing upstream eats the fish flowing
                // downstream before
                while (num != 0 && A[i] > downstreamStack[num-1])
                    num--;
                // all the fish flowing downstream is eaten by the current fish
                // flowing upstream
                if (num == 0)
                    aliveUpstreamNum++;
            } else {
                // there is a fish flowing downstream and push it into the stack
                downstreamStack[num++] = A[i];
            }
        }
        // the alive fish is consist of the fish flowing upstream and the fish
        // flowing downstream
        return aliveUpstreamNum + num;
    }
}
