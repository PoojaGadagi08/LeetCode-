Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109







  // class Solution {
//     public int[] searchRange(int[] nums, int x) {
//         int ans[]=new int [2];
//         int f=-1;
//         int l=-1;

//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==x){
//                 if(f==-1){
//                     f=i;
//                 }
//                 l=i;
//             }
//         }
//         ans[0]=f;
//         ans[1]=l;

//         return ans;
//     }
// }



class Solution {
    public int first(int arr[],int n,int x){
        int l=0;
        int h=n-1;
        int f=-1;

        while(l<=h){
            int m=(l+h)/2;

            if(arr[m]==x){
                f=m;
                h=m-1;
            }
            else if(arr[m]<x){
                l=m+1;
            }
            else 
            h=m-1;
        }
        return f;
    }
    public int last(int arr[],int n,int x){
        int l=0;
        int h=n-1;
        int la=-1;

        while(l<=h){
            int m=(l+h)/2;

            if(arr[m]==x){
                la=m;
                l=m+1;
            }
            else if(arr[m]<x){
                l=m+1;
            }
            else 
            h=m-1;
        }
        return la;
    }
    public int[] searchRange(int[] nums, int x) {
      int ans[]=new int [2];
      ans[0]=first(nums, nums.length,x);
      ans[1]=last(nums, nums.length,x);

          return ans;

    }
}
