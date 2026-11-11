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

        ListNode firstptr = head;
        ListNode secptr=null;
        ListNode prev = null;

        while(firstptr!=null){
            prev = secptr;
            firstptr=firstptr.next;
            n--;
            if(n==0) secptr=head;
            if(n<0){
                secptr=secptr.next;
            }

        }
        if(prev==null) return head.next;

        prev.next=secptr.next;
return head;

    }
}
