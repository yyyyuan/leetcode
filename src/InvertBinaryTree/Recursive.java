/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        root.left = invertTree(tempRight);
        root.right = invertTree(tempLeft);
        
        return root;
    }
}
