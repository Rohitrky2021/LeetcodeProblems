class Solution1 {
    
     HashMap<String,Integer> map=new HashMap<>();
     Set<String> ans=new HashSet<>();
    int max=-1;
    
    public List<String> findWords(char[][] board, String[] words) {
       
        for(int i=0;i<words.length;i++){
            map.put(words[i],1);
            max=Math.max(max,words[i].length());
        }
        
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                boolean[][] visited=new boolean[board.length][board[i].length];
                check(i,j,"",board,visited);
            }
        }
        return new ArrayList<>(ans);
    }
        
        
        
        public void check(int i,int j,String str,char[][] board,boolean[][] visited){
            if(i<0 || j<0 || i>=board.length || j>=board[i].length || visited[i][j]==true || str.length()>=max) return;
             
            visited[i][j]=true;   
            str+=board[i][j];
            //System.out.println(str);
            
            if(map.containsKey(str)){
                ans.add(str);
                // System.out.println(str); 
            }
            
            check(i-1,j,str,board,visited);
            check(i+1,j,str,board,visited);
            check(i,j-1,str,board,visited);
            check(i,j+1,str,board,visited);
            
            str=str.substring(0, str.length() - 1);
            
            visited[i][j]=false;
        }
    }

class Solution {
    private TrieNode root = new TrieNode();
    private int m = 0;
    private int n = 0;
    private Set<String> set = new HashSet<>();
    private int[] dir = new int[] {1, 0, -1, 0, 1};
    
    public List<String> findWords(char[][] board, String[] words) {
        for (String w : words) {
            insert(w);
        }
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bt(i, j, board, new boolean[m][n], root);
            }
        }
        
        return new ArrayList<String>(set);
    }
    
    private void bt(int x, int y, char[][] board, boolean[][] visited, TrieNode node) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
            return;
        }
        
        int idx = board[x][y] - 'a';
        if (node.children[idx] == null) {
            return;
        }
        
        if (node.children[idx].w != null) {
            set.add(node.children[idx].w); // Notice: do not return. cause there may have a longer word!
        }
        
        visited[x][y] = true;
        
        for (int i = 0; i < dir.length-1; i++) {
            bt(x+dir[i], y + dir[i+1], board, visited, node.children[idx]);
        }
        
        visited[x][y] = false;
    }
    
    private void insert(String w) {
        TrieNode node = root;
        for (char ch : w.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        
        node.w = w;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String w;
}    