You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999




  // class Solution {
//     int dp[]=new int[1001];

//     public int mincost(int i, int arr[]){
//         if(i>=arr.length)
//         return 0;

//         if(dp[i]==-1) return dp[i];
//         int op1=mincost(i+1, arr);
//         int op2=mincost(i+2, arr);

//         return dp[i]=Math.min(op1,op2)+arr[i];
       
//     }
//     public int minCostClimbingStairs(int[] arr) {
//         return Math.min(mincost(0,arr),mincost(1,arr));
//     }
// }


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        
        return Math.min(rec(cost, 0, memo), rec(cost, 1, memo));
    }
    
    int rec(int[] cost, int index, int[] memo) {
       if(index >= cost.length)
           return 0;
        
        if(memo[index] == 0) {
            memo[index] = Math.min(rec(cost, index + 1, memo), rec(cost, index + 2, memo));
        }
        
        return cost[index] + memo[index];
    }
}
