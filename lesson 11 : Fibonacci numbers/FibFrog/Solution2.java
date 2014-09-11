// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // use the depth first search algorithm.it can pass the correctness test
        // but can't pass the performance test.the final score is 83%.we know
        // that using the depth first search algorithm needs to get all the ways
        // to the other side of the river and pick the minimal number of jumps
        // from them.so the time complexity may be very large but the algorithm
        // is all right.
        int N = A.length;
        int[] fib = new int[N + 4];
        boolean[] visit = new boolean[N];
        int[] moves = new int[N];
        fib[0] = 0;
        fib[1] = 1;
        int m = 1;
        do {
            m++;
            fib[m] = fib[m-1] + fib[m-2];
        } while (fib[m] <= N + 1);
        ArrayList<Status> statusStack = new ArrayList<Status>();
        statusStack.add(new Status(-1, 0));
        int top = 1;
        int minMoves = N + 1;
        boolean reachable = false;
        while (top != 0) {
            Status currStatus = statusStack.get(top-1);
            int currPosition = currStatus.position;
            int currMoves = currStatus.moves;
            boolean success = false;
            for (int i = m-1; i > 0; i--) {
                // pick the minimal jump
                if (currPosition + fib[i] == N && currMoves + 1 <= minMoves) {
                    minMoves = currMoves + 1;
                    reachable = true;
                }
                else if (currPosition + fib[i] < N &&
                         A[currPosition + fib[i]] == 1 &&
                         (visit[currPosition + fib[i]] == false ||
                          // may be there are different way to jump to a
                          // position and we should get the minimal moves
                          currMoves + 1 < moves[currPosition + fib[i]])) {
                    statusStack.add(top, new Status(currPosition + fib[i], currMoves + 1));
                    success = true;
                    top++;
                    visit[currPosition + fib[i]] = true;
                    moves[currPosition + fib[i]] = currMoves + 1;
                    break;
                }
            }
            if (success == false)
                top--;
        }
        if (reachable == false)
            return -1;
        return minMoves;
    }
}

class Status {
    public int position;
    public int moves;

    public Status(int p, int m) {
        position = p;
        moves = m;
    }
}
