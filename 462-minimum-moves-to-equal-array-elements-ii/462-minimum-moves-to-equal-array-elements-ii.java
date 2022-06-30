class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int n=nums.length;
        
        int i=0,j=n-1;
        while(i<j){
            ans+=(nums[j]-nums[i]);
            i++;
            j--;
        }
        return ans;
    }
}