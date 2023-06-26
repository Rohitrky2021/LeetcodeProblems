class Solution {
    private static class Trie {
        TrieNode root = new TrieNode();

        public void add(String str) {
            TrieNode cur = root;
            for(int i = 0; i < str.length(); ++ i) {
                int index = str.charAt(i) - 'a';
                if(cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isLeaf = true;
        }

        private TrieNode search(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); ++ i) {
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null) {
                    return null;
                }
                cur = cur.children[index]; 
            }
            return cur;
        }

        public boolean startWith(String word) {
            TrieNode node = search(word);
            return node != null;
        }

        public boolean hasWord(String word) {
            TrieNode node = search(word);
            return node == null ? false : node.isLeaf;
        }
    }

    private static class TrieNode {
        private boolean isLeaf = false;
        private TrieNode[] children = new TrieNode[26];
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        Trie dict = new Trie();
        for(String word : wordDict) {
            dict.add(word);
        }
        return wordBreak(s, dict, 0, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, Trie wordDict, int start, Boolean[] memo)
    {
        if(start == s.length()) {
            return true;
        }
        if(null != memo[start]) {
            return memo[start];
        }
        for(int end = start + 1; end <= s.length(); ++ end) {
            String word = s.substring(start, end);
            if(!wordDict.startWith(word)) {
                break;
            }
            if(wordDict.hasWord(word) && wordBreak(s, wordDict, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}