class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int n = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            //This means the smallest element with two biggest elements can't satisfity the target. There is no need to move the right pointer.
            if (nums[i] + nums[n - 1] + nums[n - 2] < target) {
                sum = nums[i] + nums[n - 1] + nums[n - 2];
                continue;
            }
            //These three smallest elements in the sums are the closest elements to target. We can't find another possible.
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                int temp = nums[i] + nums[i + 1] + nums[i + 2];
                if(Math.abs(sum - target) < Math.abs(temp - target)){
                    return sum;
                }else{
                    return temp;
                }
            }
            //The ordinary seek with three pointers.
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target) {
                    return target;
                }
                if (temp < target) {
                    left++;
                } else {
                    right--;
                }
                
                if(Math.abs(sum - target) >= Math.abs(temp - target)){
                    sum = temp;
                }
            }
        }
        return sum;
    }
}