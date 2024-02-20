import java.util.Arrays;

public class Solution {
    // M2-->Using Cycle Sort
    public int missingNumber(int[] arr) {
        CycleSort(arr, arr.length);
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return i;
    }

    public void swap(int[] arr, int i, int correctpos) {
        // swap elements with their correct indexes
        int temp = arr[i];
        arr[i] = arr[correctpos];
        arr[correctpos] = temp;
    }

    public void CycleSort(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            int correctpos = arr[i];
            if (arr[i] < n && arr[i] != arr[correctpos]) {
                swap(arr, i, correctpos);
            } else {
                i++;
            }
        }
        System.out.println("After sort : ");
        System.out.print(Arrays.toString(arr));
    }

    // M1-->Using Bit
    public int missingNumber2(int[] arr) {
        int xor = 0 ^ 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        for (int i = 0; i < arr.length + 1; i++) {
            xor ^= i;
        }
        return xor;
    }

    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array is empty.");
        }
        int maxVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        return maxVal;
    }

    // M3--->Using the total expected sum formula  -->  TRICKY WAY 
    class Solution3 {
        public int missingNumber3(int[] nums) {
            int expectedSum = nums.length * (nums.length + 1) / 2;
            int actualSum = 0;
            for (int num : nums)
                actualSum += num;
            return expectedSum - actualSum;
        }
    }
}
