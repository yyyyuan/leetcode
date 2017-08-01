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
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        
        if (n == 0) return result[0];
        
        result[0].add(null);
        
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                for (TreeNode left : result[i]) {
                    for (TreeNode right : result[len - i - 1]) {
                        TreeNode root = new TreeNode(i + 1);
                        root.left = left;
                        root.right = clone(right, i + 1);
                        result[len].add(root);
                    }
                }
            }
        }
        
        return result[n];
    }
    
    private TreeNode clone(TreeNode root, int offset) {
        if (root == null) return null;
        
        TreeNode node = new TreeNode(root.val + offset);
        node.left = clone(root.left, offset);
        node.right = clone(root.right, offset);
        
        return node;
    }
}
