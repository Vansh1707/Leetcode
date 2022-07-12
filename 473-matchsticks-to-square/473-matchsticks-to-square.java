class Solution {
    // like partition in k eqaul subset 
    
     public boolean canPartitionSubsets(int[] arr,int idx, int k,int sumSF,int tar,boolean vis[]) {
        if(k==1)return true;
        if(sumSF>tar) return false;
        if(tar==sumSF){
            return canPartitionSubsets(arr,0,k-1,0,tar,vis);
        }
        
        boolean res=false;
        for(int i=idx;i<arr.length;i++){
            if(vis[i]) continue;
            
            vis[i]=true;
            res=res||canPartitionSubsets(arr,i+1,k,sumSF+arr[i],tar,vis);
            vis[i]=false;
        }
        return res;
    }
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        int n=matchsticks.length;
        for(int ele:matchsticks)sum+=ele;
        
        if(sum%4!=0)return false;
        
        boolean[]vis=new boolean[n];
        return canPartitionSubsets(matchsticks,0,4,0,sum/4,vis);
    }
}