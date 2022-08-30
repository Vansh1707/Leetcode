class Solution {
    public void rotate(int[][] arr) {
        int n=arr.length;
        
        //transpose
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        
        //reverse
        for(int i=0;i<n;i++){
           int lidx=0,ridx=n-1;
          while(lidx<ridx){
              int temp=arr[i][lidx];
              arr[i][lidx]=arr[i][ridx];
              arr[i][ridx]=temp;
              lidx++;
              ridx--;
              
          } 
           
       }   
        
    }
}