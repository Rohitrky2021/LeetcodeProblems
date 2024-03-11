import java.util.HashMap;

class Solution {

    class Pair{
        int k,v;

        public Pair (int k,int v){
            this.k=k;
            this.v=v;
        }
    }
    public String customSortString(String order, String s) {
        int[] freq = new int[26]; // Fixed declaration of integer array
        StringBuilder ans = new StringBuilder(""); // Fixed StringBuilder declaration

        int i = 0;
        for (char x : order.toCharArray()) { // Fixed iteration over order string
            freq[x - 'a'] = i;
            i++;
        }

        HashMap<Character, Pair> hs = new HashMap<>();

        for (char x : s.toCharArray()) {
            if(hs.containsKey(x)) {
                Pair pair = hs.get(x);
                hs.put(x, new Pair(pair.k, pair.v + 1)); // Incrementing the count for existing character
            } else {
                hs.put(x, new Pair(freq[x - 'a'], 1)); // Adding new character to the HashMap
            }
        }

        // Here's a simple approach to get sorted characters
        StringBuilder sortedString = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (hs.containsKey(c)) {
                while(hs.get(c).v != 0) {
                    sortedString.append(c);
                    hs.put(c, new Pair(hs.get(c).k, hs.get(c).v - 1));
                }
                hs.remove(c); // Removing the character after adding to the sorted string
            }
        }

        // Append the remaining characters (if any) from s which are not present in the custom order
        for (char key : hs.keySet()) {
            while(hs.get(key).v != 0) {
                sortedString.append(key);
                hs.put(key, new Pair(hs.get(key).k, hs.get(key).v - 1));
            }
        }

        return sortedString.toString();
    }
}
