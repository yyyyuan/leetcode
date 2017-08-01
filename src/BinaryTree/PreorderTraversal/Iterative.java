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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                result.add(p.val);
                p = p.left;
            }
            else {
                p = stack.pop();
                p = p.right;
            }
        }
        
        return result;
        
    }
}
