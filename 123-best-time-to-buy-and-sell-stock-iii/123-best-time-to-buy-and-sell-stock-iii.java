class Solution {
    public int maxProfit(int[] prices) {
        int dpi20=0;
        int dpi21=-(int)1e9;
        int dpi10=0;
        int dpi11=-(int)1e9;
        
        for(int i=0;i<prices.length;i++){
            dpi20=Math.max(dpi20,dpi21+prices[i]);
            dpi21=Math.max(dpi21,dpi10-prices[i]);
            dpi10=Math.max(dpi10,dpi11+prices[i]);
            dpi11=Math.max(dpi11,0-prices[i]);
        }
        return Math.max(dpi10,dpi20);
    }
}