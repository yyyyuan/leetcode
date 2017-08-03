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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();  // Note that if we need to use addFirst we should use LinkedList to define the variable.
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sublist = new ArrayList<Integer>();
            
            while (size > 0) {
                TreeNode p = queue.poll();
                sublist.add(p.val);
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
                size--;
            }
            
            result.addFirst(sublist);
        }
        
        return result;
    }
}
