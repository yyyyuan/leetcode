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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), root, sum);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> sublist, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        
        sublist.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList(sublist));
            sublist.remove(sublist.size() - 1);
            return;
        }
        else {
            helper(result, sublist, root.left, sum - root.val);
            helper(result, sublist, root.right, sum - root.val);
        }
        sublist.remove(sublist.size() - 1);
        
    }
}
