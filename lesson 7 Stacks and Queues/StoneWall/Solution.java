// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] H) {
        // write your code in Java SE 8
        int N = H.length;
        int[] stack = new int[N];
        int num = 0;
        stack[num++] = H[0];
        int result = 1;
        for (int i = 1; i < N; i++) {
            // store the stonewall in ascending order and pop out the larger
            // stonewall than the current stonewall
            while (num > 0 && stack[num-1] > H[i]) {
                num--;
            }
            // if the stack is empty or the top of stack isn't equal to the
            // current stonewall, then we should push the current stonewall in
            // the stack and add 1 to the result.
            if (num == 0 || stack[num-1] != H[i]) {
                stack[num++] = H[i];
                result++;
            }
        }
        return result;
    }
}
