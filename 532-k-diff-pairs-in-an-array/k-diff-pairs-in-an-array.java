class Solution1 {
    public int findPairs(int[] A, int B) {
        int c=0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i] + B) || set.contains(A[i] - B)) {
               c++;
            }
            set.add(A[i]);
        }

        return c;
    }
}

 

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0; // Since k cannot be negative, there won't be any valid pairs.
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> pairs = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num - k)) {
                pairs.add(num - k);
            }
            if (set.contains(num + k)) {
                pairs.add(num);
            }
            set.add(num);
        }

        return pairs.size();
    }
}
