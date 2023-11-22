Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.

 

Example 1:


Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]
Example 2:


Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i].length <= 105
1 <= sum(nums[i].length) <= 105
1 <= nums[i][j] <= 105





  class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> positions = new ArrayList();
        for (int r = 0; r < nums.size(); r++) {
            for (int c = 0; c < nums.get(r).size(); c++) {
                positions.add(new int[]{r, c});
            }
        }
        Collections.sort(positions, (a, b) -> (a[0] + a[1] == b[0] + b[1] ? b[0] - a[0] : (a[0] + a[1] - b[0] - b[1])));
        int[] res = new int[positions.size()];
        int i = 0;
        for (int[] pos : positions)
            res[i++] = nums.get(pos[0]).get(pos[1]);
        return res;
    }
}
