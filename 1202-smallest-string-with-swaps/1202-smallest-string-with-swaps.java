class Solution {
    int[] par, size;

    public int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        par=new int[s.length()];
        for(int i=0;i<s.length();i++)
            par[i]=i;
        
        for(List<Integer>pair:pairs){
            int u=pair.get(0),v=pair.get(1);
            int p1 = findPar(u), p2 = findPar(v);
            
            if (p1 != p2) {
                par[p1] = p2;
            }
        }
        Map<Integer,Queue<Character>>hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.putIfAbsent(findPar(i),new PriorityQueue<>());
            hm.get(findPar(i)).add(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(hm.get(findPar(i)).poll());
        }
        return sb.toString();
    }
}