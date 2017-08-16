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
        if (root == null) return new ArrayList<>();
        
        List<Integer> left = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        
        int m = left.size();
        int n = right.size();
        
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        
        for (int i = 0; i < n; i++) result.add(right.get(i));

        for (int i = n; i < m; i++) {
            result.add(left.get(i));
        }
        
        return result;
    }
    
}
