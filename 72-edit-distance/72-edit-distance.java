class Solution {
    public int minDistance(String s1, String s2,int N,int M,int[][]dp) {
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                if(n==0 && m==0){
                    dp[n][m]=0;
                    continue;
                }
                if(n==0){
                    dp[n][m]=m;
                    continue;
                }
                if(m==0){
                    dp[n][m]=n;
                    continue;
                }

                int insert=dp[n][m-1];
                int delete=dp[n-1][m];
                int replace=dp[n-1][m-1];

                if(s1.charAt(n-1)==s2.charAt(m-1))
                    dp[n][m]=replace;
                else
                    dp[n][m]=Math.min(Math.min(insert,delete),replace)+1;
            }
        }
        return dp[N][M];
        
    }
    
    public int minDistance(String s1, String s2) {
        int[][]dp = new int[s1.length()+1][s2.length()+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return minDistance(s1,s2,s1.length(),s2.length(),dp);
    }
}