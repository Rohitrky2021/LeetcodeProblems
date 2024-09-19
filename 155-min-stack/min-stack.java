import java.util.*;

class MinStack {
    private Stack<Integer> stack; // Stack to store the elements
    private PriorityQueue<Integer> minHeap; // PriorityQueue to store the elements in sorted order

    public MinStack() {
        stack = new Stack<>();
        minHeap = new PriorityQueue<>(); // Min-Heap for retrieving the minimum element efficiently
    }

    public void push(int val) {
        stack.push(val);        // Push element to the stack
        minHeap.add(val);       // Also add the element to the min-heap
    }

    public void pop() {
        int val = stack.pop();  // Pop element from the stack
        minHeap.remove(val);    // Remove the same element from the min-heap
    }

    public int top() {
        return stack.peek();    // Get the top element of the stack
    }

    public int getMin() {
        return minHeap.peek();  // Get the smallest element from the min-heap
    }
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(2);

        System.out.println("Top element: " + minStack.top());    // Output: 2
        System.out.println("Minimum element: " + minStack.getMin());  // Output: 2

        minStack.pop();
        System.out.println("Top element after pop: " + minStack.top());  // Output: 7
        System.out.println("Minimum element after pop: " + minStack.getMin());  // Output: 3
    }
}
