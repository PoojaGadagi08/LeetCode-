// class Solution {
//     public int numberOfSubarrays(int[] nums, int s) {
//         int cnt = 0;
//         int n = nums.length;
        
//         for (int i = 0; i < n; i++) {
//             int oddCount = 0;
            
//             for (int j = i; j < n; j++) {
//                 if (nums[j] % 2 != 0) {
//                     oddCount++;
//                 }
                
//                 if (oddCount == s) {
//                     cnt++;
//                 }
//             }
//         }
        
//         return cnt;
//     }
// }



class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int oddcount=0;
        int res=0;
        int i=0;
        int count=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]%2==1){
                oddcount++;
                count=0;
            }
            while(oddcount==k){
                if(nums[i++]%2==1) oddcount--;
                count++;
            }
            res+=count;
        }
        return res;
    }
}

