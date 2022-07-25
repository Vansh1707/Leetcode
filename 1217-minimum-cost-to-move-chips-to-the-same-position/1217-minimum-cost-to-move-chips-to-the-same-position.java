class Solution {
    public int minCostToMoveChips(int[] arr) {
        int costodd=0,costeven=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                costodd++;
            }else{
                costeven++;
            }
        }
        return Math.min(costeven,costodd);
        
    }
}