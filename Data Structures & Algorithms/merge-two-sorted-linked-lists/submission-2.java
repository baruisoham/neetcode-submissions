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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list1Head = list1;
        ListNode list2Head = list2;

        while(list1!=null && list2!=null){
            ListNode curr = list1;
            ListNode next = list1.next;


            if(list2.val<curr.val && curr.equals(list1Head)){
                final ListNode temp = list2.next;
                list1Head = list2;
                list2.next=curr;
                list1=list1Head;
                list2=temp;
            } else if(curr.val<=list2.val && next!=null && next.val>=list2.val){
                ListNode temp=list2.next;
                insertNode(curr, list2, next);
                list2=temp;
            }
            else if(curr.val<=list2.val && curr.next==null){
                ListNode temp=list2.next;
                insertNode(curr,list2,null);
                list2=temp;
            } 
            else{
                if(list1!=null) list1=list1.next;
                }
        }
        return list1Head==null ? list2Head : list1Head;

    }

    private void insertNode(ListNode prev, ListNode toInsert, ListNode next){
        prev.next = toInsert;
        toInsert.next = next;
    }
}