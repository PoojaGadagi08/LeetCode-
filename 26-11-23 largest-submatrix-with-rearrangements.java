You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.

Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.

 

Example 1:


Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
Output: 4
Explanation: You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 4.
Example 2:


Input: matrix = [[1,0,1,0,1]]
Output: 3
Explanation: You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 3.
Example 3:

Input: matrix = [[1,1,0],[1,0,1]]
Output: 2
Explanation: Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m * n <= 105
matrix[i][j] is either 0 or 1.




  /*  build the matrix to:
				 [ [1, 0, 1, 1]                                      [ [1, 0, 1, 1]  
				   [1, 0, 1, 0]                   -->                  [2, 0, 2, 0] 
				   [0, 1, 1, 0] ]                                      [0, 1, 3, 0] ]
*/
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < matrix.length; i++){
            Arrays.sort(matrix[i]);                                      // sort the Array : e.g. from [2,3,0, 1, 2,3] to [0,1,2,2,3,3]
            for(int j = 1; j <= matrix[0].length; j++){
                count = Math.max(count, j * matrix[i][matrix[0].length - j]);            // cauculate the max
            }
        }
        
        return count;
    }
}
