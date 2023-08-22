// class Solution {
    
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> ans = new ArrayList<>();

//         // Map to store anagrams as lists of strings
//         HashMap<String, List<String>> anagramMap = new HashMap<>();

//         for (String s : strs) {
//             char[] charArray = s.toCharArray();
//             Arrays.sort(charArray); // Sort the characters to identify anagrams
//             String sortedStr = new String(charArray);

//             // Check if the sorted string is already in the map
//             if (!anagramMap.containsKey(sortedStr)) {
//                 anagramMap.put(sortedStr, new ArrayList<>());
//             }
//             anagramMap.get(sortedStr).add(s); // Add the original string to the anagram group
//         }

//         // Add all anagram groups to the final result
//         ans.addAll(anagramMap.values());

//         return ans;
//     }
// }
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> ans = new ArrayList<>();

//         // Map to store anagrams as lists of strings
//         HashMap<Long, List<String>> anagramMap = new HashMap<>();

//         // Prime numbers to use for hashing
//         int[] primes = {
//             2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
//             31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
//             73, 79, 83, 89, 97, 101
//         };

//         for (String s : strs) {
//             long hashValue = calculateHash(s, primes);

//             // Check if the hash value is already in the map
//             if (!anagramMap.containsKey(hashValue)) {
//                 anagramMap.put(hashValue, new ArrayList<>());
//             }
//             anagramMap.get(hashValue).add(s); // Add the string to the hash value group
//         }

//         // Add all hash value groups to the final result
//         ans.addAll(anagramMap.values());

//         return ans;
//     }

//     private long calculateHash(String s, int[] primes) {
//         long hash = 1;
//         for (char c : s.toCharArray()) {
//             hash *= primes[c - 'a']; // Use the prime number corresponding to the character
//         }
//         return hash;
//     }
// }
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            String hashKey = getHashKey(s);
            if (!anagramMap.containsKey(hashKey)) {
                anagramMap.put(hashKey, new ArrayList<>());
            }
            anagramMap.get(hashKey).add(s);
        }

        ans.addAll(anagramMap.values());

        return ans;
    }

    private String getHashKey(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        StringBuilder hashKey = new StringBuilder();
        for (int count : charCount) {
            hashKey.append('#').append(count);
        }
        return hashKey.toString();
    }
}

