import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private static class Check {
        int curr;
        int real;

        public Check(int[] asteroids, int n) {
            this.curr = Math.abs(asteroids[n]);
            this.real = asteroids[n];
        }
    }

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
                stack.pop(); // Pop the element from the stack, as both asteroids cancel each other out.
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
