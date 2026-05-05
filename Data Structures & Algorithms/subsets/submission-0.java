class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        helper(subset, nums, new ArrayList(), 0);
        return subset;
    }

    public void helper(List<List<Integer>> subset, int[] nums, List<Integer> curr, int start) {
        if (start >= nums.length) {
            subset.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[start]);
        helper(subset, nums, curr, start+1);
        curr.remove(curr.size()-1);
        helper(subset, nums, curr, start+1);
    }
}
