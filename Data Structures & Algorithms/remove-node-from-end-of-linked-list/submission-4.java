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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1, head);

        ListNode firstptr = head;
        ListNode prev = dummy;

        while(firstptr!=null){
            firstptr=firstptr.next;
            n--;
            if(n<0){
                prev=prev.next;
            }

        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
