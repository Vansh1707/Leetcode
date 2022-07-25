class Solution {
    public int firstIndex(int arr[],int tar){
        int si=0,ei=arr.length-1;
        int fi=-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==tar){
                fi=mid;
                ei=mid-1;//better fi
            }else if(arr[mid]<tar){
                si=mid+1;
            }else{
                ei=mid-1;
            }                           
        }
        return fi;
        
    }
    public int lastIndex(int arr[],int tar){
        int si=0,ei=arr.length-1;
        int li=-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==tar){
                li=mid;
                si=mid+1;//better fi
            }else if(arr[mid]<tar){
                si=mid+1;
            }else{
                ei=mid-1;
            }                           
        }
        return li;
        

    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstIndex(nums,target),lastIndex(nums,target)};
    }
}