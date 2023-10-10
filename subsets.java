Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.




  class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        ArrayList<Integer> subSet=new ArrayList<>();
        helper(nums, 0, subSet, ans);
        return ans;
    }

public void helper(int nums[], int i, ArrayList<Integer> subSet,  List<List<Integer>> ans ){
        if(i==nums.length){
            ans.add(new ArrayList<>(subSet));
            return ;
        }

        //Pick
        subSet.add(nums[i]);
        helper(nums, i+1, subSet, ans);

        //Not Pick
        subSet.remove(subSet.size()-1);
        helper(nums, i+1, subSet, ans);
    }
}
