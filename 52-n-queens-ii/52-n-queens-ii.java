class Solution {
    int cols=0;
    int diags=0;
    int adiags=0;
    int nqueen(int n,int floor){
        if(floor==n) return 1;
        
        int count=0,m=n;
        for(int room=0;room<n;room++){
            int r=floor,c=room;
            if((cols & (1 << c))==0 && (diags &(1 <<(r+c)))==0 && (adiags &(1 <<(r-c+m-1)))==0){
                //mark true
                cols ^= (1<<c);
                diags ^= (1<<(r+c));
                adiags ^=(1<<(r-c+m-1));
                
                count+=nqueen(n,floor+1);
                
                //mark false
                cols ^= (1<<c);
                diags ^= (1<<(r+c));
                adiags ^=(1<<(r-c+m-1));
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        return nqueen(n,0);
        
    }
}