class Solution {   
  class pair{
      char c; int val;
      pair(int val,char c){
          this.c=c;
          this.val=val;
      }
  } 
    public String frequencySort(String s) {
        int []freq=new int[128];
        for(int i=0;i<s.length();i++) {freq[(int)s.charAt(i)]++;}      
        List<pair> q=new ArrayList<>();        
        for(int i=0;i<128;i++){
            if(freq[i]>0){
                q.add(new pair(freq[i],(char)i));
            }
        }
        
        Collections.sort(q,(x,y)->{
            return -(x.val-y.val);
        });      
       
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<q.size();i++){
            int n=q.get(i).val;
            for(int j=0;j<n;j++)sb.append(q.get(i).c);
        }
        return sb.toString();
        }
 
}