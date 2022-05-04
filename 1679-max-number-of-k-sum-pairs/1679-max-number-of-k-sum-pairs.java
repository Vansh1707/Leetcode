class Solution {
    public int maxOperations(int[] nums, int k) {
        int i = 0, j = nums.length - 1, count = 0;
      Arrays.sort(nums);
      while(i < j) {
        if(nums[i] + nums[j] == k) {
          count ++;
          i ++;
          j --;
        }
        else if(nums[i] + nums[j] < k) i ++;
        else j --;
      }
      return count;
    }
}