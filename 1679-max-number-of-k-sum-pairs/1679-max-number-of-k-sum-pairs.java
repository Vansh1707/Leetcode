class Solution {
    public int maxOperations(int[] nums, int k) {
         HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int val : nums){
            int res = k - val;
            if(map.containsKey(res) && map.get(res) > 0){
                count++;
                map.put(res, map.get(res) - 1);
            }else{
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        return count;
    }
}