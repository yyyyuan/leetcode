/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        
        
        // Find the middle pointer
        while (p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        
        
        // Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMid = p2;
        ListNode preCur = p2.next;
        
        
        while (preCur.next != null) {
            ListNode cur = preCur.next;
            preCur.next = cur.next;
            cur.next = preMid.next;
            preMid.next = cur;
        }
                
        
        // Complete the reorder  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1 = head;
        p2 = preMid.next;
        
        while (p1 != preMid) {
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }
    }
}
