class Solution {
    public int lcs(String s1, String s2,int N,int M,int[][]dp) {
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                if(n==0 ||m==0){
                dp[n][m]=0;
                    continue;
                }
            

            if(s1.charAt(n-1)==s2.charAt(m-1))
                dp[n][m]=dp[n-1][m-1]+1;
            else
                dp[n][m]=Math.max(dp[n-1][m],dp[n][m-1]);
            }
        }
        return dp[N][M];
        
    }
    
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][]dp=new int[n+1][m+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return lcs(s1,s2,n,m,dp);
    }
}