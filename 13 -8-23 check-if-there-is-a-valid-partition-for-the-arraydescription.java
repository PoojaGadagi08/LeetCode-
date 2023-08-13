You are given a 0-indexed integer array nums. You have to partition the array into one or more contiguous subarrays.

We call a partition of the array valid if each of the obtained subarrays satisfies one of the following conditions:

The subarray consists of exactly 2 equal elements. For example, the subarray [2,2] is good.
The subarray consists of exactly 3 equal elements. For example, the subarray [4,4,4] is good.
The subarray consists of exactly 3 consecutive increasing elements, that is, the difference between adjacent elements is 1. For example, the subarray [3,4,5] is good, but the subarray [1,3,5] is not.
Return true if the array has at least one valid partition. Otherwise, return false.

 

Example 1:

Input: nums = [4,4,4,5,6]
Output: true
Explanation: The array can be partitioned into the subarrays [4,4] and [4,5,6].
This partition is valid, so we return true.
Example 2:

Input: nums = [1,1,1,2]
Output: false
Explanation: There is no valid partition for this array.
 

Constraints:

2 <= nums.length <= 105
1 <= nums[i] <= 106




  class Solution {
        public boolean validPartition(int[] A) {
        int n = A.length, dp[] = new int[] {0, 0, 0, 1};
        for (int i = 0; i < n; ++i) {
            dp[i % 4] = 0;
            if (i - 1 >= 0 && A[i] == A[i - 1])
                dp[i % 4] |= dp[(i + 2) % 4];
            if (i - 2 >= 0 && A[i] == A[i - 1] && A[i - 1] == A[i - 2])
                dp[i % 4] |= dp[(i + 1) % 4];
            if (i - 2 >= 0 && A[i] - 1 == A[i - 1] && A[i - 1] == A[i - 2] + 1)
                dp[i % 4] |= dp[(i + 1) % 4];
        }
        return dp[(n - 1) % 4] > 0;
    }
}
