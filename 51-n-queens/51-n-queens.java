class Solution {
     boolean[] rows;
    boolean[] cols;
    boolean[] diags;
    boolean[] adiags;
    List<List<String>>ans=new ArrayList<>();
    public int nqueens(boolean[][]boxes,int tnq,int idx){
        int n=boxes.length,m=boxes[0].length;
        if(tnq==0){
            ArrayList<String>smallans=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<m;j++){
                    sb.append(boxes[i][j]?"Q":".");
                }
                smallans.add(sb.toString());
            }
            ans.add(smallans);
            return 1;
        }
        int count=0;
        for(int i=idx;i<n*m;i++){
            int r=i/m;
            int c=i%m;
            if(rows[r]==false && cols[c]==false && diags[r+c]==false && adiags[r-c+m-1]==false){
                rows[r]=cols[c]=diags[r+c]=adiags[r-c+m-1]=boxes[r][c]=true;
                
                count+=nqueens(boxes,tnq-1,i+1);
                
                rows[r]=cols[c]=diags[r+c]=adiags[r-c+m-1]=boxes[r][c]=false;
            }
        }
        return count;
    }
    public List<List<String>> solveNQueens(int n) {
        int m=n;
        boolean[][] boxes=new boolean[n][m];
        rows=new boolean[n];
        cols=new boolean[m];
        diags=new boolean[n+m-1];
        adiags=new boolean[n+m-1];
        
        nqueens(boxes,n,0);
        return ans;
    }
}