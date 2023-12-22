class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            int s = i+1;
            int e = nums.length-1;
            
            while(s < e){
                int sum = nums[i] + nums[s] + nums[e];
                if(sum == 0){
                    set.add(List.of(nums[i], nums[s], nums[e]));
                }
                if(sum > 0) e--;
                else s++;
            }
            
        }
        return new ArrayList<>(set);
    }    
}
 

public class Solution {
    int len = 0;

    public List<List<Integer>> threeSum(int[] nums) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, 0, 3, 0);
    }

    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (index >= len) {
            return res;
        }
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                // find a pair
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]); // Fix: Add nums[j] instead of target-nums[i]
                    res.add(temp);
                    // skip duplication
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j - 1] == nums[j]) j--;
                    i++;
                    j--;
                    // move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++;
                    // move right bound
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                // use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if (temp != null) {
                    // add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    // skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }
}


// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();

//         // Sort the array
//         Arrays.sort(nums);

//         for (int i = 0; i < nums.length - 2; i++) {
//             // Skip duplicate elements for i
//             if (i > 0 && nums[i] == nums[i - 1]) {
//                 continue;
//             }

//             int j = i + 1;
//             int k = nums.length - 1;

//             while (j < k) {
//                 int sum = nums[i] + nums[j] + nums[k];

//                 if (sum == 0) {
//                     // Found a triplet with zero sum
//                     ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

//                     // Skip duplicate elements for j
//                     while (j < k && nums[j] == nums[j + 1]) {
//                         j++;
//                     }

//                     // Skip duplicate elements for k
//                     while (j < k && nums[k] == nums[k - 1]) {
//                         k--;
//                     }

//                     // Move the pointers
//                     j++;
//                     k--;
//                 } else if (sum < 0) {
//                     // Sum is less than zero, increment j to increase the sum
//                     j++;
//                 } else {
//                     // Sum is greater than zero, decrement k to decrease the sum
//                     k--;
//                 }
//             }
//         }
//         return ans;
//     }
// }