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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        int[] range = new int[] {0,0};
        findRange(root, range, 0);
        
        for (int i=range[0]; i<=range[1]; i++) {
            result.add(new ArrayList<Integer>());
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> colNumber = new LinkedList<Integer>();
        
        queue.add(root);
        colNumber.add(0-range[0]);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = colNumber.poll();
            
            result.get(col).add(node.val);
            
            if (node.left != null) {
                queue.add(node.left);
                colNumber.add(col-1);
            }
            
            if (node.right != null) {
                queue.add(node.right);
                colNumber.add(col+1);
            }
        }
        
        return result;
    }
    
    public void findRange(TreeNode node, int[] range, int col) {
        if (node == null) return;
        
        range[0] = Math.min(range[0], col);
        range[1] = Math.max(range[1], col);
        
        findRange(node.left, range, col-1);
        findRange(node.right, range, col+1);
    }
}
