// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;

class Solution {
    public int solution(Tree T) {
        // write your code in Java SE 8
        // the queue holds the nodes of each level in the tree.
        ArrayList<Tree> queue = new ArrayList<Tree>();
        queue.add(T);
        int height = -1;
        while (queue.size() != 0) {
            height++;
            // the number of current level nodes
            int numberOfLevelNode = queue.size();
            while (numberOfLevelNode != 0) {
                // remove all the current level nodes
                Tree t = queue.remove(0);
                // add the next level nodes
                if (t.l != null)
                    queue.add(t.l);
                if (t.r != null)
                    queue.add(t.r);
                numberOfLevelNode--;
            }
        }
        return height;
    }
}
