class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        String[]arr=s.split(" ");
        
        for(int i=0;i<arr.length;i++){
            StringBuilder p=new StringBuilder(arr[i]);
            p.reverse();
            
            if(i!=arr.length-1)
                sb.append(p+" ");
            else
                sb.append(p);
        }
        return sb.toString();
    }
}