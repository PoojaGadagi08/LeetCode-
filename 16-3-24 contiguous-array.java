Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.


  class Solution {
    public int findMaxLength(int[] nums) {
                Map<Integer, Integer> myMap = new HashMap<>();
        int sum = 0;
        int longestSubarray = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i] == 0 ? -1 : 1;

            if (sum == 0) {
                if (longestSubarray < i + 1)
                    longestSubarray = i + 1;
            } else if (myMap.containsKey(sum)) {
                if (longestSubarray < i - myMap.get(sum))
                    longestSubarray = i - myMap.get(sum);
            } else {
                myMap.put(sum, i);
            }
        }

        return longestSubarray;

    }
}
