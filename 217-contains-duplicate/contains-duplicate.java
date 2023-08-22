import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Found a duplicate
            }
            else{seen.add(num); }// Add the number to the HashSet
        }
        
        return false; // No duplicates found
    }
}