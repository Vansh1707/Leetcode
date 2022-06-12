class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<32;i++){
            int sumAti=0;
            for(int ele:nums){
                if(((ele>>i)&1)==1){
                    sumAti++;
                }
            }
            if(sumAti%3!=0){
                res=res|1<<i;
            }
        }
        return res;
    }
}