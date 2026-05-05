class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nums = new ArrayList<>();
        helper(root, nums, 0);
        return nums;
    }

    private void helper(TreeNode node, List<List<Integer>> nums, int level) {
        if (node == null) {
            return;
        }
        if (nums.size() == level) {
            nums.add(new ArrayList<>());
        }

        nums.get(level).add(node.val);

        helper(node.left, nums, level + 1);
        helper(node.right, nums, level + 1);
    }
}
