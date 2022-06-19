class Solution {
    public void dfs(char[][] board, int dir[][],int i,int j){
        int n=board.length;
        int m=board[0].length;
        board[i][j]='$';
        for(int d=0;d<dir.length;d++){
            int r=i+dir[d][0];
            int c=j+dir[d][1];
            
            if(r>=0 && c>=0 && r<n && c<m && board[r][c]=='O'){
                dfs(board,dir,r,c);
            }
        }
    }
    
    public void solve(char[][] board) {
         int n=board.length;
        int m=board[0].length;
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 ||j==0||i==n-1||j==m-1){
                    if(board[i][j]=='O')
                        dfs(board,dir,i,j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                   board[i][j]='X';
                }else if(board[i][j]=='$')
                    board[i][j]='O';
            }
        }
        
    }
}