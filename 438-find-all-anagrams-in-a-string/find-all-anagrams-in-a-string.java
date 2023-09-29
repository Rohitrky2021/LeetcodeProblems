class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        char pi[] = p.toCharArray();
        char si[] = s.toCharArray();
        int hash[] = new int[26]; // for baap
        int curr[] = new int[26]; // my winodw array

        List<Integer> ans = new LinkedList<>();

        int tail = 0, anss = 0, sum = 0, head/*makeing it global */;

        for (int i = 0; i < pi.length; i++) {
            hash[pi[i] - 'a']++;
        }

        for (head = 0; head < si.length; head++) {
            if (Arrays.equals(hash, curr)) ans.add(tail);
 
            while (head - tail + 1 > p.length()) {
                curr[si[tail] - 'a']--;
                tail++;
            }
            curr[si[head] - 'a']++;
        }
        if (Arrays.equals(hash, curr)) ans.add(tail);
        // return head-tail+1;
        return ans;
    }
}
