class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>fmap=new HashMap<>();
        for(int ele:nums)
            fmap.put(ele,fmap.getOrDefault(ele,0)+1);
        
        //{val,freq}
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        
        for(int key:fmap.keySet()){
            pq.add(new int[]{key,fmap.get(key)});
            if(pq.size()>k)
                pq.remove();
        }
        int []ans=new int[k];
        int i=0;
        while(k-->0){
            int[]rp=pq.remove();
            int val=rp[0],freq=rp[1];
            ans[i++]=val;
        }
        return ans;
    }
}