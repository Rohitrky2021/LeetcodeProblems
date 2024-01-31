class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> ss = new Stack<>();
        // int arr[] = { 6, 8, 0, 1, 3 };
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!ss.isEmpty() && arr[ss.peek()] <= arr[i]) {
                ss.pop();
            }
            if (ss.isEmpty()) {
                // ss.push(-1);
                ans.add(0);
            } else {
                ans.add( ss.peek()-i);
            }
            ss.push(i);// index se check krenge value
        }

        int anss[] = new int[arr.length];
        for (int i =0; i<ans.size(); i++) {
            // System.out.print(ans.get(i) + " ");
            anss[ans.size()-i-1]=ans.get(i);
        }


        return anss;

    }
}