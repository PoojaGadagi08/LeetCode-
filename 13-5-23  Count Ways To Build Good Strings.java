// Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:

// Append the character '0' zero times.
// Append the character '1' one times.
// This can be performed any number of times.

// A good string is a string constructed by the above process having a length between low and high (inclusive).

// Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[]=new int[high+1];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=low;i<=high;i++){
            ans=((ans%1000000007)+(f(i,dp,zero,one)%1000000007))%1000000007;
        }
        return ans;
    }
    public int f(int ind,int[] dp,int zero,int one){
        if(ind==0)
            return 1;
        if(ind<0)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int forzero=f(ind-zero,dp,zero,one);
        int forone=f(ind-one,dp,zero,one);
        return dp[ind]=(forzero+forone)%1000000007;
    }
}
