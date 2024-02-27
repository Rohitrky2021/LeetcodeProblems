class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 1;
        HashSet<String> map = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                

                for (int j = 0; j < curr.length(); j++) {
                    char[] w = curr.toCharArray();
                   for (char c = 'a'; c <= 'z'; c++) {
                        w[j] = c;
                        String newWord = String.valueOf(w);

                        if (map.contains(newWord)) {
                            if (newWord.equals(endWord)) return step + 1;
                            q.add(newWord);
                            map.remove(newWord);
                        }
                    }
                }

            }
            step++;

        }

        return 0;

    }
}