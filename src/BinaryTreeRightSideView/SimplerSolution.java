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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }
    
    private void rightView(TreeNode root, List<Integer> result, int depth) {
        if (root == null) return;
        if (depth == result.size()) result.add(root.val);
        
        rightView(root.right, result, depth + 1);
        rightView(root.left, result, depth + 1);
    }
}
