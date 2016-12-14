// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if (N < 3)
            return 0;
        // stores the index of peak element
        boolean[] peakIndex = new boolean[N];
        int peakNumber = 0;
        for (int i = 1; i < N-1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peakIndex[i] = true;
                peakNumber++;
            }
        }
        if (peakNumber == 0)
            return 0;
        int blockNumber = 1;
        for (int block = 2; block <= peakNumber; block++) {
            // the array can be divided into blocks
            if (N % block == 0) {
                int k = N / block;
                int blockEnd = k;
                boolean blockExist = true;
                // we know that at last i == N - 1 == blockEnd - 1, so i < N.
                for (int i = 1; i < N; i++) {
                    // this block has at least one peak so move to next block
                    if (peakIndex[i] == true) {
                        i = blockEnd - 1;
                        blockEnd += k;
                        // this block has no peak so this divide has failed
                    } else if (i == blockEnd-1){
                        blockExist = false;
                        break;
                    }
                }
                if (blockExist == true)
                    blockNumber = block;
            }
        }
        return blockNumber;
    }
}
