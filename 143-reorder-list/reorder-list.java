 
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
        ListNode p1 = head;
        ListNode p2 = prev;
        while (p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p1 = temp1;
            p2.next = temp1;
            p2 = temp2;
        }
    }
}
