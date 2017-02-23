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
        
        search(result, path, root);
        
        return result;
    }
    
    public void search(List<String> result, String path, TreeNode root) {
        if (root == null) {
            if (!result.contains(path)) result.add(path);
            return;
        }
        
        if (path == "") {
            if (root.right == null || root.left != null) search(result, path + root.val, root.left);
            if (root.right != null || root.left == null) search(result, path + root.val, root.right);  
        } 
        else {
            if (root.right == null || root.left != null) search(result, path + "->" + root.val, root.left);
            if (root.right != null || root.left == null) search(result, path + "->" + root.val, root.right);            
        }
        

        
    }
}
