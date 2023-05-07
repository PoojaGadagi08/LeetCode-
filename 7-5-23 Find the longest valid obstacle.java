// You want to build some obstacle courses. You are given a 0-indexed integer array obstacles of length n, where obstacles[i] describes the height of the ith obstacle.

// For every index i between 0 and n - 1 (inclusive), find the length of the longest obstacle course in obstacles such that:

// You choose any number of obstacles between 0 and i inclusive.
// You must include the ith obstacle in the course.
// You must put the chosen obstacles in the same order as they appear in obstacles.
// Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it.
// Return an array ans of length n, where ans[i] is the length of the longest obstacle course for index i as described above.


class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int length = 0;
        int[] result = new int[n];
        int[] increasingSubseq = new int[n];
        for (int i = 0; i < n; ++i) {
            int left = 0, right = length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (increasingSubseq[mid] <= obstacles[i])
                    left = mid + 1;
                else
                    right = mid;
            }
            result[i] = left + 1;
            if (length == left)
                length++;
            increasingSubseq[left] = obstacles[i];
        }
        return result;
    }
}
