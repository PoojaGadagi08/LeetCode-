Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.

 

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.
Example 2:

Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 

Constraints:

1 <= nums1.length, nums2.length <= 105
1 <= nums1[i], nums2[j] <= 109
Both nums1 and nums2 are sorted in non-decreasing order.


  // class Solution {
//     public int getCommon(int[] nums1, int[] nums2) {
//         HashMap<Integer, Integer> mp = new HashMap<>();
//         for (int num : nums1) {
//             mp.put(num, mp.getOrDefault(num, 0) + 1);
//         }
//         for (int num : nums2) {
//             if (mp.containsKey(num) && mp.get(num) > 0) {
//                 return num;
//             }
//         }
//         return -1;
//     }
// }



// class Solution {
//     public int getCommon(int[] nums1, int[] nums2) {
//         HashSet<Integer> set = new HashSet<>();
//         for (int num : nums1) {
//             set.add(num);
//         }
//         for (int num : nums2) {
//             if (set.contains(num)) {
//                 return num;
//             }
//         }
//         return -1;
//     }
// }



public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (search(nums2, nums1[i])) {
                return nums1[i];
            }
        }
        return -1;
    }
}


// class Solution {
//     public int getCommon(int[] nums1, int[] nums2) {
//         int i = 0, j = 0;

//         while (i < nums1.length && j < nums2.length) {
//             if (nums1[i] == nums2[j]) {
//                 return nums1[i];
//             } else if (nums1[i] < nums2[j]) {
//                 i++;
//             } else {
//                 j++;
//             }
//         }

//         return -1;
//     }
// }
