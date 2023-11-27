The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). The possible movements of chess knight are shown in this diagaram:

A chess knight can move as indicated in the chess diagram below:


We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).


Given an integer n, return how many distinct phone numbers of length n we can dial.

You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.

As the answer may be very large, return the answer modulo 109 + 7.

 

Example 1:

Input: n = 1
Output: 10
Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
Example 2:

Input: n = 2
Output: 20
Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
Example 3:

Input: n = 3131
Output: 136006598
Explanation: Please take care of the mod.
 

Constraints:

1 <= n <= 5000



  class Solution {
    public static final int MOD = 1000000007;
    public int knightDialer(int N) {
        int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int cnt = 0;
        Integer[][] memo = new Integer[N+1][10];
        for (int i = 0; i <= 9; i++)
            cnt = (cnt + helper(N-1, i, graph, memo)) % MOD;
        return cnt;
    }
    private int helper(int N, int cur, int[][] graph, Integer[][] memo) {
        if (N == 0)
            return 1;
        if (memo[N][cur] != null)
            return memo[N][cur];
        int cnt = 0;
        for (int nei : graph[cur])
            cnt = (cnt + helper(N-1, nei, graph, memo)) % MOD;
        memo[N][cur] = cnt;
        return cnt;
    }}
