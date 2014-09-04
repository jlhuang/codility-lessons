// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // using the algorithm in the reading material pdf file
        int N = A.length;
        if (N == 0)
            return -1;
        int value = 0;
        int size = 0;
        // using a stack to store the same element in the array.if there is an
        // element which isn't equal to the top value of the stack, then pop the
        // value out of the stack, otherwise push the value into the stack.
        for (int ele : A) {
            if (size == 0) {
                value = ele;
                size++;
            } else if (value != ele) {
                size--;
            } else {
                size++;
            }
        }
        int candidate = -1;
        int count = 0;
        if (size > 0)
            candidate = value;
        else
            return -1;
        // the candidate could be the dominator of the array and we should test it
        for (int i = 0; i < N; i++) {
            if (A[i] == candidate)
                count++;
            if (count > N / 2)
                return i;
        }
        return -1;
    }
}
