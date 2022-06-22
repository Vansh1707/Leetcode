class Solution {
    public void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void downheapify(int[] arr,int pi,int li){
        int maxidx=pi,lci=2*pi+1,rci=2*pi+2;
        if(lci<=li && arr[lci]>arr[maxidx]) maxidx=lci;
        if(rci<=li && arr[rci]>arr[maxidx]) maxidx=rci;
        if(maxidx!=pi){
            swap(arr,pi,maxidx);
            downheapify(arr,maxidx,li);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        int li=nums.length-1;
        for(int i=li;i>=0;i--)
            downheapify(nums,i,li);
        
        while(k-->1){
            swap(nums,0,li--);
            downheapify(nums,0,li);
        }
        return nums[0];
    }
}