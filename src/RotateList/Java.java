/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // Defining a list node dummy is a good way to solve the problem.
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode tempHead = dummy;
        
        if (head == null) return head;
        
        while (p.next != null) {
            p = p.next;
            size++;
        }
        
        int index = size - k % size;
        
        if (index == size) return head;
        else {
            
            while (index != 0) {
            
                tempHead = tempHead.next;
                index--;
            }
    
        
            p.next = dummy.next;
            head = tempHead.next;
            tempHead.next = null;
        
            return head;   
        }

    }
}
