Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109





  
// i<j<k
//nums[i]<nums[k]<nums[j]
// TC : O(N)  SC : O(N)

class Solution {
    public boolean find132pattern(int[] nums) {
         int numsk = Integer.MIN_VALUE;
         Stack<Integer> st = new Stack();
         for(int idx = nums.length-1;idx>=0;idx--){
             if(nums[idx]<numsk) return true;  // nums[i] < nums[k] , and nums[j] (potential) was chosen in previous iteration so given condition reached 
              while(!st.isEmpty()&&nums[idx]>st.peek()){//nums[idx] = nums[j] (potential) 
                 numsk = st.pop(); // always bigger than previous numsk 
             }
             st.push(nums[idx]);
         }
        return false;
    }
}
