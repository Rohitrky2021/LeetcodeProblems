class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int res[] = new int[queries.length];
        int count[] = new int[words.length];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int cnt = 0;
        for(int i = 0;i<words.length;i++){
            if(vowels.contains(words[i].charAt(0)) &&  vowels.contains(words[i].charAt(words[i].length()-1))){
                cnt++;
            }
            count[i] = cnt;
        }
        int i = 0;
        for(int[]q : queries){
            res[i++] = q[0] == 0 ? count[q[1]]: count[q[1]] - count[q[0]-1];
        }
        return res;
    }
}