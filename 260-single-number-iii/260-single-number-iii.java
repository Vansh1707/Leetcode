class Solution {
    public int[] singleNumber(int[] nums) {
        // xor all elements
        int res=0;
        
        for(int num:nums){
            res^=num;
        }
        
        //finf bit mask
        int mask=res & (-res);
        
        //divide all ele in 2 grp and take xor
        
        int groupA=0;
        int groupB=0;
        for(int num: nums){
            if((mask & num)==0){
                groupA^=num;
            }else{
                groupB^=num;
            }
        }
        return new int[]{groupA,groupB};
    }
}