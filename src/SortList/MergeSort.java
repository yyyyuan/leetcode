/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        
        ListNode l1 = sortList(slow.next);
        slow.next = null;
        ListNode l2 = sortList(head);
        
        ListNode result = merge(l1, l2);
        return result;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode p = dump;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
                p.next = null;
            }
            else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
                p.next = null;
            }
        }
        
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dump.next;
    }
}
