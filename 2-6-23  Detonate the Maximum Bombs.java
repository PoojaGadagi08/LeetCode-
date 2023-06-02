You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. This area is in the shape of a circle with the center as the location of the bomb.

The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, 
whereas ri denotes the radius of its range.

You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.

Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.
  
  Example 1:


Input: bombs = [[2,1,3],[6,1,4]]
Output: 2
Explanation:
The above figure shows the positions and ranges of the 2 bombs.
If we detonate the left bomb, the right bomb will not be affected.
But if we detonate the right bomb, both bombs will be detonated.
So the maximum bombs that can be detonated is max(1, 2) = 2.
  
  
  
class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int maxBombs = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (Math.pow(bombs[i][2], 2) >= Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2)) {
                    List<Integer> neighbors = graph.getOrDefault(i, new ArrayList<>());
                    neighbors.add(j);
                    graph.put(i, neighbors);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            dfs(i, visited, graph);
            maxBombs = Math.max(maxBombs, visited.size());
        }

        return maxBombs;
    }

    private void dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
        for (int child : neighbors) {
            if (!visited.contains(child)) {
                visited.add(child);
                dfs(child, visited, graph);
            }
        }
    }
}
