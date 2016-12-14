class Solution {
    public int[] solution(int[] A, int K) {
        int []B = new int[A.length];
        
        //iterating through array and assigning the values of A to the corresponding steps
        for(int i =0;i<A.length;i++){
            B[(i+K)%A.length]=A[i];
        }
        
        return B;
        // write your code in Java SE 8
    }
}