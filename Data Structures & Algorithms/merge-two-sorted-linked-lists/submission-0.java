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
        ListNode ansHead= new ListNode(0);
        ListNode ansPtr= ansHead;
        ListNode ptr1=list1;
        ListNode ptr2=list2;

        while(ptr1!=null && ptr2!=null){
            if(ptr1.val < ptr2.val){
                ansPtr.next= ptr1;
                ptr1=ptr1.next;
            }
            else{
                ansPtr.next= ptr2;
                ptr2=ptr2.next;
            }
            ansPtr=ansPtr.next;
        }
        while(ptr1!=null){
            ansPtr.next= ptr1;
            ptr1=ptr1.next;
            ansPtr=ansPtr.next;
        }
        while(ptr2!=null){
            ansPtr.next= ptr2;
            ptr2=ptr2.next;
            ansPtr=ansPtr.next;
        }
        return ansHead.next;        
}
}