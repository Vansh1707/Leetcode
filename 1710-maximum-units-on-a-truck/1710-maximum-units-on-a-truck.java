class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int ans=0;
        int i=0;
        
        while(i<boxTypes.length && truckSize>0){
            int min=Math.min(truckSize,boxTypes[i][0]);
            ans=ans+ min*boxTypes[i][1];
            truckSize-=boxTypes[i][0];
            i++;
        }
        return ans;
    }
}