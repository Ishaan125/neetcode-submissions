class Solution {

    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(new ArrayList<>(), 0, nums, target, 0);
        return res;
    }

    private void dfs(List<Integer> curr, int sum, int[] nums, int target, int i) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
        }
        else if (i < nums.length) {
            if (sum + nums[i] <= target) {
                curr.add(nums[i]);
                dfs(curr, sum + nums[i], nums, target, i);
                curr.remove(curr.size()-1);
            }
            dfs(curr, sum, nums, target, i+1);
        }
    }
}
