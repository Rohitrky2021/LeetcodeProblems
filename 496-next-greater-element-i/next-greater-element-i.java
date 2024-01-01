import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] ngl = new int[n];
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();

        // Find the next greater element for each element in nums2
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nextGreaterMap.put(nums2[i], st.peek());
            } else {
                nextGreaterMap.put(nums2[i], -1);
            }
            st.push(nums2[i]);
        }

        // Create the result array for nums1 using the nextGreaterMap
        int m = nums1.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}
