class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        int sum=0;
        for(int ele:target){
            pq.add(ele);
            sum+=ele;
        }
        
        while(pq.peek()!=1){
            int top=pq.remove();
            sum=sum-top;
            if(sum<=0 || sum>=top){
                return false;
            }
            //top=top-sum;
            top=top%sum;
            sum=sum+top;
            pq.add(top>0?top:sum);//arr cant be fill with 0
        }
        return true;
    }
}