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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode start = null;
        ListNode prev = null;
        ListNode curr = head;

        // Find the node just before the left position
        while (i < left) {
            i++;
            prev = curr;
            curr = curr.next;
        }
        
        ListNode beforeStart = prev; // Store the node before the reversed sublist
        ListNode end = curr; // Store the node at the left position
        
        // Reverse the sublist
        while (i >= left && i <= right) {
            i++;
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Connect the reversed sublist with the rest of the list
        if (beforeStart != null) {
            beforeStart.next = prev;
        } else {
            head = prev; // If reversing from the beginning, update head
        }
        
        end.next = curr; // Connect the end of reversed sublist with the rest
        
        return head;
    }
}

// class Solution {

//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         int i = 1;
//         ListNode start = null;
//         ListNode s2 = null;
//         ListNode prev = null;
//         ListNode curr =head;
//         ListNode next;
//         while(i<left){
//             i++;
//             prev=curr;
//             curr=curr.next;
//         }
//             start=curr;
//             s2=start.next;
//         while (i>=left && i<=right) {
//             i++;
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
//         start.next=prev;
//         s2.next=curr;
//         return head;
//     }
// }

// Changes and explanations:

// Moved the start and s2 initialization outside the first loop, as it needs to be set once when left is reached.
// Added a beforeStart variable to store the node just before the reversed sublist so that it can be properly connected after reversing.
// Stored the node at the left position in the end variable, which is used to connect the end of the reversed sublist with the rest of the list.
// Added a condition to handle the case when reversing from the beginning of the list, updating the head reference.
// Improved variable naming for clarity.
// This corrected code should now correctly reverse the sublist between positions left and right in a singly-linked list.
