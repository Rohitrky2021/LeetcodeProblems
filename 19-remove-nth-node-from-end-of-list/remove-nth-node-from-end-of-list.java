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
    /**
     * Removes the nth node from the end of the linked list.
     * 
     * @param head The head of the linked list.
     * @param n    The position of the node to remove from the end.
     * @return     The head of the updated linked list after removing the nth node from the end.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) return null;

        int len = 0; // Variable to store the length of the list
        ListNode check = head; // Pointer to traverse the list for length calculation
        ListNode st = head; // Pointer to find the node before the one to be removed

        // Calculate the length of the list
        while (check != null) {
            check = check.next;
            len++;
        }

        // If the node to remove is the first node
        if (n - len + 1 == 1) return head.next;

        // Move to the node before the one to be removed
        int i = 1;
        while (i != len - n + 1 - 1 && st.next != null) {
            st = st.next;
            i++;
        }

        // Remove the nth node from the end
        if (st.next != null)
            st.next = st.next.next;
        else
            st.next = null;

        return head;
    }
}
