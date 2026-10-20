/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowptr = head==null? null : head.next;
        ListNode fastptr = slowptr==null ? null : head.next.next ;
        while(fastptr!=null){
            if (fastptr.equals(slowptr)) return true;
            fastptr= fastptr.next==null? null : fastptr.next.next;
            slowptr=slowptr.next;
        }
        return false;
    }
}
