You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.

You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.

Return the maximum sum of values that you can receive by attending events.

 

Example 1:



Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
Output: 7
Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.
Example 2:



Input: events = [[1,2,4],[3,4,3],[2,3,10]], k = 2
Output: 10
Explanation: Choose event 2 for a total value of 10.
Notice that you cannot attend any other event as they overlap, and that you do not have to attend k events.
Example 3:



Input: events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3
Output: 9
Explanation: Although the events do not overlap, you can only attend 3 events. Pick the highest valued three.






  //if you think this post is useful please upvote it
class Solution 
{
    public int fun(int i,int[][] nums,int prev,int max,int[][] dp)
    {
        if(i==nums.length || max==0)  return 0;

        if(dp[prev+1][max]!=-1)  return dp[prev+1][max];

        int take=0;
        int not=0;
        if(prev==-1 || nums[prev][1]<nums[i][0])
        {
            take=nums[i][2]+fun(i+1,nums,i,max-1,dp);
        }
        not=0+fun(i+1,nums,prev,max,dp);
        return dp[prev+1][max]=Math.max(take,not);
    }
    public int maxValue(int[][] events, int k) 
    {
        Arrays.sort(events,(a,b) -> 
        {
            if(a[0]==b[0])  return a[1]-b[1];
            return a[0]-b[0];
        });
       int[][] dp=new int[events.length+1][k+1];
       for(int[] j : dp) Arrays.fill(j,-1);
        return fun(0,events,-1,k,dp);
    }
}
