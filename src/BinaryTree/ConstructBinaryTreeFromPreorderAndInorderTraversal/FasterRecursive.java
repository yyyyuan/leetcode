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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        int root = preorder[preStart];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }
        
        TreeNode p = new TreeNode(root);
        TreeNode left = helper(preorder, inorder, preStart + 1, inStart, index - 1);
        TreeNode right = helper(preorder, inorder, preStart + index - inStart + 1, index + 1, inEnd);
        p.left = left;
        p.right = right;
        
        return p;
    }
}
