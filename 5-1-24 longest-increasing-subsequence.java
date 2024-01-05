Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?




  public int lengthOfLIS(int[] nums) {
    if(nums==null || nums.length==0){
        return 0;
    }
    int[] dp = new int[nums.length];
    int max = 1;
    for(int index=0; index<nums.length;index++){
        dp[index]=1;
        for(int dpIndex=0; dpIndex<index; dpIndex++){
            if(nums[dpIndex]<nums[index]){
                dp[index]=Math.max(dp[index],dp[dpIndex]+1);
                max=Math.max(dp[index],max);
            }
        }
    }
    return max;
}
