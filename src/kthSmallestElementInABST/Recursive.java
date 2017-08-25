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
    int count = 0;
    int number = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    
    private void helper(TreeNode root) {
        if (root.left != null) helper(root.left);
        count--;
        if (count == 0) {
            number = root.val;
            return;
        }
        
        if (root.right != null) helper(root.right);
    }
}
