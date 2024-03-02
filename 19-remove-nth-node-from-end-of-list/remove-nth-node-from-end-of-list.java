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
        if (head == null || head.next == null) return null;
        int len=0,i=1;
        ListNode  check=head,st=head;

        while(check!=null){
            check=check.next;
            len++;
        }
        if(n-len+1==1)return head.next;

        // From start it will be ( N- k+1){}

        while(i!=len-n+1-1 && st.next!=null ){
            st=st.next;
            i++;
        }

        if(st.next!=null)
                st.next=st.next.next;
        else st.next=null;        
        // while(i!=len-k+1-1){
        //     st=st.next;
        // }


        return head;
    }
}