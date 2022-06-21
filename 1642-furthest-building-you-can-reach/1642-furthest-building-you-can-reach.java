class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            return a-b;
        });
        for(int i=0;i<n-1;i++){
            int heidiff=heights[i+1]-heights[i];
            if(heidiff>0)
                pq.add(heidiff);
            
            if(pq.size()>ladders){
                bricks=bricks-pq.remove();
            }
            if(bricks<0){
                ladders--;
                return i;
            }
        }
        return n-1;
    }
}