class Solution {
    public int fiboTab(int N,int[]dp){
        for(int n=0;n<=N;n++){
            if(n<=1){
                dp[n]=n;
                continue;
            }
           
            int ans=dp[n-1]+dp[n-2];
             dp[n]=ans;
        }
        return dp[N];
    }
    public int fib(int n) {
        int[]dp=new int[n+1];
        return fiboTab(n,dp);
        
    }
}