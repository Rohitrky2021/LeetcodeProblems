import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution1 {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                a.add(nums[i]);
            } else {
                b.add(nums[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = a.get(0);
                a.remove(0);
            } else {
                nums[i] = b.get(0);
                b.remove(0);
            }
        }

        return nums;
    }

    // If you want to use Queue instead
    // public int[] rearrangeArrayWithQueue(int[] nums) {
    //     Queue<Integer> queue = new LinkedList<>();

    //     for (int num : nums) {
    //         if (num > 0) {
    //             queue.offer(num);
    //         }
    //     }

    //     for (int i = 0; i < nums.length; i += 2) {
    //         nums[i] = queue.poll();
    //     }

    //     for (int i = 1; i < nums.length; i += 2) {
    //         nums[i] = queue.poll();
    //     }

    //     return nums;
    // }
}

 
class Solution {
    // If you want to use Queue instead
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positives = new LinkedList<>();
        Queue<Integer> negatives = new LinkedList<>();

        for (int num : nums) {
            if (num > 0) {
                positives.offer(num);
            } else {
                negatives.offer(num);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (!positives.isEmpty()) {
                    nums[i] = positives.poll();
                } else {
                    nums[i] = negatives.poll();
                }
            } else {
                if (!negatives.isEmpty()) {
                    nums[i] = negatives.poll();
                } else {
                    nums[i] = positives.poll();
                }
            }
        }

        return nums;
    }
}
