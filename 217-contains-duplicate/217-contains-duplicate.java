class Solution {
    public boolean containsDuplicate(int[] arr) {
        HashSet<Integer>set=new HashSet<>();
        
        for(int ele:arr){
            if(set.contains(ele))return true;
            else set.add(ele);
        }
        return false;
    }
}