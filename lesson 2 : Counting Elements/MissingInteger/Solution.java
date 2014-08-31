// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        // count array of 1 2 ... N.
        boolean[] count = new boolean[N+1];
        for (int element : A)
            // assign true to the count array if the element of A is from 1 to N
            // if it has already appeared before then ignore it.
            if (element >= 1 && element <= N && count[element] == false)
                count[element] = true;
        // find the minimal positive integer by scanning the count array from left
        // to right, if there is an element which is false, then it's the result.
        for (int i = 1; i <= N; i++)
            if (count[i] == false)
                return i;
        // all the integer from 1 to N has appeared,then the result is N+1.
        return N+1;
    }
}
