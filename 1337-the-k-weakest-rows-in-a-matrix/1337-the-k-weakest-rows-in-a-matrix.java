class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n=mat.length,m=mat[0].length;
        int[]arr=new int[n];
        
        
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++){
                
                if(mat[i][j]==1)count++;
            }
            arr[i]=count;
        }
        
        int ans[]=new int[k];
        
        for(int i=0;i<k;i++){
            int idx=0;
            int min=(int)1e9;
            for(int j=0;j<n;j++){
                if(arr[j]<min){
                    min=arr[j];
                    idx=j;
                }
            }
            ans[i]=idx;
            arr[idx]=(int)1e9;
        }
        
        return ans;
    }
}