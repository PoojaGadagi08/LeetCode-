class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> h =new HashSet<>();
        for(int n : nums){
            if(n<0)
            h.add(n);
        }
        int ans=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                if(h.contains(-nums[i]))
                ans=Math.max(nums[i], ans);
            }
        }

        return ans;
    }
}

// class Solution {
//     public int findMaxK(int[] nums) {
//         Arrays.sort(nums);
//         int i=0;int j=nums.length-1;
//         while(i<j){
//             if(Math.abs(nums[i])==nums[j])
//             return nums[j];
//             else if(Math.abs(nums[i])>nums[j])
//             i++;
//             else j--;
//         }
//         return -1;
//     }
// }
