class Solution {

    public int[] findErrorNums(int[] arr) {
        // Integer[] real = ans.toArray(new Integer[0]);
        List<Integer> ans = new ArrayList<>();
        CycleSort(arr, arr.length);
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                // return i;
                ans.add(arr[i]);
                ans.add(i+1);
            }
        }
        int[] real = new int[ans.size()];
        for (i = 0; i < ans.size(); i++) {
            real[i] = ans.get(i);
        }
        if (ans.isEmpty()) {
            // ans.add(i);
        }
        return real;
    }

    static void CycleSort(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            int correctpos = arr[i] - 1;
            if (arr[i] <= n && arr[i] != arr[correctpos]) {
                swap(arr, i, correctpos);
            } else {
                i++;
            }
        }
        System.out.println("After sort : ");
        System.out.print(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int correctpos) {
        // swap elements with their correct indexes
        int temp = arr[i];
        arr[i] = arr[correctpos];
        arr[correctpos] = temp;
    }
}
