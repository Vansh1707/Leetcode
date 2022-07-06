class Solution {
    public int fibomem(int n,int[]dp){
        if(n<=1)return dp[n]=n;
        if(dp[n]!=0)return dp[n];
        int ans=fibomem(n-1,dp)+fibomem(n-2,dp);
        return dp[n]=ans;
    }
    public int fib(int n) {
        int[]dp=new int[n+1];
        return fibomem(n,dp);
        
    }
}