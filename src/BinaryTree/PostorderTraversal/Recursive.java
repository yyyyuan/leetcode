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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        postorder(root, result);
        return result;
    }
    
    private void postorder(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        postorder(root.left, nodes);
        postorder(root.right, nodes);
        nodes.add(root.val);
    }
}
