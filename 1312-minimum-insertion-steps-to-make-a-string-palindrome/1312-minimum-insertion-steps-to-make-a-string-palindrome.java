class Solution {
    public int lps(String s,int I,int J,int[][]dp) {
        int n=s.length();
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(i>=j){
                    dp[i][j]=(i==j?1:0);
                    continue;
                }
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[I][J];
    }
    public int minInsertions(String s) {
        int n=s.length();
        int[][]dp=new int[n][n];
        int lpsLen= lps(s,0,n-1,dp);
        return n-lpsLen;
    }
}