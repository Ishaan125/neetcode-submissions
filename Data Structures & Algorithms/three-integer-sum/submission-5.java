class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0; r < nums.length-2; r++) {
            if (r > 0 && nums[r] == nums[r-1]) {
                continue;
            }
            int i = r+1;
            int j = nums.length-1;
            while (i < j) {
                if (nums[i] + nums[j] + nums[r] == 0) {
                    res.add(Arrays.asList(nums[r], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j] == nums[j - 1]) j--;
                    i++;
                    j--;
                }
                else if (nums[i] + nums[j] + nums[r] > 0) {
                    j--;
                }
                else {
                    i++;
                }
            }
        }

        return res;
    }
}
