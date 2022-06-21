class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
         int indegree [] = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0; i< n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int arr[] :  prerequisites){
            graph.get(arr[0]).add(arr[1]);
            indegree[arr[1]]++;
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        
        for(int i =0; i< n;i++){
            if(indegree[i] == 0){
                q.addLast(i);
            }
        }
        int count =0;
        while(q.size()  > 0){
            int vtx = q.removeFirst();
            count++;
            for(int v : graph.get(vtx)){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.addLast(v);
                    
                }
            }
        }
        return count == n;
    }
}