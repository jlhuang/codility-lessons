// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        // the variable stores the minimal negative element
        int negativeMin = 0;
        // the variable stores the second minimal negative element
        int negativeSecond = 0;
        // the variable stores the third maximal element
        int thirdMax = -1000;
        // the variable stores the second maximal element
        int secondMax = -1000;
        // the variable stores the maximal element
        int maxValue = -1000;
        // get the five variables above in O(N) time complexity
        for (int element : A) {
            if (element < negativeMin) {
                negativeSecond = negativeMin;
                negativeMin = element;
            } else if (element < negativeSecond)
                negativeSecond = element;
            if (element > maxValue) {
                thirdMax = secondMax;
                secondMax = maxValue;
                maxValue = element;
            } else if (element > secondMax) {
                thirdMax = secondMax;
                secondMax = element;
            } else if (element > thirdMax)
                thirdMax = element;
        }
        // the product of the three maximal elements
        int maxProduct = thirdMax * secondMax * maxValue;
        // the number of negative elements is more than 2
        if (negativeSecond != 0)
            // the result is either the product of the three maximal elements or
            // the product of the two minimal negative elements and the maximal
            // positive element.
            return Math.max(negativeMin * negativeSecond * maxValue, maxProduct);
        // the number of negative elements is less than 2
        else
            return maxProduct;
    }
}
