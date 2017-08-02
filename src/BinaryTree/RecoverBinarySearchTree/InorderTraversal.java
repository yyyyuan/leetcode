/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (first == null && pre.val >= root.val) first = pre;
        if (first != null && pre.val >= root.val) second = root;
        pre = root;
        
        traverse(root.right);
    }
}
