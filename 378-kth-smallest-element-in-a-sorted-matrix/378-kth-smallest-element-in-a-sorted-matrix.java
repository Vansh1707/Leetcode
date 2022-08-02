class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length,m=matrix[0].length;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            int r1=a/m,c1=a%m;
            int r2=b/m,c2=b%m;
            return matrix[r1][c1]-matrix[r2][c2];
        });
        
        for(int i=0;i<n;i++){
            pq.add(i*m+0); //add all first col ele
        }
        int ans=0;
        
        while(k-->0){
            int idx=pq.remove();
            int r=idx/m,c=idx%m;
            
            ans=matrix[r][c];
            c++;
            if(c<m)
                pq.add(r*m+c);
            
        }
        return ans;
    }
}