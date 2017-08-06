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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        backtrack(root, 0);
        
        return result;
    }
    
    private void backtrack(TreeNode root, int pre) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            int temp = (pre * 10) + root.val;
            result += temp;
            return;
        }
        
        pre = pre * 10 + root.val;
        if (root.left != null) backtrack(root.left, pre);
        if (root.right != null) backtrack(root.right, pre);
        pre = (pre - root.val) / 10;
        
    }
}
