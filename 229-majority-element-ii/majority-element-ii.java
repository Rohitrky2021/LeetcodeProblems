import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        if (n == 0) {
            return Arrays.asList(); // Return an empty list if the input is empty
        }

        int threshold = n / 3;

        // Use Java streams to filter elements that occur more than n/3 times
        List<Integer> ans = Arrays.stream(nums)
                .boxed() // Convert int to Integer for stream operations
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() > threshold)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return ans;
    }
}
