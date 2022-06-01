class Solution {
    //cooldown for 1 day stated in ques but this we will do for n cooldown days
    
    public int maxProfit(int[] prices) {
        int dpi0=0;
        int dpi0prev=0;
        int dpi1=-(int)1e9;
        
        for(int i=0;i<prices.length;i++){
            int dpi_10=dpi0;
            
            dpi0=Math.max(dpi0,dpi1+prices[i]);
            dpi1=Math.max(dpi1,dpi0prev-prices[i]);
            
            dpi0prev=dpi_10;
        }
        return dpi0;
    }
}