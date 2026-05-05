class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, 0, nums);
        return nums;
    }

    private void dfs(TreeNode node, int level, List<Integer> nums) {
        if (node == null) return;

        // If this level is seen for the first time, add the node
        if (level == nums.size()) {
            nums.add(node.val);
        }

        dfs(node.right, level + 1, nums);
        dfs(node.left, level + 1, nums);
    }
}
