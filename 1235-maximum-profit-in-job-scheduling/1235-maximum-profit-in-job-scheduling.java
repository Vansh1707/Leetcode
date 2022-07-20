class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=profit.length;
        int[][]job=new int[n][3];
        for(int i=0;i<n;i++){
            job[i][0]=startTime[i];
            job[i][1]=endTime[i];
            job[i][2]=profit[i];
        }
        Arrays.sort(job,(a,b)->a[1]-b[1]);
        
        TreeMap<Integer,Integer>dp=new TreeMap<>();//{endTime,max profit}
        dp.put(0,0);
        
        for(int[]j:job){
            //curr profit= profit of this job+ max profit before this job
            int currprofit=j[2]+ dp.floorEntry(j[0]).getValue();
            if(currprofit>dp.lastEntry().getValue()){
                dp.put(j[1],currprofit);
            }
        }
        return dp.lastEntry().getValue();
        
    }
}