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
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int getMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int path = node.val + Math.max(getMax(node.left), getMax(node.right));
        return Math.max(0, path);
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            max = Math.max(max, node.val + getMax(node.left) + getMax(node.right));
            dfs(node.left);
            dfs(node.right);
        }
    } 
}
