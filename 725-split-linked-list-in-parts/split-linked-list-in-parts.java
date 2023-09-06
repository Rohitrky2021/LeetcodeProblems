class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode s1 = head;

        while (s1 != null) {
            s1 = s1.next;
            size++;
        }

        int partSize = size / k;
        int remainder = size % k;

        ListNode[] ans = new ListNode[k];
        ListNode current = head;
        int i = 0;

        while (i < k) {
            ans[i] = current;

            int partNodeCount = partSize + (i < remainder ? 1 : 0);// Remainder is there Stariting ONes Ko  
            // starting waalo ko Jaada hua tho de denge  
            

            for (int j = 1; j < partNodeCount; j++) {
                current = current.next;
            }
            if (current != null) {
            ListNode nextNode = current.next;
            current.next = null;
            
            // Move the current pointer to the next node
            current = nextNode;
            }
            i++;
        }

        return ans;
    }
}
