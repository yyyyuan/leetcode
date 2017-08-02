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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        
        while (p != null || !stack.isEmpty()) {   // This is a different implementation for inorder traversal, but the logic is same.
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            
            p = stack.pop();
            if (--k == 0) return p.val;
            p = p.right;
        }
        
        return -1;
    }
}
