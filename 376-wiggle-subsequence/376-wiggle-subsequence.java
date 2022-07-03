class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length - 1;
        int pre = Integer.MAX_VALUE;
        int res = 0;
            
        for (int i = 0; i < len; i++){
            int temp = nums[i + 1] - nums[i];
           if ((pre == Integer.MAX_VALUE && temp != 0) || (temp < 0 && pre > 0) || (temp > 0 && pre < 0)){
                res ++;
                pre = temp;  
            }
        }
        return res+1;
    }
}