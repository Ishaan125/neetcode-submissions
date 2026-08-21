class Solution {
    private boolean[] visited;
    private List<List<Integer>> adj = new ArrayList<>();
    private int total = 0;

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j])) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        dfs(nums, 0);
        return total == n;
    }

    private boolean gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a > 1;
    }

    private void dfs(int[] nums, int i) {
        visited[i] = true;
        total++;
        for (int nei : adj.get(i)) {
            if (!visited[nei]) {
                dfs(nums, nei);
            }
        }
    }
}

// every num = node in undirected graph
// only connect when gcd > 1
// check if visited set = len(nums)