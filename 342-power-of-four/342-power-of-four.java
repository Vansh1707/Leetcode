class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0 || (n & (n-1))!=0) return false; //not power of two
        
        int count=0;
        while(n!=0){
            if((n & 1)==0)
                count++;
                n>>>=1;            
        }
        return (count & 1) == 0;  //even num of zero in binary
    }
}