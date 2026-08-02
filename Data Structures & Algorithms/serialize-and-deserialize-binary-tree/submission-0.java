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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        preOrder(str, root);
        return str.toString();
    }

    private void preOrder(StringBuilder str, TreeNode node) {
        if (node == null) {
            str.append("null, ");
        }
        else { 
            str.append(node.val + ", ");
            preOrder(str, node.left);
            preOrder(str, node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(", ");
        int[] i = {0};
        return dfs(arr, i);
    }

    private TreeNode dfs(String[] arr, int[] i) {
        if (arr[i[0]].equals("null")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[i[0]]));
        i[0]++;
        node.left = dfs(arr, i);
        node.right = dfs(arr, i);
        return node;
    }
}
