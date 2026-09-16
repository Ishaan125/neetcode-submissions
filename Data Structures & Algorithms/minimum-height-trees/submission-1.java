class Solution {
    private List<List<Integer>> adj;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        int[] heights = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int next = bfs(i);
            heights[i] = next;
            min = Math.min(min, next);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (heights[i] == min) {
                res.add(i);
            }
        }

        return res;
    }

    private int bfs(int root) {
        int height = 0;
        Queue<Integer> nodes = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        nodes.offer(root);
        visited.add(root);
        while (!nodes.isEmpty()) {
            int n = nodes.size();
            for (int i = 0; i < n; i++) {
                int curr = nodes.poll();
                for (int nei : adj.get(curr)) {
                    if (!visited.contains(nei)) {
                        nodes.offer(nei);
                        visited.add(nei);
                    }
                }
            }
            height++;
        }
        return height;
    }
}