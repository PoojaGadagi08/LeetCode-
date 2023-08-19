Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi. A minimum spanning tree (MST) is a subset of the graph's edges that connects all vertices without cycles and with the minimum possible total edge weight.

Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). An MST edge whose deletion from the graph would cause the MST weight to increase is called a critical edge. On the other hand, a pseudo-critical edge is that which can appear in some MSTs but not all.

Note that you can return the indices of the edges in any order.

 

Example 1:



Input: n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
Output: [[0,1],[2,3,4,5]]
Explanation: The figure above describes the graph.
The following figure shows all the possible MSTs:

Notice that the two edges 0 and 1 appear in all MSTs, therefore they are critical edges, so we return them in the first list of the output.
The edges 2, 3, 4, and 5 are only part of some MSTs, therefore they are considered pseudo-critical edges. We add them to the second list of the output.
Example 2:



Input: n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
Output: [[],[0,1,2,3]]
Explanation: We can observe that since all 4 edges have equal weight, choosing any 3 edges from the given 4 will yield an MST. Therefore all 4 edges are pseudo-critical.
 

Constraints:

2 <= n <= 100
1 <= edges.length <= min(200, n * (n - 1) / 2)
edges[i].length == 3
0 <= ai < bi < n
1 <= weighti <= 1000
All pairs (ai, bi) are distinct.





  class UnionFind{
    final int[] parents;
    int count;
    
    public UnionFind(int n){
        this.parents = new int[n];
        reset();
    }
    
    public void reset(){
        for(int i =0;i<parents.length;i++){
            parents[i] = i;
        }
        count = parents.length;
    }
    
    public int find(int i){
        int parent = parents[i];
        if(parent == i){
            return i;
        }else{
            int root = find(parent);
            parents[i] = root;
            return root;
        }
    }
    
    public boolean union(int i, int j){
        int r1 = find(i);
        int r2 = find(j);
        if(r1 != r2){
            count--;
            parents[r1] = r2;
            return true;
        }else{
            return false;
        }
    }
    
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
       
        List<Integer>criticals = new ArrayList<>();
        List<Integer> pseduos = new ArrayList<>();
        
        Map<int[], Integer> map = new HashMap<>();
        for(int i =0;i<edges.length;i++){
            map.put(edges[i], i);
        }
        
        Arrays.sort(edges, (e1, e2)->Integer.compare(e1[2], e2[2]));
        int minCost = buildMST(n, edges, null, null);
        
        for(int i =0;i<edges.length;i++){
            int[] edge = edges[i];
            int index = map.get(edge);
            int costWithout = buildMST(n, edges, null, edge);
            if(costWithout > minCost){
                criticals.add(index);
            }else{
                int costWith = buildMST(n, edges, edge, null);
                if(costWith == minCost){
                    pseduos.add(index);
                }
            }
            
        }
        
        return Arrays.asList(criticals, pseduos);
    }
    
    private int buildMST(int n, int[][] edges, int[] pick, int[] skip){
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        if(pick != null){
            uf.union(pick[0], pick[1]);
            cost += pick[2];
        }
        
        for(int[] edge : edges){
            if(edge != skip && uf.union(edge[0], edge[1])){
                cost += edge[2];
            }
        }
        return uf.count == 1? cost : Integer.MAX_VALUE;
    }
}
