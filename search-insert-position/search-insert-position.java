class Solution {
    public int searchInsert(int[] nums, int target) {
        // Create a new array with the size of the original array plus one
        int[] newArray = new int[nums.length + 1];

        // Copy the contents of the original array to the new array
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i];
        }

        // Add the target element to the new array
        newArray[nums.length] = target;

        // Sort the new array
        Arrays.sort(newArray);

        // Find the index of the target element in the new array
        int index = Arrays.binarySearch(newArray, target);

        // If the target element is found and there are duplicate elements, 
        // find the index of the first occurrence of the target element
        if (index >= 0) {
            while (index > 0 && newArray[index - 1] == target) {
                index--;
            }
        }
        
        return index;
    }
}
