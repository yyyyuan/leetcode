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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1, inMap);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd, HashMap<Integer, Integer> inMap)     {
        if (inStart > inEnd) return null;
        int root = postorder[postEnd];
        int index = inMap.get(root);
        
        TreeNode p = new TreeNode(root);
        TreeNode right = helper(inorder, postorder, postEnd - 1, index + 1, inEnd, inMap);
        TreeNode left = helper(inorder, postorder, postEnd - (inEnd - index + 1), inStart, index - 1, inMap);
        p.left = left;
        p.right = right;
        
        return p;
    }
}
