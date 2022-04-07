class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        
        for(int weight:stones)
            pq.add(weight);
        
        while(pq.size()>=2){
            int y=pq.remove();
           
            int x=pq.remove();
            
            if(x==y)
                continue;
            else if(x!=y)
                pq.add(y-x);
            
            
        }
        if(pq.size()==0)
                return 0;
        return pq.remove();
    }
}