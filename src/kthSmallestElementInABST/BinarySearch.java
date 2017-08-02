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
        int count = countNodes(root.left);
        if (k <= count) return kthSmallest(root.left, k);
        else if (k > count + 1) return kthSmallest(root.right, k - (count + 1));
        
        return root.val;
    }
    
    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
