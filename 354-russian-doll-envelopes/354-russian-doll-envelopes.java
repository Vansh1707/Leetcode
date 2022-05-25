class Solution {
    public int binarySearch(int arr[],int si,int ei,int tar){
        while(si<ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]==tar){
                return mid;
            }else if(arr[mid]<tar){
                si=mid+1;
            }else{
                ei=mid;
            }
        }
        return si;
    }
    public int maxEnvelopes(int[][] envelopes) {
         int n = envelopes.length;
        Arrays.sort(envelopes, (a,b) -> a[0]==b[0]?b[1]-a[1]:a[0] - b[0]);
        int[]dp=new int[n];
        int max=0;
        
        
        for(int i=0;i<n;i++){
            int index=binarySearch(dp,0,max,envelopes[i][1]);
            dp[index]=envelopes[i][1];
            if(index==max){
                max++;
            }
        }
        return max;
        
    }
}