class Solution {
    public boolean containsDuplicate(int[] arr) {
        HashMap<Integer,Integer>fmap=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            fmap.put(arr[i],fmap.getOrDefault(arr[i],0)+1);
        }
        
        for(Integer key:fmap.keySet()){
            if(fmap.get(key)>1){
                return true;
            }
        }
        return false;
    }
}