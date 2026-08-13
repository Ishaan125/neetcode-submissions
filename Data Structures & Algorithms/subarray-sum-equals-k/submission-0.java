class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int pre = 0;
        count.put(0,1);
        for (int i : nums) {
            pre += i;
            res += count.getOrDefault(pre - k, 0);
            count.put(pre, count.getOrDefault(pre, 0) + 1);
        }

        return res;
    }
}