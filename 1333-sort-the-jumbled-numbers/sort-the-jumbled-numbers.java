import java.util.*;

class Solution1 {
    public int[] sortJumbled(int[] map, int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int x : nums) {
            int currscore = 0;
            String str = Integer.toString(x);
            for (int i = 0; i < str.length(); i++) {
                currscore = currscore * 10 + map[str.charAt(i) - '0'];
            }
            hm.put(x, currscore);
        }

        Integer[] sortedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedNums, (a, b) -> {
            int diff = hm.get(a) - hm.get(b);
          
                return diff;
          
        });

        return Arrays.stream(sortedNums).mapToInt(Integer::intValue).toArray();
    }
}


 
class Solution2 {
    public int[] sortJumbled(int[] map, int[] nums) {
        // Map to store the original number and its transformed value
        Map<Integer, Integer> transformedMap = new HashMap<>();

        for (int num : nums) {
            int transformedValue = 0;
            String str = Integer.toString(num);
            for (int i = 0; i < str.length(); i++) {
                transformedValue = transformedValue * 10 + map[str.charAt(i) - '0'];
            }

            
            transformedMap.put(num, transformedValue);
            
        }

        // Create a TreeMap with a custom comparator that sorts by transformed value and then by original value
        Map<Integer, Integer> sortedTransformedMap = new TreeMap<>((a, b) -> {
            return  transformedMap.get(a)-(transformedMap.get(b));
 
        });

        // Put all entries from the transformed map to the sorted transformed map
        sortedTransformedMap.putAll(transformedMap);

        // Build the result array
        int[] ans = new int[nums.length];
        int index = 0;
        for (Integer key : sortedTransformedMap.keySet()) {
            ans[index++] = key;
        }

        return ans;
    }
}


 

class Solution {
    public int[] sortJumbled(int[] map, int[] nums) {
        // List to store pairs of (original index, transformed value)
        List<int[]> transformedList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int transformedValue = 0;
            String str = Integer.toString(num);
            for (int j = 0; j < str.length(); j++) {
                transformedValue = transformedValue * 10 + map[str.charAt(j) - '0'];
            }
            transformedList.add(new int[]{i, transformedValue});
        }

        // Sort the list based on transformed value and then by original index
        transformedList.sort((a, b) -> {
            int compare = Integer.compare(a[1], b[1]);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(a[0], b[0]); // Maintain original order if transformed values are the same
            }
        });

        // Build the result array
        int[] ans = new int[nums.length];
        for (int i = 0; i < transformedList.size(); i++) {
            ans[i] = nums[transformedList.get(i)[0]];
        }

        return ans;
    }
}
