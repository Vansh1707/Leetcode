class Solution {
    private int dfs(int[][]grid,int i,int j,int n,int m){
        if(i<0 || j<0 ||i>n ||j>=m)return -1; //j>=m
        if(i==n)return j;
        
         if(grid[i][j]==-1){
			//Check for V shape.
            if(j>0 && grid[i][j-1] == 1)
                return -1;
            return dfs(grid, i+1, j-1, n, m);
        }
        else{
			//Check for V Shape.
            if(j<m-1 && grid[i][j+1] == -1)
                return -1;
            return dfs(grid, i+1, j+1, n, m);
        }
    }
    public int[] findBall(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[]ans=new int[m];
        for(int j=0;j<m;j++){
            ans[j]=dfs(grid,0,j,n,m);
        }
        return ans;
    }
}