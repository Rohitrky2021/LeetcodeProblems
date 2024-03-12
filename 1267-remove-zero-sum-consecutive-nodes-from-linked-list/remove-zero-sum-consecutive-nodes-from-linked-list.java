import java.util.*;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        map.put(0, dummy); // Initial sum is 0 with the dummy node

        // Traverse the linked list to calculate the cumulative sum
        while (head != null) {
            sum += head.val;

            // If the current sum is found in the map, remove the sublist
            if (map.containsKey(sum)) {
                ListNode removeNode = map.get(sum).next;
                int tempSum = sum + removeNode.val;
                while (removeNode != head) {
                    map.remove(tempSum);
                    removeNode = removeNode.next;
                    tempSum += removeNode.val;
                }
                map.get(sum).next = head.next;
            } else {
                map.put(sum, head);
            }

            head = head.next;
        }

        return dummy.next;
    }
}
