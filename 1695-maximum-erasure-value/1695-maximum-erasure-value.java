class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int lastIndex = -1;
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                lastIndex = Math.max(lastIndex, map.get(nums[i]));
            }
            
            if (lastIndex != -1) {
                res = Math.max(res, prefixSum[i] - prefixSum[lastIndex]);
            } else {
                res = Math.max(res, prefixSum[i]);
            }
            
            map.put(nums[i], i);
        }
        
        return res;
    }
}