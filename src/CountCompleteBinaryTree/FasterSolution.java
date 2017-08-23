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
        int mid = getLeft(root.right) + 1;
        
        if (mid != left) return countNodes(root.left) + (1 << (left - 2));
        else return countNodes(root.right) + (1 << (left - 1));
    }
    
    private int getLeft(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}
