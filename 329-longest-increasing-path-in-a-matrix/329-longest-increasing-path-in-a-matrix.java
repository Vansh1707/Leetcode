class Solution {
    public int longestIncreasingPath(int[][] matrix) {
         int n = matrix.length, m = matrix[0].length;
        int[][] indegree = new int[n][m];
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        LinkedList<Integer>q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int[]d:dir){
                    int r=i+d[0];
                    int c=j+d[1];
                    if(r>=0 && c>=0 && r<n && c<m && matrix[r][c]<matrix[i][j]){
                        indegree[i][j]++;
                    }
                }
                if(indegree[i][j]==0)
                    q.addLast(i*m+j);
            }
        }
        
        int level=0;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int idx=q.removeFirst();
                int i=idx/m,j=idx%m;
                
                for(int[]d:dir){
                    
                    int r=i+d[0];
                    int c=j+d[1];
                    if(r>=0 && c>=0 && r<n && c<m && matrix[r][c]>matrix[i][j] && --indegree[r][c]==0){
                        q.addLast(r*m+c);
                    }
                }                
            }
            level++;
        }
        return level;
    }
}