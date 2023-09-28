class Solution {

    // M1 --> Beat 83% of ans
    // public int[] sortArrayByParity(int[] nums) {
    //     int i = 0, j = 0;
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     for (int num : nums) {
    //         ans.add(num);
    //     }
    //     while (i < nums.length) {
    //         if (nums[i] % 2 == 0) {
    //             Collections.swap(ans, i, j);
    //             i++;
    //             j++;
    //             continue;
    //         }
    //         i++;
    //     }
    //     int[] arr = new int[ans.size()];
    //     for (int k = 0; k < ans.size(); k++) {
    //         arr[k] = ans.get(k);
    //     }
    //     return arr;
    // }

// M1.2--> Optimised for Space for the above one 
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = 0;

        while (i < nums.length) {
            if (nums[i] % 2 == 0) {
                // Swap the even number at position i with the number at position j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
                continue;
            }
            i++;
        }

        return nums;
    }

    // M2 --> Wihtout Swaping
    // public int[] sortArrayByParity(int[] nums) {
    //     int[] result = new int[nums.length];
    //     int evenIndex = 0;
    //     int oddIndex = nums.length - 1;

    //     for (int num : nums) {
    //         if (num % 2 == 0) {
    //             result[evenIndex] = num;
    //             evenIndex++;
    //         } else {
    //             result[oddIndex] = num;
    //             oddIndex--;
    //         }
    //     }

    //     return result;
    // }
}
