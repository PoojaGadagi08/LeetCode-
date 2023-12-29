You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.

You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

 

Example 1:


Input: jobDifficulty = [6,5,4,3,2,1], d = 2
Output: 7
Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
Second day you can finish the last job, total difficulty = 1.
The difficulty of the schedule = 6 + 1 = 7 
Example 2:

Input: jobDifficulty = [9,9,9], d = 4
Output: -1
Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
Example 3:

Input: jobDifficulty = [1,1,1], d = 3
Output: 3
Explanation: The schedule is one job per day. total difficulty will be 3.
 

Constraints:

1 <= jobDifficulty.length <= 300
0 <= jobDifficulty[i] <= 1000
1 <= d <= 10




  class Solution {
        public int minDifficulty(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;

        int[][] memo = new int[N][D + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return dfs(D, 0, jobDifficulty, memo);
    }

    private int dfs(int d, int len, int[] jobDifficulty, int[][] memo){
        final int N = jobDifficulty.length;
        if(d == 0 && len == N) return 0;
        if(d == 0 || len == N) return Integer.MAX_VALUE;
        if(memo[len][d] != -1) return memo[len][d];

        int curMax = jobDifficulty[len];
        int min = Integer.MAX_VALUE;
        for(int schedule = len; schedule < N; ++schedule){
            curMax = Math.max(curMax, jobDifficulty[schedule]);
            int temp = dfs(d - 1, schedule + 1, jobDifficulty, memo);
            if(temp != Integer.MAX_VALUE)
                min = Math.min(min, temp + curMax);
        }

        return memo[len][d] = min;
    }
}
