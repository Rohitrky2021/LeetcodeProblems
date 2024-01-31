class Solution {
    public int[] dailyTemperatures(int[] arr) {
        // Stack<Integer> ss = new Stack<>();
        // int n = arr.length;
        // int[] anss = new int[n];

        // for (int i = n - 1; i >= 0; i--) {
        // while (!ss.isEmpty() && arr[ss.peek()] <= arr[i]) {
        // ss.pop();
        // }
        // if (ss.isEmpty()) {
        // anss[i] = 0;
        // } else {
        // anss[i] = ss.peek() - i;
        // }
        // ss.push(i);
        // }

        // return anss;

        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;

    }
}