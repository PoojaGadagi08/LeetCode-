// An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes an edge between nodes ui and 
// vi with distance disi. Note that there may be multiple edges between two nodes.

// Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j] whether there is 
// a path between pj and qj such that each edge on the path has a distance strictly less than limitj .

// Return a boolean array answer, where answer.length == queries.length and the jth value of answer is true if there is a path for queries[j] is true, 
// and false otherwise.

 



class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py) {
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edges, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(queries, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        UnionFind uf = new UnionFind(n);
        int i = 0;
        for (int[] q : queries) {
            int u = q[0], v = q[1], limit = q[2], qid = q[3];
            while (i < edges.length && edges[i][2] < limit) {
                uf.union(edges[i][0], edges[i][1]);
                i++;
            }
            ans[qid] = uf.connected(u, v);
        }
        return ans;
    }
}
