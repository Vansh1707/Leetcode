class Solution {
    public boolean canPartitionKSubsets(int[] arr,int idx, int k,int sumSF,int tar,boolean vis[]) {
        if(k==0)return true;
        if(sumSF>tar) return false;
        if(tar==sumSF){
            return canPartitionKSubsets(arr,0,k-1,0,tar,vis);
        }
        
        boolean res=false;
        for(int i=idx;i<arr.length;i++){
            if(vis[i]) continue;
            
            vis[i]=true;
            res=res||canPartitionKSubsets(arr,i+1,k,sumSF+arr[i],tar,vis);
            vis[i]=false;
        }
        return res;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length,sum=0,maxele=0;
        for(int ele:nums){
            sum+=ele;
            maxele=Math.max(maxele,ele);
        }
        if(sum%k!=0 || maxele>sum/k) return false;
        
        boolean[]vis=new boolean[n];
        return canPartitionKSubsets(nums,0,k,0,sum/k,vis);
    }
}