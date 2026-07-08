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
    public ListNode reverseKGroup(ListNode head, int k) {
        // ans-> prev3>2>GE1>P4>5>6>7>8>Ans9> 11>10, k=3

        ListNode ptr=head;
        ListNode ansHead=new ListNode();
        ListNode ans=ansHead;

        while(ptr!=null){
            int i=0;
            ListNode groupEnd=ptr;
            ListNode prev=null;
            while(i<k && ptr!=null){
                ListNode curr=ptr;
                ptr=ptr.next;
                curr.next=prev;
                prev=curr;
                i++;
            }
            if(i<k){
                ListNode p= prev;
                prev= null;
                while(p!=null){
                    ListNode curr= p;
                    p=p.next;
                    curr.next=prev;
                    prev=curr;
                }
                ans.next=prev;
                break;
            }
            groupEnd.next= ptr;
            ans.next=prev;
            ans=groupEnd;
        }
        return ansHead.next;
    }
}
