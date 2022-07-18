class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[]leftmax=new int[n];
        int[]rightmax=new int[n];
        int water=0;
        
        for(int i=0;i<n;i++){
            if(i==0){
                leftmax[0]=height[0];
                rightmax[n-1]=height[n-1];
            }else{
                leftmax[i]=Math.max(leftmax[i-1],height[i]);
                rightmax[n-i-1]=Math.max(rightmax[n-i],height[n-i-1]);
            }
        }
        for(int i=0;i<n;i++){
            water+=Math.min(leftmax[i],rightmax[i])-height[i];
        }
        return water;
    }
}