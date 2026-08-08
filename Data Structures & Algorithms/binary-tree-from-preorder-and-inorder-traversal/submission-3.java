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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;
        for (mid = 0; mid < inorder.length; mid++) {
            if (inorder[mid] == preorder[0]) {
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,mid+1), Arrays.copyOfRange(inorder,0,mid));
        root.right = buildTree(Arrays.copyOfRange(preorder,mid+1,preorder.length), Arrays.copyOfRange(inorder,mid+1,inorder.length));
        return root;
    }
}

//1,2,3,4,5 -> 2,1,4,3,5 -> 