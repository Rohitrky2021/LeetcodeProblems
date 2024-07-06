class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode travel = head.next;
        ListNode setter = head;

        int currsum = 0;

        while (travel != null) {
            if (travel.val == 0) {
                setter.val = currsum;
                setter.next = travel.next;
                setter = setter.next;
                currsum = 0;
            } else {
                currsum += travel.val;
            }
            travel = travel.next;
        }

        return head;
    }
}

class Solution1 {
    public ListNode mergeNodes(ListNode head) {
        ListNode travel = head.next;
        ListNode setter = head;

        int currsum = 0;

        while (travel != null) {
            if (travel.val == 0) {
                setter.val = currsum;
                if (travel.next != null) {
                    setter.next = travel;
                    setter = setter.next;
                } else {
                    setter.next = null; // Terminate the list at the last node
                }
                currsum = 0;
            } else {
                currsum += travel.val;
            }
            travel = travel.next;
        }

        return head;
    }
}
