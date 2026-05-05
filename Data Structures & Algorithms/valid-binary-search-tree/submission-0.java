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
    public boolean isValidBST(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return helper(root, min, max);
    }

    private boolean helper(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (!(min < node.val && max > node.val)) {
            return false;
        }
        return helper(node.right, node.val, max) && helper(node.left, min, node.val);
    }
}
