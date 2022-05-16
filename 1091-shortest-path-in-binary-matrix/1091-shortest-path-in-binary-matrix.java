class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        
        int n=grid.length,m=grid[0].length,shortestpath=1;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;
        
        LinkedList<Integer>q=new LinkedList<>();
        int[][]dir= { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };
        
        q.addLast(0);
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int idx=q.removeFirst();
                int sr=idx/m,sc=idx%m;
                
                if(sr==n-1 && sc==m-1)
                    return shortestpath;
                
                for(int[]d: dir){
                    int r = sr + d[0];
                    int c = sc + d[1];
                    
                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        q.addLast(r * m + c);
                }
            }
        }
         shortestpath++;   
    }
        return -1;
}
}