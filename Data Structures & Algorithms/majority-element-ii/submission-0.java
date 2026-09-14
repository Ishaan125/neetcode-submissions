class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length/3;
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            if (freq.get(i) == n + 1) {
                res.add(i);
            }
        }
        return res;
    }
}
