There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1. The edges of the graph are initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti] meaning that there is an edge from fromi to toi with the cost edgeCosti.

Implement the Graph class:

Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost]. It is guaranteed that there is no edge between the two nodes before adding this one.
int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2. If no path exists, return -1. The cost of a path is the sum of the costs of the edges in the path.
 

Example 1:


Input
["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
[[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
Output
[null, 6, -1, null, 6]

Explanation
Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
g.shortestPath(3, 2); // return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
g.shortestPath(0, 3); // return -1. There is no path from 0 to 3.
g.addEdge([1, 3, 4]); // We add an edge from node 1 to node 3, and we get the second diagram above.
g.shortestPath(0, 3); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.
 

Constraints:

1 <= n <= 100
0 <= edges.length <= n * (n - 1)
edges[i].length == edge.length == 3
0 <= fromi, toi, from, to, node1, node2 <= n - 1
1 <= edgeCosti, edgeCost <= 106
There are no repeated edges and no self-loops in the graph at any point.
At most 100 calls will be made for addEdge.
At most 100 calls will be made for shortestPath.





  class Graph {

   List<List<Pair<Integer, Integer>>> adj_list;
public Graph(int n, int[][] edges) {
    adj_list = new ArrayList<>();
    for (int i = 0; i < n; i++)
        adj_list.add(new ArrayList<>());
    for (int[] e : edges)
        adj_list.get(e[0]).add(new Pair<>(e[1], e[2]));
}

public void addEdge(int[] e) {
    adj_list.get(e[0]).add(new Pair<>(e[1], e[2]));
}

public int shortestPath(int node1, int node2) {
    int n = adj_list.size();
    PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.getKey()));
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[node1] = 0;
    pq.offer(new Pair<>(0, node1));

    while (!pq.isEmpty()) {
        var pair = pq.poll();
        int d = pair.getKey(), node = pair.getValue();
        if (node == node2) return d;
        if (d > dist[node]) continue;
        for (Pair<Integer, Integer> neighbor : adj_list.get(node)) {
            int new_dist = d + neighbor.getValue();
            if (new_dist < dist[neighbor.getKey()]) {
                dist[neighbor.getKey()] = new_dist;
                pq.offer(new Pair<>(new_dist, neighbor.getKey()));
            }
        }
    }
    return -1;
}
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
