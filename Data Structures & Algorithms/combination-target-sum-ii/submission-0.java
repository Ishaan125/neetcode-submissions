class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        Arrays.sort(candidates);
        helper(sums, new ArrayList<>(), 0, target, candidates, 0);
        return sums;
    }

    public void helper(List<List<Integer>> sums, List<Integer> curr, int total, int target, int[] nums, int i) {
        if (total == target) {
            for (List<Integer> check : sums) {
                if (check.equals(curr)) {
                    return;
                }
            }
            sums.add(new ArrayList<>(curr));
            return;
        }
        if (total > target || i >= nums.length) {
            return;
        }

        curr.add(nums[i]);
        total += nums[i];
        helper(sums, curr, total, target, nums, i+1);
        curr.remove(curr.size()-1);
        total -= nums[i];
        helper(sums, curr, total, target, nums, i+1);
    }
}
