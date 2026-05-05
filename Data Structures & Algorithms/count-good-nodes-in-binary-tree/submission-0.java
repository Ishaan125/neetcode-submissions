/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return 1 + helper(root.left, root.val) + helper(root.right, root.val);
    }

    private int helper(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        if (node.val >= max) {
            return 1 + helper(node.left, node.val) + helper(node.right, node.val); 
        }
        return helper(node.left, max) + helper(node.right, max);
    }
}
