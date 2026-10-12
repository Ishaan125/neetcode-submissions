class Solution {
    private Map<Integer, Integer> dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new HashMap<>();
        dp.put(0, 1);
        Arrays.sort(nums);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int total) {
        if (dp.containsKey(total)) return dp.get(total);
        int res = 0;
        for (int num : nums) {
            if (total - num < 0) {
                break;
            }
            res += dfs(nums, total - num);
        }

        dp.put(total, res);
        return res;
    }
}