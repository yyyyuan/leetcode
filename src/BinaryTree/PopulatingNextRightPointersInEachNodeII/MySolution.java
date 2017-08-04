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
            TreeLinkNode connect = null;
            
            while (cur != null) {
                
                if (cur.left != null) {
                    if (connect == null) connect = cur.left;
                    else {
                        connect.next = cur.left;
                        connect = connect.next;
                    }
                }
                if (cur.right != null) {
                    if (connect == null) connect = cur.right;
                    else {
                        connect.next = cur.right;
                        connect = connect.next;
                    }
                }
                
                
                cur = cur.next;
            }
            
            while (p != null && p.left == null && p.right == null) {
                p = p.next;
            }
            
            if (p != null) {
                if (p.left != null) p = p.left;
                else p = p.right;                
            }

        }
    }
}
