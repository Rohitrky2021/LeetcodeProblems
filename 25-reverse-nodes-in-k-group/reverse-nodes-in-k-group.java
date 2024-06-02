class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = getLength(head);
        int loops = n / k;

        n = n - n % k;
        ListNode dummy = head;
        ListNode prevTail = null;
        
        for (int i = 0; i < loops; i++) {
            int m = 0;
            ListNode prev = null;
            ListNode curr = dummy;
            ListNode next;
            
            // Reverse the current group of k nodes
            while (m < k && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                m++;
            }
            
            // Connect the end of the reversed sublist with the next sublist
            if (prevTail != null) {
                prevTail.next = prev;
            } else {
                head = prev;
            }
            
            // Update pointers for the next iteration
            prevTail = dummy;
            dummy = curr;
        }
        
        // Connect the tail of the last reversed sublist with the remaining nodes
        if (prevTail != null) {
            prevTail.next = dummy;
        }
        
        return head;
    }

    public int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        
        // Traverse the LinkedList and count the nodes
        while (current != null) {
            length++;
            current = current.next;
        }
        
        return length;
    }
}
