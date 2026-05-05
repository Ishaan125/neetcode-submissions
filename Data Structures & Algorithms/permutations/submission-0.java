class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        helper(permutations, new ArrayList<>(), nums, new boolean[nums.length]);
        return permutations;
    }

    private void helper(List<List<Integer>> permutations, List<Integer> curr, int[] nums, boolean[] pick) {
        if (curr.size() == nums.length) {
            permutations.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                curr.add(nums[i]);
                helper(permutations, curr, nums, pick);
                curr.remove(curr.size()-1);
                pick[i] = false;
            }
        }
    }
}
