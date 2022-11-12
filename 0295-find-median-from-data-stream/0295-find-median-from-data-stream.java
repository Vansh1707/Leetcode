class MedianFinder {
    PriorityQueue<Integer>minpq;
    PriorityQueue<Integer>maxpq;

    /** initialize your data structure here. */
    public MedianFinder() {
        minpq=new PriorityQueue<>();
        maxpq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
    }
    
    public void addNum(int num) {
        if(maxpq.size()==0 || num<maxpq.peek())
            maxpq.add(num);
        else
            minpq.add(num);
        
         if(maxpq.size()-minpq.size()==-1)
            maxpq.add(minpq.remove());
        
        if(maxpq.size()-minpq.size()==2)
            minpq.add(maxpq.remove());
        
    }
    
    public double findMedian() {
        if(maxpq.size()==minpq.size())
            return (maxpq.peek()+minpq.peek())/2.0;
        else
            return maxpq.peek()*1.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */