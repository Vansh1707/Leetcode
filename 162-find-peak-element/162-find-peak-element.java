class Solution {
    public int findPeakElement(int[] arr) {
        int si=0,ei=arr.length-1;
        
       while(si<ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]>arr[mid+1]){
                ei=mid;
            }
            else{
                si=mid+1;
            }
        }
        return si;
        
    }
}