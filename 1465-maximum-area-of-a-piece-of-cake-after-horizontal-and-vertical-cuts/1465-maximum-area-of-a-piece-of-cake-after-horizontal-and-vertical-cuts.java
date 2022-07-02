class Solution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        //int mod = (int) 1e9 + 7;
        Arrays.sort(hc);
        Arrays.sort(vc);        
        
        
        int mhc=hc[0]-0,mvc=vc[0]-0;
        
        for(int i=1;i<hc.length;i++){
            mhc=Math.max(mhc,hc[i]-hc[i-1]);
        }
        mhc=Math.max(mhc,h-hc[hc.length-1]);
        
        for(int i=1;i<vc.length;i++){
            mvc=Math.max(mvc,vc[i]-vc[i-1]);
        }        
        mvc=Math.max(mvc,w-vc[vc.length-1]);
        
        return (int)(((long)mhc*mvc)%1000000007);
    }
}