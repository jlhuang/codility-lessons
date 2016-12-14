// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        // the frog can jump from position X to a position equal to Y
        if ((Y-X) % D == 0)
            return (Y-X) / D;
        // the frog can only jump from position X to a position greater than Y
        else
            return (Y-X) / D + 1;
    }
}
