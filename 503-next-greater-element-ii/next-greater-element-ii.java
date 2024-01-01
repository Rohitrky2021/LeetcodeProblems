class Solution {
    public int[] nextGreaterElements(int[] nums) {
         int n = nums.length;
        int ngl[] = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 2*n - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= nums[i%n]) {
                st.pop();
            }
            if (st.size() > 0) {
                ngl[i%n] = st.peek();
            } else {
                ngl[i%n] = -1;
            }

            st.push(nums[i%n]);
        }

        return ngl;

    

    }
}