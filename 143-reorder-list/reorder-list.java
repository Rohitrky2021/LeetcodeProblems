class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Merge the first half and the reversed second half alternately
        ListNode start = head;
        ListNode end = prev;
        while (end != null) {
            ListNode temp1 = start.next;
            ListNode temp2 = end.next;
            start.next = end;
            start = temp1;
            end.next = start;
            end = temp2;
        }
    }
}