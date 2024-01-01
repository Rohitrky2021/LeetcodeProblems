import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] arr) {
        cycleSort(arr, arr.length);
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return i + 1;
    }

    public void swap(int[] arr, int i, int correctpos) {
        // swap elements with their correct indexes
        int temp = arr[i];
        arr[i] = arr[correctpos];
        arr[correctpos] = temp;
    }

    public void cycleSort(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            int correctpos = arr[i] - 1;
            if (correctpos < n && correctpos >= 0 && arr[i] != arr[correctpos]) {
                swap(arr, i, correctpos);
            } else {
                i++;
            }
        }
        System.out.println("After sort : ");
        System.out.println(Arrays.toString(arr));
    }
}

class Solution1 {
    public int firstMissingPositive(int[] nums) {
    
        //the first two conditions in the if statement take care 
        //that negatives and elements greater than the size of 
        //the array are ignored, while applying cycle sort, and 
        //rest is the similar code of cycle sort

        int i = 0;
        while(i < nums.length) {
            int correct = nums[i] - 1;
            if(nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[correct]) {

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else {
                i++;
            }
        }

        int count = 0;

    //after cycle sort has been applied, we will find the first element
    //which is not at the correct index, and return that index + 1

    System.out.print(Arrays.toString(nums));

        for(int j = 0; j < nums.length; j++) {

            if(nums[j] != j + 1) {
                return j + 1;
            }
        }

    //if every element is at its correct index, then obviously the first
    //missing positive integer is nums.length + 1

        return nums.length + 1;
    }
}