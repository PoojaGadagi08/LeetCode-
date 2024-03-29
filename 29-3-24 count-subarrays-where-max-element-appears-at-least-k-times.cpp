class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        long long  n = nums.size(); 
        long long  m = *max_element(nums.begin(), nums.end()); 
        long long i = 0, j = 0, cnt = 0, ans = 0; 
        while (j < n) { 
            if (nums[j] == m) { 
                cnt++; 
            } 
            if (cnt >= k) { 
                while (cnt >= k) { 
                    ans += n - j; 
                    if (nums[i] == m) { 
                        cnt--; 
                    } 
                    i++; 
                } 
            } 
            j++; 
        } 
        return ans; 
    }
};

