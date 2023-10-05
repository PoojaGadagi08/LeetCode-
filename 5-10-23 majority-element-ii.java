Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space?




  // class Solution {
//     public List<Integer> majorityElement(int[] v) {
//            int n = v.length; //size of the array
//         List<Integer> ls = new ArrayList<>(); // list of answers

//         //declaring a map:
//         HashMap<Integer, Integer> mpp = new HashMap<>();

//         // least occurrence of the majority element:
//         int mini = (int)(n / 3) + 1;

//         //storing the elements with its occurnce:
//         for (int i = 0; i < n; i++) {
//             int value = mpp.getOrDefault(v[i], 0);
//             mpp.put(v[i], value + 1);

//             //checking if v[i] is
//             // the majority element:
//             if (mpp.get(v[i]) == mini) {
//                 ls.add(v[i]);
//             }
//             if (ls.size() == 2) break;
//         }

//         return ls;
//     }
// }



class Solution {
    public List<Integer> majorityElement(int[] v) {
        int n = v.length; //size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != v[i]) {
                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && el1 != v[i]) {
                cnt2 = 1;
                el2 = v[i];
            } else if (v[i] == el1) cnt1++;
            else if (v[i] == el2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el1) cnt1++;
            if (v[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return ls;
        
    }
}
