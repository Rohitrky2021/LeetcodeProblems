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
        }  
         else if (curr == Math.abs(stack.peek())) {
            stack.pop(); // Pop the element from the stack, as both asteroids cancel each other out.
        }
    }

    int size = stack.size();
    int[] result = new int[size];
    
    // Correct indexing here
    for (int i = size - 1; i >= 0; i--) {
        result[i] = stack.pop();
    }

    return result;
}

}


class Solution1 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> qItems = new LinkedList<>();
        for (int ast : asteroids) {
            if (ast > 0) qItems.add(ast);
            else {
                while (!qItems.isEmpty() && qItems.peekLast() > 0 && qItems.peekLast() < -ast) {
                    qItems.pollLast();
                }

                if (!qItems.isEmpty() && qItems.peekLast() == -ast) {
                    qItems.pollLast();
                } else if (qItems.isEmpty() || qItems.peekLast() < 0){
                    qItems.add(ast);
                } 
            }
        }
        int[] res = new int[qItems.size()];
        for (int i = 0; i < res.length; i++) res[i] = qItems.pollFirst();
        return res;
    }
}