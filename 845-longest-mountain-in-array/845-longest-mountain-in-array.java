class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int res=0;
        
        for(int i=1;i<n;i++){
            int count=1;
            boolean flag=false;
            //inc
            int j=i;
            while(j<n && arr[j]>arr[j-1]){
                j++;
                count++;
            }
            
            //dec
            while(i!=j && j<n && arr[j]<arr[j-1]){
                j++;
                count++;
                flag=true;
            }
            
            //max
            if(i!=j && count>2 && flag){
                res=Math.max(res,count);
                j--;
            }
            i=j;
        }
        return res;
    }
}