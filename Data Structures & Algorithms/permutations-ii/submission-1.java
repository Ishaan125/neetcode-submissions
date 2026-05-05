class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        boolean[] picked = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), picked);
        return res;
    }

    private void helper(int[] nums, List<Integer> curr, boolean[] picked) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        }

        else {
            for (int i = 0; i < nums.length; i++) {
                if (!picked[i] && !(i > 0 && nums[i] == nums[i-1] && !picked[i-1])) {
                    curr.add(nums[i]);
                    picked[i] = true;
                    helper(nums, curr, picked);
                    curr.remove(curr.size()-1);
                    picked[i] = false;
                }
            }
        }
    }
}