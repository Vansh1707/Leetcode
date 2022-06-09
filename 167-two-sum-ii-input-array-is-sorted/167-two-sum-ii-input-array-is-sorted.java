class Solution {
    public int[] twoSum(int[] nums, int tar) {
        int si=0,ei=nums.length-1;
        
        while(si<ei){
            int sum=nums[si]+nums[ei];
            if(sum==tar)
                return new int[]{si+1,ei+1};
            else if(sum<tar)
                si++;
            else
                ei--;
        }
        return new int[]{-1,-1};
    }
}