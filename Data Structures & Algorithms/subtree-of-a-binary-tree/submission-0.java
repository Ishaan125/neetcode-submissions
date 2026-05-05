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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if (root == null) {
            return false;
        }
        if (isSame(root, subroot)) {
            return true;
        }
        boolean check = isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
        if (check) {
            return true;
        }
        return false;
    }

    public boolean isSame(TreeNode root, TreeNode subroot) {
        if (root == null && subroot != null || root != null && subroot == null) {
            return false;
        }
        if (subroot == null && root == null) {
            return true;
        }
        if (root.val != subroot.val) {
            return false;
        }
        return isSame(root.left, subroot.left) && isSame(root.right, subroot.right);
    }
}
