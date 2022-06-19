class Solution {
    public void dfs(char[][]grid,int dir[][],int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        grid[i][j]='0';
        for(int d=0;d<dir.length;d++){
            int r=i+dir[d][0];
            int c=j+dir[d][1];
            
            if(r>=0 && c>=0 && r<n && c<m && grid[r][c]=='1')
                dfs(grid,dir,r,c);
            
        }
        
    }
    
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,dir,i,j);
                    
                }
            }
        }
        return count;
    }
}