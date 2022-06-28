class Solution {
    int[]low,disc,par;
    int time=0;
    boolean vis[];
    
    public void dfs(ArrayList<ArrayList<Integer>>graph,int src,List<List<Integer>>ans){
        
        disc[src]=low[src]=time++;
        vis[src]=true;
        for(int i=0;i<graph.get(src).size();i++){
            int nbr=graph.get(src).get(i);
            
            if(par[src]==nbr)continue;
            else if(vis[nbr]){
                low[src]=Math.min(low[src],disc[nbr]);
            }else{
                par[nbr]=src;
                dfs(graph,nbr,ans);
                
                low[src]=Math.min(low[src],low[nbr]);
                if(disc[src]<low[nbr]){
                    List<Integer>smallans=new ArrayList<>();
                    smallans.add(src);
                    smallans.add(nbr);
                    ans.add(smallans);
                }
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        
        for(int i=0;i<Edges.size();i++){
            int u=Edges.get(i).get(0);
            int v=Edges.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        disc=new int[n];
        low=new int[n];
        par=new int[n];
        vis=new boolean[n];
        
        List<List<Integer>>ans=new ArrayList<>();
        
        dfs(graph,0,ans);
        
        return ans;
    }
}