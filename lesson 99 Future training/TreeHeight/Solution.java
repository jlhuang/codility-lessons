// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(Tree T) {
        // write your code in Java SE 8
        return height(T);
    }

    // recursively get the height of the binary tree
    public int height(Tree t) {
        // tree t is empty
        if (t == null)
            return -1;
        // get the maximum of the height of the left tree and the right tree,
        // and return the value plus 1 because of counting the current node.
        else
            return Math.max(height(t.l) + 1, height(t.r) + 1);
    }
}
