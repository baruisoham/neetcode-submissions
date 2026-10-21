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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return getNumber(l1, l2);

        // return getLL(sum);

    }

    private ListNode getNumber(ListNode l1, ListNode l2){
        // int num1 = 0;
        // int num2=0;
        // int count1=0;
        // int count2=0;
        // while(l1!=null || l2!=null){
        //     if(l1!=null){
        //         num1 += + l1.val*Math.pow(10,count1);
        //         l1 = l1.next;
        //         count1++;
        //     }
        //     if(l2!=null){
        //         num2 += l2.val*Math.pow(10, count2);
        //         l2 = l2.next;
        //         count2++;
        //     }
        // }
        // return num1+num2;

        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        int carry=0;
        int sum = 0;
        int count = 0;
        while(l1!=null || l2!=null || carry!=0){
            int val1 = 0;
            if(l1!=null){
                val1= l1.val;
                l1=l1.next;
            }
            int val2 = 0;
            if(l2!=null){
                val2 = l2.val;
                l2=l2.next;
            }
            sum = (val1+val2) + carry;
            carry = sum/10;
            sum = sum%10;
            count++;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;

        }

        return dummy.next;
    }


    // private ListNode getLL(long num){
    //     ListNode dummy = new ListNode(-1);
    //     ListNode ptr = dummy;
    //     do{

    //         ptr.next = new ListNode((int)num%10);
    //         num=num/10;
    //         ptr=ptr.next;

    //     }while(num!=0);
    //     return dummy.next;
    // }
}
