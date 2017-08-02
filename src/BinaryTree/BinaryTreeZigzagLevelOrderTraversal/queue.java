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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;   // We set up a indicator to show the order of reading.
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> sublist = new LinkedList<>();
            while (size > 0) {
                TreeNode p = queue.remove();
                if (order) sublist.add(p.val);
                else sublist.addFirst(p.val);
                
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
                size--;
            }
            
            result.add(sublist);
            order = order ? false : true;
        }
        
        return result;
    }
}
