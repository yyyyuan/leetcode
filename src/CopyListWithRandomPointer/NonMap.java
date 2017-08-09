/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iterator = head, next;
        
        // First loop duplicates the node and merge them into the original list.
        while (iterator != null) {
            next = iterator.next;
            
            RandomListNode copy = new RandomListNode(iterator.label);
            iterator.next = copy;
            copy.next = next;
            
            iterator = next;
        }
        
        
        // Second loop sets up random relationships in the list for the copy list.
        iterator = head;
        while (iterator != null) {
            // There are some nodes which don't have random pointers.
            if (iterator.random != null) iterator.next.random = iterator.random.next;
            iterator = iterator.next.next;
        }
        
        iterator = head;
        RandomListNode dump = new RandomListNode(0);
        RandomListNode p = dump;
        
        
        // Third loop extract the copy list from the merged list and restore the original list.
        while (iterator != null) {
            next = iterator.next.next;
            
            p.next = iterator.next;
            p = p.next;
            
            iterator.next = next;
            iterator = iterator.next;
        }
        
        return dump.next;        
    }
}
