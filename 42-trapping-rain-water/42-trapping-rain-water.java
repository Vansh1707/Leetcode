class Solution {
    public int trap(int[] height) {
        LinkedList<Integer>st=new LinkedList<>();
        int curr=0,water=0;
        
        while(curr<height.length){
            while(st.size()>0 &&height[curr]>height[st.getFirst()]){
                int top=st.removeFirst();
                if(st.size()==0)break;
                int diff=curr-st.getFirst()-1;
                int fill=diff*(Math.min(height[curr],height[st.getFirst()])-height[top]);
                water+=fill;
            }
            st.addFirst(curr++);
        }
        return water;
    }
}