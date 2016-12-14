// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if (N == 0)
            return 0;
        quickSort(A, 0, N-1);
        int num = 1;
        int preDist = A[0];
        for (int i = 1; i < N; i++) {
            if (A[i] != preDist) {
                preDist = A[i];
                num++;
            }
        }
        return num;
    }
    // ordinary quick_sort function, it performs O(N*N) time complexity when in
    // the worst case, but still the solution get 100/100 on codility.
    public void quickSort(int[] array, int start, int end) {
        if (start <= end) {
            int index = partition(array, start, end);
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    public int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < pivot) {
                mark++;
                if (i != mark) {
                    int temp = array[mark];
                    array[mark] = array[i];
                    array[i] = temp;
                }
            }
        }
        if (start != mark) {
            array[start] = array[mark];
            array[mark] = pivot;
        }
        return mark;
    }
}
