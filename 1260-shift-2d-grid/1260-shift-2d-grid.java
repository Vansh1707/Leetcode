class Solution {
    public void reverse(int[] arr,int i,int j){
        int li=i,ri=j;
        
         while(li<ri){
          int swap=arr[li];
          arr[li]=arr[ri];
          arr[ri]=swap;
          
          li++;
          ri--;
      }
        
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        
        k = k % n;
        if(k<0) k=k+n;
        
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=grid.length,m=grid[0].length;
        int []arr=new int[n*m];
        
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                arr[i*m+j]=grid[i][j];
            }
        }
        
        rotate(arr,k);
        // for(int i=0;i<n*m;i++){
        //     System.out.println(arr[i]);
        // }
        for(int i=0;i<n;i++){
            List<Integer>smallans=new ArrayList<>();
            for(int j=0;j<m;j++){
                smallans.add(arr[i*m+j]);
            }
            ans.add(smallans);
        }
        return ans;
    }
}