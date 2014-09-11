// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int[] fib = new int[N + 4];
        boolean[] visit = new boolean[N];
        fib[0] = 0;
        fib[1] = 1;
        int m = 1;
        do {
            m++;
            fib[m] = fib[m-1] + fib[m-2];
        } while (fib[m] <= N + 1);
        ArrayList<Status> statusQueue = new ArrayList<Status>();
        // use a queue to save the position and the moves of every possible jump
        statusQueue.add(new Status(-1, 0));
        int nextTry = 0;
        // use the breadth first search to get the result
        while (true) {
            if (nextTry == statusQueue.size())
                return -1;
            Status currStatus = statusQueue.get(nextTry);
            nextTry++;
            int currPosition = currStatus.position;
            int currMoves = currStatus.moves;
            for (int i = m-1; i > 0; i--) {
                if (currPosition + fib[i] == N)
                    return currMoves + 1;
                else if (currPosition + fib[i] > N ||
                         A[currPosition + fib[i]] == 0 ||
                         visit[currPosition + fib[i]] == true)
                    continue;
                statusQueue.add(new Status(currPosition + fib[i], currMoves + 1));
                visit[currPosition + fib[i]] = true;
            }
        }
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
