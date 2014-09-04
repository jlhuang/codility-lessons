// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // we know that if there is an equi leader that exists, then the leader
        // element must be the leader element of the whole array. on the other
        // hand, if there is a leader element in the whole array, then there
        // could be an equi leader that exists.
        // so the algorithm here is first find out the leader element in the
        // whole array and then count the number of equi leader in O(N) time complexity.
        int N = A.length;
        if (N == 1)
            return 0;
        // stores the index of the leader element
        int[] leaderIndex = new int[N];
        int value = 0;
        int size = 0;
        // using the algorithm in the reading material to find the leader in
        // O(N) time complexity
        for (int ele : A) {
            if (size == 0) {
                value = ele;
                size++;
            } else if (value == ele) {
                size++;
            } else
                size--;
        }
        if (size == 0)
            return 0;
        int countLeader = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == value) {
                countLeader++;
                leaderIndex[i] = 1;
            }
        }
        if (countLeader <= N / 2)
            return 0;
        // using prefix sum to calculate the number of leaders before index i in
        // O(1) time complexity
        for (int i = 1; i < N; i++) {
            leaderIndex[i] += leaderIndex[i-1];
        }
        int countEquiLeader = 0;
        // the number of leaders in A[0] A[1] ... A[S] is leaderIndex[i]
        // the number of leaders in A[S+1] A[S+2] ... A[N-1] is countleader - leaderIndex[i]
        for (int i = 0; i < N - 1; i++) {
            if (leaderIndex[i] > (i + 1) / 2 && (countLeader - leaderIndex[i]) > (N - i - 1) / 2)
                countEquiLeader++;
        }
        return countEquiLeader;
    }
}
