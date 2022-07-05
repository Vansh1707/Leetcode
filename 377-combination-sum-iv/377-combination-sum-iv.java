class Solution {
    public int combinationSum4(int[] arr, int Tar) {
        int[]dp=new int[Tar+1];
        dp[0] = 1;
        for (int tar = 1; tar <= Tar; tar++) {
            int count = 0;
            for (int ele : arr) {
                if (tar - ele >= 0)
                    count += dp[tar - ele];
            }
            dp[tar] = count;
        }
        return dp[Tar];
    }
}