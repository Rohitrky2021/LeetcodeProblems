import java.util.*;


 class Solution { // Greedy paased but no the below one only this 

    public int minimumPushes(String word) {
        // Frequency array to store count of each letter
        int[] frequency = new int[26];

        // Count occurrences of each letter
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Sort frequencies in descending order
        Arrays.sort(frequency);
        int[] sortedFrequency = new int[26];
        for (int i = 0; i < 26; i++) {
            sortedFrequency[i] = frequency[25 - i];
        }

        /*
        // Or do like this 
        // Sort frequencies in descending order
        Integer[] sortedFrequency = Arrays.stream(frequency).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedFrequency, (a, b) -> b - a);
        */

        int totalPushes = 0;

        // Calculate total number of presses
        for (int i = 0; i < 26; i++) {
            if (sortedFrequency[i] == 0) break;
            totalPushes += (i / 8 + 1) * sortedFrequency[i];
        }

        return totalPushes;
    }
}


class Solution3 {  // Using Priority Queue 

    public int minimumPushes(String word) {
        // Frequency map to store count of each letter
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each letter
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Priority queue to store frequencies in descending order
        PriorityQueue<Integer> frequencyQueue = new PriorityQueue<>(
            (a, b) -> b - a
        );
        frequencyQueue.addAll(frequencyMap.values());

        int totalPushes = 0;
        int index = 0;

        // Calculate total number of presses
        while (!frequencyQueue.isEmpty()) {
            totalPushes += (index / 8 + 1) * frequencyQueue.poll();
            index++;
        }

        return totalPushes;
    }
}

class Solution2 {
    public int minimumPushes(String word) {
        int[][] freq = new int[26][2];

        // Calculate frequency of each character
        for (char x : word.toCharArray()) {
            freq[x - 'a'][0] = x - 'a';
            freq[x - 'a'][1]++;
        }

        // Sort by frequency in descending order
        Arrays.sort(freq, (a, b) -> b[1] - a[1]);

        // Array of lists to store characters for each key
        List<Character>[] keys = new List[9];
        for (int i = 0; i < 9; i++) {
            keys[i] = new ArrayList<>();
        }

        int count = 0;

        // Assign the first 9 characters to buttons 0-8
        for (int i = 0; i < 9 && freq[i][1] != 0; i++) {
            keys[count].add((char) (freq[i][0] + 'a'));
            count++;
        }

        // Assign the remaining characters to buttons 8-0 in reverse order
        count = 8;
        for (int i = 8; i < freq.length && freq[i][1] != 0; i++) {
            keys[count].add((char) (freq[i][0] + 'a'));
            count--;
            if (count ==1) count = 8; // Wrap around to 8
        }

        // Create a HashMap to store the pushes needed for each character
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < keys[i].size(); j++) {
                hm.put(keys[i].get(j), j + 1);
            }
        }

        int ans = 0;

        // Calculate the total pushes required
        for (char x : word.toCharArray()) {
            ans += hm.get(x);
        }

        // Print the intermediate data
        System.out.println("Frequency array (sorted):");
        for (int i = 0; i < 26; i++) {
            if (freq[i][1] != 0) {
                System.out.println((char)(freq[i][0] + 'a') + ": " + freq[i][1]);
            }
        }

        System.out.println("\nKeys assignment:");
        for (int i = 0; i < 9; i++) {
            System.out.print("Key " + (i + 2) + ": ");
            for (char ch : keys[i]) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }

        System.out.println("\nHashMap (character -> pushes):");
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nTotal pushes: " + ans);

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Minimum pushes: " + sol.minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}


