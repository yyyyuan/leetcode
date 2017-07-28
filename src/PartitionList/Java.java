/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        
        while (cur != null && cur.next != null) {
            if (cur.next.val < x) {
                if (pre.next == cur.next) {
                    pre = pre.next;
                    cur = cur.next;
                }
                else {
                    ListNode temp = cur.next;
                    cur.next = cur.next.next;
                    temp.next = pre.next;
                    pre.next = temp;
                    
                    pre = pre.next;
                }
            }
            else cur = cur.next;
            
        }
        
        return dummy.next;
    }
}
