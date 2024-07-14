class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Convert int[] to Set<Integer>
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        ListNode dummy = new ListNode(0); // Create a dummy node to handle edge cases easily
        dummy.next = head;
        ListNode temp = dummy;
        
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next; // Skip the node
            } else {
                temp = temp.next; // Move to the next node
            }
        }
        
        return dummy.next;
    }
}
