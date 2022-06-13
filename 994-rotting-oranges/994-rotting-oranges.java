class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length,m=grid[0].length,shortestpath=1;
        int time=0,orangecount=0,rotcount=0;       
        LinkedList<Integer>q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.addLast(i*m+j);
                    rotcount++;
                }
                else if(grid[i][j]==1) orangecount++;
            }
        }
        if(orangecount==0) return 0;
        else if(rotcount==0) return -1;
        int[][]dir= { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int idx=q.removeFirst();
                
                int sr=idx/m,sc=idx%m;
                
                for(int[]d:dir){
                    int r=sr+d[0];
                    int c=sc+d[1];
                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                        grid[r][c]=2;
                        q.addLast(r*m+c);
                        orangecount--;
                        if(orangecount==0) return time+1;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}