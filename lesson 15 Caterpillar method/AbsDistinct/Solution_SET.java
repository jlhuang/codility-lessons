// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // use a set to solve this problem and the time complexity is still
        // O(N*log(N)).
        // the fastest way is still the caterpillar method.
        Collection<Integer> set = new HashSet<Integer>();
        for (int ele : A) {
            set.add(new Integer(Math.abs(ele)));
        }
        return set.size();
    }
}
