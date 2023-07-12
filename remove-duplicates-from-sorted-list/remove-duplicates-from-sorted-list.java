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
// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         ListNode temp=head.next;

//         ListNode ans=head;

//         while(temp!=null && head!=null){
//             // temp=head.next;


//             if(head.val==temp.val){
//                 head.next=head.next.next;
//                 temp=head.next;
//             }else{
//                 head.next=temp;
//                 temp=temp.next;
//             }
            
//         }
//             return ans;
        
//     }
// }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or contains only one element, no duplicates to remove
        }
        
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip the duplicate node
            } else {
                current = current.next; // Move to the next non-duplicate node
            }
        }
        
        return head;
    }
}
