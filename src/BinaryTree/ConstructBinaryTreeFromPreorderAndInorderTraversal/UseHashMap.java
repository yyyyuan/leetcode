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
        HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);        

        return helper(preorder, inorder, 0, 0, inorder.length - 1, inMap);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, HashMap<Integer, Integer> inMap)     {
        if (inStart > inEnd) return null;
        
        int root = preorder[preStart];
        int index = inMap.get(root);
        
        TreeNode p = new TreeNode(root);
        TreeNode left = helper(preorder, inorder, preStart + 1, inStart, index - 1, inMap);
        TreeNode right = helper(preorder, inorder, preStart + index - inStart + 1, index + 1, inEnd, inMap);
        p.left = left;
        p.right = right;
        
        return p;
    }
}
