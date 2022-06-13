class Solution {
    int [] row=new int[9];
    int [] col=new int[9];
    int [][] mat =new int[3][3];
    
    public boolean solveSudoku(char[][] board,ArrayList<Integer>emptyidx,int idx) {
        if(idx==emptyidx.size()) return true;
        
        int cell=emptyidx.get(idx);
        int r=cell/9;
        int c=cell%9;
        
        for(int num=1;num<=9;num++){
            int mask= 1<<num;
            if((row[r] & mask)==0 && (col[c] & mask)==0 && (mat[r/3][c/3] & mask)==0){
                
                row[r] ^=mask;
                col[c] ^=mask;
                mat[r/3][c/3] ^=mask;
                
                board[r][c]=(char)(num+'0');
                if(solveSudoku(board,emptyidx,idx+1)==true)
                    return true;
                board[r][c]='.';
                
                row[r] ^=mask;
                col[c] ^=mask;
                mat[r/3][c/3] ^=mask;
            }
            
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        ArrayList<Integer>emptyidx=new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    emptyidx.add(i*9+j);   // idx=r*m+c; 2d to 1d conversion
                }else{
                    int mask= 1 << (board[i][j]-'0');
                    row[i] ^=mask;
                    col[j] ^=mask;
                    mat[i/3][j/3] ^=mask;
                }
            }
        }
        solveSudoku(board,emptyidx,0);
    }
}