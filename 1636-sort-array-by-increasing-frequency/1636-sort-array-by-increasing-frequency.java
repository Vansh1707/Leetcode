class Solution {
    public int[] frequencySort(int[] nums) {
         HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]==b[1])?b[0]-a[0]:(a[1]-b[1]));
        
        // for(Map.Entry<Integer,Integer> entry:map.entrySet())
        //     pq.add(new int[]{entry.getKey(),entry.getValue()});
        
        for(Integer key:map.keySet()){
            pq.add(new int[]{key,map.get(key)});
        }
        int i=0;
        while(!pq.isEmpty())
        {
            int m[]=pq.poll();
            while(m[1]>0)
            {
                nums[i]=m[0];
                m[1]--;
                i++;
            }
        }
        return nums;
    }
}