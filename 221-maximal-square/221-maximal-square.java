class Solution {
    
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int[][]dp=new int[n][m];
        int ans=0;
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 || j==m-1 ||matrix[i][j] == '0'){
                    dp[i][j]=matrix[i][j]-'0';
                // }else if(i==n-1){
                //     dp[i][j]=matrix[i][j]-'0';
                // }else if(j==m-1){
                //     dp[i][j]=matrix[i][j]-'0';
                // }
                }else{
                      dp[i][j]=Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]))+1;
                    }
                ans=Math.max(ans,dp[i][j]);
                }
            }
        return ans*ans;
        
    }
}