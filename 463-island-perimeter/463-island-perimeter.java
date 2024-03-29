class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int oncecount=0 , nbrcount=0;
        // int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        int dir[][]={{1,0},{0,1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                   oncecount++;
                    for(int d=0;d<dir.length;d++){
                        int r=i+dir[d][0];
                        int c=j+dir[d][1];
                        
                        if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1)
                            nbrcount++;
                    }
                }
            }
        }
        return 4*oncecount - 2*nbrcount;
    }
}