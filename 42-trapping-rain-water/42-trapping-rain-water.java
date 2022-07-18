class Solution {
    public int trap(int[] height) {
        int i=0,j=height.length-1,water=0,maxl=0,maxr=0;
        
        while(i<j){
            if(height[i]<=height[j]){
                //maxleft
                maxl=Math.max(maxl,height[i]);
                water+=maxl-height[i];
                i++;
            }else{
                //max right
                maxr=Math.max(maxr,height[j]);
                water+=maxr-height[j];
                j--;
            }
        }
        return water;
    }
}