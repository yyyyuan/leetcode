/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 
 // I use preorder of binary trees to serialize and deserialize the tree.
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = new String();
        if (root == null) return "n,";
        result += root.val + ",";
        
        if (root.left == null) result += "n,";
        else result += serialize(root.left) + ",";
        
        if (root.right == null) result += "n,";
        else result += serialize(root.right) + ",";
        
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>();
        String[] split = data.split(",");
        for (int i=0; i<split.length; i++) {
            queue.add(split[i]);
        }
        
        return buildTree(queue);
    }
    
    public TreeNode buildTree(Queue<String> queue) {
        if (queue.size() == 0) return null;
        String s = queue.poll();
        if (s.equals("")) return buildTree(queue);
        if (s.equals("n")) return null;
        else {
            TreeNode result = new TreeNode(Integer.valueOf(s));
            result.left = buildTree(queue);
            result.right = buildTree(queue);
            return result;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
