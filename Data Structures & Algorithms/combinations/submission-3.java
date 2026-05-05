class Solution {
    private List<List<Integer>> nums;
    public List<List<Integer>> combine(int n, int k) {
        nums = new ArrayList<>();
        helper(n, k, new ArrayList<>(), 1);
        return nums;
    }

    private void helper(int n, int k, List<Integer> curr, int i) {
        if (curr.size() == k) {
            nums.add(new ArrayList<>(curr));
        }
        else {
            for (int idx = i; idx <= n; idx++) {
                curr.add(idx);
                helper(n, k, curr, idx+1);
                curr.remove(curr.size()-1);
            }
        }
    }
}