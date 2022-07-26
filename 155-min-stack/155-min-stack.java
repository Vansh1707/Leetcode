class MinStack {
    Stack<Integer>alldata=new Stack<>();
    Stack<Integer>minst=new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        alldata.push(val);
        
        if(minst.size()==0||val<=minst.peek())
            minst.push(val);
    }
    
    public void pop() {
        if(alldata.size()==0)return;
        else{
            int val=alldata.pop();
            if(val==minst.peek())
                minst.pop();
        }
    }
    
    public int top() {
        if(alldata.size()==0)return -1;
        return alldata.peek();
    }
    
    public int getMin() {
        if(alldata.size()==0)return -1;
        return minst.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */