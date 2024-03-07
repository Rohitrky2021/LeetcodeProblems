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
    public ListNode middleNode(ListNode head) {
        if(head==null)return null;
        ListNode s=head,f=head;

        while(  f!=null && s!=null &&  f.next!=null){
            s=s.next;
           if(f.next!=null) f=f.next.next;
        }

        return s;
    }
}