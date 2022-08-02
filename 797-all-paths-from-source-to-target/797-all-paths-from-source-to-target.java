class Solution {
    public int dfs(int[][] graph, int src,List<List<Integer>> ans, List<Integer> smallans) {
        smallans.add(src);
        if(src == graph.length-1) {
            ans.add(new ArrayList<Integer>(smallans));
            return 1;
        }
        int count=0;
        
        for(int v : graph[src]) {
            count+=dfs(graph, v, ans,smallans);
            smallans.remove(smallans.size()-1);
        }
        return count;
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallans = new ArrayList<>();
        dfs(graph, 0, ans,smallans);
        return ans;
    }
}