class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int sum=0;
        for(int ele:nums)sum+=ele;
        int tar=sum-x;
        if(tar==0)return n;
        if(tar<0)return -1;
        int li=0;
        int prefsum=0;
        int res=-1;
        
        for(int i=0;i<n;i++){
            prefsum+=nums[i];
            while(prefsum>tar){
                prefsum-=nums[li++];
            }
            if(prefsum==tar){
                res=Math.max(res,i-li+1);
            }
        }        
        return res==-1 ? -1 : n-res;
    }
}