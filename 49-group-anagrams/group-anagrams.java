class Solution {

public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
        int[] charCount = new int[26]; // Count the occurrences of each character in the string
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++; // Increment the count for the character
        }

        StringBuilder keyBuilder = new StringBuilder();
        for (int count : charCount) {
            keyBuilder.append('#').append(count); // Create a unique key for anagrams
        }
        String key = keyBuilder.toString();

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>()); // Initialize a list for the anagram group
        }
        map.get(key).add(s); // Add the string to its corresponding anagram group
    }

    ans.addAll(map.values()); // Add all anagram groups to the final result

    return ans;
}

}
