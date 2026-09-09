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
    public ListNode reverseList(ListNode head) {
        ListNode prev= null;
        ListNode ptr= head;
        while(ptr!=null){
            ListNode temp =ptr;
            ptr=ptr.next;
            temp.next=prev;
            prev=temp;
        }
        return prev;
    }
}
