class Solution {
    public int reductionOperations2(int[] nums) {
          int operations = 0;

        while (!areAllEqual(nums)) {
            int maxIndex = findMaxIndex(nums);
            int nextLargest = findNextLargest(nums, maxIndex);

            nums[maxIndex] = nextLargest;
            operations++;
        }

        return operations;
    }

    private static boolean areAllEqual(int[] nums) {
        return Arrays.stream(nums).distinct().count() == 1;
    }

    private static int findMaxIndex(int[] nums) {
        return IntStream.range(0, nums.length).reduce((i, j) -> nums[i] >= nums[j] ? i : j).orElse(-1);
    }

    private static int findNextLargest(int[] nums, int currentIndex) {
        int currentValue = nums[currentIndex];
        return Arrays.stream(nums)
                .filter(e -> e < currentValue)
                .reduce((a, b) -> a > b ? a : b)
                .orElse(Integer.MIN_VALUE);
    }

    // ========================================
    public int reductionOperations(int[] n) {
    int res = 0, sz = n.length;
    Arrays.sort(n);
    for (int j = sz - 1; j > 0; --j)
        if (n[j - 1] != n[j])
            res += sz - j;
    return res;
}

}