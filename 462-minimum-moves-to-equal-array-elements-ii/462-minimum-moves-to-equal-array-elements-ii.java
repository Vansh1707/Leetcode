class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int n=nums.length;
        
        int median=n%2==0?(nums[n/2]+nums[n/2-1])/2:nums[n/2];
        for(int num:nums){
            ans+=Math.abs(num-median);
        }
        return ans;
    }
}