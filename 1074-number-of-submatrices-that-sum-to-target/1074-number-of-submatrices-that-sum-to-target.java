class Solution {
    public int countSubarrayGivenTarget(int[] arr,int target){
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int count=0,sum=0;
        for(int ele:arr){
            sum+=ele;
            count+=map.getOrDefault(sum-target,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public int numSubmatrixSumTarget(int[][] arr, int target) {
        int n=arr.length,m=arr[0].length,count=0;
        
        for(int fixrow=0;fixrow<n;fixrow++){
            int[]prefixsum=new int[m];
            for(int r=fixrow;r<n;r++){
                for(int c=0;c<m;c++){
                    prefixsum[c]+=arr[r][c];
                }
                count+=countSubarrayGivenTarget(prefixsum,target);
            }
        }
        return count;
    }
}