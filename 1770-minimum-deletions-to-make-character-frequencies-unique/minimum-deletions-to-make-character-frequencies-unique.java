class Solution {

    public int minDeletions(String s) {
        // Count character frequencies using a HashMap
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a HashSet to keep track of unique frequencies
        Set<Integer> uniqueFrequencies = new HashSet<>();

        int deletions = 0;
        for (int frequency : frequencyMap.values()) {
            while (uniqueFrequencies.contains(frequency)) {
                // If the frequency is not unique, decrement it until it's unique
                frequency--;
                deletions++;
            }
            if (frequency > 0) {
                uniqueFrequencies.add(frequency);
            }
        }

        return deletions;
    }
}
