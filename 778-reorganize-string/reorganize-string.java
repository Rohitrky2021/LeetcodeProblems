// class Solution {

//     public String reorganizeString(String s) {
//         String ans = "";

//         char nums[] = s.toCharArray();
//         int[] charCount = new int[26]; // Assuming lowercase English letters

//         for (char c : nums) {
//             charCount[c - 'a']++;
//         }

//         return backtrack(charCount, ans, nums.length, '#');
//     }

//     private String backtrack(int[] charCount, String current, int remaining, char prevChar) {
//         if (remaining == 0) {
//             return current;
//         }

//         for (int i = 0; i < charCount.length; i++) {
//             if (charCount[i] > 0 && (char) (i + 'a') != prevChar) {
//                 charCount[i]--;
//                 char newChar = (char) (i + 'a');
//                 String newCurrent = current + newChar;
//                 String result = backtrack(charCount, newCurrent, remaining - 1, newChar);

//                 if (!result.equals("")) {
//                     return result;
//                 }

//                 charCount[i]++;
//             }
//         }
//         return "";
//     }
// }


class Solution {

    public String reorganizeString(String s) {
        String ans = "";

        int[] charCount = new int[26]; // Assuming lowercase English letters

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCount[b - 'a'] - charCount[a - 'a']);

        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                maxHeap.offer((char) ('a' + i));
            }
        }

        while (maxHeap.size() >= 2) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            ans += first;
            ans += second;

            if (--charCount[first - 'a'] > 0) {
                maxHeap.offer(first);
            }
            if (--charCount[second - 'a'] > 0) {
                maxHeap.offer(second);
            }
        }

        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (charCount[last - 'a'] > 1) {
                return ""; // Not possible to rearrange
            }
            ans += last;
        }

        return ans;
    }
}
