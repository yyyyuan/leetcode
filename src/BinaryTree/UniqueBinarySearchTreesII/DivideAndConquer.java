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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generateSubtrees(1, n);    
    }
    
    private List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (s > e) {
            result.add(null);
            return result;
        }
        
        for (int i = s; i <= e; i++) {
            List<TreeNode> leftSubtree = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtree = generateSubtrees(i + 1, e);
            
            for (TreeNode left : leftSubtree) {
                for (TreeNode right : rightSubtree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}
