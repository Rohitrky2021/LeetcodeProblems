import java.util.*;

class Solution {
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
