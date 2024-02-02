class Solution {
    public int largestRectangleArea(int[] arr) {
        return  maxRectangal(arr);
    }

    public static int maxRectangal(int arr[]) {
        int nextSmall[] = nextSmaller(arr);
        int preSmall[] = preSmaller(arr);

        int maxRectangal = 0;
        int curRectangal = 0;
        for (int i = 0; i < arr.length; i++) {
            curRectangal = arr[i] * (nextSmall[i] - preSmall[i] - 1);
            if (maxRectangal < curRectangal) {
                maxRectangal = curRectangal;
            }
        }
        return maxRectangal;
    }

    public static int[] nextSmaller(int arr[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = arr.length;
            } else {
                ans[i] = s.peek();
            }
            s.push(i);
        }
        // printArr(ans);
        return ans;

    }

    public static int[] preSmaller(int arr[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(i);
        }
        // printArr(ans);
        return ans;

    }

}
