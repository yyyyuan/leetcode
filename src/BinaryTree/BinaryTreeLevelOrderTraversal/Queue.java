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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();    
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            while (size != 0) {
                TreeNode p = queue.remove();
                if (p != null) {
                    subList.add(p.val);
                    if (p.left != null) queue.add(p.left);
                    if (p.right != null) queue.add(p.right);
                } 
                size--;
            }
            result.add(subList);
            
        }
        
        
        return result;
    }
}
