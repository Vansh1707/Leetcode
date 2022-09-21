class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
	
		// get sum of even values of nums
        int eSum = 0;
        for(int e : nums) if((e&1)==0) eSum += e;
        
        int i=0;
        int[] res = new int[nums.length];
        
        for(int[] e : queries){
            
            // Value and Index to apply query
            int val = e[0], idx = e[1];
            int ele = nums[idx];
            
            // Reduce eSum if ele is included in eSum
            if((ele&1)==0) eSum -= ele;
            
            // Increase eSum if new nums[idx] is making an even value
            int sum = ele+val;
            if((sum&1)==0) eSum += sum;
            
            // now update the arrays
            nums[idx] = sum;
            res[i++] = eSum;
        }
        
        return res;
    }
}