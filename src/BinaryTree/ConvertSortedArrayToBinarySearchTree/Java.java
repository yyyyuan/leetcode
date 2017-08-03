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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        int root = nums[mid];
        TreeNode p = new TreeNode(root);
        TreeNode left = helper(nums, start, mid - 1);
        TreeNode right = helper(nums, mid + 1, end);
        
        p.left = left;
        p.right = right;
        
        return p;
    }
    
}
