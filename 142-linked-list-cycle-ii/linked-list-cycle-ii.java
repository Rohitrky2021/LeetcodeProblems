public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        if (!hasCycle) {
            return null;
        }
        
        ListNode node1 = head;
        ListNode node2 = fast;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        
        return node1;
    }
}
