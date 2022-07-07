class Solution {
    public int rob_I(int[] arr, int si,int ei, int[] dp) {
        if (si>ei)
            return 0;

        if (dp[si] != -1)
            return dp[si];

        int robCurrHouse = arr[si] + rob_I(arr, si+2,ei, dp);
        int notRobCurrHouse = rob_I(arr, si+1,ei, dp);

        return dp[si] = Math.max(robCurrHouse, notRobCurrHouse);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n == 1 ? nums[0] : 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return rob_I(nums, 0,n-1, dp);
    }
}