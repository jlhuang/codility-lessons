// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // we know that the number of inversions is the times of the swap of the
        // array to be sorted.so we can use the merge sort and count the swap times.
        return inversionCount(A);
    }

    public int merge(int[] array, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                array[i + j] = right[j];
                j++;
            } else if (j == right.length) {
                array[i + j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                array[i + j] = left[i];
                i++;
            } else {
                array[i + j] = right[j];
                j++;
                // The number of inversions removed by this operation is the
                // number of elements left from the left array to be merged
                count += left.length - i;
            }
        }
        return count > 1000000000 ? -1 : count;
    }

    public int inversionCount(int[] array) {
        if (array.length < 2)
            return 0;
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return inversionCount(left) + inversionCount(right) + merge(array, left, right);
    }
}
