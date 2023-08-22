class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        // Map to store anagrams as lists of strings
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray); // Sort the characters to identify anagrams
            String sortedStr = new String(charArray);

            // Check if the sorted string is already in the map
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(s); // Add the original string to the anagram group
        }

        // Add all anagram groups to the final result
        ans.addAll(anagramMap.values());

        return ans;
    }
}
