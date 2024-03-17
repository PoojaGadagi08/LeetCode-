You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105




  class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList();
            for (int[] in : intervals) {
                if (in[1] < newInterval[0]) {
                    list.add(in);
                } else if (newInterval[1] < in[0]) {
                    list.add(newInterval);
                    newInterval = in;
                } else {
                    newInterval[0] = Math.min(newInterval[0], in[0]);
                    newInterval[1] = Math.max(newInterval[1], in[1]);
                }
            }
            list.add(newInterval);

            return list.toArray(new int[list.size()][]);
        }
    }

    // // 2. Merge Interval Approach, TC - O(nlogn)
    // class Solution2 {
    //     public int[][] insert(int[][] intervals, int[] newInterval) {
    //         int[][] in = new int[intervals.length + 1][2];
    //         for (int i = 0; i < intervals.length; i++)
    //             in[i] = intervals[i];
    //         in[intervals.length] = newInterval;
    //         return merge(in);
    //     }

    //     public int[][] merge(int[][] intervals) {
    //         if (intervals.length == 0)
    //             return intervals;

    //         List<int[]> list = new ArrayList();
    //         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    //         int[] in = intervals[0];
    //         int i = 1;
    //         while (i < intervals.length) {
    //             if (intervals[i][0] > in[1]) {
    //                 list.add(in);
    //                 in = intervals[i];
    //             } else {
    //                 in[1] = Math.max(intervals[i][1], in[1]);
    //             }
    //             i++;
    //         }
    //         list.add(in);

    //         return list.toArray(new int[list.size()][]);
    //     }
    // }
