class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int si = 0, ei = 0, sum = 0, max = 0;
        HashSet<Integer> set = new HashSet<>();
        while(ei<nums.length){
            if(!set.contains(nums[ei])){
                set.add(nums[ei]);
                sum+=nums[ei];
                ei++;
            }else{
                sum-=nums[si];
                set.remove(nums[si]);
                si++;
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}