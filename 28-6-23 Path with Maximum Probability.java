You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a
  probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

 

Example 1:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
Example 2:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000
Example 3:



Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.






  class Solution {
   public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
         // create adjacency list
        List<double[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(new double[] {edges[i][1],succProb[i]});
            adjList[edges[i][1]].add(new double[] {edges[i][0],succProb[i]});
        }
        // adjacency list created



        // probability to reach any node : store in prob array at corresponding position
        double[] prob = new double[n];
        prob[start] = 1.0;  // start to start prabability = 1.0

        // for not coming to already visited number mark that visited
        boolean[] vis = new boolean[n];



        // simple priorityQueue
        Queue <double[]> queue = new PriorityQueue<>(Collections.reverseOrder((a, b) -> Double.compare(a[1],b[1])));
        queue.add(new double[]{start,1.0});


        while (!queue.isEmpty()){
            double[] cur = queue.poll();
            int curNode = (int) cur[0];
            if(curNode == end) return cur[1];  // if we reach at end node/number return pcorreponding probability
            if(vis[curNode] == true) continue; // if already visited node skip it.
            vis[curNode] = true; // if not visited before then mark it as  visited

            double curProb = cur[1];


            for (double[] g : adjList[curNode]) {
                int nxt = (int)g[0];
                double p = g[1];
                double val = prob[nxt];
                if(curProb*p > prob[nxt]){  // if you are getting more value for corresponding position in prob array update that and add new pair in that
                    queue.add(new double[]{nxt,curProb*p});
                }
            }

        }

        // If there is no path from start to end, return 0
        return 0.0;
    }
}
