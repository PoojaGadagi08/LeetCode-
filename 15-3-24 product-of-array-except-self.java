Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


  // class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] leftProducts = new int[n];
//         int[] rightProducts = new int[n];
//         int[] result = new int[n];
        
//         leftProducts[0] = 1;
//         for (int i = 1; i < n; i++) {
//             leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
//         }
        
//         rightProducts[n - 1] = 1;
//         for (int i = n - 2; i >= 0; i--) {
//             rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
//         }
        
//         for (int i = 0; i < n; i++) {
//             result[i] = leftProducts[i] * rightProducts[i];
//         }
        
//         return result;
//     }
// }




class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate left products and store them in the result array
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Calculate right products and accumulate them in a variable rightProduct
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }
}
