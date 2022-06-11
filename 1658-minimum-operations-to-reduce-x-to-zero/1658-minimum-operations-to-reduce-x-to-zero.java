class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int sum=0;
        for(int ele:nums)sum+=ele;
        int tar=sum-x;
        if(tar==0)return n;
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,-1);
        int prefsum=0,res=-1;
        for(int i=0;i<n;i++){
            prefsum+=nums[i];
            if(hm.containsKey(prefsum-tar)){
                res=Math.max(res,i-hm.get(prefsum-tar));
            }
            hm.put(prefsum,i);
        }
        return res==-1?-1:n-res;
        
        
    }
}