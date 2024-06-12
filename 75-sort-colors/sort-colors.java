class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;
        int zero = 0;
        int two = n - 1;

        for (int i = 0; i <= two; ) {
            if (arr[i] == 2) {
                // Swap arr[i] with arr[two]
                int temp = arr[i];
                arr[i] = arr[two];
                arr[two] = temp;
                two--;
                // Do not increment i here because the swapped element needs to be checked
            } else if (arr[i] == 0) {
                // Swap arr[i] with arr[zero]
                int temp = arr[i];
                arr[i] = arr[zero];
                arr[zero] = temp;
                zero++;
                i++;
            } else {
                // If it's 1, just move to the next element
                i++;
            }
        }
    }
}
