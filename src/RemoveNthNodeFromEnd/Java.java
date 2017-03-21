/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        
        ListNode node = head;
        ListNode count = head;
        
        int length = 0;
        
        while (count != null) {
            length++;
            count = count.next;
        }
        
        
        while (length != n+1) {
            if (length < n+1) {
                head = head.next;
                return head;
            }
            node = node.next;
            length--;
        }
        
        if (node.next.next == null) node.next = null;
        else {
            ListNode temp = node.next.next;
            node.next.next = null;
            node.next = temp;
        }
        return head;

    }
}
