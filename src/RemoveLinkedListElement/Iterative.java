/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;
        ListNode cur = head;
        
        while (cur != null) {
            if (cur.val == val) {
                pre.next = pre.next.next;
            }
            else pre = pre.next;
            cur = cur.next;
        }
        return dump.next;
    }
}
