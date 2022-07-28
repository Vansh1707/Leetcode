class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> h = new HashMap();
        int ans = 0;
        
        for(int i=0; i<grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<grid[i].length; j++) {
                sb.append(grid[i][j]).append("_");
            }
            h.put(sb.toString(),h.getOrDefault(sb.toString(), 0)+1);
        }
        
        
        for(int i=0; i<grid[0].length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<grid.length; j++) {
                sb.append(grid[j][i]).append("_");
            }
            if (h.containsKey(sb.toString())) ans+=h.get(sb.toString());
        }
        
        return ans;
    }
}