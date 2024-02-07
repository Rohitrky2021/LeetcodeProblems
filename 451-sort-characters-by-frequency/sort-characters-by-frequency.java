class Solution1 {  // NOT WORKING SOLUITON BUT NYC TRY 
    public String frequencySort(String s) {
        int[] count = new int[100];
        String ans="";
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }

 
        for(int i=0;i<count.length;i++){
            while(count[i]!=0){
             ans+=(char) (i+ 'A');
             count[i]--;
            }
        }

    return ans;
    }
}
 

class Solution {
    public String frequencySort(String s) {
        // Map to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Count frequencies of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a list of characters and sort them by frequency
        List<Character> characters = new ArrayList<>(frequencyMap.keySet());
        characters.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        // Build the sorted string
        StringBuilder sortedString = new StringBuilder();
        for (char c : characters) {
            int frequency = frequencyMap.get(c);
            for (int i = 0; i < frequency; i++) {
                sortedString.append(c);
            }
        }

        return sortedString.toString();
    }
}
