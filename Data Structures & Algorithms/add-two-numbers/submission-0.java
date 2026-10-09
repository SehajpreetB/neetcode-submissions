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
        int carry=0;
        ListNode dummy=new ListNode(0);
        ListNode ptr=dummy;
        while(l1!=null && l2!=null){
            int sum= l1.val+ l2.val+ carry;
            carry=sum/10;
            ptr.next=new ListNode(sum%10);
            ptr=ptr.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum = l1.val+carry;
            carry=sum/10;
            ptr.next=new ListNode(sum%10);
            l1=l1.next;
            ptr=ptr.next;
        }
        while(l2!=null){
            int sum = l2.val+carry;
            carry=sum/10;
            ptr.next=new ListNode(sum%10);
            l2=l2.next;
            ptr=ptr.next;
        }
        if(carry!=0){
            ptr.next=new ListNode(carry);
        }
        return dummy.next;
    }
}
