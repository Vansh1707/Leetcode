class Solution {
    int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};

    public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] vis){
        if(i < 0 || i >= vis.length || j < 0 || j >= vis[0].length) return;
        if(matrix[i][j] < prev || vis[i][j]) return;
        vis[i][j] = true;
        for(int[] d : dir){
            int r=i+d[0];
            int c=j+d[1];
            dfs(matrix, r, c, matrix[i][j], vis);
        }
        
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=heights.length,m=heights[0].length;
        if(n==0||m==0)return ans;
        
        boolean[][]pacific=new boolean[n][m];
        boolean[][]atlantic=new boolean[n][m];
        //DFS
        for(int i=0;i<m;i++){
            dfs(heights,0,i,Integer.MIN_VALUE,pacific);
            dfs(heights,n-1,i,Integer.MIN_VALUE,atlantic);
        }
        for(int i=0;i<n;i++){
            dfs(heights,i,0,Integer.MIN_VALUE,pacific);
            dfs(heights,i,m-1,Integer.MIN_VALUE,atlantic);
        }
        
        //res
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
        
    }
}