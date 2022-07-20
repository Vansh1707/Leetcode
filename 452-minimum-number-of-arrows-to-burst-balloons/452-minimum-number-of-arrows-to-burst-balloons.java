class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
    
	//atleast we require an arrow to busrt all the balloons
    int arrows=1, ep=points[0][1];
    
	
	
    for(int i=0;i<points.length;i++){
        
		// if any balloon is placed after ending of previous balloon so to burst that balloon we need more arrow
		// we have sorted the array which is making sure that every ballon which will come before me atleast they gonna end on present balloon or after ...... 
        if(points[i][0]>ep){
            arrows++;
            ep=points[i][1];
        }
    }
    
    return arrows;
    }
}