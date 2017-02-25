/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode start = reverseList(head.next);
        ListNode temp = start;
        while (temp.next != null) temp = temp.next;
        head.next = null;
        temp.next = head;
        
        return start;
    }

}
