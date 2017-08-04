/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode p = root;
        
        while (p != null) {
            TreeLinkNode cur = p;
            
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.left != null && cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            
            p = p.left;
        }
    }
}
