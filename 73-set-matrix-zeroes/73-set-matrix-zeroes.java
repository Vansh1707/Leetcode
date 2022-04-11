class Solution {
    private void make0(int mat[][],int n,int m,int i,int j){
        for(int k=0;k<m;k++){
            mat[i][k]=0;//horizontally zero
        }
        
        for(int k=0;k<n;k++){
            mat[k][j]=0;//vertically zero
        }
    }
    public void setZeroes(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        ArrayList<int[]>rc=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    rc.add(new int[]{i,j});
                }
            }
        }
        for(int a[]:rc){
            make0(mat,n,m,a[0],a[1]);
        }
    }
}