/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy=new Node(0);
        Map<Node,Node> copy=new HashMap<>();
        Node ptr=head;
        Node copyPtr=dummy;
        while(ptr!=null){
            copyPtr.next=new Node(ptr.val);
            copy.put(ptr,copyPtr.next);
            ptr=ptr.next;
            copyPtr=copyPtr.next;
        }
        ptr=head;
        copyPtr=dummy.next;
        while(ptr!=null){
            copyPtr.random= copy.get(ptr.random);
            ptr=ptr.next;
            copyPtr=copyPtr.next;
        }
        return dummy.next;
    }
}
