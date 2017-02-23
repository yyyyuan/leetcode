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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
        if (root == null) return result;
        
        String path = "";
        
        if (root.left == null && root.right == null) result.add(path+root.val);
        if (root.left != null) search(result, path + root.val, root.left);
        if (root.right != null) search(result, path + root.val, root.right);

        return result;
    }
    
    public void search(List<String> result, String path, TreeNode root) {
        if (root == null) {
            if (!result.contains(path)) result.add(path);
            return;
        }
        
        if (root.right == null || root.left != null) search(result, path + "->" + root.val, root.left);
        if (root.right != null || root.left == null) search(result, path + "->" + root.val, root.right);            
        

        
    }
}
