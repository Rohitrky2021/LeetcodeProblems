class Solution {
    public String getSmallestString(String s) {
        char[] nums = s.toCharArray(); // Fix the variable type and initialization
        
        for(int i = 0; i < nums.length - 1; i++) { // Fix the loop and variable declaration
            if(((nums[i] ^ nums[i+1]) & 1) == 0  &&  nums[i+1] <nums[i]) { // Fix the condition logic
                swap(nums, i, i+1); // Use a swap method to swap the characters
                break;
            }
        }
        
        return new String(nums); // Convert char array back to String
    }
    
    // Define the swap method
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
