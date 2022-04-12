class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length,m=board[0].length;
        int[][]dir={{ 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 },
                    { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }};
        
        int[][]mat=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=board[i][j];
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int live=0;
                for(int d=0;d<8;d++){
                    int r=i+dir[d][0];
                    int c=j+dir[d][1];
                    if(r<n && c<m && r>=0 &&c >=0 && mat[r][c]==1){
                        live++;                        
                    }
                }
                //System.out.println(live);
                if(mat[i][j]==0 && live==3)board[i][j]=1;
                else if(mat[i][j]==1 &&(live==2||live==3))board[i][j]=1;
                else board[i][j]=0;
            }
        }
        
    }
}