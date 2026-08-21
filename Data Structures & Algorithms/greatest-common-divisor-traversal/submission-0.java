class Solution {
    private Set<Integer> visited = new HashSet<>();
    private List<List<Integer>> adj = new ArrayList<>();

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

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

        visited.add(0);
        dfs(nums, 0);
        return visited.size() == n;
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
        for (int nei : adj.get(i)) {
            if (visited.contains(nei)) {
                continue;
            }
            visited.add(nei);
            dfs(nums, nei);
        }
    }
}

// every num = node in undirected graph
// only connect when gcd > 1
// check if visited set = len(nums)