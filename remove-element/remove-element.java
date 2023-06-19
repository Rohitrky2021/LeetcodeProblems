class Solution {

    public int removeElement(int[] nums, int val) {
        // if (nums.length == 0) {
        //     return 0;
        // }

        int uniqueCount = 0; // Number of unique elements found
        int currentIndex = 0; // Current index to place the next unique element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            // }else{
                uniqueCount++;

            }

        }

        return uniqueCount;
    }
}
