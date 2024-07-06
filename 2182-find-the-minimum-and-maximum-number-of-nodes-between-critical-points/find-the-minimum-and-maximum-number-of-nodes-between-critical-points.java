class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] { -1, -1 };
        }

        ListNode prev = head, curr = head.next, next = head.next.next;
        int index = 1;
        List<Integer> criticalPoints = new ArrayList<>();

        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                criticalPoints.add(index);
            }
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        if (criticalPoints.size() < 2) {
            return new int[] { -1, -1 };
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < criticalPoints.size(); i++) {
            minDist = Math.min(minDist, criticalPoints.get(i) - criticalPoints.get(i - 1));
        }

        int maxDist = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        return new int[] { minDist, maxDist };
    }
}
