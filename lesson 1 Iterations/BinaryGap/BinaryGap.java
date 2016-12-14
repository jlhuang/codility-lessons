class Solution {
    public int solution(int N) {
        //converting decimal to binary and assigning a variable to count highest gap
        String bin = Integer.toString(N,2);
        int highest = 0;
        
        
        ArrayList<Integer>index = new ArrayList<Integer>();
        //recording the indexes of 1's in the binary
        for(int i = 0;i<bin.length();i++){
            String temp = ""+bin.charAt(i);
            if(temp.equals("1")){
                index.add(i);
            }
        }
        
        //iterating through the arrayList to find the greatest gap
        for(int i=1;i<index.size();i++){
            if(index.get(i)-index.get(i-1)-1>highest){
                highest = index.get(i)-index.get(i-1)-1;
            }
        }
        System.out.println(index);
        
        return highest;
        
        
        // write your code in Java SE 8
    }
}