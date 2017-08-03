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
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p.right != null) stack.push(p.right);
            if (p.left != null) stack.push(p.left);
            if (!stack.isEmpty()) p.right = stack.peek();
            p.left = null;
        }
    }
}
