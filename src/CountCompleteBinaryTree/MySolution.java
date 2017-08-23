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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int left = getLeft(root);
        int right = getRight(root);
        int mid = getLeft(root.right) + 1;
        
        if (left == right) return (1 << left) - 1;
        if (mid != left) return countNodes(root.left) + (1 << (right - 1));
        else return countNodes(root.right) + (1 << (left - 1));
    }
    
    private int getLeft(TreeNode root) {
        if (root == null) return 0;
        return getLeft(root.left) + 1;
    }
    
    private int getRight(TreeNode root) {
        if (root == null) return 0;
        return getRight(root.right) + 1;
    }
}
