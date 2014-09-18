// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // it is very easy to solve this problem using a map, the time complexity
        // is still O(N*log(N)).
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int ele : A) {
            map.put(String.valueOf(Math.abs(ele)), ele);
        }
        return map.size();
    }
}
