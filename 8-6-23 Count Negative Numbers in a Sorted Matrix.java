Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
  
  
  class Solution {
   public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
		//start position in the left bottom (but it can be right top)
        int i = rows - 1;
        int j = 0;
        
        int result = 0;
        while(i>=0 && j<columns) {
            if(grid[i][j]<0) {
				i--;                         //switch to the upper row
				result += columns - j;       //add to result count of all numbers from current ot the end of row (because of sorted row)
            } else {
                j++;                         //switch to the right column
            }
        }
        
        return result;
    }
}
