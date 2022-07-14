class Solution {
    public int singleNonDuplicate(int[] nums) {
        int si=0,ei=nums.length-1;
        if(nums.length==1)return nums[0];
        if(nums[0]!=nums[1])return nums[0];
        if(nums[ei]!=nums[ei-1])return nums[ei];
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            else if(nums[mid]==nums[mid-1]){
                //low to mid count
                int lc=mid-si+1;
                if(lc%2==0){
                    si=mid+1;
                }else{
                    ei=mid-2;
                }
            } 
            else if(nums[mid]==nums[mid+1]){
                int rc=ei-mid+1;
                if(rc%2==0){
                    ei=mid-1;
                }else{
                    si=mid+2;
                }
            }
        }
        return -1;
    }
}