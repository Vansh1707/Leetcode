class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int n = bank.length;
        boolean[] isVisited = new boolean[n];
        int stepCount = 0;        
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String gene = q.poll();
                // System.out.println("gene = "+gene +" end ="+end);
                if(gene.equals(end)){
                    return stepCount;
                }
                for(int i =0;i<n;i++){
                    if(isVisited[i]) continue;
                    if(isValidMutation(gene,bank[i])){
                        q.offer(bank[i]);
                        isVisited[i] = true;
                    }
                }
            }
            // System.out.println(q.toString());
            stepCount++;
        }
        return -1;
    }
    
    public boolean isValidMutation(String g1 , String g2){
        int count = 0;
        for(int i =0;i<8;i++){
            if(g1.charAt(i) != g2.charAt(i)) count++;
        }
        
        return count == 1;
    }
}