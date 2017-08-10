/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // This is not fast cause we need to operate on the linked list.
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode p = dump;
        ListNode iterator = head;
        
        while (p.next != null) {
            int min = Integer.MAX_VALUE;
            iterator = p;
            ListNode smallest = p;
            while (iterator.next != null) {
                if (iterator.next.val < min) {
                    min = iterator.next.val;
                    smallest = iterator;
                }
                iterator = iterator.next;
            }
            
            ListNode node = smallest.next;
            smallest.next = node.next;
            node.next = p.next;
            p.next = node;
            
            p = p.next;
        }
        
        
        return dump.next;
    }
}
