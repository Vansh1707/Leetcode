class Solution {
    public int pathSum(int[][]grid, int n, int m, int i, int j, int[][] dp,int[][]dir){
        if(i==n-1 && j==m-1)return grid[i][j]; 
        if(dp[i][j] != -1)return dp[i][j];
        
        int minsum=(int)1e9;
        for(int d=0;d<dir.length;d++){
            int r=i+dir[d][0];
            int c=j+dir[d][1];
            
            if(r<n && c<m){
                int sum=pathSum(grid,n,m,r,c,dp,dir);
                if(sum<minsum)
                    minsum=sum;
            }
        }
        
        dp[i][j] = grid[i][j] + minsum;
        
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
        int[][]dir={{0,1},{1,0}};
        int[][] dp = new int[n][m];
        
        for(int[] d: dp)
            Arrays.fill( d ,-1 );
        
        int sum = pathSum(grid, n, m, 0 ,0, dp,dir);
        
        return sum;
    }
}