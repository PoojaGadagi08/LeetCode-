You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18




  class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, ans = 0;
        HashSet<Integer> mst = new HashSet<>();
        mst.add(0);
        int[] dist = new int[n];
        for(int i = 1; i < n; i++) dist[i] = findDist(points, 0, i);
        while(mst.size() != n) {
            // Find the node that has shortest distance
            int next = -1;
            for(int i = 0; i < n; i++) {
                if(mst.contains(i)) continue;
                if(next == -1 || dist[next] > dist[i]) next = i;
            }
            // Put the node into the Minning Spanning Tree
            mst.add(next);
            ans += dist[next];
            // Update distance array
            for(int i = 0; i < n; i++) {
                if(!mst.contains(i)) {
                    dist[i] = Math.min(dist[i], findDist(points, i, next));
                }
            }
        }
        return ans;
    }
    private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}
