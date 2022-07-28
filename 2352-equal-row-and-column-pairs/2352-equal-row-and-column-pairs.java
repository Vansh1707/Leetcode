class Solution {
	public int equalPairs(int[][] grid) {
		int ans=0;
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid.length;j++)
			{
				if(grid[i][0]==grid[0][j])
				{
					if(check(grid,i,j)) ans++;
				}
			}
		}
		return ans;
	}
	boolean check(int[][] grid, int i, int j){
		for(int k=0;k<grid.length;k++)
		{
			if(grid[i][k]!=grid[k][j])
				return false;
		}
		return true;
	}
}