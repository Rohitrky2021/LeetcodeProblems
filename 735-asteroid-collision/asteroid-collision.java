import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int curr = Math.abs(asteroids[i]);

            while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0 && Math.abs(stack.peek()) < curr) {
                stack.pop();
            }

            if (stack.isEmpty() || asteroids[i] > 0 || stack.peek() < 0) {
                stack.push(asteroids[i]);
            } else if (stack.peek() == -curr) {
                stack.pop();
            } else if (curr == Math.abs(stack.peek())) {
                stack.pop(); // Remove the previous asteroid from the stack
                continue;    // Skip the current asteroid as well
            }
        }

        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        return result;
    }
}
