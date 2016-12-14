class Solution {
    public int solution(int[] A) {
        int num = 0;
        
        //Doing a XOR operation so that only one particular number gets left out
        for(int numbers:A){
            num^=numbers;
        }
        
        return num;
        // write your code in Java SE 8
    }
}