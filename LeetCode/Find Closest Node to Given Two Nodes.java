/*You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from i, then edges[i] == -1.

You are also given two integers node1 and node2.

Return the index of the node that can be reached from both node1 and node2, such that the maximum between the distance from node1 to that node, and from node2 to that node is minimized. If there are multiple answers, return the node with the smallest index, and if no possible answer exists, return -1.

Note that edges may contain cycles.*/

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        final int n = edges.length;
        final Integer[] m1 = new Integer[n];
        final Integer[] m2 = new Integer[n];
        dfs(edges, m1, node1);
        dfs(edges, m2, node2);
        int index = -1;
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (m1[i] != null && m2[i] != null && dist > Math.max(m1[i], m2[i])) {
                dist = Math.max(m1[i], m2[i]);
                index = i;
            }
        }
        return index;
    }

    private void dfs(int[] edges, Integer[] memo, int node) {
        int dist = 0;
        while (node != -1 && memo[node] == null) {
            memo[node] = dist++;
            node = edges[node];
        }
    }
}
