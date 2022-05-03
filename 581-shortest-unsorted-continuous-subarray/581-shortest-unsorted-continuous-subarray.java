class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int []arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=nums[i];
        Arrays.sort(arr);
        
        int si=0,ei=n-1;
        if(Arrays.equals(nums,arr))return 0;
            
        for(int i=0;i<n;i++){
            if(nums[i]==arr[i])continue;
            else{
                si=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]==arr[i])continue;
            else{
                ei=i;
                break;
            }
        }
        return ei-si+1;
    }
}