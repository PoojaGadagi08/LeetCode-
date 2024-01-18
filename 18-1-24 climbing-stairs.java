You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45


  class Solution {
    public int climbStairs(int n) {
        // Create an array to store the results of subproblems
        int memo[] = new int[n+1];
        // Fill the array with -1 to indicate that the corresponding subproblem hasn't been solved yet
        Arrays.fill(memo, -1);

        // Call the helper function to solve the problem
        return helper(n, memo);
    }

    public int helper(int n, int memo[]){
        // Base cases: if there are 0 or 1 stairs, there's only one way to climb them
        if(n == 0 || n == 1){
            return 1;
        }

        // If we've already solved this subproblem, return the result from the memoization array
        if(memo[n] != -1){
            return memo[n];
        }

        // Solve the subproblem recursively by calling the helper function on n-1 and n-2 stairs,
        // and add the results together to get the final answer
        memo[n] =  helper(n-1, memo) + helper(n-2, memo);
        return memo[n];
    }
}
