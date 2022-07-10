class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int counton=0;
            for(int val:nums){
                if((val &(1<<i))!=0){
                    counton++;
                }
            }
            int countoff=nums.length-counton;
            int count=counton*countoff;
            ans+=count;
        }
        return ans;
    }
}