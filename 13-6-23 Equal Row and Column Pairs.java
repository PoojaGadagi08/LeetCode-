
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]










class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowCounts = new HashMap<>();
        int count = 0;

        for (int[] row : grid) {
            String key = Arrays.toString(row);
            rowCounts.put(key, rowCounts.getOrDefault(key, 0) + 1);
        }

        for (int col = 0; col < grid[0].length; col++) {
            int[] column = new int[grid.length];
            for (int row = 0; row < grid.length; row++) {
                column[row] = grid[row][col];
            }
            String key = Arrays.toString(column);
            count += rowCounts.getOrDefault(key, 0);
        }

        return count;
    }
}
