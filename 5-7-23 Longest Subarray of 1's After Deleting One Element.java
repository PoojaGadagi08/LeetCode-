Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.




  class Solution {
    public int longestSubarray(int[] nums) {
        int num_of_zeros_allowed = 1;
        int left_ptr = 0;
        int right_ptr = 0;

        for (right_ptr = 0; right_ptr < nums.length; right_ptr++) {
            boolean is_zero = nums[right_ptr] == 0;
            num_of_zeros_allowed -= is_zero ? 1 : 0;

            if (num_of_zeros_allowed < 0) {
                boolean is_zero_left = nums[left_ptr] == 0;
                num_of_zeros_allowed += is_zero_left ? 1 : 0;
                left_ptr += 1;
            }
        }

        return right_ptr - left_ptr;
    }
}
