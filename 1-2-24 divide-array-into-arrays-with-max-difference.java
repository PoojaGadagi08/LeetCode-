You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

 

Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
Output: [[1,1,3],[3,4,5],[7,8,9]]
Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
The difference between any two elements in each array is less than or equal to 2.
Note that the order of elements is not important.
Example 2:

Input: nums = [1,3,3,2,7,3], k = 3
Output: []
Explanation: It is not possible to divide the array satisfying all the conditions.
 

Constraints:

n == nums.length
1 <= n <= 105
n is a multiple of 3.
1 <= nums[i] <= 105
1 <= k <= 105



  class Solution {
    public int[][] divideArray(int[] nums, int k) {
//            Arrays.sort(nums);

//     int n = nums.length;
//     int[][] result = new int[n / 3][3];
//     int resultIndex = 0;

//     int start = 0;

//     while (start < n) {
//         int end = start + 2;
//         if (end >= n) {
//             // If there are less than 3 elements remaining, it's not possible
//             return new int[0][0];
//         }

//         if (nums[end] - nums[start] <= k) {
//             // Add the subarray to the result
//             for (int i = start, j = 0; i <= end; i++, j++) {
//                 result[resultIndex][j] = nums[i];
//             }
//             resultIndex++;

//             // Move to the next starting point
//             start = end + 1;
//         } else {
//             // Move to the next starting point
//             start++;
//         }
//     }

//     return result;
        
        
        
        
        
        
        
        int n = nums.length;
        Arrays.sort(nums);

        int[][] result = new int[n / 3][3];
        int resultIndex = 0;

        for (int i = 0; i < n; i += 3) {
            if (i + 2 < n && nums[i + 2] - nums[i] <= k) {
                result[resultIndex++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            } else {
                return new int[0][0];
            }
        }

        return result;

    }
}
