There are n items each belonging to zero or one of m groups where group[i] is the group that the i-th item belongs to and it's equal to -1 if the i-th item belongs to no group. The items and the groups are zero indexed. A group can have no item belonging to it.

Return a sorted list of the items such that:

The items that belong to the same group are next to each other in the sorted list.
There are some relations between these items where beforeItems[i] is a list containing all the items that should come before the i-th item in the sorted array (to the left of the i-th item).
Return any solution if there is more than one solution and return an empty list if there is no solution.

 

Example 1:



Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
Output: [6,3,4,1,5,2,0,7]
Example 2:

Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
Output: []
Explanation: This is the same as example 1 except that 4 needs to be before 6 in the sorted list.
 

Constraints:

1 <= m <= n <= 3 * 104
group.length == beforeItems.length == n
-1 <= group[i] <= m - 1
0 <= beforeItems[i].length <= n - 1
0 <= beforeItems[i][j] <= n - 1
i != beforeItems[i][j]
beforeItems[i] does not contain duplicates elements.




  class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupId;
                groupId++;
            }
        }

        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; ++i) {
            itemGraph.put(i, new ArrayList<>());
        }
        
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        int[] groupIndegree = new int[groupId];
        for (int i = 0; i < groupId; ++i) {
            groupGraph.put(i, new ArrayList<>());
        }
        
        for (int curr = 0; curr < n; curr++) {
            for (int prev : beforeItems.get(curr)) {
                itemGraph.get(prev).add(curr);
                itemIndegree[curr]++;
                if (group[curr] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[curr]);
                    groupIndegree[group[curr]]++;
                }
            }
        }

        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);
        
        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[0];
        }

        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (Integer item : itemOrder) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }
        
        List<Integer> answerList = new ArrayList<>();
        for (int groupIndex : groupOrder) {
            answerList.addAll(orderedGroups.getOrDefault(groupIndex, new ArrayList<>()));
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer key : graph.keySet()) {
            if (indegree[key] == 0) {
                stack.add(key);
            }
        }
        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            visited.add(curr);
            for (Integer prev : graph.get(curr)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    stack.add(prev);
                }
            }
        }
        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }
}
