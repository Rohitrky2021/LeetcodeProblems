class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the link

            // Move pointers one step forward
            prev = current;
            current = next;
        }

        return prev; // prev will be the new head of the reversed list
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Reverse the input linked lists
        ListNode reversedL1 = reverseList(l1);
        ListNode reversedL2 = reverseList(l2);

        // Perform the addition of reversed linked lists
        ListNode result = null;
        ListNode current = null;
        int carry = 0;

        while (reversedL1 != null || reversedL2 != null || carry > 0) {
            int sum = carry;

            if (reversedL1 != null) {
                sum += reversedL1.val;
                reversedL1 = reversedL1.next;
            }

            if (reversedL2 != null) {
                sum += reversedL2.val;
                reversedL2 = reversedL2.next;
            }

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);

            if (result == null) {
                result = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }

        // Reverse the result linked list to get the final answer
        return reverseList(result);
    }
}
