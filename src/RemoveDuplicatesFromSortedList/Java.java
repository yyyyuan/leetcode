/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        while (dummy != null && dummy.next != null) {    // This is an "and" relationship.
            if (dummy.next.val == dummy.val) dummy.next = dummy.next.next;
            else dummy = dummy.next;            // Note the case of move dummy to next list node.
        }
        
        return head;
    }
}
