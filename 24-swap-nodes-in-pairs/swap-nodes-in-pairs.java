class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) 
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode firstNode = curr.next;
            ListNode secondNode = curr.next.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            curr.next = secondNode;

            curr = firstNode;
        }

        return dummy.next;
    }
}

class Solution2 { // Wring one
    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next==null)return head;

        // int check=i

        ListNode curr=head;
        ListNode frontNode=head.next;


        while(curr.next.next!=null ){
        
            curr.next=frontNode.next;
            frontNode.next=curr;
            frontNode=curr.next.next;
            curr=curr.next;        
       }

       return head;
        
    }

    
}