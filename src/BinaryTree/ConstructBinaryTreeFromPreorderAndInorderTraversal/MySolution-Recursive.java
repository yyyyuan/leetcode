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
        if (preorder.length != inorder.length || preorder.length == 0) return null; 
        int root = preorder[0];
        
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }
        
        TreeNode node = new TreeNode(root);
        TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        TreeNode right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), 
                                   Arrays.copyOfRange(inorder, index + 1, inorder.length));
        node.left = left;
        node.right = right;
        
        return node;
        
    }
}
