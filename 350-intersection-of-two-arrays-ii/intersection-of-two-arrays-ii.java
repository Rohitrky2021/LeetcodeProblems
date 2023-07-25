class Solution {
    // public int[] intersect(int[] nums1, int[] nums2) {
         public int[] intersect(int[] nums1, int[] nums2) {
         HashMap<Integer, Integer> freqMap1 = new HashMap<>();
        HashMap<Integer, Integer> freqMap2 = new HashMap<>();

        // Populate freqMap1 with the frequency of elements in nums1
        for (int num : nums1) {
            freqMap1.put(num, freqMap1.getOrDefault(num, 0) + 1);
        }

        // Populate freqMap2 with the frequency of elements in nums2
        for (int num : nums2) {
            freqMap2.put(num, freqMap2.getOrDefault(num, 0) + 1);
        }

        // Find the common elements that exist in both freqMap1 and freqMap2
        List<Integer> commonElements = new ArrayList<>();
        for (int num : freqMap1.keySet()) {
            if (freqMap2.containsKey(num)) {
                int minFrequency = Math.min(freqMap1.get(num), freqMap2.get(num));
                for (int i = 0; i < minFrequency; i++) {
                    commonElements.add(num);
                }
            }
        }

        // Convert the list of common elements to an array
        int[] output = new int[commonElements.size()];
        for (int i = 0; i < commonElements.size(); i++) {
            output[i] = commonElements.get(i);
        }

        return output;
    }
    // }
}