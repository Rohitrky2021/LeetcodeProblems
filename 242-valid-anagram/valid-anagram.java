class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c: t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}



// class Solution {

//     public boolean isAnagram(String s, String s2) {
//         if (s.length() != s2.length()) {
//             return false;
//         }
//         HashMap<Character, Integer> map = new HashMap<>();

//         for (int i = 0; i < s.length(); i++) {
//             if (map.containsKey(s.charAt(i))) {
//                 map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//             } else {
//                 map.put(s.charAt(i), 1);
//             }
//         }

//         for (int i = 0; i < s2.length(); i++) {
//             if (map.containsKey(s2.charAt(i))) {
//                 map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
//             if (map.get(s2.charAt(i)) == 0) {
//                 map.remove(s2.charAt(i));
//             }
//             } else {
//                 return false;
//             }
//         }

//         return map.isEmpty();
//     }
// }
// import java.util.HashMap;

// class Solution {

//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }
        
//         HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
//         // Count characters in string s
//         for (char c : s.toCharArray()) {
//             frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
//         }
        
//         // Compare character frequencies with string t
//         for (char c : t.toCharArray()) {
//             if (!frequencyMap.containsKey(c)) {
//                 return false;
//             }
//             frequencyMap.put(c, frequencyMap.get(c) - 1);
//             if (frequencyMap.get(c) == 0) {
//                 frequencyMap.remove(c);
//             }
//         }
        
//         return frequencyMap.isEmpty();
//     }
// }
