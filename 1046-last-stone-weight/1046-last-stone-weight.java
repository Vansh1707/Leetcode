class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        
        for(int weight:stones)
            pq.add(weight);
        
        while(pq.size()>=2){
            int x=pq.remove();
            int y=pq.remove();
            
            if(x==y){
                continue;
            }else{
                pq.add(x-y);
            }
        }
        if(pq.size()==0)return 0;
        else return pq.remove();
    }
}