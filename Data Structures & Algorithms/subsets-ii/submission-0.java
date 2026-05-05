class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        helper(subsets, new ArrayList<>(), 0, nums);
        return subsets;
    }

    public void helper(List<List<Integer>> subsets, List<Integer> curr, int startIndex, int[] nums) {
        subsets.add(new ArrayList<>(curr));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            helper(subsets, curr, i+1, nums);
            curr.remove(curr.size()-1);
        }
    }
}
