class Solution {
    List<Integer> list;
    public List<Integer> countSmaller(int[] nums) {
        list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i = nums.length - 1; i >= 0; i--) {
            int idx = add(nums[i]);
            res.add(idx);
            
            if(idx == list.size()) list.add(nums[i]);
            else list.add(idx, nums[i]);
        }
        
        Collections.reverse(res);
        return res;
    }

    
    private int add(int n) {
         if(list.isEmpty() || list.get(list.size() - 1) < n) return list.size();
         
        
        int left = 0, right = list.size() - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(list.get(mid) >= n) right = mid;
            else left = mid + 1;
        }
        
        return left;
    }
}