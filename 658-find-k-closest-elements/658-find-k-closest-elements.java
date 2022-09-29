class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int si=0,ei=arr.length-1;
        int mid=0;
        while(si<=ei){
            mid=(si+ei)/2;
            if(arr[mid]==x){
                break;
            }else if(arr[mid]<x){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        
        int l=Math.max(0,mid-1),r=l+1;
        ArrayList<Integer>list=new ArrayList<>();
        
        while(l>=0 && r<arr.length && k>0){
            if(Math.abs(arr[l]-x)<=Math.abs(arr[r]-x)){
                list.add(arr[l]);
                l--;
            }else{
                list.add(arr[r]);
                r++;
            }
            k--;
        }
        while(k>0 && l>=0){
            list.add(arr[l]);
            l--;
            k--;
        }
        while(k>0 && r<arr.length){
            list.add(arr[r]);
            r++;
            k--;
        }
        Collections.sort(list);
        return list;
    }
}