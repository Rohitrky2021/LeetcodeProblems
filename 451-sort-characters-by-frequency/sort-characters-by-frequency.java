class Solution {  // NOT WORKING SOLUITON BUT NYC TRY 
    public String frequencySort(String s) {
      int[][] charFreq = new int[256][2]; // Extend to cover ASCII range
        for (char c : s.toCharArray()) {
            charFreq[c][0] = c; // Store the character
            charFreq[c][1]++;    // Increment the frequency
        }

        Arrays.sort(charFreq, (a, b) -> b[1] - a[1]); // Sort by frequency in descending order

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 256 && charFreq[i][1] > 0; i++) {
            char c = (char) charFreq[i][0];
            int freq = charFreq[i][1];
            for (int j = 0; j < freq; j++) {
                ans.append(c); // Append the character 'freq' times
            }
        }

        return ans.toString();
    }
}



class Solution2 {
    public String frequencySort(String s) {
       char[] str=s.toCharArray();
        int[] freq=new int[128];
        // for(char ch:s) freq[ch]++;
        for(int i=0;i<str.length;i++) freq[str[i]]++;
        for(int i=0;i<str.length;){
            char cmax=',';
            for(int j=0;j<128;j++){
                if(freq[j]>freq[cmax]) cmax=(char)j;
            }
            while(freq[cmax]!=0){
                str[i++]=cmax;
                freq[cmax]--;
            }
        }
        return new String(str);
    }
}
 

class Solution3 {
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
