Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

Return the maximum product you can get.

 

Example 1:

Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 

Constraints:

2 <= n <= 58



  class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,n,dp);
    }
    
    private int helper(int n,int q,int[] dp){
        if(n == 1)return 1;
        if(dp[n] != -1)return dp[n];
        
        int ans = (n == q)? 0 : n;
        for(int i = 1; i < n; i++){
            
            int c = helper(i,n,dp) * helper(n-i,n,dp);
            ans = Math.max(c,ans);
        }
        dp[n] = ans;
        return ans;
    }
    
}
