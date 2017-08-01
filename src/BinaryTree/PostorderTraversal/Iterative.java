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
        LinkedList<Integer> result = new LinkedList<>();    // Note that result here should be LinkedList
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            }
            else {
                p = stack.pop();
                p = p.left;
            }
        }
        
        return result;
    }
}
