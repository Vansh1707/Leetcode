class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int i=0;
        int j=arr.length-1;
        
        while(i<=j){
            
            if(arr[i]%2==0){
                i++;
            }else if(arr[j]%2!=0){
                j--;
            }else{
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        return arr;
        
    }
    
    public void swap(int a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}