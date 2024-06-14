class Solution {
    // public int minIncrementForUnique(int[] nums) {
    //     int cnt=0;
    //     Arrays.sort(nums);
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]<=nums[i-1]){
    //             int val=nums[i-1]-nums[i]+1;
    //             cnt+=(val);
    //             nums[i]=val;
    //         }
    //     }
    //     return cnt;
    // }

    public int minIncrementForUnique(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                int val = nums[i-1] + 1;
                cnt += (val - nums[i]);
                nums[i] = val;
            }
        }
        return cnt;
    }

}
