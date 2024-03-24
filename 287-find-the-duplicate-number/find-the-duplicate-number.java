class Solution {

    // Can be DOne Using 2 pointer floyd Fast And slow also 

    // M1->using Sorting ->Time Complexity: O(nlog⁡n)O(n \log n)O(nlogn) -->Space Complexity: O(log⁡n)O(\log n)O(logn) or O(n)O(n)O(n)
    // =================================================================================================================================
    // M2->Time Complexity: O(n)O(n)O(n)  -->Space Complexity: O(n)O(n)O(n)
    // public int findDuplicate(int[] nums) {
    //     HashSet hs = new HashSet<>();
    //     int ele = -1;
    //     for (int i : nums) {
    //         if (!hs.contains(i)) {
    //             hs.add(i);
    //         } else {
    //             ele = i;
    //             break;
    //         }
    //     }
    //     return ele;
    // }
    // =====================================================================================================================================M3 using Cyclic Sort
    public int findDuplicate(int[] arr) {
        CycleSort(arr, arr.length);
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return arr[i];

            }
        }

        return -1;
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


