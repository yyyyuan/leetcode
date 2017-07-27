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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        ListNode fake = dummy;
        
        while (temp != null) {
            while (temp.next != null && temp.val == temp.next.val) temp = temp.next;
            
            if (fake.next == temp) fake = fake.next;
            else fake.next = temp.next;

            temp = temp.next;
        }
        
        return dummy.next;
    }
}
